package at.fhv.serviceTasks;

import java.util.UUID;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fhv.models.Student;
import at.fhv.persistence.StudentRepository;

@Service
public class CheckNotHandedInAssingments implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void execute(DelegateExecution arg0) throws Exception {
        Student newStudent = new Student(UUID.randomUUID().toString());
        studentRepository.save(newStudent);
        LOGGER.info("student " + newStudent.getName() + " created");
    }
    
}
