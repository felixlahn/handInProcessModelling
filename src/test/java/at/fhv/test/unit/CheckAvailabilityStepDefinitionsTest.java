package at.fhv.test.unit;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import at.fhv.domain.models.Assignment;
import at.fhv.domain.models.Grade;
import at.fhv.domain.models.Student;

@DirtiesContext
@SpringBootTest
public class CheckAvailabilityStepDefinitionsTest {

    private Assignment assignment;
    private Student student;
    private Grade grading;

    @Before
    public void setup() {
        assignment = new Assignment("Testassignment", Date.valueOf(LocalDate.now().plusDays(10)));
        student = new Student("Melek Öztürk");
        student.assignAssingment(assignment);
    }

    @Test
    public void testGradingProcess() {
        grading = new Grade(student.getName(), 80);

        String expectedStudentName = student.getName();
        String expectedNote = "Good";

        Assert.assertEquals(expectedStudentName, grading.getStudentName());
        Assert.assertEquals(expectedNote, grading.getNote());
    }
}
