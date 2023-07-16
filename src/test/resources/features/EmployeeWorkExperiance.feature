Feature: Employee adding work experience

  Background:
    Given user navigates to HRMS application
    When user enters username and password
    And  User click on login button

  @smoke @farwa
  Scenario: Add Experience

    When user click Pim Tab and Employee List Tab
    And click Add button
    Then user enter "Kevin" and "Wilson" and "Anthony1"
    And user click save button
    Then user clicks Qualifications tab and add button

    #When user adds work experience using excel from "Sheet1"
    Then user enter "RobertHalf" and "Auditor" and "2022-05-06" and "2023-06-07" and "Done" and "Successfully Saved"
    Then user is able to delete previously saved work by locating the company name "RobertHalf"
