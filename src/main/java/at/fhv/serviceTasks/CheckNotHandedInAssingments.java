package at.fhv.serviceTasks;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fhv.domain.models.Assignment;
import at.fhv.domain.models.Student;
import at.fhv.domain.models.StudentAssignment;
import at.fhv.domain.persistence.IAssignmentRepository;
import at.fhv.domain.persistence.IStudentRepository;

@Service
public class CheckNotHandedInAssingments implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("CheckNotHandedInAssingmnets");

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private IAssignmentRepository assignmentRepository;

    @Override
    @Transactional
    public void execute(DelegateExecution arg0) throws Exception {
        LOGGER.info("checknothandedinassignment");

        List<Student> allStudents = studentRepository.getAll();
        for(Student student : allStudents) {
            for(Assignment assignment2 : student.notYetHandedIntAssingments(Date.valueOf(LocalDate.now()), 3)) {
                LOGGER.info(student.getName() + " " + assignment2.getAssignemtName());
            }

            List<StudentAssignment> assignments = student.getAssignments();

        }


    }
    
}
