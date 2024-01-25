/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul, on date

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.alphind.xealei.baseclass.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

public class IncidentReportPage extends BaseClass {

	private WebDriver driver;

	public IncidentReportPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	private String dropdownOption = "//span[contains(text(),'XX') and @class = 'mat-option-text']";

	@FindBy(xpath = "//h5[contains(text(),'Incident Reports')]")
	private WebElement incidentReportModuleText;

	@FindBy(xpath = "//span[contains(text(),' Add New Incident Report ')]/parent::button")
	private WebElement addNewIncidentReportButton;

	@FindBy(xpath = "//mat-select[@placeholder='Individual details']")
	private WebElement individualDetailsDropDown;

	String selectIndDetails = "//span[contains(text(),'chooseIndDetails')]/parent::mat-option";

	@FindBy(xpath = "//input[@id='dateAndTime']")
	private WebElement eventDateAndTimeCalenderIconButton;

	@FindBy(xpath = "//mat-label[contains (text(),'injured?')]")
	private WebElement wasIndividualInjuredText;

	@FindBy(xpath = "//mat-label[contains(text(),'What caused the fall?')]/following::textarea")
	private WebElement whatCausedTheFallDescriptionTxtBox;

	@FindBy(xpath = "//mat-error[contains(text(),' Please select the individual details ')]")
	private WebElement individualsDetailsValidationInfoMsg;

	@FindBy(xpath = "//mat-error[contains(text(),' Please choose event on ')]")
	private WebElement eventDateAndTimeValidationInfoMsg;

	@FindBy(xpath = "//div[@title = 'Fore Head']")
	private WebElement frontViewForeHeadInjury;

	@FindBy(xpath = "//div[@title = 'Face']")
	private WebElement frontViewFaceInjury;

	@FindBy(xpath = "(//div[@title = 'Right Shoulder'])[1]")
	private WebElement frontViewRightShoulderInjury;

	@FindBy(xpath = "(//div[@title = 'Left Shoulder'])[1]")
	private WebElement frontViewLeftShoulderInjury;

	@FindBy(xpath = "//div[@title = 'Chest']")
	private WebElement frontViewChestInjury;

	@FindBy(xpath = "//div[@title = 'Abdomen']")
	private WebElement frontViewAbdomenInjury;

	@FindBy(xpath = "(//div[@title = 'Right Knee'])[1]")
	private WebElement frontViewRightKneeInjury;

	@FindBy(xpath = "(//div[@title = 'Left Knee'])[1]")
	private WebElement frontViewLeftKneeInjury;

	@FindBy(xpath = "(//div[@title = 'Right Foot'])[1]")
	private WebElement frontViewRightFootInjury;

	@FindBy(xpath = "(//div[@title = 'Left Foot'])[1]")
	private WebElement frontViewLeftFootInjury;

	@FindBy(xpath = "//mat-label[contains(text(),'Injury Description')]/following::textarea")
	private WebElement injuryDescriptionDescriptionTxtBox;

	@FindBy(xpath = "//textarea[@ng-reflect-name='treatmentReceived']")
	private WebElement treatmentReceivedDescriptionTxtBox;

	@FindBy(xpath = "//textarea[@ng-reflect-name='futureTreatment']")
	private WebElement futureTreatmentDescriptionTxtBox;

	@FindBy(xpath = "//span[contains(text(),'Abrasion')]/parent::label")
	private WebElement injuryTypeAbrasionButton;

	@FindBy(xpath = "//span[contains(text(),'Bleeding')]/parent::label")
	private WebElement injuryTypeBleedingButton;

	@FindBy(xpath = "//span[contains(text(),'Bruise')]/parent::label")
	private WebElement injuryTypeBruiseButton;

	@FindBy(xpath = "//span[contains(text(),'Scratch')]/parent::label")
	private WebElement injuryTypeScratchButton;

	@FindBy(xpath = "//input[@id = 'sev_Light']/following::label[1]")
	private WebElement injurySeverityLight;

	@FindBy(xpath = "//input[@id = 'sev_Light']/following::label[2]")
	private WebElement injurySeverityMedium;

	@FindBy(xpath = "//input[@id = 'sev_Light']/following::label[3]")
	private WebElement injurySeverityHigh;

	@FindBy(xpath = "//input[@formcontrolname='personNotify']")
	private WebElement personNotifedTxtBox;

	@FindBy(xpath = "//mat-select[@formcontrolname='relationship']")
	private WebElement relationshipDropdown;

	@FindBy(xpath = "//span[contains(text(),'Guardian') and @class = 'mat-option-text']")
	private WebElement relationshipGuardianOption;

	@FindBy(xpath = "//span[contains(text(),'Other') and @class = 'mat-option-text']")
	private WebElement relationshipOtherOption;

	@FindBy(xpath = "//input[@formcontrolname='NotifyOn']")
	private WebElement notificationDateCalenderTxtbox;

	@FindBy(xpath = "//button[@aria-label='Open calendar']")
	private WebElement notificationDateCalenderIconButton;

	@FindBy(xpath = "//input[@formcontrolname='time']")
	private WebElement timeTxtbox;

	@FindBy(xpath = "//input[@formcontrolname='notifiedBy']")
	private WebElement notifedByTxtBox;

	@FindBy(xpath = "//mat-select[@placeholder='Notification Method']")
	private WebElement notificationMethodDropdownBox;

	private String notificationMethod = "//span[contains(text(),'method')]/parent::mat-option";

	@FindBy(xpath = "//a[contains(text(),'Reports')]")
	private WebElement breadCrumTxtLinkReports;

	@FindBy(xpath = "//li[contains(text(),'Incident Report')]")
	private WebElement breadCrumTxtLinkIncidentReport;
	
	@FindBy(xpath = "//span[contains(text(),'Incident Report')]/parent::li")
	private WebElement breadCrumTxtLinkIncidentReportInViewPage;

	
	
	
	@FindBy(xpath = "//span[text()='Next ']/parent::button")
	private WebElement nextButton;

	@FindBy(xpath = "//span[text()='Save']/parent::button")
	private WebElement saveButton;

	@FindBy(xpath = "(//div[@title = 'Right Arm'])[1]")
	private WebElement frontViewRightArmInjury;

	@FindBy(xpath = "(//div[@title = 'Left Arm'])[1]")
	private WebElement frontViewLefttArmInjury;

	@FindBy(xpath = "(//div[@title = 'Right Wrist'])[1]")
	private WebElement frontViewRightWristInjury;

	@FindBy(xpath = "(//div[@title = 'Left Wrist'])[1]")
	private WebElement frontViewLefttWristInjury;

	@FindBy(xpath = "//div[@title = 'Head']")
	private WebElement backViewHeadInjury;

	@FindBy(xpath = "(//div[@title = 'Right Shoulder'])[2]")
	private WebElement backViewRightShoulderInjury;

	@FindBy(xpath = "(//div[@title = 'Left Shoulder'])[2]")
	private WebElement backViewLeftShoulderInjury;

	@FindBy(xpath = "//div[@title = 'Back']")
	private WebElement backViewBackInjury;

	@FindBy(xpath = "//div[@title = 'Hip']")
	private WebElement backViewHipInjury;

	@FindBy(xpath = "(//div[@title = 'Right Knee'])[2]")
	private WebElement backViewRightKneeInjury;

	@FindBy(xpath = "(//div[@title = 'Left Knee'])[2]")
	private WebElement backViewLeftKneeInjury;

	@FindBy(xpath = "(//div[@title = 'Right Foot'])[2]")
	private WebElement backViewRightFootInjury;

	@FindBy(xpath = "//mat-error[contains(text(),' Given time exceeds the current time ')]")
	private WebElement exceedCurrentTimeIneventDateAndTimeValidationInfoMsg;

	@FindBy(xpath = "//mat-error[contains(text(),' Please enter fall caused ')]")
	private WebElement fallCausedValidationInfoMsg;

	@FindBy(xpath = "//mat-error[contains(text(),' Please enter fall description')]")
	private WebElement injuryDescriptionValidationInfoMsg;

	@FindBy(xpath = "//mat-error[contains(text(),' Please choose was injured')]")
	private WebElement chooseWasIndInjuredRadioButtonValidationInfoMsg;

	@FindBy(xpath = "//mat-error[contains(text(),' Please select injury site')]")
	private WebElement injurySiteValidationInfoMsg;

	@FindBy(xpath = "//mat-error[contains(text(),' Please enter treatment received')]")
	private WebElement treatmentReceivedValidationInfoMsg;

	@FindBy(xpath = "//mat-error[contains(text(),' Please enter future treatment')]")
	private WebElement futureTreatmentValidationInfoMsg;

	@FindBy(xpath = "(//div[@title = 'Left Foot'])[2]")
	private WebElement backViewLeftFootInjury;

	@FindBy(xpath = "(//div[@title = 'Right Arm'])[2]")
	private WebElement backViewRightArmInjury;

	@FindBy(xpath = "(//div[@title = 'Left Arm'])[2]")
	private WebElement backViewLefttArmInjury;

	@FindBy(xpath = "(//div[@title = 'Right Wrist'])[2]")
	private WebElement backViewRightWristInjury;

	@FindBy(xpath = "(//div[@title = 'Left Wrist'])[2]")
	private WebElement backViewLefttWristInjury;

	private String injuredIndividiual = "//mat-label[contains(text(),'Was IndividiualName injured?')]";

	@FindBy(xpath = "(//div[text()='Yes'])[1]/preceding-sibling::div/input") // ../preceding-sibling::div/input
	private WebElement wasIndividiualInjuredYesRadioButton;

	@FindBy(xpath = "(//div[text()='No'])[1]/preceding-sibling::div/input")
	private WebElement wasIndividiualInjuredNoRadioButton;

	String wasIndividualInjuredYesRadioButton = "(//div[text()='?'])[1]/preceding-sibling::div/input";

	String wasPatientInjured = "//div[contains(text(),'isInjured')]";

	@FindBy(xpath = "(//div[text()='Yes'])[2]/preceding-sibling::div/input")
	private WebElement wasTheEventNotifiedYesRadioButton;

	@FindBy(xpath = "//button[@class='attach-icon']")
	private WebElement attachmentIconButton;

	@FindBy(xpath = "//i[@title = 'Click here to delete']")
	private WebElement attachmentDeleteButton;

	@FindBy(xpath = "//mat-label[text()='Injury Color']/following-sibling::ul"
			+ "/li[@style='background-color: rgb(165, 171, 107);']")
	private WebElement injuryColorGreen;

	@FindBy(xpath = "//mat-label[text()='Injury Color']/following-sibling::ul"
			+ "/li[@style='background-color: rgb(221, 116, 103);']")
	private WebElement injuryColorRed;

	@FindBy(xpath = "//mat-label[text()='Injury Color']/following-sibling::ul"
			+ "/li[@style='background-color: rgb(72, 72, 87);']")
	private WebElement injuryColorBlack;

	@FindBy(xpath = "//mat-label[text()='Injury Color']/following-sibling::ul"
			+ "/li[@style='background-color: rgb(176, 137, 100);']")
	private WebElement injuryColorBrown;

	@FindBy(xpath = "//mat-error[text() = ' Please select the injury type ']")
	private WebElement injuryTypeValidationInfoMsg;

	@FindBy(xpath = "//mat-error[text() = ' Please select injury color ']")
	private WebElement injuryColorValidationInfoMsg;

	@FindBy(xpath = "//mat-error[text() = ' Please choose was the injury serve ']")
	private WebElement injurySeverityValidationInfoMsg;

	@FindBy(xpath = "//mat-error[text() = ' Please enter person notify ']")
	private WebElement personNotifiedValidationInfoMsg;

	@FindBy(xpath = "//mat-error[text() = ' Please choose relationship  ']")
	private WebElement relationshipValidationInfoMsg;

	@FindBy(xpath = "//mat-error[text() = ' Please choose notify date  ']")
	private WebElement chooseNotifiationDateValidationInfoMsg;

	@FindBy(xpath = "//mat-error[text() = ' Please choose time  ']")
	private WebElement chooseNotifiationTimeValidationInfoMsg;

	@FindBy(xpath = "//mat-error[text() = ' Please enter notified by  ']")
	private WebElement notifiedByValidationInfoMsg;

	@FindBy(xpath = "//table//tbody//tr//td[3]")
	private WebElement individualsGrid;

	@FindBy(xpath = "//span[contains(text(),'Saved Successfully')]")
	private WebElement savedSuccessfullToastMsg;

	@FindBy(xpath = "//span[contains(text(),'ok')]/parent::button")
	private WebElement btnToastMsgSuccessOk;

	@FindBy(xpath = "//span[contains(text(),'OK')]/parent::button")
	private WebElement OKBtnToastMsg;

	@FindBy(xpath = "//span[contains(text(),' View ')]/parent::button")
	private WebElement viewButtonInIndividualGrid;

	@FindBy(xpath = "//div[contains(text(),'Note:')]")
	private WebElement requiredFieldsNOTEInfoMessage;

	@FindBy(xpath = "//span[contains(text(),'File(1) size should be less than 1 MB')]")
	private WebElement imgSizeToastMsg;

	@FindBy(xpath = "//span[contains(text(),'JFIF format is not supported')]")
	private WebElement JFIFFileFormatNotSupportedToastMsg;

	@FindBy(xpath = "//mat-radio-group[@formcontrolname='eventNotified']/mat-radio-button[1]")
	private WebElement eventNotifiedDefaultValue;

	@FindBy(xpath = "//li[text() = 'Incident Report']")
	private WebElement incidentReportText;

	@FindBy(xpath = "//span[text()='Complete']/parent::button")
	private WebElement completeButton;
	
	@FindBy(xpath = "//span[text()='Re-submit to Sender']/parent::button")
	private WebElement resubmitButton;
	
	private String IDColumnXpath = "//table/tbody/tr[rownumber]/td[1]";

	private String statusColumnXpath = "//table/tbody/tr[rownumber]/td[7]/div/span";

	private String viewButton = "//table/tbody/tr[rownumber]/td[8]/button/span[contains(text(),'View')]";

	private String editButton = "//table/tbody/tr[rownumber]/td[8]/button/span[contains(text(),'Edit')]";

	@FindBy(xpath = "//table/tbody/tr/td[3]")
	private List<WebElement> injurySummaries;

	@FindBy(xpath = "//span[contains(text(),'Edit')]/parent::button")
	private WebElement IRFormEditButton;

	@FindBy(xpath = "//button[@type='button']/parent::mat-datepicker-toggle")
	private WebElement btnCalendar;

	String currentDate = "//table[@class='mat-calendar-table']/tbody/tr/td/div[text()='Date']";

	String chooseYear = "//table[@class='mat-calendar-table']/tbody/tr/td/div[text()='selectYear']";
	String chooseDate = "//table[@class='mat-calendar-table']/tbody/tr/td/div[text()='selectDate']";
	String chooseMonth = "//table[@class='mat-calendar-table']/tbody/tr/td/div[text()='selectMonth']";

	@FindBy(xpath = "//input[@ng-reflect-name='dob']")
	private WebElement dob;

	@FindBy(xpath = "//button[@aria-label='Next month']")
	private WebElement datePickerRightArrow;

	@FindBy(xpath = "//button[@aria-label='Previous month']")
	private WebElement datePickerLeftArrow;

	String selectNextDate = "//div[text()='selectDate']/parent::td";

	String selectNextToTheCurrentDate = "//div[text()='nextDate']/parent::td";

	@FindBy(xpath = "//button[@class='mat-calendar-previous-button mat-icon-button mat-button-base']")
	private WebElement leftArrowBtn;

	@FindBy(xpath = "//button[@aria-label='Choose month and year']")
	private WebElement datePicker;

	@FindBy(xpath = "//div[@class='mat-calendar-arrow']/parent::span/parent::button")
	private WebElement monthYearDD;

	@FindBy(xpath = "//input[@ng-reflect-name='NotifyOn']")
	private WebElement notificationDateField;

	@FindBy(xpath = "//textarea[@formcontrolname = 'comments']")
	private WebElement reviewerComments;

	@FindBy(xpath = "//mat-error[contains(text(),'Notified time should be')]")
	private WebElement lesserThanToastMsgForNotificationTime;

	@FindBy(xpath = "//div[@x-lbllocval]")
	private WebElement locationValue;

	@FindBy(xpath = "//div[@x-lbl-cause]")
	private WebElement injuryCauseValue;

	@FindBy(xpath = "//div[@x-lbl-injury]")
	private WebElement wasInjuredValue;

	@FindBy(xpath = "//div[@x-lbl-injurydesc]")
	private WebElement injuryDescriptionValue;

	@FindBy(xpath = "//span[@x-lbl-siteinjuryfront]")
	private WebElement siteOfInjuryFrontValue;

	@FindBy(xpath = "//div[@x-lbl-siteinjuryback]")
	private WebElement siteOfInjuryBackValue;

	@FindBy(xpath = "//div[@x-lbl-treatment]")
	private WebElement treatmentReceivedValue;

	@FindBy(xpath = "//div[@x-lbl-future]")
	private WebElement futureTreatmentValue;

	@FindBy(xpath = "//div[@x-lbl-type]")
	private WebElement injuryTypeValue;
	
	@FindBy(xpath = "//h1[@x-lbl-injurycolor]")
	private WebElement injuryColorValue;
	
	@FindBy(xpath = "//div[@x-lbl-severity]")
	private WebElement injurySeverityValue;

	@FindBy(xpath = "//div[@x-lbl-notstatus]")
	private WebElement eventNotifiStatusValue;

	@FindBy(xpath = "//div[@x-lbl-notifiedper]")
	private WebElement personNotifiedValue;

	@FindBy(xpath = "//div[@x-lbl-relation]")
	private WebElement relationshipValue;

	@FindBy(xpath = "//div[@x-lbl-noton]")
	private WebElement notificationDateAndTimeValue;

	@FindBy(xpath = "//div[@x-lbl-notby]")
	private WebElement notifiedByValue;

	@FindBy(xpath = "//div[@x-lbl-notmethod]")
	private WebElement notificationMethodValue;

	String BC = "//a[text()='createdSN']/parent::li";
	
	@FindBy(xpath = "//i[@class = 'nav-link notiicon']")
	private WebElement notificationIcon;
	
	@FindBy(xpath = "//span[text()='Home']/preceding::a")
	private WebElement home;
	
	@FindBy(xpath = "//textarea[@formcontrolname = 'message']")
	private WebElement chatMessageArea;
	
	@FindBy(xpath = "//button[@title = 'Attachment' and @type = 'submit']")
	private WebElement chatAttachmentButton;
	
	@FindBy(xpath = "//button[@title = 'Send Message' and @type = 'submit']")
	private WebElement chatSendButton;
	
	private String chatMessageTextXpath = "//div[@class = 'msg-info-name' and contains(text(),'XX')]"
			+ "/parent::div/following-sibling::div";
	
	@FindBy(xpath = "//div[@class='user-category']/parent::div[@class = 'wrapText']")
	private WebElement userName;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public WebElement getJFIFFileFormatNotSupportedToastMsg() {
		return JFIFFileFormatNotSupportedToastMsg;
	}

	public WebElement getSavedSuccessfullToastMsg() {
		return savedSuccessfullToastMsg;
	}

	public WebElement getBtnToastMsgSuccessOk() {
		return btnToastMsgSuccessOk;
	}

	public WebElement getIndividualsGrid() {
		return individualsGrid;
	}

	public WebElement getInjurySeverityValidationInfoMsg() {
		return injurySeverityValidationInfoMsg;
	}

	public WebElement getPersonNotifiedValidationInfoMsg() {
		return personNotifiedValidationInfoMsg;
	}

	public WebElement getRelationshipValidationInfoMsg() {
		return relationshipValidationInfoMsg;
	}

	public WebElement getChooseNotifiationDateValidationInfoMsg() {
		return chooseNotifiationDateValidationInfoMsg;
	}

	public WebElement getChooseNotifiationTimeValidationInfoMsg() {
		return chooseNotifiationTimeValidationInfoMsg;
	}

	public WebElement getNotifiedValidationInfoMsg() {
		return notifiedByValidationInfoMsg;
	}

	public WebElement getIncidentReportModuleText() {
		return incidentReportModuleText;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getNextButton() {
		return nextButton;
	}

	public WebElement getIndividualsDetailsValidationInfoMsg() {
		return individualsDetailsValidationInfoMsg;
	}

	public WebElement getExceedCurrentTimeIneventDateAndTimeValidationInfoMsg() {
		return exceedCurrentTimeIneventDateAndTimeValidationInfoMsg;
	}

	public WebElement getFallCausedValidationInfoMsg() {
		return fallCausedValidationInfoMsg;
	}

	public WebElement getInjuryDescriptionValidationInfoMsg() {
		return injuryDescriptionValidationInfoMsg;
	}

	public WebElement getChooseWasIndInjuredRadioButtonValidationInfoMsg() {
		return chooseWasIndInjuredRadioButtonValidationInfoMsg;
	}

	public WebElement getInjurySiteValidationInfoMsg() {
		return injurySiteValidationInfoMsg;
	}

	public WebElement getTreatmentReceivedValidationInfoMsg() {
		return treatmentReceivedValidationInfoMsg;
	}

	public WebElement getFutureTreatmentValidationInfoMsg() {
		return futureTreatmentValidationInfoMsg;
	}

	public WebElement getEventDateAndTimeValidationInfoMsg() {
		return eventDateAndTimeValidationInfoMsg;
	}

	public WebElement getInjuryTypeValidationInfoMsg() {
		return injuryTypeValidationInfoMsg;
	}

	public WebElement getInjuryColorValidationInfoMsg() {
		return injuryColorValidationInfoMsg;
	}

	public WebElement getRequiredFieldsNOTEInfoMessage() {
		return requiredFieldsNOTEInfoMessage;
	}

	public WebElement getImgSizeToastMsg() {
		return imgSizeToastMsg;
	}

	public WebElement getEventNotifiedDefaultValue() {
		return eventNotifiedDefaultValue;
	}

	public WebElement getCompleteButton() {
		return completeButton;
	}

	public WebElement getEventDateAndTimeCalenderIconButton() {
		return eventDateAndTimeCalenderIconButton;
	}

	public WebElement getLesserThanToastMsgForNotificationTime() {
		return lesserThanToastMsgForNotificationTime;
	}

	public WebElement getAddNewIncidentReportButton() {
		return addNewIncidentReportButton;
	}

	public WebElement getInjuryDescriptionTxtBox() {
		return injuryDescriptionDescriptionTxtBox;
	}

	public WebElement getBreadCrumTxtLinkIncidentReport() {
		return breadCrumTxtLinkIncidentReport;
	}

	public WebElement getBreadCrumTxtLinkReports() {
		return breadCrumTxtLinkReports;
	}
	
	public WebElement getInjuryColorValue() {
		return injuryColorValue;
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @author Nandhalala. Checks whether Incident report heading is displayed or
	 *         not.
	 * 
	 * @created on 26-12-2023.
	 * 
	 * @return whether incident report page is displayed or not.
	 */
	public boolean isIncidentReportPageDisplayed() {

		if (incidentReportModuleText.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * @author Nandhalala. Select the Individual Details with Individual Name.
	 * 
	 * @created on 26-12-2023.
	 * 
	 */
	public void selectIndividualDetails() {
		String individualDetail = readExcel("Test Datas", "Incident Reports", 1, 0);
		String[] fullname = individualDetail.split(" ");

		if (fullname.length > 2) {
			individualDetail = fullname[0] + "  " + fullname[1];
			for (int i = 2; i < fullname.length; i++) {
				individualDetail = individualDetail + " " + fullname[i];
			}
		} else {
			individualDetail = fullname[0] + "  " + fullname[1];
		}
		click(individualDetailsDropDown);
		String individualName = dropdownOption.replaceAll("XX", individualDetail);
		select(driver, individualName);
	}

	/**
	 * @author Nandhalala. Enter the data from excel sheet to 'What caused the
	 *         fall?' text area box.
	 *
	 * 
	 * @created on 22-12-2023.
	 */
	public void enterWhatCausedTheFallData() {
		String WhatCausedTheFall = readExcel("Test Datas", "Incident Reports", 1, 2).trim();
		sendKeys(whatCausedTheFallDescriptionTxtBox, WhatCausedTheFall);
		waitForPageLoad(driver);
	}

	/**
	 * @author Nandhalala. Enter the data from excel sheet to 'Injury Description'
	 *         text area box.
	 *
	 * 
	 * @created on 22-12-2023
	 */
	public String enterInjuryDescriptionData() {
		String injuryDescription = readExcel("Test Datas", "Incident Reports", 1, 3).trim();
		String newDescription = injuryDescription + secondsCount();
		sendKeys(injuryDescriptionDescriptionTxtBox, newDescription);
		writeExcelToOverwrite("Test Datas", "Incident Reports", 1, 18, newDescription);
		return newDescription;
	}

	/**
	 * @author Nandhalala. Select whether the individual was injured or not.
	 * 
	 * 
	 * @created on 22-10-2023.
	 * 
	 */
	public void selectWasTheIndividiualInjured() {
		String WasIndividiualIInjured = readExcel("Test Datas", "Incident Reports", 1, 4).trim();
		wasPatientInjured = wasPatientInjured.replace("isInjured", WasIndividiualIInjured);
		waitForFullPageElementLoad(driver);
		select(wasPatientInjured);
		waitForPageLoad(driver);

	}

	/**
	 * @author Nandhalala. Get tooltip for Front View Fore Head.
	 * 
	 * 
	 * @created on 09-01-2024.
	 * 
	 */
	public String getTooltipFrontViewForeHead() {
		return getAttribute(frontViewForeHeadInjury, "title");
	}

	/**
	 * @author Nandhalala. Get tooltip for Front View Face.
	 * 
	 * 
	 * @created on 09-01-2024.
	 * 
	 */
	public String getTooltipFrontViewFace() {
		return getAttribute(frontViewFaceInjury, "title");
	}

	/**
	 * @author Nandhalala. Get tooltip for Front Right Shoulder.
	 * 
	 * 
	 * @created on 09-01-2024.
	 * 
	 */
	public String getTooltipFrontViewRightShoulder() {
		return getAttribute(frontViewRightShoulderInjury, "title");
	}

	/**
	 * @author Nandhalala. Get tooltip for Front View Left Shoulder.
	 * 
	 * 
	 * @created on 09-01-2024.
	 * 
	 */
	public String getTooltipFrontViewLeftShoulder() {
		return getAttribute(frontViewLeftShoulderInjury, "title");
	}

	/**
	 * @author Nandhalala. Get tooltip for Front View Chest.
	 * 
	 * 
	 * @created on 09-01-2024.
	 * 
	 */
	public String getTooltipFrontViewChest() {
		return getAttribute(frontViewChestInjury, "title");
	}

	/**
	 * @author Nandhalala. Get tooltip for Front View Abdomen.
	 * 
	 * 
	 * @created on 09-01-2024.
	 * 
	 */
	public String getTooltipFrontViewAbdomen() {
		return getAttribute(frontViewAbdomenInjury, "title");
	}

	/**
	 * @author Nandhalala. Get tooltip for Front View Right Arm.
	 * 
	 * 
	 * @created on 09-01-2024.
	 * 
	 */
	public String getTooltipFrontViewRightArm() {
		return getAttribute(frontViewRightArmInjury, "title");
	}

	/**
	 * @author Nandhalala. Get tooltip for Front View Left Arm.
	 * 
	 * 
	 * @created on 09-01-2024.
	 * 
	 */
	public String getTooltipFrontViewLeftArm() {
		return getAttribute(frontViewLefttArmInjury, "title");
	}

	/**
	 * @author Nandhalala. Get tooltip for Front View Right Wrist.
	 * 
	 * 
	 * @created on 09-01-2024.
	 * 
	 */
	public String getTooltipFrontViewRightWrist() {
		return getAttribute(frontViewRightWristInjury, "title");
	}

	/**
	 * @author Nandhalala. Get tooltip for Front View Left Wrist.
	 * 
	 * 
	 * @created on 09-01-2024.
	 * 
	 */
	public String getTooltipFrontViewLeftWrist() {
		return getAttribute(frontViewLefttWristInjury, "title");
	}

	/**
	 * @author Nandhalala. Get tooltip for Front View Right Knee.
	 * 
	 * 
	 * @created on 09-01-2024.
	 * 
	 */
	public String getTooltipFrontViewRightKnee() {
		return getAttribute(frontViewRightKneeInjury, "title");
	}

	/**
	 * @author Nandhalala. Get tooltip for Front View Left Knee.
	 * 
	 * 
	 * @created on 09-01-2024.
	 * 
	 */
	public String getTooltipFrontViewLEftKnee() {
		return getAttribute(frontViewLeftKneeInjury, "title");
	}

	/**
	 * @author Nandhalala. Get tooltip for Front View Right Foot.
	 * 
	 * 
	 * @created on 09-01-2024.
	 * 
	 */
	public String getTooltipFrontViewRightFoot() {
		return getAttribute(frontViewRightFootInjury, "title");
	}

	/**
	 * @author Nandhalala. Get tooltip for Front View Left Foot.
	 * 
	 * 
	 * @created on 09-01-2024.
	 * 
	 */
	public String getTooltipFrontViewLeftFoot() {
		return getAttribute(frontViewLeftFootInjury, "title");
	}

	/**
	 * @author Nandhalala. Select whether the front view injured site.
	 * 
	 * 
	 * @created on 22-10-2023.
	 * 
	 */
	public void selectFrontViewInjurySite() {
		String[] injuredsites = readExcel("Test Datas", "Incident Reports", 1, 5).split(",");
		for (String injury : injuredsites) {
			String injurysite = injury.trim();
			switch (injurysite) {
			case "Fore Head":
				click(frontViewForeHeadInjury);
				break;

			case "Face":
				click(frontViewFaceInjury);
				break;

			case "Right Shoulder":
				click(frontViewRightShoulderInjury);
				break;

			case "Left Shoulder":
				click(frontViewLeftShoulderInjury);
				break;

			case "Chest":
				click(frontViewChestInjury);
				break;

			case "Abdomen":
				click(frontViewAbdomenInjury);
				break;

			case "Right Arm":
				click(frontViewRightArmInjury);
				break;

			case "Left Arm":
				click(frontViewLefttArmInjury);
				break;

			case "Right Wrist":
				click(frontViewRightWristInjury);
				break;

			case "Left Wrist":
				click(frontViewLefttWristInjury);
				break;

			case "Right Knee":
				click(frontViewRightKneeInjury);
				break;

			case "Left Knee":
				click(frontViewLeftKneeInjury);
				break;

			case "Right Foot":
				click(frontViewRightFootInjury);
				break;

			case "Left Foot":
				click(frontViewLeftFootInjury);
				break;

			}
		}
	}

	/**
	 * <<<<<<< HEAD
	 * 
	 * @author Nandhalala. Select whether the front view injured site. =======
	 * @author Nandhalala. Get tooltip for BAck View Head.
	 * 
	 * 
	 * @created on 09-01-2024.
	 * 
	 */
	public String getTooltipBackViewHead() {
		return getAttribute(backViewHeadInjury, "title");
	}

	/**
	 * @author Nandhalala. Get tooltip for Back View Right Shoulder.
	 * 
	 * 
	 * @created on 09-01-2024.
	 * 
	 */
	public String getTooltipBackViewRightShoulder() {
		return getAttribute(backViewRightShoulderInjury, "title");
	}

	/**
	 * @author Nandhalala. Get tooltip for Back View Left Shoulder.
	 * 
	 * 
	 * @created on 09-01-2024.
	 * 
	 */
	public String getTooltipBackViewLeftShoulder() {
		return getAttribute(backViewLeftShoulderInjury, "title");
	}

	/**
	 * @author Nandhalala. Get tooltip for Back View Back.
	 * 
	 * 
	 * @created on 09-01-2024.
	 * 
	 */
	public String getTooltipBackViewBack() {
		return getAttribute(backViewBackInjury, "title");
	}

	/**
	 * @author Nandhalala. Get tooltip for Back View Hip.
	 * 
	 * 
	 * @created on 09-01-2024.
	 * 
	 */
	public String getTooltipBackViewHip() {
		return getAttribute(backViewHipInjury, "title");
	}

	/**
	 * @author Nandhalala. Get tooltip for Back View Right Arm.
	 * 
	 * 
	 * @created on 09-01-2024.
	 * 
	 */
	public String getTooltipBackViewRightArm() {
		return getAttribute(backViewRightArmInjury, "title");
	}

	/**
	 * @author Nandhalala. Get tooltip for Back View Left Arm.
	 * 
	 * 
	 * @created on 09-01-2024.
	 * 
	 */
	public String getTooltipBackViewLeftArm() {
		return getAttribute(backViewLefttArmInjury, "title");
	}

	/**
	 * @author Nandhalala. Get tooltip for Back View Right Wrist.
	 * 
	 * 
	 * @created on 09-01-2024.
	 * 
	 */
	public String getTooltipBackViewRightWrist() {
		return getAttribute(backViewRightWristInjury, "title");
	}

	/**
	 * @author Nandhalala. Get tooltip for Back View Left Wrist.
	 * 
	 * 
	 * @created on 09-01-2024.
	 * 
	 */
	public String getTooltipBackViewLeftWrist() {
		return getAttribute(backViewLefttWristInjury, "title");
	}

	/**
	 * @author Nandhalala. Get tooltip for Back View Right Knee.
	 * 
	 * 
	 * @created on 09-01-2024.
	 * 
	 */
	public String getTooltipBackViewRightKnee() {
		return getAttribute(backViewRightKneeInjury, "title");
	}

	/**
	 * @author Nandhalala. Get tooltip for Back View Left Knee.
	 * 
	 * 
	 * @created on 09-01-2024.
	 * 
	 */
	public String getTooltipBackViewLeftKnee() {
		return getAttribute(backViewLeftKneeInjury, "title");
	}

	/**
	 * @author Nandhalala. Get tooltip for Back View Right Foot.
	 * 
	 * 
	 * @created on 09-01-2024.
	 * 
	 */
	public String getTooltipBackViewRightFoot() {
		return getAttribute(backViewRightFootInjury, "title");
	}

	/**
	 * @author Nandhalala. Get tooltip for Back View Left Foot.
	 * 
	 * 
	 * @created on 09-01-2024.
	 * 
	 */
	public String getTooltipBackViewLeftFoot() {
		return getAttribute(backViewLeftFootInjury, "title");
	}

	/**
	 * @author Nandhalala. Select whether the front view injured site. *
	 * 
	 * @created on 22-10-2023.
	 * 
	 */
	public void selectBackViewInjurySite() {
		String[] injuredsites = readExcel("Test Datas", "Incident Reports", 1, 6).split(",");
		for (String injury : injuredsites) {
			String injurysite = injury.trim();
			switch (injurysite) {
			case "Head":
				click(backViewHeadInjury);
				break;

			case "Right Shoulder":
				click(backViewRightShoulderInjury);
				break;

			case "Left Shoulder":
				click(backViewLeftShoulderInjury);
				break;

			case "Back":
				click(backViewBackInjury);
				break;

			case "Hip":
				click(backViewHipInjury);
				break;

			case "Right Arm":
				click(backViewRightArmInjury);
				break;

			case "Left Arm":
				click(backViewLefttArmInjury);
				break;

			case "Right Wrist":
				click(backViewRightWristInjury);
				break;

			case "Left Wrist":
				click(backViewLefttWristInjury);
				break;

			case "Right Knee":
				click(backViewRightKneeInjury);
				break;

			case "Left Knee":
				click(backViewLeftKneeInjury);
				break;

			case "Right Foot":
				click(backViewRightFootInjury);
				break;

			case "Left Foot":
				click(backViewLeftFootInjury);
				break;

			}
		}
	}

	/**
	 * @author Nandhalala. Enter the data from excel sheet to 'Treatment Received'
	 *         text area box.
	 *
	 * 
	 * @created on 22-12-2023.
	 */
	public void enterTreatmentReceivedData() {
		String treatmentreceived = readExcel("Test Datas", "Incident Reports", 1, 7).trim();
		sendKeys(treatmentReceivedDescriptionTxtBox, treatmentreceived);
	}

	/**
	 * @author Nandhalala. Enter the data from excel sheet to 'Future Treatment'
	 *         text area box.
	 *
	 * 
	 * @created on 22-12-2023
	 */
	public void enterFutureTreatmentData() {
		String futuretreatment = readExcel("Test Datas", "Incident Reports", 1, 8).trim();
		sendKeys(futureTreatmentDescriptionTxtBox, futuretreatment);
	}

	/**
	 * @author Nandhalala. Select the front view injured type.
	 * 
	 * 
	 * @created on 22-10-2023.
	 */
	public void selectInjuryType() {

		String[] injuryType = readExcel("Test Datas", "Incident Reports", 1, 9).split(",");
		for (String injurytype : injuryType) {
			switch (injurytype.trim()) {
			case "Abrasion":
				click(injuryTypeAbrasionButton);
				break;

			case "Bleeding":
				click(injuryTypeBleedingButton);
				break;

			case "Bruise":
				click(injuryTypeBruiseButton);
				break;

			case "Scratch":
				click(injuryTypeScratchButton);
				break;

			}
		}

	}

	/**
	 * @author Nandhalala. Select the Injury Color.
	 * 
	 * @created on 22-12-2023.
	 */
	public void selectInjuryColor() {
		String injuryColor = readExcel("Test Datas", "Incident Reports", 1, 10).trim();
		switch (injuryColor) {
		case "Green":
			click(injuryColorGreen);
			break;

		case "Red":
			click(injuryColorRed);
			break;

		case "Black":
			click(injuryColorBlack);
			break;

		case "Brown":
			click(injuryColorBrown);
			break;
		}
	}

	/**
	 * @author Nandhalala. Select the Injury Severity.
	 * 
	 * @created on 22-12-2023.
	 */
	public void selectHowSevereWasTheInjury() {
		String injurySeverity = readExcel("Test Datas", "Incident Reports", 1, 11).trim();
		switch (injurySeverity) {
		case "Light":
			click(injurySeverityLight);
			break;

		case "Medium":
			click(injurySeverityMedium);
			break;

		case "High":
			click(injurySeverityHigh);
			break;
		}
	}

	/**
	 * @author Nandhalala. Enter the data from excel sheet to 'Person Notified' text
	 *         area box.
	 *
	 * 
	 * @created on 22-12-2023
	 */
	public void enterPersonNotifiedData() {
		String personnotified = readExcel("Test Datas", "Incident Reports", 1, 12).trim();
		sendKeys(personNotifedTxtBox, personnotified);
	}

	/**
	 * @author Nandhalala. Enter the data from excel sheet to 'Notified By' text
	 *         area box.
	 *
	 * 
	 * @created on 22-12-2023
	 */
	public void enterNotifiedByData() {
		String notifiedby = readExcel("Test Datas", "Incident Reports", 1, 16).trim();
		sendKeys(notifedByTxtBox, notifiedby);
	}

	/**
	 * @author Nandhalala. Select the Relationship.
	 * 
	 * @created on 22-12-2023.
	 */
	public void selectRelationship() {
		String relationship = readExcel("Test Datas", "Incident Reports", 1, 13).trim();
		click(relationshipDropdown);
		switch (relationship) {
		case "Guardian":
			click(relationshipGuardianOption);
			break;

		case "Other":
			click(relationshipOtherOption);
			break;

		}
	}

	/**
	 * @author Nandhalala. Select the Notification Method.
	 * 
	 * @created on 22-12-2023.
	 */
	public void enterNotificationDate() {
		
		String currentDate = getCurrentMonth()+"/"+getCurrentDate()+"/"+getCurrentDtYearMonth("yyyy");
		writeExcelToOverwrite("Test Datas", "Incident Reports", 1, 14, currentDate);
		String notificationDate = readExcel("Test Datas", "Incident Reports", 1, 14).trim();
		sendKeys(notificationDateCalenderTxtbox, notificationDate);
	}

	/**
	 * @author Nandhalala. Select the Notification Time.
	 * 
	 * @created on 22-12-2023.
	 */
	public void enterNotificationTime() {

		writeExcelToOverwrite("Test Datas", "Incident Reports", 1, 15, getCurrentDtYearMonth("hh:mma"));
		String notificationDate = readExcel("Test Datas", "Incident Reports", 1, 15).trim();
		sendKeys(timeTxtbox, notificationDate);
	}

	/**
	 * @author Nandhalala. Select the Notification Method.
	 * 
	 * @created on 22-12-2023.
	 */
	public void selectNotificationMethod() {
		
		click(notificationMethodDropdownBox);
		String notifiedMethod = readExcel("Test Datas", "Incident Reports", 1, 17).trim();
		notificationMethod = notificationMethod.replace("method", notifiedMethod);
		select(notifiedMethod);
	}

	/**
	 * @author Nandhalala. Click on the complete button to complete the Incident
	 *         Report and submit the report.
	 * 
	 * @created on 27-12-2023.
	 * 
	 */
	public void clickCompleteButton() {
		click(completeButton);
		waitForPageLoad(this.driver);
	}
	
	/**
	 * @author Nandhalala.
	 * Click on the ReSubmit to sender button to re-send to submiter of the report.
	 * 
	 * @created on 27-12-2023.
	 * 
	 */
	public void resubmitButton() {
		click(resubmitButton);
		waitForPageLoad(this.driver);
	}
	
	public String getRowNumber() {

		waitForPageLoad(this.driver);
		System.out.println(readExcel("Test Datas", "Incident Reports", 1, 18));
		int i = 1;
		for (WebElement element : injurySummaries) {
			if (getText(element).equals(readExcel("Test Datas", "Incident Reports", 1, 18))) {
				return Integer.toString(i);
			}
			i++;
		}
		return null;
	}

	/**
	 * @author Nandhalala. To get the status of the Incident report of the mentioned
	 *         row.
	 * 
	 * @param rowNumber
	 * @return the status value of the given row.
	 * 
	 * @created on 27-12-2023.
	 */
	public String getStatus(String rowNumber) {
		String excatColumn = statusColumnXpath.replaceAll("rownumber", rowNumber);
		return getTextString(this.driver, excatColumn);
	}

	/**
	 * @author Nandhalala. To get the ID of the Incident report of the mentioned
	 *         row.
	 * 
	 * @param rowNumber
	 * @return the status value of the given row.
	 * 
	 * @created on 27-12-2023.
	 */
	public String getReportID(String rowNumber) {
		String excatColumn = IDColumnXpath.replaceAll("rownumber", rowNumber);
		writeExcelToOverwrite("Test Datas", "Incident Reports", 1, 19, getTextString(excatColumn));
		return getTextString(excatColumn);
	}

	/**
	 * @author Nandhalala. To enter Chief Nurse reviewer comments.
	 * 
	 * @param rowNumber - Accepts only approved or rejected as parameters.
	 * @return the status value of the given row.
	 * 
	 * @created on 09-01-2024.
	 */
	public void chiefNurseReviewerComments(String decision) {
		decision = decision.toUpperCase();
		switch (decision) {
		case "APPROVED": {
			String comments = readExcel("Test Datas", "Incident Reports", 1, 20);
			sendKeys(reviewerComments, comments);
			break;
		}
		case "REJECTED": {
			String comments = readExcel("Test Datas", "Incident Reports", 1, 24);
			sendKeys(reviewerComments, comments);
			break;
		}

		}
	}

	/**
	 * @author Nandhalala. To enter Residential Manager reviewer comments.
	 * 
	 * @param rowNumber - Accepts only approved or rejected as parameters.
	 * @return the status value of the given row.
	 * 
	 * @created on 09-01-2024.
	 */
	public void residentialManagerReviewerComments(String decision) {
		decision = decision.toUpperCase();
		switch (decision) {
		case "APPROVED": {
			String comments = readExcel("Test Datas", "Incident Reports", 1, 21);
			sendKeys(reviewerComments, comments);
			break;
		}
		case "REJECTED": {
			String comments = readExcel("Test Datas", "Incident Reports", 1, 25);
			sendKeys(reviewerComments, comments);
			break;
		}

		}
	}

	/**
	 * @author Nandhalala. To enter Clinical coordinator reviewer comments.
	 * 
	 * @param rowNumber - Accepts only approved or rejected as parameters.
	 * @return the status value of the given row.
	 * 
	 * @created on 11-01-2024.
	 */
	public void clinicalCoordinatorReviewerComments(String decision) {
		decision = decision.toUpperCase();
		switch (decision) {
		case "APPROVED": {
			String comments = readExcel("Test Datas", "Incident Reports", 1, 22);
			sendKeys(reviewerComments, comments);
			break;
		}
		case "REJECTED": {
			String comments = readExcel("Test Datas", "Incident Reports", 1, 26);
			sendKeys(reviewerComments, comments);
			break;
		}

		}
	}

	/**
	 * @author Nandhalala. To enter social worker reviewer comments.
	 * 
	 * @param rowNumber - Accepts only approved or rejected as parameters.
	 * @return the status value of the given row.
	 * 
	 * @created on 11-01-2024.
	 */
	public void socialWorkerReviewerComments(String decision) {
		decision = decision.toUpperCase();
		switch (decision) {
		case "APPROVED": {
			String comments = readExcel("Test Datas", "Incident Reports", 1, 23);
			sendKeys(reviewerComments, comments);
			break;
		}
		case "REJECTED": {
			String comments = readExcel("Test Datas", "Incident Reports", 1, 27);
			sendKeys(reviewerComments, comments);
			break;
		}

		}
	}
	
	/**
	 * @author Nandhalala.
	 * To enter social worker reviewer comments.
	 * 
	 * @param rowNumber - Accepts only approved or rejected as parameters.
	 * @return the status value of the given row.
	 * 
	 * @created on 12-01-2024.
	 */
	public void navigateHome() {
		click(home);
	}
	
	public void viewButton(String rowNumber) {
		waitForPageLoad(this.driver);
		String excatColumn = viewButton.replaceAll("rownumber", rowNumber);
		select(excatColumn);
		waitForPageLoad(this.driver);
	}

	public void editButton(String rowNumber) {
		String excatColumn = editButton.replaceAll("rownumber", rowNumber);
		select(excatColumn);
		waitForPageLoad(this.driver);
	}

	public void EditButton() {
		click(IRFormEditButton);
		waitForPageLoad(this.driver);
	}

	public void addNewIncidentReportButton() {

		waitForPageLoad(this.driver);

		if (addNewIncidentReportButton.isDisplayed()) {
			click(addNewIncidentReportButton);
			waitForPageLoad();
		} else {
			log(Status.FAIL, "Unable to click Add New Incident Report Button");
		}

	}

	public void nextButton() {

		click(nextButton);
	}

	public void selectIndividualDetailsDropdown() {

		click(individualDetailsDropDown);

		selectIndDetails = selectIndDetails.replaceAll("chooseIndDetails", "Arlia  Thomas(SUITE B)");
		select(selectIndDetails);
	}

	public void wasIndividualInjuredRadioButton() {

		wasIndividualInjuredYesRadioButton = wasIndividualInjuredYesRadioButton.replaceAll("?", "Yes");
		select(wasIndividualInjuredYesRadioButton);
		waitForPageLoad();
	}

	public void wasPatientInjuredRadioButton() {

		wasPatientInjured = wasPatientInjured.replaceAll("isInjured", "Yes");
		select(wasPatientInjured);
		waitForPageLoad();
	}

	public void saveButton() {

		click(saveButton);
		waitForPageLoad();
	}

	public void savedSuccessfulToastMsgokButton() {

		click(btnToastMsgSuccessOk);
	}

	public void ToastMsgOKButton() {

		click(OKBtnToastMsg);
	}

	public void eventDateAndTime() {

		switch (getConfigureProperty("currentDate&Time").toUpperCase()) {
		case "YES": {
			writeExcelToOverwrite("Test Datas", "Incident Reports", 1, 1, getCurrentDtYearMonth("MM/dd/yyyyhh:mma"));
			String eventDateAndTime = readExcel("Test Datas", "Incident Reports", 1, 1);
			sendKeys(eventDateAndTimeCalenderIconButton, eventDateAndTime);
			break;
		}
		case "NO": {
			String eventDateAndTime = readExcel("Test Datas", "Incident Reports", 1, 1);
			sendKeys(eventDateAndTimeCalenderIconButton, eventDateAndTime);
			break;
		}
		case "": {
			writeExcelToOverwrite("Test Datas", "Incident Reports", 1, 1, getCurrentDtYearMonth("MM/dd/yyyyhh:mma"));
			String eventDateAndTime = readExcel("Test Datas", "Incident Reports", 1, 1);
			sendKeys(eventDateAndTimeCalenderIconButton, eventDateAndTime);
			break;
		}
		}
	}

	public void eventDateAndFutureTime() {

		sendKeys(eventDateAndTimeCalenderIconButton, getFutureTime("MM/dd/yyyyhh:mma"));
	}

	public String getIndividualNameFromWasIndividualInjured() {
		return getText(wasIndividualInjuredText);
	}

	public void moreThan1MBImgFormatUpload(String fileName, String formatType) {

		if (getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("NO")
				&& getConfigureProperty("IncidentReportFileUpload").equalsIgnoreCase("Yes")) {

			click(attachmentIconButton);
			sleep(3000);

			String ImagePath = System.getProperty("user.dir") + "\\Individuals File Upload\\" + fileName + "."
					+ formatType;
			try {
				Robot robot = new Robot();

				// Copy the file path to the clipboard
				StringSelection stringSelection = new StringSelection(ImagePath);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

				// Simulate pressing Ctrl+V to paste the file path
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);

				// Simulate pressing Enter to confirm the file selection
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);

				try {
					waitForVisiblityOfElement(getImgSizeToastMsg(), 5);
					Assert.assertEquals("File size should be less than 1 MB Toast msg is Not Displayed as expected",
							"File(1) size should be less than 1 MB", getText(getImgSizeToastMsg()));
					log(Status.PASS, "File size should be less than 1 MB Toast msg is displayed successfully - "
							+ getText(getImgSizeToastMsg()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}

				ToastMsgOKButton();

			} catch (AWTException e) {
				e.printStackTrace();
			}

		} else if (getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("YES")) {
			log(Status.INFO, "MoreThan1MBFile Img Format scenario is SKIPPED due to Headless Run");
		} else {
			log(Status.INFO, "Enter invalid VALUE format in Config.property file");
		}
	}

	public void jfifFileUpload(String fileName, String formatType) {

		if (getConfigureProperty("IncidentReportFileUpload").equalsIgnoreCase("Yes")
				&& getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("NO")) {

			click(attachmentIconButton);
			sleep(3000);

			String ImagePath = System.getProperty("user.dir") + "\\Individuals File Upload\\" + fileName + "."
					+ formatType;
			try {
				Robot robot = new Robot();

				// Copy the file path to the clipboard
				StringSelection stringSelection = new StringSelection(ImagePath);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

				// Simulate pressing Ctrl+V to paste the file path
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);

				// Simulate pressing Enter to confirm the file selection
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);

				try {
					waitForVisiblityOfElement(getImgSizeToastMsg(), 5);
					Assert.assertEquals("Unable to restrict the JFIF File format", "JFIF format is not supported",
							getText(JFIFFileFormatNotSupportedToastMsg));
					log(Status.PASS, "JFIF FIle Format is NOT supported");
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}

				ToastMsgOKButton();

			} catch (AWTException e) {
				e.printStackTrace();
			}
		} else if (getConfigureProperty("IncidentReportFileUpload").equalsIgnoreCase("No")
				|| getConfigureProperty("IncidentReportFileUpload").equalsIgnoreCase("Yes")
						&& getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("Yes")) {
			log(Status.INFO, "Skip file Uploaded in injury photo field due to Headless Run");

		} else {
			log(Status.INFO, "Enter invalid VALUE format in Config.property file");
		}
	}

	public void Upload(String fileName, String formatType) {

		if (getConfigureProperty("IncidentReportFileUpload").equalsIgnoreCase("Yes")
				&& getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("NO")) {

			click(attachmentIconButton);
			sleep(3000);

			String ImagePath = System.getProperty("user.dir") + "\\Individuals File Upload\\" + fileName + "."
					+ formatType;
			try {
				Robot robot = new Robot();

				// Copy the file path to the clipboard
				StringSelection stringSelection = new StringSelection(ImagePath);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

				// Simulate pressing Ctrl+V to paste the file path
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);

				// Simulate pressing Enter to confirm the file selection
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);

				log(Status.PASS, "Image Uploaded successfully");

			} catch (AWTException e) {
				e.printStackTrace();
			}
		} else if (getConfigureProperty("IncidentReportFileUpload").equalsIgnoreCase("No")
				|| getConfigureProperty("IncidentReportFileUpload").equalsIgnoreCase("Yes")
						&& getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("Yes")) {
			log(Status.INFO, "Skip file Uploaded in injury photo field due to Headless Run");

		} else {
			log(Status.INFO, "Enter invalid VALUE format in Config.property file");
		}
	}

	public void deleteTheUploadedFile() {

		if (getConfigureProperty("IncidentReportFileUpload").equalsIgnoreCase("Yes")
				&& getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("NO")) {

			waitForFullPageElementLoad();

			click(attachmentDeleteButton);
		}
	}

	public IncidentReportPage abrasion() {

		click(injuryTypeAbrasionButton);
		String Abrasion = getAttribute(injuryTypeAbrasionButton, "class");
		if (Abrasion.contains("active")) {
			log(Status.PASS, "Able to select the Abrasion option");
		} else {
			log(Status.FAIL, "Unable to select the Abrasion option");
		}
		return this;
	}

	public IncidentReportPage bleeding() {

		click(injuryTypeBleedingButton);
		String Bleeding = getAttribute(injuryTypeBleedingButton, "class");
		if (Bleeding.contains("active")) {
			waitForFullPageElementLoad();
			log(Status.PASS, "Able to select the Bleeding option");
		} else {
			log(Status.FAIL, "Unable to select the Bleeding option");
		}
		return this;
	}

	public IncidentReportPage bruise() {
		click(injuryTypeBruiseButton);
		String Bruise = getAttribute(injuryTypeBleedingButton, "class");
		if (Bruise.contains("active")) {
			log(Status.PASS, "Able to select the Bruise option");
		} else {
			log(Status.FAIL, "Unable to select the Bruise option");
		}
		return this;
	}

	public IncidentReportPage scratch() {
		click(injuryTypeScratchButton);
		String Scratch = getAttribute(injuryTypeScratchButton, "class");
		if (Scratch.contains("active")) {
			log(Status.PASS, "Able to select the Scratch option");
		} else {
			log(Status.FAIL, "Unable to select the Scratch option");
		}
		return this;

	}

	public IncidentReportPage abrasionForUnselect() {

		click(injuryTypeAbrasionButton);
		String Abrasion = getAttribute(injuryTypeAbrasionButton, "class");
		if (Abrasion.contains("xyz")) {
			log(Status.PASS, "Able to unselect the Abrasion option");
		} else {
			log(Status.FAIL, "Unable to unselect the Abrasion option");
		}
		return this;
	}

	public IncidentReportPage bleedingForUnselect() {

		click(injuryTypeBleedingButton);
		String Bleeding = getAttribute(injuryTypeBleedingButton, "class");
		if (Bleeding.contains("xyz")) {
			waitForFullPageElementLoad();
			log(Status.PASS, "Able to unselect the Bleeding option");
		} else {
			log(Status.FAIL, "Unable to unselect the Bleeding option");
		}
		return this;
	}

	public IncidentReportPage bruiseForUnselect() {

		click(injuryTypeBruiseButton);
		String Bruise = getAttribute(injuryTypeBleedingButton, "class");
		if (Bruise.contains("xyz")) {
			log(Status.PASS, "Able to unselect the Bruise option");
		} else {
			log(Status.FAIL, "Unable to unselect the Bruise option");
		}
		return this;

	}

	public IncidentReportPage scratchForUnselect() {

		click(injuryTypeScratchButton);
		String Scratch = getAttribute(injuryTypeScratchButton, "class");
		if (Scratch.contains("xyz")) {
			log(Status.PASS, "Able to unselect the Scratch option");
		} else {
			log(Status.FAIL, "Unable to unselect the Scratch option");
		}

		return this;
	}

	public IncidentReportPage lightOption() {

		try {
			click(injurySeverityLight);
			log(Status.PASS, "Light option is selected");
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		return this;
	}

	public IncidentReportPage mediumOption() {

		try {
			click(injurySeverityMedium);
			waitForFullPageElementLoad();
			log(Status.PASS, "Medium option is selected");
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		return this;
	}

	public IncidentReportPage highOption() {

		try {
			click(injurySeverityHigh);
			waitForFullPageElementLoad();
			log(Status.PASS, "High option is selected");
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		return this;
	}

	public IncidentReportPage greenColor() {

		try {
			click(injuryColorGreen);
			log(Status.PASS, "Green color option is selected");
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		return this;
	}

	public IncidentReportPage redColor() {

		try {
			click(injuryColorRed);
			log(Status.PASS, "Red color option is selected");
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		return this;
	}

	public IncidentReportPage blackColor() {

		try {
			click(injuryColorBlack);
			log(Status.PASS, "Black color option is selected");
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		return this;
	}

	public IncidentReportPage brownColor() {

		try {
			click(injuryColorBrown);
			log(Status.PASS, "Brown color option is selected");
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		return this;
	}

	public void notificationDateFieldCalenderIconButton() {

		click(btnCalendar);
	}

	public void selectDateInDatePickerAndVerify() {

		System.out.println("CURRENT DATE IS :" + getCurrentDate());
		chooseDate = chooseDate.replaceAll("selectDate", getCurrentDate());
		select(chooseDate);

		waitForFullPageElementLoad();

		String selectedDate = getAttribute(dob, "value");

		try {
			Assert.assertEquals("Selected date is NOT displayed in DOB* Field",
					getCurrentDtYearMonth("MM/" + getCurrentDate() + "/yyyy"), selectedDate);
			log(Status.PASS, "Selected date is displayed in DOB* Field Exp Dt - "
					+ getCurrentDtYearMonth("MM/" + getCurrentDate() + "/yyyy") + " | Act Dt - " + selectedDate);
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	public IncidentReportPage verifyPreviousDatesIsDisabled() {

		String attribute = getAttribute(eventDateAndTimeCalenderIconButton, "value");
		System.out.println("value - " + attribute);

		String eventYear = attribute.substring(0, 4);
		System.out.println("Year alone - " + eventYear);

		String eventDate = attribute.substring(8, 10);
		System.out.println("date alone - " + eventDate);

		int convertEventDateToInt = Integer.parseInt(eventDate);

		int intValue = Integer.parseInt(eventDate);
		int PreviousDate = intValue - 1;

		String PrevDate = Integer.toString(PreviousDate);
		System.out.println("Current Date - 1 - " + PrevDate);

		int NextDt = intValue - 1;

		String NextDate = Integer.toString(NextDt);
		System.out.println("Current Date + 1 - " + NextDate);

		String eventMonth = attribute.substring(5, 7);
		System.out.println("Month alone - " + eventMonth);

//		String text = getText(datePicker);
//
//		// Mapping of numeric months to three-letter abbreviations
//		String[] monthAbbreviations = { "", "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV",
//				"DEC" };

		// Convert numeric month to integer
		int monthNumber = Integer.parseInt(eventMonth);

		// Validate the month number
		if (monthNumber < 1 || monthNumber > 12) {
			throw new IllegalArgumentException("Invalid month number: " + eventMonth);
		}
//    
//   String MentionedMonthInNumeric = monthAbbreviations[monthNumber];
//
//   System.out.println(monthAbbreviations[monthNumber]);
//   
//   while(true) {
//	   
//   if(text.equals(MentionedMonthInNumeric+" "+eventYear)) {
//	   break;
//   }
//   else {
//		click(leftArrowBtn);
//	}
//   
		if (eventMonth.equals("01") || eventMonth.equals("02") || eventMonth.equals("03") || eventMonth.equals("04")
				|| eventMonth.equals("05") || eventMonth.equals("06") || eventMonth.equals("07")
				|| eventMonth.equals("08") || eventMonth.equals("09") || eventMonth.equals("10")
				|| eventMonth.equals("11") || eventMonth.equals("12") && (convertEventDateToInt < 01)) {

			selectNextDate = selectNextDate.replaceAll("selectDate", PrevDate);
			WebElement getPreviousDate = findElementByXpath(selectNextDate);

			String previousDate = getAttribute(getPreviousDate, "aria-disabled");

			if (previousDate.equals("true")) {
				log(Status.PASS, "The Previous dates are disabled to the current date in Notification Date field");
			}
		} else if (eventDate.equals("01")) {

			log(Status.INFO, "The Mentioned date in event is 01");
		}
		return this;

	}

	public void verifyNextToTheCurrentDateIsDisabled() {

		String attribute = getAttribute(eventDateAndTimeCalenderIconButton, "value");
		System.out.println("value - " + attribute);

		String eventDate = attribute.substring(8, 10);
		System.out.println("date alone - " + eventDate);

		String eventMonth = attribute.substring(5, 7);
		System.out.println("Month alone - " + eventMonth);

		int intEventDt = Integer.parseInt(eventDate);

		if (eventMonth.equals("01") || eventMonth.equals("03") || eventMonth.equals("05") || eventMonth.equals("07")
				|| eventMonth.equals("08") || eventMonth.equals("10") || eventMonth.equals("12") && intEventDt < 31) {

			selectNextToTheCurrentDate = selectNextToTheCurrentDate.replaceAll("nextDate", nextToCurrentDate());
			WebElement getNextDate = findElementByXpath(selectNextToTheCurrentDate);

			String NextDate = getAttribute(getNextDate, "aria-disabled");

			if (NextDate.equals("true")) {
				log(Status.PASS, "Next to the current dates are disabled in Notification Date field");
			} else {
				log(Status.FAIL, "Next to the current dates are NOT disabled in Notification Date field");
			}

		} else if (eventMonth.equals("01") || eventMonth.equals("03") || eventMonth.equals("05")
				|| eventMonth.equals("07") || eventMonth.equals("08") || eventMonth.equals("10")
				|| eventMonth.equals("12") && eventDate.equals("31")) {

			log(Status.INFO, "Reached Month end date");

		} else if (eventMonth.equals("04") || eventMonth.equals("06") || eventMonth.equals("09")
				|| eventMonth.equals("11") && intEventDt < 30) {

			selectNextToTheCurrentDate = selectNextToTheCurrentDate.replaceAll("nextDate", nextToCurrentDate());
			WebElement getNextDate = findElementByXpath(selectNextToTheCurrentDate);

			String NextDate = getAttribute(getNextDate, "aria-disabled");

			if (NextDate.equals("true")) {
				log(Status.PASS, "Next to the current dates are disabled in Notification Date field");
			} else {
				log(Status.FAIL, "Next to the current dates are NOT disabled in Notification Date field");
			}

		} else if (eventMonth.equals("04") || eventMonth.equals("06") || eventMonth.equals("09")
				|| eventMonth.equals("11") && eventDate.equals("30")) {

			log(Status.INFO, "Reached Month end date");

		} else if (eventMonth.equals("02") && intEventDt < 29) {

			selectNextToTheCurrentDate = selectNextToTheCurrentDate.replaceAll("nextDate", nextToCurrentDate());
			WebElement getNextDate = findElementByXpath(selectNextToTheCurrentDate);

			String NextDate = getAttribute(getNextDate, "aria-disabled");

			if (NextDate.equals("true")) {
				log(Status.PASS, "Next to the current dates are disabled in Notification Date field");
			} else {
				log(Status.FAIL, "Next to the current dates are NOT disabled in Notification Date field");
			}

		} else if (eventMonth.equals("02") && eventDate.equals("29")) {

			log(Status.INFO, "Reached Month end date");
		}
	}

	public void selectNotificateDateUsingDD() {

		String attribute = getAttribute(eventDateAndTimeCalenderIconButton, "value");
		System.out.println("value - " + attribute);

		String eventYear = attribute.substring(0, 4);
		System.out.println("Year alone - " + eventYear);

		String eventDate = attribute.substring(8, 10);
		System.out.println("date alone - " + eventDate);

		String eventMonth = attribute.substring(5, 7);
		System.out.println("Month alone - " + eventMonth);

		click(monthYearDD);

		WebElement years = findElementByXpath("//table//tbody/tr[6]/td[4]");

		String getMentionedYearinEventDt = years.getText();

		if (getMentionedYearinEventDt.equals(eventYear)) {

			chooseYear = chooseYear.replaceAll("selectYear", eventYear);
			select(chooseYear);
			log(Status.INFO, "Select the year in date picker - YEAR " + eventYear);
		}

		// Mapping of numeric months to three-letter abbreviations
		String[] monthAbbreviations = { "", "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV",
				"DEC" };

		// Convert numeric month to integer
		int monthNumber = Integer.parseInt(eventMonth);

		// Validate the month number
		if (monthNumber < 1 || monthNumber > 12) {
			throw new IllegalArgumentException("Invalid month number: " + eventMonth);
		}

		String MentionedMonthInNumeric = monthAbbreviations[monthNumber];

		System.out.println("Mentioned month - " + monthAbbreviations[monthNumber]);

		try {
			chooseMonth = chooseMonth.replaceAll("selectMonth", MentionedMonthInNumeric);
			select(chooseMonth);
			log(Status.INFO, "Select the month in date picker - MONTH " + MentionedMonthInNumeric);

		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
		}

		try {
			currentDate = currentDate.replaceAll("Date", getCurrentDate());
			select(currentDate);
			log(Status.INFO, "Select the date in date picker - DATE " + getCurrentDate());

		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
		}

		String selectedDate = getAttribute(notificationDateField, "value");

		try {
			Assert.assertEquals(
					"[Selected date, month and year using dropdown] - Selected date is NOT displayed in Notification Date Field",
					getCurrentMonth() + "/" + getCurrentDate() + "/" + eventYear, selectedDate);

			log(Status.PASS,
					"[Selected date, month and year using dropdown] - Selected date is displayed in Notification Date Field Exp Dt - "
							+ selectedDate + " Actual Dt - " + getCurrentMonth() + "/" + getCurrentDate() + "/"
							+ eventYear);

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	public IncidentReportPage frontViewForeHeadInjury() {

		click(frontViewForeHeadInjury);
		waitForFullPageElementLoad();
		String clickedFrontHead = getAttribute(frontViewForeHeadInjury, "class");

		if (clickedFrontHead.equals("ng-star-inserted injurysite selsite")) {
			log(Status.PASS, "SELECT in Front view  front view Fore Head successfully");
		} else {
			log(Status.FAIL, "Unable to SELECT in Front view fore Head");
		}
		return this;
	}

	public IncidentReportPage frontViewFaceInjury() {

		click(frontViewFaceInjury);
		waitForFullPageElementLoad();
		String clickedFace = getAttribute(frontViewFaceInjury, "class");

		if (clickedFace.equals("ng-star-inserted injurysite selsite")) {
			log(Status.PASS, "SELECT in Front view  Face successfully");
		} else {
			log(Status.FAIL, "Unable to SELECT in Front view Face");
		}
		return this;
	}

	public IncidentReportPage frontViewRightShoulderInjury() {

		click(frontViewRightShoulderInjury);
		waitForFullPageElementLoad();
		String clickedRShoulder = getAttribute(frontViewRightShoulderInjury, "class");

		if (clickedRShoulder.equals("ng-star-inserted injurysite selsite")) {
			log(Status.PASS, "SELECT in Front view  Right Shoulder successfully");
		} else {
			log(Status.FAIL, "Unable to SELECT in Front view Right Shoulder");
		}
		return this;
	}

	public IncidentReportPage frontViewLeftShoulderInjury() {

		click(frontViewLeftShoulderInjury);
		waitForFullPageElementLoad();
		String clickedLShoulder = getAttribute(frontViewLeftShoulderInjury, "class");

		if (clickedLShoulder.equals("ng-star-inserted injurysite selsite")) {
			log(Status.PASS, "SELECT in Front view  Left Shoulder successfully");
		} else {
			log(Status.FAIL, "Unable to SELECT in Front view Left Shoulder");
		}
		return this;
	}

	public IncidentReportPage frontViewChestInjury() {

		click(frontViewChestInjury);
		waitForFullPageElementLoad();
		String clickedChest = getAttribute(frontViewChestInjury, "class");

		if (clickedChest.equals("ng-star-inserted injurysite selsite")) {
			log(Status.PASS, "SELECT in Front view  Chest successfully");
		} else {
			log(Status.FAIL, "Unable to SELECT in Front view Chest");
		}
		return this;
	}

	public IncidentReportPage frontViewAbdomenInjury() {

		click(frontViewAbdomenInjury);
		waitForFullPageElementLoad();
		String clickedAbdomen = getAttribute(frontViewAbdomenInjury, "class");

		if (clickedAbdomen.equals("ng-star-inserted injurysite selsite")) {
			log(Status.PASS, "SELECT in Front view  Abdomen successfully");
		} else {
			log(Status.FAIL, "Unable to SELECT in Front view Abdomen");
		}
		return this;
	}

	public IncidentReportPage frontViewRightArmInjury() {

		click(frontViewRightArmInjury);
		waitForFullPageElementLoad();
		String clickedRArm = getAttribute(frontViewRightArmInjury, "class");

		if (clickedRArm.equals("ng-star-inserted injurysite selsite")) {
			log(Status.PASS, "SELECT in Front view  Right Arm successfully");
		} else {
			log(Status.FAIL, "Unable to SELECT in Front view Right Arm");
		}
		return this;
	}

	public IncidentReportPage frontViewLefttArmInjury() {

		click(frontViewLefttArmInjury);
		waitForFullPageElementLoad();
		String clickedLArm = getAttribute(frontViewLefttArmInjury, "class");

		if (clickedLArm.equals("ng-star-inserted injurysite selsite")) {
			log(Status.PASS, "SELECT in Front view  Left Arm successfully");
		} else {
			log(Status.FAIL, "Unable to SELECT in Front view Left Arm");
		}
		return this;
	}

	public IncidentReportPage frontViewRightWristInjury() {

		click(frontViewRightWristInjury);
		waitForFullPageElementLoad();
		String clickedRWrist = getAttribute(frontViewRightWristInjury, "class");

		if (clickedRWrist.equals("ng-star-inserted injurysite selsite")) {
			log(Status.PASS, "SELECT in Front view  Right Wrist successfully");
		} else {
			log(Status.FAIL, "Unable to SELECT in Front view Right Wrist");
		}
		return this;
	}

	public IncidentReportPage frontViewLefttWristInjury() {

		click(frontViewLefttWristInjury);
		waitForFullPageElementLoad();
		String clickedLWrist = getAttribute(frontViewLefttWristInjury, "class");

		if (clickedLWrist.equals("ng-star-inserted injurysite selsite")) {
			log(Status.PASS, "SELECT in Front view  Left Wrist successfully");
		} else {
			log(Status.FAIL, "Unable to SELECT in Front view Left Wrist");
		}
		return this;
	}

	public IncidentReportPage frontViewRightKneeInjury() {

		click(frontViewRightKneeInjury);
		waitForFullPageElementLoad();
		String clickedRknee = getAttribute(frontViewRightKneeInjury, "class");

		if (clickedRknee.equals("ng-star-inserted injurysite selsite")) {
			log(Status.PASS, "SELECT in Front view  Right Knee successfully");
		} else {
			log(Status.FAIL, "Unable to SELECT in Front view Right Knee");
		}
		return this;
	}

	public IncidentReportPage frontViewLeftKneeInjury() {

		click(frontViewLeftKneeInjury);
		waitForFullPageElementLoad();
		String clickedLknee = getAttribute(frontViewLeftKneeInjury, "class");

		if (clickedLknee.equals("ng-star-inserted injurysite selsite")) {
			log(Status.PASS, "SELECT in Front view  Left Knee successfully");
		} else {
			log(Status.FAIL, "Unable to SELECT in Front view Left Knee");
		}
		return this;
	}

	public IncidentReportPage frontViewLeftFootInjury() {

		click(frontViewLeftFootInjury);
		waitForFullPageElementLoad();
		String clickedLFoot = getAttribute(frontViewLeftFootInjury, "class");

		if (clickedLFoot.equals("ng-star-inserted injurysite selsite")) {
			log(Status.PASS, "SELECT in Front view  Left Foot successfully");
		} else {
			log(Status.FAIL, "Unable to SELECT in Front view Left Foot");
		}
		return this;
	}

	public IncidentReportPage frontViewRightFootInjury() {

		click(frontViewRightFootInjury);
		waitForFullPageElementLoad();
		String clickedRFoot = getAttribute(frontViewRightFootInjury, "class");

		if (clickedRFoot.equals("ng-star-inserted injurysite selsite")) {
			log(Status.PASS, "SELECT in Front view  Right Foot successfully");
		} else {
			log(Status.FAIL, "Unable to SELECT in Front view Right Foot");
		}
		return this;
	}

	public IncidentReportPage backViewHeadInjury() {

		click(backViewHeadInjury);
		waitForFullPageElementLoad();
		String clickedHead = getAttribute(backViewHeadInjury, "class");

		if (clickedHead.equals("ng-star-inserted injurysite selsite")) {
			log(Status.PASS, "SELECT in back view Head successfully");
		} else {
			log(Status.FAIL, "Unable to SELECT in back view Head");
		}
		return this;
	}

	public IncidentReportPage backViewRightShoulderInjury() {

		click(backViewRightShoulderInjury);
		waitForFullPageElementLoad();
		String clickedRShoulder = getAttribute(backViewRightShoulderInjury, "class");

		if (clickedRShoulder.equals("ng-star-inserted injurysite selsite")) {
			log(Status.PASS, "SELECT in back view  Right Shoulder successfully");
		} else {
			log(Status.FAIL, "Unable to SELECT in back view Right Shoulder");
		}
		return this;
	}

	public IncidentReportPage backViewLeftShoulderInjury() {

		click(backViewLeftShoulderInjury);
		waitForFullPageElementLoad();
		String clickedLShoulder = getAttribute(backViewLeftShoulderInjury, "class");

		if (clickedLShoulder.equals("ng-star-inserted injurysite selsite")) {
			log(Status.PASS, "SELECT in back view  Left Shoulder successfully");
		} else {
			log(Status.FAIL, "Unable to SELECT in back view Left Shoulder");
		}
		return this;
	}

	public IncidentReportPage backViewBackInjury() {

		click(backViewBackInjury);
		waitForFullPageElementLoad();
		String clickedBack = getAttribute(backViewLeftShoulderInjury, "class");

		if (clickedBack.equals("ng-star-inserted injurysite selsite")) {
			log(Status.PASS, "SELECT in back view Back side successfully");
		} else {
			log(Status.FAIL, "Unable to SELECT in back view Back side");
		}
		return this;
	}

	public IncidentReportPage backViewHipInjury() {

		click(backViewHipInjury);
		waitForFullPageElementLoad();
		String clickedHip = getAttribute(backViewHipInjury, "class");

		if (clickedHip.equals("ng-star-inserted injurysite selsite")) {
			log(Status.PASS, "SELECT in back view Hip successfully");
		} else {
			log(Status.FAIL, "Unable to SELECT in back view Hip");
		}
		return this;
	}

	public IncidentReportPage backViewRightArmInjury() {

		click(backViewRightArmInjury);
		waitForFullPageElementLoad();
		String clickedRArm = getAttribute(backViewRightArmInjury, "class");

		if (clickedRArm.equals("ng-star-inserted injurysite selsite")) {
			log(Status.PASS, "SELECT in back view  Right Arm successfully");
		} else {
			log(Status.FAIL, "Unable to SELECT in back view Right Arm");
		}
		return this;
	}

	public IncidentReportPage backViewLefttArmInjury() {

		click(backViewLefttArmInjury);
		waitForFullPageElementLoad();
		String clickedLArm = getAttribute(backViewLefttArmInjury, "class");

		if (clickedLArm.equals("ng-star-inserted injurysite selsite")) {
			log(Status.PASS, "SELECT in back view  Left Arm successfully");
		} else {
			log(Status.FAIL, "Unable to SELECT in back view Left Arm");
		}
		return this;
	}

	public IncidentReportPage backViewRightWristInjury() {

		click(backViewRightWristInjury);
		waitForFullPageElementLoad();
		String clickedRWrist = getAttribute(backViewRightWristInjury, "class");

		if (clickedRWrist.equals("ng-star-inserted injurysite selsite")) {
			log(Status.PASS, "SELECT in back view  Right Wrist successfully");
		} else {
			log(Status.FAIL, "Unable to SELECT in back view Right Wrist");
		}
		return this;
	}

	public IncidentReportPage backViewLefttWristInjury() {

		click(backViewLefttWristInjury);
		waitForFullPageElementLoad();
		String clickedLWrist = getAttribute(backViewLefttWristInjury, "class");

		if (clickedLWrist.equals("ng-star-inserted injurysite selsite")) {
			log(Status.PASS, "SELECT in back view  Left Wrist successfully");
		} else {
			log(Status.FAIL, "Unable to SELECT in back view Left Wrist");
		}
		return this;
	}

	public IncidentReportPage backViewRightKneeInjury() {

		click(backViewRightKneeInjury);
		waitForFullPageElementLoad();
		String clickedRknee = getAttribute(backViewRightKneeInjury, "class");

		if (clickedRknee.equals("ng-star-inserted injurysite selsite")) {
			log(Status.PASS, "SELECT in back view  Right Knee successfully");
		} else {
			log(Status.FAIL, "Unable to SELECT in back view Right Knee");
		}
		return this;
	}

	public IncidentReportPage backViewLeftKneeInjury() {

		click(backViewLeftKneeInjury);
		waitForFullPageElementLoad();
		String clickedLknee = getAttribute(backViewLeftKneeInjury, "class");

		if (clickedLknee.equals("ng-star-inserted injurysite selsite")) {
			log(Status.PASS, "SELECT in back view  Left Knee successfully");
		} else {
			log(Status.FAIL, "Unable to SELECT in back view Left Knee");
		}
		return this;
	}

	public IncidentReportPage backViewLeftFootInjury() {

		click(backViewLeftFootInjury);
		waitForFullPageElementLoad();
		String clickedLFoot = getAttribute(backViewLeftFootInjury, "class");

		if (clickedLFoot.equals("ng-star-inserted injurysite selsite")) {
			log(Status.PASS, "SELECT in back view  Left Foot successfully");
		} else {
			log(Status.FAIL, "Unable to SELECT in back view Left Foot");
		}
		return this;
	}

	public IncidentReportPage backViewRightFootInjury() {

		click(backViewRightFootInjury);
		waitForFullPageElementLoad();
		String clickedRFoot = getAttribute(backViewRightFootInjury, "class");

		if (clickedRFoot.equals("ng-star-inserted injurysite selsite")) {
			log(Status.PASS, "SELECT in back view  Right Foot successfully");
		} else {
			log(Status.FAIL, "Unable to SELECT in back view Right Foot");
		}
		return this;
	}

	public IncidentReportPage unselectFrontViewForeHeadInjury() {

		click(frontViewForeHeadInjury);
		waitForFullPageElementLoad();
		String clickedFrontHead = getAttribute(frontViewForeHeadInjury, "class");

		if (clickedFrontHead.equals("ng-star-inserted injurysite")) {
			log(Status.PASS, "UN-SELECT in Front view  front view Fore Head successfully");
		} else {
			log(Status.FAIL, "Unable to UN-SELECT in Front view fore Head");
		}
		return this;
	}

	public IncidentReportPage unselectFrontViewFaceInjury() {

		click(frontViewFaceInjury);
		waitForFullPageElementLoad();
		String clickedFace = getAttribute(frontViewFaceInjury, "class");

		if (clickedFace.equals("ng-star-inserted injurysite")) {
			log(Status.PASS, "UN-SELECT in Front view  Face successfully");
		} else {
			log(Status.FAIL, "Unable to UN-SELECT in Front view Face");
		}
		return this;
	}

	public IncidentReportPage unselectFrontViewRightShoulderInjury() {

		click(frontViewRightShoulderInjury);
		waitForFullPageElementLoad();
		String clickedRShoulder = getAttribute(frontViewRightShoulderInjury, "class");

		if (clickedRShoulder.equals("ng-star-inserted injurysite")) {
			log(Status.PASS, "UN-SELECT in Front view  Right Shoulder successfully");
		} else {
			log(Status.FAIL, "Unable to UN-SELECT in Front view Right Shoulder");
		}
		return this;
	}

	public IncidentReportPage unselectFrontViewLeftShoulderInjury() {

		click(frontViewLeftShoulderInjury);
		waitForFullPageElementLoad();
		String clickedLShoulder = getAttribute(frontViewLeftShoulderInjury, "class");

		if (clickedLShoulder.equals("ng-star-inserted injurysite")) {
			log(Status.PASS, "UN-SELECT in Front view  Left Shoulder successfully");
		} else {
			log(Status.FAIL, "Unable to UN-SELECT in Front view Left Shoulder");
		}
		return this;
	}

	public IncidentReportPage unselectFrontViewChestInjury() {

		click(frontViewChestInjury);
		waitForFullPageElementLoad();
		String clickedChest = getAttribute(frontViewChestInjury, "class");

		if (clickedChest.equals("ng-star-inserted injurysite")) {
			log(Status.PASS, "UN-SELECT in Front view  Chest successfully");
		} else {
			log(Status.FAIL, "Unable to UN-SELECT in Front view Chest");
		}
		return this;
	}

	public IncidentReportPage unselectFrontViewAbdomenInjury() {

		click(frontViewAbdomenInjury);
		waitForFullPageElementLoad();
		String clickedAbdomen = getAttribute(frontViewAbdomenInjury, "class");

		if (clickedAbdomen.equals("ng-star-inserted injurysite")) {
			log(Status.PASS, "UN-SELECT in Front view  Abdomen successfully");
		} else {
			log(Status.FAIL, "Unable to UN-SELECT in Front view Abdomen");
		}
		return this;
	}

	public IncidentReportPage unselectFrontViewRightArmInjury() {

		click(frontViewRightArmInjury);
		waitForFullPageElementLoad();
		String clickedRArm = getAttribute(frontViewRightArmInjury, "class");

		if (clickedRArm.equals("ng-star-inserted injurysite")) {
			log(Status.PASS, "UN-SELECT in Front view  Right Arm successfully");
		} else {
			log(Status.FAIL, "Unable to UN-SELECT in Front view Right Arm");
		}
		return this;
	}

	public IncidentReportPage unselectFrontViewLefttArmInjury() {

		click(frontViewLefttArmInjury);
		waitForFullPageElementLoad();
		String clickedLArm = getAttribute(frontViewLefttArmInjury, "class");

		if (clickedLArm.equals("ng-star-inserted injurysite")) {
			log(Status.PASS, "UN-SELECT in Front view  Left Arm successfully");
		} else {
			log(Status.FAIL, "Unable to UN-SELECT in Front view Left Arm");
		}
		return this;
	}

	public IncidentReportPage unselectFrontViewRightWristInjury() {

		click(frontViewRightWristInjury);
		waitForFullPageElementLoad();
		String clickedRWrist = getAttribute(frontViewRightWristInjury, "class");

		if (clickedRWrist.equals("ng-star-inserted injurysite")) {
			log(Status.PASS, "UN-SELECT in Front view  Right Wrist successfully");
		} else {
			log(Status.FAIL, "Unable to UN-SELECT in Front view Right Wrist");
		}
		return this;
	}

	public IncidentReportPage unselectFrontViewLefttWristInjury() {

		click(frontViewLefttWristInjury);
		waitForFullPageElementLoad();
		String clickedLWrist = getAttribute(frontViewLefttWristInjury, "class");

		if (clickedLWrist.equals("ng-star-inserted injurysite")) {
			log(Status.PASS, "UN-SELECT in Front view  Left Wrist successfully");
		} else {
			log(Status.FAIL, "Unable to UN-SELECT in Front view Left Wrist");
		}
		return this;
	}

	public IncidentReportPage unselectFrontViewRightKneeInjury() {

		click(frontViewRightKneeInjury);
		waitForFullPageElementLoad();
		String clickedRknee = getAttribute(frontViewRightKneeInjury, "class");

		if (clickedRknee.equals("ng-star-inserted injurysite")) {
			log(Status.PASS, "UN-SELECT in Front view  Right Knee successfully");
		} else {
			log(Status.FAIL, "Unable to UN-SELECT in Front view Right Knee");
		}
		return this;
	}

	public IncidentReportPage unselectFrontViewLeftKneeInjury() {

		click(frontViewLeftKneeInjury);
		waitForFullPageElementLoad();
		String clickedLknee = getAttribute(frontViewLeftKneeInjury, "class");

		if (clickedLknee.equals("ng-star-inserted injurysite")) {
			log(Status.PASS, "UN-SELECT in Front view  Left Knee successfully");
		} else {
			log(Status.FAIL, "Unable to UN-SELECT in Front view Left Knee");
		}
		return this;
	}

	public IncidentReportPage unselectFrontViewLeftFootInjury() {

		click(frontViewLeftFootInjury);
		waitForFullPageElementLoad();
		String clickedLFoot = getAttribute(frontViewLeftFootInjury, "class");

		if (clickedLFoot.equals("ng-star-inserted injurysite")) {
			log(Status.PASS, "UN-SELECT in Front view  Left Foot successfully");
		} else {
			log(Status.FAIL, "Unable to UN-SELECT in Front view Left Foot");
		}
		return this;
	}

	public IncidentReportPage unselectFrontViewRightFootInjury() {

		click(frontViewRightFootInjury);
		waitForFullPageElementLoad();
		String clickedRFoot = getAttribute(frontViewRightFootInjury, "class");

		if (clickedRFoot.equals("ng-star-inserted injurysite")) {
			log(Status.PASS, "UN-SELECT in Front view  Right Foot successfully");
		} else {
			log(Status.FAIL, "Unable to UN-SELECT in Front view Right Foot");
		}
		return this;
	}

	public IncidentReportPage unselectBackViewHeadInjury() {

		click(backViewHeadInjury);
		waitForFullPageElementLoad();
		String clickedHead = getAttribute(backViewHeadInjury, "class");

		if (clickedHead.equals("ng-star-inserted injurysite")) {
			log(Status.PASS, "UN-SELECT in back view Head successfully");
		} else {
			log(Status.FAIL, "Unable to UN-SELECT in back view Head");
		}
		return this;
	}

	public IncidentReportPage unselectBackViewRightShoulderInjury() {

		click(backViewRightShoulderInjury);
		waitForFullPageElementLoad();
		String clickedRShoulder = getAttribute(backViewRightShoulderInjury, "class");

		if (clickedRShoulder.equals("ng-star-inserted injurysite")) {
			log(Status.PASS, "UN-SELECT in back view  Right Shoulder successfully");
		} else {
			log(Status.FAIL, "Unable to UN-SELECT in back view Right Shoulder");
		}
		return this;
	}

	public IncidentReportPage unselectBackViewLeftShoulderInjury() {

		click(backViewLeftShoulderInjury);
		waitForFullPageElementLoad();
		String clickedLShoulder = getAttribute(backViewLeftShoulderInjury, "class");

		if (clickedLShoulder.equals("ng-star-inserted injurysite")) {
			log(Status.PASS, "UN-SELECT in back view  Left Shoulder successfully");
		} else {
			log(Status.FAIL, "Unable to UN-SELECT in back view Left Shoulder");
		}
		return this;
	}

	public IncidentReportPage unselectBackViewBackInjury() {

		click(backViewBackInjury);
		waitForFullPageElementLoad();
		String clickedBack = getAttribute(backViewLeftShoulderInjury, "class");

		if (clickedBack.equals("ng-star-inserted injurysite")) {
			log(Status.PASS, "UN-SELECT in back view Back side successfully");
		} else {
			log(Status.FAIL, "Unable to UN-SELECT in back view Back side");
		}
		return this;
	}

	public IncidentReportPage unselectBackViewHipInjury() {

		click(backViewHipInjury);
		waitForFullPageElementLoad();
		String clickedHip = getAttribute(backViewHipInjury, "class");

		if (clickedHip.equals("ng-star-inserted injurysite")) {
			log(Status.PASS, "UN-SELECT in back view Hip successfully");
		} else {
			log(Status.FAIL, "Unable to UN-SELECT in back view Hip");
		}
		return this;
	}

	public IncidentReportPage unselectBackViewRightArmInjury() {

		click(backViewRightArmInjury);
		waitForFullPageElementLoad();
		String clickedRArm = getAttribute(backViewRightArmInjury, "class");

		if (clickedRArm.equals("ng-star-inserted injurysite")) {
			log(Status.PASS, "UN-SELECT in back view  Right Arm successfully");
		} else {
			log(Status.FAIL, "Unable to UN-SELECT in back view Right Arm");
		}
		return this;
	}

	public IncidentReportPage unselectBackViewLefttArmInjury() {

		click(backViewLefttArmInjury);
		waitForFullPageElementLoad();
		String clickedLArm = getAttribute(backViewLefttArmInjury, "class");

		if (clickedLArm.equals("ng-star-inserted injurysite")) {
			log(Status.PASS, "UN-SELECT in back view  Left Arm successfully");
		} else {
			log(Status.FAIL, "Unable to UN-SELECT in back view Left Arm");
		}
		return this;
	}

	public IncidentReportPage unselectBackViewRightWristInjury() {

		click(backViewRightWristInjury);
		waitForFullPageElementLoad();
		String clickedRWrist = getAttribute(backViewRightWristInjury, "class");

		if (clickedRWrist.equals("ng-star-inserted injurysite")) {
			log(Status.PASS, "UN-SELECT in back view  Right Wrist successfully");
		} else {
			log(Status.FAIL, "Unable to UN-SELECT in back view Right Wrist");
		}
		return this;
	}

	public IncidentReportPage unselectBackViewLefttWristInjury() {

		click(backViewLefttWristInjury);
		waitForFullPageElementLoad();
		String clickedLWrist = getAttribute(backViewLefttWristInjury, "class");

		if (clickedLWrist.equals("ng-star-inserted injurysite")) {
			log(Status.PASS, "UN-SELECT in back view  Left Wrist successfully");
		} else {
			log(Status.FAIL, "Unable to UN-SELECT in back view Left Wrist");
		}
		return this;
	}

	public IncidentReportPage unselectBackViewRightKneeInjury() {

		click(backViewRightKneeInjury);
		waitForFullPageElementLoad();
		String clickedRknee = getAttribute(backViewRightKneeInjury, "class");

		if (clickedRknee.equals("ng-star-inserted injurysite")) {
			log(Status.PASS, "UN-SELECT in back view  Right Knee successfully");
		} else {
			log(Status.FAIL, "Unable to UN-SELECT in back view Right Knee");
		}
		return this;
	}

	public IncidentReportPage unselectBackViewLeftKneeInjury() {

		click(backViewLeftKneeInjury);
		waitForFullPageElementLoad();
		String clickedLknee = getAttribute(backViewLeftKneeInjury, "class");

		if (clickedLknee.equals("ng-star-inserted injurysite")) {
			log(Status.PASS, "UN-SELECT in back view  Left Knee successfully");
		} else {
			log(Status.FAIL, "Unable to UN-SELECT in back view Left Knee");
		}
		return this;
	}

	public IncidentReportPage unselectBackViewLeftFootInjury() {

		click(backViewLeftFootInjury);
		waitForFullPageElementLoad();
		String clickedLFoot = getAttribute(backViewLeftFootInjury, "class");

		if (clickedLFoot.equals("ng-star-inserted injurysite")) {
			log(Status.PASS, "UN-SELECT in back view  Left Foot successfully");
		} else {
			log(Status.FAIL, "Unable to UN-SELECT in back view Left Foot");
		}
		return this;
	}

	public IncidentReportPage unselectBackViewRightFootInjury() {

		click(backViewRightFootInjury);
		waitForFullPageElementLoad();
		String clickedRFoot = getAttribute(backViewRightFootInjury, "class");

		if (clickedRFoot.equals("ng-star-inserted injurysite")) {
			log(Status.PASS, "UN-SELECT in back view  Right Foot successfully");
		} else {
			log(Status.FAIL, "Unable to UN-SELECT in back view Right Foot");
		}
		return this;
	}

	public void pastTimeInNotificationTime() {

		sendKeys(timeTxtbox, getPastTime("HH:MMa"));
		click(notifedByTxtBox);
	}

	public void futureTimeInNotificationTime() {

		sendKeys(timeTxtbox, getFutureTime("HH:MMa"));
		click(notifedByTxtBox);
	}

	public void breadCrumREPORTTxtLink() {

		click(breadCrumTxtLinkReports);
	}

	public String getLocationValue() {
		return getText(locationValue);
	}

	public String getInjuryCausedValue() {
		return getText(injuryCauseValue);
	}

	public String getWasInjuredValue() {
		return getText(wasInjuredValue);
	}

	public String getInjuryDescriptionValue() {
		return getText(injuryDescriptionValue);
	}

	public String getSiteOfInjuryFrontValue() {
		return getText(siteOfInjuryFrontValue);
	}

	public String getSiteOfInjuryBackValue() {
		return getText(siteOfInjuryBackValue);
	}

	public String getTreatmentReceivedValue() {
		return getText(treatmentReceivedValue);
	}

	public String getFutureTreatmentValue() {
		return getText(futureTreatmentValue);
	}

	public String getInjuryTypeValue() {
		return getText(injuryTypeValue);
	}

	public String getInjurySeverityValue() {
		return getText(injurySeverityValue);
	}

	public String getEventNotifiStatusValue() {
		return getText(eventNotifiStatusValue);
	}

	public String getPersonNotifiedValue() {
		return getText(personNotifiedValue);
	}

	public String getRelationshipValue() {
		return getText(relationshipValue);
	}

	public String getNotificationDateAndTimeValue() {
		return getText(notificationDateAndTimeValue);
	}

	public String getNotifiedByValue() {
		return getText(notifiedByValue);
	}

	public String getNotificationMethodValue() {
		return getText(notificationMethodValue);
	}

	public String getBreadCrumTxtLinkIncidentReportInViewPage() {
		return getText(breadCrumTxtLinkIncidentReportInViewPage);
	}
	
	public String breadCrumSuiteNameText() {

		waitForPageLoad();
	    String createdIndNameFromExcel = readExcel("Test Datas", "Incident Reports", 1, 28);
		String[] splitFirstNameAlone = createdIndNameFromExcel.split(" ");
		String getFirstName = splitFirstNameAlone[0];
		BC = BC.replaceAll("createdSN", getFirstName);
		String textString = getTextString(BC);
		return textString;
	}
	
	/**
	 * @author Nandhalala.
	 * 
	 * Get text from what caused the fall field.
	 *
	 * return The text data from what caused the fall field.
	 * @created on 24-01-2024.
	 */
	public String getWhatCausedTheFall() {
		return getAttribute(whatCausedTheFallDescriptionTxtBox, "value");
		
	}
	
	/**
	 * @author Nandhalala.
	 * 
	 * Send Chat message.
	 *
	 * 
	 * @created on 25-01-2024.
	 */
	public void sendChatMessage(String chatMessage) {
		
		sendKeys(chatMessageArea, chatMessage);
		click(chatSendButton);
		
	}
	
	/**
	 * @author Nandhalala.
	 * 
	 * Get Chat message.
	 *
	 * 
	 * @created on 25-01-2024.
	 */
	public Map<String, String> getChatMessagesFromUser(String userName) {
		
		chatMessageTextXpath = chatMessageTextXpath.replaceAll("XX", userName);
		List<WebElement> chatElements =  this.driver.findElements(By.xpath(chatMessageTextXpath));
		Map<String,String> chatMessages = new HashMap<String, String>();
		int n = 1;
		for(WebElement chat : chatElements) {
			chatMessages.put(n+" message", chat.getText());
			++n;
		}
		return chatMessages;
	}
	
	/**
	 * @author Nandhalala.
	 * 
	 * Get username of current Login.
	 *
	 * 
	 * @created on 25-01-2024.
	 */
	public String getUserName() {
		return userName.getText().trim();
	}
	
}