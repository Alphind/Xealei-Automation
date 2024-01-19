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

public class EditIndividualsPage extends BaseClass{

	private WebDriver driver;
	
	public EditIndividualsPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//img[@class='arrow-right']")
	private WebElement arrowRight;
	
	@FindBy(xpath = "//div[@class='profile-name mb-1']")
	private WebElement createdIndName;

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
	private WebElement validationInfoMsgForBGField ;

	@FindBy(xpath = "//span[contains(text(),' Please enter blood pressure ')]")
	private WebElement validationInfoMsgForBPField ;
	
	@FindBy(xpath = "//span[contains(text(),' Please enter blood glucose ')]")
	private WebElement validationInfoMsgForBGlucoseField ;
	
	@FindBy(xpath = "//span[contains(text(),' Please enter cholesterol ')]")
	private WebElement validationInfoMsgForCholestrolField ;
	
	@FindBy(xpath = "//span[contains(text(),' Please enter height ')]")
	private WebElement validationInfoMsgForHeightField ;
	
	@FindBy(xpath = "//span[contains(text(),' Please enter weight ')]")
	private WebElement validationInfoMsgForWeightField ;
	
	@FindBy(xpath = "//span[contains(text(),' Please enter bmi ')]")
	private WebElement validationInfoMsgForBMIField ;
	
	String selectBG = "//span[text()='selectBGroup']/parent::mat-option";

	@FindBy(xpath = "//mat-select[@ng-reflect-name='bloodGroup']")
	private WebElement bloodGroup ;
	
	@FindBy(xpath = "//span[text()='Select blood group']/parent::mat-option")
	private WebElement unSelectbloodGroup ;
	
	@FindBy(xpath = "//input[@x-et-vi-bp-val]")
	private WebElement bloodPressureField ;
	
	@FindBy(xpath = "//input[@x-et-vi-bgl-val]")
	private WebElement  bloodGlucoseField;
	
	@FindBy(xpath = "//input[@x-et-cho-val]")
	private WebElement cholestrolField ;
	
	@FindBy(xpath = "//input[@x-et-hei-val]")
	private WebElement heightField ;
	
	@FindBy(xpath = "//input[@x-et-wei-val]")
	private WebElement weightField ;
	
	@FindBy(xpath = "//textarea[@x-et-hlsu-val]")
	private WebElement healthSummaryField ;
	
	@FindBy(xpath = "//span[contains(text(),' Blood pressure format should be (120/80) ')]")
	private WebElement formatValidationInfoMsgForBPField ;
	
	@FindBy(xpath = "//span[contains(text(),' Please enter valid blood glucose ')]")
	private WebElement formatValidationInfoMsgForBGlucoseField ;
	
	@FindBy(xpath = "//span[contains(text(),' Please enter valid cholesterol ')]")
	private WebElement formatValidationInfoMsgForCholestrolField ;
	
	@FindBy(xpath = "//span[contains(text(),' Please enter valid height ')]")
	private WebElement formatValidationInfoMsgForHeightField ;
	
	@FindBy(xpath = "//span[contains(text(),' Please enter valid weight ')]")
	private WebElement formatValidationInfoMsgForWeightField ;
	
	@FindBy(xpath = "(//a[@x-et-afp-a])[1]")
	private WebElement medicalRecordFile ;
	
	@FindBy(xpath = "(//a[@x-et-afp-a])[2]")
	private WebElement medicalRecordFile2 ;
	
	@FindBy(xpath = "(//a[@x-et-remove-1])[1]")
	private WebElement cancelUploadedFile ;
	
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

	
	
	
	
	
	
	
	
	
	
	
	
	public void searchBox(int rowNum){

		String crIndividualLastName = readExcelFromLastRow("Test Datas", "CreatedIndividuals", 1);
		for (int i = 0; i < crIndividualLastName.length(); i++) {
			char letter = crIndividualLastName.charAt(i);
			String letterAsString = String.valueOf(letter);
			sendKeys(individualSearchBox, letterAsString);
		}

		backSpace(individualSearchBox);
		waitForPageLoad();
		int length = crIndividualLastName.length();
		char lastLetter = crIndividualLastName.charAt(length - 1);
		String enterLastLetter = String.valueOf(lastLetter);
		sendKeys(individualSearchBox, enterLastLetter);

		waitForPageLoad();
		waitForFullPageElementLoad();
	}
	
	
	public void downloadMRUploadedFile() {
		
		waitForPageLoad();
		waitForFullPageElementLoad();
		
		click(downloadMRFile);
	}

	
	public void arrowRight() {
		
		click(arrowRight);
	}

	public EditIndividualsPage vitalsTab() {
		
		click(vitalsTab);
		return this;
	}
	
	public EditIndividualsPage ec2closeButton() {
		
		 click(EC2CloseBtn);
		return this;
	}
	
	public EditIndividualsPage ec3closeButton() {
		
		 click(EC3CloseBtn);
		 return this;
	}
	
	public  void EditButton() {
		
		click(editIndividualBtn);
	}
	
public  void individualBCTextLink() {
		
		click(individualBreadCrumLink);
	}

public  void vitalsCancelButton() {
	
	click(btnVitalsCancel);
}


	public String createdIndNameText() {

		waitForPageLoad();
		String createdInd = readExcelFromLastRow("Test Datas", "CreatedIndividuals", 1);
		BC = BC.replaceAll("createdSN", createdInd);
		String textString = getTextString(BC);
		return textString;
	}
	
	
	public void unSelectSuite() {
		
		click(selectedSuite);
		select(unselectSuite);		
	}
	
	public void unSelectGender() {
		
	  click(gender); 
	  select(unselectGender);
	  }
	
public void unSelectEC1Relationship() {
		
	    click(EC1Relationship);   
	    select(unselectRelationship);
	}

public void unSelectEC2Relationship() {
	
    click(EC2Relationship);   
    select(unselectRelationship);
}
	
	
public void updateIndividual() {
	
	click(btnUpdate);

}	

public EditIndividualsPage firstName() {
	
	sendKeys(editFNField, "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567");
	return this;
}

public EditIndividualsPage middleName() {
	
	sendKeys(editMNField, "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567");
	return this;
}

public EditIndividualsPage lastName() {
	
	sendKeys(editLNField, "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567");
	return this;
}

public EditIndividualsPage ec1FirstName() {
	
	sendKeys(editEC1FNField, "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567");
	return this;
}

public EditIndividualsPage ec1LastName() {
	
	sendKeys(editEC1LNField, "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567");
	return this;
}

public EditIndividualsPage ec2FirstName() {
	
	sendKeys(editEC2FNField, "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567");
	return this;
}

public EditIndividualsPage ec2LastName() {
	
	sendKeys(editEC2LNField, "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567");
	return this;
}

public EditIndividualsPage ec3FirstName() {
	
	sendKeys(editEC3FNField, "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567");
	return this;
}

public EditIndividualsPage ec3LastName() {
	
	sendKeys(editEC3LNField, "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567");
	return this;
}

public void cancelButton() {
	
	click(cancelEditButton);
}
	
public EditIndividualsPage bloodPressure(int rowNum, int cellNum) {
	
	sendKeys(bloodPressureField, readExcel("Test Datas", "EditVitals", rowNum, cellNum));
	return this;
}

public EditIndividualsPage bloodGlucose(int rowNum, int cellNum) {
	
	sendKeys(bloodGlucoseField, readExcel("Test Datas", "EditVitals", rowNum, cellNum));
	return this;
}

public EditIndividualsPage cholesterol(int rowNum, int cellNum) {
	
	sendKeys(cholestrolField, readExcel("Test Datas", "EditVitals", rowNum, cellNum));
	return this;
}

public EditIndividualsPage height(int rowNum, int cellNum) {
	
	sendKeys(heightField, readExcel("Test Datas", "EditVitals", rowNum, cellNum));
	return this;
}

public EditIndividualsPage weight(int rowNum, int cellNum) {
	
	sendKeys(weightField, readExcel("Test Datas", "EditVitals", rowNum, cellNum));
	return this;
}

public EditIndividualsPage healthSummary(int rowNum, int cellNum) {
	
	sendKeys(healthSummaryField, readExcel("Test Datas", "EditVitals", rowNum, cellNum));
	return this;
}
public void cancelUploadedFile() {
	
	click(cancelUploadedFile);
}


public void toastMsgOKButton() {
	click(toastMsgOkBtn);
}

	
public void moreThan1MBImgFormatUpload(String fileName, String formatType) {

	if (getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("NO")
			&& getConfigureProperty("MedicalRecordFileUpload").equalsIgnoreCase("Yes")) {
		
		click(btnBrowser);
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

	} else if (getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("YES") && getConfigureProperty("MedicalRecordFileUpload").equalsIgnoreCase("YES") || getConfigureProperty("MedicalRecordFileUpload").equalsIgnoreCase("NO")) {
		log(Status.INFO, "MoreThan1MBFile Img Format scenario is SKIPPED due to Headless Run");
	} else {
		log(Status.INFO, "Enter invalid VALUE format in Config.property file");
	}
}

public void Upload(String fileName, String formatType){

	if (getConfigureProperty("MedicalRecordFileUpload").equalsIgnoreCase("Yes")
			&& getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("NO")) {

		click(btnBrowser);
		sleep(2000);

		String MRFilePath = System.getProperty("user.dir") + "\\Individuals File Upload\\" + fileName + "." + formatType;
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
			waitForPageLoad();
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
			&& getConfigureProperty("MedicalRecordFileUpload").equalsIgnoreCase("Yes") && getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("No")) {
	
		downloadMRUploadedFile();
		log(Status.INFO,"FILE downloaded kindly verify your local machine");
		
	} else {
		log(Status.INFO, "SKIPPED Medical Record File Download due to Headless Run ");
	}	
}

public void unSelectBloodGroup() {

	click(bloodGroup);
	click(unSelectbloodGroup);
}

	
public EditIndividualsPage selectBloodGroup(int rowNum) {

	click(bloodGroup);
	String BG = readExcel("Test Datas", "EditVitals", rowNum, 0);
	selectBG = selectBG.replaceAll("selectBGroup", BG);
	select(selectBG);
	return this;
}

public void vitalsUpdateButton() {

click(btnVitalsUpdate);

}

public EditIndividualsPage addVitalsButton() {

click(addVitalsButton);
return this;
}
	
public void uploadForEditVitalsTab(String fileName, String formatType) {

	if (getConfigureProperty("MedicalRecordFileUpload").equalsIgnoreCase("Yes")
			&& getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("NO")) {

		click(btnBrowser);
		sleep(2000);

		String MRFilePath = System.getProperty("user.dir") + "\\Individuals File Upload\\" + fileName + "." + formatType;
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
			waitForPageLoad();
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
			&& getConfigureProperty("MedicalRecordFileUpload").equalsIgnoreCase("Yes") && getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("No")) {
	
		downloadMRUploadedFile();
		log(Status.INFO,"FILE downloaded kindly verify your local machine");
		
	} else {
		log(Status.INFO, "SKIPPED Medical Record File Download due to Headless Run ");
	}	
}
	
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
         deleteExistFieldData(editEC2FNField);
		 deleteExistFieldData(editEC2LNField);
         deleteExistPhoneData(editEC2PhNumField);
	}
	
	public EditIndividualsPage duplicatePhoneNumber(int rowNum) {

		sendKeys(editEC1PhNumField, readExcel("Test Datas", "EditIndividuals", rowNum, 20));
		return this;
	}
	
	public EditIndividualsPage updateTitle(int rowNum) {

		click(title);

		String title = readExcel("Test Datas", "EditIndividuals", rowNum, 3);
		Title = Title.replaceAll("selectTitle", title);
		select(Title);
		return this;
	}

	public EditIndividualsPage updateFirstName(int rowNum) {
		
		sendKeys(editFNField, readExcel("Test Datas", "EditIndividuals", rowNum, 0));
		return this;
	}

	public EditIndividualsPage updateMiddleName(int rowNum) {
		
		sendKeys(editMNField, readExcel("Test Datas", "EditIndividuals", rowNum, 1));
		return this;
	}

	public EditIndividualsPage updateLastName(int rowNum) {
		
			String updatedLastName = readExcel("Test Datas", "EditIndividuals", rowNum, 2) + secondsCount();
			sendKeys(editLNField, updatedLastName);
			writeExcelToOverwrite("Test Datas", "EditIndividuals", 1, 21, updatedLastName);
			return this;
	}
	
	public EditIndividualsPage updateGender(int rowNum) {

		click(gender);

		String getGender = readExcel("Test Datas", "EditIndividuals", rowNum, 4);
		genderSelection = genderSelection.replaceAll("choosegender", getGender);
		select(genderSelection);
		return this;
	}
	
	public EditIndividualsPage updateDob(int rowNum) {

		sendKeys(editDOBField, readExcel("Test Datas", "EditIndividuals", rowNum, 5));
		return this;
	}
	
	public EditIndividualsPage updateSuffix(int rowNum) {

		sendKeys(editSuffixField, readExcel("Test Datas", "EditIndividuals", rowNum, 7));
		return this;
	}
	

	public EditIndividualsPage updateRace(int rowNum) {

		click(selectRace);

		String getRace = readExcel("Test Datas", "EditIndividuals", rowNum, 8);
		race = race.replaceAll("selectRace", getRace);
		select(race);
		return this;
	}

	public EditIndividualsPage updateMaritalStatus(int rowNum) {

		click(maritalStatus);

		String getStatus = readExcel("Test Datas", "EditIndividuals", rowNum, 9);
		maritalSts = maritalSts.replaceAll("Mstatus", getStatus);
		select(maritalSts);
		return this;
	}
	
	public EditIndividualsPage updateResidentialAddress(int rowNum) {

		sendKeys(editResidentialAddressField, readExcel("Test Datas", "EditIndividuals", rowNum, 10));
		return this;
	}

	public EditIndividualsPage updateMailingAddress(int rowNum) {

		sendKeys(editMailingAddressField, readExcel("Test Datas", "EditIndividuals", rowNum, 11));
		return this;
	}
	
	public EditIndividualsPage updateNickName(int rowNum) {

		sendKeys(editNickNameField, readExcel("Test Datas", "EditIndividuals", rowNum, 12));
		return this;
	}

	public EditIndividualsPage updatePronoun(int rowNum) {

		click(selectPronoun);

		String getPronoun = readExcel("Test Datas", "EditIndividuals", rowNum, 13);
		Pronoun = Pronoun.replaceAll("selectPronoun", getPronoun);
		select(Pronoun);
		return this;
	}

	public EditIndividualsPage updateEthnicAffiliation(int rowNum) {

		click(selectEthnicAffiliation);

		String getEthnicAffiliation = readExcel("Test Datas", "EditIndividuals", rowNum, 14);
		EthnicAffiliation = EthnicAffiliation.replaceAll("selectEthnicAffiliation", getEthnicAffiliation);
		select(EthnicAffiliation);
		return this;
	}

	public EditIndividualsPage updatePreferredLanguage(int rowNum) {

		click(selectPreferredLanguage);

		String getPreferredLanguage = readExcel("Test Datas", "EditIndividuals", rowNum, 15);
		PreferredLanguage = PreferredLanguage.replaceAll("selectPreferredLanguage", getPreferredLanguage);
		select(PreferredLanguage);
		return this;
	}

	public EditIndividualsPage updateReligion(int rowNum) {

		click(selectReligion);
		waitForFullPageElementLoad();

		String getReligion = readExcel("Test Datas", "EditIndividuals", rowNum, 16);
		Religion = Religion.replaceAll("selectReligion", getReligion);
		select(Religion);
		return this;
	}
	
	public EditIndividualsPage updateEC1FirstName(int rowNum) {

		sendKeys(editEC1FNField, readExcel("Test Datas", "EditIndividuals", rowNum, 17));
		return this;
	}

	public EditIndividualsPage updateEC1LastName(int rowNum) {

		sendKeys(editEC1LNField, readExcel("Test Datas", "EditIndividuals", rowNum, 18));
		return this;
	}

	public EditIndividualsPage updateEC1Relationship(int rowNum) {

		click(EC1Relationship);
		waitForFullPageElementLoad();
		String selectRS = readExcel("Test Datas", "EditIndividuals", rowNum, 19);
		relationship = relationship.replaceAll("selectRelationship", selectRS);
		select(relationship);
		return this;
	}

	public EditIndividualsPage updateEC1PhoneNumber(int rowNum) {

		String randomMobileNumber = randomMobileNumber();
		writeExcelToOverwrite("Test Datas", "EditIndividuals", 2, 20, randomMobileNumber);
		sendKeys(editEC1PhNumField, readExcel("Test Datas", "EditIndividuals", rowNum, 20));
		return this;
	}
	
	public EditIndividualsPage updateEC2FirstName(int rowNum) {

		sendKeys(editEC2FNField, readExcel("Test Datas", "EditIndividuals", rowNum, 17));
		return this;
	}

	public EditIndividualsPage updateEC2LastName(int rowNum) {

		sendKeys(editEC2LNField, readExcel("Test Datas", "EditIndividuals", rowNum, 18));
		return this;
	}

	public EditIndividualsPage updateEC2Relationship(int rowNum) {

		click(EC2Relationship);
		waitForFullPageElementLoad();
		String selectRS = readExcel("Test Datas", "EditIndividuals", rowNum, 19);
		relationship = relationship.replaceAll("selectRelationship", selectRS);
		select(relationship);
		return this;
	}

	public EditIndividualsPage updateEC2PhoneNumber(int rowNum) {

//		String randomMobileNumber = randomMobileNumber();
//		writeExcelToOverwrite("Test Datas", "EditIndividuals", 2, 20, randomMobileNumber);
		
		sendKeys(editEC2PhNumField, readExcel("Test Datas", "EditIndividuals", rowNum, 20));
		return this;

	}

	
	public void deleteAllVitalsExistFieldsData() {
		
		 deleteExistFieldData(bloodPressureField);
		 deleteExistFieldData(bloodGlucoseField);
		 deleteExistFieldData(cholestrolField);
		 deleteExistFieldData(heightField);
		 deleteExistFieldData(weightField);
		 deleteExistFieldData(healthSummaryField);
	}


	
	
	
	
	
	
	
	
}
