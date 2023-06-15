package at.fhv.serviceTasks;

import java.sql.Date;
import java.time.LocalDate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fhv.domain.models.Assignment;
import at.fhv.domain.models.Student;
import at.fhv.service.IAssignmentService;
import at.fhv.service.IStudentService;

@Service
public class PersistNewAssignmentTask implements JavaDelegate {

    @Autowired
    private IAssignmentService _assignmentService;

    @Autowired
    private IStudentService _studentService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String assignmentAssignedToStudent = execution.getVariable("assignmentAssignedToStudent").toString();
        String assingmentName = execution.getVariable("assingmentName").toString();
        String assignmentDueYear = execution.getVariable("assignmentDueYear").toString();
        String assignmentDueMonth = execution.getVariable("assignmentDueMonth").toString();
        String assignmentDueDay = execution.getVariable("assignmentDueDay").toString();
        
        Student student = _studentService.getStudent(assignmentAssignedToStudent);

        Assignment assignment = _assignmentService.createAssignment(
            assingmentName,
            Date.valueOf(LocalDate.of(
            Integer.parseInt(assignmentDueYear),
            Integer.parseInt(assignmentDueMonth),
            Integer.parseInt(assignmentDueDay))));
            
        _studentService.assignAssignment(student.getName(), assignment);
    }
    
}
