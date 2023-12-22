Feature: Verify Incident Report Form creation via manually & via fall alert notification by  Facility Admin, Staff, Chief Nurse and Resident Manager

#@IR-AllScenarios
#Scenario Outline: To verify IR form creation via manual by "<adminName>"

    #Given User is on Xealei login page
    #When User should perform login as facility admin "<userName>" and "<password>"
    #Then User should verify once the page is navigated to HOME_DASHBOARD successfully "Home"
    #Then User should also verify the performed login as "<adminName>"
    #Then User should verify the Incident report module is working
    #Then User should verify the ADD New Incident Report button is working
    
    
    
    
    
    
    #Then User should verify the save button is disabled
    #And User should perform upto was injured? field
    #Then User should verify Save button is working in IR Page
    #Then User should verify the toast message after click Save button in IR Page "Saved Successfully"
    #Then User should verify the respective individual report status "Draft"
    #Then User should verify the view button is working in IR Grid 
    #Then User should verify the error message in Incident Report Page "Note: Fill out the required fields using the edit option if you would like to submit or complete the report"
    #Then User should verify the edit button is working in IR submission page    
    #Then User should verify the mandatory info message in Incident Report page
    #Then User should verify the injury question section should display with selected individual name in field  "Was" "individual name" "injured?" 
    #
 #
 #
    #And User should click on the calendar icon in Event Date & Time field
    #Then User should verify the date & time picker is appeared
    #And User should select a valid date in date picker and verify the selected date should be displayed in Event Date & Time field
    #Then User should verify future dates are hidden in date & time picker
    #And User should select the Event Date & Time greater than current time
    #Then User should validation info message is thrown under Event time for selecting  greater than current time of current date "Given time exceeds the current time"
    #When User should click on the up arrow to navigate to the previous month and verify the calendar should display the previous months dates
    #And User should select a specific year and month in dropdown and select the date and verify the selected date are updated accordingly
    #Then User should verify the selected date, month and year using dropdown is updated in Event Date & Time field accordingly
    #And User should click on the down arrow to navigate to the current month and verify the calendar should display the current months dates
    #Then User should verify that able to enter date and time in Event Date & Time field
    #Then User should verify the Event Date & Time calendar is close after click outside the calendar
#
    #
    #
    #Then User should verify the tool tip message is displayed on mouse over on Injury site front & Back view
    #Then User should verify that able to spot the injury on Injury site front & Back view
    #Then User should verify the toast message after try to upload JFIF Format "JFIF format is not supported"
    #Then User should verify the toast message after try to upload more than 1MB File format "File(1) size should be less than 1 MB"
    #Then User should verify the user are able to attach image / file    
    #Then User should verify the delete icon is working on image under injury photo field 
    #
    #
    #Then User should verify that whether user able to select options under Injury Type field
    #Then User should verify that whether user able to selecting multiple option values under Injury Type field
    #Then User should verify that whether user able to unselect the selected option values under Injury Type field
    #Then User should verify that whether user able to select the option value under How severe was injury? field 
    #Then User should verify that whether user able to select the option value under Injury Color
    #Then User should verify that whether default optional values is selected under was Event Notified?
     #
     #
    #And User should click on the calendar icon
    #Then User should verify the date picker should appeared
    #And User should select a valid date in date picker and verify the selected date should be displayed in the DOB * field
    #And User should verify future dates are hidden
    #When User should click on the left arrow to navigate to the previous month and verify the calendar should display the previous months dates
    #And User should select a specific year and month in dropdown and select the date in date picker and verify the selected DOB are updated accordingly
    #Then User should verify the selected date, month and year using dropdown is updated in DOB* field accordingly
    #And User should click on the right arrow to navigate to the current month and verify the calendar should display the current months dates
    #Then User should verify the calendar should close after click outside the calendar
    #
    #
    #
    #Then User should verify the validation info message is thrown after selecting Notification Time field value is lesser than Event Date & Time field value
    #Then User should verify the validation info message is thrown after selecting greater than current time in Notification Time field "Notified time should be after than event time"
    #Then User should verify that able to enter time in Notification Time field
    #Then User should verify that after click the breadcrum text Report the page is navigated to the list of incident Reports page
    #Then User should verify the edit button is working in IR Grid 
    #Then User should verify the breadcrum text
    #Then User should verify Next > button is working in IR Page
    #Then User should verify the breadcrums texts
    #Then User should verify all the created details are displayed as expected?
    #Then User should verify that after click the breadcrum text Report the page is navigated to the list of incident Reports page
    #Then User should verify the view button is working in IR Grid 
    #
    #
    #
    #
    #Then User should verify that after click the breadcrum text Report the page is navigated to the list of incident Reports page
   
   
    
     #Examples:
     #     |userName | password    | adminName 			|
     #     |VVStf    | Alphind@123 | Staff     			|
     #     |VVCn     | Alphind@123 | Chief Nurse			|
     #     |VPRM     | Alphind@123 | Resident Manager|
    
    
Scenario Outline: To verify an Incident report can be approved by all levels of users.

		Given User is on Xealei login page.
		When User is login into Xealei application as Staff role user with valid <username> and <passowrd>.
		Then Verify Home page is displayed.
		Then Navigate to Reports module.
		And Navigate to Incident Report sub module.
		Then Click on Add New Incident Report button.
		And Verify Incident report page is displayed.
		And Select the individual for whom the incident report has to be created.
		Then Enter all the details of the Incident.
		Then Click on next button.
		When Incident report page is displayed verify whether all the data is displayed correctly.
		And Click on complete button.
		And Verify whether the report is in pending status.
		Then Launch a new browser and enter xealei url.
		And Login into Xealei application as Cheif nurse role with valid <username> and <passowrd>.
		Then Verify whether notification is received.
		And Approve the report.
		And Verify whether the report is in "" status.
		Then Launch a new browser and enter xealei url.
		And Login into Xealei application as Residential Manager role with valid <username> and <passowrd>.
		Then Verify whether notification is received.
		And Approve the report.
		And Verify whether the report is in "" status.
		Then Launch a new browser and enter xealei url.
		And Login into Xealei application as CLinical Coordinator role with valid <username> and <passowrd>.
		Then Verify whether notification is received.
		And Approve the report.
		And Verify whether the report is in "" status.
		And Login into Xealei application as Social Worker role with valid <username> and <passowrd>.
		Then Verify whether notification is received.
		And Approve the report.
		And Verify whether the report is in "" status.
		
		
Scenario Outline: To verify whether cheif nurse can able to reject and reapprove the incident Report.
     
    Given User is on Xealei login page.
		When User is login into Xealei application as Staff role user with valid <username> and <passowrd>.
		Then Verify Home page is displayed.
		Then Navigate to Reports module.
		And Navigate to Incident Report sub module.
		Then Click on Add New Incident Report button.
		And Verify Incident report page is displayed.
		And Select the individual for whom the incident report has to be created.
		Then Enter all the details of the Incident.
		Then Click on next button.
		When Incident report page is displayed verify whether all the data is displayed correctly.
		And Click on complete button.
		And Verify whether the report is in pending status.
		Then Launch a new browser and enter xealei url.
		And Login into Xealei application as Cheif nurse role with valid <username> and <passowrd>.
		Then Verify whether notification is received.
		And Deny the report.
		Then Switch to Staff login and check whether sent back comments are available.
		And Again submit the report.
		Then Switch to cheif nurse login and approve the incident report.   
     
Scenario Outline: To verify whether residential manager can able to reject and reapprove the incident Report. 
		Given User is on Xealei login page.
		When User is login into Xealei application as Staff role user with valid <username> and <passowrd>.
		Then Verify Home page is displayed.
		Then Navigate to Reports module.
		And Navigate to Incident Report sub module.
		Then Click on Add New Incident Report button.
		And Verify Incident report page is displayed.
		And Select the individual for whom the incident report has to be created.
		Then Enter all the details of the Incident.
		Then Click on next button.
		When Incident report page is displayed verify whether all the data is displayed correctly.
		And Click on complete button.
		And Verify whether the report is in pending status.
		Then Launch a new browser and enter xealei url.
		And Login into Xealei application as Cheif nurse role with valid <username> and <passowrd>.
		Then Verify whether notification is received.
		And Approve the report.
		And Verify whether the report is in "" status.
		Then Launch a new browser and enter xealei url.
		And Login into Xealei application as Residential Manager role with valid <username> and <passowrd>.
		Then Verify whether notification is received.
		And Deny the report.
		Then Switch to cheif nurse login and check whether sent back comments are available.
		And Again submit the report.
		Then Switch to Residential Manager login and approve the incident report.    
    
    
    
    