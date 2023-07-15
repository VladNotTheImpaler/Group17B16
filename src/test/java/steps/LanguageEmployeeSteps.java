package steps;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonMethods;
import utils.Log;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class LanguageEmployeeSteps extends CommonMethods {

    @When("user clicks on MyInfo option")
    public void user_clicks_on_my_info_option() {

        click(dashBoardPage.myDetailsOption,10);
    }
    @When("user clicks on qualifications button")
    public void user_clicks_on_qualifications_button_and_add_language_button() {
        myInfoPage.qualifField.click();
    }

    @And("user clicks on addLanguage button")
    public void user_clicks_on_addLanguage_button() {
        myInfoPage.addLangButton.click();
    }

    @When("user enters Language and Fluency and Competency")
    public void user_enters_language_and_fluency_and_competency(io.cucumber.datatable.DataTable dataTable) {

        List<Map<String, String>> langDetails=dataTable.asMaps();
        for (Map<String, String> details : langDetails) {
            String language=details.get("Language");
            String fluency=details.get("Fluency");
            String competency=details.get("Competency");


            selectFromDropdown(myInfoPage.lanField,"VisibleText",language);
            selectFromDropdown(myInfoPage.fluField,"VisibleText",fluency);
            selectFromDropdown(myInfoPage.compField,"VisibleText",competency);
        }
    }
    @When("user send text to commentsField")
    public void user_send_text_to_comments_field() {
        String text="I continue my studies";
        sendText(text,myInfoPage.commentsField);
    }
    @When("user checks the mandatory language fields and click save button")
    public void user_checks_the_mandatory_language_fields_and_click_save_button() {

        Assert.assertFalse(myInfoPage.lanField.getText().isBlank());
        Assert.assertFalse(myInfoPage.fluField.getText().isBlank());
        Assert.assertFalse(myInfoPage.compField.getText().isBlank());

        System.out.println("Mandatory fields are filled");
        myInfoPage.languageSaveButton.click();
    }
    @Then("employee's language proficiency details added successfully")
    public void employee_s_language_proficiency_details_added_successfully() {

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'message success fadable')]")));

        String actualMessage= message.getText();
        String expectedMessage="Successfully Saved"+"\n"+"Close";
        Assert.assertEquals(expectedMessage,actualMessage);
        System.out.println("Successfully Saved");

    }
    @Then("user deletes the language proficiency fields and checks if they are deleted")
    public void user_deletes_the_language_proficiency_fields_and_checks_if_they_are_deleted() {

        singleCheckBox(myInfoPage.languageCheckBox,true);
        myInfoPage.delLangButton.click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'message success fadable')]")));

        String actualMessage= message.getText();
        String expectedMessage="Successfully Deleted"+"\n"+"Close";
        Assert.assertEquals(expectedMessage,actualMessage);
        System.out.println("Successfully Deleted");
    }
}
