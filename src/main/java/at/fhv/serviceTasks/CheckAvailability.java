package at.fhv.serviceTasks;

import java.io.File;
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
public class CheckAvailability implements JavaDelegate {
    private final static Logger LOGGER = Logger.getLogger("CheckAvailabilityTask");

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private IAssignmentRepository assignmentRepository;

    @Override
    @Transactional
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("CheckAvailabilityTask");

        String studentName = (String) execution.getVariable("studentName");
        String submissionName = (String) execution.getVariable("submissionName");
        String filePath = (String) execution.getVariable("filePath");

        Student student = studentRepository.get(studentName);
        Assignment assignment = assignmentRepository.get(submissionName);

        if (student == null) {
            LOGGER.warning("Student was null");
        }
        if (assignment == null) {
            LOGGER.warning("Assignment was null");
        }

        File submission = new File(filePath);
        student.hasHandedIn(assignment, submission);

        List<StudentAssignment> assignments = student.getAssignments();

        // Set output variables
        execution.setVariable("assignmentList", assignments);
    }
}
