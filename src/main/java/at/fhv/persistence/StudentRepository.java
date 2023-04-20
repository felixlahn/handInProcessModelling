package at.fhv.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import at.fhv.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    
}
