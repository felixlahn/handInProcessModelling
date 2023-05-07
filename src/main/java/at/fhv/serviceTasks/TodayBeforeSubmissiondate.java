package at.fhv.serviceTasks;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class TodayBeforeSubmissiondate implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("CompareTwoDates");

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("TodayBeforeSubmissiondate:");
        LOGGER.info("submissionName: " + execution.getVariable("submissionName"));
        execution.setVariable("submissionToLate", false);
        LOGGER.info("submissionToLate: " + execution.getVariable("submissionToLate"));
    }
    
}
