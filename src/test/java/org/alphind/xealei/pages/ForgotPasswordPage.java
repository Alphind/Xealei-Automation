/** Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.pages;

import org.alphind.xealei.baseclass.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends BaseClass {

	public ForgotPasswordPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h3[@class='login-head']")
	private WebElement forgotPasswordText;

	@FindBy(xpath = "//p[contains(text(),'Enter your email ')]")
	private WebElement enterYourMailText;

	@FindBy(xpath = "//mat-label[contains(text(),'Email')]")
	private WebElement emailFieldLabelText;

	@FindBy(xpath = "//input[@formcontrolname='emailId']")
	private WebElement emailFieldPlaceholderText;

	@FindBy(xpath = "//button[@class=' submit-btn']")
	private WebElement resetButton;

	@FindBy(xpath = "//a[@href='/login']")
	private WebElement loginTextLink;

	@FindBy(xpath = "//mat-error[contains(text(),' Please enter ')]")
	private WebElement verifyValidEmailAddress;

	@FindBy(xpath = "//mat-error[@class='text-danger mat-error ng-star-inserted']")
	private WebElement getInfoText;

	@FindBy(xpath = "//span[contains(text(),'Email ID not exist')]")
	private WebElement emailIDNotFoundToastMsg;

	@FindBy(xpath = "//span[contains(text(),'ok')]/parent::button")
	private WebElement toastMsgokButton;

	@FindBy(xpath = "//p[contains(text(),'EMAIL SENT!')]")
	private WebElement SuccessfullEmailSentVerifyText;

	@FindBy(xpath = "//p[@class='username-txt']")
	private WebElement forgotPasswordMsgContent;

	@FindBy(xpath = "//a[@class='pLink']")
	private WebElement tryAgainLink;

	/**
	 * ********** NEW PASSWORD PAGE(Locators) *************
	 * 
	 */

	@FindBy(xpath = "//h3[contains(text(),'NEW')]")
	private WebElement newPasswordPageText;

	@FindBy(xpath = "(//span[@class='text-danger']/parent::mat-label)[1]")
	private WebElement newPasswordMandatoryFieldLabelText;

	@FindBy(xpath = "(//span[@class='text-danger']/parent::mat-label)[2]")
	private WebElement reEnterPasswordMandatoryFieldLabelText;

	@FindBy(xpath = "(//input[@placeholder='Password'])[1]")
	private WebElement newPasswordPlaceholderText;

	@FindBy(xpath = "(//input[@placeholder='Password'])[2]")
	private WebElement reEnterPasswordPlaceholderText;

	@FindBy(xpath = "//button[@class='submit-btn']")
	private WebElement confirmButtonInNewPasswordPage;

	@FindBy(xpath = "//p[@class='success-txt']")
	private WebElement newPasswordSuccessMsgText;

	@FindBy(xpath = "//p[contains(text(),'Your')]")
	private WebElement passwordSuccessfullyResetContent;

	@FindBy(xpath = "//span[@class='material-icons']")
	private WebElement doneIconInPasswordResetPage;

	@FindBy(xpath = "//p[contains(text(),'Your password has been successfully')]")
	private WebElement successfullyResetPasswordText;

	@FindBy(xpath = "//mat-error[contains(text(),' Please enter new')]")
	private WebElement newPasswordInfoMsgText;

	@FindBy(xpath = "//mat-error[contains(text(),' Please enter confirm')]")
	private WebElement reenterPasswordInfoMsgText;

	@FindBy(xpath = "//mat-error[contains(text(),' New password')]")
	private WebElement alphanumericInfoMsgInNewPasswordInfoMsgText;

	@FindBy(xpath = "//mat-error[contains(text(),'Password is not')]")
	private WebElement passwordNotMatchInfoMsgText;

	@FindBy(xpath = "//mat-icon[contains(@class,'eye ml-1')]")
	private WebElement eyeIcon;

	/**
	 * ***************** Mailinator Elements(Locators) ********************
	 * 
	 */

	@FindBy(xpath = "//input[@id='search']")
	private WebElement enterPublicMailInboxTextbox;

	@FindBy(xpath = "//button[text()='GO']")
	private WebElement goButton;

	@FindBy(xpath = "(//table/tbody/tr/td[contains(@onclick,'showTheMessage')])[2]")
	private WebElement forgotPasswordMailText;

	@FindBy(xpath = "(//table/tbody/tr/td[contains(@onclick,'showTheMessage')])[1]")
	private WebElement norplyMailText;

	@FindBy(xpath = "//p[@style='font-size: 30px ; font-weight: bold']")
	private WebElement welcomeMailText;

	@FindBy(xpath = "//a[contains(text(),' Reset Password ')]")
	private WebElement resetPasswordLink;

	@FindBy(tagName = "(//a[contains(text(),'Login')])[2]")
	private WebElement mailinatorLoginButton;

	/**
	 * Get the Mailinator Login Button WebElement
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 13/02/2024
	 * 
	 * @return WebElement
	 */
	public WebElement getMailinatorLoginButton() {
		return mailinatorLoginButton;
	}

	/**
	 * Get the Mailinator Mail textbox WebElement
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 13/02/2024
	 * 
	 * @return WebElement
	 */
	public WebElement getEnterPublicMailInboxTextbox() {
		return enterPublicMailInboxTextbox;
	}

	/**
	 * Get the Header mail content (text) from mail
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 13/02/2024
	 * 
	 * @return Header text
	 */
	public String getWelcomeMailText() {
		return getText(welcomeMailText);
	}

	/**
	 * Get the Reset password content (text) from mail
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 13/02/2024
	 * 
	 * @return Reset Password text
	 */
	public String getResetPasswordText() {
		return getText(resetPasswordLink);
	}

	// ********* NEW PASSWORD PAGE ************

	/**
	 * Get the New Password* field Label Name
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 14/02/2024
	 * 
	 * @return field Label Name (text)
	 */
	public String getNewPasswordMandatoryFieldLabelText() {

		waitForVisiblityOfElement(newPasswordMandatoryFieldLabelText, 10);
		return getText(newPasswordMandatoryFieldLabelText);
	}

	/**
	 * Get the Re-enter Password* field Label Name
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 14/02/2024
	 * 
	 * @return field Label Name (text)
	 */
	public String getReEnterNewPasswordMandatoryFieldLabelText() {

		waitForVisiblityOfElement(reEnterPasswordMandatoryFieldLabelText, 10);
		return getText(reEnterPasswordMandatoryFieldLabelText);
	}

	/**
	 * Get the mismatched password info message from Password Reset Page
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 14/02/2024
	 * 
	 * @return Info message webElement
	 */
	public WebElement getPasswordNotMatchInfoMsg() {

		return passwordNotMatchInfoMsgText;
	}

	/**
	 * Get the password successfull reset content from Password Reset Page
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 14/02/2024
	 * 
	 * @return Password Reset successsfull message (text)
	 */
	public String getNewPasswordSuccessMsgText() {

		waitForVisiblityOfElement(newPasswordSuccessMsgText, 10);
		return getText(newPasswordSuccessMsgText);
	}

	/**
	 * Get the password successfull reset content from Password Reset Page
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 20/02/2024
	 * 
	 * @return Password Reset successsfull message (text)
	 */
	public String getPasswordSuccessfullyResetContent() {

		waitForVisiblityOfElement(passwordSuccessfullyResetContent, 10);
		return getText(passwordSuccessfullyResetContent);
	}

	/**
	 * Get the New password* field placeholder text
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 14/02/2024
	 * 
	 * @return New password* field placeholder (text)
	 */
	public String getNewPasswordAttributeValue(String value) {

		waitForVisiblityOfElement(newPasswordPlaceholderText, 10);
		return getAttribute(newPasswordPlaceholderText, value);
	}

	/**
	 * Get the Re-enter password* field placeholder text
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 14/02/2024
	 * 
	 * @return Re-enter password* field placeholder (text)
	 */
	public String getReEnterPasswordAttributeValue(String value) {

		waitForVisiblityOfElement(reEnterPasswordPlaceholderText, 10);
		return getAttribute(reEnterPasswordPlaceholderText, value);
	}

	/**
	 * Check whether the done icon is displayed or not
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 14/02/2024
	 * 
	 */
	public boolean isDoneIconIsDisplayed() {

		if (doneIconInPasswordResetPage.isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Click the Submit button
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 14/02/2024
	 * 
	 */
	public void confirmButton() {

		click(confirmButtonInNewPasswordPage);
	}

	/**
	 * Get the mandatory new password info message from Password Reset Page
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 14/02/2024
	 * 
	 * @return Info message (text)
	 */
	public String getNewPasswordInfoMsgText() {
		return getText(newPasswordInfoMsgText);
	}

	/**
	 * Get the mandatory Re-enter password info message from Password Reset Page
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 14/02/2024
	 * 
	 * @return Info message (text)
	 */
	public String getReEnterNewPasswordInfoMsgText() {
		return getText(reenterPasswordInfoMsgText);
	}

	/**
	 * Get the mandatory alpha-numeric info message from Password Reset Page
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 14/02/2024
	 * 
	 * @return Info message (text)
	 */
	public String getAlphanumericInfoMsgInNewPasswordInfoMsgText() {
		return getText(alphanumericInfoMsgInNewPasswordInfoMsgText);
	}

	/**
	 * Enter data in New Password * field
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 14/02/2024
	 * 
	 */
	public ForgotPasswordPage newPassword(int rowNum, int cellNum) {

		sendKeys(newPasswordPlaceholderText, readExcel("Test Datas", "Forgot Password", rowNum, cellNum));
		return this;
	}

	/**
	 * Enter data in Re-enter Password * field
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 14/02/2024
	 * 
	 */
	public ForgotPasswordPage reEnterPassword(int rowNum, int cellNum) {

		sendKeys(reEnterPasswordPlaceholderText, readExcel("Test Datas", "Forgot Password", rowNum, cellNum));
		return this;
	}

	/**
	 * Click Re-enter Password * field
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 14/02/2024
	 * 
	 */
	public ForgotPasswordPage reEnterPassword() {

		click(reEnterPasswordPlaceholderText);
		return this;
	}

	/**
	 * Delete the re-entered password * field data
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 14/02/2024
	 * 
	 */
	public ForgotPasswordPage deleteReEnterPasswordFieldExistData() {

		deleteExistFieldData(reEnterPasswordPlaceholderText);
		return this;
	}

	/**
	 * Delete the new password * field data
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 14/02/2024
	 * 
	 */
	public ForgotPasswordPage deleteNewPasswordFieldExistData() {

		deleteExistFieldData(newPasswordPlaceholderText);
		return this;
	}

	/**
	 * Checks whether EyeIcon in Password field is displayed or not.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 2/14/2024
	 * 
	 * @return whether EyeIcon in Password field is displayed or not.
	 */
	public boolean isEyeIconInPasswordFieldIsDisplayed() {

		if (eyeIcon.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Click the "Eye" Icon.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 2/14/2024
	 * 
	 */
	public void eyeIcon() {
		click(eyeIcon);
	}

	// ********* Mailinator Elements(Locators) ************

	/**
	 * Enter data in (Mailinator) search box * field
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 14/02/2024
	 * 
	 */
	public ForgotPasswordPage searchExistMail(int rowNum) {

		sendKeys(enterPublicMailInboxTextbox, readExcel("Test Datas", "Forgot Password", rowNum, 1));
		return this;
	}

	/**
	 * Click (Mailinator) Go button
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 14/02/2024
	 * 
	 */
	public ForgotPasswordPage goButton() {

		click(goButton);
		return this;
	}

	/**
	 * Click (Mailinator) content
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 14/02/2024
	 * 
	 */
	public void naviToMailContent() {
		click(forgotPasswordMailText);
	}

	/**
	 * Click Reset Password link text from (Mailinator)
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 14/02/2024
	 * 
	 */
	public void resetPasswordTextLink() {

		/// scrollIntoView(resetPasswordLink);
		sleep(2000);
		click(resetPasswordLink);
	}

	/**
	 * Get the FORGOT PASSWORD (text).
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 24/01/2024
	 * 
	 * @return Forgot Password (text).
	 */
	public String getForgotPasswordText() {
		return getText(forgotPasswordText);
	}

	/**
	 * Checks whether Navigate to forgot password page or not.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 1/19/2024
	 * 
	 * @return whether the forgot password page is displayed or not.
	 */
	public boolean isForgotPasswordPageIsDisplayed() {

		if (forgotPasswordText.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Check whether the label name is equally displayed or not
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 *         Created on 23/01/2024
	 * 
	 */
	public boolean verifyEmailLabelText() {

		String fieldLabelName = getText(emailFieldLabelText);

		if (fieldLabelName.equals("Email *")) {
			return true;
		}
		return false;

	}

	/**
	 * Check whether the placeholder name is equally displayed or not
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 *         Created on 23/01/2024
	 * 
	 */
	public boolean verifyEmailPlaceHolderText() {

		String fieldPlaceholderName = getAttribute(emailFieldPlaceholderText, "placeholder");
		System.out.println("Place holder text is -" + fieldPlaceholderName);
		if (fieldPlaceholderName.equals("Enter email")) {
			return true;
		}
		return false;

	}

	/**
	 * Click Reset Button in forgot password Page
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 *         Created on 23/01/2024
	 * 
	 */
	public ForgotPasswordPage resetButton() {

		click(resetButton);
		return this;
	}

	/**
	 * Get the Email Required info msg (Text)
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 25/01/2024
	 * 
	 * @return Email Required info msg (Text).
	 */
	public String getInfoMsgText() {

		return getText(getInfoText);
	}

	/**
	 * Click the Login text-link in forgot password Page
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 *         Created on 23/01/2024
	 * 
	 */
	public void loginTextLink() {

		click(loginTextLink);
	}

	/**
	 * Enter email in Email* field
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @param rowNum  - Accepts only int value i.e:(0,1,2....)
	 * @param cellNum - Accepts only int value i.e:(0,1,2....)
	 * 
	 * @created on 1/25/2024
	 */
	public ForgotPasswordPage email(int rowNum, int cellNum) {

		sendKeys(emailFieldPlaceholderText, readExcel("Test Datas", "Forgot Password", rowNum, cellNum));
		return this;
	}

	/**
	 * Get the Email Not Found toast msg (Text)
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 25/01/2024
	 * 
	 * @return Email Not found Toast msg (Text).
	 */
	public String getEmailIDNotFoundToastMsgText() {
		return getText(emailIDNotFoundToastMsg);
	}

	/**
	 * Delete the entered data in Email* field
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 25/01/2024
	 * 
	 */
	public void deleteEmailFieldData() {

		deleteExistFieldData(emailFieldPlaceholderText);
	}

	/**
	 * Click the Toast Message 'ok' button
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 *         Created on 25/01/2024
	 * 
	 */
	public void toastMsgokButton() {

		click(toastMsgokButton);
	}

	/**
	 * Get the EMAIL SENT! (Text)
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 25/01/2024
	 * 
	 * @return EMAIL SENT! (Text).
	 */
	public String getEmailSentVerifyText() {
		return getText(SuccessfullEmailSentVerifyText);
	}

	/**
	 * Get the EMAIL SENT! Content (Text)
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 25/01/2024
	 * 
	 * @return EMAIL SENT! Content (Text).
	 */
	public String getForgotPasswordMsgContent() {
		return getText(forgotPasswordMsgContent);
	}

	/**
	 * Click the Try Again text-link
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 *         Created on 25/01/2024
	 * 
	 */
	public void TryAgain() {

		click(tryAgainLink);
	}

	/**
	 * Check whether the Try Again text-link is working or not
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 *         Created on 25/01/2024
	 * 
	 * @return if working : true | else : false
	 */
	public boolean isTryAgainLinkIsWork() {

		if (forgotPasswordText.isDisplayed()) {
			return true;
		}
		return false;
	}

}