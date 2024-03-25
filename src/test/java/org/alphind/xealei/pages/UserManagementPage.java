/** Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Nandhalala

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Pattern;

import org.alphind.xealei.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

public class UserManagementPage extends BaseClass {

	private WebDriver driver;

	private String randomNumber = Integer.toString(new Random().nextInt(10000));

	private String dropdownOptions = "//span[@class = 'mat-option-text' " + "and contains(text(),'XX')]";

	@FindBy(xpath = "//h5[contains(text(),'User Management')]")
	private WebElement userManagementHeading;

	@FindBy(xpath = "//button[contains(@class,'create-btn')]")
	private WebElement createNewUserButton;

	@FindBy(xpath = "//h1[contains(text(),'Create New User')]")
	private WebElement createNewUserPopupHeading;

	@FindBy(xpath = "//a[contains(text(),'Basic Details')]")
	private WebElement basicDetailsLink;

	@FindBy(xpath = "//a[contains(text(),'Contact Details')]")
	private WebElement contactDetailsLink;

	@FindBy(xpath = "//a[contains(text(),'Qualification')]")
	private WebElement QualificationLink;

	@FindBy(xpath = "//input[@formcontrolname = 'firstName']")
	private WebElement createNewUserBasicDetailsFirstNameTextBox;

	@FindBy(xpath = "//input[@formcontrolname = 'middleName']")
	private WebElement createNewUserBasicDetailsMiddleNameTextBox;

	@FindBy(xpath = "//input[@formcontrolname = 'lastName']")
	private WebElement createNewUserBasicDetailsLastNameTextBox;

	@FindBy(xpath = "//mat-select[@formcontrolname = 'role']")
	private WebElement createNewUserBasicDetailsRoleDropdown;

	@FindBy(xpath = "//input[@formcontrolname = 'email']")
	private WebElement createNewUserBasicDetailsMailTextBox;

	@FindBy(xpath = "//input[@formcontrolname = 'mobile']")
	private WebElement createNewUserBasicDetailsPhonenumberTextBox;

	@FindBy(xpath = "//span[contains(text(),'Browse')]")
	private WebElement createNewUserBasicDetailsImageUploadBrowse;

	@FindBy(xpath = "//span[contains(text(),'Browse')]/../following-sibling::input")
	private WebElement createNewUserBasicDetailsImageUploadInput;

	@FindBy(xpath = "//span[contains(text(),'Browse')]/../preceding-sibling::img")
	private WebElement profileImage;

	@FindBy(xpath = "(//span[contains(text(),'Next')]/parent::button)[1]")
	private WebElement createNewUserBasicDetailsNextButton;

	@FindBy(xpath = "(//span[contains(text(),'Create & Send Invite')]/parent::button)[1]")
	private WebElement createNewUserBasicDetailsCreateAndSendInviteButton;

	// (//mat-error/span)[1]
	@FindBy(xpath = "//input[@formcontrolname = 'firstName']/parent::div/../following-sibling"
			+ "::div/div/mat-error/span")
	private WebElement firstNameErrorText;

	// (//mat-error/span)[2]
	@FindBy(xpath = "//input[@formcontrolname = 'lastName']/parent::div/../following-sibling"
			+ "::div/div/mat-error/span")
	private WebElement lastNameErrorText;

	@FindBy(xpath = "//input[@formcontrolname = 'middleName']/parent::div/../following-sibling"
			+ "::div/div/mat-error/span")
	private WebElement middleNameErrorText;

	@FindBy(xpath = "(//mat-error/span)[3]")
	private WebElement roleErrorText;

	@FindBy(xpath = "//mat-label[contains(text(),'Email ID')]/"
			+ "following-sibling::mat-form-field/div/div[2]/div/mat-error")
	private WebElement emailErrorText;

	@FindBy(xpath = "//mat-label[contains(text(),'Phone Number')]/"
			+ "following-sibling::mat-form-field/div/div[2]/div/mat-error")
	private WebElement phoneNumberErrorText;

	@FindBy(xpath = "//div[contains(text(),'Emergency')]")
	private WebElement emergencyContactHeading;

	@FindBy(xpath = "//textarea[@formcontrolname = 'permenentAdd']")
	private WebElement createNewUserContactDetailsPermanentAddress;

	@FindBy(xpath = "//textarea[@formcontrolname = 'residingAdd']")
	private WebElement createNewUserContactDetailsResidingAddress;

	@FindBy(xpath = "//input[@formcontrolname = 'emcyCntName1']")
	private WebElement createNewUserContactDetailsEmergencyContactName1;

	@FindBy(xpath = "//mat-select[@formcontrolname = 'relationShipCnt1']")
	private WebElement createNewUserContactDetailsRelationshipEmergencyContact1;

	@FindBy(xpath = "//input[@formcontrolname = 'phoneNum1']")
	private WebElement createNewUserContactDetailsPhoneNumberEmergencyContact1;

	@FindBy(xpath = "//input[@formcontrolname = 'phoneNum1']/../../following-sibling::div" + "/div/mat-error")
	private WebElement createNewUserContactDetailsPhoneNumberEmergencyContact1ErrorText;

	@FindBy(xpath = "//a[contains(text(),'Add another emergency contact')]")
	private WebElement createNewUserContactDetailsAddEmergencyContact;

	@FindBy(xpath = "//input[@formcontrolname = 'emcyCntName2']")
	private WebElement createNewUserContactDetailsEmergencyContactName2;

	@FindBy(xpath = "//mat-select[@formcontrolname = 'relationShipCnt2']")
	private WebElement createNewUserContactDetailsRelationshipEmergencyContact2;

	@FindBy(xpath = "//input[@formcontrolname = 'phoneNum2']")
	private WebElement createNewUserContactDetailsPhoneNumberEmergencyContact2;

	@FindBy(xpath = "//input[@formcontrolname = 'phoneNum2']/../../following-sibling::div" + "/div/mat-error")
	private WebElement createNewUserContactDetailsPhoneNumberEmergencyContact2ErrorText;

	@FindBy(xpath = "(//span[contains(text(),'Back')]/parent::button)[1]")
	private WebElement createNewUserContactDetailsBackButton;

	@FindBy(xpath = "(//span[contains(text(),'Next')]/parent::button)[2]")
	private WebElement createNewUserContactDetailsNextButton;

	@FindBy(xpath = "(//span[contains(text(),'Create & Send Invite')]/parent::button)[2]")
	private WebElement createNewUserContactDetailsCreateAndSendInviteButton;

	@FindBy(xpath = "//input[@formcontrolname = 'ugDegree']")
	private WebElement createNewUserQualificationGraduationTextField;

	@FindBy(xpath = "//input[@formcontrolname = 'graduationYr1']")
	private WebElement createNewUserQualificationGraduationYear1TextBox;

	@FindBy(xpath = "(//button[@aria-label='Open calendar'])[1]")
	private WebElement createNewUserQualificationGraduationCalendar;

	@FindBy(xpath = "//textarea[@formcontrolname = 'university1']")
	private WebElement createNewUserQualificationUniversity1TextArea;

	@FindBy(xpath = "//input[@formcontrolname = 'pgDegree']")
	private WebElement createNewUserQualificationMasterDegreeTextBox;

	@FindBy(xpath = "//input[@formcontrolname = 'graduationYr2']")
	private WebElement createNewUserQualificationGraduationYear2TextBox;

	@FindBy(xpath = "(//button[@aria-label='Open calendar'])[2]")
	private WebElement createNewUserQualificationMasterGraduationCalendar;

	@FindBy(xpath = "//textarea[@formcontrolname = 'university2']")
	private WebElement createNewUserQualificationUniversity2TextArea;

	@FindBy(xpath = "(//span[contains(text(),'Create & Send Invite')]/parent::button)[3]")
	private WebElement createNewUserQualificationCreateAndSendInviteButton;

	@FindBy(xpath = "(//span[contains(text(),'Back')]/parent::button)[2]")
	private WebElement createNewUserQualificationBackButton;

	private String statusXpath = "//tbody/tr[XX]/td[5]";

	private String roleXpath = "//tbody/tr[XX]/td[4]";

	private String actionButtonXpath = "//tbody/tr[XX]/td[6]/div/button";

	private String viewButtonXpath = "//tbody/tr[XX]/td[6]/button";

	private String menuXpath = "//tbody/tr[XX]/td[6]/div/div/a";

	private String usernameXpath = "//tbody/tr[XX]/td[2]/div/div";

	@FindBy(xpath = "//simple-snack-bar/span")
	private WebElement tostrText;

	@FindBy(xpath = "//span[text()='ok']/parent::button | //span[text()='OK']/parent::button")
	private WebElement tostrOKButton;

	@FindBy(xpath = "//input[@formcontrolname = 'graduationYr1']/parent::div"
			+ "/../following-sibling::div/div/mat-error/span")
	private WebElement graduationYearErrorText;

	@FindBy(xpath = "//input[@formcontrolname = 'graduationYr2']/parent::div"
			+ "/../following-sibling::div/div/mat-error/span")
	private WebElement mastersGraduationYearErrorText;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	private WebElement userCreatedSuccessfullyOKButton;

	@FindBy(xpath = "//span[contains(text(),'Edit')]/parent::button")
	private WebElement editButton;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	private WebElement editSaveButton;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	private WebElement editCancelButton;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	private WebElement updateSuccessfullOkButton;

	@FindBy(xpath = "//div[contains(text(),'User Updated Successfully')]")
	private WebElement updateSuccessfullPopup;

	@FindBy(xpath = "//input[@formcontrolname = 'mobileNumber']")
	private WebElement editUserDetailsPhoneNumber;

	@FindBy(xpath = "//textarea[@formcontrolname = 'permanentAdd']")
	private WebElement editCommunicationDetailsPermanentAddress;

	@FindBy(xpath = "//input[@formcontrolname = 'emcyName']")
	private WebElement editEmergencyContactName1;

	@FindBy(xpath = "//mat-select[@formcontrolname = 'relationship']")
	private WebElement editEmergencyContact1RelationShip;

	@FindBy(xpath = "//input[@formcontrolname = 'phoneNumber']")
	private WebElement editEmergencyContact1PhoneNumber;

	@FindBy(xpath = "//input[@formcontrolname = 'emcyName2']")
	private WebElement editEmergencyContactName2;

	@FindBy(xpath = "//mat-select[@formcontrolname = 'relationship2']")
	private WebElement editEmergencyContact2RelationShip;

	@FindBy(xpath = "//input[@formcontrolname = 'phoneNumber2']")
	private WebElement editEmergencyContact2PhoneNumber;

	@FindBy(xpath = "//input[@formcontrolname = 'ugYear']")
	private WebElement editQualificationUGGraduationYear;

	@FindBy(xpath = "//input[@formcontrolname = 'underGraduate']")
	private WebElement editQualificationUGDegree;

	@FindBy(xpath = "//input[@formcontrolname = 'UgUniversity']")
	private WebElement editQualificationUGUniversity;

	@FindBy(xpath = "//input[@formcontrolname = 'postGraduate']")
	private WebElement eidtQualificationPGDegree;

	@FindBy(xpath = "//input[@formcontrolname = 'pgYear']")
	private WebElement editQualificationPGGraduationYear;

	@FindBy(xpath = "//input[@formcontrolname = 'pgUniversity']")
	private WebElement editQualificationPGUniversity;

	@FindBy(xpath = "//span[contains(text(),'Yes')]/parent::button")
	private WebElement editCancelYesButton;

	@FindBy(xpath = "//button[contains(text(),'No')]")
	private WebElement editCancelNoButton;

	@FindBy(xpath = "(//input[@placeholder='Search'])[2]")
	private WebElement userSearch;

	@FindBy(xpath = "//mat-icon[contains(text(),'search')]")
	private WebElement searchIcon;

	@FindBy(xpath = "//div[@class = 'profile-image']/../../div[2]/div")
	private WebElement viewFullNameText;

	@FindBy(xpath = "//mat-label[contains(text(),'Role')]/following-sibling::span")
	private WebElement viewRoleText;

	@FindBy(xpath = "//mat-label[contains(text(),'Email ID')]/following-sibling::span")
	private WebElement viewEmaiIDText;

	@FindBy(xpath = "//mat-label[contains(text(),'Phone Number')]/following-sibling::span")
	private WebElement viewPhoneNumberText;

	@FindBy(xpath = "//a[contains(text(),'User Management')]")
	private WebElement ViewPageUserManagementLink;

	@FindBy(xpath = "//h5[contains(text(),'Block User')]")
	private WebElement blockUserPopupHeading;

	@FindBy(xpath = "//h5[contains(text(),'Pause User')]")
	private WebElement pauseUserPopupHeading;

	@FindBy(xpath = "//h5[contains(text(),'Resume User')]")
	private WebElement resumeUserPopupHeading;

	@FindBy(xpath = "//span[contains(text(),'Edit')]/parent::button")
	private WebElement viewEditButton;

	@FindBy(xpath = "//button[contains(text(),'Confirm')]")
	private WebElement confirmationPopupConfirmButton;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	private WebElement confirmationPopupCancelButton;

	@FindBy(xpath = "//button[contains(@aria-label,'Close')]")
	private WebElement confirmationPopupCloseButton;

	// Calendar xpaths.
	String selectNextToTheCurrentDate = "//div[text()='nextDate']/parent::td";

	@FindBy(xpath = "//button[@aria-label='Next month']")
	private WebElement datePickerRightArrow;

	@FindBy(xpath = "//button[@class='mat-calendar-previous-button mat-icon-button mat-button-base']")
	private WebElement leftArrowBtn;

	@FindBy(xpath = "//button[@class='mat-calendar-next-button mat-icon-button mat-button-base']")
	private WebElement rightArrowBtn;

	String currentDate = "//table[@class='mat-calendar-table']/tbody/tr/td/div[text()='Date']";

	String chooseDate = "//table[@class='mat-calendar-table']/tbody/tr/td/div[text()='selectDate']";
	String chooseMonth = "//table[@class='mat-calendar-table']/tbody/tr/td/div[text()='selectMonth']";
	String chooseYear = "//table[@class='mat-calendar-table']/tbody/tr/td/div[text()='selectYear']";

	public UserManagementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 12-FEB-2024.
	 * 
	 * Verifies if the user management page is displayed or not.
	 * 
	 * @returns true if User Management page heading is displayed or else it returns
	 *          false.
	 */
	public boolean isUserManagementPageDisplayed() {
		waitForPageLoad(this.driver);
		return userManagementHeading.isDisplayed();
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * created on 12-FEB-2024.
	 * 
	 * Click on Create Button.
	 * 
	 */
	public void clickCreateNewUserButton() {
		click(createNewUserButton);
		waitForPageLoad(this.driver);
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * created on 12-FEB-2024.
	 * 
	 * Verify Create New User Popup is displayed.
	 * 
	 * @returns true if Create New User popup heading is displayed, else false.
	 * 
	 */
	public boolean isCreateNewUserPopupDisplayed() {
		return createNewUserPopupHeading.isDisplayed();
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * created on 13-FEB-2024.
	 * 
	 * Click Next button in Create New User Basic Details Page.
	 * 
	 */
	public void clickNewUserNextButton() {
		forceClick(createNewUserBasicDetailsNextButton);
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * created on 21-FEB-2024.
	 * 
	 * Click Next button in Create New User Basic Details Page.
	 * 
	 */
	public void clickNewUserCreateAndSendInviteButton() {
		click(createNewUserBasicDetailsCreateAndSendInviteButton);
		waitForPageLoad(this.driver);
		waitForFullPageElementLoad(this.driver);
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * created on 13-FEB-2024.
	 * 
	 * To get the error text of the First Name text field in Create New User Basic
	 * Details page.
	 * 
	 * @return The error text of the first name error text.
	 * 
	 */
	public String getFirstNameErrorText() {
		waitForVisiblityOfElement(firstNameErrorText, 10);
		if (firstNameErrorText.isDisplayed()) {
			return firstNameErrorText.getText();
		} else {
			return null;
		}
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * created on 13-FEB-2024.
	 * 
	 * To get the error text of the Last Name text field in Create New User Basic
	 * Details page.
	 * 
	 * @return The error text of the last name error text.
	 * 
	 */
	public String getLastNameErrorText() {
		waitForVisiblityOfElement(lastNameErrorText, 5);
		if (lastNameErrorText.isDisplayed()) {
			return lastNameErrorText.getText();
		} else {
			return null;
		}
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * created on 27-FEB-2024.
	 * 
	 * To get the error text of the Middle Name text field in Create New User Basic
	 * Details page.
	 * 
	 * @return The error text of the middle name error text.
	 * 
	 */
	public String getMiddleNameErrorText() {
		waitForVisiblityOfElement(middleNameErrorText, 5);
		if (middleNameErrorText.isDisplayed()) {
			return middleNameErrorText.getText();
		} else {
			return null;
		}
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * created on 13-FEB-2024.
	 * 
	 * To get the error text of the Role field in Create New User Basic Details
	 * page.
	 * 
	 * @return The error text of the role error text.
	 * 
	 */
	public String getRoleErrorText() {
		waitForVisiblityOfElement(roleErrorText, 5);
		if (roleErrorText.isDisplayed()) {
			return roleErrorText.getText();
		} else {
			return null;
		}
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * created on 13-FEB-2024.
	 * 
	 * To get the error text of the Email ID field in Create New User Basic Details
	 * page.
	 * 
	 * @return The error text of the Email ID error text.
	 * 
	 */
	public String getEmailIDErrorText() {
		waitForVisiblityOfElement(emailErrorText, 5);
		if (emailErrorText.isDisplayed()) {
			return emailErrorText.getText();
		} else {
			return null;
		}
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * created on 13-FEB-2024.
	 * 
	 * To get the error text of the Phone Number field in Create New User Basic
	 * Details page.
	 * 
	 * @return The error text of the Phone Number error text.
	 * 
	 */
	public String getPhoneNumberErrorText() {
		waitForVisiblityOfElement(phoneNumberErrorText, 5);
		if (phoneNumberErrorText.isDisplayed()) {
			return phoneNumberErrorText.getText();
		} else {
			return null;
		}
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * created on 13-FEB-2024.
	 * 
	 * To enter invalid Email Id in Email Id field in Create New User Basic Details
	 * page.
	 * 
	 * @throws Exception If the Email ID is not invalid.
	 * 
	 */
	public void enterInvalidEmailID() throws Exception {

		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		String invalidEmailID = readExcel("Test Datas", "User Management", 1, 4).trim();

		Pattern pattern = Pattern.compile(emailRegex);
		if (!pattern.matcher(invalidEmailID).matches()) {
			sendKeys(createNewUserBasicDetailsMailTextBox, invalidEmailID);
		} else {
			throw new Exception("Enter a Invalid Email address.");
		}

	}

	/**
	 * Created by Nandhalala.
	 * 
	 * created on 13-FEB-2024.
	 * 
	 * To enter invalid Phone Number in Phone Number field in Create New User Basic
	 * Details page.
	 * 
	 * @throws Exception If the phone number is not invalid.
	 * 
	 */
	public void enterInvalidPhoneNumber() throws Exception {

		Pattern pattern = Pattern.compile("^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$");

		String invalidPhoneNumber = readExcel("Test Datas", "User Management", 1, 6).trim();
		String actualPhone = getPhoneNumberText();

		if (Objects.nonNull(actualPhone)) {
			createNewUserBasicDetailsPhonenumberTextBox.clear();
		}

		if (!pattern.matcher(invalidPhoneNumber).matches()) {
			sendKeys(createNewUserBasicDetailsPhonenumberTextBox, invalidPhoneNumber);
		} else {
			throw new Exception("Enter a Invalid Phone Number.");
		}

	}

	/**
	 * Created by Nandhalala.
	 * 
	 * created on 13-FEB-2024
	 * 
	 * To enter valid first name in the first name field of Create New User Basic
	 * Details page.
	 */
	public void enterValidFirstName() {
		String firstName = readExcel("Test Datas", "User Management", 1, 0).trim();
		String createdFirstName = firstName + randomNumber;
		writeExcelToOverwrite("Test Datas", "User Management", 1, 24, createdFirstName);
		String actualFirstName = createNewUserBasicDetailsFirstNameTextBox.getAttribute("value");
		if (Objects.nonNull(actualFirstName))
			createNewUserBasicDetailsFirstNameTextBox.clear();
		sendKeys(createNewUserBasicDetailsFirstNameTextBox, createdFirstName);
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * created on 13-FEB-2024
	 * 
	 * To enter valid last name in the middle name field of Create New User Basic
	 * Details page.
	 */
	public void enterValidMiddleName() {
		String middleName = readExcel("Test Datas", "User Management", 1, 1).trim();
		String createdMiddleName = middleName + randomNumber;
		writeExcelToOverwrite("Test Datas", "User Management", 1, 26, createdMiddleName);
		String actualMiddleName = createNewUserBasicDetailsMiddleNameTextBox.getAttribute("value");
		if (Objects.nonNull(actualMiddleName))
			createNewUserBasicDetailsMiddleNameTextBox.clear();
		sendKeys(createNewUserBasicDetailsMiddleNameTextBox, createdMiddleName);
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * created on 13-FEB-2024
	 * 
	 * To enter valid last name in the last name field of create new user popup.
	 */
	public void enterValidLastName() {
		String lastName = readExcel("Test Datas", "User Management", 1, 2).trim();
		String createdLastName = lastName + randomNumber;
		writeExcelToOverwrite("Test Datas", "User Management", 1, 25, createdLastName);
		String actualLastName = createNewUserBasicDetailsLastNameTextBox.getAttribute("value");
		if (Objects.nonNull(actualLastName))
			createNewUserBasicDetailsLastNameTextBox.clear();
		sendKeys(createNewUserBasicDetailsLastNameTextBox, createdLastName);
	}

	/**
	 * Created by Nandhalala.
	 */
	public void selectRole() {
		String role = readExcel("Test Datas", "User Management", 1, 3).trim();
		String actualRole;
		try {
			actualRole = driver.findElement(By.xpath("//mat-select[@formcontrolname = 'role']/div/div/span/span"))
					.getText();
		} catch (NoSuchElementException e) {
			actualRole = "";
		} catch (StaleElementReferenceException e) {
			actualRole = "";
		}
		if (!actualRole.equals(role) && Objects.nonNull(actualRole)) {
			click(createNewUserBasicDetailsRoleDropdown);
			String roleXpath = dropdownOptions.replaceAll("XX", role);
			driver.findElement(By.xpath(roleXpath)).click();
		}

	}

	/**
	 * Created by Nandhalala.
	 * 
	 * created on 13-FEB-2024.
	 * 
	 * To enter valid Email Id in Email Id field of Create New User Basic Details
	 * page.
	 * 
	 * @throws Exception If the Email ID is not valid.
	 * 
	 */
	public void enterValidEmailID() throws Exception {

		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		// String validEmailID = readExcel("Test Datas", "User Management", 1,
		// 5).trim();
		String email = readExcel("Test Datas", "User Management", 1, 2).trim().toLowerCase()
				+ readExcel("Test Datas", "User Management", 1, 0).trim().toLowerCase() + randomNumber + "@"
				+ "mailinator.com";

		writeExcelToOverwrite("Test Datas", "User Management", 1, 27, email);
		Pattern pattern = Pattern.compile(emailRegex);
		if (pattern.matcher(email).matches()) {
			createNewUserBasicDetailsMailTextBox.clear();
			sendKeys(createNewUserBasicDetailsMailTextBox, email);
		} else {
			throw new Exception("Enter a Invalid Email address.");
		}

	}

	/**
	 * Created by Nandhalala.
	 * 
	 * created on 13-MAR-2024.
	 * 
	 * To enter valid duplicate Email Id in Email Id field of Create New User Basic
	 * Details page.
	 * 
	 * @throws Exception If the Email ID is not valid.
	 * 
	 */
	public void enterValidDuplicateEmailID() throws Exception {

		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		// String validEmailID = readExcel("Test Datas", "User Management", 1,
		// 5).trim();
//		String email = readExcel("Test Datas", "User Management", 1, 2).trim().toLowerCase()+
//				readExcel("Test Datas", "User Management", 1, 0).trim().toLowerCase()
//				+randomNumber
//				+"@"+"mailinator.com";
//		
//		writeExcelToOverwrite("Test Datas", "User Management", 1, 27, email);
		String email = readExcel("Test Datas", "User Management", 1, 27).trim();
		Pattern pattern = Pattern.compile(emailRegex);
		if (pattern.matcher(email).matches()) {
			createNewUserBasicDetailsMailTextBox.clear();
			sendKeys(createNewUserBasicDetailsMailTextBox, email);
		} else {
			throw new Exception("Enter a Invalid Email address.");
		}

	}

	/**
	 * Created by Nandhalala.
	 * 
	 * created on 13-FEB-2024.
	 * 
	 * To enter valid Phone Number in Phone Number field of Create New User Basic
	 * Details page.
	 * 
	 * @throws Exception If the phone number is not valid.
	 * 
	 */
	public void enterValidPhoneNumber() throws Exception {

		// Pattern pattern = Pattern.compile("^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[-
		// .]?\\d{4}$");

//		String validPhoneNumber = readExcel("Test Datas", "User Management", 1, 7).trim();
		String phonenumber = randomMobileNumber();
		writeExcelToOverwrite("Test Datas", "User Management", 1, 7, phonenumber);
//		if(pattern.matcher(validPhoneNumber).matches()){
		createNewUserBasicDetailsPhonenumberTextBox.clear();
		sendKeys(createNewUserBasicDetailsPhonenumberTextBox, phonenumber);
//		}else {
//			throw new Exception("Enter a Valid Phone Number.");
//		}

	}

	/**
	 * Created by Nandhalala.
	 * 
	 * created on 13-MAR-2024.
	 * 
	 * To enter valid duplicate Phone Number in Phone Number field of Create New
	 * User Basic Details page.
	 * 
	 * @throws Exception If the phone number is not valid.
	 * 
	 */
	public void enterValidDuplicatePhoneNumber() throws Exception {

		// Pattern pattern = Pattern.compile("^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[-
		// .]?\\d{4}$");

//		String validPhoneNumber = readExcel("Test Datas", "User Management", 1, 7).trim();
//		String phonenumber = randomMobileNumber();
		String phonenumber = readExcel("Test Datas", "User Management", 1, 7).trim();
//		if(pattern.matcher(validPhoneNumber).matches()){
		createNewUserBasicDetailsPhonenumberTextBox.clear();
		sendKeys(createNewUserBasicDetailsPhonenumberTextBox, phonenumber);
//		}else {
//			throw new Exception("Enter a Valid Phone Number.");
//		}

	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 13-MAR-2024.
	 * 
	 * Upload image of size more then 1MB in create new user page.
	 */
	public void uploadImageMoreThan1MB() {
		createNewUserBasicDetailsImageUploadInput
				.sendKeys(System.getProperty("user.dir") + "//User Management Images//MoreThan1MB.jpg");
		sleep(1000);
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 13-MAR-2024.
	 * 
	 * Upload image of unsupported format in create new user page.
	 */
	public void uploadUnsupportedFormatImage() {
		createNewUserBasicDetailsImageUploadInput
				.sendKeys(System.getProperty("user.dir") + "//User Management Images//JFIF Format.jfif");
		sleep(1000);
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 13-MAR-2024.
	 * 
	 * Upload image of supported format in create new user page.
	 */
	public void uploadSupportedFormatImage() {
		createNewUserBasicDetailsImageUploadInput
				.sendKeys(System.getProperty("user.dir") + "//User Management Images//JPG.jpg");
		sleep(1000);
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 13-MAR-2024.
	 * 
	 * @return True if profile picture is displayed else false.
	 */
	public boolean isProfilePictureDisplayed() {
		return profileImage.isDisplayed();
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * created on 15-FEB-2024.
	 * 
	 * To enter invalid Phone Number in Phone Number field of Create New User
	 * Contact Details Page.
	 * 
	 * @throws Exception If the phone number is not invalid.
	 * 
	 */
	public void enterInvalidPhoneNumberEmergencyContact1() throws Exception {

		Pattern pattern = Pattern.compile("^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$");

		String invalidPhoneNumber = readExcel("Test Datas", "User Management", 1, 6).trim();

		if (!pattern.matcher(invalidPhoneNumber).matches()) {
			sendKeys(createNewUserContactDetailsPhoneNumberEmergencyContact1, invalidPhoneNumber);
		} else {
			throw new Exception("Enter a Invalid Phone Number.");
		}

	}

	/**
	 * Created by Nandhalala.
	 * 
	 * created on 15-FEB-2024.
	 * 
	 * To get the error text of the Phone Number field in Create New User Contact
	 * Details page.
	 * 
	 * @return The error text of the Phone Number error text.
	 * 
	 */
	public String getPhoneNumberErrorTextEmergenyContact1() {
		waitForVisiblityOfElement(createNewUserContactDetailsPhoneNumberEmergencyContact1ErrorText, 5);
		if (createNewUserContactDetailsPhoneNumberEmergencyContact1ErrorText.isDisplayed()) {
			return createNewUserContactDetailsPhoneNumberEmergencyContact1ErrorText.getText();
		} else {
			return null;
		}
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * created on 16-FEB-2024.
	 * 
	 * To enter invalid Phone Number in Phone Number field of Create New User
	 * Contact Details Page.
	 * 
	 * @throws Exception If the phone number is not invalid.
	 * 
	 */
	public void enterInvalidPhoneNumberEmergencyContact2() throws Exception {

		Pattern pattern = Pattern.compile("^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$");

		String invalidPhoneNumber = readExcel("Test Datas", "User Management", 1, 6).trim();

		if (!pattern.matcher(invalidPhoneNumber).matches()) {
			sendKeys(createNewUserContactDetailsPhoneNumberEmergencyContact2, invalidPhoneNumber);
		} else {
			throw new Exception("Enter a Invalid Phone Number.");
		}

	}

	/**
	 * Created by Nandhalala.
	 * 
	 * created on 16-FEB-2024.
	 * 
	 * To get the error text of the Phone Number field in Create New User Contact
	 * Details page.
	 * 
	 * @return The error text of the Phone Number error text.
	 * 
	 */
	public String getPhoneNumberErrorTextEmergenyContact2() {
		waitForVisiblityOfElement(createNewUserContactDetailsPhoneNumberEmergencyContact2ErrorText, 5);
		if (createNewUserContactDetailsPhoneNumberEmergencyContact2ErrorText.isDisplayed()) {
			return createNewUserContactDetailsPhoneNumberEmergencyContact2ErrorText.getText();
		} else {
			return null;
		}
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * created on 15-FEB-2024.
	 * 
	 * Click Next button in Create New User Contact Details Page.
	 * 
	 */
	public boolean clickNewUserNextButtonContactDetailsPage() {
		click(createNewUserContactDetailsNextButton);
		sleep(1000);
		if (createNewUserQualificationGraduationTextField.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * created on 16-FEB-2024.
	 * 
	 * Click Add Emergency Contact button in Create New User Contact Details Page.
	 * 
	 */
	public void clickAddEmergencyContactButton() {
		click(createNewUserContactDetailsAddEmergencyContact);
		try {
			createNewUserContactDetailsAddEmergencyContact.isDisplayed();
			log(Status.FAIL, "Add emergency button is displayed");
		} catch (NoSuchElementException e) {
			log(Status.PASS, "Add emergency button is not displayed");
		}

	}

	/**
	 * Created by Nandhalala.
	 * 
	 * created on 16-FEB-2024.
	 * 
	 * Click Emergency Contact Text in Create New User Contact Details Page.
	 * 
	 */
	public void clickEmergencyContactText() {
		click(emergencyContactHeading);
	}

	/**
	 * Created by Nandhalala
	 * 
	 * @return rownumber of the firstname and lastname given.
	 */
	public String getRowNumber() {

		waitForPageLoad(this.driver);
		String firstName = readExcel("Test Datas", "User Management", 1, 24).trim();
		String lastName = readExcel("Test Datas", "User Management", 1, 25).trim();
		int i = 1;
		String userName = usernameXpath.replace("[XX]", "");
		// String userName = usernameXpath.replaceAll("[XX]", "");
		List<WebElement> userNames = this.driver.findElements(By.xpath(userName));
		for (WebElement username : userNames) {
//			System.out.println(username.getText()+"/t"+firstName+" "+lastName);
			waitForVisiblityOfElement(username, 10);
			if (username.getText().equals(firstName + " " + lastName)) {
				return Integer.toString(i);
			}
			i++;
		}
		return null;

	}

	/**
	 * Created by Nandhalala
	 * 
	 * @param rowNumber should be from 1 to 5.
	 * 
	 * @return status of the given row.
	 * @throws Exception if the row number is not between 1 and 5.
	 */
	public String getStatus(String rowNumber) throws Exception {

		if (rowNumber.toCharArray().length > 1 && !(rowNumber.charAt(0) >= '1' && rowNumber.charAt(0) <= '5')) {
			throw new Exception("The row number should be 1 or 2 or 3 or 4 or 5.");
		}

		String statusxpath = statusXpath.replaceAll("XX", rowNumber);
		return this.driver.findElement(By.xpath(statusxpath)).getText().trim();
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 07-MAR-2024.
	 * 
	 * @param rowNumber should be from 1 to 5.
	 * 
	 * @return role of the given row.
	 * @throws Exception if the row number is not between 1 and 5.
	 */
	public String getRole(String rowNumber) throws Exception {

		if (rowNumber.toCharArray().length > 1 && !(rowNumber.charAt(0) >= '1' && rowNumber.charAt(0) <= '5')) {
			throw new Exception("The row number should be 1 or 2 or 3 or 4 or 5.");
		}

		String rolexpath = roleXpath.replaceAll("XX", rowNumber);
		return this.driver.findElement(By.xpath(rolexpath)).getText().trim();
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 06-MAR-2024.
	 * 
	 * Click the view button of the user.
	 * 
	 * @param rowNumber should be from 1 to 5.
	 * 
	 * 
	 * @throws Exception if the row number is not between 1 and 5.
	 */
	public void viewButton(String rowNumber) throws Exception {

		if (rowNumber.toCharArray().length > 1 && !(rowNumber.charAt(0) >= '1' && rowNumber.charAt(0) <= '5')) {
			throw new Exception("The row number should be 1 or 2 or 3 or 4 or 5.");
		}

		String viewxpath = viewButtonXpath.replaceAll("XX", rowNumber);
		click(this.driver.findElement(By.xpath(viewxpath)));
		waitForPageLoad(this.driver);
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * @param rowNumber of the user for whom the menu options needed.
	 * @return The menu options of the user
	 * @throws Exception if the row number is not between 1 and 5.
	 */
	public List<String> getMenuOptions(String rowNumber) throws Exception {
		if (rowNumber.toCharArray().length > 1 && !(rowNumber.charAt(0) >= '1' && rowNumber.charAt(0) <= '5')) {
			throw new Exception("The row number should be 1 or 2 or 3 or 4 or 5.");
		}

		String menuxpath = actionButtonXpath.replaceAll("XX", rowNumber);
		this.driver.findElement(By.xpath(menuxpath)).click();
		String menus = menuXpath.replaceAll("XX", rowNumber);
		List<WebElement> menuOptions = this.driver.findElements(By.xpath(menus));
		List<String> optionValues = new ArrayList<>();
		for (WebElement menuOption : menuOptions) {
			optionValues.add(menuOption.getText());
		}

		return optionValues;

	}

	/**
	 * 
	 * Created by Nandhalala.
	 * 
	 * 
	 * Get the tostr text message.
	 * 
	 * @return The tostr text message
	 */
	public String getTostrText() {

		waitForVisiblityOfElement(tostrText, 10);
		return tostrText.getText();
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Click ok button in tostr message.
	 */
	public void clickTostrOkButton() {
		try {
			click(tostrOKButton);
		} catch (StaleElementReferenceException e) {

		}
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * To enter valid data in permanent address field.
	 * 
	 */
	public void enterValidPermanentAddress() {

		String permanentaddress = readExcel("Test Datas", "User Management", 1, 8).trim();
		String addr = getPermanentAddress();

		if (Objects.nonNull(addr)) {
			createNewUserContactDetailsPermanentAddress.clear();
		}

		sendKeys(createNewUserContactDetailsPermanentAddress, permanentaddress);

	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Get text from permanent address.
	 * 
	 * @return Permanent address from feilds
	 */
	public String getPermanentAddress() {
		return createNewUserContactDetailsPermanentAddress.getAttribute("value");
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * To enter valid data in residing address field.
	 * 
	 */
	public void enterValidResidingAddress() {
		String residingaddress = readExcel("Test Datas", "User Management", 1, 9).trim();
		String addr = getResidingAddress();

		if (Objects.nonNull(addr)) {
			createNewUserContactDetailsResidingAddress.clear();
		}

		sendKeys(createNewUserContactDetailsResidingAddress, residingaddress);
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Get text from residing address.
	 * 
	 * @return Residing address from feilds
	 */
	public String getResidingAddress() {
		return createNewUserContactDetailsResidingAddress.getAttribute("value");
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * To enter valid data in Emergency contact 1 Name field.
	 * 
	 */
	public void enterValidEmegrncyContact1Name() {
		String Name = readExcel("Test Datas", "User Management", 1, 10).trim();
		String name = getEmergencyContact1Name();

		if (Objects.nonNull(name)) {
			createNewUserContactDetailsEmergencyContactName1.clear();
		}

		sendKeys(createNewUserContactDetailsEmergencyContactName1, Name);
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Get text from Emergency contact 1 name.
	 * 
	 * @return Emergency contact 1 name from feilds
	 */
	public String getEmergencyContact1Name() {
		return createNewUserContactDetailsEmergencyContactName1.getAttribute("value");
	}

	/**
	 * 
	 * Created by Nandhalala.
	 * 
	 * To select emergency contact 1 relationship status.
	 * 
	 */
	public void selectValidEmegrncyContact1Relationship() {
		click(createNewUserContactDetailsRelationshipEmergencyContact1);

		String relationship = readExcel("Test Datas", "User Management", 1, 11).trim();

		String relationshipXpath = dropdownOptions.replaceAll("XX", relationship);

		click(this.driver.findElement(By.xpath(relationshipXpath)));

	}

	/**
	 * Created by Nandhalala.
	 * 
	 * @return Relationship of Emergency contact 1
	 */
	public String getEmergencyContact1Relationship() {
		return createNewUserContactDetailsRelationshipEmergencyContact1.getText();
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * To enter valid data in Emergency contact 1 phone number.
	 * 
	 */
	public void enterValidEmegrncyContact1Phone() {

		String phoneNumber = readExcel("Test Datas", "User Management", 1, 12).trim();
		String phNumber = getEmergencyContact1PhoneNumber();

		if (Objects.nonNull(phNumber)) {
			createNewUserContactDetailsPhoneNumberEmergencyContact1.clear();
		}

		sendKeys(createNewUserContactDetailsPhoneNumberEmergencyContact1, phoneNumber);

	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Get text from Emergency contact 1 phone number.
	 * 
	 * @return Emergency contact 1 phone number from feilds
	 */
	public String getEmergencyContact1PhoneNumber() {
		return createNewUserContactDetailsPhoneNumberEmergencyContact1.getAttribute("value");
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * To enter valid data in Emergency contact 2Name field.
	 * 
	 */
	public void enterValidEmegrncyContact2Name() {

		if (!createNewUserContactDetailsEmergencyContactName2.isDisplayed())
			clickAddEmergencyContactButton();

		String Name = readExcel("Test Datas", "User Management", 1, 13).trim();
		String name = getEmergencyContact2Name();

		if (Objects.nonNull(name)) {
			createNewUserContactDetailsEmergencyContactName2.clear();
		}

		sendKeys(createNewUserContactDetailsEmergencyContactName2, Name);
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Get text from Emergency contact 2 name.
	 * 
	 * @return Emergency contact 2 name from feilds
	 */
	public String getEmergencyContact2Name() {
		return createNewUserContactDetailsEmergencyContactName2.getAttribute("value");
	}

	/**
	 * 
	 * Created by Nandhalala.
	 * 
	 * To select emergency contact 2 relationship status.
	 * 
	 */
	public void selectValidEmegrncyContact2Relationship() {

		if (!createNewUserContactDetailsRelationshipEmergencyContact2.isDisplayed())
			clickAddEmergencyContactButton();

		click(createNewUserContactDetailsRelationshipEmergencyContact2);

		String relationship = readExcel("Test Datas", "User Management", 1, 14).trim();

		String relationshipXpath = dropdownOptions.replaceAll("XX", relationship);

		click(this.driver.findElement(By.xpath(relationshipXpath)));

	}

	/**
	 * Created by Nandhalala.
	 * 
	 * @return Relationship of Emergency contact 2
	 */
	public String getEmergencyContact2Relationship() {
		return createNewUserContactDetailsRelationshipEmergencyContact2.getText();
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * To enter valid data in Emergency contact 2 phone number.
	 * 
	 */
	public void enterValidEmegrncyContact2Phone() {

		if (!createNewUserContactDetailsPhoneNumberEmergencyContact2.isDisplayed())
			clickAddEmergencyContactButton();

		String phoneNumber = readExcel("Test Datas", "User Management", 1, 15).trim();
		String phNumber = getEmergencyContact2PhoneNumber();

		if (Objects.nonNull(phNumber)) {
			createNewUserContactDetailsPhoneNumberEmergencyContact2.clear();
		}

		sendKeys(createNewUserContactDetailsPhoneNumberEmergencyContact2, phoneNumber);

	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Get text from Emergency contact 2 phone number.
	 * 
	 * @return Emergency contact 2 phone number from feilds
	 */
	public String getEmergencyContact2PhoneNumber() {
		return createNewUserContactDetailsPhoneNumberEmergencyContact2.getAttribute("value");
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Enters invalid date in graduation field.
	 */
	public void enterInvalidGraduationDate() {
		String invalidDate = readExcel("Test Datas", "User Management", 1, 16).trim();
		String date = getGraduationDate();

		if (Objects.nonNull(date)) {
			createNewUserQualificationGraduationYear1TextBox.clear();
		}

		sendKeys(createNewUserQualificationGraduationYear1TextBox, invalidDate);
	}

	/**
	 * Created by Nandhalala
	 * 
	 * @return The Graduation date
	 */
	public String getGraduationDate() {
		return createNewUserQualificationGraduationYear1TextBox.getText();
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Enters invalid date in master's degree graduation field.
	 */
	public void enterInvalidMastersGraduationDate() {
		String invalidDate = readExcel("Test Datas", "User Management", 1, 16).trim();
		String s = invalidDate.substring(invalidDate.length() - 4, invalidDate.length() - 1);
		int y = Integer.parseInt(s);
		String ch = Integer.toString(--y);
		invalidDate = invalidDate.replaceAll(s, ch);
		String date = getMasterGraduationDate();

		if (Objects.nonNull(date)) {
			createNewUserQualificationGraduationYear2TextBox.clear();
		}

		sendKeys(createNewUserQualificationGraduationYear2TextBox, invalidDate);
		sleep(2000);
		createNewUserQualificationMasterDegreeTextBox.click();
	}

	/**
	 * Created by Nandhalala
	 * 
	 * @return The Graduation date
	 */
	public String getMasterGraduationDate() {
		return createNewUserQualificationGraduationYear2TextBox.getAttribute("value");
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * @return The error text of the graduation year field.
	 * 
	 * @throws Exception If the Error text is not displayed.
	 */
	public String getGraduationYearErrorText() throws Exception {
		if (graduationYearErrorText.isDisplayed()) {
			return graduationYearErrorText.getText().trim();
		} else {
			throw new Exception("Graduation date Error text is not displayed.");
		}
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * @return The error text of the master's graduation year field.
	 * 
	 * @throws Exception If the Error text is not displayed.
	 */
	public String getMastersGraduationYearErrorText() throws Exception {
		waitForVisiblityOfElement(mastersGraduationYearErrorText, 10);
		if (mastersGraduationYearErrorText.isDisplayed()) {
			return mastersGraduationYearErrorText.getText().trim();
		} else {
			throw new Exception("Master's Graduation date Error text is not displayed.");
		}
	}

	/**
	 * 
	 * Created by Nandhalala.
	 * 
	 * Created on 26-FEB-2024.
	 * 
	 * Enter valid data in graduation field.
	 * 
	 */
	public void enterValidGraduation() {
		String degree = readExcel("Test Datas", "User Management", 1, 17).trim();
		String graduation = getGraduation();

		if (Objects.nonNull(graduation)) {
			createNewUserQualificationGraduationTextField.clear();
		}

		sendKeys(createNewUserQualificationGraduationTextField, degree);
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 26-FEB-2024.
	 * 
	 * @return The Graduation Degree.
	 * 
	 */
	public String getGraduation() {
		return createNewUserQualificationGraduationTextField.getAttribute("value").trim();
	}

	/**
	 * 
	 * Created by Nandhalala.
	 * 
	 * Created on 26-FEB-2024.
	 * 
	 * Enter valid data in graduation year.
	 * 
	 */
	public void enterValidGraduationYear() {
		String year = readExcel("Test Datas", "User Management", 1, 18).trim();
		String graduationYear = getGraduationYear();
		if (Objects.nonNull(graduationYear)) {
			for (int i = 0; i < graduationYear.length(); i++)
				createNewUserQualificationGraduationYear1TextBox.sendKeys(Keys.BACK_SPACE);
		}

		sendKeys(createNewUserQualificationGraduationYear1TextBox, year);

	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 26-FEB-2024
	 * 
	 * @return The Graduation year.
	 * 
	 */
	public String getGraduationYear() {
		return createNewUserQualificationGraduationYear1TextBox.getAttribute("value").trim();
	}

	/**
	 * 
	 * Created by Nandhalala.
	 * 
	 * Created on 26-FEB-2024
	 * 
	 * Enter valid data in graduation University.
	 * 
	 */
	public void enterValidGraduationUniversity() {
		String university = readExcel("Test Datas", "User Management", 1, 19).trim();
		String graduationUniversity = getGraduationUniversity();

		if (Objects.nonNull(graduationUniversity)) {
			createNewUserQualificationUniversity1TextArea.clear();
		}

		sendKeys(createNewUserQualificationUniversity1TextArea, university);
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 27-FEB-2024
	 * 
	 * @return The Graduation University.
	 * 
	 */
	public String getGraduationUniversity() {
		return createNewUserQualificationUniversity1TextArea.getAttribute("value").trim();
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 27-FEB-2024
	 * 
	 * Enter valid data in master degree field.
	 * 
	 */
	public void enterValidMasterGraduation() {
		String degree = readExcel("Test Datas", "User Management", 1, 20).trim();
		String graduation = getMasterGraduation();

		if (Objects.nonNull(graduation)) {
			createNewUserQualificationMasterDegreeTextBox.clear();
		}
		sendKeys(createNewUserQualificationMasterDegreeTextBox, degree);
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 27-FEB-2024
	 * 
	 * @return The Master Graduation degree.
	 * 
	 */
	public String getMasterGraduation() {
		return createNewUserQualificationMasterDegreeTextBox.getAttribute("value").trim();
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 27-FEB-2024
	 * 
	 * Enter valid data in master Graduation year field.
	 * 
	 */
	public void enterValidMasterGraduationYear() {
		String year = readExcel("Test Datas", "User Management", 1, 21).trim();
		String graduationYear = getMasterGraduationYear();

		if (Objects.nonNull(graduationYear)) {
			for (int i = 0; i < graduationYear.length(); i++)
				createNewUserQualificationGraduationYear2TextBox.sendKeys(Keys.BACK_SPACE);
		}
		sendKeys(createNewUserQualificationGraduationYear2TextBox, year);
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 27-FEB-2024
	 * 
	 * @return The Master Graduation Year.
	 * 
	 */
	public String getMasterGraduationYear() {
		return createNewUserQualificationGraduationYear2TextBox.getAttribute("value").trim();
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 27-FEB-2024
	 * 
	 * Enter valid data in master graduation university field.
	 * 
	 */
	public void enterValidMasterGraduationUniversity() {
		String university = readExcel("Test Datas", "User Management", 1, 22).trim();
		String univ = getMasterGraduationUniversity();

		if (Objects.nonNull(univ)) {
			createNewUserQualificationUniversity2TextArea.clear();
		}
		sendKeys(createNewUserQualificationUniversity2TextArea, university);
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 27-FEB-2024
	 * 
	 * @return The Master Graduation University.
	 * 
	 */
	public String getMasterGraduationUniversity() {
		return createNewUserQualificationUniversity2TextArea.getAttribute("value").trim();
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 13-MAR-2024.
	 * 
	 * Click the graduation calendar icon.
	 * 
	 */
	public void clickGraduationCalendarIcon() {

		String graduationYear = getGraduationYear();
		if (Objects.nonNull(graduationYear)) {
			for (int i = 0; i < graduationYear.length(); i++)
				createNewUserQualificationGraduationYear1TextBox.sendKeys(Keys.BACK_SPACE);
		}

		createNewUserQualificationGraduationCalendar.click();
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 13-MAR-2024.
	 * 
	 * Click the graduation calendar icon.
	 * 
	 */
	public void clickMasterGraduationCalendarIcon() {

		String graduationYear = getMasterGraduationYear();
		System.out.println(graduationYear);
		if (Objects.nonNull(graduationYear)) {
			for (int i = 0; i < graduationYear.length(); i++)
				createNewUserQualificationGraduationYear2TextBox.sendKeys(Keys.BACK_SPACE);
		}

		createNewUserQualificationGraduationCalendar.click();
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 27-FEB-2024
	 * 
	 * Enter data on first name field with over the limit of the field.
	 * 
	 * @throws Exception
	 * 
	 */
	public void enterOverLimitFirstName() throws Exception {
		String overlimitText = readExcel("Test Datas", "User Management", 1, 23).trim();
		String actual = getFirstNameText();

		if (Objects.nonNull(actual)) {
			createNewUserBasicDetailsFirstNameTextBox.clear();
		}
		if (overlimitText.length() > 30)
			sendKeys(createNewUserBasicDetailsFirstNameTextBox, overlimitText);
		else
			throw new Exception(
					"The text to verify limit of the first name field is less " + "than the limit '30' characters.");

		createNewUserBasicDetailsLastNameTextBox.click();
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 27-FEB-2024.
	 * 
	 * @return The firstName text.
	 * 
	 */
	public String getFirstNameText() {
		return createNewUserBasicDetailsFirstNameTextBox.getAttribute("value").trim();
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 27-FEB-2024
	 * 
	 * Enter data on last name field with over the limit of the field.
	 * 
	 * @throws Exception
	 * 
	 */
	public void enterOverLimitLastName() throws Exception {
		String overlimitText = readExcel("Test Datas", "User Management", 1, 23).trim();
		String actual = getLastNameText();

		if (Objects.nonNull(actual)) {
			createNewUserBasicDetailsLastNameTextBox.clear();
		}
		if (overlimitText.length() > 30)
			sendKeys(createNewUserBasicDetailsLastNameTextBox, overlimitText);
		else
			throw new Exception(
					"The text to verify limit of the last name field is less " + "than the limit '30' characters.");

		createNewUserBasicDetailsMiddleNameTextBox.click();
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 27-FEB-2024.
	 * 
	 * @return The lastName text.
	 * 
	 */
	public String getLastNameText() {
		return createNewUserBasicDetailsLastNameTextBox.getAttribute("value").trim();
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 27-FEB-2024
	 * 
	 * Enter data on middle name field with over the limit of the field.
	 * 
	 * @throws Exception
	 * 
	 */
	public void enterOverLimitMiddleName() throws Exception {
		String overlimitText = readExcel("Test Datas", "User Management", 1, 23).trim();
		String actual = getMiddleNameText();

		if (Objects.nonNull(actual)) {
			createNewUserBasicDetailsMiddleNameTextBox.clear();
		}
		if (overlimitText.length() > 30)
			sendKeys(createNewUserBasicDetailsMiddleNameTextBox, overlimitText);
		else
			throw new Exception(
					"The text to verify limit of the middle name field is less " + "than the limit '30' characters.");

		createNewUserBasicDetailsFirstNameTextBox.click();
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 27-FEB-2024.
	 * 
	 * @return The lastName text.
	 * 
	 */
	public String getMiddleNameText() {
		return createNewUserBasicDetailsMiddleNameTextBox.getAttribute("value").trim();
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 27-FEB-2024.
	 * 
	 * @return The phone numbber text.
	 * 
	 */
	public String getPhoneNumberText() {
		return createNewUserBasicDetailsPhonenumberTextBox.getAttribute("value").trim();
	}

	/**
	 * 
	 * Created by Nandhalala.
	 * 
	 * Created on 01-MAR-2024.
	 * 
	 * @return true is basic details page is displayed else false.
	 */
	public boolean contactDetailsBackButton() {
		click(createNewUserContactDetailsBackButton);
		sleep(1000);
		if (createNewUserBasicDetailsFirstNameTextBox.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * Created by Nandhalala.
	 * 
	 * Created on 01-MAR-2024.
	 * 
	 * @return true is basic details page is displayed else false.
	 */
	public boolean qualificationBackButton() {
		click(createNewUserQualificationBackButton);
		sleep(1000);
		if (createNewUserContactDetailsEmergencyContactName1.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 03-MAR-2024.
	 * 
	 * Click Create and send invite button from contact details page.
	 * 
	 */
	public void contactDeailsCreateButton() {
		click(createNewUserContactDetailsCreateAndSendInviteButton);
		sleep(1000);
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 03-MAR-2024.
	 * 
	 * Click Create and send invite button from qualification page.
	 * 
	 */
	public void qualificationCreateButton() {
		click(createNewUserQualificationCreateAndSendInviteButton);
		sleep(1000);
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 05-MAR-2024.
	 * 
	 * Click OK button in created successfully popup.
	 * 
	 */
	public void userCreatedSuccessfullyOK() {
		waitForVisiblityOfElement(userCreatedSuccessfullyOKButton, 10);
		click(userCreatedSuccessfullyOKButton);
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 06-MAR-2024.
	 * 
	 * Click the edit button.
	 */
	public void editButton() {
		waitForVisiblityOfElement(editButton, 10);
		sleep(3000);
		click(editButton);
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 06-MAR-2024.
	 * 
	 * @return Whether the fields are editable
	 */
	public boolean viewFieldsCanBeEdited() {
		waitForVisiblityOfElement(createNewUserBasicDetailsFirstNameTextBox, 10);
		if (createNewUserBasicDetailsFirstNameTextBox.isDisplayed()
				&& createNewUserBasicDetailsLastNameTextBox.isDisplayed()
				&& createNewUserBasicDetailsMiddleNameTextBox.isDisplayed()
				&& createNewUserBasicDetailsRoleDropdown.isDisplayed()
				&& createNewUserBasicDetailsMailTextBox.isDisplayed() && editUserDetailsPhoneNumber.isDisplayed()
				&& editCommunicationDetailsPermanentAddress.isDisplayed()
				&& createNewUserContactDetailsResidingAddress.isDisplayed() && editEmergencyContactName1.isDisplayed()
				&& editEmergencyContact1RelationShip.isDisplayed() && editEmergencyContact1PhoneNumber.isDisplayed()
				&& editEmergencyContactName2.isDisplayed() && editEmergencyContact2RelationShip.isDisplayed()
				&& editEmergencyContact2PhoneNumber.isDisplayed() && editQualificationUGGraduationYear.isDisplayed()
				&& editQualificationUGDegree.isDisplayed() && editQualificationUGUniversity.isDisplayed()
				&& eidtQualificationPGDegree.isDisplayed() && editQualificationPGGraduationYear.isDisplayed()
				&& editQualificationUGUniversity.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 07-MAR-2024.
	 * 
	 * Edit first name.
	 */
	public void editFirstName() {
		sleep(2000);
		if (!getFirstNameText().equals(null)) {
			createNewUserBasicDetailsFirstNameTextBox.sendKeys(Keys.BACK_SPACE);
		}

	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 07-MAR-2024.
	 * 
	 * Click cancel and yes for cancel.
	 */
	public void editCancelButton() {
		click(editCancelButton);

		editCancelYesButton.click();
		waitForPageLoad(this.driver);
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 07-MAR-2024.
	 * 
	 * Edit Role of the user.
	 */
	public void editRole() {
		click(createNewUserBasicDetailsRoleDropdown);
		String role = readExcel("Test Datas", "User Management", 1, 30).trim();
		String roleXpath = dropdownOptions.replaceAll("XX", role);
		driver.findElement(By.xpath(roleXpath)).click();
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 07-MAR-2024.
	 * 
	 * Click Save button.
	 */
	public void editSaveButton() {
		click(editSaveButton);
		if (updateSuccessfullPopup.isDisplayed())
			updateSuccessfullOkButton.click();
		waitForPageLoad(this.driver);
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 07-MAR-2024.
	 * 
	 * Search using firstname.
	 */
	public void searchUserwithFirstName() {
		userSearch.sendKeys(readExcel("Test Datas", "User Management", 1, 24).trim());
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 12-MAR-2024.
	 * 
	 * @return The full name of the user from the view page.
	 */
	public String getFullNameFromViewPage() {
		return viewFullNameText.getText().trim();
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 12-MAR-2024.
	 * 
	 * @return The Role of the user from the view page.
	 */
	public String getRoleFromViewPage() {
		return viewRoleText.getText().trim();
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 12-MAR-2024.
	 * 
	 * @return The Email ID of the user from the view page.
	 */
	public String getEmailIDFromViewPage() {
		return viewEmaiIDText.getText().trim();
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 12-MAR-2024.
	 * 
	 * @return The Email ID of the user from the view page.
	 */
	public String getPhoneNumberFromViewPage() {
		return viewPhoneNumberText.getText().trim();
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 12-MAR-2024.
	 * 
	 * Navigate to user management from view page.
	 * 
	 */
	public void navigateBacktoUserManagementFromViewEditPage() {
		ViewPageUserManagementLink.click();
		waitForPageLoad(this.driver);
	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 12-MAR-2024.
	 * 
	 * @param rowNumber of the user for whom the menu options needed.
	 * @param action    need to be performed.
	 * @throws Exception if the row number is not between 1 and 5.
	 */
	public String menuAction(String rowNumber, String action) throws Exception {
		if (rowNumber.toCharArray().length > 1 && !(rowNumber.charAt(0) >= '1' && rowNumber.charAt(0) <= '5')) {
			throw new Exception("The row number should be 1 or 2 or 3 or 4 or 5.");
		}

		String menuxpath = actionButtonXpath.replaceAll("XX", rowNumber);
		this.driver.findElement(By.xpath(menuxpath)).click();
		String menus = menuXpath.replaceAll("XX", rowNumber);
		List<WebElement> menuOptions = this.driver.findElements(By.xpath(menus));
		for (WebElement menuOption : menuOptions) {
			waitForVisiblityOfElementwithException(menuOption, 10);
			if (menuOption.getText().equals(action)) {
				menuOption.click();
				break;
			}
		}
		if (!(action.equals("Resend Invite") || action.equals("Show QR Code"))) {
			boolean isHeadingDisplayed = switch (action) {
			case "Pause":
				yield pauseUserPopupHeading.isDisplayed();
			case "Resume":
				yield resumeUserPopupHeading.isDisplayed();
			case "Block":
				yield blockUserPopupHeading.isDisplayed();
			default:
				throw new IllegalArgumentException("Unexpected value: " + action);
			};
			if (isHeadingDisplayed)
				confirmationPopupConfirmButton.click();
			else
				throw new Exception("Block/Pause/Resume Popup is not displayed");
			String tostrText = getTostrText();
			clickTostrOkButton();
			return tostrText;
		}
		this.driver.findElement(By.xpath(menuxpath)).click();
		return null;
//		boolean isHeadingDisplayed = switch(action) {
//		case "Pause" :
//			yield pauseUserPopupHeading.isDisplayed();
//		case "Resume":
//			yield resumeUserPopupHeading.isDisplayed();
//		case "Block":
//			yield blockUserPopupHeading.isDisplayed();
//		default:
//			throw new IllegalArgumentException("Unexpected value: " + action);
//		};
//		if(isHeadingDisplayed)
//			confirmationPopupConfirmButton.click();
//		else
//			throw new Exception("Block/Pause/Resume Popup is not displayed");
//		String tostrText = getTostrText();
//		clickTostrOkButton();
//		return tostrText;

	}

	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 13-MAR-2024.
	 * 
	 * @return The disabled status of the edit button.
	 */
	public String getEditbuttonDisabledStatus() {
		return viewEditButton.getAttribute("ng-reflect-disabled").trim();
	}

	/**
	 * Copied from add individuals page.
	 * 
	 * @throws Exception
	 */
	public void futureDatesAreHidden() throws Exception {

		String currentMonth = getCurrentDtYearMonth("MM");
		String currentDate = getCurrentDtYearMonth("dd");
		String currentYear = getCurrentDtYearMonth("yyyy");

		int intEventDt = Integer.parseInt(currentDate);
		int intEventYear = Integer.parseInt(currentYear);

		if ((currentMonth.equals("01") || currentMonth.equals("03") || currentMonth.equals("05")
				|| currentMonth.equals("07") || currentMonth.equals("08") || currentMonth.equals("10")
				|| currentMonth.equals("12")) && intEventDt <= 30) {

			selectNextToTheCurrentDate = selectNextToTheCurrentDate.replaceAll("nextDate", nextToCurrentDate());
			WebElement getNextDate = findElementByXpath(selectNextToTheCurrentDate);

			String NextDate = getAttribute(getNextDate, "aria-disabled");

			if (NextDate.equals("true")) {
				log(Status.PASS, "Next to the current dates are disabled in Notification Date field");
			} else {
				log(Status.FAIL, "Next to the current dates are NOT disabled in Notification Date field");
			}

			String rightArrow = getAttribute(datePickerRightArrow, "ng-reflect-disabled");

			if (rightArrow.equalsIgnoreCase("true")) {
				log(Status.PASS, "Next Month > Right arrow is disabled");
			} else {
				log(Status.FAIL, "Next Month > Right arrow is NOT disabled");
			}

		} else if ((currentMonth.equals("01") || currentMonth.equals("03") || currentMonth.equals("05")
				|| currentMonth.equals("07") || currentMonth.equals("08") || currentMonth.equals("10")
				|| currentMonth.equals("12")) && currentDate.equals("31")) {

			String rightArrow = getAttribute(datePickerRightArrow, "ng-reflect-disabled");

			if (rightArrow.equalsIgnoreCase("true")) {
				log(Status.PASS, "Reached the Month END date Next Month > arrow is disabled");
			} else {
				log(Status.FAIL, "Reached the Month END date Next Month > arrow is NOT disabled");
			}

		} else if ((currentMonth.equals("04") || currentMonth.equals("06") || currentMonth.equals("09")
				|| currentMonth.equals("11")) && intEventDt <= 29) {

			selectNextToTheCurrentDate = selectNextToTheCurrentDate.replaceAll("nextDate", nextToCurrentDate());
			WebElement getNextDate = findElementByXpath(selectNextToTheCurrentDate);

			String NextDate = getAttribute(getNextDate, "aria-disabled");

			if (NextDate.equals("true")) {
				log(Status.PASS, "Next to the current dates are disabled in Notification Date field");
			} else {
				log(Status.FAIL, "Next to the current dates are NOT disabled in Notification Date field");
			}

			String rightArrow = getAttribute(datePickerRightArrow, "ng-reflect-disabled");

			if (rightArrow.equalsIgnoreCase("true")) {
				log(Status.PASS, "Next Month > Right arrow is disabled");
			} else {
				log(Status.FAIL, "Next Month > Right arrow is NOT disabled");
			}

		} else if ((currentMonth.equals("04") || currentMonth.equals("06") || currentMonth.equals("09")
				|| currentMonth.equals("11")) && currentDate.equals("30")) {

			String rightArrow = getAttribute(datePickerRightArrow, "ng-reflect-disabled");

			if (rightArrow.equalsIgnoreCase("true")) {
				log(Status.PASS, "Reached the Month END date Next Month > arrow is disabled");
			} else {
				log(Status.FAIL, "Reached the Month END date Next Month > arrow is NOT disabled");
			}

		} else if (currentMonth.equals("02") && intEventDt <= 28 && (intEventYear % 4 != 0)) {

			selectNextToTheCurrentDate = selectNextToTheCurrentDate.replaceAll("nextDate", nextToCurrentDate());
			WebElement getNextDate = findElementByXpath(selectNextToTheCurrentDate);

			String NextDate = getAttribute(getNextDate, "aria-disabled");

			if (NextDate.equals("true")) {
				log(Status.PASS, "Next to the current dates are disabled in Notification Date field");
			} else {
				log(Status.FAIL, "Next to the current dates are NOT disabled in Notification Date field");
			}

			String rightArrow = getAttribute(datePickerRightArrow, "ng-reflect-disabled");

			if (rightArrow.equalsIgnoreCase("true")) {
				log(Status.PASS, "Next Month > Right arrow is disabled");
			} else {
				log(Status.FAIL, "Next Month > Right arrow is NOT disabled");
			}

		} else if (currentMonth.equals("02")
				&& ((intEventDt > 28 && (intEventYear % 4 == 0)) || (intEventDt == 28 && (intEventYear % 4 != 0)))) {

			String rightArrow = getAttribute(datePickerRightArrow, "ng-reflect-disabled");

			if (rightArrow.equalsIgnoreCase("true")) {
				log(Status.PASS, "Reached the Month END date Next Month > arrow is disabled");
			} else {
				log(Status.FAIL, "Reached the Month END date Next Month > arrow is NOT disabled");
			}

		} else if (currentMonth.equals("02") && intEventDt == 28 && (intEventYear % 4 == 0)) {

			selectNextToTheCurrentDate = selectNextToTheCurrentDate.replaceAll("nextDate", nextToCurrentDate());
			WebElement getNextDate = findElementByXpath(selectNextToTheCurrentDate);

			String NextDate = getAttribute(getNextDate, "aria-disabled");

			if (NextDate.equals("true")) {
				log(Status.PASS, "Next to the current dates are disabled in Notification Date field");
			} else {
				log(Status.FAIL, "Next to the current dates are NOT disabled in Notification Date field");
			}

			String rightArrow = getAttribute(datePickerRightArrow, "ng-reflect-disabled");

			if (rightArrow.equalsIgnoreCase("true")) {
				log(Status.PASS, "Next Month > Right arrow is disabled");
			} else {
				log(Status.FAIL, "Next Month > Right arrow is NOT disabled");
			}
		}
	}

	/**
	 * Copied from add individuals.
	 * 
	 * @throws Exception
	 */
	public void verifyLeftAndRightArrow() {

		if (getAttribute(leftArrowBtn, "disabled").equals("true")
				&& getAttribute(rightArrowBtn, "disabled").equals("true")) {
			log(Status.PASS, "Left and Right Arrow button in datepicker is disabled");
		} else {
			log(Status.FAIL, "Left and Right Arrow button is NOT disabled");
		}

	}

	/**
	 * Copied from add individuals.
	 * 
	 * @throws Exception
	 */
	public void selectCurrentDateInDatePicker() throws Exception {

		System.out.println("CURRENT DATE IS :" + getCurrentDate());
		chooseDate = chooseDate.replaceAll("selectDate", getCurrentDate());
		System.out.println(chooseDate);
		waitForVisiblityOfElement(this.driver.findElement(By.xpath(chooseDate)), 10);
		select(chooseDate);

		waitForFullPageElementLoad();

	}

}
