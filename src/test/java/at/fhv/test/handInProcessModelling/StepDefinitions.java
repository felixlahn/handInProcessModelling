package at.fhv.test.handInProcessModelling;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fhv.domain.persistence.IAssignmentRepository;
import at.fhv.domain.persistence.IStudentRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

class IsItFriday {
    static String isItFriday(String today) {
        return "Nope";
    }
}

@Service
public class StepDefinitions {
    private String today;
    private String actualAnswer;

    @Autowired
    IStudentRepository _studentRepository;

    @Autowired
    IAssignmentRepository _assignmentRepository;

    @Given("today is Sunday")
    public void today_is_Sunday() {
        today = "Sunday";
    }

    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_Friday_yet() {
        actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    ////////////

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