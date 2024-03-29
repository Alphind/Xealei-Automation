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

public class AddIndividualsPage extends BaseClass {


	public AddIndividualsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//h5[@x-page='Individuals']")
	private WebElement individualsPageText;

	@FindBy(xpath = "//button[@x-ind-add-btn]")
	private WebElement addIndividual;

	@FindBy(xpath = "//h1[@x-heading-ind-reg]")
	private WebElement addIndividualPopup;

	@FindBy(xpath = "//span[@x-tab-photo]")
	private WebElement photoTab;

	@FindBy(xpath = "//span[@x-tab-identi]")
	private WebElement identificationTab;

	@FindBy(xpath = "//span[@x-tab-address]")
	private WebElement addressTab;

	@FindBy(xpath = "//span[@x-tab-Prefe]")
	private WebElement preferenceTab;

	@FindBy(xpath = "//button[@x-ind-upload-btn]")
	private WebElement uploadPhotobtn;

	@FindBy(xpath = "//button[@x-ind-upload-btn]/div[1]")
	private WebElement uploadBtnEnabled;

	@FindBy(xpath = "//button[@x-ind-capture-cont]/div[1]")
	private WebElement capturedBtnEnabled;

	@FindBy(xpath = "//button[@x-ind-capture-cont]/div[1]")
	private WebElement continueBtnEnabled;

	String currentDate = "//table[@class='mat-calendar-table']/tbody/tr/td/div[text()='Date']";

	String chooseDate = "//table[@class='mat-calendar-table']/tbody/tr/td/div[text()='selectDate']";
	String chooseMonth = "//table[@class='mat-calendar-table']/tbody/tr/td/div[text()='selectMonth']";
	String chooseYear = "//table[@class='mat-calendar-table']/tbody/tr/td/div[text()='selectYear']";

	String selectNextDate = "//div[text()='selectDate']/parent::td";

	@FindBy(xpath = "//input[@x-ind-fn-val]")
	private WebElement firstName;

	@FindBy(xpath = "//button[@class='mat-calendar-previous-button mat-icon-button mat-button-base']")
	private WebElement leftArrowBtn;

	@FindBy(xpath = "//button[@class='mat-calendar-next-button mat-icon-button mat-button-base']")
	private WebElement rightArrowBtn;

	@FindBy(xpath = "//input[@x-ind-mn-val]")
	private WebElement middleName;

	@FindBy(xpath = "//input[@x-ind-ln-val]")
	private WebElement lastName;

	@FindBy(xpath = "//span[contains(text(),' First name cannot be longer')]")
	private WebElement limitValMsgForFrstName;

	@FindBy(xpath = "//span[contains(text(),' Middle name cannot be longer')]")
	private WebElement limitValMsgForMiddleName;

	@FindBy(xpath = "//span[contains(text(),' Last name cannot be longer')]")
	private WebElement limitValMsgForLastName;

	@FindBy(xpath = "//button[@type='button']/parent::mat-datepicker-toggle")
	private WebElement btnCalendar;

	@FindBy(xpath = "//button[@aria-label='Choose month and year']")
	private WebElement datePicker;

	@FindBy(xpath = "(//button[@id='identification-tab-id'])[1]")
	private WebElement forwardToIdentificationTab;

	@FindBy(xpath = "(//button[@id='address-tab-id'])[1]")
	private WebElement forwardToAddressTab;

	@FindBy(xpath = "//button[@id='preference-tab-id']")
	private WebElement forwardToPrefTab;

	@FindBy(xpath = "(//span[@x-tab-prefe]/following::mat-icon[contains(text(),'arrow_forward')])[3]")
	private WebElement forwardToConfimPage;

	@FindBy(xpath = "(//span[@x-tab-prefe]/following::mat-icon[contains(text(),'arrow_forward')])[4]")
	private WebElement imageUploadForwardArrowToConfirmPage;

	@FindBy(xpath = "(//button[@id='address-tab-id'])[2]")
	private WebElement backToAddressTab;

	@FindBy(xpath = "(//button[@id='identification-tab-id'])[2]")
	private WebElement backToIdentificationTab;

	@FindBy(xpath = "//button[@id='photo-tab-id']")
	private WebElement backToPhotoTab;

	@FindBy(xpath = "//button[@aria-label='Next month']")
	private WebElement datePickerRightArrow;

	@FindBy(xpath = "//mat-select[@ng-reflect-name='suite']")
	private WebElement selectSuite;

	@FindBy(xpath = "//mat-label[@x-ind-resi-lbl]")
	private WebElement residentialAddressLabelName;

	String genderSelection = "//mat-radio-button[@ng-reflect-value = 'chooseGender']";

	@FindBy(xpath = "//input[@ng-reflect-name='dob']")
	private WebElement dob;

	String selectExistSuite = "//span[text()='existSuiteName ']/parent::mat-option";

	String selectSuiteForS1 = "(//mat-option[@role='option'])[2]";

	@FindBy(xpath = "//input[@x-ind-resi-val]")
	private WebElement residentialAddress;

	@FindBy(xpath = "//mat-checkbox[contains(@class,'mat-checkbox-checked')]")
	private WebElement addressTabCheckbox;

	@FindBy(xpath = "//input[@x-ind-mail-addr-val]")
	private WebElement mailingAddress;

	@FindBy(xpath = "//div[@class='mat-checkbox-inner-container']/parent::label/parent::mat-checkbox")
	private WebElement sameAsResiAddressCheckbox;

	@FindBy(xpath = "//span[contains(text(),' Please enter residential address ')]")
	private WebElement validationErrMsgForResidentialAddressField;

	@FindBy(xpath = "//span[contains(text(),' Please enter mailing address ')]")
	private WebElement validationErrMsgForMailingAddressField;

	@FindBy(xpath = "//span[contains(text(),' Please enter emergency contact first name ')]")
	private WebElement validationErrMsgForEmContactFNField;

	@FindBy(xpath = "//span[contains(text(),' Please enter emergency contact last name ')]")
	private WebElement validationErrMsgForEmContactLNField;

	@FindBy(xpath = "//span[contains(text(),' Please select emergency contact relationship ')]")
	private WebElement validationErrMsgForEmContactRelationshipField;

	@FindBy(xpath = "//span[contains(text(),' Please enter valid emergency contact number ')]")
	private WebElement validationErrMsgForEmContactPhNoField;

	@FindBy(xpath = "//span[contains(text(),'Please enter first name')]")
	private WebElement validationErrMsgForIndFNField;

	@FindBy(xpath = "//span[contains(text(),' Please enter last name ')]")
	private WebElement validationErrMsgForIndLNField;

	@FindBy(xpath = "//span[contains(text(),' Please select gender')]")
	private WebElement validationErrMsgForGenderField;

	@FindBy(xpath = "//span[contains(text(),'Please enter dob')]")
	private WebElement validationErrMsgForDOBField;

	@FindBy(xpath = "//span[contains(text(),' Please select suite ')]")
	private WebElement validationErrMsgForSuiteField;

	@FindBy(xpath = "(//div[@class='head6 user-text'])[2]")
	private WebElement IndividualNameInPreferenceTabVerification;

	@FindBy(xpath = "(//span[@class='font14'])[2]")
	private WebElement IndividualDOBInPreferenceTabVerification;

	@FindBy(xpath = "//div[@class='head6 user-text']")
	private WebElement IndividualNameInAddressTabVerification;

	@FindBy(xpath = "(//span[@class='font14'])[1]")
	private WebElement IndividualDOBInAddressTabVerification;

	@FindBy(xpath = "(//div[@class='head6 user-text'])[3]")
	private WebElement IndividualNameInConfirmTabVerification;

	@FindBy(xpath = "(//span[@class='font14'])[4]")
	private WebElement IndividualDOBInConfirmTabVerification;

	@FindBy(xpath = "(//mat-label[contains(text(),'Address')]/following::span[@class='font14'])[4]")
	private WebElement IndividualAddressInConfirmTabVerification;

	@FindBy(xpath = "//mat-label[contains(text(),'Phone Number')]/following::p")
	private WebElement IndividualPhoneNumInConfirmTabVerification;

	@FindBy(xpath = "(//mat-label[contains(text(),'Address')]/following::span[@class='font14'])[2]")
	private WebElement IndividualAddressInPreferenceTabVerification;

	@FindBy(xpath = "//mat-label[contains(text(),'Title')]")
	private WebElement titleLabelName;

	@FindBy(xpath = "//mat-label[contains(text(),'Nick Name')]")
	private WebElement nickNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Add another emergency contact')]")
	private WebElement btnAddEmergencyContact;

	@FindBy(xpath = "//input[@x-ec-fn-val]")
	private WebElement emergencyContact1FN;

	@FindBy(xpath = "//input[@x-ec-ln-val]")
	private WebElement emergencyContact1LN;

	@FindBy(xpath = "//mat-select[@ng-reflect-name='relationship']")
	private WebElement emergencyContact1Relationship;

	String relationship = "//span[text()='selectRelationship']/parent::mat-option";

	@FindBy(xpath = "//input[@x-ec-phno-val]")
	private WebElement emergencyContact1PhoneNo;

	@FindBy(xpath = "//input[@ng-reflect-name='suffix']")
	private WebElement suffix;

	@FindBy(xpath = "//button[@x-ind-skip-btn]")
	private WebElement skipbtn;

	@FindBy(xpath = "//button[@x-ind-cm]")
	private WebElement confirmBtn;

	@FindBy(xpath = "//button[@x-ind-bk]")
	private WebElement backBtn;

	@FindBy(xpath = "//span[contains(text(),'Please provide valid data')]")
	private WebElement validDataAndEnterAllReqFieldsToastMsg;

	@FindBy(xpath = "//span[contains(text(),'ok')]/parent::button")
	private WebElement requiredFieldToastMsgokbtn;

	@FindBy(xpath = "//button[@x-ind-capture-cont]")
	private WebElement capture;

	@FindBy(xpath = "//mat-select[@ng-reflect-name='title']")
	private WebElement title;

	String Title = "//span[text()='selectTitle']/parent::mat-option";

	@FindBy(xpath = "//mat-select[@ng-reflect-name='race']")
	private WebElement selectRace;

	String race = "//span[text()='selectRace']/parent::mat-option";

	@FindBy(xpath = "//mat-select[@ng-reflect-name='maritalStatus']")
	private WebElement maritalStatus;

	String maritalSts = "//span[text()='Mstatus']/parent::mat-option";

	@FindBy(xpath = "//input[@x-ind-nick-nm-val]")
	private WebElement nickName;

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

	@FindBy(xpath = "(//input[@x-ec-fn-val])[2]")
	private WebElement emergencyContact2FN;

	@FindBy(xpath = "(//input[@x-ec-ln-val])[2]")
	private WebElement emergencyContact2LN;

	@FindBy(xpath = "(//mat-select[@ng-reflect-name='relationship'])[2]")
	private WebElement emergencyContact2Relationship;

	@FindBy(xpath = "(//input[@x-ec-phno-val])[2]")
	private WebElement emergencyContact2PhoneNo;

	@FindBy(xpath = "(//input[@x-ec-fn-val])[3]")
	private WebElement emergencyContact3FN;

	@FindBy(xpath = "(//input[@x-ec-ln-val])[3]")
	private WebElement emergencyContact3LN;

	@FindBy(xpath = "(//mat-select[@ng-reflect-name='relationship'])[3]")
	private WebElement emergencyContact3Relationship;

	@FindBy(xpath = "(//input[@x-ec-phno-val])[3]")
	private WebElement emergencyContact3PhoneNo;

	@FindBy(xpath = "(//div[@x-emerg-conts])[1]")
	private WebElement emergencyContact1LabelName;

	@FindBy(xpath = "(//div[@x-emerg-conts])[2]")
	private WebElement emergencyContact2LabelName;

	@FindBy(xpath = "(//div[@x-emerg-conts])[3]")
	private WebElement emergencyContact3LabelName;

	@FindBy(xpath = "(//div[@x-emerg-conts]/following::i)[1]")
	private WebElement emContact2CloseBtn;

	@FindBy(xpath = "(//div[@x-emerg-conts]/following::i)[2]")
	private WebElement emContact3CloseBtn;

	@FindBy(xpath = "//mat-datepicker-toggle[@class='mat-datepicker-toggle']")
	private WebElement datePickerButton;

	@FindBy(xpath = "(//span[@class='popup-close']/parent::button)[2]")
	private WebElement newIndRegCloseBtn;

	@FindBy(xpath = "//button[@x-ind-capture-cont]")
	private WebElement continueButton;

	@FindBy(xpath = "//p[contains(text(),'(')]")
	private WebElement phoneNum;

	@FindBy(xpath = "//i[@class='tab-tick']/parent::span[@x-tab-identi]")
	private WebElement identificationTabTick;

	@FindBy(xpath = "//i[@class='tab-tick']/parent::span[@x-tab-address]")
	private WebElement addressTabTick;

	@FindBy(xpath = "//i[@class='tab-tick']/parent::span[@x-tab-prefe]")
	private WebElement preferenceTabTick;

	@FindBy(xpath = "//span[contains(text(),'Only jpg,jpeg')]")
	private WebElement unsupportedImgFormatToastMsg;

	@FindBy(xpath = "//span[text()='OK']/parent::button")
	private WebElement toastMsgOkBtn;

	@FindBy(xpath = "//span[contains(text(),'File size should be less than 1 MB')]")
	private WebElement imgSizeToastMsg;

	@FindBy(xpath = "//div[@class='mat-calendar-arrow']/parent::span/parent::button")
	private WebElement monthYearDD;

	@FindBy(xpath = "//h5[contains(text(),'New')]")
	private WebElement txtNewIndID;

	@FindBy(xpath = "//b[@x-bncid]")
	private WebElement indID;

	@FindBy(xpath = "//h6[contains(text(),'Created')]")
	private WebElement txtCreatedSuccessfully;

	@FindBy(xpath = "//button[@x-gti-btn]")
	private WebElement btnGoToInd;

	@FindBy(xpath = "//span[contains(text(),'Individual already exist with same phone number')]")
	private WebElement duplicatePhNoToastbarMsg;

	@FindBy(xpath = "//span[contains(text(),'OK')]/parent::button")
	private WebElement duplicatePhNoToastbarMsgOKBtn;

	@FindBy(xpath = "//span[contains(text(),'Individual Saved Successfully')]")
	private WebElement createIndSuccessfullyToastMsg;

	@FindBy(xpath = "//img[@src='/assets/img/confirmation-tick.gif']")
	private WebElement createdGIFImage;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement individualSearchBox;

	@FindBy(xpath = "//div[@class='profile-name mb-1']")
	private WebElement createdIndName;

	@FindBy(xpath = "//mat-dialog-container[@id='mat-dialog-0']")
	private WebElement scrollDownInPrefTab;

	@FindBy(xpath = "//div[@class='head6 user-text']")
	private WebElement createdIndividualName;

	@FindBy(xpath = "//span[@class='font14'][@x-et-v-dob-val]")
	private WebElement createdDOB;

	String selectNextToTheCurrentDate = "//div[text()='nextDate']/parent::td";

	@FindBy(xpath = "//span[@class='font14'][@x-et-v-gen-val]")
	private WebElement createdGender;

	@FindBy(xpath = "//span[@class='font14'][@x-et-v-resadd-val]")
	private WebElement createdResiAddress;

	@FindBy(xpath = "//span[@class='font14'][@x-et-v-maadd-val]")
	private WebElement createdMailAddress;

	@FindBy(xpath = "//div[@x-et-v-iden-hea]/following::mat-label/following::span[@x-et-v-tit-val]")
	private WebElement selectedTitle;

	@FindBy(xpath = "//div[@x-et-v-iden-hea]/following::mat-label/following::span[@x-et-v-ide-fn-val]")
	private WebElement createdFirstName;

	@FindBy(xpath = "//div[@x-et-v-iden-hea]/following::mat-label/following::span[@x-et-v-ide-mn-val]")
	private WebElement createdMiddleName;

	@FindBy(xpath = "//div[@x-et-v-iden-hea]/following::mat-label/following::span[@x-et-v-ide-ln-val]")
	private WebElement createdLastName;

	@FindBy(xpath = "//div[@x-et-v-iden-hea]/following::mat-label/following::span[@x-et-v-ide-suf-val]")
	private WebElement createdSuffix;

	@FindBy(xpath = "//div[@x-et-v-iden-hea]/following::mat-label/following::span[@x-et-v-ide-rce-val]")
	private WebElement selectedRace;

	@FindBy(xpath = "//div[@x-et-v-iden-hea]/following::mat-label/following::span[@x-et-v-ide-masts-val]")
	private WebElement selectedMaritalStatus;

	@FindBy(xpath = "//div[@x-et-v-iden-hea]/following::mat-label/following::span[@x-et-v-ide-suite-val]")
	private WebElement selectedSuite;

	@FindBy(xpath = "//div[@x-et-v-ide-prefe-head]/following::mat-label/following::span[@x-et-v-ide-nina-val]")
	private WebElement createdNickName;

	@FindBy(xpath = "//div[@x-et-v-ide-prefe-head]/following::mat-label/following::span[@x-et-v-ide-pro-val]")
	private WebElement selectedPronoun;

	@FindBy(xpath = "//div[@x-et-v-ide-prefe-head]/following::mat-label/following::span[@x-et-v-ide-etaff-val]")
	private WebElement selectedEthnicAffiliation;

	@FindBy(xpath = "//div[@x-et-v-ide-prefe-head]/following::mat-label/following::span[@x-et-v-ide-prelan-val]")
	private WebElement selectedPrefLanguage;

	@FindBy(xpath = "//div[@x-et-v-ide-prefe-head]/following::mat-label/following::span[@x-et-v-ide-reli-val]")
	private WebElement selectedReligion;

	@FindBy(xpath = "//div[@x-et-v-ide-prefe-head]/following::div[@id='x-et-v-ec0']/following::span[@id='x-et-v-ne-val0']")
	private WebElement createdEmContact1Name;

	@FindBy(xpath = "//div[@x-et-v-ide-prefe-head]/following::div[@id='x-et-v-ec0']/following::span[@id='x-et-v-rel-val0']")
	private WebElement selectedEmContact1Relationship;

	@FindBy(xpath = "//div[@x-et-v-ide-prefe-head]/following::div[@id='x-et-v-ec0']/following::span[@id='x-et-v-pne-val0']")
	private WebElement createdEmContact1PhNo;

	@FindBy(xpath = "//div[@x-et-v-ide-prefe-head]/following::div[@id='x-et-v-ec1']/following::span[@id='x-et-v-ne-val1']")
	private WebElement createdEmContact2Name;

	@FindBy(xpath = "//div[@x-et-v-ide-prefe-head]/following::div[@id='x-et-v-ec1']/following::span[@id='x-et-v-rel-val1']")
	private WebElement selectedEmContact2Relationship;

	@FindBy(xpath = "//div[@x-et-v-ide-prefe-head]/following::div[@id='x-et-v-ec1']/following::span[@id='x-et-v-pne-val1']")
	private WebElement createdEmContact2PhNo;

	String selectBG = "//span[text()='selectBGroup']/parent::mat-option";

	@FindBy(xpath = "//mat-select[@ng-reflect-name='bloodGroup']")
	private WebElement bloodGroup;

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

	@FindBy(xpath = "//input[@x-et-bmi-val]")
	private WebElement bmiField;

	@FindBy(xpath = "//textarea[@x-et-hlsu-val]")
	private WebElement healthSummaryField;

	@FindBy(xpath = "//button[@x-et-edit-update]")
	private WebElement btnVitalsUpdate;

	@FindBy(xpath = "//span[contains(text(),'Vitals updated successfully')]")
	private WebElement vitalsUpdatedSuccessfullToastMsg;

	@FindBy(xpath = "//button[@x-et-v-arb]")
	private WebElement addVitalsButton;

	@FindBy(xpath = "//span[@x-et-v-vi-bg-val]")
	private WebElement selectedBG;

	@FindBy(xpath = "//span[@x-et-v-vi-bp-val]")
	private WebElement createdBP;

	@FindBy(xpath = "//span[@x-et-v-vi-bgle-val]")
	private WebElement createdBGlucose;

	@FindBy(xpath = "//span[@x-et-v-vi-cho-val]")
	private WebElement createdCholestrol;

	@FindBy(xpath = "//span[@x-et-v-vi-ht-lbl]")
	private WebElement createdHeight;

	@FindBy(xpath = "//span[@x-et-v-vi-wt-val]")
	private WebElement createdWeight;

	@FindBy(xpath = "//span[@x-et-v-vi-bmi-val]")
	private WebElement createdBMI;

	@FindBy(xpath = "//a[@x-et-v-ovc01][@data-toggle='tab']")
	private WebElement vitalsTab;


	public WebElement getCreatedIndividualName() {
		return createdIndividualName;
	}

	public WebElement getCreatedDOB() {
		return createdDOB;
	}

	public WebElement getCreatedGender() {
		return createdGender;
	}

	public WebElement getCreatedMailAddress() {
		return createdMailAddress;
	}

	public WebElement getCreatedResiAddress() {
		return createdResiAddress;
	}

	public WebElement getCreatedFirstName() {
		return createdFirstName;
	}

	public WebElement getCreatedMiddleName() {
		return createdMiddleName;
	}

	public WebElement getCreatedLastName() {
		return createdLastName;
	}

	public WebElement getSelectedTitle() {
		return selectedTitle;
	}

	public WebElement getCreatedSuffix() {
		return createdSuffix;
	}

	public WebElement getSelectedRace() {
		return selectedRace;
	}

	public WebElement getSelectedMaritalStatus() {
		return selectedMaritalStatus;
	}

	public WebElement getSelectedSuite() {
		return selectedSuite;
	}

	public WebElement getCreatedNickName() {
		return createdNickName;
	}

	public WebElement getSelectedPronoun() {
		return selectedPronoun;
	}

	public WebElement getSelectedEthnicAffiliation() {
		return selectedEthnicAffiliation;
	}

	public WebElement getSelectedPrefLanguage() {
		return selectedPrefLanguage;
	}

	public WebElement getSelectedReligion() {
		return selectedReligion;
	}

	public WebElement getCreatedEmContact1Name() {
		return createdEmContact1Name;
	}

	public WebElement getSelectedEmContact1Relationship() {
		return selectedEmContact1Relationship;
	}

	public WebElement getCreatedEmContact1PhNo() {
		return createdEmContact1PhNo;
	}

	public WebElement getScrollDownInPrefTab() {
		return scrollDownInPrefTab;
	}

	public WebElement getCreatedIndName() {
		return createdIndName;
	}

	public WebElement getAddIndividual() {
		return addIndividual;
	}

	public WebElement getUploadPhotobtn() {
		return uploadPhotobtn;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getEmContact2CloseBtn() {
		return emContact2CloseBtn;
	}

	public WebElement getEmContact3CloseBtn() {
		return emContact3CloseBtn;
	}

	public WebElement getCapture() {
		return capture;
	}

	public WebElement getValidDataAndEnterAllReqFieldsToastMsg() {
		return validDataAndEnterAllReqFieldsToastMsg;
	}

	public WebElement getConfirmBtn() {
		return confirmBtn;
	}

	public WebElement getNickNameLabel() {
		return nickNameLabel;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getMiddleName() {
		return middleName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getIndividualsPageText() {
		return individualsPageText;
	}

	public WebElement getAddIndividualPopup() {
		return addIndividualPopup;
	}

	public WebElement getPhotoTab() {
		return photoTab;
	}

	public WebElement getIdentificationTab() {
		return identificationTab;
	}

	public WebElement getAddressTab() {
		return addressTab;
	}

	public WebElement getPreferenceTab() {
		return preferenceTab;
	}

	public WebElement getLimitValMsgForFrstName() {
		return limitValMsgForFrstName;
	}

	public WebElement getLimitValMsgForMiddleName() {
		return limitValMsgForMiddleName;
	}

	public WebElement getLimitValMsgForLastName() {
		return limitValMsgForLastName;
	}

	public WebElement getIndID() {
		return indID;
	}

	public WebElement getDatePicker() {
		return datePicker;
	}

	public WebElement getResidentialAddressLabelName() {
		return residentialAddressLabelName;
	}

	public WebElement getResidentialAddress() {
		return residentialAddress;
	}

	public WebElement getMailingAddress() {
		return mailingAddress;
	}

	public WebElement getValidationErrMsgForMailingAddressField() {
		return validationErrMsgForMailingAddressField;
	}

	public WebElement getValidationErrMsgForResidentialAddressField() {
		return validationErrMsgForResidentialAddressField;
	}

	public WebElement getEmergencyContact1PhoneNo() {
		return emergencyContact1PhoneNo;
	}

	public WebElement getEmergencyContact2PhoneNo() {
		return emergencyContact2PhoneNo;
	}

	public WebElement getValidationErrMsgForEmContactFNField() {
		return validationErrMsgForEmContactFNField;
	}

	public WebElement getValidationErrMsgForEmContactLNField() {
		return validationErrMsgForEmContactLNField;
	}

	public WebElement getValidationErrMsgForEmContactRelationshipField() {
		return validationErrMsgForEmContactRelationshipField;
	}

	public WebElement getValidationErrMsgForEmContactPhNoField() {
		return validationErrMsgForEmContactPhNoField;
	}

	public WebElement getValidationErrMsgForIndFNField() {
		return validationErrMsgForIndFNField;
	}

	public WebElement getValidationErrMsgForIndLNField() {
		return validationErrMsgForIndLNField;
	}

	public WebElement getValidationErrMsgForGenderField() {
		return validationErrMsgForGenderField;
	}

	public WebElement getValidationErrMsgForDOBField() {
		return validationErrMsgForDOBField;
	}

	public WebElement getValidationErrMsgForSuiteField() {
		return validationErrMsgForSuiteField;
	}

	public WebElement getTitleLabelName() {
		return titleLabelName;
	}

	public WebElement getIndividualNameInAddressTabVerification() {
		return IndividualNameInAddressTabVerification;
	}

	public WebElement getIndividualDOBInAddressTabVerification() {
		return IndividualDOBInAddressTabVerification;
	}

	public WebElement getIndividualNameInPreferenceTabVerification() {
		return IndividualNameInPreferenceTabVerification;
	}

	public WebElement getIndividualDOBInPreferenceTabVerification() {
		return IndividualDOBInPreferenceTabVerification;
	}

	public WebElement getIndividualAddressInPreferenceTabVerification() {
		return IndividualAddressInPreferenceTabVerification;
	}

	public WebElement getIndividualNameInConfirmTabVerification() {
		return IndividualNameInConfirmTabVerification;
	}

	public WebElement getIndividualDOBInConfirmTabVerification() {
		return IndividualDOBInConfirmTabVerification;
	}

	public WebElement getIndividualAddressInConfirmTabVerification() {
		return IndividualAddressInConfirmTabVerification;
	}

	public WebElement getIndividualPhoneNumInConfirmTabVerification() {
		return IndividualPhoneNumInConfirmTabVerification;
	}

	public WebElement getEmergencyContact1FN() {
		return emergencyContact1FN;
	}

	public WebElement getEmergencyContact1LN() {
		return emergencyContact1LN;
	}

	public WebElement getEmergencyContact2FN() {
		return emergencyContact2FN;
	}

	public WebElement getEmergencyContact2LN() {
		return emergencyContact2LN;
	}

	public WebElement getEmergencyContact3FN() {
		return emergencyContact3FN;
	}

	public WebElement getEmergencyContact3LN() {
		return emergencyContact3LN;
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

	public WebElement getIdentificationTabTick() {
		return identificationTabTick;
	}

	public WebElement getAddressTabTick() {
		return addressTabTick;
	}

	public WebElement getPreferenceTabTick() {
		return preferenceTabTick;
	}

	public WebElement getUnsupportedImgFormatToastMsg() {
		return unsupportedImgFormatToastMsg;
	}

	public WebElement getImgSizeToastMsg() {
		return imgSizeToastMsg;
	}

	public WebElement getUploadBtnEnabled() {
		return uploadBtnEnabled;
	}

	public WebElement getCapturedBtnEnabled() {
		return capturedBtnEnabled;
	}

	public WebElement getContinueBtnEnabled() {
		return continueBtnEnabled;
	}

	public WebElement getDob() {
		return dob;
	}

	public WebElement getCreateIndSuccessfullyToastMsg() {
		return createIndSuccessfullyToastMsg;
	}

	public WebElement getTxtNewIndID() {
		return txtNewIndID;
	}

	public WebElement getTxtCreatedSuccessfully() {
		return txtCreatedSuccessfully;
	}

	public WebElement getBtnGoToInd() {
		return btnGoToInd;
	}

	public WebElement getDuplicatePhNoToastbarMsg() {
		return duplicatePhNoToastbarMsg;
	}

	public WebElement getDuplicatePhNoToastbarMsgOKBtn() {
		return duplicatePhNoToastbarMsgOKBtn;
	}

	public WebElement getCreatedGIFImage() {
		return createdGIFImage;
	}

	public WebElement getVitalsUpdatedSuccessfullToastMsg() {
		return vitalsUpdatedSuccessfullToastMsg;
	}

	public WebElement getSelectedBG() {
		return selectedBG;
	}

	public WebElement getCreatedBP() {
		return createdBP;
	}

	public WebElement getCreatedBGlucose() {
		return createdBGlucose;
	}

	public WebElement getCreatedCholestrol() {
		return createdCholestrol;
	}

	public WebElement getCreatedHeight() {
		return createdHeight;
	}

	public WebElement getCreatedWeight() {
		return createdWeight;
	}

	public WebElement getCreatedBMI() {
		return createdBMI;
	}

	public WebElement getBmiField() {
		return bmiField;
	}

	public WebElement getforwardToAddressTab() {
		return forwardToAddressTab;
	}

	public WebElement isCheckboxTicked() {
		return addressTabCheckbox;
	}

	/**
	 * Retrieves the value of a individual searchbox field attribute.
	 * 
	 * @return The value of the individual searchbox field attribute.
	 * @author Alphi-MohamedRazul
	 */
	public String getIndividualSearchBox() {
		return getAttribute(individualSearchBox, "value");
	}
	
	
	/**
	 * Select and verifies the current date and time in DOB* field.
	 * 
	 * @throws Exception If an error occurs during this operation.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void selectCurrentDateInDatePicker() throws Exception {

		System.out.println("CURRENT DATE IS :" + getCurrentDate());
		chooseDate = chooseDate.replaceAll("selectDate", getCurrentDate());
		select(chooseDate);

		waitForFullPageElementLoad();

		String selectedDate = getAttribute(dob, "value");

		try {
			Assert.assertEquals("Selected date is NOT displayed in DOB* Field",
					getCurrentMonth() + "/" + getCurrentDate() + getCurrentDtYearMonth("/yyyy"), selectedDate);
			log(Status.PASS, "Selected date is displayed in DOB* Field Exp Dt - " + getCurrentMonth() + "/"
					+ getCurrentDate() + getCurrentDtYearMonth("/yyyy") + " | Act Dt - " + selectedDate);
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Check whether the future dates are hidden or not.
	 * 
	 * @throws Exception If an error occurs during this operation.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void futureDatesAreHidden() throws Exception {

		String currentMonth = getCurrentDtYearMonth("MM");
		String currentDate = getCurrentDtYearMonth("dd");
		String currentYear = getCurrentDtYearMonth("yyyy");

		System.out.println("Current Date - " + currentDate);
		System.out.println("Current Month - " + currentMonth);
		System.out.println("Current Year - " + currentYear);

		int intEventDt = Integer.parseInt(currentDate);

		if ((currentMonth.equals("01") || currentMonth.equals("03") || currentMonth.equals("05")
				|| currentMonth.equals("07") || currentMonth.equals("08") || currentMonth.equals("10")
				|| currentMonth.equals("12")) && intEventDt <= 30) {

			selectNextToTheCurrentDate = selectNextToTheCurrentDate.replaceAll("nextDate", nextToCurrentDate());
			WebElement getNextDate = findElementByXpath(selectNextToTheCurrentDate);

			String NextDate = getAttribute(getNextDate, "aria-disabled");
			System.out.println("Future Dt - " + NextDate);

			if (NextDate.equals("true")) {
				log(Status.PASS, "Future date is disabled");
			} else {
				log(Status.FAIL, "Next to the current dates are NOT disabled in Notification Date field");
			}

//			String rightArrow = getAttribute(datePickerRightArrow, "ng-reflect-disabled");
//
//			if (rightArrow.equalsIgnoreCase("true")) {
//				log(Status.PASS, "Next Month > Right arrow is disabled");
//			} else {
//				log(Status.FAIL, "Next Month > Right arrow is NOT disabled");	
//			}

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
				log(Status.PASS, "Future date is disabled");
			} else {
				log(Status.FAIL, "Next to the current dates are NOT disabled in Notification Date field");
			}

//			String rightArrow = getAttribute(datePickerRightArrow, "ng-reflect-disabled");
//
//			if (rightArrow.equalsIgnoreCase("true")) {
//				log(Status.PASS, "Next Month > Right arrow is disabled");
//			} else {
//				log(Status.FAIL, "Next Month > Right arrow is NOT disabled");	
//			}

		} else if ((currentMonth.equals("04") || currentMonth.equals("06") || currentMonth.equals("09")
				|| currentMonth.equals("11")) && currentDate.equals("30")) {

			String rightArrow = getAttribute(datePickerRightArrow, "ng-reflect-disabled");

			if (rightArrow.equalsIgnoreCase("true")) {
				log(Status.PASS, "Reached the Month END date Next Month > arrow is disabled");
			} else {
				log(Status.FAIL, "Reached the Month END date Next Month > arrow is NOT disabled");
			}

		} else if (currentMonth.equals("02") && intEventDt <= 27) {

			selectNextToTheCurrentDate = selectNextToTheCurrentDate.replaceAll("nextDate", nextToCurrentDate());
			WebElement getNextDate = findElementByXpath(selectNextToTheCurrentDate);

			String NextDate = getAttribute(getNextDate, "aria-disabled");
			System.out.println("Future Dt - " + NextDate);

			if (NextDate.equals("true")) {
				log(Status.PASS, "Future date is disabled");
			} else {
				log(Status.FAIL, "Next to the current dates are NOT disabled in Notification Date field");
			}

//			String rightArrow = getAttribute(datePickerRightArrow, "ng-reflect-disabled");
//
//			if (rightArrow.equalsIgnoreCase("true")) {
//				log(Status.PASS, "Next Month > Right arrow is disabled");
//			} else {
//				log(Status.FAIL, "Next Month > Right arrow is NOT disabled");	
//			}

		} else if (currentMonth.equals("02") && intEventDt == 28) {

			String rightArrow = getAttribute(datePickerRightArrow, "ng-reflect-disabled");

			if (rightArrow.equalsIgnoreCase("true")) {
				log(Status.PASS, "Reached the Month END date Next Month > arrow is disabled");
			} else {
				log(Status.FAIL, "Reached the Month END date Next Month > arrow is NOT disabled");
			}

//		} else if (currentMonth.equals("02") && intEventDt == 28 && (intEventYear%4==0)) {
//
//			selectNextToTheCurrentDate = selectNextToTheCurrentDate.replaceAll("nextDate", nextToCurrentDate());
//			WebElement getNextDate = findElementByXpath(selectNextToTheCurrentDate);
//
//			String NextDate = getAttribute(getNextDate, "aria-disabled");
//			System.out.println("Future Dt - "+NextDate);
//			
//			if (NextDate.equals("true")) {
//				log(Status.PASS, "Future date is disabled");
//			} else {
//				log(Status.FAIL, "Next to the current dates are NOT disabled in Notification Date field");
//			}
//			
//			String rightArrow = getAttribute(datePickerRightArrow, "ng-reflect-disabled");
//
//			if (rightArrow.equalsIgnoreCase("true")) {
//				log(Status.PASS, "Next Month > Right arrow is disabled");
//			} else {
//				log(Status.FAIL, "Next Month > Right arrow is NOT disabled");	
//			}
		} else {
			log(Status.SKIP, "The Method is skiped kindly check manually");
		}

	}

	/**
	 * To check whether the left and right arrow <> is disabled or not.
	 * 
	 * @author Alphi-MohamedRazul
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
	 * Select the Date/Month/Year in DOB* field using dropdown
	 * 
	 * @param rowNum The row number from which to read the data from excel.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void selectDOBUsingDD(int rowNum) {

		deleteExistFieldData(dob);
		datePicker();
		waitForFullPageElementLoad();
		click(monthYearDD);
		while (true) {
			String getYearFromExcel = readExcel("Test Datas", "AddIndividuals", rowNum, 25);

			WebElement startYear = findElementByXpath("//table/tbody/tr[1]/td[1]");
			WebElement LastYear = findElementByXpath("//table//tbody/tr[6]/td[4]");

			String startYEAR = startYear.getText();
			String lastYEAR = LastYear.getText();

			int getYearFromExcelIntParse = Integer.parseInt(getYearFromExcel);
			int startYearIntParse = Integer.parseInt(startYEAR);
			int lastYEARIntParse = Integer.parseInt(lastYEAR);

			if (startYearIntParse <= getYearFromExcelIntParse && lastYEARIntParse >= getYearFromExcelIntParse) {

				String chooseYearFromExcel = readExcel("Test Datas", "AddIndividuals", 1, 25);
				chooseYear = chooseYear.replaceAll("selectYear", chooseYearFromExcel);
				select(chooseYear);
				log(Status.INFO, "Select the year in date picker - YEAR " + chooseYearFromExcel);
				log(Status.PASS, "Selected the year in date picker - YEAR " + chooseYearFromExcel);
				break;
			} else {
				click(leftArrowBtn);
			}
		}

		try {
			chooseMonth = chooseMonth.replaceAll("selectMonth", previousMonth("MMM"));
			select(chooseMonth);
			log(Status.INFO, "Select the month in date picker - MONTH " + previousMonth("MMM"));
			log(Status.PASS, "Selected the month in date picker - MONTH " + previousMonth("MMM"));

		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
		}

		try {
			String chooseDateFromExcel = readExcel("Test Datas", "AddIndividuals", rowNum, 22);
			currentDate = currentDate.replaceAll("Date", chooseDateFromExcel);
			select(currentDate);
			log(Status.INFO, "Select the date in date picker - DATE " + chooseDateFromExcel);
			log(Status.PASS, "Select the date in date picker - DATE " + chooseDateFromExcel);

		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
		}
	}

	/**
	 * Click on right side arrow in DOB* field and verifies the dates are displayed
	 * are not.
	 * 
	 * @param rowNum The row number from which to read the data from excel.
	 * @throws Exception If an error occurs during this operation.
	 */
	public void rightSideArrow(int rowNum) throws Exception {

		String chooseDateFromExcel = readExcel("Test Datas", "AddIndividuals", rowNum, 22);
		sendKeys(getDob(), getMonth() + "/" + chooseDateFromExcel + "/" + getYear());

		datePicker();

		click(rightArrowBtn);
		chooseDate = chooseDate.replaceAll("selectDate", getCurrentDate());
		select(chooseDate);

		log(Status.INFO, "Select the date in date picker - DATE :" + getCurrentDate());

		String selectedDate = getAttribute(dob, "value");

		try {

			Assert.assertEquals("Selected date is NOT displayed in DOB* Field",
					getCurrentMonth() + "/" + getCurrentDate() + getCurrentDtYearMonth("/yyyy"), selectedDate);
			log(Status.PASS, "Selected date is displayed in DOB* Field Exp Dt - " + getCurrentMonth() + "/"
					+ getCurrentDate() + getCurrentDtYearMonth("/yyyy") + " | Act Dt - " + selectedDate);
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Click on 'Address' Tab section to close the calender.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void closeCalender() {

		click(addressTab);
	}

	/**
	 * Click on 'Photo' Tab section to close the calender.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage photoTab() {

		click(photoTab);
		return this;
	}

	/**
	 * Click on Toast message 'OK' button.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage toastMsgOKButton() {
		click(toastMsgOkBtn);
		return this;
	}

	/**
	 * Click on 'Skip' button.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void skip() {

		click(skipbtn);
	}

	/**
	 * Click on '->' arrow to navigate confirm page.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage forwardToConfirmPage() {

		if (getConfigureProperty("ImageUpload").equalsIgnoreCase("Yes")
				&& getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("No")) {

			click(imageUploadForwardArrowToConfirmPage);
			return this;
		} else {
			click(forwardToConfimPage);
			return this;
		}
	}

	/**
	 * Click on right arrow '->' to navigate confirm page.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void rightArrowToConfirmPage() {

		click(forwardToConfimPage);
	}

	/**
	 * Click on 'Confirm' button to confirm the individual creation.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage confirm() {

		click(confirmBtn);
		return this;
	}

	/**
	 * Click on 'Add Individual' Button
	 */
	public void addIndividualButton() {

		click(addIndividual);
	}

	/**
	 * Select the unsupported image/file format and verifies whether the toast message is
	 * displayed or not.
	 * 
	 * @param fileName   The name of the file name to upload.
	 * @param formatType The type of file (i.e: .jfif, .gif, etc)
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void unSupportedImgFormatUpload(String fileName, String formatType) {

		if (getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("NO")
				&& getConfigureProperty("ImageUpload").equalsIgnoreCase("Yes")) {

			click(uploadPhotobtn);
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
					waitForVisiblityOfElement(getUnsupportedImgFormatToastMsg(), 5);
					Assert.assertEquals("Unsupport FileFormat Toast Msg Not Displayed as expected",
							"Only jpg,jpeg,png type format is supported", getText(getUnsupportedImgFormatToastMsg()));
					log(Status.PASS, "Unsupport FileFormat ToastMsg is displayed successfully - "
							+ getText(getUnsupportedImgFormatToastMsg()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}
				toastMsgOKButton();

			} catch (AWTException e) {
				e.printStackTrace();
			}

		} else if (getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("YES")) {
			log(Status.INFO, "Unsupported Img Format scenario is SKIPPED Due to Headless Run");
		} else {
			log(Status.INFO, "Enter invalid VALUE format in Config.property file");
		}
	}

	/**
	 * Select more than 1MB file format and verifies whether the toast message is
	 * displayed or not.
	 * 
	 * @param fileName   The name of the file name to upload.
	 * @param formatType The type of file (i.e: .jfif, .gif, etc)
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void moreThan1MBImgFormatUpload(String fileName, String formatType) {

		if (getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("NO")
				&& getConfigureProperty("ImageUpload").equalsIgnoreCase("Yes")) {

			click(uploadPhotobtn);
			sleep(2000);

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

		} else if (getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("YES")) {
			log(Status.INFO, "MoreThan1MBFile Img Format scenario is SKIPPED due to Headless Run");
		} else {
			log(Status.INFO, "Enter invalid VALUE format in Config.property file");
		}
	}

	/**
	 * Select the Supported image/file format and verifies whether the toast message is
	 * displayed or not.
	 * 
	 * @param fileName   The name of the file name to upload.
	 * @param formatType The type of file (i.e: .jpg, .png, etc)
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void Upload(String fileName, String formatType) throws Exception {

		if (getConfigureProperty("ImageUpload").equalsIgnoreCase("Yes")
				&& getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("NO")) {

			click(uploadPhotobtn);
			sleep(2000);

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

				String uploadBtn = getAttribute(getUploadBtnEnabled(), "ng-reflect-disabled");
				String captureBtn = getAttribute(getContinueBtnEnabled(), "ng-reflect-disabled");

				if (uploadBtn.equalsIgnoreCase("false") && captureBtn.equalsIgnoreCase("false")) {
					log(Status.PASS, "Image Uploaded Successfully in Photo tab section");
					log(Status.PASS, "Upload and Continue button is Enabled in photo tab section");

					continueButton();

					if (titleLabelName.isDisplayed()) {
						log(Status.PASS, "Continue Button is working in photo tab");
					} else {
						log(Status.FAIL, "Continue Button is working in photo tab");
						throw new Exception();
					}

				} else {
					log(Status.FAIL, "Upload and Continue button is NOT Enabled in photo tab section");
				}

			} catch (AWTException e) {
				e.printStackTrace();
			}
		} else if (getConfigureProperty("ImageUpload").equalsIgnoreCase("No")
				|| getConfigureProperty("ImageUpload").equalsIgnoreCase("Yes")
						&& getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("Yes")) {
			log(Status.INFO, "Skip Image Uploaded in Photo tab section due to Headless Run");
			skip();
		} else {
			log(Status.INFO, "Enter invalid VALUE format in Config.property file");
		}
	}

	/**
	 * To enter max characters in first name field.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void invalidFirstName() {

		sendKeys(firstName, "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345");
		click(middleName);
	}

	/**
	 * To enter max characters in middle name field.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void invalidMiddleName() {

		sendKeys(middleName, "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345");
		click(lastName);
	}

	/**
	 * To enter max characters in last name field.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void invalidLastName() {

		sendKeys(lastName, "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345");
		click(suffix);
	}

	/**
	 * Click on calender icon.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void datePicker() {

		click(btnCalendar);
	}

	/**
	 * To enter valid data in first name field.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage firstName(int rowNum) {

		sendKeys(firstName, readExcel("Test Datas", "AddIndividuals", rowNum, 0));
		return this;
	}

	/**
	 * To enter valid data in middle name field.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage middleName(int rowNum) {

		sendKeys(middleName, readExcel("Test Datas", "AddIndividuals", rowNum, 1));
		return this;
	}

	/**
	 * To enter valid data in last name field.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage lastName(int rowNum) throws Exception {

		String crLastName = readExcel("Test Datas", "AddIndividuals", rowNum, 2) + secondsCount();
		sendKeys(lastName, crLastName);
		writeExcelToOverwrite("Test Datas", "AddIndividuals", 1, 21, crLastName);
		return this;
	}

	/**
	 * Select the gender to create and individual.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage gender(int rowNum) {

		String chooseGender = readExcel("Test Datas", "AddIndividuals", rowNum, 4);
		genderSelection = genderSelection.replaceAll("chooseGender", chooseGender);
		select(genderSelection);
		return this;
	}

	/**
	 * To enter valid data in DOB* field
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @return
	 */
	public AddIndividualsPage dob(int rowNum) {

		sendKeys(dob, readExcel("Test Datas", "AddIndividuals", rowNum, 5));
		return this;
	}

	/**
	 * Select the first suite in Suite* field to check whether able to select or
	 * not.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage selectSuiteForS1() {

		click(selectSuite);
		select(selectSuiteForS1);
		return this;
	}

	/**
	 * Check whether the Mandatory fields are filled in identification tab section.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void isMandatoryFieldsAreFilledInIdenticationTabSection() {

		if (getAttribute(firstName, "value").isBlank() || getAttribute(lastName, "value").isBlank()
				|| getAttribute(lastName, "value").isBlank() || getAttribute(dob, "value").isBlank()) {
			log(Status.FAIL, "All the mandatory fields are NOT filled");
		} else {
			log(Status.PASS, "All the mandatory fields are filled");
		}

	}

	/**
	 * Click & Select the valid suite data from excel.
	 * 
	 * @param rowNum The row number from which to read the data from excel.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage selectSuite(int rowNum) {

		sleep(1000);
		click(selectSuite);
		waitForFullPageElementLoad();
		String existSUITE = readExcel("Test Datas", "AddIndividuals", rowNum, 6);
		selectExistSuite = selectExistSuite.replaceAll("existSuiteName", existSUITE);
		select(selectExistSuite);
		return this;
	}

	/**
	 * Click on '->' forward arrow in Identi.. tab to moved Address tab section.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void forwardArrowToAddressSection() {

		waitForFullPageElementLoad();
		click(forwardToAddressTab);

	}

	/**
	 * Click on '->' forward arrow in address.. tab to moved Preference tab section.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void forwardArrowToPreferenceSection() {

		waitForFullPageElementLoad();
		click(forwardToPrefTab);
	}

	/**
	 * Click on '->' forward arrow in Prefe.. tab to moved Confirm page.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage movedtoConfirmPage() {

		waitForFullPageElementLoad();
		click(forwardToConfimPage);
		return this;

	}

	/**
	 * Click on '<-' backward arrow in Address tab to moved Identification tab
	 * section.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void backwardArrowToIdentificationSection() {

		waitForFullPageElementLoad();
		click(backToIdentificationTab);
	}

	/**
	 * Click on '<-' backward arrow in Pref... tab to moved Address tab section.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void backwardArrowToAddressSection() {

		waitForFullPageElementLoad();
		click(backToAddressTab);
	}

	/**
	 * Click on '<-' backward arrow in Identi... tab to moved Photo tab section.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void backwardArrowToPhotoSection() {

		waitForFullPageElementLoad();
		click(backToPhotoTab);
	}

	/**
	 * To Enters a residential Address into a field based on the data from the
	 * specified row number in the Excel sheet.
	 *
	 * @param rowNum The row number from which to read the residential Address data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage residentialAddress(int rowNum) {

		sendKeys(residentialAddress, readExcel("Test Datas", "AddIndividuals", rowNum, 10));
		return this;
	}

	/**
	 * To Enters a mailing Address into a field based on the data from the specified
	 * row number in the Excel sheet.
	 *
	 * @param rowNum The row number from which to read the mailing Address data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage MailingAddress(int rowNum) {

		sendKeys(mailingAddress, readExcel("Test Datas", "AddIndividuals", rowNum, 11));
		return this;
	}

	/**
	 * Verifies mailing address field is empty or not
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void isMailingAddressFieldIsEmpty() {

		if (getAttribute(mailingAddress, "value").isBlank()) {
			log(Status.PASS, "Mailing address Field is empty");
		} else {
			log(Status.FAIL, "Mailing address Field is NOT empty");
		}
	}

	/**
	 * Click on 'sameAsResiAddress' checkbox
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage sameAsResiAdresscheckBox() {

		click(sameAsResiAddressCheckbox);
		return this;

	}

	/**
	 * Click on AddEmergencyContact
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void addEmergencyContact() {

		click(btnAddEmergencyContact);

	}

	/**
	 * To enter the maximum character in emergency contact First Name* field.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage ecFNForLimitVal() {

		sendKeys(emergencyContact1FN, "abcdefghijklmnopqrstuvwxyz12345");
		click(emergencyContact1LN);
		return this;
	}

	/**
	 * To enter the maximum character in emergency contact Last Name* field.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage ecLNForLimitVal() {

		sendKeys(emergencyContact1LN, "abcdefghijklmnopqrstuvwxyz12345");
		click(emergencyContact1FN);
		return this;
	}

	/**
	 * To enter the valid data in emergency contact1 First Name* field based on the
	 * data from the specified row number in the Excel sheet..
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage ecFirstName(int rowNum) {

		sendKeys(emergencyContact1FN, readExcel("Test Datas", "AddIndividuals", rowNum, 17));
		return this;
	}

	/**
	 * To enter the valid data in emergency contact1 Last Name* field based on the
	 * data from the specified row number in the Excel sheet..
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage ecLastName(int rowNum) {

		sendKeys(emergencyContact1LN, readExcel("Test Datas", "AddIndividuals", rowNum, 18));
		return this;
	}

	/**
	 * Click and select emergency contact1 Relationship dropdown based on the data
	 * from the specified row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage ecRelationship(int rowNum) {

		click(emergencyContact1Relationship);
		String selectRS = readExcel("Test Datas", "AddIndividuals", rowNum, 19);
		relationship = relationship.replaceAll("selectRelationship", selectRS);
		select(relationship);
		return this;
	}

	/**
	 * To enter the valid data in emergency contact1 Phone Number* field based on the
	 * data from the specified row number in the Excel sheet..
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @throws Exception If an error occurs during this operation.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage ecPhoneNumber(int rowNum) throws Exception {

		String randomMobileNumber = randomMobileNumber();
		writeExcelToOverwrite("Test Datas", "AddIndividuals", 2, 20, randomMobileNumber);
		sendKeys(emergencyContact1PhoneNo, readExcel("Test Datas", "AddIndividuals", rowNum, 20));
		return this;
	}

	/**
	 * Enters 1 digit extra in emergency contact 1 phone number field and retrieves
	 * the entered value.
	 *
	 * @param phoneNumber The phone number to be entered into the emergency contact
	 *                    1 phone number field.
	 * @return The value of the entered phone number.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public String getPhoneNoFieldMaxValue() {

		backSpace(emergencyContact1PhoneNo);
		sendKeys(emergencyContact1PhoneNo, "01");
		String phNoFieldValue = getAttribute(emergencyContact1PhoneNo, "value");
		return phNoFieldValue;
	}

	/**
	 * Click on Toast button 'ok' button.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage toastMsgokButton() {

		click(requiredFieldToastMsgokbtn);
		return this;
	}

	/**
	 * Click on 'Back' button
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage back() {

		click(backBtn);
		waitForFullPageElementLoad();
		return this;
	}

	/**
	 * Click on identification tab section
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage identificationTab() {

		click(identificationTab);
		waitForFullPageElementLoad();
		return this;
	}

	/**
	 * Click on address tab section
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage addressTab() {

		click(addressTab);
		return this;

	}

	/**
	 * Click on preference tab section
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage preferenceTab() {

		click(preferenceTab);
		return this;
	}

	/**
	 * Click and select title dropdown based on the data from the specified row
	 * number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage title(int rowNum) {

		click(title);

		String title = readExcel("Test Datas", "AddIndividuals", rowNum, 3);
		Title = Title.replaceAll("selectTitle", title);
		select(Title);
		return this;
	}

	/**
	 * To enter the valid data in suffix field based on the data from the specified
	 * row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage suffix(int rowNum) {

		sendKeys(suffix, readExcel("Test Datas", "AddIndividuals", rowNum, 7));
		return this;
	}

	/**
	 * Click and select race dropdown based on the data from the specified row
	 * number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage race(int rowNum) {

		click(selectRace);

		String getRace = readExcel("Test Datas", "AddIndividuals", rowNum, 8);
		race = race.replaceAll("selectRace", getRace);
		select(race);
		return this;
	}

	/**
	 * Click and select marital status dropdown based on the data from the specified
	 * row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage maritalStatus(int rowNum) {

		click(maritalStatus);

		String getStatus = readExcel("Test Datas", "AddIndividuals", rowNum, 9);
		maritalSts = maritalSts.replaceAll("Mstatus", getStatus);
		select(maritalSts);
		return this;
	}

	/**
	 * To enter the valid data in Nick Name field based on the data from the
	 * specified row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage nickName(int rowNum) {

		sendKeys(nickName, readExcel("Test Datas", "AddIndividuals", rowNum, 12));
		return this;
	}

	/**
	 * Click and select Pronoun dropdown based on the data from the specified row
	 * number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage pronoun(int rowNum) {

		click(selectPronoun);

		String getPronoun = readExcel("Test Datas", "AddIndividuals", rowNum, 13);
		Pronoun = Pronoun.replaceAll("selectPronoun", getPronoun);
		select(Pronoun);
		return this;
	}

	/**
	 * Click and select Ethnic Affiliation dropdown based on the data from the
	 * specified row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage ethnicAffiliation(int rowNum) {

		click(selectEthnicAffiliation);

		String getEthnicAffiliation = readExcel("Test Datas", "AddIndividuals", rowNum, 14);
		EthnicAffiliation = EthnicAffiliation.replaceAll("selectEthnicAffiliation", getEthnicAffiliation);
		select(EthnicAffiliation);
		return this;
	}

	/**
	 * Click and select Preffered Language dropdown based on the data from the
	 * specified row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage preferredLanguage(int rowNum) {

		click(selectPreferredLanguage);

		String getPreferredLanguage = readExcel("Test Datas", "AddIndividuals", rowNum, 15);
		PreferredLanguage = PreferredLanguage.replaceAll("selectPreferredLanguage", getPreferredLanguage);
		select(PreferredLanguage);
		return this;
	}

	/**
	 * Click and select Religion dropdown based on the data from the specified row
	 * number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage Religion(int rowNum) {

		click(selectReligion);
		waitForFullPageElementLoad();

		String getReligion = readExcel("Test Datas", "AddIndividuals", rowNum, 16);
		Religion = Religion.replaceAll("selectReligion", getReligion);
		select(Religion);
		return this;
	}

	/**
	 * To enter the max characters in emergency contact2 First Name field.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage ec2FNForLimitVal() {

		sendKeys(emergencyContact2FN, "abcdefghijklmnopqrstuvwxyz12345");
		click(emergencyContact2LN);
		return this;
	}

	/**
	 * To enter the max characters in emergency contact2 Last Name field.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage ecLN2ForLimitVal() {

		sendKeys(emergencyContact2LN, "abcdefghijklmnopqrstuvwxyz12345");
		click(emergencyContact2FN);
		return this;
	}

	/**
	 * To check whether the emergency contact1 field details is empty or not.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public void ecFieldIsEmpty() {

		if (getAttribute(emergencyContact1FN, "value").isBlank() || getAttribute(emergencyContact1LN, "value").isBlank()
				|| getAttribute(emergencyContact1PhoneNo, "value").isBlank()) {
			log(Status.FAIL, "Data NOT entered in First and Last Name field in EC1");
		} else {
			log(Status.PASS, "Data is entered in First and Last Name field in EC1");
		}
	}

	/**
	 * To check whether the emergency contact2 field details is empty or not.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public void ec2FieldIsEmpty() {

		if (getAttribute(emergencyContact2FN, "value").isBlank()
				|| getAttribute(emergencyContact2LN, "value").isBlank()) {
			log(Status.FAIL, "Data NOT entered in First and Last Name field in EC2");
		} else {
			log(Status.PASS, "Data is entered in First and Last Name field in EC2");
		}
	}

	/**
	 * To enter the valid data in emergency contact2 first name field based on the
	 * data from the specified row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage ec2FirstName(int rowNum) {

		sendKeys(emergencyContact2FN, readExcel("Test Datas", "AddIndividuals", rowNum, 17));
		return this;
	}

	/**
	 * To enter the valid data in emergency contact2 last name field based on the
	 * data from the specified row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage ec2LastName(int rowNum) {

		sendKeys(emergencyContact2LN, readExcel("Test Datas", "AddIndividuals", rowNum, 18));
		return this;
	}

	/**
	 * Click and select ec2 relationship dropdown based on the data from the
	 * specified row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage ec2Relationship(int rowNum) {

		click(emergencyContact2Relationship);
		waitForFullPageElementLoad();
		String selectRS = readExcel("Test Datas", "AddIndividuals", rowNum, 19);
		relationship = relationship.replaceAll("selectRelationship", selectRS);
		select(relationship);
		return this;
	}

	/**
	 * To enter the valid data in emergency contact2 phone number field based on the
	 * data from the specified row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage ec2PhoneNumber(int rowNum) throws Exception {

		String randomMobileNumber = randomMobileNumber();
		writeExcelToOverwrite("Test Datas", "AddIndividuals", 2, 20, randomMobileNumber);
		sendKeys(emergencyContact2PhoneNo, readExcel("Test Datas", "AddIndividuals", rowNum, 20));
		return this;
	}

	/**
	 * Click on emergency contact2 Relationship dropdown
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage selectEC2Relationship() {

		click(emergencyContact2Relationship);
		return this;
	}

	/**
	 * To enter the max characters in emergency contact3 First Name field.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage ec3FNForLimitVal() {

		sendKeys(emergencyContact3FN, "abcdefghijklmnopqrstuvwxyz13345");
		click(emergencyContact3LN);
		return this;
	}

	/**
	 * To enter the max characters in emergency contact3 Last Name field.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public void ec3LNForLimitVal() {

		sendKeys(emergencyContact3LN, "abcdefghijklmnopqrstuvwxyz13345");
		click(emergencyContact3FN);
	}

	/**
	 * To check whether the emergency contact3 field details is empty or not.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public void ec3FieldIsEmpty() {

		if (getAttribute(emergencyContact3FN, "value").isBlank()
				|| getAttribute(emergencyContact3LN, "value").isBlank()) {
			log(Status.FAIL, "Data NOT entered in First and Last Name field in EC3");
		} else {
			log(Status.PASS, "Data is entered in First and Last Name field in EC3");
		}
	}

	/**
	 * To enter the valid data in emergency contact3 First Name field based on the
	 * data from the specified row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public void ec3FirstName(int rowNum) {

		sendKeys(emergencyContact3FN, readExcel("Test Datas", "AddIndividuals", rowNum, 17));
	}

	/**
	 * To enter the valid data in emergency contact3 Last Name field based on the
	 * data from the specified row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public void ec3LastName(int rowNum) {

		sendKeys(emergencyContact3LN, readExcel("Test Datas", "AddIndividuals", rowNum, 18));
	}

	/**
	 * Click and select ec3 relationship dropdown based on the data from the
	 * specified row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public void ec3Relationship(int rowNum) {

		click(emergencyContact3Relationship);
		waitForFullPageElementLoad();
		String selectRS = readExcel("Test Datas", "AddIndividuals", rowNum, 19);
		relationship = relationship.replaceAll("selectRelationship", selectRS);
		select(relationship);
	}

	/**
	 * To enter the valid data in emergency contact3 phone number field based on the
	 * data from the specified row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public void ec3PhoneNumber(int rowNum) {

		sendKeys(emergencyContact3PhoneNo, readExcel("Test Datas", "AddIndividuals", rowNum, 30));
	}

	/**
	 * Click on emergency contact3 Relationship dropdown field
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void selectEC3Relationship() {

		click(emergencyContact3Relationship);
		click(emergencyContact3LN);
	}

	/**
	 * Click on AddEmergencyContact2 'x' button
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void xBtnInEmContact2() {

		click(emContact2CloseBtn);
	}

	/**
	 * Click on 'x' button in New Individual Registration Popup
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void closeNewIndRegistrationPopup() {

		click(newIndRegCloseBtn);
	}

	/**
	 * Click on Continue button
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void continueButton() {

		click(continueButton);
	}

	/**
	 * Click on 'Go Individual' button
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void goToIndividualsButton() {

		click(btnGoToInd);
		waitForPageLoad();
	}

	/**
	 * To enter invalid data in individual search box
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void searchBoxForZeroSearch() throws Exception {

		// Sanity Run
		deleteExistFieldData(individualSearchBox);

		sendKeys(individualSearchBox, "KKKGT");
		waitForAjexPageLoad();
		waitForPageLoad();
		backSpace(individualSearchBox);
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
	public void searchBox(int rowNum) throws Exception {

		// Sanity Run
		deleteExistFieldData(individualSearchBox);

		String crIndividualLastName = readExcel("Test Datas", "AddIndividuals", rowNum, 26);
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

			searchedIndividualform();

		} else {
			log(Status.FAIL, "Searched Individual is NOT displayed");
			throw new Exception("Assertion failed searched Individual is not displayed as expected");
		}
	}

//	public void searchBox(int rowNum) throws Exception{
//        
//		//Sanity Run
//		deleteExistFieldData(individualSearchBox);
//		
//		String crIndividualLastName = readExcel("Test Datas", "AddIndividuals", rowNum, 26);
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
//				searchedIndividualform();
//				
//			} else {
//				log(Status.FAIL, "Searched Individual is NOT displayed");
//				throw new Exception("Assertion failed searched Individual is not displayed as expected");
//			}			
//	}

	/**
	 * Click on 'Vitals' tab section.
	 * 
	 * @throws Exception If an error occurs during this operation.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage vitalsTab() throws Exception {

		try {
			waitForElementToBeClickable(vitalsTab, 5);
			click(vitalsTab);
			return this;
		} catch (Exception e) {
			throw new Exception("Unable to navigate Vitals Tab Section");
		}
	}

	/**
	 * Click and select blood group dropdown based on the data from the specified
	 * row number in the Excel sheet.
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public AddIndividualsPage selectBloodGroup(int rowNum) {

		click(bloodGroup);
		String BG = readExcel("Test Datas", "AddVitals", rowNum, 0);
		selectBG = selectBG.replaceAll("selectBGroup", BG);
		select(selectBG);
		return this;
	}

	/**
	 * To enter the valid data in Blood Pressure* field based on the data from the
	 * specified row number in the Excel sheet.
	 * 
	 * @author Alphi-MohamedRazul
	 * @param rowNum The row number from which to read the data.
	 */
	public AddIndividualsPage bloodPressure(int rowNum) {

		sendKeys(bloodPressureField, readExcel("Test Datas", "AddVitals", rowNum, 1));
		return this;
	}

	/**
	 * To enter the valid data in Blood Glucose* field based on the data from the
	 * specified row number in the Excel sheet..
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage bloodGlucose(int rowNum) {

		sendKeys(bloodGlucoseField, readExcel("Test Datas", "AddVitals", rowNum, 2));
		return this;
	}

	/**
	 * To enter the valid data in Cholestrol* field based on the data from the
	 * specified row number in the Excel sheet..
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage cholesterol(int rowNum) {

		sendKeys(cholestrolField, readExcel("Test Datas", "AddVitals", rowNum, 3));
		return this;
	}

	/**
	 * To enter the valid data in Height* field based on the data from the specified
	 * row number in the Excel sheet..
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage height(int rowNum) {

		sendKeys(heightField, readExcel("Test Datas", "AddVitals", rowNum, 4));
		return this;
	}

	/**
	 * To enter the valid data in Weight* field based on the data from the specified
	 * row number in the Excel sheet..
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage weight(int rowNum) {

		sendKeys(weightField, readExcel("Test Datas", "AddVitals", rowNum, 5));
		return this;
	}

	/**
	 * To enter the valid data in health Summary* field based on the data from the
	 * specified row number in the Excel sheet..
	 * 
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage healthSummary(int rowNum) {

		sendKeys(healthSummaryField, readExcel("Test Datas", "AddVitals", rowNum, 7));
		return this;
	}

	/**
	 * Click on Update button under Vitals tab.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void vitalsUpdateButton() {

		waitForElementToBeClickable(btnVitalsUpdate, 10);
		click(btnVitalsUpdate);

	}

	/**
	 * Click on 'Add Vitals' button.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public AddIndividualsPage addVitalsButton() {

		click(addVitalsButton);
		return this;
	}

	/**
	 * Click on searched individual form
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void searchedIndividualform() {

		sleep(1000);
		waitForFullPageElementLoad();
		click(createdIndName);
	}

}
