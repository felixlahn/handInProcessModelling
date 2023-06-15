package at.fhv.serviceTasks;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fhv.service.IStudentService;

@Service
public class NotifyStudent implements JavaDelegate {

    @Autowired
    private IStudentService _studentService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        String studentName = execution.getVariable("studentToBeNotified").toString();
        String assignmentName = execution.getVariable("assignmentToBeNotifiedAbout").toString();

        _studentService.notifyAboutLateSubmission(studentName, assignmentName, "Submission needs to be done in a few days!");
    }
    
}
