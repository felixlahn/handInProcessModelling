package at.fhv.test.unit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import at.fhv.domain.models.Assignment;
import at.fhv.domain.persistence.IAssignmentRepository;
import at.fhv.service.IAssignmentService;

@SpringBootTest(
    properties = {
        "camunda.bpm.generate-unique-process-engine-name=true",
        "camunda.bpm.generate-unique-process-application-name=true",
        "spring.datasource.generate-unique-name=true",
      }
)
public class AssignmentServiceTests {

    @Autowired
    private IAssignmentService _assignmentService;
    
    @MockBean
    private IAssignmentRepository _assignmentRepository;

    @Test
    public void Test_is_expired_true() {
        //given
        LocalDate dueDate = LocalDate.of(2022, 7, 23);
        Assignment assignment = new Assignment("Testassignment", Date.valueOf(dueDate));

        Mockito.when(_assignmentRepository.get(assignment.getAssignemtName())).thenReturn(assignment);

        //when .. then
        assertTrue(_assignmentService.isExpired(assignment.getAssignemtName()));
    }

    @Test
    public void test_is_expired_false() {
        //given
        LocalDate dueDate = LocalDate.of(2035, 7, 23);
        Assignment assignment = new Assignment("Testassignment", Date.valueOf(dueDate));

        Mockito.when(_assignmentRepository.get(assignment.getAssignemtName())).thenReturn(assignment);

        //when .. then
        assertFalse(_assignmentService.isExpired(assignment.getAssignemtName()));
    }

    @Test
    public void testtest() {
        assertTrue(false);
    }
}
