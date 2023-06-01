package at.fhv.service;

import java.util.Optional;

import org.camunda.bpm.engine.impl.util.ImmutablePair;

import at.fhv.domain.models.Assignment;
import at.fhv.domain.models.Student;

public interface IStudentService {
    Student createStudent(String studentName);
    Student getStudent(String studentName);
    void assignAssignment(String studentName, Assignment assignment);
    void notifyAboutLateSubmission(String studentName, String assignmentName, String message);
    Optional<ImmutablePair<Student, Assignment>> getNextStudentWithNotYetSubmittedAssignment(int assignmentDueUntil);
}
