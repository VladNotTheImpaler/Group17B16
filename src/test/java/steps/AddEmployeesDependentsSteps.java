package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;

public class AddEmployeesDependentsSteps extends CommonMethods {

    //add dependent
    @Then("the user navigates to the dependents section")
    public void the_user_navigates_to_the_dependents_section() {

    }

    @Then("the user clicks on the Add button.")
    public void the_user_clicks_on_the_add_button() {

    }

    @Then("the following fields should be displayed and editable:")
    public void the_following_fields_should_be_displayed_and_editable(io.cucumber.datatable.DataTable dataTable) {

    }

    @When("user add the employee dependents data using excel file {string} and verify it")
    public void user_add_the_employee_dependents_data_using_excel_file_and_verify_it(String string) {


    }

    @When("the user clicks on the Save dependent info button")
    public void the_user_clicks_on_the_save_dependent_info_button() {


    }

    @Then("the user should see a success message confirming the dependent was added successfully")
    public void the_user_should_see_a_success_message_confirming_the_dependent_was_added_successfully() {


    }


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

    //remove dependent
    @When("the user enters an incomplete or invalid dependent information")
    public void the_user_enters_an_incomplete_or_invalid_dependent_information() {

    }

    @When("the user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String string) {

    }

    @Then("the user should see an error message indicating the issue")
    public void the_user_should_see_an_error_message_indicating_the_issue() {
       
    }


}
