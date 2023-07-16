Feature: Search for an employee

  Background:
    Given user enters valid admin username and password
    And user clicks on login button
    Then user is successfully logged in the application
    When user clicks on PIM button
    And user clicks on employee list button

  @SearchEmployeeByID103
  Scenario: Search employee by id
    And user enters a valid employee id
    And user clicks on the search button
    Then user verifies the employee information

  @SearchEmployeeByFullName104
  Scenario: Search employee by name
    And user enters valid employee full or partial name
    And user clicks on search button
    Then user verifies the associated employees' information

  @NoRecordFound105
  Scenario: No Record Found for given employee name
    And user enters an non-existing employee name
    And user clicks on search button
    Then user verifies no record found
