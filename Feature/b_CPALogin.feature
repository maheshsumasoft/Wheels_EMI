Feature: CPA User Login

  Scenario: Open CPA user screen and login with Valid Credentials
    Given I launch chrome browser
    Then I maximize page
    When I open CPA user home page
    Then I verify that the logo present on screen
    When user enter "CPAUserName" and "CPAPsw"
    And click on CPA login button
    And close browser