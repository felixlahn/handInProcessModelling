package at.fhv.persistence;

import at.fhv.domain.models.Assignment;
import at.fhv.domain.persistence.IAssignmentRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AssignmentRepository implements IAssignmentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Assignment assignment) {
        entityManager.persist(assignment);
    }
    
}
