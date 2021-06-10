Feature: Add Employee

  Background:
    And user logs in with valid admin credentials
    When user clicks on PIM option
    And clicks on Add Employee button

  @smoke
  Scenario:Adding employee from add employee page
    And user enters firstname middlename and lastname
    And user clicks on save button option
    Then employee added successfully

  Scenario:Adding employee from add employee page via feature file
    And user enters first name "amy123", middle name "e", and last name "velksx"
    And user clicks on save button option
    Then employee added successfully

  @example
  Scenario Outline: Adding employee from add employee page via feature file
    And user enters "<FirstName>", "<MiddleName>", and "<LastName>" in the application
    And user clicks on save button option
    Then employee added successfully
    Examples:
      | FirstName | MiddleName | LastName |
      | Hope      | Faith      | Trust    |
      | Jeff      | Eli        | Mondra   |
      | John      | jacl       | aoxs     |

    @dataTableWithHeader
    Scenario: Adding multiple employees in a single execution
      When user adds multiple employees and verifies they're added successfully
      |FirstName|MiddleName|LastName|
      |Elysium  |M         |Mondy   |
      |Yerffej  |E         |Leitnom |
      |Havohej  |Si        |Doog    |

    @excel
    Scenario: Adding employee from excel file
      When user adds multiple employees from excel file for "newData" sheet and verifies they're added