package at.fhv.serviceTasks;

import java.io.File;
import java.util.logging.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import at.fhv.service.IAssignmentService;

@Service
public class PersistSubmission implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("PersistSubmission");


    @Autowired
    IAssignmentService _assignmentService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("studentName: " + execution.getVariable("studentName").toString());
        LOGGER.info("submissionName: " + execution.getVariable("submissionName").toString());

        String studentName = execution.getVariable("studentName").toString();
        String assignmentName = execution.getVariable("submissionName").toString();
        
        File submission = new File(execution.getVariable("filePath").toString());

        _assignmentService.handAssignmentIn(studentName, _assignmentService.getAssingment(assignmentName), submission);
    }
    
}
