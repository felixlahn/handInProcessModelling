package at.fhv.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import at.fhv.domain.models.Assignment;
import at.fhv.domain.models.Student;
import at.fhv.domain.persistence.IAssignmentRepository;
import at.fhv.domain.persistence.IStudentRepository;

@Component
public class OnStartup {

    @Autowired
    private IAssignmentRepository assignmentRepository;

    @Autowired
    private IStudentRepository studentRepository;
    
    private final static Logger LOGGER = Logger.getLogger("OnStartup");

    @PostConstruct
    @Transactional
    public void init() {
        LOGGER.info("init PostConstruct");

        // Student felix = new Student("Felix");
        // Student melek = new Student("Melek");

        // LocalDate date = LocalDate.of(2023, 5, 12);

        // Assignment assignment = new Assignment("camunda model", Date.valueOf(date));

        // assignmentRepository.add(assignment);

        // felix.assignAssingment(assignment);
        // melek.assignAssingment(assignment);
        // melek.hasHandedIn(assignment);

        // studentRepository.add(felix);
        // studentRepository.add(melek);
    }
}
