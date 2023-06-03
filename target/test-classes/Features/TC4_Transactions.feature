@Transactions
Feature: Verifying Cypress Real World App Everyone features

  Background: 
    Given User is on the cypress real world app page

  Scenario Outline: Verifying Cypress Real World App Everone tab page
    When User should perform signin "<username>","<password>"
    Then User should verify user name "Home"
    When User should click on everyone public transaction
    Then User should verify transaction detail msg "Transaction Detail"
    And User should perform click home button
    When User should click on date
    Then User should select date from calendar

    Examples: 
      | username | password   |
      | RajRK    | Raj@123450 |

  Scenario Outline: Verifying Cypress Real World App Friends tab page
    When User should perform signin "<username>","<password>"
    Then User should verify user name "Home"
    When User should click on friends transaction tab
    Then User should click on create a transaction button
    And User should click on search text box
    And User should select contact
    And User should type amount of transaction "<amount>"
    And User should add a note on transaction "<note>"
    And User should click on pay to the contact button
    And User should return to transactions

    Examples: 
      | username | password   | amount | note |
      | RajRK    | Raj@123450 |    123 |    1 |

  Scenario Outline: Verifying Cypress Real World App Mine tab page
    When User should perform signin "<username>","<password>"
    Then User should verify user name "Home"
    When User should click on mine transaction tab
    Then User should verify personal text "Personal"

    Examples: 
      | username | password   |
      | RajRK    | Raj@123450 |
