package at.fhv.domain.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<StudentAssignment> assignments;

    private Student() {}

    public Student(String name) {
        this.name = name;
        assignments = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void assignAssingment(Assignment assignment) {
        this.assignments.add(new StudentAssignment(assignment));
    }

    public void hasHandedIn(Assignment assignment) {
        for (StudentAssignment studentAssignment : assignments) {
            if(studentAssignment.getAssignment().getAssignemtName().equals(assignment.getAssignemtName())) {
                studentAssignment.hasBeenHandedIn();
                return;
            }
        }
    }

    public List<StudentAssignment> getAssignments() {
        return assignments;
    }

    public List<Assignment> notYetHandedIntAssingments(Date today, long dueUntilDays) {
        return assignments.stream()
            .filter(
                assignment -> !assignment.isHandedIn()
                && 0 < assignment.getAssignment().dueUntil().toLocalDate().compareTo(today.toLocalDate().plusDays(dueUntilDays)))
            .map(StudentAssignment::getAssignment)
            .collect(Collectors.toList());
    }
}
