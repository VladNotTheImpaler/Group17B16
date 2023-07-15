package steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.CommonMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UpdatePersonalInfoSteps extends CommonMethods {

    @Then("the user clicks on the Employee List button inside the PIM Tab.")
    public void the_user_clicks_on_the_employee_list_button_inside_the_pim_tab() {
        waitForClick(updatePersonalInfo.empListOption, 10);
    }

    @Then("the user searches for the employee by ID using the ID {string}.")
    public void the_user_searches_for_the_employee_by_id_using_the_id(String string) {
        sendText(string, updatePersonalInfo.idTextField);
        waitForClick(updatePersonalInfo.searchButton, 10);
    }

    @Then("the user clicks on the employee from the search results.")
    public void the_user_clicks_on_the_employee_from_the_search_results() {
        waitForClick(updatePersonalInfo.idTableCell, 20);
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
    }

    @Then("the user enters or updates the following data:")
    public void the_user_enters_or_updates_the_following_data(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> employeeData = dataTable.asMaps();
        for (var employee : employeeData) {

            var firstNameValue = employee.get("firstName");
            var middleNameValue = employee.get("middleName");
            var lastNameValue = employee.get("lastName");
            var gender = employee.get("gender");
            var nationality = employee.get("nationality");
            var martialStatus = employee.get("maritalStatus");

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


    }

    @Then("the user clicks on the Save button")
    public void the_user_clicks_on_the_button() {

    }

    @Then("the user should see a success message confirming the changes were saved successfully")
    public void the_user_should_see_a_success_message_confirming_the_changes_were_saved_successfully() {

    }
}
