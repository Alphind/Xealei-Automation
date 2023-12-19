/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul, on date

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.pages;

import java.util.List;

import org.alphind.xealei.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IncidentReportPage extends BaseClass {

	public IncidentReportPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),' Add New Incident Report ')]/parent::button")
	private WebElement addNewIncidentReportButton;
	
	@FindBy(xpath = "//mat-select[@placeholder='Individual details']")
	private WebElement individualDetailsDropDown;
	
	String selectIndDetails = "//span[text()='chooseIndDetails']/parent::mat-option";
	
	@FindBy(xpath = "//input[@id='dateAndTime']")
	private WebElement eventDateAndTimeCalenderIconButton;
	
	@FindBy(xpath = "//span[text()='Next ']/parent::button")
	private WebElement nextButton;
	
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
	
	private String injuredPatient = "//mat-label[contains(text(),'Was PatientName injured?')]";
	
	@FindBy(xpath = "(//div[text()='Yes'])[1]/preceding-sibling::div/input")
	private WebElement wasPatientInjuredYesRadioButton;
	
	@FindBy(xpath = "(//div[text()='Yes'])[2]/preceding-sibling::div/input")
	private WebElement wasTheEventNotifiedYesRadioButton;
	
	@FindBy(xpath = "//i[@title = 'Click here to delete']")
	private List<WebElement> attachmentDeleteButton;
	
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
	private WebElement injuryTypeErrorText;
	
	@FindBy(xpath = "//mat-error[text() = ' Please select injury color ']")
	private WebElement injuryColorErrorText;
	
	@FindBy(xpath = "//mat-error[text() = ' Please choose was the injury serve ']")
	private WebElement injurySeverityErrorText;
	
	@FindBy(xpath = "//mat-error[text() = ' Please enter person notify ']")
	private WebElement personNotifiedErrorText;
	
	@FindBy(xpath = "//mat-error[text() = ' Please choose relationship  ']")
	private WebElement relationshipErrorText;
	
	@FindBy(xpath = "//mat-error[text() = ' Please choose notify date  ']")
	private WebElement chooseNotifiationDateErrorText;
	
	@FindBy(xpath = "//mat-error[text() = ' Please choose time  ']")
	private WebElement chooseNotifiationtimeErrorText;
	
	@FindBy(xpath = "//mat-error[text() = ' Please enter notified by  ']")
	private WebElement NotifiedByErrorText;
	
	
}
