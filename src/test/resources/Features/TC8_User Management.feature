# /**
#  * Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.
#  * You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization
#  * is prohibited without prior and proper license agreement
#  *
#  * created by Nandhalala
#  *
#  *
# */

@All
Feature: User Management
	
	@Validations
  Scenario: To verify field validations in User Management screen while creating a New User.
    Given User is on Xealei login page
    When User is login as facility admin.
    Then User should verify once the page is navigated to HOME_DASHBOARD successfully "Home"
    And Verify User Management module is available.
    Then Navigate to User Management Page.
    And Click on Create New user button.
    Then Click Next and verify Validations for FirstName, LastName and Role field.
    Then Verify limit of the firstname, middlename and lastname field.
    Then Verify user is unable to upload image of size higher than 1MB.
    Then Verify user is unable to upload unsupported formats.
    Then Verify user able to upload supported format.
    And Validate phone number and Email field with invalid data and click next.
    Then Enter valid data in all the fields of basic details.
    Then Click Basic details page next button.
    Then Check validation for phone number for emergency contact 1 and emergency contact 2.
    Then Click Next button and validate tostr message.
    And Enter Valid Data in all the Contact Details page.
    Then Click back button in contact details and verify whether basic details page is displayed.
    Then Click Contact Details Next button.
    And Enter Invalid data in date fields of Qualification page.
    Then Enter valid data in all the fields of Qualification page.
    And Click back button in qualification page and verify whether contact details page is displayed.
    
    @CreateNewUserWithoutEmail
    @CreateNewUserFromBasicDetailsPage
    Scenario: To verify able to create an User without Email.
    	Given User is on Xealei login page
    	When User is login as facility admin.
    	Then User should verify once the page is navigated to HOME_DASHBOARD successfully "Home"
    	And Verify User Management module is available.
    	Then Navigate to User Management Page.
    	And Click on Create New user button.
    	Then Enter valid mandatory data in all fields of basic details.
    	And Click basic details create button.
    	Then Verify the status of the created user is in pending status.
    	Then Verify the menu contains show QR Code option.
    
    
    @CreateNewUserWithEmail
    Scenario: To verify able to create an User with Email.
    	Given User is on Xealei login page
    	When User is login as facility admin.
    	Then User should verify once the page is navigated to HOME_DASHBOARD successfully "Home"
    	And Verify User Management module is available.
    	Then Navigate to User Management Page.
    	And Click on Create New user button.
    	Then Enter valid data in all the fields of basic details.
    	Then Open Mailinator aplication.
    	And Click basic details create button.
    	Then Verify the status of the created user is in pending status.
    	Then Verify the menu contains show QR Code and Resend invite options.
    	And Click xealei url from mail and login into application as new user.
    	Then Verify the status of the created user is in active status.
    	Then Verify the menu options for created user.
    	Then Verify whether all the fields are editable in edit mode.
    	Then Edit any field and click cancel button.
    	And Verify able to save the edited data.
    	Then Search the created user and verify view info.
    
    @CreateNewUserFromContactDetailsPage
    Scenario: To verify able to create in contact details page.
    	Given User is on Xealei login page
    	When User is login as facility admin.
    	Then User should verify once the page is navigated to HOME_DASHBOARD successfully "Home"
    	And Verify User Management module is available.
    	Then Navigate to User Management Page.
    	And Click on Create New user button.
    	Then Enter valid mandatory data in all fields of basic details.
    	Then Click Basic details page next button.
    	Then Click Create and send invite from contact details page.
    	
    	@CreateNewUserFromQualificationDetailsPage
    Scenario: To verify able to create in contact details page.
    	Given User is on Xealei login page
    	When User is login as facility admin.
    	Then User should verify once the page is navigated to HOME_DASHBOARD successfully "Home"
    	And Verify User Management module is available.
    	Then Navigate to User Management Page.
    	And Click on Create New user button.
    	Then Enter valid mandatory data in all fields of basic details.
    	Then Click Basic details page next button.
    	Then Click Contact Details Next button.
    	Then Click Create and send invite from qualification page.
    	
    