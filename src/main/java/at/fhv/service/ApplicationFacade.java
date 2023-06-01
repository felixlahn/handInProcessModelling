package at.fhv.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import at.fhv.service.impl.AssignmentService;
import at.fhv.service.impl.StudentService;

@Component
public class ApplicationFacade {
    
    @Bean
    public IAssignmentService assignmentService() {
        return new AssignmentService();
    }

    @Bean
    public IStudentService studentService() {
        return new StudentService();
    }
}
