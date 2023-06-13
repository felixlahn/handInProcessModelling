package at.fhv.test.integration;

import static org.camunda.bpm.engine.test.assertions.bpmn.AbstractAssertions.init;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.*;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext
@SpringBootTest(
    properties = {
        "camunda.bpm.generate-unique-process-engine-name=true",
        "camunda.bpm.generate-unique-process-application-name=true",
        "spring.datasource.generate-unique-name=true",
      }
)
public class TestProccessesAvailable {
    
    @Autowired
    ProcessEngine processEngine;  

    @Autowired
    RuntimeService runtimeService;

    @BeforeEach
    public void setUp() {
        init(this.processEngine);
    }

    @Test
    public void test_start_createStudentProcess() {
        ProcessInstance process = this.runtimeService.startProcessInstanceByKey("createStudentProcess", 
        withVariables("studentName", "Felix Lahnsteiner"));
        assertThat(process).isNotNull();
        assertThat(process).isStarted();
    }

    @Test
    public void test_start_abgabeerinnerung() {
        ProcessInstance process = this.runtimeService.startProcessInstanceByKey("submissionReminder");
        assertThat(process).isNotNull();
        assertThat(process).isStarted();
    }

    @Test
    public void test_start_abgabe() {
        ProcessInstance process = this.runtimeService.startProcessInstanceByKey("abgabeProcess");
        assertThat(process).isNotNull();
        assertThat(process).isStarted();
    }
}
