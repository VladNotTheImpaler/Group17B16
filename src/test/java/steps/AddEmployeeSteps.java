package steps;

import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {
    @When("user clicks on PIM button")
    // Perform click action on the PIM button
    public void user_clicks_on_pim_button() {
        click(dashboardPage.pimOption, 10);
    }
    @When("user clicks on add employee button")
    // Perform click action on the Add Employee button
    public void user_clicks_on_add_employee_button() {
        click(dashboardPage.addEmployeeButton, 10);
    }
    @When("user enters {string} and {string} and {string} and {string} and {string} and verify employees added successfully")
    public void user_enters_and_and_and_and_and_verify_employees_added_successfully(String firstName, String middleName, String lastName, String employeeID, String fullName) {
        sendText(firstName, addEmployeePage.firstNameField);
        sendText(middleName, addEmployeePage.middleNameField);
        sendText(lastName,addEmployeePage.lastNameField);

        if (!employeeID.isEmpty()){
            sendText(employeeID,addEmployeePage.employeeIdField);
        }else
            System.out.println("system ID generated!");
        click(addEmployeePage.saveButton, 10);
        Assert.assertEquals(fullName,addEmployeePage.profileName.getText());
        if (!employeeID.isEmpty()){
            Assert.assertEquals(employeeID,addEmployeePage.profileEmpId.getAttribute("value"));
        }
    }

    @When("user do not enter either firstname or lastname show Require field missing error")
    public void user_do_not_enter_either_firstname_or_lastname(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> employeesInformation = dataTable.asMaps();

        for (Map<String, String> employeeInfo:employeesInformation
        ) {
            //getting the values against the key in map
            String firstNameValue = employeeInfo.get("firstName");
            String middleNameValue = employeeInfo.get("middleName");
            String lastNameValue = employeeInfo.get("lastName");

            if (firstNameValue  == null ) {
                firstNameValue = "";
            }

            if (lastNameValue == null) {
                lastNameValue = "";
            }

            //filling the name in the fields
            sendText(firstNameValue, addEmployeePage.firstNameField);
            sendText(middleNameValue, addEmployeePage.middleNameField);
            sendText(lastNameValue, addEmployeePage.lastNameField);
            click(addEmployeePage.saveButton, 10);
            WebElement actualValueWebElement;
            if(firstNameValue.isEmpty()) {
                actualValueWebElement = addEmployeePage.requiredFirstNameError;
            } else {
                actualValueWebElement = addEmployeePage.requiredLastNameError;
            }
            Assert.assertEquals("Required",actualValueWebElement.getText());
        }
    }
}
