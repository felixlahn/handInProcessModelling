package at.fhv.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.camunda.bpm.engine.impl.util.ImmutablePair;
import org.springframework.beans.factory.annotation.Autowired;

import at.fhv.domain.models.Assignment;
import at.fhv.domain.models.Student;
import at.fhv.domain.models.StudentAssignment;
import at.fhv.domain.persistence.IAssignmentRepository;
import at.fhv.domain.persistence.IStudentRepository;
import at.fhv.service.IStudentService;

public class StudentService implements IStudentService {

    private final static Logger LOGGER = Logger.getLogger("StudentService");
    
    @Autowired
    private IStudentRepository _studentRepository;

    @Autowired
    private IAssignmentRepository _assignmentRepository;

    @Override
    @Transactional
    public Student createStudent(String studentName) {
        Student newStudent = new Student(studentName);
        _studentRepository.add(newStudent);
        return newStudent;
    }

    @Override
    public Student getStudent(String studentName) {
        return _studentRepository.get(studentName);
    }

    @Override
    @Transactional
    public void assignAssignment(String studentName, Assignment assignment) {
        Student whoHasToDoAssignment = _studentRepository.get(studentName);
        whoHasToDoAssignment.assignAssingment(assignment);
    }

    @Override
    public void notifyAboutLateSubmission(String studentName, String assignmentName, String message) {
        Student student = _studentRepository.get(studentName);
        Assignment assignment = _assignmentRepository.get(assignmentName);

        StudentAssignment assignmentInQuestion = null;
        for(StudentAssignment studentAssignment : student.getAssignments()) {
            if(studentAssignment.getAssignment().getAssignemtName().equals(assignment.getAssignemtName())) {
                assignmentInQuestion = studentAssignment;
            }
        }

        if(!assignmentInQuestion.lateSubmissionHasBeenNotified()) {
            LOGGER.info("NOTIFICATION: Student " + student.getName() + ", Assignment: " + assignmentInQuestion.getAssignment().getAssignemtName() + ", Message: " + message);
            assignmentInQuestion.notifyAboutLateSubmission();
        }
    }

    @Override
    public Optional<ImmutablePair<Student, Assignment>> getNextStudentWithNotYetSubmittedAssignment(int assignmentDueUntil) {
        List<Student> allStudents = _studentRepository.getAll();
        for(Student student : allStudents) {
            for(Assignment notYetSubmittedAssignment : student.notYetHandedIntAssingments(Date.valueOf(LocalDate.now()), assignmentDueUntil)) {
                return Optional.of(new ImmutablePair<Student, Assignment>(student, notYetSubmittedAssignment));
            }
        }
        return Optional.empty();
    }
}
