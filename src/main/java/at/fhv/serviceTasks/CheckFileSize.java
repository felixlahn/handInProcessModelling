package at.fhv.serviceTasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CheckFileSize implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("CheckFileSize");

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        File submission = new File(execution.getVariable("filePath").toString());

        if(!submission.exists()) throw new FileNotFoundException(execution.getVariable("filePath").toString());

        long fileSizeBytes = submission.length();

        if(fileSizeBytes > 1.024e+9) throw new Exception("file too large");

        execution.setVariable("fileSize", fileSizeBytes);
        
        LOGGER.info("checkfilesize:");
        LOGGER.info("submissionName: " + execution.getVariable("submissionName"));
        LOGGER.info("filePath: " + execution.getVariable("filePath"));
        LOGGER.info("fileSize: " + execution.getVariable("fileSize"));
    }
    
}
