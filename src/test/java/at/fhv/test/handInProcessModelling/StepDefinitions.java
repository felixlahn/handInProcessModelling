package at.fhv.test.handInProcessModelling;

import java.io.File;
import java.sql.Date;
import java.time.LocalDate;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import at.fhv.Application;
import at.fhv.domain.models.Assignment;
import at.fhv.domain.models.Student;
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

@SpringBootTest
@ContextConfiguration(
        classes = Application.class,
        loader = SpringBootContextLoader.class)
public class StepDefinitions {
    private String today;
    private String actualAnswer;

    private Assignment _assignment;
    private Student _student;

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

    //////////////

    @Given("there is an assingment assigend to the student with enough time to deadline")
    public void there_is_an_assingment_assigend_to_the_student_with_enough_time_to_deadline() {
        _assignment = new Assignment("Testassignment", Date.valueOf(LocalDate.now().plusDays(10)));
        _student = new Student("Max Mustermann");
        _student.assignAssingment(_assignment);
    }
    @When("Student handed in this assignment")
    public void student_handed_in_this_assignment() {
        _student.hasHandedIn(_assignment, new File(""));
    }

    @Then("the studentassignment should be marked as handed in")
    public void the_studentassignment_should_be_marked_as_handed_in() {
        Assert.assertTrue(_student.getAssignments().get(0).isHandedIn());
    }
}