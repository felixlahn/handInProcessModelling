package at.fhv.persistence;

import org.springframework.data.repository.CrudRepository;

import at.fhv.models.Assignment;

public interface AssignmentRepository extends CrudRepository<Assignment, Integer> {
    
}
