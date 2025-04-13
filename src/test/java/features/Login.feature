Feature: Login to Bibit Web

  Scenario: User successfully login to Bibit Web
    Given User on Bibit Homepage
    When User click on the Login button
    And User enter phone number
    And User tap on Login button
    And User submit OTP and PIN
    Then User redirected to Bibit Homepage
