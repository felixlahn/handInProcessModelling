package at.fhv.cucumber;

import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.*;

import org.camunda.bpm.engine.ProcessEngine;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@RunWith(SpringRunner.class)
@SpringBootTest(
    properties = {
        "camunda.bpm.generate-unique-process-engine-name=true",
        "camunda.bpm.generate-unique-process-application-name=true",
        "spring.datasource.generate-unique-name=true",
      }
)

@ContextConfiguration(classes = TestConfiguration.class)
public class HasNotHandedInYetStepDefinitions {

    @Autowired
    ProcessEngine processEngine;  

    @Before
    public void setUp() {
        init(this.processEngine);
    }

    @After
    public void tearDown() {
        System.out.println("Stopping a hand in scenario");
    }

    @Given("there is an assingment assigend to the student")
    public void there_is_an_assingment_assigend_to_the_student() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
    }

    @When("the assignments deadline is within three days")
    public void the_assignments_deadline_is_within_three_days() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
    }

    @Then("the student should get be notified")
    public void the_student_should_get_be_notified() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
    }
}