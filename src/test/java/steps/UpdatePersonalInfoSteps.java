package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;
import utils.Constants;

import java.util.Map;

public class UpdatePersonalInfoSteps extends CommonMethods {

    @Then("the user clicks on the Employee List button inside the PIM Tab.")
    public void the_user_clicks_on_the_employee_list_button_inside_the_pim_tab() {
        waitForClick(updatePersonalInfo.pimOption, 10);
    }

    @Then("the user searches for the employee by ID using the ID {string}.")
    public void the_user_searches_for_the_employee_by_id_using_the_id(String string) {
        sendText(string, updatePersonalInfo.idTextField);
        waitForClick(updatePersonalInfo.searchButton, 10);
    }

    @Then("the user clicks on the employee from the search results.")
    public void the_user_clicks_on_the_employee_from_the_search_results() {
        waitForClick(updatePersonalInfo.idTableCell, 10);
    }

    @Then("the user navigates to the Employee page.")
    public void the_user_navigates_to_the_employee_page() {
        if (updatePersonalInfo.titlePersonalDetails.isDisplayed()) {
            var expectedTitle = updatePersonalInfo.titlePersonalDetails.getText();
            var actualTitle = "Personal Details";
            Assert.assertEquals("we are not on the personal page", expectedTitle, actualTitle);
            System.out.println("We are on the Personal Page of the Employee");
        }
    }

    @Then("the user clicks on the Edit button.")
    public void the_user_clicks_on_the_edit_button() {
        waitForClick(updatePersonalInfo.btnEdit, 10);
    }

    @Then("the following fields should be displayed:")
    public void the_following_fields_should_be_displayed(io.cucumber.datatable.DataTable dataTable) {
        var expectedFields = dataTable.asList();
        var actualFields = getDisplayedFields();

        Assert.assertEquals("fields mismatch", expectedFields.size(), actualFields.size());

        for (String expectedField : expectedFields) {
            Assert.assertTrue("Field not found: " + expectedField, actualFields.contains(expectedField));
        }
        System.out.println("All field found and matched");
    }

    @When("user updated {string}, {string}, {string}, {string}, {string}, {string}")
    public void userUpdatedInDataDriverFormat
            (String firstNameValue, String middleNameValue, String lastNameValue,
             String gender, String nationality, String martialStatus) {

        sendText(firstNameValue, updatePersonalInfo.personalFirstName);
        sendText(middleNameValue, updatePersonalInfo.personalMiddleName);
        sendText(lastNameValue, updatePersonalInfo.personalLastName);

        if (gender.equalsIgnoreCase(updatePersonalInfo.personalGenderMale.getText())) {
            singleCheckBox(updatePersonalInfo.personalGenderIDMale, false);
        }
        if (gender.equalsIgnoreCase(updatePersonalInfo.personalGenderFemale.getText())) {
            singleCheckBox(updatePersonalInfo.personalGenderIDFemale, false);
        }
        selectFromDropdown(updatePersonalInfo.personalNationality, "VisibleText", nationality);
        selectFromDropdown(updatePersonalInfo.personalMaritalStatusDD, "VisibleText", martialStatus);

    }

    @Then("the user clicks on the Save button")
    public void the_user_clicks_on_the_button() {
        waitForClick(updatePersonalInfo.btnSave, 10);
    }

    @Then("the user should see a success message confirming the changes were saved successfully")
    public void the_user_should_see_a_success_message_confirming_the_changes_were_saved_successfully() {

        var specialElement = updatePersonalInfo.successSavedMsg;
        waitForAppear(specialElement, 0);
        boolean present = specialElement.isDisplayed();
        Assert.assertTrue("Successfully Saved not presented", present);
        System.out.println("Successfully Saved Massage Presented");

    }

    @When("user update the employee data using excel file {string} and verify it")
    public void userUpdateTheEmployeeDataUsingExcelFromAndVerifyIt(String sheetName) {

        var newEmployees = readExcelData(sheetName, Constants.EXCEL_READER_PATH_OLEKSII);
        for (Map<String, String> mapNewEmp : newEmployees) {
            sendText(mapNewEmp.get("firstName"), updatePersonalInfo.personalFirstName);
            sendText(mapNewEmp.get("middleName"), updatePersonalInfo.personalMiddleName);
            sendText(mapNewEmp.get("lastName"), updatePersonalInfo.personalLastName);

            if (mapNewEmp.get("gender").equalsIgnoreCase(updatePersonalInfo.personalGenderMale.getText())) {
                singleCheckBox(updatePersonalInfo.personalGenderIDMale, false);
            }
            if (mapNewEmp.get("gender").equalsIgnoreCase(updatePersonalInfo.personalGenderFemale.getText())) {
                singleCheckBox(updatePersonalInfo.personalGenderIDFemale, false);
            }

            selectFromDropdown(updatePersonalInfo.personalNationality, "VisibleText", mapNewEmp.get("nationality"));
            selectFromDropdown(updatePersonalInfo.personalMaritalStatusDD, "VisibleText", mapNewEmp.get("maritalStatus"));

            waitForClick(updatePersonalInfo.btnSave, 10);

            var specialElement = updatePersonalInfo.successSavedMsg;
            waitForAppear(specialElement, 0);
            boolean present = specialElement.isDisplayed();
            Assert.assertTrue("Successfully Saved not presented", present);
            System.out.println("Successfully Saved Massage Presented");

            waitForClick(updatePersonalInfo.btnEdit, 10);
        }
    }


}
