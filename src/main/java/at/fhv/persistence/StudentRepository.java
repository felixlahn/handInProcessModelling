package at.fhv.persistence;

import at.fhv.domain.models.Student;
import at.fhv.domain.persistence.IStudentRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class StudentRepository implements IStudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Student student) {
        entityManager.persist(student);
    }
 
    @Override
    public List<Student> getAll() {
        return entityManager.createQuery("SELECT a FROM Student a", Student.class).getResultList(); 
    }

    @Override
    public Student get(String name) {
        TypedQuery<Student> query = entityManager.createQuery("from Student as s where s.name = :name", Student.class);
        query.setParameter("name", name);

        List<Student> result = query.getResultList();
        if (1 != result.size()) {
            return null;
        }

        return result.get(0);
    }
}
