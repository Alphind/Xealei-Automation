/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.stepdefinition;

import org.alphind.xealei.baseclass.BaseClass;
import org.alphind.xealei.pom.PageObjectManager;
import org.junit.Assert;

import com.aventstack.extentreports.Status;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddIndividualsPageStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager(getDriver());

	@Then("User should verify the Individuals Module is working")
	public void user_should_verify_the_individuals_module_is_working() {

		logStep(methodName());

		waitForPageLoad();
		
		pom.getHomePage().navToIndividualsModule();
		try {
			Assert.assertEquals("Unable to navigate Individuals Page", "Individuals",
					getText(pom.getAddIndividualsPage().getIndividualsPageText()));
			log(Status.PASS, "Navigate to Individuals page");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("User should verify the Add Individual button is working")
	public void user_should_verify_the_add_individual_button_is_working() {

		logStep(methodName());

		pom.getAddIndividualsPage().addIndividualButton();
	}

	@Then("User should verify the {string} pop up screen is displayed")
	public void user_should_verify_the_pop_up_screen_is_displayed(String expAddIndividualsPopupText) throws Exception {

		logStep(methodName());

		String popupText = getText(pom.getAddIndividualsPage().getAddIndividualPopup());

		if (popupText.contains(expAddIndividualsPopupText)) {
			log(Status.PASS, "Add Individuals popup is displayed");
		} else {
			log(Status.FAIL, "Add Individuals popup is not displayed");
			throw new Exception("Assertion Failed");
		}

	}

	@Then("User should verify the respective tab text are displayed {string}, {string}, {string}, {string}")
	public void user_should_verify_the_respective_tab_text_are_displayed(String photoTab, String IdentificationTab,
			String AddressTab, String PreferenceTab) throws Exception {

		logStep(methodName());

		String photo = getText(pom.getAddIndividualsPage().getPhotoTab());
		String identification = getText(pom.getAddIndividualsPage().getIdentificationTab());
		String address = getText(pom.getAddIndividualsPage().getAddressTab());
		String preference = getText(pom.getAddIndividualsPage().getPreferenceTab());

		if (photo.equals(photoTab)) {
			log(Status.PASS, "Photo tab is displayed in New Individuals Popup");
		} else {
			log(Status.FAIL, "Photo tab is not displayed in New Individuals Popup");
			throw new Exception("Assertion Failed");
		}

		if (identification.equals(IdentificationTab)) {
			log(Status.PASS, "Identification tab is displayed in New Individuals Popup");
		} else {
			log(Status.FAIL, "Identification tab is not displayed in New Individuals Popup");
			throw new Exception("Assertion Failed");
		}

		if (address.equals(AddressTab)) {
			log(Status.PASS, "Address tab is displayed in New Individuals Popup");
		} else {
			log(Status.FAIL, "Address tab is not displayed in New Individuals Popup");
			throw new Exception("Assertion Failed");
		}

		if (preference.equals(PreferenceTab)) {
			log(Status.PASS, "Preference tab is displayed in New Individuals Popup");
		} else {
			log(Status.FAIL, "Preference tab is not displayed in New Individuals Popup");
			throw new Exception("Assertion Failed");
		}

	}

	@Then("User should verify that able to upload different file formats except jpg, jpeg, png")
	public void user_should_verify_that_able_to_upload_different_file_formats_except_jpg_jpeg_png() {

		logStep(methodName());

		pom.getAddIndividualsPage().unSupportedImgFormatUpload("JFIF Format", "jfif");
	}

	@Then("User should verify that able to upload more than 1MB Image file")
	public void user_should_verify_that_able_to_upload_more_than_1MB_Image_file() {

		logStep(methodName());

		pom.getAddIndividualsPage().moreThan1MBImgFormatUpload("MoreThan1MB", "jpg");

	}

	@Then("User should upload image in photo tab section")
	public void user_should_upload_image_in_photo_tab_section() throws Exception {

		logStep(methodName());
		
		pom.getAddIndividualsPage().Upload("JPG", "jpg");
	}

	@Then("User should verify the navigation arrows and validation message for Mandatory fields are working as expected {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void user_should_verify_the_navigation_arrows_and_validation_message_for_mandatory_fields_are_working_as_expected(
			String IndFN, String IndLN, String Gender, String DOB, String Suite, String ResAddress, String MailAddress,
			String EmFN, String EmLN, String EmRelationship, String EmPhNo) throws Exception {

		logStep(methodName());

		pom.getAddIndividualsPage().forwardArrowToAddressSection();

		if (pom.getAddIndividualsPage().getResidentialAddressLabelName().isDisplayed()) {
			log(Status.PASS, "Forward arrow -> button is working in Identification tab");
		} else {
			log(Status.FAIL, "Forward arrow -> button is not working in Identification tab");
			throw new Exception();
		}

		pom.getAddIndividualsPage().forwardArrowToPreferenceSection();

		if (pom.getAddIndividualsPage().getNickNameLabel().isDisplayed()) {
			log(Status.PASS, "Forward arrow -> button is working in Address tab");
		} else {
			log(Status.FAIL, "Forward arrow -> button is not working in Address tab");
			throw new Exception();
		}

		pom.getAddIndividualsPage().forwardToConfirmPage();

		if (pom.getAddIndividualsPage().getConfirmBtn().isEnabled()) {
			log(Status.PASS, "Forward arrow -> button is working in Preference tab");

			pom.getAddIndividualsPage().confirm();
		} else {
			log(Status.FAIL, "Forward arrow -> button is not working in Preference tab");
			throw new Exception();
		}

		try {
			Assert.assertEquals("[Please provide valid data/ *Required field] toast msg is not displayed",
					"Please provide valid data / Enter all required fields",
					getText(pom.getAddIndividualsPage().getValidDataAndEnterAllReqFieldsToastMsg()));
			log(Status.PASS, "*Required field toastbar msg is displayed as expected - "
					+ getText(pom.getAddIndividualsPage().getValidDataAndEnterAllReqFieldsToastMsg()));

		} catch (AssertionError e) {
			log(Status.FAIL, "*Required field toastbar msg is displayed as expected");
		}

		pom.getAddIndividualsPage().toastMsgOKButton().back();

		if (pom.getAddIndividualsPage().getNickNameLabel().isDisplayed()) {
			log(Status.PASS, "Back button is working in Confirm tab");
		} else {
			log(Status.FAIL, "Back button is NOT working in Confirm tab");
			throw new Exception();
		}

		try {
			Assert.assertEquals("MF validation message is NOT displayed for Em.Contact FirstName* field", EmFN,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactFNField()));
			log(Status.PASS, "MF validation message is displayed for Em.Contact FirstName* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactFNField()));

		} catch (AssertionError e) {
			log(Status.FAIL, "MF validation message is NOT displayed for Em.Contact FirstName* field");
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("MF validation message is NOT displayed for Em.Contact LastName* field", EmLN,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactLNField()));
			log(Status.PASS, "MF validation message is displayed for Em.Contact LastName* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactLNField()));

		} catch (AssertionError e) {
			log(Status.FAIL, "MF validation message is NOT displayed for Em.Contact LastName* field");
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("MF validation message is NOT displayed for Em.Contact Relationship* field",
					EmRelationship,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactRelationshipField()));
			log(Status.PASS, "MF validation message is displayed for Em.Contact Relationship* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactRelationshipField()));

		} catch (AssertionError e) {
			log(Status.FAIL, "MF validation message is NOT displayed for Em.Contact Relationship* field");
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("MF validation message is NOT displayed for Em.Contact Ph.No* field", EmPhNo,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactPhNoField()));
			log(Status.PASS, "MF validation message is displayed for Em.Contact Ph.No* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactPhNoField()));

		} catch (AssertionError e) {
			log(Status.FAIL, "MF validation message is NOT displayed for Em.Contact Ph.No* field");
			e.printStackTrace();
		}

		pom.getAddIndividualsPage().backwardArrowToAddressSection();

		if (pom.getAddIndividualsPage().getResidentialAddressLabelName().isDisplayed()) {
			log(Status.PASS, "Backward arrow <- button is working in Preference tab");
		} else {
			log(Status.FAIL, "Backward arrow <- button is not working in Preference tab");
			throw new Exception();
		}

		try {
			Assert.assertEquals("MF validation message is NOT displayed for Residential Address* field", ResAddress,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForResidentialAddressField()));
			log(Status.PASS, "MF validation message is displayed for Residential Address* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForResidentialAddressField()));

		} catch (AssertionError e) {
			log(Status.FAIL, "MF validation message is NOT displayed for Residential Address* field");
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("MF validation message is NOT displayed for Mailing Address* field", MailAddress,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForMailingAddressField()));
			log(Status.PASS, "MF validation message is displayed for Mailing Address* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForMailingAddressField()));

		} catch (AssertionError e) {
			log(Status.FAIL, "MF validation message is NOT displayed for Mailing Address* field");
			e.printStackTrace();
		}

		pom.getAddIndividualsPage().backwardArrowToIdentificationSection();

		if (pom.getAddIndividualsPage().getTitleLabelName().isDisplayed()) {
			log(Status.PASS, "Backward arrow <- button is working in Address tab");
		} else {
			log(Status.FAIL, "Backward arrow <- button is not working in Address tab");
			throw new Exception();
		}

		try {
			Assert.assertEquals("MF validation message is NOT displayed for Individual FirstName* field", IndFN,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForIndFNField()));
			log(Status.PASS, "MF validation message is displayed for Individual FirstName* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForIndFNField()));

		} catch (AssertionError e) {
			log(Status.FAIL, "MF validation message is NOT displayed for Individual FirstName* field");
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("MF validation message is NOT displayed for Individual LastName* field", IndLN,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForIndLNField()));
			log(Status.PASS, "MF validation message is displayed for Individual LastName* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForIndLNField()));

		} catch (AssertionError e) {
			log(Status.FAIL, "MF validation message is NOT displayed for Individual LastName* field");
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("MF validation message is NOT displayed for Gender* field", Gender,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForGenderField()));
			log(Status.PASS, "MF validation message is displayed for Gender* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForGenderField()));

		} catch (AssertionError e) {
			log(Status.FAIL, "MF validation message is NOT displayed for Gender* field");
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("MF validation message is NOT displayed for DOB* field", DOB,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForDOBField()));
			log(Status.PASS, "MF validation message is displayed for DOB* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForDOBField()));

		} catch (AssertionError e) {
			log(Status.FAIL, "MF validation message is NOT displayed for DOB* field");
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("MF validation message is NOT displayed for Suite* field", Suite,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForSuiteField()));
			log(Status.PASS, "MF validation message is displayed for Suite* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForSuiteField()));

		} catch (AssertionError e) {
			log(Status.FAIL, "MF validation message is NOT displayed for Suite* field");
			e.printStackTrace();
		}

		pom.getAddIndividualsPage().backwardArrowToPhotoSection();

		if (pom.getAddIndividualsPage().getCapture().isEnabled()) {

			log(Status.PASS, "Backward arrow <- button is working in Identification tab");
		} else {
			log(Status.FAIL, "Backward arrow <- button is not working in Identification tab");
			throw new Exception();
		}
	}

	@Then("User should Add Individual by perform only non mandatory fields")
	public void user_should_add_individual_by_perform_only_non_mandatory_fields() throws Exception {

		logStep(methodName());
		
		pom.getAddIndividualsPage().identificationTab().title(1).middleName(1).suffix(1).race(1).maritalStatus(1)
				.addressTab();

		if (pom.getAddIndividualsPage().getResidentialAddressLabelName().isDisplayed()) {
			log(Status.PASS, "Address TAB button is working as expected");
		} else {
			log(Status.FAIL, "Forward arrow -> button is NOT working as expected");
			throw new Exception();
		}

		pom.getAddIndividualsPage().preferenceTab().nickName(1).pronoun(1).ethnicAffiliation(1).preferredLanguage(1)
				.Religion(1).forwardToConfirmPage();

		if (pom.getAddIndividualsPage().getConfirmBtn().isEnabled()) {
			pom.getAddIndividualsPage().confirm();
			log(Status.PASS, "Forward arrow -> button is working in Preference tab");
		} else {
			log(Status.FAIL, "Forward arrow -> button is not working in Preference tab");
			throw new Exception();
		}
	}

	@Then("User should verify the Required field toast message {string}")
	public void user_should_verify_the_required_field_toast_message(String expRequiredFieldToastMsg) {

		 logStep(methodName());
		 
		try {
			
          waitForVisiblityOfElement(pom.getAddIndividualsPage().getValidDataAndEnterAllReqFieldsToastMsg(), 5);
			Assert.assertEquals("[Please provide valid data/ *Required field] toast msg is not displayed",
					expRequiredFieldToastMsg,
					getText(pom.getAddIndividualsPage().getValidDataAndEnterAllReqFieldsToastMsg()));
			log(Status.PASS, "*Required field toastbar msg is displayed as expected - "
					+ getText(pom.getAddIndividualsPage().getValidDataAndEnterAllReqFieldsToastMsg()));

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		pom.getAddIndividualsPage().toastMsgOKButton();
	}

	@Then("User should verify the limit validation error message for First Name* field in identification tab section {string}")
	public void user_should_verify_the_limit_validation_error_message_for_first_name_field_in_identification_tab_section(
			String expValidationMsgForFrstName) {

		logStep(methodName());

		waitForFullPageElementLoad();
		pom.getAddIndividualsPage().back();
		pom.getAddIndividualsPage().identificationTab();
		pom.getAddIndividualsPage().invalidFirstName();

		waitForVisiblityOfElement(pom.getAddIndividualsPage().getLimitValMsgForFrstName(), 5);

		try {
			Assert.assertEquals("Limit validation msg for FirstName* field is not displayed",
					expValidationMsgForFrstName, getText(pom.getAddIndividualsPage().getLimitValMsgForFrstName()));
			log(Status.PASS, "Limit validation msg for FirstName* field is displayed - "
					+ getText(pom.getAddIndividualsPage().getLimitValMsgForFrstName()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should verify the limit validation error message for Middle Name* field in identification tab section {string}")
	public void user_should_verify_the_limit_validation_error_message_for_middle_name_field_in_identification_tab_section(
			String expValidationMsgForMiddleName) {

		logStep(methodName());

		pom.getAddIndividualsPage().invalidMiddleName();

		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getLimitValMsgForMiddleName(), 5);

			Assert.assertEquals("Limit validation msg for MiddleName* field is not displayed",
					expValidationMsgForMiddleName, getText(pom.getAddIndividualsPage().getLimitValMsgForMiddleName()));
			log(Status.PASS, "Limit validation msg for MiddleName* field is displayed - "
					+ getText(pom.getAddIndividualsPage().getLimitValMsgForMiddleName()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("User should verify the limit validation error message for Last Name* field in identification tab section {string}")
	public void user_should_verify_the_limit_validation_error_message_for_last_name_field_in_identification_tab_section(
			String expValidationMsgForLastName) {

		logStep(methodName());

		pom.getAddIndividualsPage().invalidLastName();

		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getLimitValMsgForLastName(), 5);

			Assert.assertEquals("Limit validation msg for LastName* field is not displayed",
					expValidationMsgForLastName, getText(pom.getAddIndividualsPage().getLimitValMsgForLastName()));
			log(Status.PASS, "Limit validation msg for LastName* field is displayed - "
					+ getText(pom.getAddIndividualsPage().getLimitValMsgForLastName()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should perform only mandatory fields in identification tab")
	public void user_should_perform_only_mandatory_fields_in_identification_tab() throws Exception {

		logStep(methodName());

		deleteExistFieldData(pom.getAddIndividualsPage().getFirstName());
		deleteExistFieldData(pom.getAddIndividualsPage().getMiddleName());
		deleteExistFieldData(pom.getAddIndividualsPage().getLastName());

		pom.getAddIndividualsPage().firstName(1).middleName(1).lastName(1).gender(1).dob(1).selectSuiteForS1();

		String getExpLastName = getAttribute(pom.getAddIndividualsPage().getLastName(), "value");

		writeExcelToOverwrite("Test Datas", "AddIndividuals", 1, 21, getExpLastName);

	}

	@Then("User should click the address tab")
	public void user_should_click_the_address_tab() {

		logStep(methodName());

		pom.getAddIndividualsPage().addressTab();
	}

	@Then("User should perform Address in Residential Address * field")
	public void user_should_perform_address_in_residential_address_field() {

		logStep(methodName());

		pom.getAddIndividualsPage().residentialAddress(1);
	}

	@Then("User should tick the Same as Residential address checkbox")
	public void user_should_tick_the_same_as_residential_address_checkbox() {

		logStep(methodName());

		pom.getAddIndividualsPage().sameAsResiAdresscheckBox();
	}
	
	@Then("User should verify the Residential Address * and Mailing Address * fields values are same")
	public void user_should_verify_the_residential_address_and_mailing_address_fields_values_are_same()
			throws Exception {

		logStep(methodName());

		String residentialAddress = getText(pom.getAddIndividualsPage().getResidentialAddress());
		String mailingAddress = getText(pom.getAddIndividualsPage().getMailingAddress());

		if (residentialAddress.equals(mailingAddress)) {
			log(Status.PASS, "Same as Residential address checkbox is working as expected");
		} else {
			log(Status.FAIL, "Same as Residential address checkbox is not working as expected");
			throw new Exception();
		}

	}

	
	@Then("User should uncheck the Same as Residential address checkbox")
	public void user_should_uncheck_the_same_as_residential_address_checkbox() {

		logStep(methodName());

		pom.getAddIndividualsPage().sameAsResiAdresscheckBox();
	}

	@Then("User should enter address in Mailing Address * field")
	public void user_should_enter_address_in_mailing_address_field() {

		logStep(methodName());

		pom.getAddIndividualsPage().MailingAddress(1);
	}

	
	@Then("User should tick the same as Residential address after entering different address in Mailing address")
	public void user_should_tick_the_same_as_residential_address_after_entering_different_address_in_mailing_address() {
	
	logStep(methodName());

	pom.getAddIndividualsPage().sameAsResiAdresscheckBox();
	
	}
	
	
	
	
	@Then("User should verify the validation error message for Mailing Address * field {string}")
	public void user_should_verify_the_validation_error_message_for_mailing_address_field(
			String expValidationMsgForMailingAddress) {

		logStep(methodName());

		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getValidationErrMsgForMailingAddressField(), 5);

			Assert.assertEquals("Validation error message for Mailing Address * field is not displayed",
					expValidationMsgForMailingAddress,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForMailingAddressField()));
			log(Status.PASS, "Validation error message for Mailing Address * field is displayed - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForMailingAddressField()));
		} catch (AssertionError e) {
			log(Status.FAIL, "Validation error message for Mailing Address * field is not displayed");
			e.printStackTrace();
		}

	}

	@Then("User should delete the Residential Address * field data")
	public void user_should_delete_the_residential_address_field_data() {

		logStep(methodName());

		deleteExistFieldData(pom.getAddIndividualsPage().getResidentialAddress());
	}

	@Then("User should verify the validation error message for Residential Address * field {string}")
	public void user_should_verify_the_validation_error_message_for_residential_address_field(
			String expValidationMsgForResidentialAddress) {

		logStep(methodName());

		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getValidationErrMsgForResidentialAddressField(), 5);

			Assert.assertEquals("Validation error message for Residential Address * field is not displayed",
					expValidationMsgForResidentialAddress,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForResidentialAddressField()));
			log(Status.PASS, "Validation error message for Residential Address * field is displayed - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForResidentialAddressField()));
		} catch (AssertionError e) {
			log(Status.FAIL, "Validation error message for Residential Address * field is not displayed");
			e.printStackTrace();
		}

		pom.getAddIndividualsPage().residentialAddress(1).sameAsResiAdresscheckBox();
	}

	@Then("User should verify the first, middle, last and dob is displayed in Address tab section")
	public void user_should_verify_the_first_middle_last_and_dob_is_displayed_in_address_tab_section()
			throws Exception {

		logStep(methodName());

		String firstName = readExcel("Test Datas", "AddIndividuals", 1, 0);
		String middleName = readExcel("Test Datas", "AddIndividuals", 1, 1);
		String lastName = readExcel("Test Datas", "AddIndividuals", 1, 21);

		String expdate = readExcel("Test Datas", "AddIndividuals", 1, 5);

		String expDob = expdate.replaceAll("/", "-");

		String expIndName = firstName + " " + middleName + " " + lastName;
		writeExcelToOverwrite("Test Datas", "AddIndividuals", 1, 26, expIndName);

		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getIndividualNameInAddressTabVerification(), 5);
            waitForFullPageElementLoad();
			Assert.assertEquals("First,Middle & Last Name is not displayed in Address tab section", expIndName,
					getText(pom.getAddIndividualsPage().getIndividualNameInAddressTabVerification()));
			log(Status.PASS, "First,Middle & Last Name is displayed in Address tab section Ind Name - "
					+ getText(pom.getAddIndividualsPage().getIndividualNameInAddressTabVerification()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getIndividualDOBInAddressTabVerification(), 5);
			waitForFullPageElementLoad();
			Assert.assertEquals("DOB is not displayed in Address tab section", expDob,
					getText(pom.getAddIndividualsPage().getIndividualDOBInAddressTabVerification()));
			log(Status.PASS, "DOB is displayed in Address tab section Ind DOB - "
					+ getText(pom.getAddIndividualsPage().getIndividualDOBInAddressTabVerification()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("User should verify the first, middle, last name, dob and mailing address are displayed in Preference tab section")
	public void user_should_verify_the_first_middle_last_name_dob_and_mailing_address_are_displayed_in_preference_tab_section()
			throws Exception {

		logStep(methodName());

		pom.getAddIndividualsPage().preferenceTab();

		String expdate = readExcel("Test Datas", "AddIndividuals", 1, 5);

		String expDob = expdate.replaceAll("/", "-");

		String expIndName = readExcel("Test Datas", "AddIndividuals", 1, 26);

		String expAddress = readExcel("Test Datas", "AddIndividuals", 1, 10);

		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getIndividualNameInPreferenceTabVerification(), 5);
			waitForFullPageElementLoad();
			Assert.assertEquals("First,Middel & Last Name is not displayed in Preference tab section", expIndName,
					getText(pom.getAddIndividualsPage().getIndividualNameInPreferenceTabVerification()));
			log(Status.PASS, "First,Middel & Last Name is displayed in Preference tab section Ind Name - "
					+ getText(pom.getAddIndividualsPage().getIndividualNameInPreferenceTabVerification()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getIndividualDOBInPreferenceTabVerification(), 5);
			waitForFullPageElementLoad();
			Assert.assertEquals("DOB is not displayed in Preference tab section", expDob,
					getText(pom.getAddIndividualsPage().getIndividualDOBInPreferenceTabVerification()));
			log(Status.PASS, "DOB is displayed in Preference tab section Ind DOB - "
					+ getText(pom.getAddIndividualsPage().getIndividualDOBInPreferenceTabVerification()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getIndividualAddressInPreferenceTabVerification(), 5);
			waitForFullPageElementLoad();
			Assert.assertEquals("Address is not displayed in Preference tab section", expAddress,
					getText(pom.getAddIndividualsPage().getIndividualAddressInPreferenceTabVerification()));
			log(Status.PASS, "Address is displayed in Preference tab section Ind Address - "
					+ getText(pom.getAddIndividualsPage().getIndividualAddressInPreferenceTabVerification()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("User should perform Add another emergency contact1")
	public void user_should_perform_add_another_emergency_contact1() throws Exception {

		logStep(methodName());

		pom.getAddIndividualsPage().preferenceTab().ecFNForLimitVal().ecLNForLimitVal().ecRelationship(1)
				.ecPhoneNumber(1);
	}

	@Then("User should verify the limit validation error message in Emergency Contact1 First Name* field {string}")
	public void user_should_verify_the_limit_validation_error_message_in_emergency_contact1_first_name_field(
			String expValidationMsgForFrstName) {

		logStep(methodName());
		
		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getLimitValMsgForFrstName(), 5);
			waitForFullPageElementLoad();
			Assert.assertEquals("Limit validation msg for FirstName* field is not displayed",
					expValidationMsgForFrstName, getText(pom.getAddIndividualsPage().getLimitValMsgForFrstName()));
			log(Status.PASS, "Limit validation msg for FirstName* field is displayed - "
					+ getText(pom.getAddIndividualsPage().getLimitValMsgForFrstName()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		deleteExistFieldData(pom.getAddIndividualsPage().getEmergencyContact1FN());
		pom.getAddIndividualsPage().ecFirstName(1);

	}

	@Then("User should verify the limit validation error message in Emergency Contact1 Last Name* field {string}")
	public void user_should_verify_the_limit_validation_error_message_in_emergency_contact1_last_name_field(
			String expValidationMsgForLastName) {

		logStep(methodName());
		
		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getLimitValMsgForLastName(), 5);
			waitForFullPageElementLoad();
			Assert.assertEquals("Limit validation msg for LastName* field is not displayed",
					expValidationMsgForLastName, getText(pom.getAddIndividualsPage().getLimitValMsgForLastName()));
			log(Status.PASS, "Limit validation msg for LastName* field is displayed - "
					+ getText(pom.getAddIndividualsPage().getLimitValMsgForLastName()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		deleteExistFieldData(pom.getAddIndividualsPage().getEmergencyContact1LN());
		pom.getAddIndividualsPage().ecLastName(1);
	}
	
//	@Then("User should click Add another emergency contact")
//	public void user_should_click_add_another_emergency_contact() {
// 
//		logStep(methodName());
//		pom.getAddIndividualsPage().addEmergencyContact();
//	}

	@Then("User should perform firstName* and lastName* fields in Add another emergency contact2")
	public void user_should_perform_first_name_and_last_name_fields_in_add_another_emergency_contact2() {

		logStep(methodName());
		
		pom.getAddIndividualsPage().ec2FNForLimitVal().ecLN2ForLimitVal();
	}

	@Then("User should verify the limit validation error message in Emergency Contact2 First Name* field {string}")
	public void user_should_verify_the_limit_validation_error_message_in_emergency_contact2_first_name_field(
			String expValidationMsgForFrstName) {

		logStep(methodName());
		
		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getLimitValMsgForFrstName(), 5);
			waitForFullPageElementLoad();
			Assert.assertEquals("Limit validation msg for FirstName* field is not displayed",
					expValidationMsgForFrstName, getText(pom.getAddIndividualsPage().getLimitValMsgForFrstName()));
			log(Status.PASS, "Limit validation msg for FirstName* field is displayed - "
					+ getText(pom.getAddIndividualsPage().getLimitValMsgForFrstName()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should verify the limit validation error message in Emergency Contact2 Last Name* field {string}")
	public void user_should_verify_the_limit_validation_error_message_in_emergency_contact2_last_name_field(
			String expValidationMsgForLastName) {

		logStep(methodName());
		
		try {

			waitForVisiblityOfElement(pom.getAddIndividualsPage().getLimitValMsgForLastName(), 5);
			waitForFullPageElementLoad();
			Assert.assertEquals("Limit validation msg for LastName* field is not displayed",
					expValidationMsgForLastName, getText(pom.getAddIndividualsPage().getLimitValMsgForLastName()));
			log(Status.PASS, "Limit validation msg for LastName* field is displayed - "
					+ getText(pom.getAddIndividualsPage().getLimitValMsgForLastName()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should verify the mandatory field validation error message in Emergency Contact2 {string}, {string}, {string}, {string}")
	public void user_should_verify_the_mandatory_field_validation_error_message_in_emergency_contact2(String EmFN,
			String EmLN, String EmRelationship, String EmPhNo) {

		logStep(methodName());
		
		deleteExistFieldData(pom.getAddIndividualsPage().getEmergencyContact2FN());
		deleteExistFieldData(pom.getAddIndividualsPage().getEmergencyContact2LN());

		pom.getAddIndividualsPage().forwardToConfirmPage().confirm().toastMsgOKButton().back();

		try {

			waitForVisiblityOfElement(pom.getAddIndividualsPage().getValidationErrMsgForEmContactFNField(), 5);
			waitForFullPageElementLoad();
			Assert.assertEquals("MF validation message is NOT displayed for Em.Contact2 FirstName* field", EmFN,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactFNField()));
			log(Status.PASS, "MF validation message is displayed for Em.Contact2 FirstName* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactFNField()));

		} catch (AssertionError e) {
			log(Status.FAIL, "MF validation message is NOT displayed for Em.Contact2 FirstName* field");
			e.printStackTrace();
		}
		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getValidationErrMsgForEmContactLNField(), 5);

			Assert.assertEquals("MF validation message is NOT displayed for Em.Contact2 LastName* field", EmLN,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactLNField()));
			log(Status.PASS, "MF validation message is displayed for Em.Contact2 LastName* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactLNField()));

		} catch (AssertionError e) {
			log(Status.FAIL, "MF validation message is NOT displayed for Em.Contact2 LastName* field");
			e.printStackTrace();
		}

		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getValidationErrMsgForEmContactRelationshipField(),
					5);
			waitForFullPageElementLoad();
			Assert.assertEquals("MF validation message is NOT displayed for Em.Contact2 Relationship* field",
					EmRelationship,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactRelationshipField()));
			log(Status.PASS, "MF validation message is displayed for Em.Contact2 Relationship* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactRelationshipField()));

		} catch (AssertionError e) {
			log(Status.FAIL, "MF validation message is NOT displayed for Em.Contact2 Relationship* field");
			e.printStackTrace();
		}

		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getValidationErrMsgForEmContactPhNoField(), 5);
			waitForFullPageElementLoad();
			Assert.assertEquals("MF validation message is NOT displayed for Em.Contact2 Ph.No* field", EmPhNo,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactPhNoField()));
			log(Status.PASS, "MF validation message is displayed for Em.Contact2 Ph.No* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactPhNoField()));

		} catch (AssertionError e) {
			log(Status.FAIL, "MF validation message is NOT displayed for Em.Contac2t Ph.No* field");
			e.printStackTrace();
		}

	}

	@Then("User should perform all the fields in Emergency Contact2")
	public void user_should_perform_all_the_fields_in_emergency_contact2() {

		logStep(methodName());
		
		pom.getAddIndividualsPage().ec2FirstName(1).ec2LastName(1).ec2Relationship(1).ec2PhoneNumber(1);
	}
	
//	@Then("User should verify the emergency contact label names")
//	public void user_should_verify_the_emergency_contact_label_names() throws Exception {
// 
//		logStep(methodName());
//		String EC1 = getText(pom.getAddIndividualsPage().getEmergencyContact1LabelName());
// 
//		if (EC1.contains("Emergency Contact 1")) {
//			log(Status.PASS, "Emergency contact1 label names is displayed as expected - " + EC1);
//		} else {
//			log(Status.FAIL, "Emergency contact1 label names is NOT displayed as expected - " + EC1);
//			throw new Exception();
//		}
// 
//		String EC2 = getText(pom.getAddIndividualsPage().getEmergencyContact2LabelName());
// 
//		if (EC2.contains("Emergency Contact 2")) {
//			log(Status.PASS, "Emergency contact2 label names is displayed as expected - " + EC2);
//		} else {
//			log(Status.FAIL, "Emergency contact2 label names is NOT displayed as expected - " + EC2);
//			throw new Exception();
//		}
// 
//	}
//	
	

	@Then("User should perform firstName* and lastName* fields in Add another emergency contact3")
	public void user_should_perform_first_name_and_last_name_fields_in_add_another_emergency_contact3() {

		logStep(methodName());
		
		pom.getAddIndividualsPage().ec3FNForLimitVal().ec3LNForLimitVal();
	}

	@Then("User should verify the limit validation error message in Emergency Contact3 First Name* field {string}")
	public void user_should_verify_the_limit_validation_error_message_in_emergency_contact3_first_name_field(
			String expValidationMsgForFrstName) {

		logStep(methodName());
		
		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getLimitValMsgForFrstName(), 5);
			waitForFullPageElementLoad();
			Assert.assertEquals("Limit validation msg for FirstName* field is not displayed",
					expValidationMsgForFrstName, getText(pom.getAddIndividualsPage().getLimitValMsgForFrstName()));
			log(Status.PASS, "Limit validation msg for FirstName* field is displayed - "
					+ getText(pom.getAddIndividualsPage().getLimitValMsgForFrstName()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should verify the limit validation error message in Emergency Contact3 Last Name* field {string}")
	public void user_should_verify_the_limit_validation_error_message_in_emergency_contact3_last_name_field(
			String expValidationMsgForLastName) {

		logStep(methodName());
		
		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getLimitValMsgForLastName(), 5);
			waitForFullPageElementLoad();
			Assert.assertEquals("Limit validation msg for LastName* field is not displayed",
					expValidationMsgForLastName, getText(pom.getAddIndividualsPage().getLimitValMsgForLastName()));
			log(Status.PASS, "Limit validation msg for LastName* field is displayed - "
					+ getText(pom.getAddIndividualsPage().getLimitValMsgForLastName()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should verify the mandatory field validation error message in Emergency Contact3 {string}, {string}, {string}, {string}")
	public void user_should_verify_the_mandatory_field_validation_error_message_in_emergency_contact3(String EmFN,
			String EmLN, String EmRelationship, String EmPhNo) {

		logStep(methodName());
		
		deleteExistFieldData(pom.getAddIndividualsPage().getEmergencyContact3FN());
		deleteExistFieldData(pom.getAddIndividualsPage().getEmergencyContact3LN());

		pom.getAddIndividualsPage().forwardToConfirmPage().confirm().toastMsgOKButton().back();

		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getValidationErrMsgForEmContactFNField(), 5);
			waitForFullPageElementLoad();
			Assert.assertEquals("MF validation message is NOT displayed for Em.Contact3 FirstName* field", EmFN,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactFNField()));
			log(Status.PASS, "MF validation message is displayed for Em.Contact3 FirstName* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactFNField()));

		} catch (AssertionError e) {
			log(Status.FAIL, "MF validation message is NOT displayed for Em.Contact3 FirstName* field");
			e.printStackTrace();
		}

		try {

			waitForVisiblityOfElement(pom.getAddIndividualsPage().getValidationErrMsgForEmContactLNField(), 5);
			waitForFullPageElementLoad();
			Assert.assertEquals("MF validation message is NOT displayed for Em.Contact3 LastName* field", EmLN,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactLNField()));
			log(Status.PASS, "MF validation message is displayed for Em.Contact3 LastName* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactLNField()));

		} catch (AssertionError e) {
			log(Status.FAIL, "MF validation message is NOT displayed for Em.Contact3 LastName* field");
			e.printStackTrace();
		}

		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getValidationErrMsgForEmContactRelationshipField(),
					5);
			waitForFullPageElementLoad();
			Assert.assertEquals("MF validation message is NOT displayed for Em.Contact3 Relationship* field",
					EmRelationship,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactRelationshipField()));
			log(Status.PASS, "MF validation message is displayed for Em.Contact3 Relationship* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactRelationshipField()));

		} catch (AssertionError e) {
			log(Status.FAIL, "MF validation message is NOT displayed for Em.Contact3 Relationship* field");
			e.printStackTrace();
		}
		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getValidationErrMsgForEmContactPhNoField(), 5);
			waitForFullPageElementLoad();
			Assert.assertEquals("MF validation message is NOT displayed for Em.Contact3 Ph.No* field", EmPhNo,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactPhNoField()));
			log(Status.PASS, "MF validation message is displayed for Em.Contact3 Ph.No* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactPhNoField()));

		} catch (AssertionError e) {
			log(Status.FAIL, "MF validation message is NOT displayed for Em.Contact3 Ph.No* field");
			e.printStackTrace();
		}

	}

	@Then("User should able to delete the emergency contact3")
	public void user_should_able_to_delete_the_emergency_contact3() {

		logStep(methodName());
		
		pom.getAddIndividualsPage().xBtnInEmContact2();
	}

	@Then("User should verify the emergency contact3 is closed")
	public void user_should_verify_the_emergency_contact3_is_closed() throws Exception {

		logStep(methodName());
		
		if (pom.getAddIndividualsPage().getEmContact3CloseBtn().isDisplayed()) {
			log(Status.FAIL, "Emergency contact2 is NOT closed");
			throw new Exception();
		} else {
			log(Status.PASS, "Emergency contact2 is closed successfully");
		}
	}

	@Then("User should able to delete the emergency contact2")
	public void user_should_able_to_delete_the_emergency_contact2() {

		logStep(methodName());
		
		pom.getAddIndividualsPage().xBtnInEmContact2();
	}

	@Then("User should verify the emergency contact2 is closed")
	public void user_should_verify_the_emergency_contact2_is_closed() throws Exception {

		logStep(methodName());
		
		if (pom.getAddIndividualsPage().getEmContact2CloseBtn().isDisplayed()) {
			log(Status.FAIL, "EC3 -> EC2 Emergency contact2 is NOT closed");
			throw new Exception();
		} else {
			log(Status.PASS, "EC3 -> EC2 Emergency contact2 is closed successfully");
		}

	}

	@Then("User should verify the tabticks in Identification, Address and Preference tab sections")
	public void user_should_verify_the_tabticks_in_identification_address_and_preference_tab_sections() {

		logStep(methodName());

		if (pom.getAddIndividualsPage().getIdentificationTabTick().isDisplayed()
				&& pom.getAddIndividualsPage().getAddressTabTick().isDisplayed()
				&& pom.getAddIndividualsPage().getPreferenceTabTick().isDisplayed()) {
			log(Status.PASS, "Tab Ticks are displayed as expected");
		} else {
			log(Status.FAIL, "Tab Ticks are NOT displayed as expected");
		}
	}

	@Then("User should verify the First, middle and last name, DOB, mailing address and Phone Number are displayed in confirm form screen")
	public void user_should_verify_the_first_middle_and_last_name_dob_mailing_address_and_phone_number_are_displayed_in_confirm_form_screen()
			throws Exception {

		logStep(methodName());

		pom.getAddIndividualsPage().forwardToConfirmPage();

		String expdate = readExcel("Test Datas", "AddIndividuals", 1, 5);

		String expDob = expdate.replaceAll("/", "-");

		String expIndName = readExcel("Test Datas", "AddIndividuals", 1, 26);

		String splitPhNum = readExcel("Test Datas", "AddIndividuals", 2, 20);

		String frst3Num = splitPhNum.substring(0, 3);
		String middle3Num = splitPhNum.substring(3, 6);
		String last4Num = splitPhNum.substring(6, 10);
		String expPhoneNumber = "(" + frst3Num + ") ".concat(middle3Num) + "-".concat(last4Num);

		String expAddress = readExcel("Test Datas", "AddIndividuals", 1, 10);

		try {
			Assert.assertEquals("First,Middel & Last Name is not displayed in Confirm tab section", expIndName,
					getText(pom.getAddIndividualsPage().getIndividualNameInConfirmTabVerification()));
			log(Status.PASS, "First,Middel & Last Name is displayed in Confirm tab section Ind Name - "
					+ getText(pom.getAddIndividualsPage().getIndividualNameInConfirmTabVerification()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getIndividualDOBInConfirmTabVerification(), 5);

			Assert.assertEquals("DOB is not displayed in Confirm tab section", expDob,
					getText(pom.getAddIndividualsPage().getIndividualDOBInConfirmTabVerification()));
			log(Status.PASS, "DOB is displayed in Confirm tab section Ind DOB - "
					+ getText(pom.getAddIndividualsPage().getIndividualDOBInConfirmTabVerification()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getIndividualAddressInConfirmTabVerification(), 5);

			Assert.assertEquals("Address is not displayed in Confirm tab section", expAddress,
					getText(pom.getAddIndividualsPage().getIndividualAddressInConfirmTabVerification()));
			log(Status.PASS, "Address is displayed in Confirm tab section Ind Address - "
					+ getText(pom.getAddIndividualsPage().getIndividualAddressInConfirmTabVerification()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getIndividualPhoneNumInConfirmTabVerification(), 5);

			Assert.assertEquals("Phone  Number is not displayed in Confirm tab section", expPhoneNumber,
					getText(pom.getAddIndividualsPage().getIndividualPhoneNumInConfirmTabVerification()));
			log(Status.PASS, "Phone  Number is displayed in Confirm tab section Ind Name - "
					+ getText(pom.getAddIndividualsPage().getIndividualPhoneNumInConfirmTabVerification()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}
	
	
@And("User should perform emergency contact1 with different phone number")
public void User_should_perform_emergency_contact1_with_different_phone_number() {

	logStep(methodName());

//	pom.getAddIndividualsPage().back()
//			.deleteExistPhoneData(pom.getAddIndividualsPage().getEmergencyContact1PhoneNo());

	try {
		pom.getAddIndividualsPage().ecPhoneNumber(1).forwardToConfirmPage().confirm();
	} catch (Exception e) {
		e.printStackTrace();
	}

}
	
	@Then("User should verify the {string}, {string} buttons is enabled in Photo tab Section")
	public void user_should_verify_the_buttons_is_enabled_in_photo_tab_section(String string, String string2) {

		logStep(methodName());

		if (getConfigureProperty("ImageUpload").equalsIgnoreCase("No")) {

			String uploadBtn = getAttribute(pom.getAddIndividualsPage().getUploadBtnEnabled(), "ng-reflect-disabled");
			String captureBtn = getAttribute(pom.getAddIndividualsPage().getCapturedBtnEnabled(),
					"ng-reflect-disabled");

			if (uploadBtn.equalsIgnoreCase("false") && captureBtn.equalsIgnoreCase("false")) {
				log(Status.PASS, "the Upload and Capture button is Enabled in photo tab section");
			} else {
				log(Status.FAIL, "Upload and Capture button is NOT Enabled in photo tab section");
			}
		}
	}

	@Then("User should click on the calendar icon")
	public void user_should_click_on_the_calendar_icon() {

		logStep(methodName());

	//	pom.getAddIndividualsPage().back().identificationTab();

		deleteExistFieldData(pom.getAddIndividualsPage().getDob());
		pom.getAddIndividualsPage().datePicker();

	}

	@Then("User should verify the date picker should appeared")
	public void user_should_verify_the_date_picker_should_appeared() throws Exception {

		logStep(methodName());

		if (getCurrentDtYearMonth("MMM yyyy").contains(getText(pom.getAddIndividualsPage().getDatePicker()))) {
			log(Status.PASS, "Date picker is defaultly appeared in current month & year");
		} else {
			log(Status.FAIL, "Date picker is defaultly NOT appeared in current month & year");
			throw new Exception();
		}

	}
	
	@Then("User should verify future dates are hidden")
	public void user_should_verify_future_dates_are_hidden() throws Exception {

		logStep(methodName());

			pom.getAddIndividualsPage().futureDatesAreHidden();
		
	}

	@Then("User should select a valid date in date picker and verify the selected date should be displayed in the DOB * field")
	public void user_should_select_a_valid_date_in_date_picker_and_verify_the_selected_date_should_be_displayed_in_the_dob_field() throws Exception {

		logStep(methodName());

		pom.getAddIndividualsPage().selectCurrentDateInDatePicker();
	}
		
	@When("User should select a specific year and month in dropdown and select the date in date picker")
	public void user_should_select_a_specific_year_and_month_in_dropdown_and_select_the_date_in_date_picker() {

		logStep(methodName());

		pom.getAddIndividualsPage().selectDOBUsingDD(1);
	}

	@Then("User should verify the selected date, month and year using dropdown is updated in DOB* field accordingly")
	public void User_should_verify_the_selected_date_month_and_year_using_dropdown_is_updated_in_DOB_field_accordingly() throws Exception {

		logStep(methodName());

		String selectedDate = getAttribute(pom.getAddIndividualsPage().getDob(), "value");
        System.out.println("Selected Date is - "+selectedDate);
		
		String expDate = readExcel("Test Datas", "AddIndividuals", 1, 22);
		String expYear = readExcel("Test Datas", "AddIndividuals", 1, 25);

		waitForFullPageElementLoad();
		try {
			Assert.assertEquals(
					"[Selected date, month and year using dropdown] - Selected date is NOT displayed in DOB* Field",
					getMonth() + "/" + expDate + "/" + expYear, selectedDate);
			log(Status.PASS,
					"[Selected date, month and year using dropdown] - Selected date is displayed in DOB* Field Exp Dt - "
							+ getMonth() + "/" + expDate + "/" + expYear + " | Act Dt - " + selectedDate);
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@And("User should click on the right arrow to navigate to the current month and verify the calendar should display the current months dates")
	public void user_should_click_on_the_right_arrow_to_navigate_to_the_current_month_and_verify_the_calendar_should_display_the_current_months_dates() throws Exception {

		logStep(methodName());

		deleteExistFieldData(pom.getAddIndividualsPage().getDob());
		pom.getAddIndividualsPage().rightSideArrow(1);
		deleteExistFieldData(pom.getAddIndividualsPage().getDob());
		pom.getAddIndividualsPage().dob(1);
		
	}

	

	@Then("User should close the New Individual Registration popup")
	public void user_should_close_the_new_individual_registration_popup() {

		logStep(methodName());

		scrollIntoUp();
		pom.getAddIndividualsPage().closeNewIndRegistrationPopup();

	}


	@Then("User should perform only mandatory fields in Identification tab section")
	public void user_should_perform_only_mandatory_fields_in_identification_tab_section() throws Exception {

		logStep(methodName());

		pom.getAddIndividualsPage().firstName(1).middleName(1).lastName(1).gender(1).dob(1).selectSuite(1);
	}

	@Then("User should perform only mandatory fields in Address tab section")
	public void user_should_perform_only_mandatory_fields_in_address_tab_section() {

		logStep(methodName());

		pom.getAddIndividualsPage().addressTab().residentialAddress(1).sameAsResiAdresscheckBox();

	}

	@Then("User should perform only mandatory fields in Preference tab section")
	public void user_should_perform_only_mandatory_fields_in_preference_tab_section() throws Exception {

		logStep(methodName());

		pom.getAddIndividualsPage().preferenceTab().ecFirstName(1).ecLastName(1).ecRelationship(1).ecPhoneNumber(2);
	}

	@Then("User should click the confirm button")
	public void user_should_click_the_confirm_button() {

		logStep(methodName());

		pom.getAddIndividualsPage().confirm();
		waitForPageLoad();
	}

	@Then("User should verify the error message for duplicate Mobile Number {string}")
	public void user_should_verify_the_error_message_for_duplicate_mobile_number(String expDuplicateErrorMsg) {

		logStep(methodName());

		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getDuplicatePhNoToastbarMsg(), 5);
			Assert.assertEquals("Individual already exist with same phone number - Toast Msg NOT displayed as expected",
					expDuplicateErrorMsg, getText(pom.getAddIndividualsPage().getDuplicatePhNoToastbarMsg()));
			log(Status.PASS, "Duplicate PhoneNo Toast Msg is displayed as expected -"
					+ getText(pom.getAddIndividualsPage().getDuplicatePhNoToastbarMsg()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		pom.getAddIndividualsPage().toastMsgOKButton();
		waitForFullPageElementLoad();
	}

	@Then("User should perform Add Individual with different phone number")
	public void user_should_perform_add_individual_with_different_phone_number() throws Exception {

		logStep(methodName());

		pom.getAddIndividualsPage().back();
		deleteExistPhoneData(pom.getAddIndividualsPage().getEmergencyContact1PhoneNo());

		pom.getAddIndividualsPage().ecPhoneNumber(2);

	}

//	@Then("User should verify the changed Phone Number is displayed in confirm page")
//	public void user_should_verify_the_changed_phone_number_is_displayed_in_confirm_page() {
//
//		logStep(methodName());
//
//		String firstName = readExcel("Test Datas", "AddIndividuals", 1, 0);
//		String middleName = readExcel("Test Datas", "AddIndividuals", 1, 1);
//		String lastName = readExcel("Test Datas", "AddIndividuals", 1, 21);
//
//		String expdate = readExcel("Test Datas", "AddIndividuals", 1, 5);
//
//		String expDob = expdate.replaceAll("/", "-");
//
//		String expIndName = firstName + " " + middleName + " " + lastName;
//
//		String splitPhNum = readExcel("Test Datas", "AddIndividuals", 2, 20);
//
//		String frst3Num = splitPhNum.substring(0, 3);
//		String middle3Num = splitPhNum.substring(3, 6);
//		String last4Num = splitPhNum.substring(6, 10);
//		String expPhoneNumber = "(" + frst3Num + ") ".concat(middle3Num) + "-".concat(last4Num);
//
//		String expAddress = readExcel("Test Datas", "AddIndividuals", 1, 10);
//		waitForFullPageElementLoad();
//		try {
//			Assert.assertEquals("First,Middel & Last Name is not displayed in Confirm tab section", expIndName,
//					getText(pom.getAddIndividualsPage().getIndividualNameInConfirmTabVerification()));
//			log(Status.PASS, "First,Middel & Last Name is displayed in Confirm tab section Ind Name - "
//					+ getText(pom.getAddIndividualsPage().getIndividualNameInConfirmTabVerification()));
//		} catch (AssertionError e) {
//			log(Status.FAIL, e.getMessage());
//			e.printStackTrace();
//		}
//
//		try {
//			Assert.assertEquals("DOB is not displayed in Confirm tab section", expDob,
//					getText(pom.getAddIndividualsPage().getIndividualDOBInConfirmTabVerification()));
//			log(Status.PASS, "DOB is displayed in Confirm tab section Ind DOB - "
//					+ getText(pom.getAddIndividualsPage().getIndividualDOBInConfirmTabVerification()));
//		} catch (AssertionError e) {
//			log(Status.FAIL, e.getMessage());
//			e.printStackTrace();
//		}
//
//		try {
//			Assert.assertEquals("Address is not displayed in Confirm tab section", expAddress,
//					getText(pom.getAddIndividualsPage().getIndividualAddressInConfirmTabVerification()));
//			log(Status.PASS, "Address is displayed in Confirm tab section Ind Address - "
//					+ getText(pom.getAddIndividualsPage().getIndividualAddressInConfirmTabVerification()));
//		} catch (AssertionError e) {
//			log(Status.FAIL, e.getMessage());
//			e.printStackTrace();
//		}
//
//		try {
//			Assert.assertEquals("Phone  Number is not displayed in Confirm tab section", expPhoneNumber,
//					getText(pom.getAddIndividualsPage().getIndividualPhoneNumInConfirmTabVerification()));
//			log(Status.PASS, "Phone  Number is displayed in Confirm tab section Ind Name - "
//					+ getText(pom.getAddIndividualsPage().getIndividualPhoneNumInConfirmTabVerification()));
//		} catch (AssertionError e) {
//			log(Status.FAIL, e.getMessage());
//			e.printStackTrace();
//		}
//
//	}

	@Then("User should verify the toast messgage {string}")
	public void user_should_verify_the_toast_messgage(String expIndCreatedSuccessfullyToastMsg) {

		logStep(methodName());

		try {
			waitForPageLoad();
			
			Assert.assertEquals("Ind Created Successfully Toast Msg is Not Displayed as expected",
					expIndCreatedSuccessfullyToastMsg,
					getText(pom.getAddIndividualsPage().getCreateIndSuccessfullyToastMsg()));
			log(Status.PASS, "Toast Msg is displayed as expected - "
					+ getText(pom.getAddIndividualsPage().getCreateIndSuccessfullyToastMsg()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		pom.getAddIndividualsPage().toastMsgOKButton();
	}

	@Then("User should verify the Individual ID and Created successfull Image are displayed")
	public void user_should_verify_the_individual_id_and_Created_successfull_Image_are_displayed() throws Exception {

		logStep(methodName());
		
		String tickSymbol = "\u2713";
		
		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getCreatedGIFImage(), 5);
			Assert.assertTrue("GIF tick image is NOT displayed",
					pom.getAddIndividualsPage().getCreatedGIFImage().isDisplayed());
			log(Status.PASS, "Tick symbol is displayed as expected : " + tickSymbol);
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		String newIndNum[] = getText(pom.getAddIndividualsPage().getIndID()).split(" ");
		System.out.println(newIndNum[1]);
		String id = newIndNum[1].replace(')', ' ').toString().trim();
		

		System.out.println("CREATED IND ID - "+id);
		
		writeExcel("Test Datas", "CreatedIndividuals", 2, id);
		
		String ID = getText(pom.getAddIndividualsPage().getTxtNewIndID());
		System.out.println("NEW IND ID- " + ID);

		String expSuccessfulTxt = getText(pom.getAddIndividualsPage().getTxtCreatedSuccessfully());
		System.out.println("NEW INDIVIDUAL: " + expSuccessfulTxt);

		if (ID.contains("New Individual (ID") && expSuccessfulTxt.equals("Created Successfully")) {
			log(Status.PASS, "New Individual ID & Text is Displayed as expected - " + ID + " | " + expSuccessfulTxt);
		} else {
			log(Status.FAIL,
					"New Individual ID & Text is NOT Displayed as expected - " + ID + " | " + expSuccessfulTxt);
			throw new Exception();
		}
	}

	@Then("User should click Go to Individuals button")
	public void user_should_click_go_to_individuals_button() {

		logStep(methodName());

		pom.getAddIndividualsPage().goToIndividualsButton();
	}

	@Then("User should verify the page is landed on Individual’s screen")
	public void user_should_verify_the_page_is_landed_on_individual_s_screen() throws Exception {

		logStep(methodName());

		if (getText(pom.getAddIndividualsPage().getIndividualsPageText())
				.equals("Individuals")) {
			
			log(Status.PASS, "The page is landed on Individual’s screen after click [Go To Individuals - Button]");
		} else {
			log(Status.FAIL, "The page is NOT landed on Individual’s screen after click [Go To Individuals - Button]");
			throw new Exception("Assertion failed The page is NOT landed on Individual’s screen");
		}
	}

	@Then("User should verify that individuals are created successfully by perform only mandatory fields")
	public void user_should_verify_that_individuals_are_created_successfully_by_perform_only_mandatory_fields() throws Exception {

		logStep(methodName());
		
		pom.getAddIndividualsPage().searchBox(1);		
		
		String actSearchedInd = getText(pom.getAddIndividualsPage().getCreatedIndName());
		String expSearchedInd = pom.getAddIndividualsPage().getIndividualSearchBox();
		
		System.out.println("Actua Searched Ind - "+actSearchedInd);
		System.out.println("Exp Searched Ind - "+expSearchedInd);
		
		if (actSearchedInd.equals(expSearchedInd)) {
			log(Status.INFO, "Searched Individual is displayed");
			
			pom.getAddIndividualsPage().searchedIndividualform();
			
		} else {
			log(Status.FAIL, "Searched Individual is NOT displayed");
			throw new Exception("Assertion failed searched Individual is not displayed as expected");
		}
		
		waitForPageLoad();
		waitForFullPageElementLoad();
		waitForVisiblityOfElement(pom.getAddIndividualsPage().getSelectedSuite(), 10);
		
		System.out.println("IND FULL NAME -" + getText(pom.getAddIndividualsPage().getCreatedIndividualName()));
		System.out.println("IND DOB -" + getText(pom.getAddIndividualsPage().getCreatedDOB()));
		System.out.println("IND FN NAME -" + getText(pom.getAddIndividualsPage().getCreatedFirstName()));
		System.out.println("IND MN NAME -" + getText(pom.getAddIndividualsPage().getCreatedMiddleName()));
		System.out.println("IND LN NAME -" + getText(pom.getAddIndividualsPage().getCreatedLastName()));
		System.out.println("IND Selected SUITE -" + getText(pom.getAddIndividualsPage().getSelectedSuite()));
		System.out.println("IND ResiAddress -" + getText(pom.getAddIndividualsPage().getCreatedResiAddress()));
		System.out.println("IND MailingAddress -" + getText(pom.getAddIndividualsPage().getCreatedMailAddress()));
		System.out.println("IND GENDER -" + getText(pom.getAddIndividualsPage().getCreatedGender()));
		System.out.println("IND EMNAME -" + getText(pom.getAddIndividualsPage().getCreatedEmContact1Name()));
		System.out.println(
				"IND RELATIONSHIP -" + getText(pom.getAddIndividualsPage().getSelectedEmContact1Relationship()));
		System.out.println("IND EmC PhNo -" + getText(pom.getAddIndividualsPage().getCreatedEmContact1PhNo()));

		
		try {
			String actualSelectedSuite = getText(pom.getAddIndividualsPage().getSelectedSuite());
			String expSelectSuite = readExcel("Test Datas", "AddIndividuals", 1, 6);
            waitForVisiblityOfElement(pom.getAddIndividualsPage().getSelectedSuite(), 5);
			Assert.assertEquals("Created Suite Mismatched", expSelectSuite, actualSelectedSuite);
			log(Status.PASS, "Individual Suite is displayed as expected EXP Suite to select - " + expSelectSuite
					+ " | ACT Selected Suite - " + actualSelectedSuite);

			writeExcelLastRow("Test Datas", "CreatedIndividuals", 0, actualSelectedSuite);

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expIndividualName = readExcel("Test Datas", "AddIndividuals", 1, 26);
			String createdIndividual = getText(pom.getAddIndividualsPage().getCreatedIndividualName());
			
			Assert.assertEquals("Created Individual Name Mismatched", expIndividualName, createdIndividual);
			log(Status.PASS, "Individual Name is displayed as expected EXP Name - " + expIndividualName
					+ " | ACT Name - " + createdIndividual);
			writeExcelLastRow("Test Datas", "CreatedIndividuals", 1, createdIndividual);
			
			String[] split = createdIndividual.split(" ");
			String IndfirstName = split[0];
			String IndLastNameName = split[2];
			System.out.println("Created FrstName & LastName - "+IndfirstName+" "+IndLastNameName);
			
			writeExcelToOverwrite("Test Datas", "Incident Reports", 1, 28, IndfirstName+" "+IndLastNameName);
			
			System.out.println("Created Ind & Selected Suite - " +createdIndividual+"("+getText(pom.getAddIndividualsPage().getCreatedIndividualName())+")");			
			
			writeExcelToOverwrite("Test Datas", "Incident Reports", 1, 0, createdIndividual+"("+getText(pom.getAddIndividualsPage().getCreatedIndividualName())+")");
			
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expDOB = readExcel("Test Datas", "AddIndividuals", 1, 5);
			Assert.assertEquals("Created DOB Mismatched", expDOB, getText(pom.getAddIndividualsPage().getCreatedDOB()));
			log(Status.PASS, "DOB is displayed as expected EXP DOB - " + expDOB + " | ACT DOB - "
					+ getText(pom.getAddIndividualsPage().getCreatedDOB()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expFirstName = readExcel("Test Datas", "AddIndividuals", 1, 0);
			Assert.assertEquals("Created FirstName Mismatched", expFirstName,
					getText(pom.getAddIndividualsPage().getCreatedFirstName()));
			log(Status.PASS, "Individual FirstName is displayed as expected EXP FN - " + expFirstName + " | ACT FN - "
					+ getText(pom.getAddIndividualsPage().getCreatedFirstName()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expMiddleName = readExcel("Test Datas", "AddIndividuals", 1, 1);
			Assert.assertEquals("Created MiddleName Mismatched", expMiddleName,
					getText(pom.getAddIndividualsPage().getCreatedMiddleName()));
			log(Status.PASS, "Individual MiddleName is displayed as expected EXP MN - " + expMiddleName + " | ACT MN - "
					+ getText(pom.getAddIndividualsPage().getCreatedMiddleName()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expLastName = readExcel("Test Datas", "AddIndividuals", 1, 21);
			Assert.assertEquals("Created LastName Mismatched", expLastName,
					getText(pom.getAddIndividualsPage().getCreatedLastName()));
			log(Status.PASS, "Individual LastName is displayed as expected EXP LN - " + expLastName + " | ACT LN - "
					+ getText(pom.getAddIndividualsPage().getCreatedLastName()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expResAddress = readExcel("Test Datas", "AddIndividuals", 1, 10);
			Assert.assertEquals("Created Residential Address Mismatched", expResAddress,
					getText(pom.getAddIndividualsPage().getCreatedResiAddress()));
			log(Status.PASS, "Residential Address is displayed as expected EXP Residential Address - " + expResAddress
					+ " | ACT Residential Address - " + getText(pom.getAddIndividualsPage().getCreatedResiAddress()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expResAddress = readExcel("Test Datas", "AddIndividuals", 1, 10);
			Assert.assertEquals("Created Mailing Address Mismatched", expResAddress,
					getText(pom.getAddIndividualsPage().getCreatedMailAddress()));
			log(Status.PASS, "Mailing Address is displayed as expected EXP Mailing Address - " + expResAddress
					+ " | ACT Mailing Address - " + getText(pom.getAddIndividualsPage().getCreatedMailAddress()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expECFN = readExcel("Test Datas", "AddIndividuals", 1, 17);
			String expECLN = readExcel("Test Datas", "AddIndividuals", 1, 18);
			String expEmergencyContactName = expECFN + " " + expECLN;
			Assert.assertEquals("Created EmergencyContact Name Mismatched", expEmergencyContactName,
					getText(pom.getAddIndividualsPage().getCreatedEmContact1Name()));
			log(Status.PASS, "EmergencyContact Name is displayed as expected EXP EmCName - " + expEmergencyContactName
					+ " | ACT EmCName - " + getText(pom.getAddIndividualsPage().getCreatedEmContact1Name()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expEmRelationship = readExcel("Test Datas", "AddIndividuals", 1, 19);
			Assert.assertEquals("Created EmergencyContact Relationship Mismatched", expEmRelationship,
					getText(pom.getAddIndividualsPage().getSelectedEmContact1Relationship()));
			log(Status.PASS,
					"EmergencyContact Relationship is displayed as expected EXP EmCRelationship - " + expEmRelationship
							+ " | ACT EmCRelationship - "
							+ getText(pom.getAddIndividualsPage().getSelectedEmContact1Relationship()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expEmRelationship = readExcel("Test Datas", "AddIndividuals", 1, 19);
			Assert.assertEquals("Created EmergencyContact Relationship Mismatched", expEmRelationship,
					getText(pom.getAddIndividualsPage().getSelectedEmContact1Relationship()));
			log(Status.PASS,
					"EmergencyContact Relationship is displayed as expected EXP EmCRelationship - " + expEmRelationship
							+ " | ACT EmCRelationship - "
							+ getText(pom.getAddIndividualsPage().getSelectedEmContact1Relationship()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		String splitPhNum = readExcel("Test Datas", "AddIndividuals", 2, 20);

		String frst3Num = splitPhNum.substring(0, 3);
		String middle3Num = splitPhNum.substring(3, 6);
		String last4Num = splitPhNum.substring(6, 10);
		String expPhoneNumber = "(" + frst3Num + ") ".concat(middle3Num) + "-".concat(last4Num);

		try {
			Assert.assertEquals("Created EmergencyContact Phone Number is NOT displayed as expected", expPhoneNumber,
					getText(pom.getAddIndividualsPage().getCreatedEmContact1PhNo()));
			log(Status.PASS, "EmergencyContact Phone Number is displayed as expected Exp EmCPhNum - " + expPhoneNumber
					+ " | Act EmCPhNum - " + getText(pom.getAddIndividualsPage().getCreatedEmContact1PhNo()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		String expGender = readExcel("Test Datas", "AddIndividuals", 1, 4);
		if (expGender.equalsIgnoreCase(getText(pom.getAddIndividualsPage().getCreatedGender()))) {
			log(Status.PASS, "Gender is displayed as expected EXP Gender - " + expGender + " | ACT Gender - "
					+ getText(pom.getAddIndividualsPage().getCreatedGender()));
		} else {
			log(Status.FAIL, "Gender is NOT displayed as expected EXP Gender - " + expGender + " | ACT Gender - "
					+ getText(pom.getAddIndividualsPage().getCreatedGender()));
			throw new Exception("Assertion FAILED");
		}

	}

	@Then("User should perform all fields in Identification tab section")
	public void user_should_perform_all_fields_in_identification_tab_section() throws Exception {

		logStep(methodName());
		
		pom.getAddIndividualsPage().title(1).firstName(1).middleName(1).lastName(1).gender(1).suffix(1).dob(1)
				.selectSuite(2).race(1).maritalStatus(1).addressTab();
	}

	@Then("User should perform all fields in Address tab section")
	public void user_should_perform_all_fields_in_address_tab_section() {

		logStep(methodName());
		
		pom.getAddIndividualsPage().residentialAddress(1).MailingAddress(1);

	}

	@Then("User should verify the first, middle, last name, dob residential and mailing address are displayed in Preference tab section")
	public void user_should_verify_the_first_middle_last_name_dob_residential_and_mailing_address_are_displayed_in_preference_tab_section() {

		logStep(methodName());
		
		pom.getAddIndividualsPage().preferenceTab();

		String expdate = readExcel("Test Datas", "AddIndividuals", 1, 5);

		String expDob = expdate.replaceAll("/", "-");

		String expIndName = readExcel("Test Datas", "AddIndividuals", 1, 26);

		String expAddress = readExcel("Test Datas", "AddIndividuals", 1, 11);

		waitForFullPageElementLoad();
		try {
			Assert.assertEquals("First,Middel & Last Name is not displayed in Preference tab section", expIndName,
					getText(pom.getAddIndividualsPage().getIndividualNameInPreferenceTabVerification()));
			log(Status.PASS, "First,Middel & Last Name is displayed in Preference tab section Ind Name - "
					+ getText(pom.getAddIndividualsPage().getIndividualNameInPreferenceTabVerification()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("DOB is not displayed in Preference tab section", expDob,
					getText(pom.getAddIndividualsPage().getIndividualDOBInPreferenceTabVerification()));
			log(Status.PASS, "DOB is displayed in Preference tab section Ind DOB - "
					+ getText(pom.getAddIndividualsPage().getIndividualDOBInPreferenceTabVerification()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("Address is not displayed in Preference tab section", expAddress,
					getText(pom.getAddIndividualsPage().getIndividualAddressInPreferenceTabVerification()));
			log(Status.PASS, "Address is displayed in Preference tab section Ind Address - "
					+ getText(pom.getAddIndividualsPage().getIndividualAddressInPreferenceTabVerification()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should perform all fields in Preference tab section")
	public void user_should_perform_all_fields_in_preference_tab_section() throws Exception {

		logStep(methodName());
		
		pom.getAddIndividualsPage().preferenceTab().nickName(1).pronoun(1).ethnicAffiliation(1).preferredLanguage(1)
				.ecFirstName(1).ecLastName(1).ecRelationship(1).ecPhoneNumber(2);
		pom.getAddIndividualsPage().Religion(1);

	}

	@Then("User should add another emergency Contact2")
	public void user_should_add_another_emergency_contact2() {

		logStep(methodName());
		
		pom.getAddIndividualsPage().addEmergencyContact();

		pom.getAddIndividualsPage().ec2FirstName(1).ec2LastName(1).ec2Relationship(1).ec2PhoneNumber(1);
	}

	@Then("User should verify the First, middle and last name, dob, residential & mailing address and Phone Number are displayed in confirm form")
	public void user_should_verify_the_first_middle_and_last_name_dob_residential_and_mailing_address_and_phone_number_are_displayed_in_confirm_form() {

		logStep(methodName());

		pom.getAddIndividualsPage().forwardToConfirmPage();

		String expdate = readExcel("Test Datas", "AddIndividuals", 1, 5);

		String expDob = expdate.replaceAll("/", "-");

		String expIndName = readExcel("Test Datas", "AddIndividuals", 1, 26);

		String splitPhNum = readExcel("Test Datas", "AddIndividuals", 2, 20);

		String frst3Num = splitPhNum.substring(0, 3);
		String middle3Num = splitPhNum.substring(3, 6);
		String last4Num = splitPhNum.substring(6, 10);
		String expPhoneNumber = "(" + frst3Num + ") ".concat(middle3Num) + "-".concat(last4Num);

		String expAddress = readExcel("Test Datas", "AddIndividuals", 1, 11);

		waitForFullPageElementLoad();
		try {
			Assert.assertEquals("First,Middel & Last Name is not displayed in Confirm tab section", expIndName,
					getText(pom.getAddIndividualsPage().getIndividualNameInConfirmTabVerification()));
			log(Status.PASS, "First,Middel & Last Name is displayed in Confirm tab section Ind Name - "
					+ getText(pom.getAddIndividualsPage().getIndividualNameInConfirmTabVerification()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("DOB is not displayed in Confirm tab section", expDob,
					getText(pom.getAddIndividualsPage().getIndividualDOBInConfirmTabVerification()));
			log(Status.PASS, "DOB is displayed in Confirm tab section Ind DOB - "
					+ getText(pom.getAddIndividualsPage().getIndividualDOBInConfirmTabVerification()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("Address is not displayed in Confirm tab section", expAddress,
					getText(pom.getAddIndividualsPage().getIndividualAddressInConfirmTabVerification()));
			log(Status.PASS, "Address is displayed in Confirm tab section Ind Address - "
					+ getText(pom.getAddIndividualsPage().getIndividualAddressInConfirmTabVerification()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("Phone  Number is not displayed in Confirm tab section", expPhoneNumber,
					getText(pom.getAddIndividualsPage().getIndividualPhoneNumInConfirmTabVerification()));
			log(Status.PASS, "Phone  Number is displayed in Confirm tab section Ind Name - "
					+ getText(pom.getAddIndividualsPage().getIndividualPhoneNumInConfirmTabVerification()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@And("User should perform emergency contact2 with different phone number")
	public void User_should_perform_emergency_contact2_with_different_phone_number() {

		logStep(methodName());

		pom.getAddIndividualsPage().back()
				.deleteExistPhoneData(pom.getAddIndividualsPage().getEmergencyContact2PhoneNo());

		pom.getAddIndividualsPage().ec2PhoneNumber(2).forwardToConfirmPage();

	}

	@Then("User should verify that individuals are created successfully by perform all fields")
	public void user_should_verify_that_individuals_are_created_successfully_by_perform_all_fields() throws Exception {

		logStep(methodName());
		
	pom.getAddIndividualsPage().searchBox(1);		
		
		
		String actSearchedInd = getText(pom.getAddIndividualsPage().getCreatedIndName());
		String expSearchedInd = pom.getAddIndividualsPage().getIndividualSearchBox();
		
		System.out.println("Actua Searched Ind - "+actSearchedInd);
		System.out.println("Exp Searched Ind - "+expSearchedInd);
		
		if (actSearchedInd.equals(expSearchedInd)) {
			log(Status.INFO, "Searched Individual is displayed");
			
			pom.getAddIndividualsPage().searchedIndividualform();
			
		} else {
			log(Status.FAIL, "Searched Individual is NOT displayed");
			throw new Exception("Assertion failed searched Individual is not displayed as expected");
		}
		
		waitForPageLoad();

		System.out.println("IND FULL NAME -" + getText(pom.getAddIndividualsPage().getCreatedIndividualName()));
		System.out.println("IND DOB -" + getText(pom.getAddIndividualsPage().getCreatedDOB()));
		System.out.println("IND FN NAME -" + getText(pom.getAddIndividualsPage().getCreatedFirstName()));
		System.out.println("IND MN NAME -" + getText(pom.getAddIndividualsPage().getCreatedMiddleName()));
		System.out.println("IND LN NAME -" + getText(pom.getAddIndividualsPage().getCreatedLastName()));
		System.out.println("IND ResiAddress -" + getText(pom.getAddIndividualsPage().getCreatedResiAddress()));
		System.out.println("IND MailingAddress -" + getText(pom.getAddIndividualsPage().getCreatedMailAddress()));
		System.out.println("IND GENDER -" + getText(pom.getAddIndividualsPage().getCreatedGender()));
		System.out.println("IND TITLE -" + getText(pom.getAddIndividualsPage().getSelectedTitle()));
		System.out.println("IND SUFFIX -" + getText(pom.getAddIndividualsPage().getCreatedSuffix()));
		System.out.println("IND RACE -" + getText(pom.getAddIndividualsPage().getSelectedRace()));
		System.out.println("IND MARITAL ST -" + getText(pom.getAddIndividualsPage().getSelectedMaritalStatus()));
		System.out.println("IND Slected SUITE -" + getText(pom.getAddIndividualsPage().getSelectedSuite()));
		System.out.println("IND NICKNAME -" + getText(pom.getAddIndividualsPage().getCreatedNickName()));
		System.out.println("IND PRONOUN -" + getText(pom.getAddIndividualsPage().getSelectedPronoun()));
		System.out
				.println("IND Ethnic Affil.. -" + getText(pom.getAddIndividualsPage().getSelectedEthnicAffiliation()));
		System.out.println("IND PREF.Lang -" + getText(pom.getAddIndividualsPage().getSelectedPrefLanguage()));
		System.out.println("IND RELIGION -" + getText(pom.getAddIndividualsPage().getSelectedReligion()));

		System.out.println("IND EC1NAME -" + getText(pom.getAddIndividualsPage().getCreatedEmContact1Name()));
		System.out.println(
				"IND EC1RELATIONSHIP -" + getText(pom.getAddIndividualsPage().getSelectedEmContact1Relationship()));
		System.out.println("IND EC1 PhNo -" + getText(pom.getAddIndividualsPage().getCreatedEmContact1PhNo()));
		System.out.println("IND EC2NAME -" + getText(pom.getAddIndividualsPage().getCreatedEmContact2Name()));
		System.out.println(
				"IND EC2RELATIONSHIP -" + getText(pom.getAddIndividualsPage().getSelectedEmContact2Relationship()));
		System.out.println("IND EC2 PhNo -" + getText(pom.getAddIndividualsPage().getCreatedEmContact2PhNo()));

		
		
		try {
			String expFirstName = readExcel("Test Datas", "AddIndividuals", 1, 0);
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getCreatedFirstName(), 10);
			Assert.assertEquals("Created FirstName Mismatched", expFirstName,
					getText(pom.getAddIndividualsPage().getCreatedFirstName()));
			log(Status.PASS, "Individual FirstName is displayed as expected EXP FN - " + expFirstName + " | ACT FN - "
					+ getText(pom.getAddIndividualsPage().getCreatedFirstName()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getCreatedMiddleName(), 10);
			String expMiddleName = readExcel("Test Datas", "AddIndividuals", 1, 1);
			Assert.assertEquals("Created MiddleName Mismatched", expMiddleName,
					getText(pom.getAddIndividualsPage().getCreatedMiddleName()));
			log(Status.PASS, "Individual MiddleName is displayed as expected EXP MN - " + expMiddleName + " | ACT MN - "
					+ getText(pom.getAddIndividualsPage().getCreatedMiddleName()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expLastName = readExcel("Test Datas", "AddIndividuals", 1, 21);
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getCreatedLastName(), 10);
			Assert.assertEquals("Created LastName Mismatched", expLastName,
					getText(pom.getAddIndividualsPage().getCreatedLastName()));
			log(Status.PASS, "Individual LastName is displayed as expected EXP LN - " + expLastName + " | ACT LN - "
					+ getText(pom.getAddIndividualsPage().getCreatedLastName()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		
		
		try {
		
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getSelectedSuite(), 10);
			
			String actualSelectedSuite = getText(pom.getAddIndividualsPage().getSelectedSuite());
			String expSelectSuite = readExcel("Test Datas", "AddIndividuals", 2, 6);
			
			Assert.assertEquals("Created Suite Mismatched", expSelectSuite,
					actualSelectedSuite);
			log(Status.PASS, "Individual Suite is displayed as expected EXP Suite to select - " + expSelectSuite
					+ " | ACT Selected Suite - " + actualSelectedSuite);

			writeExcelLastRow("Test Datas", "CreatedIndividuals", 0, actualSelectedSuite);

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getCreatedIndividualName(), 10);
			String expIndividualName = readExcel("Test Datas", "AddIndividuals", 1, 26);
			
			String createdIndividual = getText(pom.getAddIndividualsPage().getCreatedIndividualName());

			
			Assert.assertEquals("Created Individual Name Mismatched", expIndividualName,
					createdIndividual);
			log(Status.PASS, "Individual Name is displayed as expected EXP Name - " + expIndividualName
					+ " | ACT Name - " + createdIndividual);
			writeExcelLastRow("Test Datas", "CreatedIndividuals", 1, createdIndividual);
		
			String[] split = createdIndividual.split(" ");
			String IndfirstName = split[0];
			String IndLastNameName = split[2];
			
            System.out.println("Created FrstName & LastName -"+IndfirstName+" "+IndLastNameName);
			
			writeExcelToOverwrite("Test Datas", "Incident Reports", 1, 28, IndfirstName+" "+IndLastNameName);
			
			System.out.println("Created Ind & Selected Suite -" +createdIndividual+"("+getText(pom.getAddIndividualsPage().getSelectedSuite())+")");			
			
			writeExcelToOverwrite("Test Datas", "Incident Reports", 1, 0, createdIndividual+"("+getText(pom.getAddIndividualsPage().getSelectedSuite())+")");
			
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expTitle = readExcel("Test Datas", "AddIndividuals", 1, 3);
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getSelectedTitle(), 10);
			Assert.assertEquals("Created Title Name Mismatched", expTitle,
					getText(pom.getAddIndividualsPage().getSelectedTitle()));
			log(Status.PASS, "Ind Title is displayed as expected EXP Title - " + expTitle + " | ACT Title - "
					+ getText(pom.getAddIndividualsPage().getSelectedTitle()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		String expGender = readExcel("Test Datas", "AddIndividuals", 1, 4);
		if (expGender.equalsIgnoreCase(getText(pom.getAddIndividualsPage().getCreatedGender()))) {
			log(Status.PASS, "Gender is displayed as expected EXP Gender - " + expGender + " | ACT Gender - "
					+ getText(pom.getAddIndividualsPage().getCreatedGender()));
		} else {
			log(Status.FAIL, "Gender is NOT displayed as expected EXP Gender - " + expGender + " | ACT Gender - "
					+ getText(pom.getAddIndividualsPage().getCreatedGender()));
			throw new Exception("Assertion FAILED");
		}

		try {
			String expDOB = readExcel("Test Datas", "AddIndividuals", 1, 5);
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getCreatedDOB(), 10);
			Assert.assertEquals("Created DOB Mismatched", expDOB, getText(pom.getAddIndividualsPage().getCreatedDOB()));
			log(Status.PASS, "DOB is displayed as expected EXP DOB - " + expDOB + " | ACT DOB - "
					+ getText(pom.getAddIndividualsPage().getCreatedDOB()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expSuffix = readExcel("Test Datas", "AddIndividuals", 1, 7);
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getCreatedSuffix(), 10);
			Assert.assertEquals("Created Suffix Mismatched", expSuffix,
					getText(pom.getAddIndividualsPage().getCreatedSuffix()));
			log(Status.PASS, "Created Suffix is displayed as expected EXP Suffix - " + expSuffix + " | ACT Suffix - "
					+ getText(pom.getAddIndividualsPage().getCreatedSuffix()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expRace = readExcel("Test Datas", "AddIndividuals", 1, 8);
			
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getSelectedRace(), 10);
			
			Assert.assertEquals("Selected Race Mismatched", expRace,
					getText(pom.getAddIndividualsPage().getSelectedRace()));
			log(Status.PASS, "Selected Race is displayed as expected EXP Race - " + expRace + " | ACT Race - "
					+ getText(pom.getAddIndividualsPage().getSelectedRace()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expMaritalStatus = readExcel("Test Datas", "AddIndividuals", 1, 9);
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getSelectedMaritalStatus(), 10);
			
			Assert.assertEquals("Selected Marital Status Mismatched", expMaritalStatus,
					getText(pom.getAddIndividualsPage().getSelectedMaritalStatus()));
			log(Status.PASS, "Selected Marital Status is displayed as expected EXP MS - " + expMaritalStatus
					+ " | ACT MS - " + getText(pom.getAddIndividualsPage().getSelectedMaritalStatus()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expResAddress = readExcel("Test Datas", "AddIndividuals", 1, 10);
			
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getCreatedResiAddress(), 10);
			
			Assert.assertEquals("Created Residential Address Mismatched", expResAddress,
					getText(pom.getAddIndividualsPage().getCreatedResiAddress()));
			log(Status.PASS, "Residential Address is displayed as expected EXP Residential Address - " + expResAddress
					+ " | ACT Residential Address - " + getText(pom.getAddIndividualsPage().getCreatedResiAddress()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expMailingAddress = readExcel("Test Datas", "AddIndividuals", 1, 11);
			
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getCreatedMailAddress(), 10);
			
			Assert.assertEquals("Created Mailing Address Mismatched", expMailingAddress,
					getText(pom.getAddIndividualsPage().getCreatedMailAddress()));
			log(Status.PASS, "Mailing Address is displayed as expected EXP Mailing Address - " + expMailingAddress
					+ " | ACT Mailing Address - " + getText(pom.getAddIndividualsPage().getCreatedMailAddress()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expNickName = readExcel("Test Datas", "AddIndividuals", 1, 12);
			
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getCreatedNickName(), 10);
			
			Assert.assertEquals("Created Nick name Mismatched", expNickName,
					getText(pom.getAddIndividualsPage().getCreatedNickName()));
			log(Status.PASS, "NickName is displayed as expected EXP NN - " + expNickName + " | ACT NN - "
					+ getText(pom.getAddIndividualsPage().getCreatedNickName()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expPronoun = readExcel("Test Datas", "AddIndividuals", 1, 13);
			
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getSelectedPronoun(), 10);
			
			Assert.assertEquals("Selected pronoun Mismatched", expPronoun,
					getText(pom.getAddIndividualsPage().getSelectedPronoun()));
			log(Status.PASS, "Selected pronoun is displayed as expected EXP Pronoun - " + expPronoun
					+ " | ACT Pronoun - " + getText(pom.getAddIndividualsPage().getSelectedPronoun()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expEthnicAff = readExcel("Test Datas", "AddIndividuals", 1, 14);
			
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getSelectedEthnicAffiliation(), 10);

			Assert.assertEquals("Selected ethnic Affiliation Mismatched", expEthnicAff,
					getText(pom.getAddIndividualsPage().getSelectedEthnicAffiliation()));
			log(Status.PASS, "Selected ethnic Affiliation is displayed as expected EXP EA - " + expEthnicAff
					+ " | ACT EA - " + getText(pom.getAddIndividualsPage().getSelectedEthnicAffiliation()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expPreferredLang = readExcel("Test Datas", "AddIndividuals", 1, 15);
			
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getSelectedPrefLanguage(), 10);

			Assert.assertEquals("Selected PreferredLang Mismatched", expPreferredLang,
					getText(pom.getAddIndividualsPage().getSelectedPrefLanguage()));
			log(Status.PASS, "Selected PreferredLang is displayed as expected EXP PL - " + expPreferredLang
					+ " | ACT PL - " + getText(pom.getAddIndividualsPage().getSelectedPrefLanguage()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expReligion = readExcel("Test Datas", "AddIndividuals", 1, 16);
			
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getSelectedReligion(), 10);

			Assert.assertEquals("Selected Religion Mismatched", expReligion,
					getText(pom.getAddIndividualsPage().getSelectedReligion()));
			log(Status.PASS, "Selected Religion is displayed as expected EXP Religion - " + expReligion
					+ " | ACT Religion - " + getText(pom.getAddIndividualsPage().getSelectedReligion()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expECFN = readExcel("Test Datas", "AddIndividuals", 1, 17);
			String expECLN = readExcel("Test Datas", "AddIndividuals", 1, 18);
			String expEmergencyContactName = expECFN + " " + expECLN;
			
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getCreatedEmContact1Name(), 10);

			Assert.assertEquals("Created EmergencyContact Name Mismatched", expEmergencyContactName,
					getText(pom.getAddIndividualsPage().getCreatedEmContact1Name()));
			log(Status.PASS, "EmergencyContact Name is displayed as expected EXP EmCName - " + expEmergencyContactName
					+ " | ACT EmCName - " + getText(pom.getAddIndividualsPage().getCreatedEmContact1Name()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expEmRelationship = readExcel("Test Datas", "AddIndividuals", 1, 19);
			
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getSelectedEmContact1Relationship(), 10);

			Assert.assertEquals("Created EmergencyContact Relationship Mismatched", expEmRelationship,
					getText(pom.getAddIndividualsPage().getSelectedEmContact1Relationship()));
			log(Status.PASS,
					"EmergencyContact Relationship is displayed as expected EXP EmCRelationship - " + expEmRelationship
							+ " | ACT EmCRelationship - "
							+ getText(pom.getAddIndividualsPage().getSelectedEmContact1Relationship()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		String splitPhNum = readExcel("Test Datas", "AddIndividuals", 2, 20);

		String frst3Num = splitPhNum.substring(0, 3);
		String middle3Num = splitPhNum.substring(3, 6);
		String last4Num = splitPhNum.substring(6, 10);
		String expPhoneNumber = "(" + frst3Num + ") ".concat(middle3Num) + "-".concat(last4Num);

		try {
			
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getCreatedEmContact1PhNo(), 10);

			Assert.assertEquals("Created EmergencyContact Phone Number is NOT displayed as expected", expPhoneNumber,
					getText(pom.getAddIndividualsPage().getCreatedEmContact1PhNo()));
			log(Status.PASS, "EmergencyContact Phone Number is displayed as expected Exp EmCPhNum - " + expPhoneNumber
					+ " | Act EmCPhNum - " + getText(pom.getAddIndividualsPage().getCreatedEmContact1PhNo()));
		
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expECFN = readExcel("Test Datas", "AddIndividuals", 1, 17);
			String expECLN = readExcel("Test Datas", "AddIndividuals", 1, 18);
			String expEmergencyContactName = expECFN + " " + expECLN;
			
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getCreatedEmContact2Name(), 10);
			
			Assert.assertEquals("Created EmergencyContact 2 Name Mismatched", expEmergencyContactName,
					getText(pom.getAddIndividualsPage().getCreatedEmContact2Name()));
			log(Status.PASS,
					"EmergencyContact 2 Name is displayed as expected EXP EmC2 Name - " + expEmergencyContactName
							+ " | ACT EmC2 Name - " + getText(pom.getAddIndividualsPage().getCreatedEmContact2Name()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expEmRelationship = readExcel("Test Datas", "AddIndividuals", 1, 19);
			
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getSelectedEmContact2Relationship(), 10);
			
			Assert.assertEquals("Created EmergencyContact 2 Relationship Mismatched", expEmRelationship,
					getText(pom.getAddIndividualsPage().getSelectedEmContact2Relationship()));
			log(Status.PASS,
					"EmergencyContact Relationship 2 is displayed as expected EXP EmC2 Relationship - "
							+ expEmRelationship + " | ACT EmC2 Relationship - "
							+ getText(pom.getAddIndividualsPage().getSelectedEmContact2Relationship()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getCreatedEmContact2PhNo(), 10);
			
			Assert.assertEquals("Created EmergencyContact 2 Phone Number is NOT displayed as expected", expPhoneNumber,
					getText(pom.getAddIndividualsPage().getCreatedEmContact2PhNo()));
			log(Status.PASS,
					"EmergencyContact 2 Phone Number is displayed as expected Exp EmC2 PhNum - " + expPhoneNumber
							+ " | Act EmC2 PhNum - " + getText(pom.getAddIndividualsPage().getCreatedEmContact2PhNo()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	@Then("User should navigate to vitals tab and click add vitals button in View Individual page")
	public void user_should_navigate_to_vitals_tab_and_click_add_vitals_button_in_view_individual_page() {

		logStep(methodName());
	
		pom.getAddIndividualsPage().vitalsTab().addVitalsButton();
		waitForPageLoad();
	}

	@Then("User should verify the breadcrums link should be display with module individual name > Edit individual")
	public void user_should_verify_the_breadcrums_link_should_be_display_with_module_individual_name_edit_individual()
			throws Exception {

		logStep(methodName());

		String txtBreadCrum = getText(pom.getEditIndividualsPage().getBreadCrumLink());

		String BCTxtEditInd = getText(pom.getEditIndividualsPage().getBreadCrumTextEditIndividual());

		if (txtBreadCrum.contains("Individuals") && BCTxtEditInd.contains("Edit Individual")) {
			log(Status.PASS, "Breadcrums link name is displayed after click Edit Button as expected :"
					+ getText(pom.getEditIndividualsPage().getBreadCrumTextEditIndividual()));

		} else {
			log(Status.FAIL, "Breadcrums link name is NOT displayed after click Edit Button");
			throw new Exception("Assertion Failed : Breadcrums link is not displayed with selected suiteName");
		}
	}
	
	
	@Then("User should perform update without enter any fields in vitals tab")
	public void user_should_perform_update_without_enter_any_fields_in_vitals_tab() {

		logStep(methodName());

		pom.getEditIndividualsPage().vitalsUpdateButton();
	}

	@Then("User should verify the Mandatory fields info messages in vitals tab {string}, {string}, {string}, {string}, {string}, {string}")
	public void user_should_verify_the_mandatory_fields_info_messages_in_vitals_tab(String expBGInfoMsg,
			String expBPInfoMsg, String expBGlucoseInfoMsg, String expCholestrolInfoMsg, String expHeightInfoMsg,
			String expWeightInfoMsg) {

		logStep(methodName());

		try {
			waitForVisiblityOfElement(pom.getEditIndividualsPage().getValidationInfoMsgForBGField(), 5);
			Assert.assertEquals("MF validation message is NOT displayed in Blood Group* field as expected",
					expBGInfoMsg, getText(pom.getEditIndividualsPage().getValidationInfoMsgForBGField()));
		
			log(Status.PASS,
					"MF validation message is displayed under Blood Group* field EXP info msg - " + expBGInfoMsg
							+ " | ACT info msg - "
							+ getText(pom.getEditIndividualsPage().getValidationInfoMsgForBGField()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			waitForVisiblityOfElement(pom.getEditIndividualsPage().getValidationInfoMsgForBPField(), 5);
			Assert.assertEquals("MF validation message is NOT displayed in Blood Pressure* field as expected",
					expBPInfoMsg, getText(pom.getEditIndividualsPage().getValidationInfoMsgForBPField()));
			log(Status.PASS,
					"MF validation message is displayed under Blood Pressure* field EXP info msg - " + expBGInfoMsg
							+ " | ACT info msg - "
							+ getText(pom.getEditIndividualsPage().getValidationInfoMsgForBPField()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			waitForVisiblityOfElement(pom.getEditIndividualsPage().getValidationInfoMsgForBGlucoseField(), 5);
			Assert.assertEquals("MF validation message is NOT displayed in Blood Glucose* field as expected",
					expBGlucoseInfoMsg, getText(pom.getEditIndividualsPage().getValidationInfoMsgForBGlucoseField()));
			log(Status.PASS,
					"MF validation message is displayed under Blood Glucose* field EXP info msg - " + expBGlucoseInfoMsg
							+ " | ACT info msg - "
							+ getText(pom.getEditIndividualsPage().getValidationInfoMsgForBGlucoseField()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			waitForVisiblityOfElement(pom.getEditIndividualsPage().getValidationInfoMsgForCholestrolField(), 5);
			Assert.assertEquals("MF validation message is NOT displayed in Cholestrol* field as expected",
					expCholestrolInfoMsg,
					getText(pom.getEditIndividualsPage().getValidationInfoMsgForCholestrolField()));
			log(Status.PASS,
					"MF validation message is displayed under Cholestrol* field EXP info msg - " + expCholestrolInfoMsg
							+ " | ACT info msg - "
							+ getText(pom.getEditIndividualsPage().getValidationInfoMsgForCholestrolField()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			waitForVisiblityOfElement(pom.getEditIndividualsPage().getValidationInfoMsgForHeightField(), 5);
			Assert.assertEquals("MF validation message is NOT displayed in Height* field as expected", expHeightInfoMsg,
					getText(pom.getEditIndividualsPage().getValidationInfoMsgForHeightField()));
			log(Status.PASS,
					"MF validation message is displayed under Height* field EXP info msg - " + expHeightInfoMsg
							+ " | ACT info msg - "
							+ getText(pom.getEditIndividualsPage().getValidationInfoMsgForHeightField()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			waitForVisiblityOfElement(pom.getEditIndividualsPage().getValidationInfoMsgForWeightField(), 5);
			Assert.assertEquals("MF validation message is NOT displayed in Weight* field as expected", expWeightInfoMsg,
					getText(pom.getEditIndividualsPage().getValidationInfoMsgForWeightField()));
			log(Status.PASS,
					"MF validation message is displayed under Weight* field EXP info msg - " + expWeightInfoMsg
							+ " | ACT info msg - "
							+ getText(pom.getEditIndividualsPage().getValidationInfoMsgForWeightField()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("User should verify the valid format Mandatory fields info messages in vitals tab {string}, {string}, {string}, {string}, {string}")
	public void user_should_verify_the_valid_format_mandatory_fields_info_messages_in_vitals_tab(
			String expBPressureFormatInfoMsg, String expBGlucoseFormatInfoMsg, String expCholestrolFormatInfoMsg,
			String expHeightFormatInfoMsg, String expWeightFormatInfoMsg) {

		logStep(methodName());

		pom.getEditIndividualsPage().bloodPressure(1,8).bloodGlucose(1,8).cholesterol(1,8).height(1,8).weight(1,8);

		try {
			Assert.assertEquals("Format validation info message is NOT displayed in Blood Pressure* field as expected",
					expBPressureFormatInfoMsg,
					getText(pom.getEditIndividualsPage().getFormatValidationInfoMsgForBPField()));
			log(Status.PASS,
					"Format validation info message is displayed under Blood Pressure* field EXP info msg - "
							+ expBPressureFormatInfoMsg + " | ACT info msg - "
							+ getText(pom.getEditIndividualsPage().getFormatValidationInfoMsgForBPField()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("Format validation info message is NOT displayed in Blood Glucose* field as expected",
					expBGlucoseFormatInfoMsg,
					getText(pom.getEditIndividualsPage().getFormatValidationInfoMsgForBGlucoseField()));
			log(Status.PASS,
					"Format validation info message is displayed under Blood Glucose* field EXP info msg - "
							+ expBGlucoseFormatInfoMsg + " | ACT info msg - "
							+ getText(pom.getEditIndividualsPage().getFormatValidationInfoMsgForBGlucoseField()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("Format validation info message is NOT displayed in Cholestrol* field as expected",
					expCholestrolFormatInfoMsg,
					getText(pom.getEditIndividualsPage().getFormatValidationInfoMsgForCholestrolField()));
			log(Status.PASS,
					"Format validation info message is displayed under Cholestrol* field EXP info msg - "
							+ expCholestrolFormatInfoMsg + " | ACT info msg - "
							+ getText(pom.getEditIndividualsPage().getFormatValidationInfoMsgForCholestrolField()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("Format validation info message is NOT displayed in Height* field as expected",
					expHeightFormatInfoMsg,
					getText(pom.getEditIndividualsPage().getFormatValidationInfoMsgForHeightField()));
			log(Status.PASS,
					"Format validation info message is displayed under Height* field EXP info msg - "
							+ expHeightFormatInfoMsg + " | ACT info msg - "
							+ getText(pom.getEditIndividualsPage().getFormatValidationInfoMsgForHeightField()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("Format validation info message is NOT displayed in Weight* field as expected",
					expWeightFormatInfoMsg,
					getText(pom.getEditIndividualsPage().getFormatValidationInfoMsgForWeightField()));
			log(Status.PASS,
					"Format validation info message is displayed under Weight* field EXP info msg - "
							+ expWeightFormatInfoMsg + " | ACT info msg - "
							+ getText(pom.getEditIndividualsPage().getFormatValidationInfoMsgForWeightField()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should verify that able to upload more than 1MB file in medical record")
	public void user_should_verify_that_able_to_upload_more_than_1MB_file_in_medical_record() {

		logStep(methodName());

		pom.getEditIndividualsPage().moreThan1MBImgFormatUpload("MoreThan1MB", "jpg");

	}

	@Then("User should upload medical record in vitals tab section")
	public void user_should_upload_medical_record_in_vitals_tab_section() {

		logStep(methodName());

		pom.getEditIndividualsPage().Upload("PNG", "png");
	}
	
	@Then("User should verify that able to cancel the uploaded record file in vitals tab section")
	public void user_should_verify_that_able_to_cancel_the_uploaded_record_file_in_vitals_tab_section() {

		logStep(methodName());

		if (getConfigureProperty("MedicalRecordFileUpload").equalsIgnoreCase("Yes")
				&& getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("NO")) {

			pom.getEditIndividualsPage().cancelUploadedFile();

		} else if (getConfigureProperty("MedicalRecordFileUpload").equalsIgnoreCase("No")
				|| getConfigureProperty("MedicalRecordFileUpload").equalsIgnoreCase("Yes")
						&& getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("Yes")) {

			log(Status.INFO, "SKIPPED Medical Record File Upload due to Headless Run ");

		}
	}

	@Then("User should verify the cancel button is working in vitals tab")
	public void user_should_verify_the_cancel_button_is_working_in_vitals_tab() {

		logStep(methodName());

		try {
			pom.getEditIndividualsPage().vitalsCancelButton();
			Assert.assertTrue("Edit Individual CANCEL button is NOT workin as expected",
					pom.getEditIndividualsPage().getEditIndividualBtn().isEnabled());
			log(Status.PASS, "CANCEL button is working");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should add Vitals info by entering all fields")
	public void user_should_add_vitals_info_by_entering_all_fields() throws Exception {
	    
		logStep(methodName());
		
		pom.getAddIndividualsPage().vitalsTab().addVitalsButton();
		waitForPageLoad();
		
		pom.getAddIndividualsPage().selectBloodGroup(1).bloodPressure(1).bloodGlucose(1).cholesterol(1).height(1).weight(1).healthSummary(1);
	
		String BMIValue = getAttribute(pom.getAddIndividualsPage().getBmiField(),"value");
		
		try {
			Assert.assertEquals("BMI Calculation is NOT working as expected", readExcel("Test Datas", "AddVitals", 1, 6), BMIValue);
			log(Status.PASS, "BMI Calculation is working as expected exp BMI value - "+readExcel("Test Datas", "AddVitals", 1, 6) +" |Act BMI value - "+BMIValue);
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
        pom.getEditIndividualsPage().Upload("JFIF Format", "jfif");		
		
		pom.getAddIndividualsPage().vitalsUpdateButton();
	}
	
	@Then("User should verify the toast messgage {string} after perform vitals tab")
	public void user_should_verify_the_toast_messgage_after_perform_vitals_tab(String expVitalsUpdatedSuccessfullToastMsg) {
	    
		logStep(methodName());
		
		waitForPageLoad();
		
		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getVitalsUpdatedSuccessfullToastMsg(), 5);
			Assert.assertEquals("Vitals updated successfull Toast msg is NOT Displayed as expected",
					expVitalsUpdatedSuccessfullToastMsg,
					getText(pom.getAddIndividualsPage().getVitalsUpdatedSuccessfullToastMsg()));
			log(Status.PASS,
					"Vitals updated successfull Toast msg is displayed successfully EXP Toast msg - "
							+ expVitalsUpdatedSuccessfullToastMsg + " | ACT Toast msg - "
							+ getText(pom.getAddIndividualsPage().getVitalsUpdatedSuccessfullToastMsg()));
		
			pom.getAddIndividualsPage().toastMsgokButton();
			
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		
		
	}
	
	@Then("User should verify that vitals are created successfully by perform all fields")
	public void user_should_verify_that_vitals_are_created_successfully_by_perform_all_fields() {
	    
		logStep(methodName());
		
	pom.getEditIndividualsPage().vitalsTab();
	
	try {
		waitForVisiblityOfElement(pom.getAddIndividualsPage().getSelectedBG(), 5);
		String expBG = readExcel("Test Datas", "AddVitals", 1, 0);
		Assert.assertEquals("Selected Blood Group* Mismatched", expBG,
				getText(pom.getAddIndividualsPage().getSelectedBG()));
		log(Status.PASS, "Selected Blood Group* is displayed as expected EXP BG - " + expBG + " | ACT BG - "
				+ getText(pom.getAddIndividualsPage().getSelectedBG()));
	} catch (AssertionError e) {
		log(Status.FAIL, e.getMessage());
		e.printStackTrace();
	}
	
	try {
		waitForVisiblityOfElement(pom.getAddIndividualsPage().getCreatedBP(), 5);
		String expBP = readExcel("Test Datas", "AddVitals", 1, 1);
		Assert.assertEquals("Created Blood Pressure* Mismatched", expBP,
				getText(pom.getAddIndividualsPage().getCreatedBP()));
		log(Status.PASS, "Created Blood Pressure* is displayed as expected EXP BP - " + expBP + " | ACT BP - "
				+ getText(pom.getAddIndividualsPage().getCreatedBP()));
	} catch (AssertionError e) {
		log(Status.FAIL, e.getMessage());
		e.printStackTrace();
	}
	
	try {
		waitForVisiblityOfElement(pom.getAddIndividualsPage().getCreatedBGlucose(), 5);
		String expBGlucose = readExcel("Test Datas", "AddVitals", 1, 2);
		Assert.assertEquals("Created Blood Glucose* Mismatched", expBGlucose,
				getText(pom.getAddIndividualsPage().getCreatedBGlucose()));
		log(Status.PASS, "Created Blood Glucose* is displayed as expected EXP BGlucose - " + expBGlucose + " | ACT BGlucose - "
				+ getText(pom.getAddIndividualsPage().getCreatedBGlucose()));
	} catch (AssertionError e) {
		log(Status.FAIL, e.getMessage());
		e.printStackTrace();
	}
	
	try {
		waitForVisiblityOfElement(pom.getAddIndividualsPage().getCreatedCholestrol(), 5);
		String expCholestrol = readExcel("Test Datas", "AddVitals", 1, 3);
		Assert.assertEquals("Created Cholestrol* Mismatched", expCholestrol,
				getText(pom.getAddIndividualsPage().getCreatedCholestrol()));
		log(Status.PASS, "Created Cholestrol* is displayed as expected EXP Cholestrol - " + expCholestrol + " | ACT Cholestrol - "
				+ getText(pom.getAddIndividualsPage().getCreatedCholestrol()));
	} catch (AssertionError e) {
		log(Status.FAIL, e.getMessage());
		e.printStackTrace();
	}
	
	try {
		waitForVisiblityOfElement(pom.getAddIndividualsPage().getCreatedHeight(), 5);
		String expHeight = readExcel("Test Datas", "AddVitals", 1, 4);
		Assert.assertEquals("Created Height* Mismatched", expHeight,
				getText(pom.getAddIndividualsPage().getCreatedHeight()));
		log(Status.PASS, "Created Height* is displayed as expected EXP Height - " + expHeight + " | ACT Height - "
				+ getText(pom.getAddIndividualsPage().getCreatedHeight()));
	} catch (AssertionError e) {
		log(Status.FAIL, e.getMessage());
		e.printStackTrace();
	}
	
	try {
		waitForVisiblityOfElement(pom.getAddIndividualsPage().getCreatedWeight(), 5);
		String expWeight = readExcel("Test Datas", "AddVitals", 1, 5);
		Assert.assertEquals("Created Weight* Mismatched", expWeight,
				getText(pom.getAddIndividualsPage().getCreatedWeight()));
		log(Status.PASS, "Created Weight* is displayed as expected EXP Weight - " + expWeight + " | ACT Weight - "
				+ getText(pom.getAddIndividualsPage().getCreatedWeight()));
	} catch (AssertionError e) {
		log(Status.FAIL, e.getMessage());
		e.printStackTrace();
	}
	
	try {
		waitForVisiblityOfElement(pom.getAddIndividualsPage().getCreatedBMI(), 5);
		String expBMI = readExcel("Test Datas", "AddVitals", 1, 6);
		Assert.assertEquals("Created BMI* Mismatched", expBMI,
				getText(pom.getAddIndividualsPage().getCreatedBMI()));
		log(Status.PASS, "Created BMI* is displayed as expected EXP BMI - " + expBMI + " | ACT BMI - "
				+ getText(pom.getAddIndividualsPage().getCreatedBMI()));
	} catch (AssertionError e) {
		log(Status.FAIL, e.getMessage());
		e.printStackTrace();
	}
}

}