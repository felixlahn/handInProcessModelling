package at.fhv.domain.models;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class StudentAssignment {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Assignment assignment;
    private boolean handedIn;
    private boolean lateSubmissionHasBeenNotified;
    private Grade grade;

    @Lob
    private File submission;

    private StudentAssignment() { }

    public StudentAssignment(Assignment assignment) {
        this.assignment = assignment;
        handedIn = false;
        grade = Grade.NOT_GRADED_YET;
        lateSubmissionHasBeenNotified = false;
    }

    public File getSubmission() {
        return this.submission;
    }

    public void setSubmission(File submission) {
        this.submission = submission;
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

    public void hasBeenHandedIn(File submission) {
        this.handedIn = true;
        this.submission = submission;
        System.out.println("handed in");
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

    public void notifyAboutLateSubmission() {
        lateSubmissionHasBeenNotified = true;
    }

    public boolean lateSubmissionHasBeenNotified() {
        return lateSubmissionHasBeenNotified;
    }
}
