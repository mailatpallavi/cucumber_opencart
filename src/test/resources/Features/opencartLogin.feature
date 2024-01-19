Feature: Login Functionality for Opencart E-commerce Website
  
  As a user of the opencart website 
  I want to be able to log in with my account
  so that i can access my account related features and manage my orders

  Background: 
    Given I am on the Opencart login page

  Scenario: Successful login with valid credentials
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully

  Scenario Outline: Unsuccessful login with invalid credentials
    Given I have entered invalid "<username>" and "<password>"
    When I click on the login button
    Then I should see error message indicating "<error_message>"

    Examples: 
      | username    | password | error_message                           |
      | abc         | xxyz     | Warning: No match for name and password |
      | c@gmail.com | abc      | Warning: No match for name and password |
      | wrong       | iiid     | Warning: No match for name and password |

  Scenario: Navigating to the forgotten password page
    When I click on the Forgotten Password link
    Then I should be redirected to the password reset page
