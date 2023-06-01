package at.fhv.service.impl;

import java.io.File;
import java.sql.Date;
import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import at.fhv.domain.models.Assignment;
import at.fhv.domain.models.Student;
import at.fhv.domain.persistence.IAssignmentRepository;
import at.fhv.domain.persistence.IStudentRepository;
import at.fhv.service.IAssignmentService;

public class AssignmentService implements IAssignmentService {

    @Autowired
    IAssignmentRepository _assignmentRepository;

    @Autowired
    IStudentRepository _studentRepository;

    @Override
    @Transactional
    public Assignment createAssignment(String assignmentName, Date dueDate) {
        Assignment newAssignment = new Assignment(assignmentName, dueDate);
        _assignmentRepository.add(newAssignment);
        return newAssignment;
    }

    @Override
    @Transactional
    public void handAssignmentIn(String studentName, Assignment assignment, File file) {
        Student student = _studentRepository.get(studentName);
        student.hasHandedIn(assignment, file);
    }

    @Override
    public Assignment getAssingment(String assignmentName) {
        return _assignmentRepository.get(assignmentName);
    }

    @Override
    public boolean isExpired(String assignmentName) {
        return _assignmentRepository.get(assignmentName).dueUntil().before(Date.valueOf(LocalDate.now()));
    }
    
}
