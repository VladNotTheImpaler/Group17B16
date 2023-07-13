package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //FailedRunnerclass isfailed.txt file, uses the step definitions in the steps package, and generates a simple output using the "pretty" plugin.
        // Its purpose is to retest and validate previously failed scenarios.
        features = "@target/failed.txt",
        glue = "steps",
        plugin = {"pretty"}
)
public class FailedRunner {
}