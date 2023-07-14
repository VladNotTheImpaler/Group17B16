package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReader;

import java.io.ObjectInputFilter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EmployeeWorkExperianceSteps extends CommonMethods {

    @Given("user navigates to HRMS application")
    public void user_navigates_to_hrms_application() {
        openBrowserGetURL(getProperty("url"),"chrome");
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
        sendText(getProperty("username"),emp.usernameField);
        sendText(getProperty("password"), emp.passwordField);
    }

    @When("User click on login button")
    public void user_click_on_login_button() {

        emp.loginButton.click();
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
    public void user_enter_and_and(String firstName, String middleName, String lastName) throws InterruptedException {
        System.out.println("On Add Employee page");
        System.out.println(firstName + middleName + lastName);
        sendText(firstName, emp.firstNameField);
        sendText(middleName, emp.middleNameField);
        sendText(lastName, emp.lastNameField);
        Thread.sleep(2000);
    }

    @Then("user click save button")
    public void user_click_save_button() throws InterruptedException {
        emp.saveBtn.click();
        Thread.sleep(2000);
    }

    @Then("user clicks Qualifications tab and add button")
    public void user_clicks_qualifications_tab_and_add_button() throws InterruptedException {
        emp.qualificationtab.click();
        emp.addbtn.click();
        Thread.sleep(2000);
    }

    @When("user adds work experiance using excel from {string}")
    public void userAddsWorkExperianceUsingExcelFrom(String arg0) throws InterruptedException {
        List<Map<String, String>> empexp = ExcelReader.getExcelData("Sheet1", Constants.EXCEL_READER_PATH);
        Iterator<Map<String, String>> itr = empexp.iterator();
        while (itr.hasNext()) {
            Map<String, String> mapEmpExp = itr.next();
            sendText(mapEmpExp.get("Company"), emp.company);
            sendText(mapEmpExp.get("Job Title"), emp.jobTitle);
            sendText(mapEmpExp.get("From"), emp.fromDate);
            sendText(mapEmpExp.get("To"),emp.toDate);
            sendText(mapEmpExp.get("Comment"),emp.comments);
            Thread.sleep(50000);
            emp.saveBtn.click();
        }
    }

}
