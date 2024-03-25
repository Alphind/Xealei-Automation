/** Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.stepdefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.alphind.xealei.baseclass.BaseClass;
import org.alphind.xealei.pom.PageObjectManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Then;

public class ForgotPasswordPageStep extends BaseClass {

	private WebDriver mailinatorDriver;

	private PageObjectManager mailinatorpom;

	PageObjectManager pom = new PageObjectManager(getDriver());

	@Then("User should verify Forget password link is working")
	public void user_should_verify_forget_password_link_is_working() {

		logWithLabelName(getMethodName());

		if (pom.getLoginPage().isForgotPasswordLinkDisplayed()) {

			pom.getLoginPage().forgotPasswordHyperLink();

			try {
				Assert.assertTrue(pom.getForgotPasswordPage().isForgotPasswordPageIsDisplayed());
				log(Status.PASS, "Navigate to Forgot Password Page");
			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}

		} else {
			log(Status.FAIL, "Unable to click Forget password? textlink");
			System.err.println("[ERROR] >>>> Unable to click Forget password? textlink");
		}
	}

	@Then("User must verify the tab url address for FORGOT PASSWORD screen")
	public void user_must_verify_the_tab_url_address_for_forgot_password_screen() throws Exception {

		logWithLabelName(getMethodName());

		try {

			String environment = getConfigureProperty("Environment");
			switch (environment) {
			case "QA": {
				Assert.assertEquals("Login page url is wrong",
						readExcel("Test Datas", "Environments", 1, 1) + "login/forgot", getCurrentUrl());
				log(Status.INFO, "Forgot Password tab URL Address verified - " + getCurrentUrl());
              log(Status.PASS, "Forgot Password tab URL Address is displayed as expected | Actual URL - "+getCurrentUrl());
				break;
			}
			case "PREPROD": {
				Assert.assertEquals("Login page url is wrong",
						readExcel("Test Datas", "Environments", 2, 1) + "login/forgot", getCurrentUrl());
				log(Status.INFO, "Forgot Password tab URL Address verified - " + getCurrentUrl());
	              log(Status.PASS, "Forgot Password tab URL Address is displayed as expected | Actual URL - "+getCurrentUrl());
                      break;
			}
			case "PROD": {
				Assert.assertEquals("Login page url is wrong",
						readExcel("Test Datas", "Environments", 3, 1) + "login/forgot", getCurrentUrl());
				log(Status.INFO, "Forgot Password tab URL Address verified - " + getCurrentUrl());
	              log(Status.PASS, "Forgot Password tab URL Address is displayed as expected | Actual URL - "+getCurrentUrl());
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

	@Then("User must verify the Forgot Password text is displayed {string}")
	public void user_must_verify_the_forgot_password_text_is_displayed(String getExpForgotPassTxt) {

		logWithLabelName(getMethodName());

		try {
			Assert.assertEquals("FORGOT PASSWORD text is NOT Displayed as expected", getExpForgotPassTxt,
					pom.getForgotPasswordPage().getForgotPasswordText());
			log(Status.PASS, "FP text is displayed as expected");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User must verify the Lable name & Place holder text for Email field")
	public void user_must_verify_the_lable_name_place_holder_text_for_email_field() {

		logWithLabelName(getMethodName());

		try {

			Assert.assertTrue("Lable name in Email* text is not displayed as expected",
					pom.getForgotPasswordPage().verifyEmailLabelText());
			log(Status.PASS, "Field Lable name is displayed as expected");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {

			Assert.assertTrue("Placeholder text in Email* field is not displayed as expected",
					pom.getForgotPasswordPage().verifyEmailPlaceHolderText());
			log(Status.PASS, "Placeholder text in Email* field is displayed as expected");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("User must click  the Reset button without perform Email field and verify the info message is displayed {string}")
	public void user_must_click_the_reset_button_without_perform_email_field_and_verify_the_info_message_is_displayed(
			String expInfoMsg) {

		logWithLabelName(getMethodName());

		pom.getForgotPasswordPage().resetButton();

		try {
			Assert.assertEquals("Info message is NOT displayed as expected", expInfoMsg,
					pom.getForgotPasswordPage().getInfoMsgText());
			log(Status.PASS, "Info message is displayed as expected Exp Info Text - " + expInfoMsg
					+ " | Actual Info Text - " + pom.getForgotPasswordPage().getInfoMsgText());
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("User must verify the Email field for formats {string}")
	public void user_must_verify_the_email_field_for_formats(String expInfoMsgText) {

		logWithLabelName(getMethodName());

		pom.getForgotPasswordPage().email(1, 0).resetButton();

		try {
			Assert.assertEquals(
					"" + expInfoMsgText
							+ " Info message is NOT displayed as expected after perform invalid email format",
					expInfoMsgText, pom.getForgotPasswordPage().getInfoMsgText());
			log(Status.PASS, "Info message is displayed as expected Exp Info Text - " + expInfoMsgText
					+ " | Actual Info Text - " + pom.getForgotPasswordPage().getInfoMsgText());
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		pom.getForgotPasswordPage().deleteEmailFieldData();
		pom.getForgotPasswordPage().email(2, 0).resetButton();

		// TEMP STEPS
		waitForPageLoad();
		pom.getForgotPasswordPage().toastMsgokButton();

		// *** ISSUE ****

//        try {
//    		Assert.assertEquals(""+expInfoMsgText+" Info message is NOT displayed as expected after perform invalid email format", expInfoMsgText, pom.getForgotPasswordPage().getInfoMsgText());
//    		log(Status.PASS, "Info message is displayed as expected Exp Info Text - "+expInfoMsgText+" | Actual Info Text - "+pom.getForgotPasswordPage().getInfoMsgText());
//    	} catch (AssertionError e) {
//    		log(Status.FAIL, e.getMessage());
//    		e.printStackTrace();
//    	}
	}

	@Then("User must verify the Email field with invalid data {string}")
	public void user_must_verify_the_email_field_with_invalid_data(String expNotFoundToastMsgText) {

		logWithLabelName(getMethodName());

		pom.getForgotPasswordPage().deleteEmailFieldData();
		pom.getForgotPasswordPage().email(2, 0).resetButton();

		try {
			waitForPageLoad();

			Assert.assertEquals(
					"" + expNotFoundToastMsgText
							+ " Toast message is NOT displayed as expected after perform invalid email format",
					expNotFoundToastMsgText, pom.getForgotPasswordPage().getEmailIDNotFoundToastMsgText());
			log(Status.PASS, "Toast message is displayed as expected Exp Text - " + expNotFoundToastMsgText
					+ " | Actual Text - " + pom.getForgotPasswordPage().getEmailIDNotFoundToastMsgText());

			pom.getForgotPasswordPage().toastMsgokButton();

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User must verify the email field for unregistered user {string}")
	public void user_must_verify_the_email_field_for_unregistered_user(String expNotFoundToastMsgText) {

		logWithLabelName(getMethodName());

		pom.getForgotPasswordPage().deleteEmailFieldData();

		pom.getForgotPasswordPage().email(3, 0).resetButton();

		try {

			waitForPageLoad();

			Assert.assertEquals(
					"" + expNotFoundToastMsgText
							+ " Toast message is NOT displayed as expected after perform invalid email format",
					expNotFoundToastMsgText, pom.getForgotPasswordPage().getEmailIDNotFoundToastMsgText());
			log(Status.PASS, "Toast message is displayed as expected Exp Text - " + expNotFoundToastMsgText
					+ " | Actual Text - " + pom.getForgotPasswordPage().getEmailIDNotFoundToastMsgText());

			pom.getForgotPasswordPage().toastMsgokButton();

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("User must verify the email for blocked user")
	public void user_must_verify_the_email_for_blocked_user() {

		logWithLabelName(getMethodName());

	}

	@Then("User must verify the email for Inactive user")
	public void user_must_verify_the_email_for_inactive_user() {

		logWithLabelName(getMethodName());

	}

	@Then("User must verify the email field with valid data")
	public void user_must_verify_the_email_field_with_valid_data() {

		logWithLabelName(getMethodName());

		pom.getForgotPasswordPage().deleteEmailFieldData();

		pom.getForgotPasswordPage().email(1, 1).resetButton();

		try {
			waitForPageLoad();

			String expText = "EMAIL SENT!";
			Assert.assertEquals("Unable to reset the password using valid email address", expText,
					pom.getForgotPasswordPage().getEmailSentVerifyText());
			log(Status.PASS, "Successfully Reset the password using valid email address");

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User must verify the email sent successfully content")
	public void user_must_verify_the_email_sent_successfully_content() {

		logWithLabelName(getMethodName());

		try {
			waitForFullPageElementLoad();
			String resetMailId = readExcel("Test Datas", "Forgot Password", 1, 1);
			String expTextContent = "We sent an email to " + resetMailId + " so you can create your new password";

			Assert.assertEquals("Email Sent successfully content is NOT displayed as expected", expTextContent,
					pom.getForgotPasswordPage().getForgotPasswordMsgContent());
			log(Status.PASS,
					"Email Sent successfully content is displayed as expected Exp Content text - " + expTextContent
							+ " | Actual Content Text - " + pom.getForgotPasswordPage().getForgotPasswordMsgContent());

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("User must verify the Try Again text link is working")
	public void user_must_verify_the_try_again_text_link_is_working() {

		logWithLabelName(getMethodName());

		pom.getForgotPasswordPage().TryAgain();

		try {
			Assert.assertTrue("Try Again link is NOT Working as expected",
					pom.getForgotPasswordPage().isTryAgainLinkIsWork());
			log(Status.PASS, "Try Again text link is working as expected");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User must verify the login button in forgot password screen")
	public void user_must_verify_the_login_button_in_forgot_password_screen() {

		logWithLabelName(getMethodName());

		String windowHandle = driver.getWindowHandle();
		System.out.println("forgot Window - " + windowHandle);

		pom.getForgotPasswordPage().loginTextLink();

		try {
			waitForVisiblityOfElement(pom.getLoginPage().waitForloginTextVerification(), 10);
			Assert.assertTrue("Login link is NOT Working as expected", pom.getLoginPage().isLoginPageIsDisplayed());
			log(Status.PASS, "Login text link is working as expected");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("User should open the mailinator site for to verify whether the mail is received or not")
	public void user_should_open_the_mailinator_site_for_to_verify_whether_the_mail_is_received_or_not() {

		logWithLabelName(getMethodName());

		try {
			mailinatorDriver = getNewDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}

		mailinatorDriver.get("https://www.mailinator.com/");
		mailinatorpom = new PageObjectManager(mailinatorDriver);
		mailinatorDriver.manage().window().maximize();		
	}

	@Then("User should search the existing mail inbox")
	public void user_should_search_the_existing_mail_inbox() {

		logWithLabelName(getMethodName());

		mailinatorpom.getForgotPasswordPage().searchExistMail(1).goButton();
		waitForFullPageElementLoad(mailinatorDriver);
	}

	@Then("User should verify the content and body of the Forgot mail")
	public void user_should_verify_the_content_and_body_of_the_forgot_mail() {

		logWithLabelName(getMethodName());

		sleep(3000);
		waitForFullPageElementLoad(mailinatorDriver);
		mailinatorpom.getForgotPasswordPage().naviToMailContent();
		waitForFullPageElementLoad(mailinatorDriver);
		sleep(3000);

		WebElement iframe = findElementByXpath(mailinatorDriver, "(//iframe[@title='HTML Email Message Body'])[1]");
		mailinatorDriver.switchTo().frame(iframe);

		List<WebElement> findElements = mailinatorDriver
				.findElements(By.xpath("//p[@style='font-size: 30px ; font-weight: bold']/following::p"));

		sleep(2000);

		String welcomeMailText = mailinatorpom.getForgotPasswordPage().getWelcomeMailText();
		System.out.println("Text 1 - " + welcomeMailText);

		String mailText02 = findElements.get(0).getText();
		System.out.println("Text 2 - " + mailText02);

		String mailText03 = findElements.get(1).getText();
		System.out.println("Text 3 - " + mailText03);

		String mailText04 = findElements.get(2).getText();
		System.out.println("Text 4 - " + mailText04);

		String mailText05 = findElements.get(3).getText();
		System.out.println("Text 5 - " + mailText05);

		try {
			String expHeaderContent = readExcel("Test Datas", "Forgot Password", 1, 4);
			Assert.assertEquals("Welcome content is NOT displayed as expected", expHeaderContent, welcomeMailText);

			log(Status.PASS, "Welcome content is displayed as expected - " + welcomeMailText, mailinatorDriver);
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage(), mailinatorDriver);
			e.printStackTrace();
		}

		try {
			String expGreetingContent = readExcel("Test Datas", "Forgot Password", 2, 4);
			Assert.assertEquals("Hi userName  content is NOT displayed as expected", expGreetingContent, mailText02);
			log(Status.PASS, "Hi userName content is displayed as expected - " + mailText02, mailinatorDriver);
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage(), mailinatorDriver);
			e.printStackTrace();
		}

		try {
			String expMainBodyContent = readExcel("Test Datas", "Forgot Password", 3, 4);
			Assert.assertEquals("Main body content is NOT displayed as expected", expMainBodyContent, mailText03);
			log(Status.PASS, "Main body content is displayed as expected - " + mailText03, mailinatorDriver);
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage(), mailinatorDriver);
			e.printStackTrace();
		}

		try {
			String expLinkExpiredContent = readExcel("Test Datas", "Forgot Password", 4, 4);
			Assert.assertEquals("Link Expired content is NOT displayed as expected", expLinkExpiredContent, mailText04);
			log(Status.PASS, "Link Expired content is displayed as expected - " + mailText04, mailinatorDriver);
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage(), mailinatorDriver);
			e.printStackTrace();
		}

		try {
			String expIgnoreContent = readExcel("Test Datas", "Forgot Password", 5, 4);
			Assert.assertEquals("If you did not request this change... content is NOT displayed as expected",
					expIgnoreContent, mailText05);
			log(Status.PASS, "If you did not request this change... content is displayed as expected - " + mailText05,
					mailinatorDriver);
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage(), mailinatorDriver);
			e.printStackTrace();
		}
	}

	@Then("User should verify the Reset Password link is working in mail.")
	public void user_should_verify_the_reset_password_link_is_working_in_mail() {

		logWithLabelName(getMethodName());

			mailinatorpom.getForgotPasswordPage().resetPasswordTextLink();
	}

	@Then("User should switch to New Password page")
	public void user_should_switch_to_new_password_page() {
	    
      logWithLabelName(getMethodName());
		
		Set<String> windowHandles = mailinatorDriver.getWindowHandles();
		List<String> li = new ArrayList<String>(windowHandles);
		mailinatorDriver.switchTo().window(li.get(1));
	}
	
	@Then("User should verify the tab url address for NEW PASSWORD screen")
	public void user_should_verify_the_tab_url_address_for_new_password_screen() throws Exception {
	   
		 logWithLabelName(getMethodName());
		
		 try {
				String environment = getConfigureProperty("Environment");
				String[] split = mailinatorDriver.getCurrentUrl().split("new-password/");
				System.out.println(split[0]);
				System.out.println("Current Url - "+mailinatorDriver.getCurrentUrl());
				
				waitForFullPageElementLoad(mailinatorDriver);
				switch (environment) {
	
				case "QA": {
					Assert.assertEquals("New Password page url is wrong", readExcel("Test Datas", "Environments", 1, 1) + "login/new-password/",
							split[0].concat("new-password/"));
					log(Status.PASS, "URL Address for NEW PASSWORD is displayed as expected | Act URL - "+ getCurrentUrl());
					log(Status.INFO, "Tab URL Address verified - NEW PASSWORD QA - " + getCurrentUrl());
					break;
				}
				case "PREPROD": {
					Assert.assertEquals("Login page url is wrong", readExcel("Test Datas", "Environments", 2, 1) + "login/new-password/",
							split[0].concat("new-password/"));
					log(Status.PASS, "Client code is displayed as expected | Act URL - "+ getCurrentUrl());
					log(Status.INFO, "Tab URL Address verified - Login using PREPROD - " + getCurrentUrl());
					break;
				}
				case "PROD": {
					Assert.assertEquals("Login page url is wrong", readExcel("Test Datas", "Environments", 3, 1) + "login/new-password/",
							split[0].concat("new-password/"));
					log(Status.PASS, "Client code is displayed as expected | Act URL - "+ getCurrentUrl());
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
	
	@Then("User should verify whether the fields are mandatory in new password page {string}, {string}")
	public void user_should_verify_whether_the_fields_are_mandatory_in_new_password_page(String expNewPasswordInfoMsg,
			String expReenterPasswordInfoMsg) {

		logWithLabelName(getMethodName());
		
		mailinatorpom.getForgotPasswordPage().confirmButton();

		try {
			waitForPageLoad(mailinatorDriver);
			Assert.assertEquals("Mandatory info message is NOT displayed as expected in New Password field",
					expNewPasswordInfoMsg, mailinatorpom.getForgotPasswordPage().getNewPasswordInfoMsgText());
			log(Status.PASS, "Mandatory info msg is displayed in New Password field - "
					+ mailinatorpom.getForgotPasswordPage().getNewPasswordInfoMsgText(),mailinatorDriver);
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage(), mailinatorDriver);
		}

		try {
			Assert.assertEquals("Mandatory info message is NOT displayed as expected in Re-enter Password field",
					expReenterPasswordInfoMsg, mailinatorpom.getForgotPasswordPage().getReEnterNewPasswordInfoMsgText());
			log(Status.PASS, "Mandatory info msg is displayed in Re-enter Password field - "
					+ mailinatorpom.getForgotPasswordPage().getReEnterNewPasswordInfoMsgText(), mailinatorDriver);
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage(), mailinatorDriver);
		}
	}

	@Then("User should verify the Label name & Placeholder text for the New Password Re-Enter Password field")
	public void user_should_verify_the_label_name_placeholder_text_for_the_new_password_re_enter_password_field() {

		logWithLabelName(getMethodName());

		if (mailinatorpom.getForgotPasswordPage().getNewPasswordMandatoryFieldLabelText().contains("New Password *")
				&& mailinatorpom.getForgotPasswordPage().getReEnterNewPasswordMandatoryFieldLabelText()
						.contains("Re-enter Password *")) {

			log(Status.PASS,
					"New Password and Re-enter Password fields Lable names are displayed - "
							+ mailinatorpom.getForgotPasswordPage().getNewPasswordMandatoryFieldLabelText() + " | "
							+ mailinatorpom.getForgotPasswordPage().getReEnterNewPasswordMandatoryFieldLabelText(), mailinatorDriver);
		} else {
			log(Status.FAIL,
					"New Password and Re-enter Password fields Lable names are NOT displayed as expected - "
							+ mailinatorpom.getForgotPasswordPage().getNewPasswordMandatoryFieldLabelText() + ", "
							+ mailinatorpom.getForgotPasswordPage().getReEnterNewPasswordMandatoryFieldLabelText(), mailinatorDriver);
		}

		try {

			Assert.assertEquals("New Password field placeholder text Name Mismatched", "Password",
					mailinatorpom.getForgotPasswordPage().getNewPasswordAttributeValue("placeholder"));

			log(Status.PASS, "New Password field placeholder text is displayed - "
					+ mailinatorpom.getForgotPasswordPage().getNewPasswordAttributeValue("placeholder"), mailinatorDriver);

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage(), mailinatorDriver);
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("Re-enter Password field placeholder text Name Mismatched", "Password",
					mailinatorpom.getForgotPasswordPage().getReEnterPasswordAttributeValue("placeholder"));

			log(Status.PASS, "Re-enter Password field placeholder text is displayed - "
					+ mailinatorpom.getForgotPasswordPage().getReEnterPasswordAttributeValue("placeholder"), mailinatorDriver);

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage(),mailinatorDriver);
			e.printStackTrace();
		}

	}

	@Then("User should verify that the eye icon is functional in the New Password field")
	public void user_should_verify_that_the_eye_icon_is_functional_in_the_new_password_field() {

		logWithLabelName(getMethodName());

		mailinatorpom.getForgotPasswordPage().newPassword(1, 6);

		boolean passwordFieldHideInNewPasswordPage = "password"
				.equalsIgnoreCase(mailinatorpom.getForgotPasswordPage().getNewPasswordAttributeValue("type"));

		if (passwordFieldHideInNewPasswordPage) {

			log(Status.PASS, "Password is **hide", mailinatorDriver);
			System.out.println("Password is hide");
		} else {
			log(Status.FAIL, "Entered Password is still not visible after click the eye icon", mailinatorDriver);
			System.err.println("[ERROR] >>>> Entered Password is still not visible after click the eye icon");
		}

		if (mailinatorpom.getForgotPasswordPage().isEyeIconInPasswordFieldIsDisplayed()) {
			mailinatorpom.getForgotPasswordPage().eyeIcon();

		} else {
			log(Status.FAIL, "Unable to click eye iconin password field", mailinatorDriver);
			System.err.println("[ERROR] >>>> Unable to click eye icon in new password field");
		}

		boolean passwordFieldUnHideInNewPasswordPage = "text"
				.equalsIgnoreCase(mailinatorpom.getForgotPasswordPage().getNewPasswordAttributeValue("type"));

		if (passwordFieldUnHideInNewPasswordPage) {

			log(Status.PASS, "Password is visible", mailinatorDriver);
			System.out.println("Password is visible");
		} else {
			log(Status.FAIL, "Entered Password is still **hide after click the eye icon", mailinatorDriver);
			System.err.println("[ERROR] >>>> Entered Password is still **hide after click the eye icon");
		}
	}

	@Then("User should verify that the new password field must have alphanumeric restriction {string}")
	public void user_should_verify_that_the_new_password_field_must_have_alphanumeric_restriction(
			String expAlphanumericRestrictionInfoMsg) {

		logWithLabelName(getMethodName());

	   mailinatorpom.getForgotPasswordPage().reEnterPassword();

		try {
			Assert.assertEquals("Alphanumeric Info message is NOT displayed as expected",
					expAlphanumericRestrictionInfoMsg,
					mailinatorpom.getForgotPasswordPage().getAlphanumericInfoMsgInNewPasswordInfoMsgText());

			log(Status.PASS, "Alphanumeric Info message is NOT displayed as expected"
					+ mailinatorpom.getForgotPasswordPage().getAlphanumericInfoMsgInNewPasswordInfoMsgText(), mailinatorDriver);

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage(), mailinatorDriver);
			e.printStackTrace();
		}
	}

	@Then("User should verify whether an error message is displayed if the New Password and Re-Enter Password fields are mismatched {string}")
	public void user_should_verify_whether_an_error_message_is_displayed_if_the_new_password_and_re_enter_password_fields_are_mismatched(
			String expPassNotMatchInfoMsg) {

		logWithLabelName(getMethodName());
  
		
		mailinatorpom.getForgotPasswordPage().deleteNewPasswordFieldExistData();
		mailinatorpom.getForgotPasswordPage().newPassword(1, 3).reEnterPassword(1, 5);

		try {
			waitForVisiblityOfElement(mailinatorpom.getForgotPasswordPage().getPasswordNotMatchInfoMsg(), 10);
			Assert.assertEquals("Password does not match Info message is NOT displayed as expected",
					expPassNotMatchInfoMsg, getText(mailinatorpom.getForgotPasswordPage().getPasswordNotMatchInfoMsg()));

			log(Status.PASS, "Password does not match Info message is displayed as expected - "
					+ getText(mailinatorpom.getForgotPasswordPage().getPasswordNotMatchInfoMsg()), mailinatorDriver);

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage(), mailinatorDriver);
			e.printStackTrace();
		}
	}

	@Then("User should confirm the fields and button with valid data")
	public void user_should_confirm_the_fields_and_button_with_valid_data() {

		logWithLabelName(getMethodName());

		mailinatorpom.getForgotPasswordPage().deleteNewPasswordFieldExistData().deleteReEnterPasswordFieldExistData();
		mailinatorpom.getForgotPasswordPage().newPassword(1,5).reEnterPassword(1, 5).confirmButton();

	}

	@Then("User should verify the reset password page contents")
	public void user_should_verify_the_reset_password_page_contents() {

		logWithLabelName(getMethodName());
		
		sleep(3000);
		
		try {

			Assert.assertTrue("Tick icon is NOT displayed as expected after reset the password",
					mailinatorpom.getForgotPasswordPage().isDoneIconIsDisplayed());
			log(Status.PASS, "Tick symbol is successfully displayed as expected after reset the password", mailinatorDriver);
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage(), mailinatorDriver);
		}

		if(mailinatorpom.getForgotPasswordPage().getNewPasswordSuccessMsgText().equals("SUCCESS!") && mailinatorpom.getForgotPasswordPage().getPasswordSuccessfullyResetContent().equals("Your password has been successfully reset..")) {
	
			log(Status.PASS, "Password Reset successfully content is displayed as expected", mailinatorDriver);
	} else {
			log(Status.FAIL,"Password Reset successfully content is NOT displayed as expected", mailinatorDriver);
		}

	}

	@Then("User should verify the Login button on the password reset screen")
	public void user_should_verify_the_login_button_on_the_password_reset_screen() {

		logWithLabelName(getMethodName());

		mailinatorpom.getForgotPasswordPage().confirmButton();
		try {
			Assert.assertTrue("Login button is NOT working on the password reset screen",
					mailinatorpom.getLoginPage().isForgotPasswordLinkDisplayed());
			log(Status.PASS, "Login button on the password reset screen", mailinatorDriver);
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage(), mailinatorDriver);
		}
	}
	
		
	@Then("User should perform login with new password and verify once the page is navigated to HOME_DASHBOARD successfully {string}")
	public void user_should_perform_login_with_new_password_and_verify_once_the_page_is_navigated_to_home_dashboard_successfully(String string) throws Exception {
	  
		logWithLabelName(getMethodName());
		
	waitForFullPageElementLoad(mailinatorDriver);

		
		mailinatorpom.getLoginPage().email(1);
		mailinatorpom.getLoginPage().newPassword(1);
		mailinatorpom.getLoginPage().loginButton();
		
		try {
			waitForPageLoad(mailinatorDriver);
			waitForVisiblityOfElement(mailinatorpom.getHomePage().getAdminName(), 10);
			Assert.assertEquals("Unable to perform login with new password", "Social Worker", mailinatorpom.getHomePage().getAdminNameText());
			System.out.println("ACT Value" + mailinatorpom.getHomePage().getAdminNameText());
			log(Status.PASS, "Able to perform login with new password - "+ mailinatorpom.getHomePage().getAdminNameText(),mailinatorDriver);
			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage(),mailinatorDriver);
				e.printStackTrace();
			}
	}
	
	@Then("User should close the browser")
	public void user_should_close_the_browser() {
	   
		logWithLabelName(getMethodName());
		
		mailinatorDriver.quit();
	}
	
}
