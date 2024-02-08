#/** Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.
#
#* created by Mohamed Razul
#
#* reviewed by Hajira Begam
#
#* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement
#
#*/

@AddIndividuals-AllScenarios
Feature: Verify Xealei Individuals > Add Individual Page

  Background: 
    Given User is on Xealei login page
    When User should perform login with valid email and password
    Then User should verify once the page is navigated to HOME_DASHBOARD successfully "Home"
    And User should verify the Individuals Module is working
    Then User should verify the Add Individual button is working
    Then User should verify the 'New Individual Registration' pop up screen is displayed
    

  Scenario: To verify the validation messages for limit and mandatory fields in Add Individuals page
    Then User should verify the "Upload", "Capture" buttons is enabled in Photo tab Section
    Then User should verify the respective tab text are displayed "Photo", "Identification", "Address", "Preference"
    Then User should verify that able to upload different file formats except jpg, jpeg, png
    Then User should verify that able to upload more than 1MB Image file
    And User should upload image in photo tab section
    Then User should verify the navigation arrows and validation message for Mandatory fields are working as expected "Please enter first name", "Please enter last name", "Please select gender", "Please enter dob", "Please select suite", "Please enter residential address", "Please enter mailing address", "Please enter emergency contact first name", "Please enter emergency contact last name", "Please select emergency contact relationship", "Please enter valid emergency contact number"
    Then User should Add Individual by perform only non mandatory fields
    Then User should verify the Required field toast message "Please provide valid data / Enter all required fields"
    Then User should verify the limit validation error message for First Name* field in identification tab section "First name cannot be longer than 30 characters"
    Then User should verify the limit validation error message for Middle Name* field in identification tab section "Middle name cannot be longer than 30 characters"
    Then User should verify the limit validation error message for Last Name* field in identification tab section "Last name cannot be longer than 30 characters"
    And User should perform only mandatory fields in identification tab
    And User should click on the calendar icon
    Then User should verify the date picker should appeared
    Then User should verify future dates are hidden
    And User should select a valid date in date picker and verify the selected date should be displayed in the DOB * field
    And User should select a specific year and month in dropdown and select the date in date picker
    Then User should verify the selected date, month and year using dropdown is updated in DOB* field accordingly
    And User should click on the right arrow to navigate to the current month and verify the calendar should display the current months dates    
    Then User should click the address tab
    And User should perform Address in Residential Address * field
    And User should tick the Same as Residential address checkbox
    Then User should verify the Residential Address * and Mailing Address * fields values are same
    And User should uncheck the Same as Residential address checkbox
    And User should enter address in Mailing Address * field    
    And User should tick the same as Residential address after entering different address in Mailing address
    Then User should verify the Residential Address * and Mailing Address * fields values are same
    And User should uncheck the Same as Residential address checkbox
    Then User should verify the validation error message for Mailing Address * field "Please enter mailing address"
    And User should delete the Residential Address * field data
    Then User should verify the validation error message for Residential Address * field "Please enter residential address"
    Then User should verify the first, middle, last and dob is displayed in Address tab section
    Then User should verify the first, middle, last name, dob and mailing address are displayed in Preference tab section
    And User should perform Add another emergency contact1
    Then User should verify the limit validation error message in Emergency Contact1 First Name* field "First name cannot be longer than 30 characters"
    Then User should verify the limit validation error message in Emergency Contact1 Last Name* field "Last name cannot be longer than 30 characters"
    And User should click Add another emergency contact
    And User should perform firstName* and lastName* fields in Add another emergency contact2
    Then User should verify the limit validation error message in Emergency Contact2 First Name* field "First name cannot be longer than 30 characters"
    Then User should verify the limit validation error message in Emergency Contact2 Last Name* field "Last name cannot be longer than 30 characters"
    Then User should verify the mandatory field validation error message in Emergency Contact2 "Please enter emergency contact first name", "Please enter emergency contact last name", "Please select emergency contact relationship", "Please enter valid emergency contact number"
    And User should perform all the fields in Emergency Contact2
    And User should click Add another emergency contact
    Then User should verify the emergency contact label names
    And User should perform firstName* and lastName* fields in Add another emergency contact3
    Then User should verify the limit validation error message in Emergency Contact3 First Name* field "First name cannot be longer than 30 characters"
    Then User should verify the mandatory field validation error message in Emergency Contact3 "Please enter emergency contact first name", "Please enter emergency contact last name", "Please select emergency contact relationship", "Please enter valid emergency contact number"
    Then User should able to delete the emergency contact3
    Then User should able to delete the emergency contact2
    Then User should verify the tabticks in Identification, Address and Preference tab sections
    And User should perform emergency contact1 with different phone number
    Then User should verify the error message for duplicate Mobile Number "Individual already exist with same phone number"
    And User should perform Add Individual with different phone number
    Then User should verify the First, middle and last name, DOB, mailing address and Phone Number are displayed in confirm form screen
    And User should close the New Individual Registration popup


 @AddIndividuals-AllScenarios
  Scenario: To verify the user able to Add/Create Individual by entering only mandatory fields
    And User should upload image in photo tab section
    And User should perform only mandatory fields in Identification tab section
    And User should perform only mandatory fields in Address tab section
    Then User should verify the first, middle, last and dob is displayed in Address tab section
    And User should perform only mandatory fields in Preference tab section
    Then User should verify the first, middle, last name, dob and mailing address are displayed in Preference tab section
    Then User should verify the tabticks in Identification, Address and Preference tab sections
    Then User should verify the First, middle and last name, DOB, mailing address and Phone Number are displayed in confirm form screen
    And User should click the confirm button    
    Then User should verify the toast messgage "Individual Saved Successfully"
    Then User should verify the Individual ID and Created successfull Image are displayed
    And User should click Go to Individuals button
    Then User should verify the page is landed on Individual’s screen
    Then User should verify that individuals are created successfully by perform only mandatory fields
    

  Scenario: To verify the user able to Add/Create Individual by entering all fields
  
    And User should upload image in photo tab section
    And User should perform all fields in Identification tab section
    Then User should verify the first, middle, last and dob is displayed in Address tab section
    And User should perform all fields in Address tab section
    And User should perform all fields in Preference tab section
    And User should add another emergency Contact2
    Then User should verify the first, middle, last name, dob residential and mailing address are displayed in Preference tab section
    Then User should verify the tabticks in Identification, Address and Preference tab sections
    Then User should verify the First, middle and last name, dob, residential & mailing address and Phone Number are displayed in confirm form
    And User should click the confirm button
    Then User should verify the error message for duplicate Mobile Number "Individual already exist with same phone number"
    And User should perform emergency contact2 with different phone number
    And User should click the confirm button
    Then User should verify the toast messgage "Individual Saved Successfully"
    Then User should verify the Individual ID and Created successfull Image are displayed
    And User should click Go to Individuals button
    Then User should verify the page is landed on Individual’s screen
    Then User should verify that individuals are created successfully by perform all fields
    And User should navigate to vitals tab and click add vitals button in View Individual page
    Then User should verify the breadcrums link should be display with module individual name > Edit individual
    And User should perform update without enter any fields in vitals tab
    Then User should verify the Required field toast message "Please provide valid data / Enter all required fields"
    Then User should verify the Mandatory fields info messages in vitals tab "Please select Blood Group", "Please enter blood pressure", "Please enter blood glucose", "Please enter cholesterol", "Please enter height", "Please enter weight"
    Then User should verify the valid format Mandatory fields info messages in vitals tab "Blood pressure format should be (120/80)", "Please enter valid blood glucose", "Please enter valid cholesterol", "Please enter valid height", "Please enter valid weight"
    Then User should verify that able to upload more than 1MB file in medical record
    And User should upload medical record in vitals tab section 
    Then User should verify that able to cancel the uploaded record file in vitals tab section
    Then User should verify the cancel button is working in vitals tab
    And User should add Vitals info by entering all fields
    Then User should verify the toast messgage "Vitals updated successfully" after perform vitals tab
    Then User should verify that vitals are created successfully by perform all fields
    
