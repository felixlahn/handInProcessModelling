package at.fhv.models;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany
    private List<StudentAssignment> assignments;

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
}
