Feature: Admin Terminate Employee Employment

  @terminate
  Scenario: Admin terminates employment of a specified employee
    When Admin clciks on PIM option
    And user clicks on employee list button
    And Admin selects a specified employee from the list
    And Admin navigates to the employee's job page
    And selects the option to terminate the employment
    Then pop-up appears
    And user chooses a reason from the drop-down
    And selects a date from the calendar
    And writes a note in the provided text area
    And clicks on the Confirm button
    Then the specified employee is terminated
    And the message of successfully terminated should appear

