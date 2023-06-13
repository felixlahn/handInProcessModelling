package at.fhv.test.unit;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import at.fhv.domain.models.Assignment;
import at.fhv.domain.models.Student;
import at.fhv.domain.persistence.IAssignmentRepository;
import at.fhv.domain.persistence.IStudentRepository;
import at.fhv.serviceTasks.CheckAvailability;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CheckAvailabilityTest {

    @Mock
    private IStudentRepository studentRepository;

    @Mock
    private IAssignmentRepository assignmentRepository;

    @InjectMocks
    private CheckAvailability checkAvailability;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testExecute() throws Exception {
        // Mock input variables
        String studentName = "Melek Öztürk";
        String submissionName = "Testassignment";
        String filePath = "path/to/submission";

        // Creating mock objects
        Student student = mock(Student.class);
        Assignment assignment = mock(Assignment.class);

        // Configuring mock objects
        when(studentRepository.get(studentName)).thenReturn(student);
        when(assignmentRepository.get(submissionName)).thenReturn(assignment);
        when(student.getAssignments()).thenReturn(new ArrayList<>());

        // Creating a mock DelegateExecution
        DelegateExecution execution = mock(DelegateExecution.class);
        when(execution.getVariable("studentName")).thenReturn(studentName);
        when(execution.getVariable("submissionName")).thenReturn(submissionName);
        when(execution.getVariable("filePath")).thenReturn(filePath);

        // Execute the task
        checkAvailability.execute(execution);

    }
}
