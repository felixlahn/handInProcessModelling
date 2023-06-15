package at.fhv.service.impl;

import java.io.File;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fhv.domain.models.Assignment;
import at.fhv.domain.models.Student;
import at.fhv.domain.persistence.IAssignmentRepository;
import at.fhv.domain.persistence.IStudentRepository;

@Service
public class AvailabilityService {
    private final static Logger LOGGER = Logger.getLogger("CheckAvailabilityTask");

    private final IStudentRepository studentRepository;
    private final IAssignmentRepository assignmentRepository;

    @Autowired
    public AvailabilityService(IStudentRepository studentRepository, IAssignmentRepository assignmentRepository) {
        this.studentRepository = studentRepository;
        this.assignmentRepository = assignmentRepository;
    }

    @Transactional
    public void checkAvailability(String studentName, String submissionName, String filePath) {
        LOGGER.info("CheckAvailabilityTask");

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

         // Set output variables or perform other actions
    }
}
