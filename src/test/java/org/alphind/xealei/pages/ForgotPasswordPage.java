package org.alphind.xealei.pages;

import org.alphind.xealei.baseclass.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends BaseClass {

	private WebDriver driver;
	
	public ForgotPasswordPage(WebDriver driver) {
		
		this.driver = driver;
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
	 * Created on 23/01/2024
	 * 
	 */
	public boolean verifyEmailLabelText() {
		
     String fieldLabelName = getText(emailFieldLabelText);
     
     if(fieldLabelName.equals("Email *")) { 
    	 return true;
     }
     return false;

	} 
	
	/**
	 * Check whether the placeholder name is equally displayed or not
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * Created on 23/01/2024
	 * 
	 */
	public boolean verifyEmailPlaceHolderText() {
	
		String fieldPlaceholderName = getAttribute(emailFieldPlaceholderText,"placeholder");
	     System.out.println("Place holder text is -" +fieldPlaceholderName);
	     if(fieldPlaceholderName.equals("Enter email")) { 
	    	 return true;
	     }
	     return false;

	}
	
	/**
	 * Click Reset Button in forgot password Page
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * Created on 23/01/2024
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
	 * Created on 23/01/2024
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
	 * @param rowNum - Accepts only int value i.e:(0,1,2....)
	 * @param cellNum - Accepts only int value i.e:(0,1,2....)
	 * 
	 * @created on 1/25/2024
	 */
	public ForgotPasswordPage email(int rowNum, int cellNum) {
		
		sendKeys(emailFieldPlaceholderText, readExcel("Test Datas","Forgot Password",rowNum,cellNum));
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
	 * Created on 25/01/2024
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
	 * Created on 25/01/2024
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
	 * Created on 25/01/2024
	 * 
	 * @return if working : true | else : false
	 */
	public boolean isTryAgainLinkIsWork() {
		
		if(forgotPasswordText.isDisplayed()) {
			return true;
		}
		return false;
	}
	

	
	
	
	
	
	
	
	
}
