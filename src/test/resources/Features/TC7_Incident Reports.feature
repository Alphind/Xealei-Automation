Feature: Verify Incident Report Form creation via manually & via fall alert notification by  Facility Admin, Staff, Chief Nurse and Resident Manager

 @NegativeScenarios
  Scenario Outline: To verify IR form creation via manual by "<adminName>"
    Given User is on Xealei login page
    When User should perform login as facility admin "<userName>" and "<password>"
    Then User should verify once the page is navigated to HOME_DASHBOARD successfully "Home"
    Then User should also verify the performed login as "<adminName>"
    Then User should verify the Incident report module is working
    Then User should verify the ADD New Incident Report button is working
    Then User should verify the save button is disabled
    Then User should verify Next > button is working
    Then User should verify the validation info message under all fields "Please select the individual details", "Please choose event on", "Please enter fall caused", "Please choose was injured", "Please enter fall description", "Please select injury site", "Please enter treatment received", "Please enter future treatment", "Please select the injury type", "Please select injury color", "Please choose was the injury serve", "Please enter person notify", "Please choose relationship", "Please choose notify date", "Please choose time", "Please enter notified by"
    Then User should verify Save button is working in IR Page after perform Individuals Details and Event Date & Time fields
    Then User should verify the toast message after click Save button in IR Page "Saved Successfully"
    Then User should verify the respective individual report status "Draft"
    Then User should verify the view button is working in IR Grid
    Then User should verify the error message in Incident Report Page "Note: Fill out the required fields using the edit option if you would like to submit or complete the report"
    Then User should verify the complete button is disabled
    Then User should verify the edit button is working in IR submission page
    Then User should verify the injury question section should display with selected individual name in field
    
    #And User should click on the calendar icon in Event Date & Time field
    #Then User should verify the date & time picker is appeared
    #And User should select a valid date in date picker and verify the selected date should be displayed in Event Date & Time field
    #Then User should verify future dates are hidden in date & time picker
    
    And User should enter the Event Date & Time greater than current time
    Then User should validation info message is thrown under Event time for selecting  greater than current time of current date "Given time exceeds the current time"   
   
    #When User should click on the up arrow to navigate to the previous month and verify the calendar should display the previous months dates
    #And User should select a specific year and month in dropdown and select the date and verify the selected date are updated accordingly
    #Then User should verify the selected date, month and year using dropdown is updated in Event Date & Time field accordingly
    #And User should click on the down arrow to navigate to the current month and verify the calendar should display the current months dates
    #Then User should verify the Event Date & Time calendar is close after click outside the calendar
    #Then User should verify the tool tip message is displayed on mouse over on Injury site front & Back view
    
    Then User should verify that able to spot the injury on Injury site front & Back view
    Then User should verify that able to unselect the injury on Injury site front & Back view
    
    ##ISSUE FACING##
    #Then User should verify that able to upload upload JFIF Format
    
    Then User should verify that able to upload more than 1MB File format
    Then User should verify that able to upload files or images
    Then User should verify the delete icon is working on image under injury photo field
    Then User should verify that whether able to selecting multiple option values under Injury Type field
    Then User should verify that whether able to unselect the selected option values under Injury Type field
    Then User should verify that whether able to select the option value under How severe was injury? field
    Then User should verify that whether able to select the option value under Injury Color
    Then User should verify that whether default optional values is selected under was Event Notified?
    Then User should verify that able to enter current date and time in Event Date & Time field
    And  User should click on the Notification Date calendar icon
    Then User should verify the date picker should appeared
    Then User should verify that the Notification Date calendar field only allows selecting dates from the event date and time to the current date
    And  User should select a notified date using dropdown in date picker and verify the selected notified date are updated accordingly
   #NOT IMPLEMENTED
   #Then User should verify the validation info message is thrown after selecting Notification Time field value is lesser than Event Date & Time field value "Notified time should be after than event time"
    Then User should verify the validation info message is thrown after selecting greater than current time in Notification Time field "Notified time should be after than event time"
    Then User should verify that able to enter time in Notification Time field
    Then User should verify that after click the breadcrum text Report the page is navigated to the list of incident Reports page
    Then User should verify the edit button is working in IR Grid
    Then User should verify that the IR form continues to display the previously entered draft datas
    Then User should verify the breadcrum text
    And  User should perform all the fields
    Then User should verify all the created details are displayed as expected
    Then User should verify the breadcrums texts

    Examples: 
      | userName | password | adminName |
      | AStaff   | auto@123 | Staff     |
    
   
@AllApprove
Scenario Outline: To verify an Incident report can be approved by all levels of users.

		Given User is on Xealei login page
    When User should perform login as staff "<StaffUserName>" and "<StaffPassWord>"
    Then User should verify once the page is navigated to HOME_DASHBOARD successfully "Home"
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
		
		Examples:
		
		|StaffUserName| |StaffPassWord| |ChiefNurseUserName| |ChiefNursePassWord| |RMUserName| |RMPassWord| |CCUserName| |CCPassWord| |SWUserName| |SWPassWord|
		
		|AStaff| 				|auto@123| 			|AChief_Nu| 				 |auto@123| 					|AManager| 	 |auto@123| 	|AClinical|  |auto@123| 	|ASWorker| 	|auto@123|
		
@RejectAndReapprovebyChiefNurse		
Scenario Outline: To verify whether Chief nurse can able to reject and reapprove the incident Report.

    Given User is on Xealei login page
    When User should perform login as staff "<StaffUserName>" and "<StaffPassWord>"
    Then User should verify once the page is navigated to HOME_DASHBOARD successfully "Home"
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
		And Re-Send the report by Chief Nurse user to staff nurse.
		Then Switch back to staff user login.
		And Open notification received by staff.
		Then ReSubmit the Report by staff user.
		Then Open notification received by Chief nurse.
		And Approve the report by Chief Nurse user.
		Then Close all the browsers.
		
		Examples:
      | StaffUserName |  | StaffPassWord |  | CheifNurseUserName |  | CheifNursePassWord |  | RMUserName |  | RMPassWord |  | CCUserName |  | CCPassWord |  | SWUserName |  | SWPassWord |
      | AStaff        |  | auto@123      |  | AChief_Nu          |  | auto@123           |  | AManager   |  | auto@123   |  | AClinical  |  | auto@123   |  | ASWorker   |  | auto@123   |

  
@RejectAndReapprovebyResidentialManager   
Scenario Outline: To verify whether residential manager can able to reject and reapprove the incident Report. 
		Given User is on Xealei login page
    When User should perform login as staff "<StaffUserName>" and "<StaffPassWord>"
    Then User should verify once the page is navigated to HOME_DASHBOARD successfully "Home"
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
		And Re-Send the report by Residential Manager user.
		And Verify whether the report is in "Sent Back" status by Residential Manager user.
		Then Switch back to staff user login.
		And Open notification received by staff.
		Then ReSubmit the Report by staff user.
		Then Open notification received by Chief nurse.
		And Approve the report by Chief Nurse user.
		Then Open notification received by residential manager.
		And Approve the report by Residential Manager user.
		And Verify whether the report is in "In Progress" status by Residential Manager user.
		Then Close all the browsers.
    
Examples:    
    
   |StaffUserName| |StaffPassWord| |ChiefNurseUserName| |ChiefNursePassWord| |RMUserName| |RMPassWord| |CCUserName| |CCPassWord| |SWUserName| |SWPassWord|
		
		|AStaff| 				|auto@123| 			|AChief_Nu| 				 |auto@123| 					|AManager| 	 |auto@123| 	|AClinical|  |auto@123| |ASWorker| |auto@123|
