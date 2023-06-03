@BankAccounts
Feature: Verifying Cypress Real World App MyAccount details

  Background: 
    Given User is on the cypress real world app page

  Scenario Outline: Verifying Cypress Real World App Bank Accounts page
    When User should perform signin "<username>","<password>"
    Then User should verify user name "Home"
    When User should click bank accounts tab
    Then User should verify bank accounts text "Bank Accounts"
    When User should perform create bank account
    Then User create bank account with valid credentials "<bankname>","<routingnumber>" and "<accountnumber>"
    When User should perform with delete tab
    Then User should verify deleted msg "(Deleted)"

    Examples: 
      | username | password   | bankname    | routingnumber | accountnumber |
      | RajRK    | Raj@123450 | United Bank1 |     123456789 |     123456789 |
