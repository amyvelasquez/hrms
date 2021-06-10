Feature: Login

  @simpleTag
  Scenario: valid admin login
    When user enters valid admin username and password
    And user clicks on log in button
    Then admin user is successfully logged in

  @production
  Scenario: valid ess employee login
    When user enters valid ess username and password
    And user clicks on log in button
    Then ess user is successfully logged in

  @regression
  Scenario: log in with valid username and invalid password
    When user enters valid username and invalid password
    And user clicks on log in button
    Then user sees invalid credentials text on login page

  @example
  Scenario Outline: login in with multiple data
    When user enters "<username>" and "<password>"
    And user clicks on log in button
    And "<firstName>" is successfully logged in
    Examples:
      | username          | password     | firstName |
      | Admin             | Hum@nhrm123  | Admin     |
      | william1236000000 | Syntax12!!!! | William   |

  @error
  Scenario: Login with valid username and invalid password
    When user enters valid username and invalid password and verifies error message
      | username          | password | errorMessage        |
      | Admin             | rhfiu3   | Invalid credentials |
      | william1236000000 | 3e908    | Invalid credentials |


  @errorValidation
  Scenario Outline: Login with multiple username and password combinations
    When user enter different "<usernameValue>" and "<passwordValue>" and verifies the "<error>" for all the combinations
    Examples:
      | usernameValue | passwordValue | error                    |
      | Admin         | Syntax123!    | Invalid credentials      |
      | adied2        | Hum@nhrm123!  | Invalid credentials      |
      | Ames          |               | Password cannot be empty |
      |               | Syntax123!    | Username cannot be empty |





