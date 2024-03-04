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
@Login-Regression
Feature: Verify Xealei Login Page

  Background: 
    Given User is on Xealei login page
    
    
    Scenario: To verify the login validations
  
    And User should verify the client code is addressed in tab url address in login screen
    And User should check that the label name and placeholder text for the Email field
    And User should check if the eye icon in the Password field is working
    And User enter invalid password and verify the toast message is displayed "Incorrect password"
    And User should perform login with invalid data and verify the toast message is displayed "User not found"
    And User should verify that the fields for email and password are mandatory "Please enter email ID", "Please enter password"
    
  Scenario: To verify Xealei Login page by click the ENTER key with valid credentials
    When User should perform login with valid email and password by click the Enter key
    Then User should verify once the page is navigated to HOME_DASHBOARD successfully "Home"

@SanityTesting
  Scenario: To verify Xealei Login page with valid credentials
    When User should perform login with valid email and password
    Then User should verify once the page is navigated to HOME_DASHBOARD successfully "Home"
