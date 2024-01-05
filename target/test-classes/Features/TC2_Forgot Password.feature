#/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.
#
#* created by Mohamed Razul
#
#* reviewed by 
#
#* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement
#
#*/

Feature: Verify Xealei Forgot Page

  Scenario Outline: To verify the web url link for forgot password page
    Given User is on Xealei login page
    When User must click the forgot password? hyperlink
    And User must verify once the page is navigate to forgot password page successfully "FORGOT PASSWORD"
    Then User must also verify the web url after successfully navigate to forgot password page

  Scenario Outline: To verify the image, fields, logo & button
    Given User is on Xealei login page
    When User must click the forgot password? hyperlink
    And User must verify once the page is navigate to forgot password page successfully "FORGOT PASSWORD"
    Then User must also verify the web url after successfully navigate to forgot password page
    Then User must verify the xealei Logo is displayed in forgot page
    Then User must verify the Forgot Password text is displayed in forgot page
    Then User must verify Enter your email text is displayed in forgot page
    Then User must verify the Email field contains * symbol in forgot page
    Then User must verify the Email textbox contains "Enter email" text in forgot page
    Then User must verify the "Reset" text is displayed in Reset button
    Then User must verify the Remember it? text is displayed
    Then User must verify the Login text is displayed
    Then User must verify the copy rights "Powered by Alphind © 2023" text is displayed

  Scenario Outline: To verify the Reset password email field with invalid format
    Given User is on Xealei login page
    When User must click the forgot password? hyperlink
    And User must verify once the page is navigate to forgot password page successfully "FORGOT PASSWORD"
    Then User must also verify the web url after successfully navigate to forgot password page
    And User must perform reset password with invalid data format
    Then User must verify after click Reset button the error msg should displayed under EMAIL as "Please enter a valid email address"

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
  
  
