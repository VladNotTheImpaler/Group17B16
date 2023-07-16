Feature: Adding Employees to the HRMS Application

  Background:
    Given user enters valid admin username and password
    And user clicks on login button
    Then user is successfully logged in the application
    When user clicks on PIM button
    And user clicks on add employee button

  @AddingEmployee101
  Scenario Outline: adding an employee with system-generated employee ID and with unique employee ID
    When user enters "<firstName>" and "<middleName>" and "<lastName>" and "<employeeID>" and "<fullName>" and verify employees added successfully
    Examples:
      |firstName|middleName|lastName|employeeID |fullName        |
      |Paul     |D.        |John    |           |Paul D. John    |
      |Steven   |F.        |Smithh  |12121219   |Steven F. Smithh|

  @MissingRequiredEmployeeInformation102
  Scenario: missing employee information
    When user do not enter either firstname or lastname show Require field missing error
      |firstName|middleName|lastName|
      |         |ms        |Zck     |
      |Justin   |ms        |        |
