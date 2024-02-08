/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.stepdefinition;

import org.alphind.xealei.baseclass.BaseClass;
import org.alphind.xealei.pom.PageObjectManager;
import org.junit.Assert;

import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CommonSteps extends BaseClass {

	PageObjectManager pom = new PageObjectManager(getDriver());

	@Given("User is on Xealei login page")
	public void user_is_on_xealei_login_page() {
		
		try {
		Assert.assertTrue("User is NOT in Xealei login page",pom.getLoginPage().isImageIsDisplayed().isDisplayed());
        log(Status.PASS,"User is on Xealei login page");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
		}
	}
	
	@Then("User should verify once the page is navigated to HOME_DASHBOARD successfully {string}")
	public void user_should_verify_once_the_page_is_navigated_to_home_dashboard_successfully(String expMessage) {

		logStep(methodName());

		System.out.println("exp Text :" + expMessage);
		System.out.println("Actual Text :" + pom.getHomePage().HomeText());
		
		try {
			Assert.assertEquals("Unable to navigate HOME Dashboard", expMessage, pom.getHomePage().HomeText());
					
			log(Status.PASS, "Successfully Navigate to Home Dashboard Page");
		} catch (AssertionError e) {
			log(Status.FAIL, "Unable to navigate HOME Dashboard Page");
		}
	}
	
}