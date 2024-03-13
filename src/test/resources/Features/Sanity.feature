#/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.
#
#* created by Mohamed Razul
#
#* reviewed by Hajira Begam
#
#* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement
#
#*/
@Sanity
Feature: Xealei Application

  Background: 
    Given User is on Xealei login page

  Scenario: To verify the Login to IR Process
  
    Given User is on Xealei login page
    When User should perform login with valid email and password
    Then User should verify once the page is navigated to HOME_DASHBOARD successfully "Home"
    
    And User should verify the Occupancy Zone Module is working
    Then User should verify the Suite Module is working
    And User should clicks on the Add Suite button and verifies that the Add Suite popup screen is displayed
    And User should perform all fields and verify the toast message after perform all fields "Saved Successfully!!"
    And User should search the created suite by performed all fields
    Then User should verify all fields are created successsfully

    And User should clicks on the Edit Suite button and verifies that the Edit Suite screen is displayed
    And User should update all fields and verify the toast message after update all fields "Saved Successfully!!" in edit Suite Page
    Then User should verify all fields are updated successsfully in edit Suite Page
    
    And User should verify the Occupancy Zone Module is working
    Then User should verify the Common Area Module is working
    And User should clicks on the Add Common Area button and verifies that the Add Common Area popup screen is displayed
    And User should perform all fields in common area page and verify the toast message after perform all fields "Saved Successfully!!"
    And User should search the created Common Area by performed all fields
    Then User should verify all fields are created successsfully in common area page
    
    And User should clicks on the Edit button and verifies that the Edit Common Area popup is displayed
    And User should update all fields and verify the toast message after update all fields "Updated Successfully!!" in Edit Common Area popup Page
    Then User should verify all fields are updated successsfully in Edit Common Area popup Page
    
    And User should verify the Individuals Module is working
    And User should click on the Add Individual button and verify the 'New Individual Registration' pop up screen is displayed
    And User should upload image in photo tab section
    And User should perform all fields in Identification tab section
    Then User should verify the first, middle, last and dob is displayed in Address tab section
    And User should perform all fields in Address tab section
    And User should perform all fields in Preference tab section
    Then User should verify the First, middle and last name, dob, residential & mailing address and Phone Number are displayed in confirm form
    And User should click the confirm button
    Then User should verify the toast messgage "Individual Saved Successfully"
    Then User should verify the Individual ID and Created successfull Image are displayed
    And User should click Go to Individuals button
    Then User should verify the page is landed on Individual’s screen
    Then User should verify that individuals are created successfully by perform all fields
    
    And User should add Vitals info by entering all fields
    Then User should verify the toast messgage "Vitals updated successfully" after perform vitals tab
    Then User should verify that vitals are created successfully by perform all fields
    
    And User should navigate to personal information tab
    
    And User should update all fields and verify the toast message after perform all fields "Individual personal info updated successfully" in edit individual Page
    Then User should verify all fields are updated successsfully in edit individual Page
    
    And User should update all fields in vitals tab
    Then User should verify the toast messgage "Vitals updated successfully" after perform vitals tab
    Then User should verify all fields are updated successsfully in vitals Page
    
    Then User should verify the Incident report module is working
    Then User should verify the ADD New Incident Report button is working
    And Select the individual for whom the incident report has to be created.
    Then Enter all the details of the Incident.
    Then Click on next button.
    And Click on complete button.
    And Verify whether the report is in pending status.
    Then Launch a new browser and enter xealei url for Chief nurse.
    And Login into Xealei application as Chief nurse role with valid "<ChiefNurseUserName>" and "<ChiefNursePassWord>".
    Then Open notification received by Chief nurse.
    And Approve the report by Chief Nurse user.
    And Verify whether the report is in "In Progress" status by Chief Nurse user.
    Then Launch a new browser and enter xealei url for residential manager.
    And Login into Xealei application as Residential Manager role with valid "<RMUserName>" and "<RMPassWord>".
    Then Open notification received by residential manager.
    And Approve the report by Residential Manager user.
    And Verify whether the report is in "In Progress" status by Residential Manager user.
    Then Launch a new browser and enter xealei url for clinical coordinator.
    And Login into Xealei application as CLinical Coordinator role with valid "<CCUserName>" and "<CCPassWord>".
    Then Open notification received by Clinical Coordinator.
    And Approve the report by Clinical Coordinator user.
    And Verify whether the report is in "In Progress" status by Clinical Coordinator user.
    Then Launch a new browser and enter xealei url for social worker.
    And Login into Xealei application as Social Worker role with valid "<SWUserName>" and "<SWPassWord>".
    Then Verify whether notification received by Social Worker.
    And Approve the report by Social Worker user.
    And Verify whether the report is in "Finalized" status by Social Worker user.
    Then Close all the browsers.
    
    
    When Notification is Triggered from a sensor.
    Then Open notification received by staff from sensor.
    Then Select fall radio button and enter description.
    Then Click Save and Proceed to IR button.
    Then Verify text in what casued the fall matches with Description.
    Then Enter all the details of the Incident.
    Then Click on next button.
    And Click on complete button.
    And Verify whether the report is in pending status.
    Then Launch a new browser and enter xealei url for Chief nurse.
    And Login into Xealei application as Chief nurse role with valid "<ChiefNurseUserName>" and "<ChiefNursePassWord>".
    Then Open notification received by Chief nurse.
    And Approve the report by Chief Nurse user.
    And Verify whether the report is in "In Progress" status by Chief Nurse user.
    Then Launch a new browser and enter xealei url for residential manager.
    And Login into Xealei application as Residential Manager role with valid "<RMUserName>" and "<RMPassWord>".
    Then Open notification received by residential manager.
    And Approve the report by Residential Manager user.
    And Verify whether the report is in "In Progress" status by Residential Manager user.
    Then Launch a new browser and enter xealei url for clinical coordinator.
    And Login into Xealei application as CLinical Coordinator role with valid "<CCUserName>" and "<CCPassWord>".
    Then Open notification received by Clinical Coordinator.
    And Approve the report by Clinical Coordinator user.
    And Verify whether the report is in "In Progress" status by Clinical Coordinator user.
    Then Launch a new browser and enter xealei url for social worker.
    And Login into Xealei application as Social Worker role with valid "<SWUserName>" and "<SWPassWord>".
    Then Verify whether notification received by Social Worker.
    And Approve the report by Social Worker user.
    And Verify whether the report is in "Finalized" status by Social Worker user.
    Then Close all the browsers.
