@Auth
Feature: Verifying Cypress Real World App Authorization details

  Background: 
    Given User is on the cypress real world app page

  Scenario Outline: Verifying Cypress Real World App Signup with empty credentials
    When User should perform click signup "<firstname>","<lastname>","<username>","<password>" and "<confirmpassword>"
    Then User should verify error messages "First Name is required","Last Name is required","Username is required","Enter your password" and "Confirm your password"

    Examples: 
      | firstname | lastname | username | password | confirmpassword |
      |           |          |          |          |                 |

  Scenario Outline: Verifying Cypress Real World App Signup valid
    When User should perform click signup "<firstname>","<lastname>","<username>","<password>" and "<confirmpassword>"
    Then User should click signup button

    Examples: 
      | firstname | lastname | username | password   | confirmpassword |
      | Raj       | Kumar    | New1     | Raj@123450 | Raj@123450      |

  Scenario Outline: Verifying Cypress Real World App SignIn valid
    When User should perform signin "<username>","<password>"
    Then User should click next button to create bank account
    When User create bank account with without entering credentials "<bankname>","<routingnumber>" and "<accountnumber>"
    Then User should verify error messages "Enter a bank name","Enter a valid bank routing number" and "Enter a valid bank account number "

    Examples: 
      | username | password   | bankname | routingnumber | accountnumber |
      | New1     | Raj@123450 |          |               |               |

  Scenario Outline: Verifying Cypress Real World App CreateBankAccount valid
    When User should perform signin "<username>","<password>"
    Then User should click next button to create bank account
    When User create bank account with valid credentials "<bankname>","<routingnumber>" and "<accountnumber>"
    Then User should verify finished message "Finished"
    When User should click done button
    Then User should verify user name "Home"
    And User should click logout

    Examples: 
      | username | password   | bankname    | routingnumber | accountnumber |
      | New1     | Raj@123450 | United Bank |     123456789 |     123456789 |

  Scenario Outline: Verifying Cypress Real World App SignIn using Enter
    When User should perform signin "<username>","<password>" with Enter Key
    Then User should verify user name "Home"

    Examples: 
      | username | password   |
      | New1     | Raj@123450 |

  Scenario Outline: Verifying Cypress Real World App SignIn empty username and min char password
    When User should perform signin "<username>","<password>"
    Then User should verify after signin with empty username and min char password error message contains "Username is required","Password must contain at least 4 characters"

    Examples: 
      | username | password |
      |          | R        |

  Scenario Outline: Verifying Cypress Real World App SignIn Invalid credentials
    When User should perform signin "<username>","<password>"
    Then User should verify after signin with invalid credential error message contains "Username or password is invalid"

    Examples: 
      | username | password |
      | New1     | Raj@123  |
