package at.fhv.serviceTasks;

import java.sql.Date;
import java.time.LocalDate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fhv.domain.models.Assignment;
import at.fhv.domain.models.Student;
import at.fhv.domain.persistence.IAssignmentRepository;
import at.fhv.domain.persistence.IStudentRepository;

@Service
public class PersistNewAssignmentTask implements JavaDelegate {

    @Autowired
    private IAssignmentRepository _assignmentRepository;

    @Autowired
    private IStudentRepository _studentRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String assignmentAssignedToStudent = execution.getVariable("assignmentAssignedToStudent").toString();
        String assingmentName = execution.getVariable("assingmentName").toString();
        String assignmentDueYear = execution.getVariable("assignmentDueYear").toString();
        String assignmentDueMonth = execution.getVariable("assignmentDueMonth").toString();
        String assignmentDueDay = execution.getVariable("assignmentDueDay").toString();
        
        Student student;
        if(_studentRepository.get(assignmentAssignedToStudent) == null) return;
        student = _studentRepository.get(assignmentAssignedToStudent);

        System.out.println(assignmentDueYear);
        System.out.println(assignmentDueMonth);
        System.out.println(assignmentDueDay);
        
        Assignment assignment = new Assignment(assingmentName, Date.valueOf(LocalDate.of(
            Integer.parseInt(assignmentDueYear),
            Integer.parseInt(assignmentDueMonth),
            Integer.parseInt(assignmentDueDay))));
            
        student.assignAssingment(assignment);
        
        _assignmentRepository.add(assignment);
        
        System.out.println(student);
    }
    
}
