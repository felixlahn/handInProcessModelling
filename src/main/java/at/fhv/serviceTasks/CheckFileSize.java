package at.fhv.serviceTasks;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CheckFileSize implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("CheckFileSize");

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        execution.setVariable("fileSize", 2000);
        LOGGER.info("checkfilesize:");
        LOGGER.info("submissionName: " + execution.getVariable("submissionName"));
        LOGGER.info("filePath: " + execution.getVariable("filePath"));
        LOGGER.info("fileSize: " + execution.getVariable("fileSize"));
    }
    
}
