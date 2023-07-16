package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;

public class EmployeeWorkExperianceSteps extends CommonMethods {

    @Given("user navigates to HRMS application")
    public void user_navigates_to_hrms_application() {
        //   openBrowserGetURL(getProperty("url"), "chrome");
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
        sendText(getProperty("username"), loginPage.getUsernameField());
        sendText(getProperty("password"), loginPage.getPasswordField());
    }

    @When("User click on login button")
    public void user_click_on_login_button() {
        loginPage.loginButton.click();

    }


    @When("user click Pim Tab and Employee List Tab")
    public void user_click_pim_tab_and_employee_list_tab() {
        emp.pimOption.click();
        emp.addEmployeeButton.click();
    }

    @Then("click Add button")
    public void click_add_button() {
        emp.addEmployeeButton.click();
        System.out.println("Have clicked on Add Button");
    }

    @Then("user enter {string} and {string} and {string}")
    public void user_enter_and_and(String firstName, String middleName, String lastName) {
        System.out.println("On Add Employee page");
        System.out.println(firstName + middleName + lastName);
        sendText(firstName, emp.firstNameField);
        sendText(middleName, emp.middleNameField);
        sendText(lastName, emp.lastNameField);

    }

    @Then("user click save button")
    public void user_click_save_button() {
        emp.saveBtn.click();

    }

    @Then("user clicks Qualifications tab and add button")
    public void user_clicks_qualifications_tab_and_add_button() {
        emp.qualificationtab.click();
        emp.addbtn.click();
        System.out.println("I AM DEFINETLY HERE");
    }

    @Then("user enter {string} and {string} and {string} and {string} and {string} and {string}")
    public void user_enter_and_and_and_and(String company, String jobTitle, String from, String to, String comment, String expectedMessage) {
        sendText(company, emp.company);
        sendText(jobTitle, emp.jobTitle);
        sendText(from, emp.fromDate);
        sendText(to, emp.toDate);
        sendText(comment, emp.comments);
        emp.workExpSaveBtn.click();

        var specialElement = emp.successSavedMsgWork;
        waitForAppear(specialElement, 0);
        boolean present = specialElement.isDisplayed();
        Assert.assertTrue("Successfully Saved not presented", present);
        System.out.println("Successfully Saved Massage Presented");
    }

    //user will be able to delete the saved work
    @Then("user is able to delete previously saved work by locating the company name {string}")
    public void userIsAbleToDeletePreviouslySavedWorkByLocatingTheCompanyName(String company) {
        var getCompanyText = emp.companyTable.getText();
        if (getCompanyText.equalsIgnoreCase(company)) {
            singleCheckBox(emp.checkBox, false);
            emp.deletework.click();
        }

        var specialElementDelete = emp.successDeleteMsgWork;
        waitForAppear(specialElementDelete, 0);
        boolean present = specialElementDelete.isDisplayed();
        Assert.assertTrue("Successfully Deleted not presented", present);
        System.out.println("Successfully Deleted Massage Presented");

    }
}


