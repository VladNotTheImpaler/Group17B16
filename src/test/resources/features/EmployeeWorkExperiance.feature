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

    #When user adds work experiance using excel from "Sheet1"
    Then user enter "<company>" and "<jobtitle>" and "<from>" and "<to>" and "<comment>"
    Examples:
      | firstName | middleName | lastName |
      | Megan     | Chelsea    | Anthony  |
   Examples:
      | company    | jobtitle | from       | to         | comment |
      | RobertHalf | Auditor  | 2022-05-06 | 2023-06-07 | Done    |

    @test
    Scenario:
      Then user is able to delete previously saved work