package at.fhv.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;

import at.fhv.domain.models.Assignment;
import at.fhv.domain.models.Student;

public class CheckNotHandedInAssignmnentsTest {

    private final static Logger LOGGER = Logger.getLogger("CheckNotHandedInAssingmnetsTest");

    @Test
    public void Test_calculate_Duration_for_notYetHandedIntAssingments_within_three_days() {
        //setup
        Student felix = new Student("Felix");
        LocalDate date = LocalDate.of(2023, 5, 13);
        Assignment assignment = new Assignment("camunda model", Date.valueOf(date));
        felix.assignAssingment(assignment);
        
        //act
        List<Assignment> result = felix.notYetHandedIntAssingments(Date.valueOf(LocalDate.of(2023, 1, 11)), 3);
        LOGGER.info(result.toString());

        //assert
        assertEquals("notYetHandedIntAssingments has not returned expected amount of elements", 1, result.size());
        assertTrue("notYetHandedIntAssingments has not returned expected elements", result.contains(assignment));
    }
}
