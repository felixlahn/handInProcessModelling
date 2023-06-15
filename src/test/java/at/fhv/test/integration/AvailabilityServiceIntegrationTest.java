package at.fhv.test.integration;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import at.fhv.domain.models.Assignment;
import at.fhv.domain.models.Student;
import at.fhv.domain.models.StudentAssignment;
import at.fhv.domain.persistence.IAssignmentRepository;
import at.fhv.domain.persistence.IStudentRepository;
import at.fhv.service.impl.AvailabilityService;

@DirtiesContext
@SpringBootTest(properties = {
        "camunda.bpm.generate-unique-process-engine-name=true",
        "camunda.bpm.generate-unique-process-application-name=true",
        "spring.datasource.generate-unique-name=true",
})
public class AvailabilityServiceIntegrationTest {

    private final static Logger LOGGER = Logger.getLogger("CheckAvailabilityTask");

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private IAssignmentRepository assignmentRepository;

    private AvailabilityService availabilityService;

    @Before
    public void setUp() {
        availabilityService = new AvailabilityService(studentRepository, assignmentRepository);
    }

    // @Test
    @Transactional
    public void testCheckAvailability() {
        LOGGER.info("Running AvailabilityServiceIntegrationTest");

        // Create test data
        Student student = new Student("Felix Lahnsteiner");
        Assignment assignment = new Assignment("Testassignment", Date.valueOf(LocalDate.now().plusDays(7)));
        studentRepository.add(student);
        assignmentRepository.add(assignment);

        // Set up input parameters
        String studentName = student.getName();
        String submissionName = assignment.getName();
        String filePath = "path/to/file";

        // Perform the availability check
        availabilityService.checkAvailability(studentName, submissionName, filePath);

        // Retrieve the updated assignments list
        List<StudentAssignment> assignments = student.getAssignments();
        assignments.size();

        // Assertions or further verifications
        // ...
    }
}
