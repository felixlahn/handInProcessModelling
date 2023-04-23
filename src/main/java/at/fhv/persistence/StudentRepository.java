package at.fhv.persistence;

import at.fhv.domain.models.Student;
import at.fhv.domain.persistence.IStudentRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class StudentRepository implements IStudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Student student) {
        entityManager.persist(student);
    }
    
}
