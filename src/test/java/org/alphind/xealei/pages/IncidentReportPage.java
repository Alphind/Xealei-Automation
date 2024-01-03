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

import org.alphind.xealei.baseclass.BaseClass;
import org.junit.Assert;
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

	
	
	@FindBy(xpath = "//h5[@class='mb-3 page-head']")
	private WebElement incidentReportModuleText;

	@FindBy(xpath = "//span[contains(text(),' Add New Incident Report ')]/parent::button")
	private WebElement addNewIncidentReportButton;
	
	@FindBy(xpath = "//mat-select[@placeholder='Individual details']")
	private WebElement individualDetailsDropDown;
	
	String selectIndDetails = "//span[contains(text(),'chooseIndDetails')]/parent::mat-option";
	
	@FindBy(xpath = "//input[@id='dateAndTime']")
	private WebElement eventDateAndTimeCalenderIconButton;
	
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
	private WebElement frontViewRightShoulderINjury;
	
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
	
	@FindBy(xpath = "//span[contains(text(),'Abrasion')]")
	private WebElement injuryTypeAbrasionButton;
	
	@FindBy(xpath = "//span[contains(text(),'Bleeding')]")
	private WebElement injuryTypeBleedingButton;
	
	@FindBy(xpath = "//span[contains(text(),'Bruise')]")
	private WebElement injuryTypeBruiseButton;
	
	@FindBy(xpath = "//span[contains(text(),'Scratch')]")
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
	
	@FindBy(xpath = "//span[contains(text(),'Phone Call') and @class = 'mat-option-text']")
	private WebElement notificationMethodPhoneCallOption;
	
	@FindBy(xpath = "//span[contains(text(),'Email') and @class = 'mat-option-text']")
	private WebElement notificationMethodEmailOption;
	
	@FindBy(xpath = "//span[contains(text(),'Text Message') and @class = 'mat-option-text']")
	private WebElement notificationMethodTextMessageOption;
	
	@FindBy(xpath = "//a[contains(text(),'Reports')]")
	private WebElement breadCrumTxtLinkReports;
	
	@FindBy(xpath = "//li[contains(text(),'Incident Report')]")
	private WebElement breadCrumTxtLinkIncidentReport;
	
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
	private WebElement backViewRightShoulderINjury;
	
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
	
	@FindBy(xpath = "(//div[@title = 'Left Wrist'])[1]")
	private WebElement backViewLefttWristInjury;
	
	private String injuredIndividiual = "//mat-label[contains(text(),'Was IndividiualName injured?')]";
	
	@FindBy(xpath = "(//div[text()='Yes'])[1]/preceding-sibling::div/input")
	private WebElement wasIndividiualInjuredYesRadioButton;
	
	@FindBy(xpath = "(//div[text()='No'])[1]/preceding-sibling::div/input")
	private WebElement wasIndividiualInjuredNoRadioButton;
	
//	@FindBy(xpath = "(//div[text()='Yes'])[1]/preceding-sibling::div/input")
//	private WebElement wasPatientInjuredYesRadioButton;
	 
	String wasPatientInjured ="//div[contains(text(),'isInjured')]";
	
	
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
	
	@FindBy(xpath = "//span[contains(text(),'Saved Successfully!!')]")
	private WebElement savedSuccessfullToastMsg;
	
	@FindBy(xpath = "//span[contains(text(),'ok')]/parent::button")
	private WebElement btnToastMsgSuccessOk;
	
	@FindBy(xpath = "//span[contains(text(),'OK')]/parent::button")
	private WebElement OKBtnToastMsg;

	@FindBy(xpath = "//span[contains(text(),' View ')]/parent::button")
	private WebElement viewButtonInIndividualGrid;

	@FindBy(xpath = "//div[contains(text(),'Note:')]")
	private WebElement requiredFieldsNOTEInfoMessage;

	@FindBy(xpath = "//span[contains(text(),'File size should be less than 1 MB')]")
	private WebElement imgSizeToastMsg;
	
	@FindBy(xpath = "//mat-radio-group[@formcontrolname='eventNotified']/mat-radio-button[1]")
	private WebElement eventNotifiedDefaultValue;
	
	
	
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
	
	
	

	
	
	
	
	/**
	 * @author Nandhalala.
	 * Enter the data from excel sheet to 'What caused the fall?' text area box.
	 *
	 * 
	 * @created on 22-12-2023.
	 */
	public void enterWhatCausedTheFallData() {
		String WhatCausedTheFall = readExcel("", "", 0, 0).trim();
		sendKeys(whatCausedTheFallDescriptionTxtBox, WhatCausedTheFall);
	}
	
	/**
	 * @author Nandhalala.
	 * Enter the data from excel sheet to 'Injury Description' text area box.
	 *
	 * 
	 * @created on 22-12-2023
	 */
	public void enterInjuryDescriptionData() {
		String injuryDescription = readExcel("", "", 0, 0).trim();
		sendKeys(injuryDescriptionDescriptionTxtBox, injuryDescription);
	}
	
	/**
	 * @author Nandhalala.
	 * Select whether the individual was injured or not.
	 * 
	 * 
	 * @created on 22-10-2023.
	 * 
	 */
	public void selectWasTheIndividiualInjured() {
		String WasIndividiualIInjured = readExcel("", "", 0, 0).trim();
		switch (WasIndividiualIInjured) {
		case "Yes":
			click(wasIndividiualInjuredYesRadioButton);
			break;
			
		case "No":
			click(wasIndividiualInjuredNoRadioButton);
			break;

		}
	}
	
	/**
	 * @author Nandhalala.
	 * Select whether the front view injured site.
	 * 
	 * 
	 * @created on 22-10-2023.
	 * 
	 */
	public void selectFrontViewInjurySite() {
		String [] injuredsites = readExcel("", "", 0, 0).split(",");
		for(String injury : injuredsites) {
			String injurysite = injury.trim();
			switch(injurysite) {
			case "Fore Head":
				click(frontViewForeHeadInjury);
				break;
				
			case "Face":
				click(frontViewFaceInjury);
				break;
				
			case "Right Shoulder":
				click(frontViewRightShoulderINjury);
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
	 * @author Nandhalala.
	 * Select whether the front view injured site.
	 * 
	 * 
	 * @created on 22-10-2023.
	 * 
	 */
	public void selectBackViewInjurySite() {
		String [] injuredsites = readExcel("", "", 0, 0).split(",");
		for(String injury : injuredsites) {
			String injurysite = injury.trim();
			switch(injurysite) {
			case "Head":
				click(frontViewForeHeadInjury);
				break;
				
			case "Right Shoulder":
				click(frontViewRightShoulderINjury);
				break;
				
			case "Left Shoulder":
				click(frontViewLeftShoulderInjury);
				break;
				
			case "Back":
				click(frontViewChestInjury);
				break;
				
			case "Hip":
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
	 * @author Nandhalala.
	 * Enter the data from excel sheet to 'Treatment Received' text area box.
	 *
	 * 
	 * @created on 22-12-2023.
	 */
	public void enterTreatmentReceivedData() {
		String treatmentreceived = readExcel("", "", 0, 0).trim();
		sendKeys(injuryDescriptionDescriptionTxtBox, treatmentreceived);
	}
	
	/**
	 * @author Nandhalala.
	 * Enter the data from excel sheet to 'Future Treatment' text area box.
	 *
	 * 
	 * @created on 22-12-2023
	 */
	public void enterFutureTreatmentData() {
		String futuretreatment = readExcel("", "", 0, 0).trim();
		sendKeys(injuryDescriptionDescriptionTxtBox, futuretreatment);
	}
	
	/**
	 * @author Nandhalala.
	 * Select the front view injured type.
	 * 
	 * 
	 * @created on 22-10-2023.
	 */
	public void selectInjuryType() {
		String [] injuryType = readExcel("", "", 0, 0).split(",");
		for(String injurytype: injuryType) {
			switch(injurytype) {
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
	 * @author Nandhalala.
	 * Select the Injury Color.
	 * 
	 * @created on 22-12-2023.
	 */
	public void selectInjuryColor() {
		String injuryColor = readExcel("", "", 0, 0).trim();
		switch(injuryColor) {
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
	 * @author Nandhalala.
	 * Select the Injury Severity.
	 * 
	 * @created on 22-12-2023.
	 */
	public void selectHowSevereWasTheInjury() {
		String injurySeverity = readExcel("", "", 0, 0).trim();
		switch(injurySeverity) {
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
	 * @author Nandhalala.
	 * Enter the data from excel sheet to 'Person Notified' text area box.
	 *
	 * 
	 * @created on 22-12-2023
	 */
	public void enterPersonNotifiedData() {
		String personnotified = readExcel("", "", 0, 0).trim();
		sendKeys(injuryDescriptionDescriptionTxtBox, personnotified);
	}
	
	/**
	 * @author Nandhalala.
	 * Enter the data from excel sheet to 'Notified By' text area box.
	 *
	 * 
	 * @created on 22-12-2023
	 */
	public void enterNotifiedByData() {
		String notifiedby = readExcel("", "", 0, 0).trim();
		sendKeys(injuryDescriptionDescriptionTxtBox, notifiedby);
	}
	
	/**
	 * @author Nandhalala.
	 * Select the Relationship.
	 * 
	 * @created on 22-12-2023.
	 */
	public void selectReletionship() {
		String relationship = readExcel("", "", 0, 0).trim();
		click(relationshipDropdown);
		switch(relationship) {
		case "Guardian":
			click(relationshipGuardianOption);
			break;
			
		case "Other":
			click(relationshipOtherOption);
			break;

		}
	}
	
	/**
	 * @author Nandhalala.
	 * Select the Notification Method.
	 * 
	 * @created on 22-12-2023.
	 */
	public void selectNotificationMethod() {
		String relationship = readExcel("", "", 0, 0).trim();
		click(notificationMethodDropdownBox);
		switch(relationship) {
		case "Phone Call":
			click(notificationMethodPhoneCallOption);
			break;
			
		case "Email":
			click(notificationMethodEmailOption);
			break;
			
		case "Text Message":
			click(notificationMethodTextMessageOption );
			break;

		}
	}
	
	public void addNewIncidentReportButton() {
			
		waitForPageLoad();
		
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
	
	public void selectIndividualDetailsDropdown(){
		
		click(individualDetailsDropDown);
		
		selectIndDetails = selectIndDetails.replaceAll("chooseIndDetails", "Arlia  Thomas(SUITE B)");
		select(selectIndDetails);
	}
	
	public void radioBtnYes() {
		
		

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
	
public void injuryDescription() {
		
	sendKeys(injuryDescriptionDescriptionTxtBox, "Twisted Ankle"+randomName());
	String attribute = getAttribute(injuryDescriptionDescriptionTxtBox, "value");
	writeExcelToOverwrite("Test Datas", "Incident Reports", 0, 18, attribute);
}

public void savedSuccessfulToastMsgokButton() {

	click(btnToastMsgSuccessOk);
}

public void ToastMsgOKButton() {
	
	click(OKBtnToastMsg);
}

public void viewButton() {
	
	click(viewButtonInIndividualGrid);
	waitForPageLoad();
}

public void editButton() {
	
	click(viewButtonInIndividualGrid);
	waitForPageLoad();
}

public void eventDateAndTime(int rowNum) {
	
		String eventDateAndTime = "05/12/202311:59AM";		
		sendKeys(eventDateAndTimeCalenderIconButton, eventDateAndTime);
	}
	
public void moreThan1MBImgFormatUpload(String fileName, String formatType) {

	if (getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("NO")
			&& getConfigureProperty("IncidentReportFileUpload").equalsIgnoreCase("Yes")) {
		
		click(attachmentIconButton);
		sleep(2000);
		
		String ImagePath = System.getProperty("user.dir") + "\\Individuals File Upload\\" + fileName + "." + formatType;
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
						"File size should be less than 1 MB", getText(getImgSizeToastMsg()));
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

public void Upload(String fileName, String formatType) {

	if (getConfigureProperty("IncidentReportFileUpload").equalsIgnoreCase("Yes")
			&& getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("NO")) {

		click(attachmentIconButton);
		sleep(2000);
		
		String ImagePath = System.getProperty("user.dir") + "\\Individuals File Upload\\" + fileName + "." + formatType;
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

		} catch (AWTException e) {
			e.printStackTrace();
		}
	} else if (getConfigureProperty("IncidentReportFileUpload").equalsIgnoreCase("No")
			|| getConfigureProperty("IncidentReportFileUpload").equalsIgnoreCase("Yes")
					&& getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("Yes")) {
		log(Status.INFO, "Skip Image Uploaded in Photo tab section due to Headless Run");
		
	} else {
		log(Status.INFO, "Enter invalid VALUE format in Config.property file");
	}
}

public void deleteTheUploadedFile() {

if (getConfigureProperty("IncidentReportFileUpload").equalsIgnoreCase("Yes")
		&& getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("NO")) {
	
		click(attachmentDeleteButton);
}
}


public void selectMultipleOptionInjuryType() {
	
			click(injuryTypeAbrasionButton);
			click(injuryTypeBleedingButton);
			click(injuryTypeBruiseButton);
			click(injuryTypeScratchButton);
	
	}

public void selectOptionHowSevereWasTheInjury() {

		click(injurySeverityLight);
		click(injurySeverityMedium);
		click(injurySeverityHigh);
}
	

public void selectInjuryColorOption() {

		click(injuryColorGreen);
		click(injuryColorRed);
		click(injuryColorBlack);
		click(injuryColorBrown);
}


public void gridStatusVerify() {
	
	WebElement individualsGrid2 = individualsGrid;
	
		
	}
	


}


