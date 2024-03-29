#/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.
#
#* created by Mohamed Razul
#
#* reviewed by Hajira Begam
#
#* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement
#
#*/

@AddCommonArea-AllScenarios
@OccupancyZoneCommonArea-Regression
Feature: Verify Xealei Suites > Add Common Area Page

  Background: 
    Given User is on Xealei login page
    When User should perform login with valid email and password
    Then User should verify once the page is navigated to HOME_DASHBOARD successfully "Home"
    And User should verify the Occupancy Zone Module is working
    Then User should verify the Common Area Module is working
    Then User should verify common area page tab url address
    And User should clicks on the Add Common Area button and verifies that the Add Common Area popup screen is displayed


  Scenario: To verify the buttons functionality and error validation and info messages in Add Common Area popup.
    Then User should verify the limit error info message for Common Area Name * field "Common area name must be minimum 3 characters"
    Then User should verify the field Common Area Name * is mandatory "Please enter common area name"
    And User should verify duplicate validation for Common Area name "Common Area Name already exists"
    And User should perform only non-mandatory fields in common area band verify the info message contains for Mandatory fields "Please enter common area name"
    Then User should verify the field Common Area Name* for limit
    Then User should verify the field Length* for limit
    Then User should verify the field Width* for limit
    Then User should verify the field Height* for limit
    Then User should verify the field Length* for limit with decimal point
    Then User should verify the field Width* for limit with decimal point
    Then User should verify the field Height* for limit with decimal point
    Then User should verify whether able to close the popup by clicking x icon
    Then User should verify for Zero Search result in Add Common Area search field	
    And User should perform Common Area by entering only Mandatory field
  

@SanityTesting
  Scenario: To verify user able to Add/Create Common Area by entering all fields also verify the 'Bread Crums' link
    And User should perform all fields in common area page and verify the toast message after perform all fields "Saved Successfully!!"
    And User should search the created Common Area by performed all fields
    Then User should verify all fields are created successsfully in common area page
    Then User should verify the breadcrums link should be display with module Common Area > Common Area name
    Then User should verify after click the breadcrums link it should be return to Common Area searched page
