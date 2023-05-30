package at.fhv.serviceTasks;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fhv.domain.models.Assignment;
import at.fhv.domain.models.Student;
import at.fhv.domain.models.StudentAssignment;
import at.fhv.domain.persistence.IAssignmentRepository;
import at.fhv.domain.persistence.IStudentRepository;

@Service
public class NotifyStudent implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("NotifyStudent");

    @Autowired
    private IStudentRepository _studentRepository;

    @Autowired
    private IAssignmentRepository _assignmentRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        String studentName = execution.getVariable("studentToBeNotified").toString();

        Student student = _studentRepository.get(studentName);
        Assignment assignment = _assignmentRepository.get(execution.getVariable("assignmentToBeNotifiedAbout").toString());

        StudentAssignment assignmentInQuestion = null;
        for(StudentAssignment studentAssignment : student.getAssignments()) {
            if(studentAssignment.getAssignment().getAssignemtName().equals(assignment.getAssignemtName())) {
                assignmentInQuestion = studentAssignment;
            }
        }

        if(assignmentInQuestion == null || assignmentInQuestion.lateSubmissionHasBeenNotified()) return;

        LOGGER.info("NOTIFICATION: student " + student.getName() + " hasent handed in assignment " + assignmentInQuestion.getAssignment().getAssignemtName());

        assignmentInQuestion.notifyAboutLateSubmission();
    }
    
}
