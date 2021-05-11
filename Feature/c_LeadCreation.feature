Feature: Create Lead

  Scenario: Verify user able to create New Lead or not
    Given I launch chrome browser
    Then I maximize page
    When I Login as SO user
    Then I verify that the logo present on screen
    When I navigate to header "Product"
    When I click on option "New TW"
    Then I verify New TW page on screen
    When I navigate to header "Leads"
    When I click on option "Lead Creation - SO"
    When I select "ID Proof" as "02-PAN"
    When I select "Address Proof" as "6-Water Bill"
    When I enter "Address Document Number/VID Number" as "DocNum"
    When I select "Title" as "1-Mr."
    When I enter "First Name" as "FirstName"
    When I enter "Middle Name" as "MiddleName"
    When I enter "Last Name" as "LastName"
    When I enter "Date Of Birth" as "DOB"
    When I enter "Mobile" as "Mobile"
    When I select "Preferred Language" as "5-Kannada"
