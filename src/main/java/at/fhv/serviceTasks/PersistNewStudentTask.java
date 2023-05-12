package at.fhv.serviceTasks;

import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fhv.domain.models.Student;
import at.fhv.domain.persistence.IStudentRepository;

@Service
public class PersistNewStudentTask implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("PersistNewStudentTask");

    @Autowired
    private IStudentRepository _studentRepository;

    @Override
    @Transactional
    public void execute(DelegateExecution execution) throws Exception {
        _studentRepository.add(new Student(execution.getVariable("studentName").toString()));
        LOGGER.info("Added Student with Name " + execution.getVariable("studentName").toString());
    }
    
}
