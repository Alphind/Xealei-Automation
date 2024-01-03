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

import io.cucumber.java.en.Then;

public class CommonSteps extends BaseClass {

	PageObjectManager pom = new PageObjectManager(driver);

	@Then("User should verify once the page is navigated to HOME_DASHBOARD successfully {string}")
	public void user_should_verify_once_the_page_is_navigated_to_home_dashboard_successfully(String expMessage) {

		logStep(methodName());
		
		waitForPageLoad();
//		try {
//			Assert.assertFalse("Assert Fail", pom.getLoginPage().getUnknownErrorToastMsg().isDisplayed());
//			log(Status.PASS, "Unknown Toast Msg is NOT diplayed");
//			
//		} catch (AssertionError e) {
//			log(Status.FAIL, "Unknown error Toast msg is displayed | Error :" +e);
//			e.getMessage();
//			System.err.println("[ERROR] - Unknown Toast Msg is Diplayed [Toast Message] >>>  Unknown Error.Please contact administrator for more information.");
//		} catch (NoSuchElementException e1) {
//			AddIndividualsPage.javalog(Status.INFO, "No Unknown error Toast msg is displayed");
//			e1.getMessage();
//		}

		System.out.println("exp Text :" + expMessage);
		System.out.println("Actual Text :" + getText(pom.getLoginPage().getNavToHomePageSuccessfully()));
		try {
			Assert.assertEquals("Unable to navigate HOME Dashboard", expMessage,
					getText(pom.getLoginPage().getNavToHomePageSuccessfully()));
			log(Status.PASS, "Navigate to Home Dashboard Page");
		} catch (AssertionError e) {
			log(Status.FAIL, "Unable to navigate HOME Dashboard Page");
		}
	}
	
}