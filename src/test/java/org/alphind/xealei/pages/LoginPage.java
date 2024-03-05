/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul

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

	private WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h3[contains(text(),'LOGIN')]")
	private WebElement loginTextVerification;

	@FindBy(xpath = "(//span[@class='text-danger']/parent::mat-label)[1]")
	private WebElement emailMandatoryFieldLabelText;

	@FindBy(xpath = "(//span[@class='text-danger']/parent::mat-label)[2]")
	private WebElement passwordMandatoryFieldLabelText;

	@FindBy(xpath = "//img[@class='show-hide-pwd1']")
	private WebElement eyeShow;

	@FindBy(xpath = "//a[contains(text(),'Forgot password?')]")
	private WebElement forgotPasswordHyperLink;

	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement userName;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;

	@FindBy(xpath = "//button[text()='Login ']")
	private WebElement loginButton;

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
	private WebElement toastMsgOKButton;

	@FindBy(xpath = "//span[contains(text(),'ok')]/parent::button")
	private WebElement toastMsgokButton;
	
	@FindBy(xpath = "//img[@class='logo-img']")
	private WebElement XealeiImageInLoginPage;

	
	
	
	public WebElement isImageIsDisplayed() {
		return XealeiImageInLoginPage;
	}
	
	public WebElement waitForloginTextVerification() {
		return loginTextVerification;
	}
	
	
	
	/**
	 * Get the "LOGIN" (text) in Login Page.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 19/01/2024
	 * 
	 * @return LOGIN (text).
	 */
	public String getLoginTextVerification() {
		return getText(loginTextVerification);
	}

	/**
	 * Get the Login button "Attribute value" in Login Page.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 19/01/2024
	 * 
	 * @return Login button "Attribute value".
	 */
	public String getLoginButtonAttribute() {
		return getAttribute(loginButton, "ng-reflect-ng-class");
	}

	/**
	 * Get the Email* field Label (text) in Login Page.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 19/01/2024
	 * 
	 * @return Email* field label (text).
	 */
	public String getEmailMandatoryFieldLabelText() {
		waitForVisiblityOfElement(emailMandatoryFieldLabelText, 10);
		return getText(emailMandatoryFieldLabelText);
	}

	/**
	 * Get the Password* field Label (text) in Login Page.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 19/01/2024
	 * 
	 * @return Password* field label (text).
	 */
	public String getPassMandatoryFieldLabelText() {
		return getText(passwordMandatoryFieldLabelText);
	}

	/**
	 * Get the Email* field "Attribute value" in Login Page.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 19/01/2024
	 * 
	 * @return Email* field "Attribute value".
	 */
	public String getUserNameFieldAttributeValue(String value) {
		return getAttribute(userName, value);
	}

	/**
	 * Get the Password* field "Attribute value" in Login Page.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 19/01/2024
	 * 
	 * @return Password* field "Attribute value".
	 */
	public String getPasswordFieldAttributeValue(String value) {
		return getAttribute(password, value);
	}

	/**
	 * Get the Email* field Info (text) in Login Page.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 19/01/2024
	 * 
	 * @return Email* field Info(text).
	 */
	public String getEmailMFInfoMessageText() {
		return getText(errorMessageForEmail);
	}

	/**
	 * Get the Password* field Info (text) in Login Page.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 19/01/2024
	 * 
	 * @return Password* field Info(text).
	 */
	public String getPasswordMFInfoMessageText() {
		return getText(errorMessageForPassword);
	}

	/**
	 * Get the "User Not Found" ToastMsg (text) in Login Page.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 19/01/2024
	 * 
	 * @return "User Not Found" ToastMsg (text).
	 */
	public String getUserNotFoundErrorMessageText() {
		return getText(userNotFoundErrorMessage);
	}

	/**
	 * Get the "Incorrect Password" ToastMsg (text) in Login Page.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 19/01/2024
	 * 
	 * @return "Incorrect Password" ToastMsg (text).
	 */
	public String getIncorrectPasswordErrorMessageText() {
		return getText(incorrectPasswordErrorMessage);
	}

	/**
	 * Enter the invalid data to 'Email*' field.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 19/01/2024
	 * 
	 */
	public void email() {

		sendKeys(userName, "Doc@Medi.com");
	}

	/**
	 * Enter the invalid data to 'password*' field.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 19/01/2024
	 * 
	 */
	public void password() {
		
		sendKeys(password, "xe23Dal%q3");
		pressEnterKeyInPasswordField();
	}

	/**
	 * Click the "Login" button.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 19/01/2024
	 * 
	 */
	public void loginButton() {

		sleep(2000);
		waitForElementToBeClickable(loginButton, 10);
		waitForFullPageElementLoad();
		click(loginButton);
	}

	/**
	 * Click the "Eye" Icon.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 19/01/2024
	 * 
	 */
	public void eyeIcon() {
		click(eyeShow);
	}

	/**
	 * Click the "forgot password" text link.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 19/01/2024
	 * 
	 */
	public void forgotPasswordHyperLink() {

		waitForElementToBeClickable(forgotPasswordHyperLink, 10);
		click(forgotPasswordHyperLink);
	}

	/**
	 * Click the Toast message "OK" Button.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 19/01/2024
	 * 
	 */
	public void ToastMsgOkButton() {

		waitForElementToBeClickable(toastMsgOKButton,10);
		click(toastMsgOKButton);
	}

	/**
	 * Click the Toast message "ok" Button.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 19/01/2024
	 * 
	 */
	public void ToastMsgokButton() {

		waitForPageLoad();
		waitForElementToBeClickable(toastMsgokButton,10);
		click(toastMsgokButton);
	}

	/**
	 * To delete the existing Email field data.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 19/01/2024
	 * 
	 */
	public LoginPage deleteExistingEmailFieldData() {

		deleteExistFieldData(userName);
		return this;
	}

	/**
	 * To delete the existing Password field data.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 19/01/2024
	 * 
	 */
	public void deleteExistingPasswordFieldData() {

		deleteExistFieldData(password);
	}

	/**
	 * Press ENTER key.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 19/01/2024
	 * 
	 */
	public void pressEnterKeyInPasswordField() {

		waitForElementToBeClickable(password, 10);
		clickEnter(password);
	}

	/**
	 * Check whether the email and password field is empty or not
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 05/02/2024
	 */
	public void isEmailAndPasswordFieldIsEmpty() {
		
		if(getAttribute(userName,"value").isEmpty() || getAttribute(password,"value").isEmpty()) {
			log(Status.FAIL, "Data is NOT entered/displayed in email or password field");
		} else {
			log(Status.PASS, "Data is entered/displayed in email and password field");
	}
	}
	

	String email;

	/**
	 * Enter the valid data from excel sheet to 'Email*' field.
	 * 
	 * @author Alphi-MohamedRazul.
	 *
	 * @created on 22-12-2023.
	 */
	public void validEmail(int rowNum) {

		String environment = getConfigureProperty("Environment");
		
		waitForVisiblityOfElement(userName, 3);
		
		switch (environment) {

		case "QA": {
			email = readExcel("Test Datas", "Login", rowNum, 1);
			sendKeys(userName, email);			
			clickEnter(password);
			break;
		}
		case "PREPROD": {
			email = readExcel("Test Datas", "Login", rowNum, 1);
			sendKeys(userName, email);
			clickEnter(password);
			break;
		}
		case "PROD": {
			email = readExcel("Test Datas", "Login", rowNum, 1);
			sendKeys(userName, email);
			clickEnter(password);
			break;
		}
		default: {
			log(Status.FAIL, "Unable to get the EMAIL data from excel");
			break;
		}
		}

	}

	
	String passWord;

	/**
	 * Enter the valid data from excel sheet to 'Password*' field.
	 * 
	 * @author Alphi-MohamedRazul.
	 *
	 * @created on 22-12-2023.
	 */
	public void validPassword(int rowNum) {

		String environment = getConfigureProperty("Environment");

		switch (environment) {

		case "QA": {
			passWord = readExcel("Test Datas", "Login", rowNum, 2);
			sendKeys(password, passWord);
			break;
		}
		case "PREPROD": {
			passWord = readExcel("Test Datas", "Login", rowNum, 2);
			sendKeys(password, passWord);
			break;
		}
		case "PROD": {
			passWord = readExcel("Test Datas", "Login", rowNum, 2);
			sendKeys(password, passWord);
			break;
		}
		default: {
			log(Status.FAIL, "Unable to get the Password data from excel");
			break;
		}

		}
	}

	/**
	 * Checks whether forgot password link is displayed or not.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 1/19/2024
	 * 
	 * @return whether forgot password link is displayed or not.
	 */
	public boolean isForgotPasswordLinkDisplayed() {

		if (forgotPasswordHyperLink.isEnabled()) {
			return true;
		}
		return false;
	}

	/**
	 * Checks whether EyeIcon in Password field is displayed or not.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 1/19/2024
	 * 
	 * @return whether EyeIcon in Password field is displayed or not.
	 */
	public boolean isEyeIconInPasswordFieldIsDisplayed() {

		if (eyeShow.isDisplayed()) {
			return true;
		}
		return false;
	}

	
	/**
	 * Check whether the Login text-link is working or not IN FORGOT PASSWORD Page
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * Created on 25/01/2024
	 * 
	 * @return if working : true | else : false
	 */
	public boolean isLoginPageIsDisplayed() {

		if (loginTextVerification.isDisplayed()) {
			return true;
		}
		return false;
	}

	
	String newEmail;

	/**
	 * Enter the valid data from excel sheet to 'Email*' field.
	 * 
	 * @author Alphi-MohamedRazul.
	 *
	 * @created on 20-02-2023.
	 */
	public void email(int rowNum) {

		String environment = getConfigureProperty("Environment");
		
		waitForVisiblityOfElement(userName, 3);
		
		switch (environment) {

		case "QA": {
			newEmail = readExcel("Test Datas", "Forgot Password", rowNum, 2);
			sendKeys(userName, newEmail);
			clickEnter(password);
			break;
		}
		case "PREPROD": {
			newEmail = readExcel("Test Datas", "Forgot Password", rowNum, 2);
			sendKeys(userName, newEmail);
			clickEnter(password);
			break;
		}
		case "PROD": {
			newEmail = readExcel("Test Datas", "Forgot Password", rowNum, 2);
			sendKeys(userName, newEmail);
			clickEnter(password);
			break;
		}
		default: {
			log(Status.FAIL, "Unable to get the EMAIL data from excel");
			break;
		}
		}

	}


	String pass;

	/**
	 * Enter the valid data from excel sheet to 'Password*' field.
	 * 
	 * @author Alphi-MohamedRazul.
	 *
	 * @created on 20-02-2023.
	 */
	public void newPassword(int rowNum) {

		String environment = getConfigureProperty("Environment");

		switch (environment) {

		case "QA": {
			pass = readExcel("Test Datas", "Forgot Password", rowNum, 5);
			sendKeys(password, pass);
			break;
		}
		case "PREPROD": {
			pass = readExcel("Test Datas", "Forgot Password", rowNum, 5);
			sendKeys(password, pass);
			break;
		}
		case "PROD": {
			pass = readExcel("Test Datas", "Forgot Password", rowNum, 5);
			sendKeys(password, pass);
			break;
		}
		default: {
			log(Status.FAIL, "Unable to get the Password data from excel");
			break;
		}

		}
	}
	
	
	
	

	
}