package at.fhv.test.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import at.fhv.domain.models.Assignment;
import at.fhv.domain.models.Student;

@SpringBootTest
// @RunWith(SpringRunner.class)
public class CheckNotHandedInAssignmnentsTest {

    @Test
    public void Test_get_assignment_within_three_days() {
        //setup
        Student felix = new Student("Felix");
        LocalDate date = LocalDate.of(2023, 5, 31);
        Assignment assignment = new Assignment("camunda model", Date.valueOf(date));
        felix.assignAssingment(assignment);
        
        //act
        List<Assignment> result = felix.notYetHandedIntAssingments(Date.valueOf(LocalDate.of(2023, 5, 30)), 3);

        //assert
        assertEquals("notYetHandedIntAssingments has not returned expected amount of elements", 1, result.size());
        assertTrue("notYetHandedIntAssingments has not returned expected elements", result.contains(assignment));
    }

    @Test
    public void Test_get_no_assignment_when_is_not_urgent() {
        //setup
        Student felix = new Student("Felix");
        LocalDate date = LocalDate.of(2023, 7, 20);
        Assignment assignment = new Assignment("camunda model", Date.valueOf(date));
        felix.assignAssingment(assignment);
        
        //act
        List<Assignment> result = felix.notYetHandedIntAssingments(Date.valueOf(LocalDate.of(2023, 5, 30)), 3);

        //assert
        assertEquals("notYetHandedIntAssingments has not returned expected amount of elements", 0, result.size());
        assertTrue("notYetHandedIntAssingments has not returned expected elements", !result.contains(assignment));
    }
}
