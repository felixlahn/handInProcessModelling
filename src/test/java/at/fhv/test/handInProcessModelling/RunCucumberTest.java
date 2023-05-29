package at.fhv.test.handInProcessModelling;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, features = "src/test/resources/")
// @CucumberOptions(plugin = {"pretty"})
public class RunCucumberTest {
}