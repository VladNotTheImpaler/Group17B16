package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import utils.CommonMethods;
import utils.Log;

public class LoginSteps extends CommonMethods {

    @When("user enters valid admin username and password")
    public void user_enters_valid_admin_username_and_password() {
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("My Group17B16 test case starts here");
        sendText(getProperty("username"), loginPage.getUsernameField());
        Log.info("my username has been entered");
        sendText(getProperty("password"), loginPage.getPasswordField());
        Log.info("My password has been entered");
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.loginButton.click();
    }

    @Then("user is successfully logged in the application")
    public void user_is_successfully_logged_in_the_application() {
        var expectedWelcomeMsg = "Welcome Admin";
        var actualWelcomeMsg = loginPage.welcomeAdmin.getText();
        Assert.assertEquals(expectedWelcomeMsg, actualWelcomeMsg);
    }
    @When("user enters valid employee username and password")
    public void user_enters_valid_employee_username_and_password() {
        sendText(getProperty("usernameEmp"),loginPage.getUsernameField());
        sendText(getProperty("passwordEmp"),loginPage.getPasswordField());
    }
    @Then("employee user is successfully logged in the application")
    public void employee_user_is_successfully_logged_in_the_application() {
        var expectedWelcomeMsg = "Welcome "+getProperty("nameEmp");
        var actualWelcomeMsg = loginPage.welcomeAdmin.getText();
        Assert.assertEquals(expectedWelcomeMsg, actualWelcomeMsg);
    }

}

