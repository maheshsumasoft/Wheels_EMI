Feature: Sales User Login

  Scenario: Open Sales user screen and login with same
    Given I launch chrome browser
    Then I maximize page
    When I open SO user home page
    Then I verify that the logo present on screen
    And close browser