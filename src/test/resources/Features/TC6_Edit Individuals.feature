#/** Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.
#
#* created by Mohamed Razul
#
#* reviewed by Hajira Begam
#
#* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement
#
#*/

@EditIndividuals-AllScenarios
Feature: Verify Xealei Individuals > Edit Individual Page

 Background: 
    Given User is on Xealei login page
    When User should perform login with valid email and password
    Then User should verify once the page is navigated to HOME_DASHBOARD successfully "Home"
    And User should verify the Individuals Module is working
    Then User should search the created Individual
    Then User should verify the name dob id guardian contact details is displayed
    
     
  Scenario: To verify the validation messages for limit and mandatory fields in Edit Individuals page
  
  Then User should verify the breadcrums link should be display with module individual name > selected individual name in edit individual page
  Then User should verify the tab section name "Personal Information" and "Vitals"
  And User should click the Edit button
  Then User should verify the breadcrums link should be display with module individual name > Edit individual
  Then User should verify the Update and Cancel button is enabled
  And User should update existing phone number in emergency contact1
  Then User should verify the error message for duplicate Mobile Number '"Individual already exist with same phone number"'
  And User should delete all the fields and perform update
  Then User should verify the Required field toast message "Please provide valid data / Enter all required fields"
  Then User should verify the validation message for Mandatory fields "Please enter first name", "Please enter last name", "Please select gender", "Please enter dob", "Please select suite", "Please enter residential address", "Please enter mailing address", "Please enter emergency contact first name", "Please enter emergency contact last name", "Please select emergency contact relationship", "Please enter valid emergency contact number"
  Then User should verify the limit validation error message for First, Middle and Last Name* fields "First name cannot be longer than 30 characters", "Middle name cannot be longer than 30 characters", "Last name cannot be longer than 30 characters"
  Then User should verify the limit validation error message in Emergency Contact1 First, Last Name* fields "First name cannot be longer than 30 characters" and "Last name cannot be longer than 30 characters"
   And User should click Add another emergency contact
  Then User should verify the emergency contact label names in edit individual page
  And User should perform update without enter any fields in emergency 
  Then User should verify the Required field toast message "Please provide valid data / Enter all required fields"
  Then User should verify the mandatory field validation error info message in Emergency Contact2 "Please enter emergency contact first name", "Please enter emergency contact last name", "Please select emergency contact relationship", "Please enter valid emergency contact number"  
  Then User should verify the limit validation error message in Emergency Contact2 First, Last Name* fields "First name cannot be longer than 30 characters" and "Last name cannot be longer than 30 characters"
  And User should click Add another emergency contact
  And User should perform firstName* and lastName* fields in Add another emergency contact3 in edit individual page
  Then User should verify the limit validation error message in Emergency Contact3 First, Last Name* fields "First name cannot be longer than 30 characters" and "Last name cannot be longer than 30 characters"
  Then User should verify the that able to close the emergency contact2 and emergency contact3 in edit individual page  
  And User should click on the calendar icon in edit individual page
  Then User should verify the date picker should appeared
  And User should select a valid date in date picker and verify the selected date should be displayed in the DOB * field
    #
    #DELETE
    # When User should attempt to enter an invalid date manually
    # Then an appropriate error message should be displayed
    #DELETE
    #
  And User should verify future dates are hidden
  When User should click on the left arrow to navigate to the previous month and verify the calendar should display the previous months dates
  And User should select a specific year and month in dropdown and select the date in date picker and verify the selected DOB are updated accordingly
  Then User should verify the selected date, month and year using dropdown is updated in DOB* field accordingly
  And User should click on the right arrow to navigate to the current month and verify the calendar should display the current months dates
  Then User should verify the calendar should close after click outside the calendar
  Then User should verify the cancel button is working in edit individual page
  Then User should verify after click the breadcrums link module name should be return to searched Individual page
  And User should navigate to created individual
  And User should navigate to vitals tab and click add vitals button in edit individual page
  Then User should verify the breadcrums link should be display with module individual name > Edit individual
  And User should perform update with empty fields in vitals tab
 # Then User should verify the Required field toast message "Please provide valid data / Enter all required fields"
  Then User should verify the Mandatory fields info messages in vitals tab "Please select Blood Group", "Please enter blood pressure", "Please enter blood glucose", "Please enter cholesterol", "Please enter height", "Please enter weight"
  Then User should verify the valid format Mandatory fields info messages in vitals tab "Blood pressure format should be (120/80)", "Please enter valid blood glucose", "Please enter valid cholesterol", "Please enter valid height", "Please enter valid weight"
  Then User should verify that able to upload more than 1MB file in medical record
    And User should upload medical record in edit vital tab section 
  Then User should verify that able to cancel the uploaded record file in edit vitals tab section
  Then User should verify the cancel button is working in vitals tab


   Scenario: To verify user able to Edit/Update Individuals and Vitals by entering all fields
   
    And User should update all fields and verify the toast message after perform all fields "Individual personal info updated successfully" in edit individual Page
    Then User should verify all fields are updated successsfully in edit individual Page
    And User should update all fields in vitals tab
    Then User should verify the toast messgage "Vitals updated successfully" after perform vitals tab
    Then User should verify all fields are updated successsfully in vitals Page

   