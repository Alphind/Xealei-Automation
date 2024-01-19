/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul, on date

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.pages;

import org.alphind.xealei.baseclass.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

public class LoginPage extends BaseClass {

	/*
	 * Description - All the Login Module/Page locators are stored here..
	 */

	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[contains(text(),'Powered by Alphind © 2023')]")
	private WebElement copyRightsTxtInLoginScreen;

	@FindBy(xpath = "//h3[contains(text(),'LOGIN')]")
	private WebElement loginTextVerification;

	@FindBy(xpath = "(//span[@class='text-danger']/parent::mat-label)[1]")
	private WebElement UNMandatoryVerification;

	@FindBy(xpath = "(//span[@class='text-danger']/parent::mat-label)[2]")
	private WebElement PassMandatoryVerification;

	@FindBy(xpath = "//img[@class='show-hide-pwd1']")
	private WebElement eyeShow;

	@FindBy(xpath = "//a[contains(text(),'Forgot password?')]")
	private WebElement forgotPasswordHyperLink;

	@FindBy(xpath = "//h3[@class='login-head']")
	private WebElement forgotPassword;

	@FindBy(xpath = "//a[text()='Privacy Policy']")
	private WebElement lnkPrivacyPolicy;

	@FindBy(xpath = "//h1[text()='PRIVACY POLICY']")
	private WebElement privacyPolicyContent;

	@FindBy(xpath = "//p[@class='text-muted text-center mt-6']")
	private WebElement bottomText;

	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement userName;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;

	@FindBy(xpath = "//button[text()='Login ']")
	private WebElement loginButton;

	@FindBy(xpath = "//h5[@x-page='home']")
	private WebElement navToHomePageSuccessfully;

	@FindBy(xpath = "//span[contains(text(),'User not found')]")
	private WebElement userNotFoundErrorMessage;

	@FindBy(xpath = "//span[contains(text(),'Incorrect password')]")
	private WebElement incorrectPasswordErrorMessage;

	@FindBy(xpath = "//mat-error[contains(text(),' Please enter email ID ')]")
	private WebElement errorMessageForEmail;

	@FindBy(xpath = "//mat-error[contains(text(),' Please enter password ')]")
	private WebElement errorMessageForPassword;

	@FindBys({ @FindBy(xpath = "//span[contains(text(),'Unknown Error.')]"),
			@FindBy(xpath = "//span[text()='ok']/parent::button") })
	private WebElement unknownErrorToastMsg;

	@FindBy(xpath = "//span[contains(text(),'OK')]/parent::button")
	private WebElement toastMsgOkButton;
	
	@FindBy(xpath = "//span[contains(text(),'ok')]/parent::button")
	private WebElement toastMsgokButton;
	
	

	public WebElement getCopyRightsTxtInLoginScreen() {
		return copyRightsTxtInLoginScreen;
	}

	public WebElement getLoginTextVerification() {
		return loginTextVerification;
	}

	public WebElement getUNMandatoryVerification() {
		return UNMandatoryVerification;
	}

	public WebElement getPassMandatoryVerification() {
		return PassMandatoryVerification;
	}

	public WebElement getEyeShow() {
		return eyeShow;
	}

	public WebElement getForgotPassword() {
		return forgotPassword;
	}

	public WebElement getLnkPrivacyPolicy() {
		return lnkPrivacyPolicy;
	}

	public WebElement getBottomText() {
		return bottomText;
	}

	public WebElement getPrivacyPolicyContent() {
		return privacyPolicyContent;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getNavToHomePageSuccessfully() {
		return navToHomePageSuccessfully;
	}

	public WebElement getUserNotFoundErrorMessage() {
		return userNotFoundErrorMessage;
	}

	public WebElement getIncorrectPasswordErrorMessage() {
		return incorrectPasswordErrorMessage;
	}

	public WebElement getErrorMessageForEmail() {
		return errorMessageForEmail;
	}

	public WebElement getErrorMessageForPassword() {
		return errorMessageForPassword;
	}

	public WebElement getUnknownErrorToastMsg() {
		return unknownErrorToastMsg;
	}

	public WebElement getToastMsgOkButton() {
		return toastMsgOkButton;
	}
	
	public WebElement getToastMsgokButton() {
		return toastMsgokButton;
	}
	
	public WebElement getForgotPasswordHyperLink() {
		return forgotPasswordHyperLink;
	}

	/*
	 * Description - Below method helps to perform the Testcase actions for Login
	 * Page..
	 */

	public void email() {

		sendKeys(getUserName(), "Doc@Medi.com");
	}

	public void password() {

		waitForPageLoad(this.driver);
		sendKeys(getPassword(), "xe23Dal%q3");
	}

	public void loginButton() {
		
		click(loginButton);
	}
	
	public void eyeIcon() {
		click(eyeShow); 
	}
	
	public void forgotPasswordHyperLink() {
		
		click(forgotPasswordHyperLink); 
	}
	
	
	public void privacyPolicyTextLink() {

		click(lnkPrivacyPolicy);
	}
	
	 public void ToastMsgOkButton() {
			
		   click(toastMsgOkButton);
	}
	 
	 public void ToastMsgokButton() {
			
		   click(toastMsgokButton);
	}

	String email;

	public void validEmail(int rowNum){

		String environment = getConfigureProperty("Environment");

		switch (environment) {

		case "QA": {
			email = readExcel("Test Datas", "Login", rowNum, 1);
			sendKeys(getUserName(), email);
			log(Status.INFO, "Enter QA environment Email/userName");
			clickEnter(getPassword());
			waitForPageLoad();
			break;
		}
		case "PREPROD": {
			email = readExcel("Test Datas", "Login", rowNum, 1);
			sendKeys(getUserName(), email);
			log(Status.INFO, "Enter PREPROD environment email/userName");
			clickEnter(getPassword());
			waitForPageLoad();
			break;
		}
		case "PROD": {
			email = readExcel("Test Datas", "Login", rowNum, 1);
			sendKeys(getUserName(), email);
			log(Status.INFO, "Enter PROD environment email/userName");
			clickEnter(getPassword());
			waitForPageLoad();
			break;
		}
		default: {
			log(Status.FAIL, "Unable to get the EMAIL data from excel");
			break;
		}
		}

	}

	String passWord;

	public void validPassword(int rowNum) {

		String environment = getConfigureProperty("Environment");

		switch (environment) {

		case "QA": {
			passWord = readExcel("Test Datas", "Login", rowNum, 2);
			waitForPageLoad();
			sendKeys(getPassword(), passWord);
			log(Status.INFO, "Enter QA environment Password");
			break; 
		}
		case "PREPROD": {
			passWord = readExcel("Test Datas", "Login", rowNum, 2);
			waitForPageLoad();
			sendKeys(getPassword(), passWord);
			log(Status.INFO, "Enter PREPROD environment Password");
			break;
		}
		case "PROD": {
			passWord = readExcel("Test Datas", "Login", rowNum, 2);
			waitForPageLoad();
			sendKeys(getPassword(), passWord);
			log(Status.INFO, "Enter PROD environment Password");
			break;
		}
		default: {
			log(Status.FAIL, "Unable to get the Password data from excel");
			break;
		}

		}
	}

}