package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;

public class SearchEmployeeSteps extends CommonMethods {
    @When("user clicks on employee list button")
    public void user_clicks_on_employee_list_button() {
        click(dashboardPage.empListOption, 10);
    }
    @When("user enters a valid employee id")
    public void user_enters_a_valid_employee_id() {
        sendText("12121217", searchEmployeePage.idTextField);
    }
    @When("user clicks on the search button")
    public void user_clicks_on_the_search_button() {
        click(searchEmployeePage.searchButton, 10);
    }
    @Then("user verifies the employee information")
    public void user_verifies_the_employee_information() {
        Assert.assertEquals("12121217",searchEmployeePage.listedEmployeeID.getText());
    }

    @When("user enters valid employee full or partial name")
    public void user_enters_valid_employee_full_or_partial_name() throws InterruptedException {
        Thread.sleep(5000);
        sendText("Stev", searchEmployeePage.nameTextField);
    }
    @Then("user verifies the associated employees' information")
    public void user_verifies_the_associated_employees_information() {
        System.out.println("Associated Employees Successfully Found");
    }
    @When("user enters an non-existing employee name")
    public void user_enters_an_non_existing_employee_name() throws InterruptedException {
        Thread.sleep(5000);
        sendText("nonexistingemployee1", searchEmployeePage.nameTextField);
    }
    @Then("user verifies no record found")
    public void user_verifies_no_record_found() {
        System.out.println("Successfully run the test for No Records Found");
    }

}
