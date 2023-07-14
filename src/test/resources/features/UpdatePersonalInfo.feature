Feature: Update Employee Personal Information

  Background:
    When user enters valid admin username and password
    And user clicks on login button
    Then user is successfully logged in the application

  @updateInfo @scenarioOutline @regression @smoke
  Scenario Outline: update employee info with multiply set of data using scenario outline
    And the user clicks on the Employee List button inside the PIM Tab.
    And the user searches for the employee by ID using the ID "49749018".
    And the user clicks on the employee from the search results.
    And the user navigates to the Employee page.
    And the user clicks on the Edit button.
    Then the following fields should be displayed:
      | First Name          |
      | Middle Name         |
      | Last Name           |
      | Male                |
      | Female              |
      | personal_cmbNation  |
      | personal_cmbMarital |
    And the user enters or updates the following data:
      | Field          | Value           |
      | First Name     | <firstName>     |
      | Middle Name    | <middleName>    |
      | Last Name      | <lastName>      |
      | Gender         | <gender>        |
      | Nationality    | <nationality>   |
      | Marital Status | <maritalStatus> |
    And the user clicks on the Save button
    Then the user should see a success message confirming the changes were saved successfully

    Examples:
      | employeeName | firstName | middleName | lastName | gender | nationality | maritalStatus |
      | John Doe     | John      | OR         | Smith    | Female | USA         | Married       |
      | Jane Smith   | Jane      | OR         | Johnson  | Male   | Canada      | Single        |

  #@updateInfo @excel @regression @smoke
  #Scenario: update employee info using the excel file
   #When user update the employee data using excel from "UpdateEmployeeInfoBatch16G17" and verify it