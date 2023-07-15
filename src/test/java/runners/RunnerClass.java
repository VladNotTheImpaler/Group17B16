package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //The runner class configures and runs Cucumber tests, specifying the location of feature files, step definitions package, and other settings.
        // It executes the tests and generates reports in different formats.
        features = "src/test/resources/features/",
        glue = "steps",
        dryRun = true,
        tags="@test",
        monochrome = true,
        plugin={"pretty","html:target/cucumber.html","json:target/cucumber.json",
                "rerun:target/failed.txt"}
)
public class RunnerClass {

}