package at.fhv.test.integration;

import at.fhv.domain.models.Grade;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GradeIntegrationTest {

    @Test
    public void testCalculateNote_Excellent() {
        // Arrange
        double points = 95.0;
        String expectedNote = "Excellent";

        // Act
        Grade grade = new Grade("John Doe", points);
        String actualNote = grade.getNote();

        // Assert
        assertEquals(expectedNote, actualNote);
    }

    @Test
    public void testCalculateNote_Good() {
        // Arrange
        double points = 80.0;
        String expectedNote = "Good";

        // Act
        Grade grade = new Grade("Jane Smith", points);
        String actualNote = grade.getNote();

        // Assert
        assertEquals(expectedNote, actualNote);
    }

}
