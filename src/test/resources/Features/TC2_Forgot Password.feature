#/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.
#
#* created by Mohamed Razul
#
#* reviewed by 
#
#* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization   * is prohibited without prior and proper license agreement
#
#*/

Feature: Verify Xealei Forgot Page

@FP
  Scenario Outline: To verify the Xealei FORGOT PASSWORD-POP UP Page
    Given User is on Xealei login page
    And User should verify Forget password link is working
    Then User must verify the tab url address for FORGOT PASSWORD screen
    Then User must verify the Forgot Password text is displayed "FORGOT PASSWORD"
    Then User must verify the Lable name & Place holder text for Email field
    Then User must click  the Reset button without perform Email field and verify the info message is displayed "Email is required"
    #BUG
    Then User must verify the Email field for formats "Please enter a valid email address"
    Then User must verify the Email field with invalid data "Email ID not exist"
    Then User must verify the email field for unregistered user "Email ID not exist"
    Then User must verify the email for blocked user
    Then User must verify the email for Inactive user
    Then User must verify the email field with valid data
    Then User must verify the email sent successfully content
    Then User must verify the Try Again text link is working
    Then User must verify the login button in forgot password screen
    






















  Scenario Outline: To verify the Reset password email field with invalid format
    Given User is on Xealei login page
    When User must click the forgot password? hyperlink
    And User must verify once the page is navigate to forgot password page successfully "FORGOT PASSWORD"
    Then User must also verify the web url after successfully navigate to forgot password page
    And User must perform reset password with invalid data format
    

  Scenario Outline: To verify the Reset password email field with invalid data
    Given User is on Xealei login page
    When User must click the forgot password? hyperlink
    And User must verify once the page is navigate to forgot password page successfully "FORGOT PASSWORD"
    Then User must also verify the web url after successfully navigate to forgot password page
    And User must perform reset password with invalid data
    Then User must verify after click Reset button the error msg should displayed "Email ID not exist"

  Scenario Outline: To verify the Login hyperlink
    Given User is on Xealei login page
    When User must click the forgot password? hyperlink
    And User must verify once the page is navigate to forgot password page successfully "FORGOT PASSWORD"
    Then User must also verify the web url after successfully navigate to forgot password page
    And User must click the Login hyperlink
    And User must verify once the page is redirected to login page successfully "LOGIN"
    Then User must also verify the web url after successfully redirected to login page

  Scenario Outline: To verify Reset password field with valid data
    Given User is on Xealei login page
    When User must click the forgot password? hyperlink
    And User must verify once the page is navigate to forgot password page successfully "FORGOT PASSWORD"
    Then User must also verify the web url after successfully navigate to forgot password page
    And User must perform forgot password with valid mail id
    Then User must verify the success message pop up is displayed "EMAIL SENT!"

  Scenario Outline: To verify the success message pop contents after Reset the Password
    Given User is on Xealei login page
    When User must click the forgot password? hyperlink
    And User must verify once the page is navigate to forgot password page successfully "FORGOT PASSWORD"
    Then User must also verify the web url after successfully navigate to forgot password page
    And User must perform forgot password with valid mail id
    Then User must verify the success message pop up is displayed "EMAIL SENT!"
    Then User must also verify the content for create a new password

  Scenario Outline: To verify the Try agin hyperlink
    Given User is on Xealei login page
    When User must click the forgot password? hyperlink
    And User must verify once the page is navigate to forgot password page successfully "FORGOT PASSWORD"
    Then User must also verify the web url after successfully navigate to forgot password page
    And User must perform forgot password with valid mail id
    Then User must verify the success message pop up is displayed "EMAIL SENT!"
    And User must click the Try again hyperlink
    Then User must verify the page is redirected to forgot password page successfully "FORGOT PASSWORD"
    
  Scenario Outline: To verify the Users Mail for Reset the Password
  
  
