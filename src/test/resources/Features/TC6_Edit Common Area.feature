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
@EditCommonArea-AllScenarios
@RegressionTesting
Feature: Verify Xealei Suites > Edit Suites Page

  Background: 
    Given User is on Xealei login page
    When User should perform login with valid email and password
    Then User should verify once the page is navigated to HOME_DASHBOARD successfully "Home"
    And User should verify the Occupancy Zone Module is working
    Then User should verify the Common Area Module is working
    Then User should verify common area page tab url address
    And User should search the created common area
    And User should clicks on the Edit button and verifies that the Edit Common Area popup is displayed
    

  Scenario: To verify the buttons functionality and error validation and info messages in Edit Common Area popup
  Then User should verify the limit error info message for Common Area Name * field "Common area name must be minimum 3 characters" in edit common area popup page
    And User should verify duplicate validation for Common Area Name "Common Area Name already exists" in edit common area popup page
    And User should perform only non-mandatory fields in Edit Common Area popup and verify the info message contains for Mandatory fields "Please enter common area name"
    Then User should verify whether able to close the popup by clicking x icon
    Then User should verify the breadcrums link should be display with module Common Area Name > Created Common Area name in edit Common Area page
    Then User should verify after click the breadcrums link it should be return to Common Area searched page
  
  
  #Scenario: To verify the data formats and field limits validation messages in Common Area > Edit Common Area
  #Then User should verify the field 'Common Area Name' for limit in edit common area
  #Then User should verify the field 'Length' for limit in edit common area
  #Then User should verify the field 'Breadth' for limit in edit common area
  #Then User should verify the field 'Height' for limit in edit common area
  #Then User should verify the field 'Length' for limit with decimal point in edit common area
  #Then User should verify the field 'Breadth' for limit with decimal point in edit common area
  #Then User should verify the field 'Height' for limit with decimal point in edit common area
  
  
 @SanityTesting
  Scenario: To verify user able to Edit/Update Common Area by entering all fields also verify the 'Bread Crums' link in Edit Common Area popup Page.
    And User should update all fields and verify the toast message after update all fields "Updated Successfully!!" in Edit Common Area popup Page
    Then User should verify all fields are updated successsfully in Edit Common Area popup Page
  