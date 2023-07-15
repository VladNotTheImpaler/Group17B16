Feature: Add Employees Dependents

  Background:
    When user enters valid admin username and password
    And user clicks on login button
    Then user is successfully logged in the application
    And the user clicks on the Employee List button inside the PIM Tab.
    And the user searches for the employee by ID using the ID "49749018".
    And the user clicks on the employee from the search results.
    And the user navigates to the Employee page.

