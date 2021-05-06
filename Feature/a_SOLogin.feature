Feature: Sales User Login

  Scenario: Open Sales user screen and login with Valid Credentials
    Given I launch chrome browser
    Then I maximize page
    When I open SO user home page
    Then I verify that the logo present on screen
    When user enter "UserName" and "Password"
    And click on login button
    And close browser