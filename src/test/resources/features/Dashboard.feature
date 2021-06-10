Feature: Dashboard tab functionality

    @dashboardTabs
    Scenario: Dashboard tab verification
      When user enters valid admin username and password
      And user clicks on log in button
      Then admin user is successfully logged in
      Then user sees the following tabs on dashboard

      |Admin|PIM|Leave|Time|Recritment|Performance|Dashboard|Directory|
