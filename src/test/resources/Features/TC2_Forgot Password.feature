#/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.
#
#* created by Mohamed Razul
#
#* reviewed by Hajira begam
#
#* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization   * is prohibited without prior and proper license agreement
#
#*/

@ForgotPassword-AllScenario
@Login-Regression
Feature: Verify Xealei Forgot Page


  Scenario Outline: To verify the Xealei Forgot-Popup Page
    Given User is on Xealei login page
    And User should verify Forget password link is working
    Then User must verify the tab url address for FORGOT PASSWORD screen
    Then User must verify the Forgot Password text is displayed "FORGOT PASSWORD"
    Then User must verify the Lable name & Place holder text for Email field
    Then User must click  the Reset button without perform Email field and verify the info message is displayed "Email is required"
    Then User must verify the Email field for formats "Please enter a valid email address"
    Then User must verify the Email field with invalid data "Email ID not exist"
    Then User must verify the email field for unregistered user "Email ID not exist"
    
    #NOT IMPLEMENTED
    #Then User must verify the email for blocked user
    #Then User must verify the email for Inactive user
    
    Then User must verify the email field with valid data
    Then User must verify the email sent successfully content
    Then User must verify the Try Again text link is working
    Then User must verify the login button in forgot password screen
    And User should open the mailinator site for to verify whether the mail is received or not    
    And User should search the existing mail inbox
    And User should verify the content and body of the Forgot mail
    And User should verify the Reset Password link is working in mail.
    Then User should switch to New Password page
    Then User should verify the tab url address for NEW PASSWORD screen
    And User should verify the Label name & Placeholder text for the New Password Re-Enter Password field
    And User should verify whether the fields are mandatory in new password page "Please enter new password", "Please enter confirm password"
    And User should verify that the eye icon is functional in the New Password field
    And User should verify that the new password field must have alphanumeric restriction "New password should be alphanumeric"
    And User should verify whether an error message is displayed if the New Password and Re-Enter Password fields are mismatched "Password is not matched"
    And User should confirm the fields and button with valid data
    Then User should verify the reset password page contents
    And User should verify the Login button on the password reset screen
    And User should perform login with new password and verify once the page is navigated to HOME_DASHBOARD successfully "Home"
    Then User should close the browser
      
