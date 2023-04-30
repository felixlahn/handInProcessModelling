package at.fhv.persistence;

import at.fhv.domain.models.Assignment;
import at.fhv.domain.persistence.IAssignmentRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class AssignmentRepository implements IAssignmentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Assignment assignment) {
        entityManager.persist(assignment);
    }

    @Override
    public Assignment get(String assignmentName) {
        TypedQuery<Assignment> query = entityManager.createQuery("from Assignment as a where a.assignmentName = :assignmentName", Assignment.class);
        query.setParameter("assignmentName", assignmentName);

        List<Assignment> result = query.getResultList();
        if (1 != result.size()) {
            return null;
        }

        return result.get(0);
    }
    
}
