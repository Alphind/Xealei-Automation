#/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.
#
#* created by Mohamed Razul
#
#* reviewed by Hajira Begam
#
#* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement
#
#*/

@OccupancyZoneSuites-Regression
@Suites-AllScenarios
Feature: Verify Xealei Suites > Add Suites Page

  
  Scenario: To verify the buttons functionality and error validation and info messages in Add Suite Page
    
    Given User is on Xealei login page
    When User should perform login with valid email and password
    Then User should verify once the page is navigated to HOME_DASHBOARD successfully "Home"
    And User should verify the Occupancy Zone Module is working
    Then User should verify the Suite Module is working
    Then User should verify suite page tab url address for suites page
    And User should clicks on the Add Suite button and verifies that the Add Suite popup screen is displayed
    Then User should verify the limit error info message for Suite Name* field "Suite Name must be minimum 3 characters"
    Then User should verify the field Suite Name * is mandatory "Please Enter Suite Name"
    And User should verify duplicate validation for Suite name "Suite Name already exists."
    And User should perform only non-mandatory fields and verify the info message contains for Mandatory fields "Please Enter Suite Name"
    Then User should verify the field Suite Name* for limit
    Then User should verify the field Length* for limit
    Then User should verify the field Width* for limit
    Then User should verify the field Height* for limit
    Then User should verify the field Length* for limit with decimal point
    Then User should verify the field Width* for limit with decimal point
    Then User should verify the field Height* for limit with decimal point
    Then User should verify the x icon in add suites screen is working
    Then User should verify for Zero Search result in Add Suites search field
  
   Scenario: To verify whether NOTE info is displayed after adding maximum suite set by super Admin. 
    Given User is on Xealei login page
    When User should perform login to check suite limit with valid email and password 
    Then User should verify once the page is navigated to HOME_DASHBOARD successfully "Home"
    And User should verify the Occupancy Zone Module is working
    Then User should verify the Suite Module is working
    And User should perform suite by entering only Mandatory field to check suite limit
    
    
    Scenario: To verify user able to Add/Create Suites by perform only mandatory field
    Given User is on Xealei login page
    When User should perform login with valid email and password
    Then User should verify once the page is navigated to HOME_DASHBOARD successfully "Home"
    And User should verify the Occupancy Zone Module is working
    Then User should verify the Suite Module is working
    Then User should verify suite page tab url address for suites page
    And User should clicks on the Add Suite button and verifies that the Add Suite popup screen is displayed
    And User should perform suite by entering only Mandatory field
    
@SanityTesting
  Scenario: To verify user able to Add/Create Suites by entering all fields also verify the 'Bread Crums' link
    Given User is on Xealei login page
    When User should perform login with valid email and password
    Then User should verify once the page is navigated to HOME_DASHBOARD successfully "Home"
    And User should verify the Occupancy Zone Module is working
    Then User should verify the Suite Module is working
    Then User should verify suite page tab url address for suites page
    And User should clicks on the Add Suite button and verifies that the Add Suite popup screen is displayed
    And User should perform all fields and verify the toast message after perform all fields "Saved Successfully!!"
    And User should search the created suite by performed all fields
    Then User should verify all fields are created successsfully
    Then User should verify the breadcrums link should be display with module suite name > selected suite name
    Then User should verify after click the breadcrums link it should be return to Suite searched page
    
    
    
