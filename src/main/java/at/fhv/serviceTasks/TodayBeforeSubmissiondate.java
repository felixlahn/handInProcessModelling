package at.fhv.serviceTasks;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fhv.service.IAssignmentService;

@Service
public class TodayBeforeSubmissiondate implements JavaDelegate {

    @Autowired
    private IAssignmentService _assignmentService;

    private final static Logger LOGGER = Logger.getLogger("CompareTwoDates");

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        execution.setVariable("submissionToLate", false);

        if(_assignmentService.isExpired(execution.getVariable("submissionName").toString())) {
            execution.setVariable("submissionToLate", true);
        }

        LOGGER.info("TodayBeforeSubmissiondate:");
        LOGGER.info("submissionName: " + execution.getVariable("submissionName"));
        LOGGER.info("submissionToLate: " + execution.getVariable("submissionToLate"));
    }
    
}
