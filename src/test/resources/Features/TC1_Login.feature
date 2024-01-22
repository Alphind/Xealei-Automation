#/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.
#
#* created by Mohamed Razul
#
#* reviewed by Hajira Begam
#
#* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement
#
#*/
@Login-AllScenarios
Feature: Verify Xealei Login Page

  Background: 
    Given User is on Xealei login page

  Scenario: Comprehensive Login Page UI Testing
    When User should verify the client code is addressed in tab url address in login screen
    Then User should verify the 'LOGIN' text is displayed
    Then User should verify that after landing on the login page the login button is disabled
    Then User should verify the field label name and placeholder text for Email and Password fields
    And User should enter password in password field
    Then User should verify that entered password is **hide
    And User should click the eye icon in the Password field
    Then User should verify that entered password is Unhide
    And User should verify Forget password link is working
    Then User should verify the copy rights "Powered by Alphind © 2024" text is displayed

  Scenario: To verify the error validation messages in Login page
    And User should verify that email field is mandatory "Please enter email ID"
    Then User should verify that password field is mandatory "Please enter password"
    When User should perform login with invalid data
    Then User should verify the error message after performed login with invalid data "User not found"
    When User should perform login with valid email and invalid password
    Then User should verify the Toastbar message after performed login with valid email and invalid password 'Incorrect password'

  Scenario: To verify Xealei Login page by click the ENTER key with valid credentials
    When User should perform login with valid email and password by click the Enter key
    Then User should verify once the page is navigated to HOME_DASHBOARD successfully "Home"

  Scenario: To verify Xealei Login page with valid credentials
    When User should perform login with valid email and password
    Then User should verify once the page is navigated to HOME_DASHBOARD successfully "Home"
