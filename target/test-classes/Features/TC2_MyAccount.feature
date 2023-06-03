@MyAccount
Feature: Verifying Cypress Real World App MyAccount details

  Background: 
    Given User is on the cypress real world app page

  Scenario Outline: Verifying Cypress Real World App My Account User Settings with valid details
    When User should perform signin "<username>","<password>"
    Then User should verify user name "Home"
    When User should click my account tab
    Then User should verify user settings text "User Settings"
    When User should perform with invalid details "<email>","<phonenumber>"
    Then User should click save button

    Examples: 
      | username | password   | email        | phonenumber |
      | RajRK    | Raj@123450 | 11@gmail.com |      123456 |

  Scenario Outline: Verifying Cypress Real World App My Account User Settings with Invalid details
    When User should perform signin "<username>","<password>"
    Then User should verify user name "Home"
    When User should click my account tab
    Then User should verify user settings text "User Settings"
    When User should perform with invalid details "<email>","<phonenumber>"
    Then User should verify error msg contains "Must contain a valid email address","Phone number is not valid"

    Examples: 
      | username | password   | email | phonenumber |
      | RajRK    | Raj@123450 |    11 |          11 |
