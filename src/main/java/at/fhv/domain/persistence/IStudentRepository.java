package at.fhv.domain.persistence;

import java.util.List;

import at.fhv.domain.models.Student;

public interface IStudentRepository {
    void add(Student student);
    List<Student> getAll();
}
