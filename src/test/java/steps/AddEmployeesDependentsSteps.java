package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;
import utils.Constants;

import java.util.Map;

public class AddEmployeesDependentsSteps extends CommonMethods {

    //add dependent
    @Then("the user navigates to the dependents section")
    public void the_user_navigates_to_the_dependents_section() {
        waitForClick(addEmployeesDependents.dependentSection, 10);
    }

    @Then("the user clicks on the Add button.")
    public void the_user_clicks_on_the_add_button() {
        waitForClick(addEmployeesDependents.dependentAdd, 10);
    }

    @Then("the following fields should be displayed and editable:")
    public void the_following_fields_should_be_displayed_and_editable(io.cucumber.datatable.DataTable dataTable) {

        var expectedFields = dataTable.asList();
        var actualFields = getDisplayedDependentsFields();

        Assert.assertEquals("fields mismatch", expectedFields.size(), actualFields.size());

        for (String expectedField : expectedFields) {
            Assert.assertTrue("Field not found: " + expectedField, actualFields.contains(expectedField));
        }
        System.out.println("All field found and matched");
    }

    @When("user add the employee dependents data using excel {string} and verify it")
    public void user_add_the_employee_dependents_data_using_excel_and_verify_it(String sheetName) {
        var addDependents = readExcelData(sheetName, Constants.EXCEL_READER_PATH_OLEKSII_2);
        for (Map<String, String> mapNewDependent : addDependents) {
            sendText(mapNewDependent.get("name"), addEmployeesDependents.dependentName);
            selectFromDropdown(addEmployeesDependents.dependentRelationship, "VisibleText", mapNewDependent.get("relationship"));
            sendText(mapNewDependent.get("relationship"), addEmployeesDependents.dependentRelationship);
            sendText(mapNewDependent.get("birth"), addEmployeesDependents.dependentBirth);

            waitForClick(addEmployeesDependents.dependentSave, 10);

            var specialElement = addEmployeesDependents.successSavedDependentMsg;
            waitForAppear(specialElement, 0);
            boolean present = specialElement.isDisplayed();
            Assert.assertTrue("Successfully Saved not presented", present);
            System.out.println("Successfully Saved Massage Presented");

            waitForClick(addEmployeesDependents.dependentAdd, 10);
        }
    }


    /*
    //edit dependent
    @Then("there is a dependent named {string} in the list")
    public void there_is_a_dependent_named_in_the_list(String string) {

    }

    @When("the user edits the dependent field with the following details:")
    public void the_user_edits_the_dependent_field_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {

    }

    @Then("the user should see updated dependant info in the list of dependents")
    public void the_user_should_see_updated_dependant_info_in_the_list_of_dependents() {

    }

    //remove dependent
    @Then("there is a dependent new named {string} in the list")
    public void there_is_a_dependent_new_named_in_the_list(String string) {

    }

    @When("the user removes the dependent named {string}")
    public void the_user_removes_the_dependent_named(String string) {

    }

    @Then("the user should not see {string} in the list of dependents")
    public void the_user_should_not_see_in_the_list_of_dependents(String string) {

    }

    //submit incomplete data
    @When("the user enters an incomplete or invalid dependent information")
    public void the_user_enters_an_incomplete_or_invalid_dependent_information() {

    }

    @When("the user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String string) {

    }

    @Then("the user should see an error message indicating the issue")
    public void the_user_should_see_an_error_message_indicating_the_issue() {

    }
*/

}
