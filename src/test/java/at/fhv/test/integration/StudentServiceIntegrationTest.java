package at.fhv.test.integration;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;

import at.fhv.domain.models.Student;
import at.fhv.domain.persistence.IAssignmentRepository;
import at.fhv.domain.persistence.IStudentRepository;
import at.fhv.service.IStudentService;

@DirtiesContext
@SpringBootTest(
    properties = {
        "camunda.bpm.generate-unique-process-engine-name=true",
        "camunda.bpm.generate-unique-process-application-name=true",
        "spring.datasource.generate-unique-name=true",
      }
)
public class StudentServiceIntegrationTest {
    
    @Autowired
    private IStudentService _studentService;

    @MockBean
    private IStudentRepository _studentRepository;

    @MockBean
    private IAssignmentRepository _assignmentRepository;

    @Test
    public void test_createStudent() {
        //given
        String studentName = "Felix Lahnsteiner";
        ArgumentCaptor<Student> captor = ArgumentCaptor.forClass(Student.class);

        //when
        Student created = _studentService.createStudent(studentName);

        //then
        verify(_studentRepository, times(1)).add(captor.capture());

        Student persisted = captor.getValue();

        assertEquals(studentName, persisted.getName());
    }
}
