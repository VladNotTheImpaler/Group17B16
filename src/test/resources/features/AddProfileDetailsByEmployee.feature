Feature: Adding profile details by the Employee

  Background:
    When user enters valid employee username and password
    And user clicks on login button
    Then employee user is successfully logged in the application
    When user clicks on MyInfo option


  @languageSave
  Scenario: Add langProficiency details by the Employee
    When user clicks on qualifications button
    And user clicks on addLanguage button
    And user enters Language and Fluency and Competency
      |Language|Fluency  |Competency|
      |Dutch   |Speaking  |Good      |

    And user send text to commentsField
    And user checks the mandatory language fields and click save button
    Then employee's language proficiency details added successfully


  @languageDelete
  Scenario: Delete language details by the Employee
    When user clicks on qualifications button
    Then user deletes the language proficiency fields and checks if they are deleted