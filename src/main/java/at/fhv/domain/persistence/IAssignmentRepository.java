package at.fhv.domain.persistence;

import at.fhv.domain.models.Assignment;

public interface IAssignmentRepository {
    void add(Assignment assignment);
    Assignment get(String assignmentName);
}
