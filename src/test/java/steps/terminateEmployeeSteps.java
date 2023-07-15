package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.PersonalDetailsPage;
import utils.CommonMethods;

public class terminateEmployeeSteps extends CommonMethods {

    @When("Admin clciks on PIM option")
    public void admin_clciks_on_pim_option() {
        click(dashboardPage.pimOption,20);
    }
    @When("user clicks on employee list button")
    public void user_clicks_on_employee_list_button() {
        click(dashboardPage.empListOption, 20);
    }
    @When("Admin selects a specified employee from the list")
    public void admin_selects_a_specified_employee_from_the_list() {
        WebElement specificEmp=driver.findElement(By.xpath("//table/tbody/tr/td[2]"));
        specificEmp.click();
    }
    @When("Admin navigates to the employee's job page")
    public void admin_navigates_to_the_employee_s_job_page() {
       click(personalDetailsPage.jobElement, 20);
    }
    @When("selects the option to terminate the employment")
    public void selects_the_option_to_terminate_the_employment() {
       click(personalDetailsPage.terminateButton,20);
    }
    @Then("pop-up appears")
    public void pop_up_appears() {
       click(personalDetailsPage.popUp,20);
    }
    @Then("user chooses a reason from the drop-down")
    public void user_chooses_a_reason_from_the_drop_down() {
        click(personalDetailsPage.reasonDD,20);
    }
    @Then("selects a date from the calendar")
    public void selects_a_date_from_the_calendar() {
        click(personalDetailsPage.calendar, 20);
       // click(personalDetailsPage.month, 20);
        selectFromDropdown(personalDetailsPage.month, "visibleText","Mar");
        selectFromDropdown(personalDetailsPage.year,"value","1999");
        WebElement day= driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-hover']"));
        day.click();
    }
    @Then("writes a note in the provided text area")
    public void writes_a_note_in_the_provided_text_area() {
        WebElement note= driver.findElement(By.id("terminate_note"));
        note.sendKeys("TASKS WERE NOT EXECUTED BY THIS EMPLOYEE");
    }
    @Then("clicks on the Confirm button")
    public void clicks_on_the_confirm_button() {
        WebElement confirmButton= driver.findElement(By.id("dialogConfirm"));
        confirmButton.click();
    }
    @Then("the specified employee is terminated")
    public void the_specified_employee_is_terminated() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the message of successfully terminated should appear")
    public void the_message_of_successfully_terminated_should_appear() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
