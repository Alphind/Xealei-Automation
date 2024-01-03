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
    When User should verify the tab url address for login page
    Then User should verify the 'LOGIN' text is displayed
    Then User should verify the Login button is disabled
    #Not Implemented
    # When User should perform login with invalid email format (with 2 diff format)
    # Then User should verify the error message contains email field "Enter Valid Email"
    Then User should verify the field label name and placeholder text for Email and Password fields
    When User should enter password in password field
    Then User should verify that entered password is **hide
    And User should click the eye icon in the Password field
    Then User should verify that entered password is Unhide
    And User should verify Forget password link is working
    Then User should verify the copy rights "Powered by Alphind © 2023" text is displayed
  #Not Implemented
  #When User should click the Close icon in the Privacy Policy pop-up screen
  #Then User should verify the pop-up should be closed
 
 
  Scenario: To verify the error validation messages in Login page
    And User should enter password in password field and press enter button
    Then User should verify the error message contains email field "Please enter email ID"
    And User should enter email in email field and click login button
    Then User should verify the error message contains password field "Please enter password"
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
