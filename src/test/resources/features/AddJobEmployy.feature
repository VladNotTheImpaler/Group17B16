Feature: Adding employee's job details

  Background:
    When user enters valid admin username and password
    And user clicks on login button
    Then user is successfully logged in the application
    When user clicks on PIM option and Employee list option
    And user enters valid employee id
    And user clicks on search button
    And user clicks on employee id
    Then user is able to see employee's profile


  @job
  Scenario: Add employee's current job details using excel file
    When user clicks on job button and edit button
    And user adds multiple employees job details using excel from "JobDetails"
    And user checks the mandatory fields and click save button
    Then employee's current job details added successfully