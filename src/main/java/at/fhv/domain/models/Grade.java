package at.fhv.domain.models;

import jakarta.persistence.Entity;

@Entity
public class Grade {
    public static final Grade EXCELLENT = new Grade("Excellent", 100.0);
    public static final Grade GOOD = new Grade("Good", 87.5);
    public static final Grade SUFFICIENT = new Grade("Sufficient", 75.0);
    public static final Grade UNSATISFACTORY = new Grade("Unsatisfactory", 0.0);
    public static final Grade NOT_GRADED_YET = new Grade("Not Graded Yet", -1.0);
    public static final Grade SATISFACTORY = new Grade("Satisfactory", 62.5);

    private String studentName;
    private double points;
    private String note;

    public Grade(String studentName, double points) {
        this.studentName = studentName;
        this.points = points;
        this.note = calculateNote();
    }

    private String calculateNote() {
        if (points >= 87.5 && points <= 100) {
            return "Excellent";
        } else if (points > 75 && points <= 87.5) {
            return "Good";
        } else if (points > 62.5 && points <= 75) {
            return "Satisfactory";
        } else if (points >= 50 && points < 62.5) {
            return "Sufficient";
        } else {
            return "Unsatisfactory";
        }
    }

    // Getters for the fields
    public String getStudentName() {
        return studentName;
    }

    public String getNote() {
        return note;
    }

    public double getPoints() {
        return points;
    }
}
