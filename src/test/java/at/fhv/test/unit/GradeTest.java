package at.fhv.test.unit;

import at.fhv.domain.models.Grade;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.assertEquals;

@SpringBootTest(properties = {
        "camunda.bpm.generate-unique-process-engine-name=true",
        "camunda.bpm.generate-unique-process-application-name=true",
        "spring.datasource.generate-unique-name=true",
})
@DirtiesContext
public class GradeTest {

    @Test
    public void testCalculateNote() {
        // Test with different points values
        Grade grade1 = new Grade("John Doe", 95.0);
        assertEquals("Excellent", grade1.getNote());

        Grade grade2 = new Grade("Jane Smith", 80.0);
        assertEquals("Good", grade2.getNote());

        Grade grade3 = new Grade("Alice Johnson", 70.0);
        assertEquals("Satisfactory", grade3.getNote());

        Grade grade4 = new Grade("Bob Brown", 55.0);
        assertEquals("Sufficient", grade4.getNote());

        Grade grade5 = new Grade("Charlie Davis", 40.0);
        assertEquals("Unsatisfactory", grade5.getNote());

        // Test with points outside the defined range
        Grade grade6 = new Grade("Eva Wilson", 120.0);
        assertEquals("Unsatisfactory", grade6.getNote());

        Grade grade7 = new Grade("Frank Miller", -10.0);
        assertEquals("Unsatisfactory", grade7.getNote());
    }
}