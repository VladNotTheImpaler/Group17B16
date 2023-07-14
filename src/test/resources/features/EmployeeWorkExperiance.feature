Feature: Employee adding work experiance

  @smoke
  Scenario Outline: Add Experience
    Given user navigates to HRMS application
    When user enters username and password
    And  User click on login button
    When user click Pim Tab and Employee List Tab
    And click Add button
    Then user enter "<firstName>" and "<middleName>" and "<lastName>"
    And user click save button
    Then user clicks Qualifications tab and add button
    When user adds work experiance using excel from "Sheet1"
    Examples:
      | firstName | middleName | lastName |
      | Megan      | Chelsea     | Anthony   |


