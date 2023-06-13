package at.fhv.cucumber;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import at.fhv.domain.models.Assignment;
import at.fhv.domain.models.Grade;
import at.fhv.domain.models.Student;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckAvailabilityStepDefinitions {

    private Assignment assignment;
    private Student student;
    private Grade grading;

    @Given("there is an assignment assigned to the student")
    public void there_is_an_assignment_assigned_to_the_student_with_enough_time_to_deadline() {
        assignment = new Assignment("Testassignment", Date.valueOf(LocalDate.now().plusDays(10)));
        student = new Student("Max Mustermann");
        student.assignAssingment(assignment);
    }

    @When("start the grading process")
    public void start_the_grading_process() {
        grading = new Grade(student.getName(), 80);
    }

    @Then("the teacher gives the final grade")
    public void the_teacher_gives_the_final_grade() {
        String studentName = grading.getStudentName();
        String note = grading.getNote();

        System.out.println("Student: " + studentName);
        System.out.println("Grade: " + note);
    }
}