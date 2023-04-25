package at.fhv.domain.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Assignment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    private String assignmentName;

    private Date dueUnitl;

    public Assignment(Date dueUnit) {
        this.dueUnitl = dueUnit;
    }

    public Date dueUntil() {
        return this.dueUnitl;
    }

    public int getId() {
        return this.id;
    }

    public String getAssignemtName() {
        return this.assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }


}
