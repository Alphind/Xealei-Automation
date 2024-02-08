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
    

  Scenario: To verify Login Page functionality UI Testing and To verify the validation messages in Login page
    # When User should verify the client code is addressed in tab url address in login screen
    # User should verify the field label name and placeholder text for Email and Password fields
    # And User should enter password in password field
    # User should verify that entered password is **hide
    # User should verify that entered password is Unhide after click the eye icon
    # User should verify that email and password fields are mandatory "Please enter email ID", "Please enter password"
    # When User should perform login with invalid data
    # User should verify the error message after performed login with invalid data "User not found"
    # When User should perform login with valid email and invalid password
    # User should verify the Toastbar message after performed login with valid email and invalid password 'Incorrect password'
    # User must verify the Inactive user data "The client facility is inactive. For more information, please contact the administrator"

  Scenario: To verify Xealei Login page by click the ENTER key with valid credentials
    When User should perform login with valid email and password by click the Enter key
    Then User should verify once the page is navigated to HOME_DASHBOARD successfully "Home"


  Scenario: To verify Xealei Login page with valid credentials
    When User should perform login with valid email and password
    Then User should verify once the page is navigated to HOME_DASHBOARD successfully "Home"
