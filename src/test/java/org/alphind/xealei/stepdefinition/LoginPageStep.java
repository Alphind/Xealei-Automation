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
import io.cucumber.java.en.When;

public class LoginPageStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Given("User is on Xealei login page")
	public void user_is_on_xealei_login_page() {
		
		logStep(methodName());
		
		}

	@When("User should verify the tab url address for login page")
	public void user_should_verify_the_tab_url_address_for_login_page() {

		logStep(methodName());
		
		try {
			String environment = getConfigureProperty("Environment");
			switch (environment) {
			case "QA": {
				Assert.assertEquals("Login page url is wrong", readExcel("Test Datas", "Environments", 1, 1) + "login",
						getCurrentUrl());
				log(Status.PASS, "Tab URL Address verified - Login using QA - " + getCurrentUrl());

				break;
			}
			case "PREPROD": {
				Assert.assertEquals("Login page url is wrong", readExcel("Test Datas", "Environments", 2, 1) + "login",
						getCurrentUrl());
				log(Status.PASS, "Tab URL Address verified - Login using PREPROD - " + getCurrentUrl());
				break;
			}
			case "PROD": {
				Assert.assertEquals("Login page url is wrong", readExcel("Test Datas", "Environments", 3, 1) + "login",
						getCurrentUrl());
				log(Status.PASS, "Tab URL Address verified - Login using PROD - " + getCurrentUrl());
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

	@Then("User should verify the {string} text is displayed")
	public void user_should_verify_the_text_is_displayed(String expText) {

		logStep(methodName());
		try {

			Assert.assertEquals("Header Name (LOGIN) Text is Missing/Not displayed", expText,
					getText(pom.getLoginPage().getLoginTextVerification()));

			log(Status.PASS, "LOGIN text is displayed in Login Page - "
					+ getText(pom.getLoginPage().getLoginTextVerification()));

			System.out.println(
					"verify_the_login_text_is_displayed - " + getText(pom.getLoginPage().getLoginTextVerification()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("User should verify the field label name and placeholder text for Email and Password fields")
	public void user_should_verify_the_field_label_name_and_placeholder_text_for_email_and_password_fields()
			 {


		logStep(methodName());
		
		String email = getText(pom.getLoginPage().getUNMandatoryVerification());

		String password = getText(pom.getLoginPage().getPassMandatoryVerification());

		System.out.println(email);
		System.out.println(password);

		if (email.contains("Email *") && password.contains("Password *")) {

			log(Status.PASS, "Email and Password field label contains * symbol");
			System.out.println("UN and Password fields name contains * symbol");
		} else {
			System.out.println("* symbol is missing : Expected * but was - " + email + ", " + password);
			log(Status.FAIL, "* Symbol is missing : Expected * but was - " + email + ", " + password);
			System.err.println("[ERROR] >>>> * Symbol is missing : Expected * but was - " + email + "," + password);
		}

		try {
			Assert.assertEquals("Email field placeholder text Name Mismatched", "Email",
					getAttribute(pom.getLoginPage().getUserName(), "placeholder"));

			log(Status.PASS, "Email field placeholder text is displayed - "
					+ getAttribute(pom.getLoginPage().getUserName(), "placeholder"));

			System.out.println("verify_the_email_textbox_contains_text - "
					+ getAttribute(pom.getLoginPage().getUserName(), "placeholder"));

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("Password field placeholder text Name Mismatched", "Password",
					getAttribute(pom.getLoginPage().getPassword(), "placeholder"));

			log(Status.PASS, "Password field placeholder text is displayed - "
					+ getAttribute(pom.getLoginPage().getPassword(), "placeholder"));

			System.out.println("verify_the_password_textbox_contains_text - "
					+ getAttribute(pom.getLoginPage().getPassword(), "placeholder"));

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@When("User should enter password in password field")
	public void user_should_enter_password_in_password_field() {

		logStep(methodName());
		pom.getLoginPage().password();
	}

	@Then("User should verify that entered password is **hide")
	public void user_should_verify_that_entered_password_is_hide()  {

		logStep(methodName());
		String passwordType = getAttribute(pom.getLoginPage().getPassword(), "type");
		boolean passwordField = "password".equalsIgnoreCase(passwordType);

		if (passwordField) {

			log(Status.PASS, "Password is **hide");
			System.out.println("Password is hide");
		} else {
			log(Status.FAIL, "Entered Password is still not visible after click the eye icon");
			System.err.println("[ERROR] >>>> Entered Password is still not visible after click the eye icon");
		}

	}

	@Then("User should click the eye icon in the Password field")
	public void user_should_click_the_eye_icon_in_the_password_field() {

		logStep(methodName());
		
		if (pom.getLoginPage().getEyeShow().isDisplayed()) {
			pom.getLoginPage().eyeIcon(); 
			waitForPageLoad();
		} else {
			log(Status.FAIL, "Unable to click eye iconin password field ");
			System.err.println("[ERROR] >>>> Unable to click eye icon in password field");
		}

	}

	@Then("User should verify that entered password is Unhide")
	public void user_should_verify_that_entered_password_is_unhide()  {

		logStep(methodName());
		
		String passwordType = getAttribute(pom.getLoginPage().getPassword(), "type");
		boolean passwordField = "text".equalsIgnoreCase(passwordType);

		if (passwordField) {

			log(Status.PASS, "Password is visible");
			System.out.println("Password is visible");
		} else {
			log(Status.FAIL, "Entered Password is still **hide after click the eye icon");
			System.err.println("[ERROR] >>>> Entered Password is still **hide after click the eye icon");
		}

		// deleteUsingSendKeys(pom.getLoginPage().getPassword());
		// log(Status.INFO, "Delete the entered password");
	}

	@Then("User should verify Forget password link is working")
	public void user_should_verify_forget_password_link_is_working() {

		logStep(methodName());
		
		if (pom.getLoginPage().getForgotPasswordHyperLink().isEnabled()) {
			pom.getLoginPage().forgotPasswordHyperLink(); 
			
			try {
				Assert.assertTrue(pom.getLoginPage().getForgotPassword().isDisplayed());
				log(Status.PASS, "Navigate to Forgot Password Page");
				pageBackward();
				log(Status.INFO, "Back to Login page");
			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}
		} else {
			log(Status.FAIL, "Unable to click Forget password? textlink");
			System.err.println("[ERROR] >>>> Unable to click Forget password? textlink");
		}
	}

	@Then("User should verify the copy rights {string} text is displayed")
	public void user_should_verify_the_copy_rights_text_is_displayed(String expCopyRightsTxt) {

		logStep(methodName());
		
		scrollDownToBottomOfThePage();

		try {
			Assert.assertEquals("Copyrights text is mismatched", expCopyRightsTxt,
					getText(pom.getLoginPage().getBottomText()));

			log(Status.PASS,
					"Copyrights text is presented in login page -" + getText(pom.getLoginPage().getBottomText()));
		} catch (AssertionError e) {

			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@When("User should click the privacy policy link")
	public void user_should_click_the_privacy_policy_link() {

		logStep(methodName());
		
		if (pom.getLoginPage().getLnkPrivacyPolicy().isEnabled()) {
			pom.getLoginPage().privacyPolicyTextLink();      
		} else {
			log(Status.FAIL, "Unable to click the privacy policy textlink ");
			System.err.println("[ERROR] >>>> Unable to click the privacy policy link");
		}
	}

	@Then("User should verify {string} popup should be displayed after click the Privacy Policy link")
	public void user_should_verify_popup_should_be_displayed_after_click_the_privacy_policy_link(String expPPText) {

		logStep(methodName());
		
		try {
			Assert.assertEquals("Privacy policy content is not displayed", expPPText,
					getText(pom.getLoginPage().getPrivacyPolicyContent()));
			log(Status.PASS, "Privacy Policy content screen is displayed");

			System.out.println("Exp PP Text - " + expPPText);
			System.out.println("Act PP Text - " + getText(pom.getLoginPage().getPrivacyPolicyContent()));

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Given("User should enter password in password field and click login button")
	public void user_should_enter_password_in_password_field_and_click_login_button() {

		logStep(methodName());
		pom.getLoginPage().password();
		pom.getLoginPage().loginButton();

	}

	@Then("User should verify the error message contains email field {string}")
	public void user_should_verify_the_error_message_contains_email_field(String expErrMsgForEmailField)
			 {

		logStep(methodName());
		waitForPageLoad();
		try {
			Assert.assertEquals("Validation Msg under Email* field is not displayed as expected",
					expErrMsgForEmailField, getText(pom.getLoginPage().getErrorMessageForEmail()));

			log(Status.PASS, "Validation Msg is displayed - " + getText(pom.getLoginPage().getErrorMessageForEmail()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should enter email in email field and click login button")
	public void user_should_enter_email_in_email_field_and_click_login_button() {

		logStep(methodName());
		
		deleteExistFieldData(pom.getLoginPage().getPassword());
		log(Status.INFO, "Delete the entered password in password* field");
		pom.getLoginPage().email();
		pom.getLoginPage().loginButton();

	}

	@Then("User should verify the error message contains password field {string}")
	public void user_should_verify_the_error_message_contains_password_field(String expErrMsgForPasswordField)
			 {

		logStep(methodName());
		
		waitForPageLoad();

		try {
			waitForInVisiblityOfElement(pom.getLoginPage().getErrorMessageForPassword(), 5);
			Assert.assertEquals("Validation Msg under Password* field is not displayed as expected",
					expErrMsgForPasswordField, getText(pom.getLoginPage().getErrorMessageForPassword()));
			log(Status.PASS, "Validation Msg for Password* field is displayed - "
					+ getText(pom.getLoginPage().getErrorMessageForPassword()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("User should click login button without enter username and password")
	public void user_should_click_login_button_without_enter_username_and_password() {

		logStep(methodName());
		
		deleteExistFieldData(pom.getLoginPage().getUserName());
		log(Status.INFO, "Delete the entered email/userName in Email* field");

		pom.getLoginPage().loginButton();

	}

	@Then("User should verify the error message contains for both email and password after click the Login button {string} and {string}")
	public void user_should_verify_the_error_message_contains_for_both_email_and_password_after_click_the_login_button_and(
			String expErrMsgForEmailField, String expErrMsgForPasswordField)  {

		logStep(methodName());
		
		waitForPageLoad();
		try {
			Assert.assertEquals("Validation Msg under Email* field is not displayed as expected",
					expErrMsgForEmailField, getText(pom.getLoginPage().getErrorMessageForEmail()));
			log(Status.PASS, "Validation Msg for Email* field is displayed - "
					+ getText(pom.getLoginPage().getErrorMessageForEmail()));
			Assert.assertEquals("Validation Msg under Password* field is not displayed as expected",
					expErrMsgForPasswordField, getText(pom.getLoginPage().getErrorMessageForPassword()));
			log(Status.PASS, "Validation Msg for Password* field is displayed - "
					+ getText(pom.getLoginPage().getErrorMessageForPassword()));

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
		pom.getLoginPage().loginButton();

	}

	@Then("User should verify the error message after performed login with invalid data {string}")
	public void user_should_verify_the_error_message_after_performed_login_with_invalid_data(String expUNFErrorMessage)
			 {

		logStep(methodName());
		
		waitForPageLoad();
		try {
			Assert.assertEquals("User Not Found-Toastbar msg is not displayed as expected", expUNFErrorMessage,
					getText(pom.getLoginPage().getUserNotFoundErrorMessage()));
			log(Status.PASS, "User Not Found-Toastbar msg text is displayed - "
					+ getText(pom.getLoginPage().getUserNotFoundErrorMessage()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		if (pom.getLoginPage().getToastMsgOkButton().isEnabled()) {
			log(Status.INFO, "User Not Found toastbar OK button is enabled");
			pom.getLoginPage().ToastMsgOkButton();
			log(Status.PASS, "User Not Found toastbar is closed by clicking ok button");
			System.out.println("Toastbar is closed by clicking ok button");
		} else {
			log(Status.FAIL, "Toastbar ok button is not working");
			System.err.println("[ERROR] >>>> Toastbar ok button is not working");
		}

//		try {
//			Assert.assertFalse("Assert Fail", pom.getLoginPage().getUnknownErrorToastMsg().isDisplayed());
//			log(Status.PASS, "Unknown Toast Msg is NOT diplayed");
//
//		} catch (AssertionError e) {
//			log(Status.FAIL,e.getMessage());
//			e.printStackTrace();
//			
//		} catch (NoSuchElementException e1) {
//			log(Status.INFO, "No Unknown error Toast msg is displayed");
//			e1.getMessage();
//		}

	}

	@When("User should perform login with valid email and invalid password")
	public void user_should_perform_login_with_valid_email_and_invalid_password()  {

		logStep(methodName());
		
		deleteExistFieldData(pom.getLoginPage().getUserName());
		log(Status.INFO, "Delete the entered email/userName");
		deleteExistFieldData(pom.getLoginPage().getPassword());
		log(Status.INFO, "Delete the entered Password");

		pom.getLoginPage().validEmail(1);
		pom.getLoginPage().password();
		pom.getLoginPage().loginButton();

	}

	@Then("User should verify the Toastbar message after performed login with valid email and invalid password {string}")
	public void user_should_verify_the_toastbar_message_after_performed_login_with_valid_email_and_invalid_password(
			String expIncorrectPassToastMsg) {

		logStep(methodName());
		
		waitForPageLoad();

		try {
			Assert.assertEquals("Incorrect Password-validation is Missing", expIncorrectPassToastMsg,
					getText(pom.getLoginPage().getIncorrectPasswordErrorMessage()));

			log(Status.PASS, "Incorrect Password toast Message text is displayed - "
					+ getText(pom.getLoginPage().getIncorrectPasswordErrorMessage()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		if (pom.getLoginPage().getToastMsgOkButton().isEnabled()) {
			log(Status.INFO, "Toastbar OK button is enabled");
			pom.getLoginPage().ToastMsgOkButton(); 
			log(Status.PASS, "Incorrect Password toastbar is closed by clicking ok button");
			System.out.println("Incorrect Password-validation Toastbar is closed by clicking ok button");
		} else {
			log(Status.FAIL, "Toastbar ok button is not working");
			System.err.println("[ERROR] >>>> Toastbar ok button is not working");
		}

//	try {
//			Assert.assertFalse("Assert Fail", pom.getLoginPage().getUnknownErrorToastMsg().isDisplayed());
//			log(Status.PASS, "Unknown Toast Msg is NOT diplayed");
//
//		} catch (AssertionError e) {
//			log(Status.FAIL,e.getMessage());
//			e.printStackTrace();
//			
//		} catch (NoSuchElementException e1) {
//			log(Status.INFO, "No Unknown error Toast msg is displayed");
//			e1.getMessage();
//		}

	}

	@When("User should perform login with valid email and password by click the Enter key")
	public void user_should_perform_login_with_valid_email_and_password_by_click_the_enter_key() {

		logStep(methodName());
		
		pom.getLoginPage().validEmail(1);
		pom.getLoginPage().validPassword(1);

		try {
			clickEnter(pom.getLoginPage().getLoginButton());
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@When("User should perform login with valid email and password")
	public void user_should_perform_login_with_valid_email_and_password(){

		logStep(methodName());
		
		pom.getLoginPage().validEmail(1);
		pom.getLoginPage().validPassword(1);
		pom.getLoginPage().loginButton();

	}

}
