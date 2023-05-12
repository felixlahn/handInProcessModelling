package at.fhv.serviceTasks;

import java.sql.Date;
import java.time.LocalDate;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fhv.domain.models.Assignment;
import at.fhv.domain.persistence.IAssignmentRepository;

@Service
public class TodayBeforeSubmissiondate implements JavaDelegate {

    @Autowired
    private IAssignmentRepository _assignmentRepository;

    private final static Logger LOGGER = Logger.getLogger("CompareTwoDates");

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        Assignment assignment = _assignmentRepository.get(execution.getVariable("submissionName").toString());
        execution.setVariable("submissionToLate", false);

        if(assignment.dueUntil().before(Date.valueOf(LocalDate.now()))) {
            execution.setVariable("submissionToLate", true);
        }

        LOGGER.info("TodayBeforeSubmissiondate:");
        LOGGER.info("submissionName: " + execution.getVariable("submissionName"));
        LOGGER.info("submissionToLate: " + execution.getVariable("submissionToLate"));
    }
    
}
