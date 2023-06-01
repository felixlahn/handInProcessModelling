package at.fhv.serviceTasks;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.impl.util.ImmutablePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fhv.domain.models.Assignment;
import at.fhv.domain.models.Student;
import at.fhv.domain.persistence.IStudentRepository;
import at.fhv.service.IStudentService;

@Service
public class CheckNotHandedInAssingments implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("CheckNotHandedInAssingmnets");

    @Autowired
    private IStudentService _studentService;

    @Override
    @Transactional
    public void execute(DelegateExecution execution) throws Exception {

        execution.setVariable("studentsNeedToBeNotified", false);

        Optional<ImmutablePair<Student, Assignment>> overdueStudent = _studentService.getNextStudentWithNotYetSubmittedAssignment(3);

        if(overdueStudent.isPresent()) {
            execution.setVariable("studentToBeNotified", overdueStudent.get().getLeft().getName());
            execution.setVariable("assignmentToBeNotifiedAbout", overdueStudent.get().getRight().getAssignemtName());
            execution.setVariable("studentsNeedToBeNotified", true);
        }
    }
    
}
