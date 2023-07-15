Feature: Update Employee Personal Information

  Background:
    When user enters valid admin username and password
    And user clicks on login button
    Then user is successfully logged in the application
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

  @updateInfo @scenarioOutline @regression @smoke
  Scenario Outline: update employee info with multiply set of data using scenario outline
    When user updated "<firstName>", "<middleName>", "<lastName>", "<gender>", "<nationality>", "<maritalStatus>"
    And the user clicks on the Save button
    Then the user should see a success message confirming the changes were saved successfully

    Examples:
      | firstName | middleName | lastName | gender | nationality | maritalStatus |
      | John      | OR         | Smith    | Male   | Ukrainian   | Married       |
      #| Jane      | OR         | Johnson  | Female | Ukrainian   | Single        |
      #| Jakie     | OR         | Wilson   | Male   | Ukrainian   | Other         |

  @updateInfo @excelOleksii @regression @smoke
  Scenario: update employee info using the excel file
    When user update the employee data using excel file "UpdateEmployeeInfoBatch16G17" and verify it