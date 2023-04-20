package at.fhv.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StudentAssignment {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Assignment assignment;
    private boolean handedIn;
    private Grade grade;

    public StudentAssignment(Assignment assignment) {
        this.assignment = assignment;
        handedIn = false;
        grade = Grade.NOT_GRADED_YET;
    }

    public Grade getGrade() {
        return this.grade;
    }

    public Assignment getAssignment() {
        return this.assignment;
    }

    public boolean isHandedIn() {
        return this.handedIn;
    }

    public void hasBeenHandedIn() {
        this.handedIn = true;
    }

    public void excellent() {
        this.grade = Grade.EXCELLENT;
    }

    public void good() {
        this.grade = Grade.GOOD;
    }

    public void satisfactory() {
        this.grade = Grade.SATISFACTORY;
    }

    public void sufficient() {
        this.grade = Grade.SUFFICIENT;
    }

    public void unsatisfactory() {
        this.grade = Grade.UNSATISFACTORY;
    }
}
