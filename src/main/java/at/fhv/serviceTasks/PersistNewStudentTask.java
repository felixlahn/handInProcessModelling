package at.fhv.serviceTasks;

import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fhv.service.IStudentService;

@Service
public class PersistNewStudentTask implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("PersistNewStudentTask");

    @Autowired
    private IStudentService _studentService;

    @Override
    @Transactional
    public void execute(DelegateExecution execution) throws Exception {
        _studentService.createStudent(execution.getVariable("studentName").toString());
        LOGGER.info("Added Student with Name " + execution.getVariable("studentName").toString());
    }
    
}
