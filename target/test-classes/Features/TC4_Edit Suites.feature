#/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.
#
#* created by Mohamed Razul
#
#* reviewed by Hajira Begam
#
#* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement
#
#*/
@EditSuites-AllScenarios
Feature: Verify Xealei Suites > Edit Suites Page

  Background: 
    Given User is on Xealei login page
    When User should perform login with valid email and password
    Then User should verify once the page is navigated to HOME_DASHBOARD successfully "Home"
    And User should verify the Suite Module is working
    Then User should verify suite page tab url address for suites page
    Then User should search the created suite
    Then User should verify the Edit Suite button is working
    Then User should verify the Edit Suite pop up screen is displayed

  Scenario: To verify the buttons functionality and error validation and info messages in Edit Suite Page
    Then User should verify the limit error info message for Suite Name* field "Suite Name must be minimum 3 characters" in edit suite page
    Then User should verify the Edit Suite form for mandatory "Please Enter Suite Name"
    Then User should verify duplicate validation for Suite name "Suite Name already exists." in edit suite page
    Then User should verify the x icon in edit suite screen is working
    Then User should verify the user able to change the status as InActive and is displayed accordingly on update of Availability field in Edit screen

  #Scenario: To verify the data formats and field limits validation messages in Suites > Edit Suite Page
  #Then User should verify the field 'Suite Name' for limit in edit suite page
  #Then User should verify the field 'Length' for limit in edit suite page
  #Then User should verify the field 'Breadth' for limit in edit suite page
  #Then User should verify the field 'Height' for limit in edit suite page
  #Then User should verify the field 'Length' for limit with decimal point in edit suite page
  #Then User should verify the field 'Breadth' for limit with decimal point in edit suite page
  #Then User should verify the field 'Height' for limit with decimal point in edit suite page
  

  Scenario: To verify user able to Edit/Update Suites by entering all fields also verify the 'Bread Crums' link in Edit Suite Page
    And User should update all fields and verify the toast message after update all fields "Saved Successfully!!" in edit Suite Page
    Then User should verify all fields are created successsfully in edit Suite Page
    Then User should verify the breadcrums link should be display with module suite name > selected suite name in edit suite page
    Then User should verify after click the breadcrums link it should be return to Suite searched page in edit suite page
