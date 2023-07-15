package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    @Then("user enter {string} and {string} and {string} and {string} and {string}")
    public void user_enter_and_and_and_and(String company, String jobtitle, String from, String to, String comment, String expectedmessage) {
        sendText(company,emp.company);
        sendText(jobtitle,emp.jobTitle);
        sendText(from,emp.fromDate);
        sendText(to,emp.toDate);
        sendText(comment,emp.comments);

      String actualmessage= emp.saveMessage.getText();
      Assert.assertEquals("Succesfully saved",expectedmessage,actualmessage);


    }
    //user will be able to delete the saved work

    @Then("user is able to delete previously saved work")
    public void user_is_able_to_delete_previously_saved_work() {
        emp.deletework.click();
    }

//        List<Map<String, String>> empexp = ExcelReader.getExcelData("Sheet1", Constants.EXCEL_READER_PATH);
//        Iterator<Map<String, String>> itr = empexp.iterator();
//        while (itr.hasNext()) {
//            Map<String, String> mapEmpExp = itr.next();
//            sendText(mapEmpExp.get("Company"), emp.company);
//            sendText(mapEmpExp.get("Job Title"), emp.jobTitle);
//            sendText(mapEmpExp.get("From"), emp.fromDate);
//            sendText(mapEmpExp.get("To"),emp.toDate);
//            sendText(mapEmpExp.get("Comment"),emp.comments);
//            Thread.sleep(50000);
//            emp.saveBtn.click();

        }
//    @When("user adds work experiance using excel from {string}")
//    public void userAddsWorkExperianceUsingExcelFrom(String arg0) throws InterruptedException {
//        List<Map<String, String>> empexp = ExcelReader.getExcelData("Sheet1", Constants.EXCEL_READER_PATH);
//        Iterator<Map<String, String>> itr = empexp.iterator();
//        while (itr.hasNext()) {
//            Map<String, String> mapEmpExp = itr.next();
//            sendText(mapEmpExp.get("Company"), emp.company);
//            sendText(mapEmpExp.get("Job Title"), emp.jobTitle);
//            selectFromDropdown(emp.fromMonth, "value", "1");
//            selectFromDropdown(emp.fromYear, "value", "2019");
//            List<WebElement> alldates = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[6]/a)"));
//            for (WebElement date : alldates) {
//                String currentDate = date.getText();
//                if (currentDate.equals("15")) {
//                    date.click();
//                    Thread.sleep(20000);
//
//                    sendText(mapEmpExp.get("Comment"), emp.comments);
//                    emp.saveBtn.click();
//                }
//            }


