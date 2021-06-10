Feature: Employee Search

  Background:
    And user logs in with valid admin credentials
    And user navigates to employee list page

  @smoke
  Scenario: Search employee by ID
    When user enters valid employee ID
    And clicks on search button
    Then employee information is displayed

  @smoke
  Scenario: Search employee by name
    When user enters valid employee name
    And clicks on search button
    Then employee information is displayed