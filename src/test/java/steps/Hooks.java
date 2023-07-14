package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks extends CommonMethods {
    @Before
    public void start() {
        //browser name we should add from the openBrowserGetURL method
        // in the CommonMethods class
        openBrowserGetURL(getProperty("url"), "chrome");
    }

    @After
    //we are calling the Scenario main class in order to get the name from each scenario
    public void end(Scenario scenario) {
        byte[] pic;
        var scenarioNameAndStatus = scenario.getName() + " " + scenario.getStatus();
        if (scenario.isFailed()) {
            pic = takeScreenshot("failed/" + scenarioNameAndStatus);
        } else {
            pic = takeScreenshot("passed/" + scenarioNameAndStatus);
        }

        //attach this screenshot in the report
        scenario.attach(pic, "image/png", scenarioNameAndStatus);

        closeBrowser();
    }


}
