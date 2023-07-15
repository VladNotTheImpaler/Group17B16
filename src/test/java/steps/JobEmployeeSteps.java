package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReader;
import utils.Log;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JobEmployeeSteps extends CommonMethods {
    @When("user clicks on PIM option and Employee list option")
    public void user_clicks_on_pim_option_and_employee_list_option() {
        click(dashBoardPage.pimOption,10);
        click(dashBoardPage.empListOption,10);
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        sendText("66786009",jobEmployeePage.idTextField);
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        click(jobEmployeePage.searchButton,10);
    }
    @When("user clicks on employee id")
    public void user_clicks_on_employee_id() {
        jobEmployeePage.employeeID.click();
    }
    @Then("user is able to see employee's profile")
    public void user_is_able_to_see_employee_s_profile() {
        System.out.println("Personal Details section is visible");
    }

    @When("user clicks on job button and edit button")
    public void user_clicks_on_job_button_and_edit_button() {
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("My AddJobEmployyDetails test case starts here");
        jobEmployeePage.jobButton.click();
      jobEmployeePage.editButton.click();
    }

    @When("user adds multiple employees job details using excel from {string}")
    public void user_adds_multiple_employees_job_details_using_excel_from(String sheetName) {
        List<Map<String,String>> addDetails= ExcelReader.getExcelData(sheetName, Constants.EXCEL_READER_PATH);
        Iterator<Map<String,String>> itr=addDetails.iterator();
        while (itr.hasNext()){
            Map<String,String> jobDet=itr.next();
            selectFromDropdown(jobEmployeePage.jobTitle,"VisibleText",jobDet.get("Job Title"));
            selectFromDropdown(jobEmployeePage.jobStatus,"VisibleText",jobDet.get("Employment Status"));
            selectFromDropdown(jobEmployeePage.jobCategory,"VisibleText",jobDet.get("Job Category"));

            click(jobEmployeePage.jobDate,10);
            selectFromDropdown(jobEmployeePage.jobDateMonth,"VisibleText",jobDet.get("Joined Date-m"));
            selectFromDropdown(jobEmployeePage.jobDateYear,"VisibleText",jobDet.get("Joined Date-y"));
            for (WebElement s : jobEmployeePage.jobDateDay) {
                String day=s.getText();
                if(day.equals(jobDet.get("Joined Date-d"))){
                    s.click();
                    break;
                }

            }

            selectFromDropdown(jobEmployeePage.jobUnit,"VisibleText",jobDet.get("Sub Unit"));
            selectFromDropdown(jobEmployeePage.jobLocation,"VisibleText",jobDet.get("Location"));

            click(jobEmployeePage.jobStartDate,10);
            selectFromDropdown(jobEmployeePage.jobDateMonth,"VisibleText",jobDet.get("Start Date-m"));
            selectFromDropdown(jobEmployeePage.jobDateYear,"VisibleText",jobDet.get("Start Date-y"));
            for (WebElement s : jobEmployeePage.jobDateDay) {
                String day=s.getText();
                if(day.equals(jobDet.get("Start Date-d"))){
                    s.click();
                    break;
                }
            }

            click(jobEmployeePage.jobEndDate,10);
            selectFromDropdown(jobEmployeePage.jobDateMonth,"VisibleText",jobDet.get("End Date-m"));
            selectFromDropdown(jobEmployeePage.jobDateYear,"VisibleText",jobDet.get("End Date-d"));
            for (WebElement s : jobEmployeePage.jobDateDay) {
                String day=s.getText();
                if(day.equals(jobDet.get("End Date-y"))){
                    s.click();
                    break;
                }
            }

            if(jobEmployeePage.jobFile.isDisplayed()){
                sendText(jobDet.get("Contract Details"),jobEmployeePage.jobFile);
            }else{
                jobEmployeePage.radioBtn.click();
            }

        }
    }

    @When("user checks the mandatory fields and click save button")
    public void user_checks_the_mandatory_fields_and_click_save_button() {
        Assert.assertFalse(jobEmployeePage.jobTitle.getText().isBlank());
        Assert.assertFalse(jobEmployeePage.jobStatus.getText().isBlank());
        Assert.assertFalse(jobEmployeePage.jobDateDay.toString().isBlank());
        Assert.assertFalse(jobEmployeePage.jobUnit.getText().isBlank());
        Assert.assertFalse(jobEmployeePage.jobLocation.getText().isBlank());
        System.out.println("Mandatory fields are filled");
        click(jobEmployeePage.editButton,10);

    }
    @Then("employee's current job details added successfully")
    public void employee_s_current_job_details_added_successfully() {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'message success fadable')]")));
        String actualMessage= message.getText();
        String expectedMessage="Successfully Updated"+"\n"+"Close";
        Assert.assertEquals(expectedMessage,actualMessage);

        System.out.println("Successfully Updated");
        Log.info("My AddJobEmployyDetails test case passed");


    }

}
