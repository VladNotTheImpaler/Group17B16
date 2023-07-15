Feature: Add Employees Dependents

  Background:
    When user enters valid admin username and password
    And user clicks on login button
    Then user is successfully logged in the application
    And the user clicks on the Employee List button inside the PIM Tab.
    And the user searches for the employee by ID using the ID "49749018".
    And the user clicks on the employee from the search results.
    And the user navigates to the Employee page.
    And the user navigates to the dependents section

  Scenario: Add a dependent
    And the user clicks on the Add button.
    Then the following fields should be displayed and editable:
      | Name         |
      | Relationship |
      | Birth        |
    When user add the employee dependents data using excel file "AddEmployeesDependentsBatch16G17" and verify it
    And the user clicks on the Save dependent info button
    Then the user should see a success message confirming the dependent was added successfully

  Scenario: Edit a dependent
    And there is a dependent named "Olena OR" in the list
    When the user edits the dependent field with the following details:
      | Name         | Jane Smith |
      | Relationship | Spouse     |
      | Birth        | 1990-02-10 |
    Then the user should see updated dependant info in the list of dependents

  Scenario: Remove a dependent
    And there is a dependent named "Jane Smith" in the list
    When the user removes the dependent named "Jane Smith"
    Then the user should not see "Jane Smith" in the list of dependents

  Scenario: Submit incomplete or invalid dependent information
    When the user enters an incomplete or invalid dependent information
    And the user clicks on the "Add" button
    Then the user should see an error message indicating the issue

