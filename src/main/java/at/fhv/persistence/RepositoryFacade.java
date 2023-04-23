package at.fhv.persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import at.fhv.domain.persistence.IAssignmentRepository;
import at.fhv.domain.persistence.IStudentRepository;

@Component
public class RepositoryFacade {
    
    @Bean
    public IAssignmentRepository assignmentRepository() {
        return new AssignmentRepository();
    }

    @Bean
    public IStudentRepository studentRepository() {
        return new StudentRepository();
    }
}
