package org.alphind.xealei.stepdefinition;

import org.alphind.xealei.baseclass.BaseClass;
import org.alphind.xealei.pom.PageObjectManager;
import org.junit.Assert;

import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Then;

public class AddCommonAreaPageStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager(getDriver());

	@Then("User should verify the Common Area Module is working")
	public void user_should_verify_the_common_area_module_is_working() {

		stepName(methodName());

		pom.getHomePage().navToCommonAreaModule();

//		waitForPageLoad();
		
		try {
			Assert.assertEquals("Unable to navigate Common Area Page", "Common Area",
					pom.getAddCommonAreaPage().getCommonAreaPageText());
			log(Status.PASS, "Navigate to Common Area page");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should verify common area page tab url address")
	public void user_should_verify_common_area_page_tab_url_address() throws Exception {

		stepName(methodName());

		try {

			String environment = getConfigureProperty("Environment");
			switch (environment) {
			case "QA": {
				Assert.assertEquals("Common Area page tab url is wrong in QA Environment",
						readExcel("Test Datas", "Environments", 1, 1) + "main/suites/commonArea", getCurrentUrl());
				log(Status.PASS, "Tab URL Address verified - Login using QA - " + getCurrentUrl());

				break;
			}
			case "PREPROD": {
				Assert.assertEquals("Common Area page tab url is wrong in PREPROD Environment",
						readExcel("Test Datas", "Environments", 2, 1) + "main/suites/commonArea", getCurrentUrl());
				log(Status.PASS, "Tab URL Address verified - Login using PREPROD - " + getCurrentUrl());
				break;
			}
			case "PROD": {
				Assert.assertEquals("Suite page tab url is wrong",
						readExcel("Test Datas", "Environments", 3, 1) + "main/suites/commonArea", getCurrentUrl());
				log(Status.PASS, "Tab URL Address verified - Login using PROD - " + getCurrentUrl());
				break;
			}
			default: {
				break;
			}
			}
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("User should clicks on the Add Common Area button and verifies that the Add Common Area popup screen is displayed")
	public void user_should_clicks_on_the_add_common_area_button_and_verifies_that_the_add_common_area_popup_screen_is_displayed()
			throws Exception {

		stepName(methodName());

//		waitForPageLoad();
		
		pom.getAddCommonAreaPage().addCommonAreaButton();

		waitForFullPageElementLoad();

		System.out.println("Add CAN" + pom.getAddCommonAreaPage().getHeaderPopupText());

		if (pom.getAddCommonAreaPage().getHeaderPopupText().contains("Add Common Area")) {
			log(Status.PASS, "Add Common Area popup is displayed");
		} else {
			log(Status.FAIL, "Add Common Area is NOT displayed");
			throw new Exception("Assertion Failed");
		}
	}

	@Then("User should verify the limit error info message for Common Area Name * field {string}")
	public void user_should_verify_the_limit_error_info_message_for_common_area_name_field(
			String expLimitValidationMsgForCAN) {

		stepName(methodName());

		pom.getAddCommonAreaPage().checkLimitIncommonAreaTextbox().addButtonInCommenAreaPopup();

		try {
			waitForVisiblityOfElement(pom.getAddCommonAreaPage().getCheckLimitInfoMsgUnderIncommonAreaTextbox(), 10);
			Assert.assertEquals("limit error info message for Common Area Name* field is NOT displayed",
					expLimitValidationMsgForCAN,
					getText(pom.getAddCommonAreaPage().getCheckLimitInfoMsgUnderIncommonAreaTextbox()));
			log(Status.PASS, "limit error info message for Common Area Name* field is displayed - "
					+ getText(pom.getAddCommonAreaPage().getCheckLimitInfoMsgUnderIncommonAreaTextbox()));

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("User should verify the field Common Area Name * is mandatory {string}")
	public void user_should_verify_the_field_common_area_name_is_mandatory(String expCANMandatoryTxt) {

		stepName(methodName());

		deleteExistFieldData(pom.getAddCommonAreaPage().getCommonAreaNameTxtbox());

		pom.getAddCommonAreaPage().addButtonInCommenAreaPopup();

		try {
			Assert.assertEquals("Validation message for Common Area name NOT displayed", expCANMandatoryTxt,
					getText(pom.getAddCommonAreaPage().getValidationInfoMsgForCommonAreaNameField()));
			log(Status.PASS, "Validation message for Common Area name is displayed : "
					+ getText(pom.getAddCommonAreaPage().getValidationInfoMsgForCommonAreaNameField()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("User should verify duplicate validation for Common Area name {string}")
	public void user_should_verify_duplicate_validation_for_common_area_name(String expExistToastMessage) {

		stepName(methodName());

		pom.getAddCommonAreaPage().existCommonAreaName(1).addButtonInCommenAreaPopup();

		try {
			waitForPageLoad();
			Assert.assertEquals("Common Area Name already exists.Toast message is not displayed", expExistToastMessage,
					getText(pom.getAddCommonAreaPage().getCANExitsToastMsg()));
			log(Status.PASS, "Common Area Name already exists. Toast Message is displayed - "
					+ getText(pom.getAddCommonAreaPage().getCANExitsToastMsg()));

			pom.getAddCommonAreaPage().alreadyExistToastMsgOkButton();

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should perform only non-mandatory fields in common area band verify the info message contains for Mandatory fields {string}")
	public void user_should_perform_only_non_mandatory_fields_in_common_area_band_verify_the_info_message_contains_for_mandatory_fields(
			String expCANMandatoryTxt) {

		stepName(methodName());

		deleteExistFieldData(pom.getAddCommonAreaPage().getCommonAreaNameTxtbox());

		pom.getAddCommonAreaPage().enterLengthWidthHeight(1);
		pom.getAddCommonAreaPage().nonMandatoryFieldIsNotEmpty().addButtonInCommenAreaPopup();

		try {
			Assert.assertEquals("Validation message for Common Area name NOT displayed", expCANMandatoryTxt,
					getText(pom.getAddCommonAreaPage().getValidationInfoMsgForCommonAreaNameField()));
			log(Status.PASS, "Validation message for Common Area name is displayed : "
					+ getText(pom.getAddCommonAreaPage().getValidationInfoMsgForCommonAreaNameField()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should verify the field Common Area Name* for limit")
	public void user_should_verify_the_field_common_area_name_for_limit() {
		
		stepName(methodName());
		
		pom.getAddSuitesPage().deleteExistLengthWidthHeightFieldsData();
		
		String checkSuiteNameFieldMaxLimit = pom.getAddCommonAreaPage().checkCommonAreaNameFieldMaxLimit();
		int length = checkSuiteNameFieldMaxLimit.length();
		if(length==14) {
			
		log(Status.PASS, "Common Area Name* field not allows to enter more than 14 characters");
		} else {
			log(Status.FAIL, "Common Area Name* field allows to enter More Than 14 characters");
		}
	}
	
		@Then("User should verify whether able to close the popup by clicking x icon")
		public void user_should_verify_whether_able_to_close_the_popup_by_clicking_x_icon() throws Exception {
		  
		stepName(methodName());

		pom.getAddCommonAreaPage().closePopup();

		String expContent = "Changes you made may not be saved. Are you sure you want to Cancel?";
		String PopupName = "Common Area";

		try {
			Assert.assertEquals("Close popup is NOT displayed", PopupName,
					pom.getAddCommonAreaPage().getCloseCommonAreaPopupHeaderText());
			log(Status.PASS, "Close popup is displayed as expected - "
					+ pom.getAddCommonAreaPage().getCloseCommonAreaPopupHeaderText());

			Assert.assertEquals("Close popup content is NOT displayed as expected.", expContent,
					pom.getAddCommonAreaPage().getClosePopupContentText());
			log(Status.PASS, "Close popup content is displayed as expected - "
					+ pom.getAddCommonAreaPage().getClosePopupContentText());

			pom.getAddCommonAreaPage().yesButton();
			
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("User should perform Common Area by entering only Mandatory field")
	public void user_should_perform_common_area_by_entering_only_mandatory_field() throws Exception {

		stepName(methodName());
		
		pom.getAddCommonAreaPage().addCommonAreaButton();

		waitForFullPageElementLoad();
		
		pom.getAddCommonAreaPage().commonAreaName(1);
		waitForFullPageElementLoad();
		pom.getAddCommonAreaPage().mandatoryFieldIsNotEmpty();
		pom.getAddCommonAreaPage().addButtonInCommenAreaPopup();

		try {
			waitForVisiblityOfElement(pom.getAddCommonAreaPage().getSavedSuccessfullToastMessage(), 10);
			Assert.assertEquals("Saved Successfull Toast Message is not displayed", "Saved Successfully!!",
					getText(pom.getAddCommonAreaPage().getSavedSuccessfullToastMessage()));
			log(Status.PASS, "Toast Message is displayed : "
					+ getText(pom.getAddCommonAreaPage().getSavedSuccessfullToastMessage()));

			String createdCommonArea = readExcelFromLastRow("Test Datas", "CreatedCommonArea", 0);
			writeExcelToOverwrite("Test Datas", "AddCommonArea", 1, 6, createdCommonArea);
			writeExcelToOverwrite("Test Datas", "EditCommonArea", 1, 6, createdCommonArea);
			
			// writeExcelToOverwrite("Test Datas","AddIndividuals", 1, 6,
			// createdCommonArea);

			pom.getAddCommonAreaPage().savedSuccessfulToastMsgOkButton();

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should perform all fields in common area page and verify the toast message after perform all fields {string}")
	public void user_should_perform_all_fields_in_common_area_page_and_verify_the_toast_message_after_perform_all_fields(
			String string) throws Exception {

		stepName(methodName());

		pom.getAddCommonAreaPage().commonAreaName(1).enterLengthWidthHeight(1);
		waitForFullPageElementLoad();
		pom.getAddCommonAreaPage().addButtonInCommenAreaPopup();

		waitForPageLoad();

		try {
			Assert.assertEquals("Saved Successfull Toast Message is not displayed", "Saved Successfully!!",
					getText(pom.getAddCommonAreaPage().getSavedSuccessfullToastMessage()));
			log(Status.PASS, "Toast Message is displayed : "
					+ getText(pom.getAddCommonAreaPage().getSavedSuccessfullToastMessage()));

			String createdCommonArea = readExcelFromLastRow("Test Datas", "CreatedCommonArea", 0);
			writeExcelToOverwrite("Test Datas", "AddCommonArea", 2, 6, createdCommonArea);

			pom.getAddCommonAreaPage().savedSuccessfulToastMsgOkButton();

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("User should search the created Common Area by performed all fields")
	public void user_should_search_the_created_common_area_by_performed_all_fields() throws Exception {

		stepName(methodName());

		pom.getAddCommonAreaPage().searchBox();
		waitForFullPageElementLoad();
	}

	@Then("User should verify all fields are created successsfully in common area page")
	public void user_should_verify_all_fields_are_created_successsfully_in_common_area_page() {

		stepName(methodName());
		try {
			waitForVisiblityOfElement(pom.getAddCommonAreaPage().getCreatedCommonAreaData(), 10);
			String expCommonAreaName = readExcel("Test Datas", "AddCommonArea", 2, 6);
			Assert.assertEquals("Displayed Common Area Mismatched", expCommonAreaName,
					pom.getAddCommonAreaPage().getCreatedCommonAreaNameDataText());
			log(Status.PASS, "Common Area Name is displayed successfully Exp CAN :" + expCommonAreaName
					+ " Actual CAN :" + pom.getAddCommonAreaPage().getCreatedCommonAreaNameDataText());

			String createdCommonAreaName = pom.getAddCommonAreaPage().getCreatedCommonAreaNameDataText();

			writeExcelToOverwrite("Test Datas", "EditCommonArea", 2, 6, createdCommonAreaName);
			// writeExcelToOverwrite("Test Datas","AddIndividuals", 2, 6,
			// createdCommonAreaName);

		} catch (AssertionError e1) {
			log(Status.FAIL, e1.getMessage());
			e1.printStackTrace();
		}

		try {
			String expLocation = readExcel("Test Datas", "AddCommonArea", 1, 1);
			Assert.assertEquals("Location  Mismatched", expLocation,
					pom.getAddCommonAreaPage().getCommonAreaDefaultLocationDataText());
			log(Status.PASS, "Location displayed successfully Exp Location : " + expLocation + " Actual Location :"
					+ pom.getAddCommonAreaPage().getCommonAreaDefaultLocationDataText());

		} catch (AssertionError e2) {
			log(Status.FAIL, e2.getMessage());
			e2.printStackTrace();
		}

		try {
			String expLength = readExcel("Test Datas", "AddCommonArea", 1, 2);
			Assert.assertEquals("Displayed Length data Mismatched", expLength,
					pom.getAddCommonAreaPage().getCreatedLengthDataText());
			log(Status.PASS, "Length is displayed successfully Exp Length :" + expLength + " Actual Length :"
					+ pom.getAddCommonAreaPage().getCreatedLengthDataText());
		} catch (AssertionError e3) {
			log(Status.FAIL, e3.getMessage());
			e3.printStackTrace();
		}

		try {
			String expWidth = readExcel("Test Datas", "AddCommonArea", 1, 3);
			Assert.assertEquals("Created width data  Mismatched", expWidth,
					pom.getAddCommonAreaPage().getCreatedWidthDataText());
			log(Status.PASS, "Width is displayed successfully Exp width : " + expWidth + " Actual width :"
					+ pom.getAddCommonAreaPage().getCreatedWidthDataText());

		} catch (AssertionError e4) {
			log(Status.FAIL, e4.getMessage());
			e4.printStackTrace();
		}

		try {
			String expHeight = readExcel("Test Datas", "AddCommonArea", 1, 4);
			Assert.assertEquals("Created height data Mismatched", expHeight,
					pom.getAddCommonAreaPage().getCreatedHeightDataText());
			log(Status.PASS, "Height is displayed successfully Exp height : " + expHeight + " Actual height : "
					+ pom.getAddCommonAreaPage().getCreatedHeightDataText());

		} catch (AssertionError e5) {
			log(Status.FAIL, e5.getMessage());
			e5.printStackTrace();
		}

	}

	@Then("User should verify the breadcrums link should be display with module Common Area > Common Area name")
	public void user_should_verify_the_breadcrums_link_should_be_display_with_module_common_area_common_area_name()
			throws Exception {

		stepName(methodName());

		String txtBreadCrum = pom.getAddCommonAreaPage().getBreadCrumLinkText();

		System.out.println("Breadcrums Common Area Name text - " + txtBreadCrum);
		System.out.println("Breadcrums Common Area > createdCommonAreaName text - "
				+ pom.getAddCommonAreaPage().commonAreaNameBCText());

		if (txtBreadCrum.contains("Common Area") && pom.getAddCommonAreaPage().commonAreaNameBCText()
				.contains(pom.getAddCommonAreaPage().readExcel("Test Datas", "AddCommonArea", 2, 6))) {
			log(Status.PASS, "Breadcrums link name is displayed as expected :"
					+ pom.getAddCommonAreaPage().commonAreaNameBCText());
			System.out.println("Breadcrums link is displayed with created Common Area Name");
		} else {
			log(Status.FAIL, "Breadcrums link name is NOT displayed with created Common Area Name");
			throw new Exception("Assertion Failed : Breadcrums link is not displayed with created Common Area Name");
		}

	}

	@Then("User should verify after click the breadcrums link it should be return to Common Area searched page")
	public void user_should_verify_after_click_the_breadcrums_link_it_should_be_return_to_common_area_searched_page()
			throws Exception {

		stepName(methodName());

		pom.getAddCommonAreaPage().returnToCommonAreaPageBCText();

		waitForFullPageElementLoad();

		if (pom.getAddCommonAreaPage().isViewButtonisDisplayed()) {
			log(Status.PASS,
					"Return to Common Area searched page successfully after click the [Common Area >] breadcrum link");
			System.out.println("Breadcrums link is successfully returned to common area searched page");
		} else {
			log(Status.FAIL, "Unable to Return to Suite searched page after click the [Common Area >] breadcrum link");
			throw new Exception("Assertion Failed : Breadcrums link is not returned to common area searched page");
		}
	}

}
