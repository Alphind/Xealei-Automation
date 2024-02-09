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
    
    