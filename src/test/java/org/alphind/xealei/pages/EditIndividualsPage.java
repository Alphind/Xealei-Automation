/** Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul

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

public class EditIndividualsPage extends BaseClass {

	public EditIndividualsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//img[@class='arrow-right']")
	private WebElement arrowRight;

	@FindBy(xpath = "//div[@class='profile-name mb-1']")
	private WebElement createdIndName;

	@FindBy(xpath = "//div[@x-et-v-fml01]")
	private WebElement createdIndNameInEditPage;

	@FindBy(xpath = "//span[@x-ind-dob-val]")
	private WebElement createdDOB;

	@FindBy(xpath = "//span[@x-ind-id-val]")
	private WebElement createdID;

	@FindBy(xpath = "//span[@x-ind-emrcon-fn-mn-ln]")
	private WebElement createdGuardianName;

	@FindBy(xpath = "//span[@x-ind-emrcon-pn]")
	private WebElement createdPhNum;

	@FindBy(xpath = "//ol[@class='breadcrumb']")
	private WebElement breadCrumLink;

	@FindBy(xpath = "//li[@class='breadcrumb-item']")
	private WebElement individualBreadCrumLink;

	@FindBy(xpath = "//h5[@x-page='Individuals']")
	private WebElement searchedIndividualsText;

	String BC = "//span[text()='createdSN']/parent::li/parent::ol";

	@FindBy(xpath = "//a[@x-et-v-ovc][@data-toggle='tab']")
	private WebElement personalTab;

	@FindBy(xpath = "//a[@x-et-v-ovc01][@data-toggle='tab']")
	private WebElement vitalsTab;

	@FindBy(xpath = "//button[@x-et-v-arb]")
	private WebElement editIndividualBtn;

	@FindBy(xpath = "//li[@x-ei-lbl]")
	private WebElement breadCrumTextEditIndividual;

	@FindBy(xpath = "//button[@x-et-cl]")
	private WebElement editIndCancelBtn;

	@FindBy(xpath = "//button[@x-et-ue]")
	private WebElement updateBtn;

	@FindBy(xpath = "//mat-select[@ng-reflect-name='gender']")
	private WebElement gender;

	String genderSelection = "//span[text()='choosegender']/parent::mat-option";

	@FindBy(xpath = "//mat-select[@ng-reflect-name='title']")
	private WebElement title;

	String Title = "//span[text()='selectTitle']/parent::mat-option";

	String unselectGender = "//span[text()='Select gender']/parent::mat-option";

	String unselectSuite = "//span[text()='Select suite number']/parent::mat-option";

	String relationship = "//span[text()='selectRelationship']/parent::mat-option";

	@FindBy(xpath = "//mat-select[@ng-reflect-name='relationship']")
	private WebElement EC1Relationship;

	@FindBy(xpath = "(//mat-select[@ng-reflect-name='relationship'])[2]")
	private WebElement EC2Relationship;

	String unselectRelationship = "//span[text()='Select Relationship']/parent::mat-option";

	String selectExistSuite = "//span[text()='existSuiteName ']/parent::mat-option";
	String selectECRelationship = "//span[text()='ECRelationship ']/parent::mat-option";

	@FindBy(xpath = "//mat-select[@ng-reflect-name='suiteId']")
	private WebElement selectedSuite;

	@FindBy(xpath = "//input[@x-et-fn-val]")
	private WebElement editFNField;

	@FindBy(xpath = "//input[@x-et-sufx-val]")
	private WebElement editSuffixField;

	@FindBy(xpath = "//mat-select[@ng-reflect-name='race']")
	private WebElement selectRace;

	String race = "//span[text()='selectRace']/parent::mat-option";

	@FindBy(xpath = "//mat-select[@ng-reflect-name='maritalStatus']")
	private WebElement maritalStatus;

	String maritalSts = "//span[text()='Mstatus']/parent::mat-option";

	@FindBy(xpath = "//input[@x-et-nn-val]")
	private WebElement editNickNameField;

	String Pronoun = "//span[text()='selectPronoun']/parent::mat-option";

	@FindBy(xpath = "//mat-select[@ng-reflect-name='pronoun']")
	private WebElement selectPronoun;

	String EthnicAffiliation = "//span[text()='selectEthnicAffiliation']/parent::mat-option";

	@FindBy(xpath = "//mat-select[@ng-reflect-name='ethnicAffiliation']")
	private WebElement selectEthnicAffiliation;

	String PreferredLanguage = "//span[text()='selectPreferredLanguage']/parent::mat-option";

	@FindBy(xpath = "//mat-select[@ng-reflect-name='preferredLanguage']")
	private WebElement selectPreferredLanguage;

	String Religion = "//span[text()='selectReligion']/parent::mat-option";

	@FindBy(xpath = "//mat-select[@ng-reflect-name='religion']")
	private WebElement selectReligion;

	@FindBy(xpath = "//input[@x-et-mn-val]")
	private WebElement editMNField;

	@FindBy(xpath = "//input[@x-et-ln-val]")
	private WebElement editLNField;

	@FindBy(xpath = "//input[@x-et-dob-val]")
	private WebElement editDOBField;

	@FindBy(xpath = "//textarea[@ng-reflect-name='residentialAddress']")
	private WebElement editResidentialAddressField;

	@FindBy(xpath = "//textarea[@ng-reflect-name='mailingAddress']")
	private WebElement editMailingAddressField;

	@FindBy(xpath = "(//div[contains(text(),'Contact 1 ')]/following::input[@ng-reflect-name='firstName'])[1]")
	private WebElement editEC1FNField;

	@FindBy(xpath = "(//div[contains(text(),'Contact 1 ')]/following::input[@ng-reflect-name='lastName'])[1]")
	private WebElement editEC1LNField;

	@FindBy(xpath = "(//div[contains(text(),'Contact 1 ')]/following::input[@ng-reflect-name='phoneNumber'])[1]")
	private WebElement editEC1PhNumField;

	@FindBy(xpath = "(//div[contains(text(),'Contact 1 ')]/following::input[@ng-reflect-name='firstName'])[2]")
	private WebElement editEC2FNField;

	@FindBy(xpath = "(//div[contains(text(),'Contact 1 ')]/following::input[@ng-reflect-name='lastName'])[2]")
	private WebElement editEC2LNField;

	@FindBy(xpath = "(//div[contains(text(),'Contact 1 ')]/following::input[@ng-reflect-name='phoneNumber'])[2]")
	private WebElement editEC2PhNumField;

	@FindBy(xpath = "(//div[contains(text(),'Contact 1 ')]/following::input[@ng-reflect-name='firstName'])[3]")
	private WebElement editEC3FNField;

	@FindBy(xpath = "(//div[contains(text(),'Contact 1 ')]/following::input[@ng-reflect-name='lastName'])[3]")
	private WebElement editEC3LNField;

	@FindBy(xpath = "//button[@x-et-ue]")
	private WebElement btnUpdate;

	@FindBy(xpath = "//button[@x-et-edit-update]")
	private WebElement btnVitalsUpdate;

	@FindBy(xpath = "//button[@x-et-edit-cancel]")
	private WebElement btnVitalsCancel;

	@FindBy(xpath = "//span[@x-et-ficli]")
	private WebElement btnBrowser;

	@FindBy(xpath = "//div[@id='x-et-emrcon-lbl0']")
	private WebElement emergencyContact1LabelName;

	@FindBy(xpath = "//div[@id='x-et-emrcon-lbl1']")
	private WebElement emergencyContact2LabelName;

	@FindBy(xpath = "//div[@id='x-et-emrcon-lbl2']")
	private WebElement emergencyContact3LabelName;

	@FindBy(xpath = "//i[@id='x-et-del1']")
	private WebElement EC2CloseBtn;

	@FindBy(xpath = "//i[@id='x-et-del2']")
	private WebElement EC3CloseBtn;

	@FindBy(xpath = "//button[@x-et-cl]")
	private WebElement cancelEditButton;

	@FindBy(xpath = "//button[@x-et-v-arb]")
	private WebElement addVitalsButton;

	@FindBy(xpath = "//span[contains(text(),' Please select Blood Group ')]")
	private WebElement validationInfoMsgForBGField;

	@FindBy(xpath = "//span[contains(text(),' Please enter blood pressure ')]")
	private WebElement validationInfoMsgForBPField;

	@FindBy(xpath = "//span[contains(text(),' Please enter blood glucose ')]")
	private WebElement validationInfoMsgForBGlucoseField;

	@FindBy(xpath = "//span[contains(text(),' Please enter cholesterol ')]")
	private WebElement validationInfoMsgForCholestrolField;

	@FindBy(xpath = "//span[contains(text(),' Please enter height ')]")
	private WebElement validationInfoMsgForHeightField;

	@FindBy(xpath = "//span[contains(text(),' Please enter weight ')]")
	private WebElement validationInfoMsgForWeightField;

	@FindBy(xpath = "//span[contains(text(),' Please enter bmi ')]")
	private WebElement validationInfoMsgForBMIField;

	String selectBG = "//span[text()='selectBGroup']/parent::mat-option";

	@FindBy(xpath = "//mat-select[@ng-reflect-name='bloodGroup']")
	private WebElement bloodGroup;

	@FindBy(xpath = "//span[text()='Select blood group']/parent::mat-option")
	private WebElement unSelectbloodGroup;

	@FindBy(xpath = "//input[@x-et-vi-bp-val]")
	private WebElement bloodPressureField;

	@FindBy(xpath = "//input[@x-et-vi-bgl-val]")
	private WebElement bloodGlucoseField;

	@FindBy(xpath = "//input[@x-et-cho-val]")
	private WebElement cholestrolField;

	@FindBy(xpath = "//input[@x-et-hei-val]")
	private WebElement heightField;

	@FindBy(xpath = "//input[@x-et-wei-val]")
	private WebElement weightField;

	@FindBy(xpath = "//textarea[@x-et-hlsu-val]")
	private WebElement healthSummaryField;

	@FindBy(xpath = "//span[contains(text(),' Blood pressure format should be (120/80) ')]")
	private WebElement formatValidationInfoMsgForBPField;

	@FindBy(xpath = "//span[contains(text(),' Please enter valid blood glucose ')]")
	private WebElement formatValidationInfoMsgForBGlucoseField;

	@FindBy(xpath = "//span[contains(text(),' Please enter valid cholesterol ')]")
	private WebElement formatValidationInfoMsgForCholestrolField;

	@FindBy(xpath = "//span[contains(text(),' Please enter valid height ')]")
	private WebElement formatValidationInfoMsgForHeightField;

	@FindBy(xpath = "//span[contains(text(),' Please enter valid weight ')]")
	private WebElement formatValidationInfoMsgForWeightField;

	@FindBy(xpath = "(//a[@x-et-afp-a])[1]")
	private WebElement medicalRecordFile;

	@FindBy(xpath = "(//a[@x-et-afp-a])[2]")
	private WebElement medicalRecordFile2;

	@FindBy(xpath = "(//a[@x-et-remove-1])[1]")
	private WebElement cancelUploadedFile;

	@FindBy(xpath = "//span[text()='OK']/parent::button")
	private WebElement toastMsgOkBtn;

	@FindBy(xpath = "//span[contains(text(),'File size should be less than 1 MB')]")
	private WebElement imgSizeToastMsg;

	@FindBy(xpath = "//span[contains(text(),'Individual personal info updated successfully')]")
	private WebElement indUpdatedSuccessfullyToastMsg;

	@FindBy(xpath = "//a[@x-et-afp-a]")
	private WebElement downloadMRFile;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement individualSearchBox;

	public WebElement getIndividualSearchBox() {
		return individualSearchBox;
	}

	public WebElement getEditIndCancelBtn() {
		return editIndCancelBtn;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}

	public WebElement getEditIndividualBtn() {
		return editIndividualBtn;
	}

	public WebElement getBreadCrumTextEditIndividual() {
		return breadCrumTextEditIndividual;
	}

	public WebElement getPersonalTab() {
		return personalTab;
	}

	public WebElement getVitalsTab() {
		return vitalsTab;
	}

	public WebElement getBreadCrumLink() {
		return breadCrumLink;
	}

	public WebElement getCreatedIndName() {
		return createdIndName;
	}

	public WebElement getCreatedDOB() {
		return createdDOB;
	}

	public WebElement getCreatedID() {
		return createdID;
	}

	public WebElement getCreatedGuardianName() {
		return createdGuardianName;
	}

	public WebElement getCreatedPhNum() {
		return createdPhNum;
	}

	public WebElement getEditFNField() {
		return editFNField;
	}

	public WebElement getEditLNField() {
		return editLNField;
	}

	public WebElement getEditDOBField() {
		return editDOBField;
	}

	public WebElement getEditResidentialAddressField() {
		return editResidentialAddressField;
	}

	public WebElement getEditMailingAddressField() {
		return editMailingAddressField;
	}

	public WebElement getEditECFNField() {
		return editEC1FNField;
	}

	public WebElement getEditMNField() {
		return editMNField;
	}

	public WebElement getEditECLNField() {
		return editEC1LNField;
	}

	public WebElement getEditECPhNumField() {
		return editEC1PhNumField;
	}

	public WebElement getEmergencyContact1LabelName() {
		return emergencyContact1LabelName;
	}

	public WebElement getEmergencyContact2LabelName() {
		return emergencyContact2LabelName;
	}

	public WebElement getEmergencyContact3LabelName() {
		return emergencyContact3LabelName;
	}

	public WebElement getSearchedIndividualsText() {
		return searchedIndividualsText;
	}

	public WebElement getValidationInfoMsgForBGField() {
		return validationInfoMsgForBGField;
	}

	public WebElement getValidationInfoMsgForBPField() {
		return validationInfoMsgForBPField;
	}

	public WebElement getValidationInfoMsgForBGlucoseField() {
		return validationInfoMsgForBGlucoseField;
	}

	public WebElement getValidationInfoMsgForCholestrolField() {
		return validationInfoMsgForCholestrolField;
	}

	public WebElement getValidationInfoMsgForHeightField() {
		return validationInfoMsgForHeightField;
	}

	public WebElement getValidationInfoMsgForWeightField() {
		return validationInfoMsgForWeightField;
	}

	public WebElement getValidationInfoMsgForBMIField() {
		return validationInfoMsgForBMIField;
	}

	public WebElement getFormatValidationInfoMsgForBPField() {
		return formatValidationInfoMsgForBPField;
	}

	public WebElement getFormatValidationInfoMsgForBGlucoseField() {
		return formatValidationInfoMsgForBGlucoseField;
	}

	public WebElement getFormatValidationInfoMsgForCholestrolField() {
		return formatValidationInfoMsgForCholestrolField;
	}

	public WebElement getFormatValidationInfoMsgForHeightField() {
		return formatValidationInfoMsgForHeightField;
	}

	public WebElement getFormatValidationInfoMsgForWeightField() {
		return formatValidationInfoMsgForWeightField;
	}

	public WebElement getMedicalRecordFile() {
		return medicalRecordFile;
	}

	public WebElement getImgSizeToastMsg() {
		return imgSizeToastMsg;
	}

	public WebElement getToastMsgOkBtn() {
		return toastMsgOkBtn;
	}

	public WebElement getBloodPressureField() {
		return bloodPressureField;
	}

	public WebElement getBloodGlucoseField() {
		return bloodGlucoseField;
	}

	public WebElement getCholestrolField() {
		return cholestrolField;
	}

	public WebElement getHeightField() {
		return heightField;
	}

	public WebElement getWeightField() {
		return weightField;
	}

	public WebElement getIndUpdatedSuccessfullyToastMsg() {
		return indUpdatedSuccessfullyToastMsg;
	}

	/**
	 * Retrieves the text content from created ind.. element.
	 *
	 * @return The text content from created ind.. in edit individual page
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public String getCreatedIndNameTextInEditPage() {
		return getText(createdIndNameInEditPage);
	}

	/**
	 * Click on 'Personal Info..' tab section.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void navigateToPersonalInformationTab() {

		click(personalTab);
		waitForFullPageElementLoad();
	}

	/**
	 * To enter created individual data in search box based on the data from the
	 * specified row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data from excel.
	 * @throws Exception If an error occurs during this operation.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void searchBox() throws Exception {

		deleteExistFieldData(individualSearchBox);

		String crIndividualLastName = readExcelFromLastRow("Test Datas", "CreatedIndividuals", 1);
		String[] split = crIndividualLastName.split("-");
		String firstName = split[0];
		String MiddleName = split[1];

		System.out.println("FN - " + firstName);

		System.out.println("MN - " + MiddleName);

		sendKeys(individualSearchBox, firstName + "-");
		waitForAjexPageLoad();

		for (int i = 0; i < MiddleName.length(); i++) {
			char letter = MiddleName.charAt(i);
			String letterAsString = String.valueOf(letter);
			sendKeys(individualSearchBox, letterAsString);
			waitForPageLoad();
		}
		backSpace(individualSearchBox);
		waitForPageLoad();
		waitForFullPageElementLoad();
		sleep(5000);
		int length = MiddleName.length();
		char lastLetter = MiddleName.charAt(length - 1);
		String enterLastLetter = String.valueOf(lastLetter);
		sendKeys(individualSearchBox, enterLastLetter);
		waitForPageLoad();
		waitForFullPageElementLoad();

		String actSearchedInd = getText(getCreatedIndName());

		System.out.println("Actua Searched Ind - " + actSearchedInd);
		System.out.println("Exp Searched Ind - " + crIndividualLastName);

		if (actSearchedInd.equals(crIndividualLastName)) {
			log(Status.PASS, "Searched Individual is displayed");

		} else {
			log(Status.FAIL, "Searched Individual is NOT displayed");
			throw new Exception("Assertion failed searched Individual is not displayed as expected");
		}

	}

//	public void searchBox() throws Exception{
//
//		deleteExistFieldData(individualSearchBox);
//		
//		String crIndividualLastName = readExcelFromLastRow("Test Datas", "CreatedIndividuals", 1);
//		String[] split = crIndividualLastName.split(" ");
//		String firstName = split[0];
//		String MiddleName = split[1];
//		String LastName = " "+split[2];
//		
//		System.out.println("FN - "+firstName);
//
//		System.out.println("MN - "+MiddleName);
//		System.out.println("LN - "+LastName);
//		
//		sendKeys(individualSearchBox, firstName+" "+MiddleName);
//			waitForAjexPageLoad();
//			
//			for (int i = 0; i < LastName.length(); i++) {
//				char letter = LastName.charAt(i);
//				String letterAsString = String.valueOf(letter);
//				sendKeys(individualSearchBox, letterAsString);
//				waitForPageLoad();
//			}
//			backSpace(individualSearchBox);
//			waitForPageLoad();
//			waitForFullPageElementLoad();
//			sleep(5000);
//			int length = LastName.length();
//			char lastLetter = LastName.charAt(length - 1);
//			String enterLastLetter = String.valueOf(lastLetter);
//			sendKeys(individualSearchBox, enterLastLetter);
//			waitForPageLoad();
//			waitForFullPageElementLoad();
//			
//			String actSearchedInd = getText(getCreatedIndName());
//			
//			System.out.println("Actua Searched Ind - "+actSearchedInd);
//			System.out.println("Exp Searched Ind - "+crIndividualLastName);
//			
//			if (actSearchedInd.equals(crIndividualLastName)) {
//				log(Status.PASS, "Searched Individual is displayed");
//				
//			} else {
//				log(Status.FAIL, "Searched Individual is NOT displayed");
//				throw new Exception("Assertion failed searched Individual is not displayed as expected");
//			}
//			
//	}

//	public void searchBox(){
//
//		String crIndividualLastName = readExcelFromLastRow("Test Datas", "CreatedIndividuals", 1);
//		for (int i = 0; i < crIndividualLastName.length(); i++) {
//			char letter = crIndividualLastName.charAt(i);
//			String letterAsString = String.valueOf(letter);
//			sendKeys(individualSearchBox, letterAsString);
//		}
//		}

	/**
	 * Click on Download File
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void downloadMRUploadedFile() {

		waitForFullPageElementLoad();

		click(downloadMRFile);
	}

	/**
	 * Click on > arrow in individual view page.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void arrowRight() {

		waitForFullPageElementLoad();
		click(arrowRight);
	}

	/**
	 * Click on 'Vitals' Tab.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage vitalsTab() {

		click(vitalsTab);
		return this;
	}

	/**
	 * Click on 'x' icon to close Emergency Contact2.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage ec2closeButton() {

		click(EC2CloseBtn);
		return this;
	}

	/**
	 * Click on 'x' icon to close Emergency Contact3.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage ec3closeButton() {

		click(EC3CloseBtn);
		return this;
	}

	/**
	 * Click on 'Edit' button in Individuals page.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void EditButton() {

		click(editIndividualBtn);
	}

	/**
	 * Click on individual 'Bread crum' link text.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void individualBCTextLink() {

		click(individualBreadCrumLink);
	}

	/**
	 * Click on 'Cancel' button in vitals tab.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void vitalsCancelButton() {

		click(btnVitalsCancel);
	}

	/**
	 * Retrieves the individual breadcrum text.
	 *
	 * @return The text individual BC.
	 */
	public String createdIndNameText() {

		String createdInd = readExcelFromLastRow("Test Datas", "CreatedIndividuals", 1);
		BC = BC.replaceAll("createdSN", createdInd);
		String textString = getTextString(BC);
		return textString;
	}

	/**
	 * Unselect the selected suite data.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void unSelectSuite() {

		click(selectedSuite);
		select(unselectSuite);
	}

	/**
	 * Unselect the Gender data.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void unSelectGender() {

		click(gender);
		select(unselectGender);
	}

	/**
	 * Unselect the EC1 Relationship dropdown data.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void unSelectEC1Relationship() {

		click(EC1Relationship);
		select(unselectRelationship);
	}

	/**
	 * Unselect the EC2 Relationship dropdown data.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void unSelectEC2Relationship() {

		click(EC2Relationship);
		select(unselectRelationship);
	}

	/**
	 * Click on 'Update' button in edit individuals page.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void updateIndividual() {

		click(btnUpdate);

	}

	/**
	 * To enter max characters in First Name field.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage firstName() {

		sendKeys(editFNField, "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567");
		return this;
	}

	/**
	 * To enter max characters in Middle Name field.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage middleName() {

		sendKeys(editMNField, "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567");
		return this;
	}

	/**
	 * To enter max characters in Last Name field.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage lastName() {

		sendKeys(editLNField, "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567");
		return this;
	}

	/**
	 * To enter max characters in emergency contact1 First Name field.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage ec1FirstName() {

		sendKeys(editEC1FNField, "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567");
		return this;
	}

	/**
	 * To enter max characters in emergency contact1 Last Name field.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage ec1LastName() {

		sendKeys(editEC1LNField, "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567");
		return this;
	}

	/**
	 * To enter max characters in emergency contact2 First Name field.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage ec2FirstName() {

		sendKeys(editEC2FNField, "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567");
		return this;
	}

	/**
	 * To enter max characters in emergency contact2 Last Name field.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage ec2LastName() {

		sendKeys(editEC2LNField, "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567");
		return this;
	}

	/**
	 * To enter max characters in emergency contact3 First Name field.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage ec3FirstName() {

		sendKeys(editEC3FNField, "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567");
		return this;
	}

	/**
	 * To enter max characters in emergency contact3 Last Name field.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage ec3LastName() {

		sendKeys(editEC3LNField, "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567");
		return this;
	}

	/**
	 * Click on 'Cancel' button
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void cancelButton() {

		click(cancelEditButton);
	}

	/**
	 * To enter(update) the valid data in Blood Pressure* field based on the data
	 * from the specified row number in the Excel sheet.
	 * 
	 * @author Alphi-MohamedRazul
	 * @param rowNum The row number from which to read the data.
	 */
	public EditIndividualsPage bloodPressure(int rowNum, int cellNum) {

		sendKeys(bloodPressureField, readExcel("Test Datas", "EditVitals", rowNum, cellNum));
		return this;
	}

	/**
	 * To enter(update) the valid data in Blood Glucose* field based on the data
	 * from the specified row number in the Excel sheet..
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage bloodGlucose(int rowNum, int cellNum) {

		sendKeys(bloodGlucoseField, readExcel("Test Datas", "EditVitals", rowNum, cellNum));
		return this;
	}

	/**
	 * To enter(update) the valid data in Cholestrol* field based on the data from
	 * the specified row number in the Excel sheet..
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage cholesterol(int rowNum, int cellNum) {

		sendKeys(cholestrolField, readExcel("Test Datas", "EditVitals", rowNum, cellNum));
		return this;
	}

	/**
	 * To enter(update) the valid data in Height* field based on the data from the
	 * specified row number in the Excel sheet..
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage height(int rowNum, int cellNum) {

		sendKeys(heightField, readExcel("Test Datas", "EditVitals", rowNum, cellNum));
		return this;
	}

	/**
	 * To enter(update) the valid data in Weight* field based on the data from the
	 * specified row number in the Excel sheet..
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage weight(int rowNum, int cellNum) {

		sendKeys(weightField, readExcel("Test Datas", "EditVitals", rowNum, cellNum));
		return this;
	}

	/**
	 * To enter(update) the valid data in health Summary* field based on the data
	 * from the specified row number in the Excel sheet..
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage healthSummary(int rowNum, int cellNum) {

		sendKeys(healthSummaryField, readExcel("Test Datas", "EditVitals", rowNum, cellNum));
		return this;
	}

	/**
	 * Click on Cancel 'x' button to cancel upload file.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void cancelUploadedFile() {

		click(cancelUploadedFile);
	}

	/**
	 * Click on Toast button 'OK' button.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void toastMsgOKButton() {
		click(toastMsgOkBtn);
	}

	/**
	 * Select(update) more than 1MB file format and verifies whether the toast
	 * message is displayed or not.
	 * 
	 * @param fileName   The name of the file name to upload.
	 * @param formatType The type of file (i.e: .jfif, .gif, etc)
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void moreThan1MBImgFormatUpload(String fileName, String formatType) {

		if (getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("NO")
				&& getConfigureProperty("MedicalRecordFileUpload").equalsIgnoreCase("Yes")) {

			click(btnBrowser);
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

				log(Status.PASS, "More than 1MB File NOT Supported in Medical Record");

				try {
					Assert.assertEquals("File size should be less than 1 MB Toast msg is Not Displayed as expected",
							"File size should be less than 1 MB", getText(getImgSizeToastMsg()));
					log(Status.PASS, "File size should be less than 1 MB Toast msg is displayed successfully - "
							+ getText(getImgSizeToastMsg()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}

				toastMsgOKButton();

			} catch (AWTException e) {
				e.printStackTrace();
			}

		} else if (getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("YES")
				&& getConfigureProperty("MedicalRecordFileUpload").equalsIgnoreCase("YES")
				|| getConfigureProperty("MedicalRecordFileUpload").equalsIgnoreCase("NO")) {
			log(Status.INFO, "MoreThan1MBFile Img Format scenario is SKIPPED due to Headless Run");
		} else {
			log(Status.INFO, "Enter invalid VALUE format in Config.property file");
		}
	}

	/**
	 * Select the Supported image/file format and verifies whether the toast message
	 * is displayed or not.
	 * 
	 * @param fileName   The name of the file name to upload.
	 * @param formatType The type of file (i.e: .jpg, .png, etc)
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void Upload(String fileName, String formatType) {

		if (getConfigureProperty("MedicalRecordFileUpload").equalsIgnoreCase("Yes")
				&& getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("NO")) {

			click(btnBrowser);
			sleep(3000);

			String MRFilePath = System.getProperty("user.dir") + "\\Individuals File Upload\\" + fileName + "."
					+ formatType;
			try {
				Robot robot = new Robot();

				// Copy the file path to the clipboard
				StringSelection stringSelection = new StringSelection(MRFilePath);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

				// Simulate pressing Ctrl+V to paste the file path
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);

				// Simulate pressing Enter to confirm the file selection
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);

			} catch (Exception e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}

			waitForPageLoad();
			waitForFullPageElementLoad();

			String fileUpload = getAttribute(medicalRecordFile, "href");

			try {

				Assert.assertFalse("File NOT Uploaded", fileUpload.isEmpty());
				log(Status.PASS, "File uploaded in Medical Record successfully");

			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}

		} else if (getConfigureProperty("MedicalRecordFileUpload").equalsIgnoreCase("No")
				|| getConfigureProperty("MedicalRecordFileUpload").equalsIgnoreCase("Yes")
						&& getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("Yes")) {

			log(Status.INFO, "SKIPPED Medical Record File Upload due to Headless Run");

		} else {
			log(Status.INFO, "Enter invalid VALUE format in Config.property file");
		}

		if (getConfigureProperty("MedicalRecordFileDownload").equalsIgnoreCase("Yes")
				&& getConfigureProperty("MedicalRecordFileUpload").equalsIgnoreCase("Yes")
				&& getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("No")) {

			downloadMRUploadedFile();
			log(Status.INFO, "FILE downloaded kindly verify your local machine");

		} else {
			log(Status.INFO, "SKIPPED Medical Record File Download due to Headless Run ");
		}
	}

	/**
	 * Click on Blood Group dropdown to unselect.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void unSelectBloodGroup() {

		click(bloodGroup);
		click(unSelectbloodGroup);
	}

	/**
	 * Click and select(update) blood group dropdown based on the data from the
	 * specified row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public EditIndividualsPage selectBloodGroup(int rowNum) {

		click(bloodGroup);
		String BG = readExcel("Test Datas", "EditVitals", rowNum, 0);
		selectBG = selectBG.replaceAll("selectBGroup", BG);
		select(selectBG);
		return this;
	}

	/**
	 * Click on 'Update' button in vitals tab.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void vitalsUpdateButton() {

		click(btnVitalsUpdate);

	}

	/**
	 * Click on 'Add Vitals' button.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage addVitalsButton() {

		click(addVitalsButton);
		return this;
	}

	/**
	 * Select the Supported image/file format and verifies whether the toast message
	 * is displayed or not.
	 * 
	 * @param fileName   The name of the file name to upload.
	 * @param formatType The type of file (i.e: .jpg, .png, etc)
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void uploadForEditVitalsTab(String fileName, String formatType) {

		if (getConfigureProperty("MedicalRecordFileUpload").equalsIgnoreCase("Yes")
				&& getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("NO")) {

			click(btnBrowser);
			sleep(3000);

			String MRFilePath = System.getProperty("user.dir") + "\\Individuals File Upload\\" + fileName + "."
					+ formatType;
			try {
				Robot robot = new Robot();

				// Copy the file path to the clipboard
				StringSelection stringSelection = new StringSelection(MRFilePath);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

				// Simulate pressing Ctrl+V to paste the file path
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);

				// Simulate pressing Enter to confirm the file selection
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);

			} catch (Exception e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}

			waitForPageLoad();
			waitForFullPageElementLoad();

			String fileUpload = getAttribute(medicalRecordFile, "href");

			try {

				Assert.assertFalse("File NOT Uploaded", fileUpload.isEmpty());
				log(Status.PASS, "File uploaded in Medical Record successfully");

			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}

		} else if (getConfigureProperty("MedicalRecordFileUpload").equalsIgnoreCase("No")
				|| getConfigureProperty("MedicalRecordFileUpload").equalsIgnoreCase("Yes")
						&& getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("Yes")) {

			log(Status.INFO, "SKIPPED Medical Record File Upload due to Headless Run");

		} else {
			log(Status.INFO, "Enter invalid VALUE format in Config.property file");
		}

		if (getConfigureProperty("MedicalRecordFileDownload").equalsIgnoreCase("Yes")
				&& getConfigureProperty("MedicalRecordFileUpload").equalsIgnoreCase("Yes")
				&& getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("No")) {

			downloadMRUploadedFile();
			log(Status.INFO, "FILE downloaded kindly verify your local machine");

		} else {
			log(Status.INFO, "SKIPPED Medical Record File Download due to Headless Run ");
		}
	}

	/**
	 * Delete all the exist field datas in edit individual page
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void deleteAllIndexistFieldsData() {

		deleteExistFieldData(editFNField);
		deleteExistFieldData(editMNField);
		deleteExistFieldData(editLNField);
		deleteExistFieldData(editSuffixField);
		deleteExistFieldData(editDOBField);
		deleteExistFieldData(editResidentialAddressField);
		deleteExistFieldData(editMailingAddressField);
		deleteExistFieldData(editNickNameField);
		deleteExistFieldData(editEC1FNField);
		deleteExistFieldData(editEC1LNField);
		deleteExistPhoneData(editEC1PhNumField);
	}

	public EditIndividualsPage duplicatePhoneNumber(int rowNum) {

		sendKeys(editEC1PhNumField, readExcel("Test Datas", "EditIndividuals", rowNum, 20));
		return this;
	}

	/**
	 * Click and select(update) title dropdown based on the data from the specified
	 * row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage updateTitle(int rowNum) {

		click(title);

		String title = readExcel("Test Datas", "EditIndividuals", rowNum, 3);
		Title = Title.replaceAll("selectTitle", title);
		select(Title);
		return this;
	}

	/**
	 * To enter(update) the valid data in First name* field based on the data from
	 * the specified
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage updateFirstName(int rowNum) {

		sendKeys(editFNField, readExcel("Test Datas", "EditIndividuals", rowNum, 0));
		return this;
	}

	/**
	 * To enter(update) the valid data in Middle name field based on the data from
	 * the specified
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage updateMiddleName(int rowNum) {

		sendKeys(editMNField, readExcel("Test Datas", "EditIndividuals", rowNum, 1));
		return this;
	}

	/**
	 * To enter(update) the valid data in Last name* field based on the data from
	 * the specified
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @throws Exception If an error occurs during this operation.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage updateLastName(int rowNum) throws Exception {

		String updatedLastName = readExcel("Test Datas", "EditIndividuals", rowNum, 2) + secondsCount();
		sendKeys(editLNField, updatedLastName);
		writeExcelToOverwrite("Test Datas", "EditIndividuals", 1, 21, updatedLastName);
		return this;
	}

	/**
	 * Click(update) on gender* field based on the data from the specified row
	 * number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage updateGender(int rowNum) {

		click(gender);

		String getGender = readExcel("Test Datas", "EditIndividuals", rowNum, 4);
		genderSelection = genderSelection.replaceAll("choosegender", getGender);
		select(genderSelection);
		return this;
	}

	/**
	 * To enter(update) the valid data in DOB* field based on the data from the
	 * specified row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage updateDob(int rowNum) {

		sendKeys(editDOBField, readExcel("Test Datas", "EditIndividuals", rowNum, 5));
		return this;
	}

	/**
	 * To enter(update) the valid data in suffix field based on the data from the
	 * specified row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage updateSuffix(int rowNum) {

		sendKeys(editSuffixField, readExcel("Test Datas", "EditIndividuals", rowNum, 7));
		return this;
	}

	/**
	 * Click and select(update) race dropdown based on the data from the specified
	 * row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage updateRace(int rowNum) {

		click(selectRace);

		String getRace = readExcel("Test Datas", "EditIndividuals", rowNum, 8);
		race = race.replaceAll("selectRace", getRace);
		select(race);
		return this;
	}

	/**
	 * Click and select(update) marital status dropdown based on the data from the
	 * specified row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage updateMaritalStatus(int rowNum) {

		click(maritalStatus);

		String getStatus = readExcel("Test Datas", "EditIndividuals", rowNum, 9);
		maritalSts = maritalSts.replaceAll("Mstatus", getStatus);
		select(maritalSts);
		return this;
	}

	/**
	 * To Enter(update) a residential Address into a field based on the data from
	 * the specified row number in the Excel sheet.
	 *
	 * @param rowNum The row number from which to read the residential Address data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage updateResidentialAddress(int rowNum) {

		sendKeys(editResidentialAddressField, readExcel("Test Datas", "EditIndividuals", rowNum, 10));
		return this;
	}

	/**
	 * To Enter(update) a mailing Address into a field based on the data from the
	 * specified row number in the Excel sheet.
	 *
	 * @param rowNum The row number from which to read the mailing Address data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage updateMailingAddress(int rowNum) {

		sendKeys(editMailingAddressField, readExcel("Test Datas", "EditIndividuals", rowNum, 11));
		return this;
	}

	/**
	 * To enter(update) the valid data in Nick Name field based on the data from the
	 * specified row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage updateNickName(int rowNum) {

		sendKeys(editNickNameField, readExcel("Test Datas", "EditIndividuals", rowNum, 12));
		return this;
	}

	/**
	 * Click and select(update) Pronoun dropdown based on the data from the
	 * specified row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage updatePronoun(int rowNum) {

		click(selectPronoun);

		String getPronoun = readExcel("Test Datas", "EditIndividuals", rowNum, 13);
		Pronoun = Pronoun.replaceAll("selectPronoun", getPronoun);
		select(Pronoun);
		return this;
	}

	/**
	 * Click and select(update) Ethnic Affiliation dropdown based on the data from
	 * the specified row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage updateEthnicAffiliation(int rowNum) {

		click(selectEthnicAffiliation);

		String getEthnicAffiliation = readExcel("Test Datas", "EditIndividuals", rowNum, 14);
		EthnicAffiliation = EthnicAffiliation.replaceAll("selectEthnicAffiliation", getEthnicAffiliation);
		select(EthnicAffiliation);
		return this;
	}

	/**
	 * Click and select(update) Preffered Language dropdown based on the data from
	 * the specified row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage updatePreferredLanguage(int rowNum) {

		click(selectPreferredLanguage);

		String getPreferredLanguage = readExcel("Test Datas", "EditIndividuals", rowNum, 15);
		PreferredLanguage = PreferredLanguage.replaceAll("selectPreferredLanguage", getPreferredLanguage);
		select(PreferredLanguage);
		return this;
	}

	/**
	 * Click and select(update) Religion dropdown based on the data from the
	 * specified row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage updateReligion(int rowNum) {

		click(selectReligion);
		waitForFullPageElementLoad();

		String getReligion = readExcel("Test Datas", "EditIndividuals", rowNum, 16);
		Religion = Religion.replaceAll("selectReligion", getReligion);
		select(Religion);
		return this;
	}

	/**
	 * To enter(update) the valid data in emergency contact1 First Name* field based
	 * on the data from the specified row number in the Excel sheet..
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage updateEC1FirstName(int rowNum) {

		sendKeys(editEC1FNField, readExcel("Test Datas", "EditIndividuals", rowNum, 17));
		return this;
	}

	/**
	 * To enter(update) the valid data in emergency contact1 Last Name* field based
	 * on the data from the specified row number in the Excel sheet..
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage updateEC1LastName(int rowNum) {

		sendKeys(editEC1LNField, readExcel("Test Datas", "EditIndividuals", rowNum, 18));
		return this;
	}

	/**
	 * Click and select(update) emergency contact1 Relationship dropdown based on
	 * the data from the specified row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage updateEC1Relationship(int rowNum) {

		click(EC1Relationship);
		waitForFullPageElementLoad();
		String selectRS = readExcel("Test Datas", "EditIndividuals", rowNum, 19);
		relationship = relationship.replaceAll("selectRelationship", selectRS);
		select(relationship);
		return this;
	}

	/**
	 * To enter(update) the valid data in emergency contact1 Phone Number* field
	 * based on the data from the specified row number in the Excel sheet..
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @throws Exception If an error occurs during this operation.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage updateEC1PhoneNumber(int rowNum) throws Exception {

		String randomMobileNumber = randomMobileNumber();
		writeExcelToOverwrite("Test Datas", "EditIndividuals", 2, 20, randomMobileNumber);
		sendKeys(editEC1PhNumField, readExcel("Test Datas", "EditIndividuals", rowNum, 20));
		return this;
	}

	/**
	 * To enter(update) the valid data in emergency contact2 first name field based
	 * on the data from the specified row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage updateEC2FirstName(int rowNum) {

		sendKeys(editEC2FNField, readExcel("Test Datas", "EditIndividuals", rowNum, 17));
		return this;
	}

	/**
	 * To enter(update) the valid data in emergency contact2 last name field based
	 * on the data from the specified row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage updateEC2LastName(int rowNum) {

		sendKeys(editEC2LNField, readExcel("Test Datas", "EditIndividuals", rowNum, 18));
		return this;
	}

	/**
	 * Click and select (Update) ec2 relationship dropdown based on the data from
	 * the specified row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage updateEC2Relationship(int rowNum) {

		click(EC2Relationship);
		waitForFullPageElementLoad();
		String selectRS = readExcel("Test Datas", "EditIndividuals", rowNum, 19);
		relationship = relationship.replaceAll("selectRelationship", selectRS);
		select(relationship);
		return this;
	}

	/**
	 * To enter(update) the valid data in emergency contact2 phone number field
	 * based on the data from the specified row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public EditIndividualsPage updateEC2PhoneNumber(int rowNum) {

		sendKeys(editEC2PhNumField, readExcel("Test Datas", "EditIndividuals", rowNum, 20));
		return this;

	}

	/**
	 * Delete all the exist datas in Vitals Tab
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void deleteAllVitalsExistFieldsData() {

		deleteExistFieldData(bloodPressureField);
		deleteExistFieldData(bloodGlucoseField);
		deleteExistFieldData(cholestrolField);
		deleteExistFieldData(heightField);
		deleteExistFieldData(weightField);
		deleteExistFieldData(healthSummaryField);
	}

}
