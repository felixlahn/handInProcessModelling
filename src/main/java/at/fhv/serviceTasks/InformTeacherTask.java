package at.fhv.serviceTasks;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class InformTeacherTask implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("InformTeacherTask");

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("InformTeacherTask:");
    }
     
}
