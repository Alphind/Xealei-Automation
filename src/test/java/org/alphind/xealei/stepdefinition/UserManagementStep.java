package org.alphind.xealei.stepdefinition;

import org.alphind.xealei.baseclass.BaseClass;
import org.alphind.xealei.pom.PageObjectManager;

import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserManagementStep extends BaseClass {
	
	PageObjectManager pom = new PageObjectManager(getDriver());
	
	@When("User is login as facility admin.")
	public void User_is_login_as_facility_admin() {
		logStep(methodName());

		pom.getLoginPage().validEmail(1);
		pom.getLoginPage().validPassword(1);
		
		waitForFullPageElementLoad();
		sleep(2000);
		pom.getLoginPage().loginButton();
	}
	
	@Then("Verify User Management module is available.")
	public void Verify_User_Management_module_is_available() {
		logStep(methodName());
		if(pom.getHomePage().isUserManagementPresent()){
			log(Status.PASS, "User Management module is present on Home Screen.");
		}
		else {
			log(Status.FAIL, "User Management Module is not present on home screen");
		}
	}
	
	@Then("Navigate to User Management Page.")
	public void Navigate_to_User_Management_Page() {
		pom.getHomePage().navigateToUserManagementModule();
	}
	
	
}
