/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* Created by Mohamed Razul S

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.stepdefinition;

import org.alphind.xealei.baseclass.BaseClass;
import org.alphind.xealei.pom.PageObjectManager;
import org.junit.Assert;

import com.aventstack.extentreports.Status;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager(getDriver());

	@When("User should verify the client code is addressed in tab url address in login screen")
	public void user_should_verify_the_client_code_is_addressed_in_tab_url_address_in_login_screen() throws Exception {

		logStep(methodName());

		try {
			String environment = getConfigureProperty("Environment");
			switch (environment) {
			case "QA": {
				Assert.assertEquals("Login page url is wrong", readExcel("Test Datas", "Environments", 1, 1) + "login",
						getCurrentUrl());
				log(Status.INFO, "Tab URL Address verified - Login using QA - " + getCurrentUrl());

				break;
			}
			case "PREPROD": {
				Assert.assertEquals("Login page url is wrong", readExcel("Test Datas", "Environments", 2, 1) + "login",
						getCurrentUrl());
				log(Status.INFO, "Tab URL Address verified - Login using PREPROD - " + getCurrentUrl());
				break;
			}
			case "PROD": {
				Assert.assertEquals("Login page url is wrong", readExcel("Test Datas", "Environments", 3, 1) + "login",
						getCurrentUrl());
				log(Status.INFO, "Tab URL Address verified - Login using PROD - " + getCurrentUrl());
				break;
			}
			default: {
				break;
			}
			}
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}


	@Then("User should verify the field label name and placeholder text for Email and Password fields")
	public void user_should_verify_the_field_label_name_and_placeholder_text_for_email_and_password_fields() {

		logStep(methodName());
		
		waitForFullPageElementLoad();
		
		if (pom.getLoginPage().getEmailMandatoryFieldLabelText().contains("Email *") && pom.getLoginPage().getPassMandatoryFieldLabelText().contains("Password *")) {

			log(Status.PASS, "Email and Password field Lable names are displayed - " +pom.getLoginPage().getEmailMandatoryFieldLabelText() +" | "+pom.getLoginPage().getPassMandatoryFieldLabelText());
		} else {
			log(Status.FAIL, "Email and Password field Lable names are NOT displayed as expected - " + pom.getLoginPage().getEmailMandatoryFieldLabelText() + ", " + pom.getLoginPage().getPassMandatoryFieldLabelText());
		}

		try {
			
			Assert.assertEquals("Email field placeholder text Name Mismatched", "Email", pom.getLoginPage().getUserNameFieldAttributeValue("placeholder"));

			log(Status.PASS, "Email field Placeholder text is displayed - " + pom.getLoginPage().getUserNameFieldAttributeValue("placeholder"));

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("Password field placeholder text Name Mismatched", "Password",pom.getLoginPage().getPasswordFieldAttributeValue("placeholder"));

			log(Status.PASS, "Password field placeholder text is displayed - "+ pom.getLoginPage().getPasswordFieldAttributeValue("placeholder"));

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@And("User should enter password in password field")
	public void user_should_enter_password_in_password_field() {

		logStep(methodName());
		pom.getLoginPage().password();
	}

	@Then("User should verify that entered password is **hide")
	public void user_should_verify_that_entered_password_is_hide() {

		logStep(methodName());
		
		boolean passwordField = "password".equalsIgnoreCase(pom.getLoginPage().getPasswordFieldAttributeValue("type"));

		if (passwordField) {

			log(Status.PASS, "Password is **hide");
			System.out.println("Password is hide");
		} else {
			log(Status.FAIL, "Entered Password is still not visible after click the eye icon");
			System.err.println("[ERROR] >>>> Entered Password is still not visible after click the eye icon");
		}

	}

	@Then("User should verify that entered password is Unhide after click the eye icon")
	public void user_should_verify_that_entered_password_is_unhide_after_click_the_eye_icon() {

		logStep(methodName());

		if (pom.getLoginPage().isEyeIconInPasswordFieldIsDisplayed()) {
			pom.getLoginPage().eyeIcon();
			
		} else {
			log(Status.FAIL, "Unable to click eye iconin password field ");
			System.err.println("[ERROR] >>>> Unable to click eye icon in password field");
		}

		boolean passwordField = "text".equalsIgnoreCase(pom.getLoginPage().getPasswordFieldAttributeValue("type"));

		if (passwordField) {

			log(Status.PASS, "Password is visible");
			System.out.println("Password is visible");
		} else {
			log(Status.FAIL, "Entered Password is still **hide after click the eye icon");
			System.err.println("[ERROR] >>>> Entered Password is still **hide after click the eye icon");
		}
	}


	@Then("User should verify that email and password fields are mandatory {string}, {string}")
	public void user_should_verify_that_email_and_password_fields_are_mandatory(String expErrMsgForEmailField, String expErrMsgForPasswordField) {
	   
		logStep(methodName());

		try {
			Assert.assertEquals("Validation Msg under Email* field is not displayed as expected", expErrMsgForEmailField, pom.getLoginPage().getEmailMFInfoMessageText());

			log(Status.PASS, "Validation Msg under Email* field is displayed - " + pom.getLoginPage().getEmailMFInfoMessageText());
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		pom.getLoginPage().deleteExistingPasswordFieldData();
		
		try {
			Assert.assertEquals("Validation Msg under Password* field is not displayed as expected",
					expErrMsgForPasswordField, pom.getLoginPage().getPasswordMFInfoMessageText());
			log(Status.PASS, "Validation Msg for Password* field is displayed as " +pom.getLoginPage().getPasswordMFInfoMessageText());
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}


	@When("User should perform login with invalid data")
	public void user_should_perform_login_with_invalid_data() {

		logStep(methodName());
		
		pom.getLoginPage().email();
		pom.getLoginPage().password();
	}

	@Then("User should verify the error message after performed login with invalid data {string}")
	public void user_should_verify_the_error_message_after_performed_login_with_invalid_data(
			String expUNFErrorMessage) {

		logStep(methodName());

		waitForPageLoad();
		
		try {
			
			Assert.assertEquals("User Not Found-Toastbar msg is not displayed as expected", expUNFErrorMessage,	pom.getLoginPage().getUserNotFoundErrorMessageText());
			log(Status.PASS, "User Not Found-Toastbar msg text is displayed - "	+ pom.getLoginPage().getUserNotFoundErrorMessageText());
			
			pom.getLoginPage().ToastMsgOkButton();
			
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	
	}

	@When("User should perform login with valid email and invalid password")
	public void user_should_perform_login_with_valid_email_and_invalid_password() {

		logStep(methodName());

		pom.getLoginPage().deleteExistingEmailFieldData();
		pom.getLoginPage().validEmail(1);

	}

	@Then("User should verify the Toastbar message after performed login with valid email and invalid password {string}")
	public void user_should_verify_the_toastbar_message_after_performed_login_with_valid_email_and_invalid_password(
			String expIncorrectPassToastMsg) {

		logStep(methodName());

		waitForPageLoad();
		
		try {

			Assert.assertEquals("Incorrect Password-validation is Missing", expIncorrectPassToastMsg, pom.getLoginPage().getIncorrectPasswordErrorMessageText());

			log(Status.PASS, "Incorrect Password toast Message text is displayed - " + pom.getLoginPage().getIncorrectPasswordErrorMessageText());

			pom.getLoginPage().ToastMsgokButton();

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@When("User should perform login with valid email and password by click the Enter key")
	public void user_should_perform_login_with_valid_email_and_password_by_click_the_enter_key() {

		logStep(methodName());

		pom.getLoginPage().validEmail(1);
		pom.getLoginPage().validPassword(1);
		pom.getLoginPage().pressEnterKeyInPasswordField();
		
	}

	@When("User should perform login with valid email and password")
	public void user_should_perform_login_with_valid_email_and_password() {

		logStep(methodName());

		pom.getLoginPage().validEmail(1);
		pom.getLoginPage().validPassword(1);
		pom.getLoginPage().loginButton();

	}

}
