package org.alphind.xealei.stepdefinition;

import org.alphind.xealei.baseclass.BaseClass;
import org.alphind.xealei.pom.PageObjectManager;
import org.junit.Assert;

import com.aventstack.extentreports.Status;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class EditIndividualsStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager(getDriver());

	@Then("User should search the created Individual")
	public void user_should_search_the_created_individual() {

		logStep(methodName());

		pom.getEditIndividualsPage().searchBox();

	}

	@Then("User should verify the name dob id guardian contact details is displayed")
	public void user_should_verify_the_name_dob_id_guardian_contact_details_is_displayed() {

		logStep(methodName());

		waitForPageLoad();
		waitForFullPageElementLoad();
		
		String IndName = getAttribute(pom.getEditIndividualsPage().getIndividualSearchBox(),"value");
		
				System.out.println("Actual Searched Ind Name - "+IndName);
				System.out.println("Expected Searched Ind Name - "+readExcel("Test Datas", "AddIndividuals", 1, 26));
				
		if(IndName.equals(readExcel("Test Datas", "AddIndividuals", 1, 26))){
			
		try {
			
			String expIndividualName = readExcel("Test Datas", "AddIndividuals", 1, 26);
			Assert.assertEquals("Created Individual Name Mismatched", expIndividualName,
					getText(pom.getEditIndividualsPage().getCreatedIndName()));
			log(Status.PASS, "Individual Name is displayed as expected EXP Name - " + expIndividualName
					+ " | ACT Name - " + getText(pom.getEditIndividualsPage().getCreatedIndName()));
			
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expDOB = readExcel("Test Datas", "AddIndividuals", 1, 5);
			Assert.assertEquals("Created DOB Mismatched", expDOB,
					getText(pom.getEditIndividualsPage().getCreatedDOB()));
			log(Status.PASS, "DOB is displayed as expected EXP DOB - " + expDOB + " | ACT DOB - "
					+ getText(pom.getEditIndividualsPage().getCreatedDOB()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expIndId = readExcelFromLastRow("Test Datas", "CreatedIndividuals", 2);
			Assert.assertEquals("Created Ind ID Mismatched", "IIN000".concat(expIndId),
					getText(pom.getEditIndividualsPage().getCreatedID()));
			log(Status.PASS, "Ind ID is displayed as expected EXP Ind ID - " + expIndId + " | ACT Ind ID - "
					+ getText(pom.getEditIndividualsPage().getCreatedID()));
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
			Assert.assertEquals("Created Phone Number is NOT displayed as expected", expPhoneNumber,
					getText(pom.getEditIndividualsPage().getCreatedPhNum()));
			log(Status.PASS, "Phone Number is displayed as expected Exp PhNum - " + expPhoneNumber + " | Act PhNum - "
					+ getText(pom.getEditIndividualsPage().getCreatedPhNum()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String expGuardianName = readExcel("Test Datas", "AddIndividuals", 1, 17)
					+ " ".concat(readExcel("Test Datas", "AddIndividuals", 1, 18));
			Assert.assertEquals("Created Guardian Name is NOT displayed as expected", expGuardianName,
					getText(pom.getEditIndividualsPage().getCreatedGuardianName()));
			log(Status.PASS, "Guardian Name is displayed as expected Exp Guardian Name - " + expGuardianName
					+ " | Act Guardian Name - " + getText(pom.getEditIndividualsPage().getCreatedGuardianName()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		}	
	     else if(IndName.equals(readExcelFromLastRow("Test Datas", "CreatedIndividuals", 1))){
			
			try {
				String expIndividualName = readExcel("Test Datas", "EditIndividuals", 1, 26);
				Assert.assertEquals("Created Individual Name Mismatched", expIndividualName,
						getText(pom.getEditIndividualsPage().getCreatedIndName()));
				log(Status.PASS, "Individual Name is displayed as expected EXP Name - " + expIndividualName
						+ " | ACT Name - " + getText(pom.getEditIndividualsPage().getCreatedIndName()));
				
			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}

			try {
				String expDOB = readExcel("Test Datas", "EditIndividuals", 1, 5);
				Assert.assertEquals("Created DOB Mismatched", expDOB,
						getText(pom.getEditIndividualsPage().getCreatedDOB()));
				log(Status.PASS, "DOB is displayed as expected EXP DOB - " + expDOB + " | ACT DOB - "
						+ getText(pom.getEditIndividualsPage().getCreatedDOB()));
			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}

			try {
				String expIndId = readExcelFromLastRow("Test Datas", "CreatedIndividuals", 2);
				Assert.assertEquals("Created Ind ID Mismatched", "IIN00".concat(expIndId),
						getText(pom.getEditIndividualsPage().getCreatedID()));
				log(Status.PASS, "Ind ID is displayed as expected EXP Ind ID - " + expIndId + " | ACT Ind ID - "
						+ getText(pom.getEditIndividualsPage().getCreatedID()));
			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}

			String splitPhNum = readExcel("Test Datas", "EditIndividuals", 2, 20);

			String frst3Num = splitPhNum.substring(0, 3);
			String middle3Num = splitPhNum.substring(3, 6);
			String last4Num = splitPhNum.substring(6, 10);
			String expPhoneNumber = "(" + frst3Num + ") ".concat(middle3Num) + "-".concat(last4Num);

			try {
				Assert.assertEquals("Created Phone Number is NOT displayed as expected", expPhoneNumber,
						getText(pom.getEditIndividualsPage().getCreatedPhNum()));
				log(Status.PASS, "Phone Number is displayed as expected Exp PhNum - " + expPhoneNumber + " | Act PhNum - "
						+ getText(pom.getEditIndividualsPage().getCreatedPhNum()));
			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}

			try {
				String expGuardianName = readExcel("Test Datas", "EditIndividuals", 1, 17)
						+ " ".concat(readExcel("Test Datas", "EditIndividuals", 1, 18));
				Assert.assertEquals("Created Guardian Name is NOT displayed as expected", expGuardianName,
						getText(pom.getEditIndividualsPage().getCreatedGuardianName()));
				log(Status.PASS, "Guardian Name is displayed as expected Exp Guardian Name - " + expGuardianName
						+ " | Act Guardian Name - " + getText(pom.getEditIndividualsPage().getCreatedGuardianName()));
			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}
			
	     } else {
	    	 log(Status.FAIL, "Searched Individual Name doesn't displayed as expected");
		}

	}

	@Then("User should verify the breadcrums link should be display with module individual name > selected individual name in edit individual page")
	public void user_should_verify_the_breadcrums_link_should_be_display_with_module_individual_name_selected_individual_name_in_edit_individual_page()
			throws Exception {

		logStep(methodName());

		pom.getEditIndividualsPage().arrowRight();
		waitForPageLoad();
		
		String txtBreadCrum = getText(pom.getEditIndividualsPage().getBreadCrumLink());

		if (txtBreadCrum.contains("Individuals") && pom.getEditIndividualsPage().createdIndNameText()
				.contains(readExcelFromLastRow("Test Datas", "CreatedIndividuals", 1))) {
			log(Status.PASS, "Breadcrums link name is displayed as expected :"
					+ pom.getEditIndividualsPage().createdIndNameText());
		} else {
			log(Status.FAIL, "Breadcrums link name is NOT displayed with selected Individual Name");
			throw new Exception("Assertion Failed : Breadcrums link is not displayed with selected suiteName");
		}
	}

	@And("User should click the Edit button")
	public void user_should_click_the_Edit_button() {

		logStep(methodName());

		pom.getEditIndividualsPage().EditButton();

	}
	
	@Then("User should verify the tab section name {string},{string}")
	public void user_should_verify_the_tab_section_name(String expPersonalTab, String expVitalsTab) {

		logStep(methodName());

		waitForPageLoad();

		try {
			Assert.assertEquals("Personal Tab is NOT displayed as expected", expPersonalTab,
					getText(pom.getEditIndividualsPage().getPersonalTab()));
			log(Status.PASS, "Personal Tab is displayed as expected - "
					+ getText(pom.getEditIndividualsPage().getPersonalTab()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("Vitals Tab is NOT displayed as expected", expVitalsTab,
					getText(pom.getEditIndividualsPage().getVitalsTab()));
			log(Status.PASS,
					"Vitals Tab is displayed as expected - " + getText(pom.getEditIndividualsPage().getVitalsTab()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("User should verify the Update and Cancel button is enabled")
	public void user_should_verify_the_update_and_cancel_button_is_enabled() {

		logStep(methodName());

		boolean enabled = pom.getEditIndividualsPage().getEditIndCancelBtn().isEnabled();

		try {
			Assert.assertTrue("Cancel button is not displayed as expected", enabled);
			log(Status.PASS, "Cancel Button is enabled as expected ");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Then("User should update existing phone number in emergency contact1")
	public void user_should_update_existing_phone_number_in_emergency_contact1() {
	   
		logStep(methodName());
	
		deleteExistPhoneData(pom.getEditIndividualsPage().getEditECPhNumField());
		
		pom.getEditIndividualsPage().duplicatePhoneNumber(1).updateIndividual();
	}
	
	@Then("User should delete all the fields and perform update")
	public void user_should_delete_all_the_fields_and_perform_update() {

		logStep(methodName());

		pom.getEditIndividualsPage().deleteAllIndexistFieldsData();
		
		pom.getEditIndividualsPage().unSelectGender();
		pom.getEditIndividualsPage().unSelectSuite();
		pom.getEditIndividualsPage().unSelectEC1Relationship();		
		
		pom.getEditIndividualsPage().updateIndividual();
	}

	@Then("User should verify the validation message for Mandatory fields {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void user_should_verify_the_validation_message_for_mandatory_fields(String expFirstName, String expLastName,
			String expGender, String expDob, String expSuiteName, String expResAddress, String expMailAddress,
			String expECFN, String expECLN, String expECRelationship, String expECPhNo) {

		logStep(methodName());

		try {
			Assert.assertEquals("MF validation message is NOT displayed for Individual FirstName* field", expFirstName,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForIndFNField()));
			log(Status.PASS, "MF validation message is displayed for Individual FirstName* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForIndFNField()));

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("MF validation message is NOT displayed for Individual LastName* field", expLastName,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForIndLNField()));
			log(Status.PASS, "MF validation message is displayed for Individual LastName* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForIndLNField()));

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("MF validation message is NOT displayed for Gender* field", expGender,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForGenderField()));
			log(Status.PASS, "MF validation message is displayed for Gender* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForGenderField()));

		} catch (AssertionError e) {
		log(Status.FAIL, e.getMessage());
		e.printStackTrace();
	}

		try {
			Assert.assertEquals("MF validation message is NOT displayed for DOB* field", expDob,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForDOBField()));
			log(Status.PASS, "MF validation message is displayed for DOB* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForDOBField()));

		} catch (AssertionError e) {
		log(Status.FAIL, e.getMessage());
		e.printStackTrace();
	}

		try {
			Assert.assertEquals("MF validation message is NOT displayed for Residential Address* field", expResAddress,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForResidentialAddressField()));
			log(Status.PASS, "MF validation message is displayed for Residential Address* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForResidentialAddressField()));

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("MF validation message is NOT displayed for Mailing Address* field", expMailAddress,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForMailingAddressField()));
			log(Status.PASS, "MF validation message is displayed for Mailing Address* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForMailingAddressField()));

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("MF validation message is NOT displayed for Suite* field", expSuiteName,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForSuiteField()));
			log(Status.PASS, "MF validation message is displayed for Suite* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForSuiteField()));

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("MF validation message is NOT displayed for Em.Contact FirstName* field", expECFN,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactFNField()));
			log(Status.PASS, "MF validation message is displayed for Em.Contact FirstName* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactFNField()));

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("MF validation message is NOT displayed for Em.Contact LastName* field", expECLN,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactLNField()));
			log(Status.PASS, "MF validation message is displayed for Em.Contact LastName* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactLNField()));

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("MF validation message is NOT displayed for Em.Contact Relationship* field",
					expECRelationship,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactRelationshipField()));
			log(Status.PASS, "MF validation message is displayed for Em.Contact Relationship* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactRelationshipField()));

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("MF validation message is NOT displayed for Em.Contact Ph.No* field", expECPhNo,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactPhNoField()));
			log(Status.PASS, "MF validation message is displayed for Em.Contact Ph.No* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactPhNoField()));

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should verify the limit validation error message for First, Middle and Last Name* fields {string}, {string}, {string}")
	public void user_should_verify_the_limit_validation_error_message_for_first_middle_and_last_name_fields(
			String expValidationMsgForFrstName, String expValidationMsgForMiddleName,
			String expValidationMsgForLastName) {

		logStep(methodName());

		pom.getEditIndividualsPage().firstName().middleName().lastName();

		try {

			waitForVisiblityOfElement(pom.getAddIndividualsPage().getLimitValMsgForFrstName(), 5);
			Assert.assertEquals("Limit validation msg for FirstName* field is not displayed",
					expValidationMsgForFrstName, getText(pom.getAddIndividualsPage().getLimitValMsgForFrstName()));
			log(Status.PASS, "Limit validation msg for FirstName* field is displayed - "
					+ getText(pom.getAddIndividualsPage().getLimitValMsgForFrstName()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

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

	@Then("User should verify the limit validation error message in Emergency Contact1 First, Last Name* fields {string} and {string}")
	public void user_should_verify_the_limit_validation_error_message_in_emergency_contact1_first_last_name_fields_and(
			String expValidationMsgForFrstName, String expValidationMsgForLastName) {

		logStep(methodName());

		pom.getEditIndividualsPage().ec1FirstName().ec1LastName();

		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getLimitValMsgForFrstName(), 5);

			Assert.assertEquals("Limit validation msg for FirstName* field is not displayed",
					expValidationMsgForFrstName, getText(pom.getAddIndividualsPage().getLimitValMsgForFrstName()));
			log(Status.PASS, "Limit validation msg for FirstName* field is displayed - "
					+ getText(pom.getAddIndividualsPage().getLimitValMsgForFrstName()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

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

	@Then("User should click Add another emergency contact")
	public void user_should_click_add_another_emergency_contact() {

		logStep(methodName());
		
		pom.getAddIndividualsPage().addEmergencyContact();
	}

	@Then("User should verify the emergency contact label names")
	public void user_should_verify_the_emergency_contact_label_names() throws Exception {

		logStep(methodName());
		
		String EC1 = getText(pom.getAddIndividualsPage().getEmergencyContact1LabelName());

		if (EC1.contains("Emergency Contact 1")) {
			log(Status.PASS, "Emergency contact1 label names is displayed as expected - " + EC1);
		} else {
			log(Status.FAIL, "Emergency contact1 label names is NOT displayed as expected - " + EC1);
			throw new Exception();
		}

		String EC2 = getText(pom.getAddIndividualsPage().getEmergencyContact2LabelName());

		if (EC2.contains("Emergency Contact 2")) {
			log(Status.PASS, "Emergency contact2 label names is displayed as expected - " + EC2);
		} else {
			log(Status.FAIL, "Emergency contact2 label names is NOT displayed as expected - " + EC2);
			throw new Exception();
		}

	}
	
	@Then("User should verify the limit validation error message in Emergency Contact2 First, Last Name* fields {string} and {string}")
	public void user_should_verify_the_limit_validation_error_message_in_emergency_contact2_first_last_name_fields(
			String expValidationMsgForFrstName, String expValidationMsgForLastName) {

		logStep(methodName());

		pom.getEditIndividualsPage().ec2FirstName().ec2LastName();

		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getLimitValMsgForFrstName(), 5);

			Assert.assertEquals("Limit validation msg for FirstName* field is not displayed",
					expValidationMsgForFrstName, getText(pom.getAddIndividualsPage().getLimitValMsgForFrstName()));
			log(Status.PASS, "Limit validation msg for FirstName* field is displayed - "
					+ getText(pom.getAddIndividualsPage().getLimitValMsgForFrstName()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

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

	@Then("User should verify the emergency contact label names in edit individual page")
	public void user_should_verify_the_emergency_contact_label_names_in_edit_individual_page() throws Exception {

		logStep(methodName());

		String EC1 = getText(pom.getEditIndividualsPage().getEmergencyContact1LabelName());

		if (EC1.contains("Emergency Contact 1")) {
			log(Status.PASS, "Emergency contact1 label names is displayed as expected - " + EC1);
		} else {
			log(Status.FAIL, "Emergency contact1 label names is NOT displayed as expected - " + EC1);
			throw new Exception();
		}

		String EC2 = getText(pom.getEditIndividualsPage().getEmergencyContact2LabelName());

		if (EC2.contains("Emergency Contact 2")) {
			log(Status.PASS, "Emergency contact2 label names is displayed as expected - " + EC2);
		} else {
			log(Status.FAIL, "Emergency contact2 label names is NOT displayed as expected - " + EC2);
			throw new Exception();
		}
	}

	@And("User should perform update without enter any fields in emergency")
	public void user_should_perform_update_without_enter_any_fields_in_emergency() {
		
		logStep(methodName());

		pom.getEditIndividualsPage().updateIndividual();
	}
	
	
	@Then("User should verify the mandatory field validation error info message in Emergency Contact2 {string}, {string}, {string}, {string}")
	public void user_should_verify_the_mandatory_field_validation_error_info_message_in_emergency_contact3(
			String expValidationMsgForFrstName, String expValidationMsgForLastName, String expECRelationship,
			String expECPhNo) {
		
		logStep(methodName());

		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getValidationErrMsgForEmContactFNField(), 5);

			Assert.assertEquals("MF validation message is NOT displayed for EC3FirstName* field",
					expValidationMsgForFrstName,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactFNField()));
			
			log(Status.PASS, "MF validation message is displayed for EC3FirstName* field"
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactFNField()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {

			waitForVisiblityOfElement(pom.getAddIndividualsPage().getValidationErrMsgForEmContactLNField(), 5);
			Assert.assertEquals("MF validation message is NOT displayed for EC3LastName* field",
					expValidationMsgForLastName,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactLNField()));
			log(Status.PASS, "MF validation message is NOT displayed for EC3LastName* field is displayed - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactLNField()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getValidationErrMsgForEmContactRelationshipField(), 5);
			Assert.assertEquals("MF validation message is NOT displayed for Em.Contact3 Relationship* field",
					expECRelationship,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactRelationshipField()));
			log(Status.PASS, "MF validation message is displayed for Em.Contact3 Relationship* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactRelationshipField()));

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getValidationErrMsgForEmContactPhNoField(), 5);
					
			Assert.assertEquals("MF validation message is NOT displayed for Em.Contact3 Ph.No* field", expECPhNo,
					getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactPhNoField()));
			log(Status.PASS, "MF validation message is displayed for Em.Contact3 Ph.No* field - "
					+ getText(pom.getAddIndividualsPage().getValidationErrMsgForEmContactPhNoField()));

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("User should perform firstName* and lastName* fields in Add another emergency contact3 in edit individual page")
	public void user_should_perform_first_name_and_last_name_fields_in_add_another_emergency_contact3_in_edit_individual_page() {

		logStep(methodName());

		pom.getEditIndividualsPage().ec3FirstName().ec3LastName();

	}

	@Then("User should verify the limit validation error message in Emergency Contact3 First, Last Name* fields {string} and {string}")
	public void user_should_verify_the_limit_validation_error_message_in_emergency_contact3_first_last_name_fields_and(
			String expValidationMsgForFrstName, String expValidationMsgForLastName) {

		logStep(methodName());

		try {
			waitForVisiblityOfElement(pom.getAddIndividualsPage().getLimitValMsgForFrstName(), 5);

			Assert.assertEquals("Limit validation msg for EC3FirstName* field is not displayed",
					expValidationMsgForFrstName, getText(pom.getAddIndividualsPage().getLimitValMsgForFrstName()));
			log(Status.PASS, "Limit validation msg for EC3FirstName* field is displayed - "
					+ getText(pom.getAddIndividualsPage().getLimitValMsgForFrstName()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {

			waitForVisiblityOfElement(pom.getAddIndividualsPage().getLimitValMsgForLastName(), 5);
			Assert.assertEquals("Limit validation msg for EC3LastName* field is not displayed",
					expValidationMsgForLastName, getText(pom.getAddIndividualsPage().getLimitValMsgForLastName()));
			log(Status.PASS, "Limit validation msg for EC3LastName* field is displayed - "
					+ getText(pom.getAddIndividualsPage().getLimitValMsgForLastName()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("User should verify the that able to close the emergency contact2 and emergency contact3 in edit individual page")
	public void user_should_verify_the_that_able_to_close_the_emergency_contact2_and_emergency_contact3_in_edit_individual_page() {

		logStep(methodName());

		pom.getEditIndividualsPage().ec3closeButton().ec2closeButton();

	}

	@And("User should click on the calendar icon in edit individual page")
	public void user_should_click_on_the_calendar_icon_in_edit_individual_page() {

		logStep(methodName());

		pom.getAddIndividualsPage().datePicker();
	}

	@Then("User should verify the cancel button is working in edit individual page")
	public void user_should_verify_the_cancel_button_is_working_in_edit_individual_page() {

		logStep(methodName());

		try {
			pom.getEditIndividualsPage().cancelButton();
			waitForPageLoad();
			Assert.assertTrue("Edit Individual CANCEL button is NOT workin as expected",
					pom.getEditIndividualsPage().getEditIndividualBtn().isEnabled());
			log(Status.PASS, "CANCEL button is working");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should verify after click the breadcrums link module name should be return to searched Individual page")
	public void user_should_verify_after_click_the_breadcrums_link_module_name_should_be_return_to_searched_individual_page() {

		logStep(methodName());

		pom.getEditIndividualsPage().individualBCTextLink();

		try {
			waitForPageLoad();
			Assert.assertTrue(
					"After click the Individuals breadcrums link NOT able to return to searched Individual page",
					pom.getEditIndividualsPage().getSearchedIndividualsText().isDisplayed());
			log(Status.PASS, "Individual BreadCrum TextLink is working as expected");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@And("User should navigate to created individual")
	public void user_should_navigate_to_created_individual() {

		logStep(methodName());
		
		pom.getEditIndividualsPage().arrowRight();
		waitForPageLoad();
	}
	
	@And("User should perform update with empty fields in vitals tab")
	public void user_should_perform_update_with_empty_fields_in_vitals_tab() {

		logStep(methodName());
		
		pom.getEditIndividualsPage().unSelectBloodGroup();
		
		deleteExistFieldData(pom.getEditIndividualsPage().getBloodPressureField());
		deleteExistFieldData(pom.getEditIndividualsPage().getBloodGlucoseField());
		deleteExistFieldData(pom.getEditIndividualsPage().getCholestrolField());
		deleteExistFieldData(pom.getEditIndividualsPage().getHeightField());
		deleteExistFieldData(pom.getEditIndividualsPage().getWeightField());
		
		pom.getEditIndividualsPage().vitalsUpdateButton();
}
	
	@And("User should upload medical record in edit vital tab section")
	public void user_should_upload_medical_record_in_edit_vital_tab_section() {

		logStep(methodName());
		
	pom.getEditIndividualsPage().uploadForEditVitalsTab("Gif Format", "gif");
	
	}
	
	
	 @Then("User should verify that able to cancel the uploaded record file in edit vitals tab section")
		public void user_should_verify_that_able_to_cancel_the_uploaded_record_file_in_edit_vital_tab_section() {

			logStep(methodName());

	if (getConfigureProperty("MedicalRecordFileUpload").equalsIgnoreCase("Yes")
			&& getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("NO")) {

		pom.getEditIndividualsPage().cancelUploadedFile();
		log(Status.INFO, "Closed the uploaded Medical Record file");

	} else if (getConfigureProperty("MedicalRecordFileUpload").equalsIgnoreCase("No")
			|| getConfigureProperty("MedicalRecordFileUpload").equalsIgnoreCase("Yes")
					&& getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("Yes")) {

		log(Status.INFO, "SKIPPED Medical Record File Upload due to Headless Run ");
	}
	}
	 
	
		 @Then("User should update all fields and verify the toast message after perform all fields {string} in edit individual Page")
		 public void user_should_update_all_fields_and_verify_the_toast_message_after_perform_all_fields_in_edit_individual_page(String expIndUpdatedToastMsg) {
		     
			 logStep(methodName());
			 
			 String IndNeedToUpdate = getText(pom.getEditIndividualsPage().getCreatedIndName());
			 writeExcel("Test Datas", "UpdatedIndividuals", 0, IndNeedToUpdate);
			 
			 pom.getEditIndividualsPage().arrowRight();
			 waitForPageLoad();
			 
			 pom.getEditIndividualsPage().EditButton();
			 waitForPageLoad();
			
			 pom.getEditIndividualsPage().deleteAllIndexistFieldsData();
			 
			 pom.getEditIndividualsPage().updateTitle(1).updateFirstName(1).updateMiddleName(1).updateLastName(1).updateSuffix(1).updateRace(1).updateMaritalStatus(1).updateDob(1).updateGender(1).updateResidentialAddress(1).updateMailingAddress(1).updateNickName(1).updatePronoun(1).updateEthnicAffiliation(1).updatePreferredLanguage(1).updateReligion(1).updateEC1FirstName(1).updateEC1LastName(1).updateEC1Relationship(1).updateEC1PhoneNumber(2).updateEC2FirstName(1).updateEC2LastName(1).updateEC2Relationship(1).updateEC2PhoneNumber(2);	     
			 
			 String updatedFN = getAttribute(pom.getEditIndividualsPage().getEditFNField(), "value");
			 String updatedMN = getAttribute(pom.getEditIndividualsPage().getEditMNField(), "value");
			 String updatedLN = getAttribute(pom.getEditIndividualsPage().getEditLNField(), "value");
			 
			 String UpdatedINDName = updatedFN +" "+ updatedMN +" "+ updatedLN;
			 writeExcelToOverwrite("Test Datas","EditIndividuals", 1, 26, UpdatedINDName);
			 
			 pom.getEditIndividualsPage().updateIndividual();	
			 waitForPageLoad();
			 
				try {
					
		          waitForVisiblityOfElement(pom.getEditIndividualsPage().getIndUpdatedSuccessfullyToastMsg(), 5);
					Assert.assertEquals("Individual updated successfully toast msg is NOT displayed",
							expIndUpdatedToastMsg,
							getText(pom.getEditIndividualsPage().getIndUpdatedSuccessfullyToastMsg()));
					log(Status.PASS, "*Individual updated successfully toastbar msg is displayed as expected - "
							+ getText(pom.getEditIndividualsPage().getIndUpdatedSuccessfullyToastMsg()));

					
					
					
				} catch (AssertionError e) {
					log(Status.FAIL, "Individual updated successfully toastbar msg is displayed as expected");
				}

			pom.getAddIndividualsPage().toastMsgokButton();	
		 }

		 @Then("User should verify all fields are updated successsfully in edit individual Page")
		 public void user_should_verify_all_fields_are_updated_successsfully_in_edit_individual_page() throws Exception {
		     
			 logStep(methodName());
			 
			 waitForPageLoad();
				waitForFullPageElementLoad();

				System.out.println("Updated IND FULL NAME -" + getText(pom.getAddIndividualsPage().getCreatedIndividualName()));
				System.out.println("Updated IND DOB -" + getText(pom.getAddIndividualsPage().getCreatedDOB()));
				System.out.println("Updated IND FN NAME -" + getText(pom.getAddIndividualsPage().getCreatedFirstName()));
				System.out.println("Updated IND MN NAME -" + getText(pom.getAddIndividualsPage().getCreatedMiddleName()));
				System.out.println("Updated IND LN NAME -" + getText(pom.getAddIndividualsPage().getCreatedLastName()));
				System.out.println("Updated IND ResiAddress -" + getText(pom.getAddIndividualsPage().getCreatedResiAddress()));
				System.out.println("Updated IND MailingAddress -" + getText(pom.getAddIndividualsPage().getCreatedMailAddress()));
				System.out.println("Updated IND GENDER -" + getText(pom.getAddIndividualsPage().getCreatedGender()));
				System.out.println("Updated IND TITLE -" + getText(pom.getAddIndividualsPage().getSelectedTitle()));
				System.out.println("Updated IND SUFFIX -" + getText(pom.getAddIndividualsPage().getCreatedSuffix()));
				System.out.println("Updated IND RACE -" + getText(pom.getAddIndividualsPage().getSelectedRace()));
				System.out.println("Updated IND MARITAL ST -" + getText(pom.getAddIndividualsPage().getSelectedMaritalStatus()));
				System.out.println("Updated IND Slected SUITE -" + getText(pom.getAddIndividualsPage().getSelectedSuite()));
				System.out.println("Updated IND NICKNAME -" + getText(pom.getAddIndividualsPage().getCreatedNickName()));
				System.out.println("Updated IND PRONOUN -" + getText(pom.getAddIndividualsPage().getSelectedPronoun()));
				System.out
						.println("Updated IND Ethnic Affil.. -" + getText(pom.getAddIndividualsPage().getSelectedEthnicAffiliation()));
				System.out.println("Updated IND PREF.Lang -" + getText(pom.getAddIndividualsPage().getSelectedPrefLanguage()));
				System.out.println("Updated IND RELIGION -" + getText(pom.getAddIndividualsPage().getSelectedReligion()));

				System.out.println("Updated IND EC1NAME -" + getText(pom.getAddIndividualsPage().getCreatedEmContact1Name()));
				System.out.println(
						"Updated IND EC1RELATIONSHIP -" + getText(pom.getAddIndividualsPage().getSelectedEmContact1Relationship()));
				System.out.println("Updated IND EC1 PhNo -" + getText(pom.getAddIndividualsPage().getCreatedEmContact1PhNo()));
				System.out.println("Updated IND EC2NAME -" + getText(pom.getAddIndividualsPage().getCreatedEmContact2Name()));
				System.out.println(
						"Updated IND EC2RELATIONSHIP -" + getText(pom.getAddIndividualsPage().getSelectedEmContact2Relationship()));
				System.out.println("Updated IND EC2 PhNo -" + getText(pom.getAddIndividualsPage().getCreatedEmContact2PhNo()));

				try {
					String expFirstName = readExcel("Test Datas", "EditIndividuals", 1, 0);
					Assert.assertEquals("UpdatedFirstName Mismatched", expFirstName,
							getText(pom.getAddIndividualsPage().getCreatedFirstName()));
					log(Status.PASS, "Updated Individual FirstName is displayed as expected EXP FN - " + expFirstName + " | ACT FN - "
							+ getText(pom.getAddIndividualsPage().getCreatedFirstName()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}

				try {
					String expMiddleName = readExcel("Test Datas", "EditIndividuals", 1, 1);
					Assert.assertEquals("UpdatedMiddleName Mismatched", expMiddleName,
							getText(pom.getAddIndividualsPage().getCreatedMiddleName()));
					log(Status.PASS, "Updated Individual MiddleName is displayed as expected EXP MN - " + expMiddleName + " | ACT MN - "
							+ getText(pom.getAddIndividualsPage().getCreatedMiddleName()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}

				try {
					String expLastName = readExcel("Test Datas", "EditIndividuals", 1, 21);
					Assert.assertEquals("UpdatedLastName Mismatched", expLastName,
							getText(pom.getAddIndividualsPage().getCreatedLastName()));
					log(Status.PASS, "Updated Individual LastName is displayed as expected EXP LN - " + expLastName + " | ACT LN - "
							+ getText(pom.getAddIndividualsPage().getCreatedLastName()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}
				
				
				

//                         ***NOT UPDATED ***
				
//				try {
//					String expSelectSuite = readExcel("Test Datas", "EditIndividuals", 2, 6);
//					Assert.assertEquals("UpdatedSuite Mismatched", expSelectSuite,
//							getText(pom.getAddIndividualsPage().getSelectedSuite()));
//					log(Status.PASS, "Updated Individual Suite is displayed as expected EXP Suite to select - " + expSelectSuite
//							+ " | ACT Selected Suite - " + getText(pom.getAddIndividualsPage().getSelectedSuite()));
//
//					writeExcelLastRow("Test Datas", "UpdatedIndividuals", 1, getText(pom.getAddIndividualsPage().getCreatedIndName()));
//
//				} catch (AssertionError e) {
//					log(Status.FAIL, e.getMessage());
//					e.printStackTrace();
//				}
				String actualSelectedSuite = getText(pom.getAddIndividualsPage().getSelectedSuite());
				try {
					
					String expIndividualName = readExcel("Test Datas", "EditIndividuals", 1, 26);
					
					String updatedIndividual = getText(pom.getAddIndividualsPage().getCreatedIndividualName());

					Assert.assertEquals("UpdatedIndividual Name Mismatched", expIndividualName,
							updatedIndividual);
					log(Status.PASS, "Updated Individual Name is displayed as expected EXP Name - " + expIndividualName
							+ " | ACT Name - " + updatedIndividual);
					
					writeExcelLastRow("Test Datas", "CreatedIndividuals", 1, updatedIndividual);
					
					writeExcelLastRow("Test Datas", "UpdatedIndividuals", 1, updatedIndividual);
					
					String[] split = updatedIndividual.split(" ");
					String IndfirstName = split[0];
					String IndLastNameName = split[2];
					
		            System.out.println("Updated Ind FrstName & LastName -"+IndfirstName+" "+IndLastNameName);
					
					writeExcelToOverwrite("Test Datas", "Incident Reports", 1, 28, IndfirstName+" "+IndLastNameName);
					
					System.out.println("Updated Ind & Selected Suite -" +updatedIndividual+"("+actualSelectedSuite+")");			
					
					writeExcelToOverwrite("Test Datas", "Incident Reports", 1, 0, updatedIndividual+"("+actualSelectedSuite+")");
					
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}

				try {
					String expTitle = readExcel("Test Datas", "EditIndividuals", 1, 3);
					Assert.assertEquals("UpdatedTitle Name Mismatched", expTitle,
							getText(pom.getAddIndividualsPage().getSelectedTitle()));
					log(Status.PASS, "Updated Ind Title is displayed as expected EXP Title - " + expTitle + " | ACT Title - "
							+ getText(pom.getAddIndividualsPage().getSelectedTitle()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}

				String expGender = readExcel("Test Datas", "EditIndividuals", 1, 4);
				if (expGender.equalsIgnoreCase(getText(pom.getAddIndividualsPage().getCreatedGender()))) {
					log(Status.PASS, "Gender is displayed as expected EXP Gender - " + expGender + " | ACT Gender - "
							+ getText(pom.getAddIndividualsPage().getCreatedGender()));
				} else {
					log(Status.FAIL, "Gender is NOT displayed as expected EXP Gender - " + expGender + " | ACT Gender - "
							+ getText(pom.getAddIndividualsPage().getCreatedGender()));
					throw new Exception("Assertion FAILED");
				}

				try {
					String expDOB = readExcel("Test Datas", "EditIndividuals", 1, 5);
					Assert.assertEquals("UpdatedDOB Mismatched", expDOB, getText(pom.getAddIndividualsPage().getCreatedDOB()));
					log(Status.PASS, "DOB is displayed as expected EXP DOB - " + expDOB + " | ACT DOB - "
							+ getText(pom.getAddIndividualsPage().getCreatedDOB()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}

				try {
					String expSuffix = readExcel("Test Datas", "EditIndividuals", 1, 7);
					Assert.assertEquals("UpdatedSuffix Mismatched", expSuffix,
							getText(pom.getAddIndividualsPage().getCreatedSuffix()));
					log(Status.PASS, "UpdatedSuffix is displayed as expected EXP Suffix - " + expSuffix + " | ACT Suffix - "
							+ getText(pom.getAddIndividualsPage().getCreatedSuffix()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}

				try {
					String expRace = readExcel("Test Datas", "EditIndividuals", 1, 8);
					Assert.assertEquals("Updated Race Mismatched", expRace,
							getText(pom.getAddIndividualsPage().getSelectedRace()));
					log(Status.PASS, "Updated Race is displayed as expected EXP Race - " + expRace + " | ACT Race - "
							+ getText(pom.getAddIndividualsPage().getSelectedRace()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}

				try {
					String expMaritalStatus = readExcel("Test Datas", "EditIndividuals", 1, 9);
					Assert.assertEquals("Updated Marital Status Mismatched", expMaritalStatus,
							getText(pom.getAddIndividualsPage().getSelectedMaritalStatus()));
					log(Status.PASS, "Updated Marital Status is displayed as expected EXP MS - " + expMaritalStatus
							+ " | ACT MS - " + getText(pom.getAddIndividualsPage().getSelectedMaritalStatus()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}

				try {
					String expResAddress = readExcel("Test Datas", "EditIndividuals", 1, 10);
					Assert.assertEquals("UpdatedResidential Address Mismatched", expResAddress,
							getText(pom.getAddIndividualsPage().getCreatedResiAddress()));
					log(Status.PASS, "Updated Residential Address is displayed as expected EXP Residential Address - " + expResAddress
							+ " | ACT Residential Address - " + getText(pom.getAddIndividualsPage().getCreatedResiAddress()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}

				try {
					String expMailingAddress = readExcel("Test Datas", "EditIndividuals", 1, 11);
					Assert.assertEquals("UpdatedMailing Address Mismatched", expMailingAddress,
							getText(pom.getAddIndividualsPage().getCreatedMailAddress()));
					log(Status.PASS, "Updated Mailing Address is displayed as expected EXP Mailing Address - " + expMailingAddress
							+ " | ACT Mailing Address - " + getText(pom.getAddIndividualsPage().getCreatedMailAddress()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}

				try {
					String expNickName = readExcel("Test Datas", "EditIndividuals", 1, 12);
					Assert.assertEquals("UpdatedNick name Mismatched", expNickName,
							getText(pom.getAddIndividualsPage().getCreatedNickName()));
					log(Status.PASS, "Updated NickName is displayed as expected EXP NN - " + expNickName + " | ACT NN - "
							+ getText(pom.getAddIndividualsPage().getCreatedNickName()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}

				try {
					String expPronoun = readExcel("Test Datas", "EditIndividuals", 1, 13);
					Assert.assertEquals("Updated pronoun Mismatched", expPronoun,
							getText(pom.getAddIndividualsPage().getSelectedPronoun()));
					log(Status.PASS, "Updated pronoun is displayed as expected EXP Pronoun - " + expPronoun
							+ " | ACT Pronoun - " + getText(pom.getAddIndividualsPage().getSelectedPronoun()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}

				try {
					String expEthnicAff = readExcel("Test Datas", "EditIndividuals", 1, 14);
					Assert.assertEquals("Updated ethnic Affiliation Mismatched", expEthnicAff,
							getText(pom.getAddIndividualsPage().getSelectedEthnicAffiliation()));
					log(Status.PASS, "Updated ethnic Affiliation is displayed as expected EXP EA - " + expEthnicAff
							+ " | ACT EA - " + getText(pom.getAddIndividualsPage().getSelectedEthnicAffiliation()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}

				try {
					String expPreferredLang = readExcel("Test Datas", "EditIndividuals", 1, 15);
					Assert.assertEquals("Updated PreferredLang Mismatched", expPreferredLang,
							getText(pom.getAddIndividualsPage().getSelectedPrefLanguage()));
					log(Status.PASS, "Updated PreferredLang is displayed as expected EXP PL - " + expPreferredLang
							+ " | ACT PL - " + getText(pom.getAddIndividualsPage().getSelectedPrefLanguage()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}

				try {
					String expReligion = readExcel("Test Datas", "EditIndividuals", 1, 16);
					Assert.assertEquals("Updated Religion Mismatched", expReligion,
							getText(pom.getAddIndividualsPage().getSelectedReligion()));
					log(Status.PASS, "Updated Religion is displayed as expected EXP Religion - " + expReligion
							+ " | ACT Religion - " + getText(pom.getAddIndividualsPage().getSelectedReligion()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}

				try {
					String expECFN = readExcel("Test Datas", "EditIndividuals", 1, 17);
					String expECLN = readExcel("Test Datas", "EditIndividuals", 1, 18);
					String expEmergencyContactName = expECFN + " " + expECLN;
					Assert.assertEquals("UpdatedEmergencyContact Name Mismatched", expEmergencyContactName,
							getText(pom.getAddIndividualsPage().getCreatedEmContact1Name()));
					log(Status.PASS, "Updated EmergencyContact Name is displayed as expected EXP EmCName - " + expEmergencyContactName
							+ " | ACT EmCName - " + getText(pom.getAddIndividualsPage().getCreatedEmContact1Name()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}

				try {
					String expEmRelationship = readExcel("Test Datas", "EditIndividuals", 1, 19);
					Assert.assertEquals("UpdatedEmergencyContact Relationship Mismatched", expEmRelationship,
							getText(pom.getAddIndividualsPage().getSelectedEmContact1Relationship()));
					log(Status.PASS,
							"Updated EmergencyContact Relationship is displayed as expected EXP EmCRelationship - " + expEmRelationship
									+ " | ACT EmCRelationship - "
									+ getText(pom.getAddIndividualsPage().getSelectedEmContact1Relationship()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}

				String splitPhNum = readExcel("Test Datas", "EditIndividuals", 2, 20);

				String frst3Num = splitPhNum.substring(0, 3);
				String middle3Num = splitPhNum.substring(3, 6);
				String last4Num = splitPhNum.substring(6, 10);
				String expPhoneNumber = "(" + frst3Num + ") ".concat(middle3Num) + "-".concat(last4Num);

				try {
					Assert.assertEquals("UpdatedEmergencyContact Phone Number is NOT displayed as expected", expPhoneNumber,
							getText(pom.getAddIndividualsPage().getCreatedEmContact1PhNo()));
					log(Status.PASS, "Updated EmergencyContact Phone Number is displayed as expected Exp EmCPhNum - " + expPhoneNumber
							+ " | Act EmCPhNum - " + getText(pom.getAddIndividualsPage().getCreatedEmContact1PhNo()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}

				try {
					String expECFN = readExcel("Test Datas", "EditIndividuals", 1, 17);
					String expECLN = readExcel("Test Datas", "EditIndividuals", 1, 18);
					String expEmergencyContactName = expECFN + " " + expECLN;
					Assert.assertEquals("UpdatedEmergencyContact 2 Name Mismatched", expEmergencyContactName,
							getText(pom.getAddIndividualsPage().getCreatedEmContact2Name()));
					log(Status.PASS,
							"Updated EmergencyContact 2 Name is displayed as expected EXP EmC2 Name - " + expEmergencyContactName
									+ " | ACT EmC2 Name - " + getText(pom.getAddIndividualsPage().getCreatedEmContact2Name()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}

				try {
					String expEmRelationship = readExcel("Test Datas", "EditIndividuals", 1, 19);
					Assert.assertEquals("UpdatedEmergencyContact 2 Relationship Mismatched", expEmRelationship,
							getText(pom.getAddIndividualsPage().getSelectedEmContact2Relationship()));
					log(Status.PASS,
							"Updated EmergencyContact Relationship 2 is displayed as expected EXP EmC2 Relationship - "
									+ expEmRelationship + " | ACT EmC2 Relationship - "
									+ getText(pom.getAddIndividualsPage().getSelectedEmContact2Relationship()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}

				try {
					Assert.assertEquals("UpdatedEmergencyContact 2 Phone Number is NOT displayed as expected", expPhoneNumber,
							getText(pom.getAddIndividualsPage().getCreatedEmContact2PhNo()));
					log(Status.PASS,
							"Updated EmergencyContact 2 Phone Number is displayed as expected Exp EmC2 PhNum - " + expPhoneNumber
									+ " | Act EmC2 PhNum - " + getText(pom.getAddIndividualsPage().getCreatedEmContact2PhNo()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}
		     
		 }
		 
		 @Then("User should update all fields in vitals tab")
		 public void user_should_update_all_fields_in_vitals_tab() {
		     
			 logStep(methodName());
			 
			 pom.getAddIndividualsPage().vitalsTab().addVitalsButton();
			 waitForPageLoad();
				
				pom.getEditIndividualsPage().deleteAllVitalsExistFieldsData();
				
				pom.getEditIndividualsPage().selectBloodGroup(1).bloodPressure(1,1).bloodGlucose(1,2).cholesterol(1,3).height(1,4).weight(1,5).healthSummary(1,7);
				
				String BMIValue = getAttribute(pom.getAddIndividualsPage().getBmiField(),"value");
				
				try {
					Assert.assertEquals("BMI Calculation is NOT working as expected", readExcel("Test Datas", "EditVitals", 1, 6), BMIValue);
					log(Status.PASS, "BMI Calculation is working as expected exp BMI value - "+readExcel("Test Datas", "AddVitals", 1, 6) +" |Act BMI value - "+BMIValue);
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}
				
		        pom.getEditIndividualsPage().Upload("JFIF Format", "jfif");		
				
				pom.getAddIndividualsPage().vitalsUpdateButton();
		 }
		 
		 @Then("User should verify all fields are updated successsfully in vitals Page")
		 public void user_should_verify_all_fields_are_updated_successsfully_in_vitals_page() {
		     
			 logStep(methodName());

			 pom.getEditIndividualsPage().vitalsTab();
				
				try {
					waitForVisiblityOfElement(pom.getAddIndividualsPage().getSelectedBG(), 5);
					String expBG = readExcel("Test Datas", "EditVitals", 1, 0);
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
					String expBP = readExcel("Test Datas", "EditVitals", 1, 1);
					Assert.assertEquals("Updated Blood Pressure* Mismatched", expBP,
							getText(pom.getAddIndividualsPage().getCreatedBP()));
					log(Status.PASS, "Updated Blood Pressure* is displayed as expected EXP BP - " + expBP + " | ACT BP - "
							+ getText(pom.getAddIndividualsPage().getCreatedBP()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}
				
				try {
					waitForVisiblityOfElement(pom.getAddIndividualsPage().getCreatedBGlucose(), 5);
					String expBGlucose = readExcel("Test Datas", "EditVitals", 1, 2);
					Assert.assertEquals("Updated Blood Glucose* Mismatched", expBGlucose,
							getText(pom.getAddIndividualsPage().getCreatedBGlucose()));
					log(Status.PASS, "Updated Blood Glucose* is displayed as expected EXP BGlucose - " + expBGlucose + " | ACT BGlucose - "
							+ getText(pom.getAddIndividualsPage().getCreatedBGlucose()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}
				
				try {
					waitForVisiblityOfElement(pom.getAddIndividualsPage().getCreatedCholestrol(), 5);
					String expCholestrol = readExcel("Test Datas", "EditVitals", 1, 3);
					Assert.assertEquals("Updated Cholestrol* Mismatched", expCholestrol,
							getText(pom.getAddIndividualsPage().getCreatedCholestrol()));
					log(Status.PASS, "Updated Cholestrol* is displayed as expected EXP Cholestrol - " + expCholestrol + " | ACT Cholestrol - "
							+ getText(pom.getAddIndividualsPage().getCreatedCholestrol()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}
				
				try {
					waitForVisiblityOfElement(pom.getAddIndividualsPage().getCreatedHeight(), 5);
					String expHeight = readExcel("Test Datas", "EditVitals", 1, 4);
					Assert.assertEquals("Updated Height* Mismatched", expHeight,
							getText(pom.getAddIndividualsPage().getCreatedHeight()));
					log(Status.PASS, "Updated Height* is displayed as expected EXP Height - " + expHeight + " | ACT Height - "
							+ getText(pom.getAddIndividualsPage().getCreatedHeight()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}
				
				try {
					waitForVisiblityOfElement(pom.getAddIndividualsPage().getCreatedWeight(), 5);
					String expWeight = readExcel("Test Datas", "EditVitals", 1, 5);
					Assert.assertEquals("Updated Weight* Mismatched", expWeight,
							getText(pom.getAddIndividualsPage().getCreatedWeight()));
					log(Status.PASS, "Updated Weight* is displayed as expected EXP Weight - " + expWeight + " | ACT Weight - "
							+ getText(pom.getAddIndividualsPage().getCreatedWeight()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}
				
				try {
					waitForVisiblityOfElement(pom.getAddIndividualsPage().getCreatedBMI(), 5);
					String expBMI = readExcel("Test Datas", "EditVitals", 1, 6);
					Assert.assertEquals("Updated BMI* Mismatched", expBMI,
							getText(pom.getAddIndividualsPage().getCreatedBMI()));
					log(Status.PASS, "Updated BMI* is displayed as expected EXP BMI - " + expBMI + " | ACT BMI - "
							+ getText(pom.getAddIndividualsPage().getCreatedBMI()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}
		 }



		 
}
