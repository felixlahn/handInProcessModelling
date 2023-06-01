package at.fhv.service;

import java.io.File;
import java.sql.Date;

import at.fhv.domain.models.Assignment;

public interface IAssignmentService {
    Assignment createAssignment(String assignmentName, Date dueDate);
    void handAssignmentIn(String studentName, Assignment assignment, File file);
    Assignment getAssingment(String assignmentName);
    boolean isExpired(String assignmentName);
}
