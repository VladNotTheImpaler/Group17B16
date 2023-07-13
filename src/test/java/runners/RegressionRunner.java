package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //RegressionRunnerclass@regression are executed.
        features = "src/test/resources/features/",
        glue = "steps",
        dryRun = false,
        tags="@regression",
        monochrome = true,
        plugin={"pretty","html:target/cucumber.html","json:target/cucumber.json"}
)
public class RegressionRunner {
}
