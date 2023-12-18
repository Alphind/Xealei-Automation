package org.alphind.xealei.stepdefinition;

import org.alphind.xealei.baseclass.BaseClass;
import org.alphind.xealei.pom.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class IncidentReportPageStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();
	
	

	@When("User should perform login as facility admin {string} and {string}")
	public void user_should_perform_login_as_facility_admin (String userName, String password) {

			logStep(methodName());
			
//			pom.getLoginPage().validEmail(1);
//			pom.getLoginPage().validPassword(1);
//			pom.getLoginPage().loginButton();
//            waitForPageLoad();
			
			sendKeys(pom.getLoginPage().getUserName(),userName );
			sendKeys(pom.getLoginPage().getPassword(),password );
			pom.getLoginPage().loginButton();
			waitForPageLoad();
			
		}


			@Then("User should also verify the performed login as {string}")
			public void user_should_also_verify_the_performed_login_as (String adminName) {
			   
				String text = getText(pom.getHomePage().getAdminName());
				
			Assert.assertEquals("Login page url is wrong", adminName , text);
			System.out.println("EXP Value" +adminName);
			System.out.println("ACT Value" +text);
				
			}

			
			@Then("User should verify the Incident report module is working")
			public void user_should_verify_the_incident_report_module_is_working() {


				
			}
			
			
			@Then("User should verify the ADD New Incident Report button is working")
			public void user_should_verify_the_add_new_incident_report_button_is_working() {


			}



		
}
