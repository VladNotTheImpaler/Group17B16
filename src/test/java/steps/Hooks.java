package steps;

import org.junit.Before;
import utils.CommonMethods;

public class Hooks extends CommonMethods {
    @Before
    public void start() {
        //browser name we should add from the openBrowserGetURL method
        // in the CommonMethods class
        openBrowserGetURL(getProperty("url"), "chrome");
    }


}
