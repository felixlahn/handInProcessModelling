package at.fhv.serviceTasks;

import java.io.File;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fhv.domain.models.Assignment;
import at.fhv.domain.models.Student;
import at.fhv.domain.persistence.IAssignmentRepository;
import at.fhv.domain.persistence.IStudentRepository;

@Service
public class PersistSubmission implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("PersistSubmission");


    @Autowired
    IStudentRepository _studentRepository;

    @Autowired
    IAssignmentRepository _assignmentRepository;

    @Override
    @Transactional
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("studentName: " + execution.getVariable("studentName").toString());
        LOGGER.info("submissionName: " + execution.getVariable("submissionName").toString());

        Student student = _studentRepository.get(execution.getVariable("studentName").toString());
        Assignment assignment = _assignmentRepository.get(execution.getVariable("submissionName").toString());

        if(student == null) {
            LOGGER.warning("student was null");
        }
        if(assignment == null) {
            LOGGER.warning("assignment was null");
        }

        File submission = new File(execution.getVariable("filePath").toString());
        student.hasHandedIn(assignment, submission);

        // _studentRepository.merge(student);
    }
    
}
