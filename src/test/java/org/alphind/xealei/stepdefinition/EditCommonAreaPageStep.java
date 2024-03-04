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

import io.cucumber.java.en.Then;

public class EditCommonAreaPageStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager(getDriver());

	@Then("User should search the created common area")
	public void user_should_search_the_created_common_area() throws Exception {

		stepName(methodName());

		pom.getEditCommonAreaPage().searchBox(1);
	}

	@Then("User should clicks on the Edit button and verifies that the Edit Common Area popup is displayed")
	public void user_should_clicks_on_the_edit_button_and_verifies_that_the_edit_common_area_popup_is_displayed()
			throws Exception {

		stepName(methodName());
		
		waitForPageLoad();
		
		pom.getEditCommonAreaPage().editButton();

		String popupText = pom.getEditCommonAreaPage().getEditCommonAreaPopupName();

		if (popupText.contains("Edit Common Area")) {
			log(Status.PASS, "Edit Common Area popup is displayed");
		} else {
			log(Status.FAIL, "Edit Common Area popup is NOT displayed");
			throw new Exception("Assertion Failed");
		}
	}

	@Then("User should verify the limit error info message for Common Area Name * field {string} in edit common area popup page")
	public void user_should_verify_the_limit_error_info_message_for_common_area_name_field_in_edit_common_area_popup_page(
			String expLimitValidationMsgForCAN) {

		stepName(methodName());

		pom.getEditCommonAreaPage().deleteExistCommonAreaFieldData();

		pom.getEditCommonAreaPage().enterDataToCheckTheLimitIncommonAreaTextbox().updateButton();

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

	@Then("User should verify duplicate validation for Common Area Name {string} in edit common area popup page")
	public void user_should_verify_duplicate_validation_for_common_area_name_in_edit_common_area_popup_page(
			String expExistToastMessage) {

		stepName(methodName());

		pom.getEditCommonAreaPage().deleteExistCommonAreaFieldData();
		
		pom.getEditCommonAreaPage().existCommonAreaName(1);
		pom.getEditCommonAreaPage().updateButton();

		try {
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

	@Then("User should perform only non-mandatory fields in Edit Common Area popup and verify the info message contains for Mandatory fields {string}")
	public void user_should_perform_only_non_mandatory_fields_in_edit_common_area_popup_and_verify_the_info_message_contains_for_mandatory_fields(
			String expCANMandatoryTxt) {

		stepName(methodName());

		pom.getEditCommonAreaPage().deleteExistCommonAreaFieldData();
		
		pom.getEditCommonAreaPage().enterLengthWidthHeight(1).updateButton();

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

	@Then("User should update all fields and verify the toast message after update all fields {string} in Edit Common Area popup Page")
	public void user_should_update_all_fields_and_verify_the_toast_message_after_update_all_fields_in_edit_common_area_popup_page(
			String string) throws Exception {

		stepName(methodName());

		writeExcel("Test Datas", "UpdatedCommonArea", 0,
				pom.getEditCommonAreaPage().getAttributeValueForCommonAreaNameField());

		pom.getEditCommonAreaPage().deleteExistCommonAreaFieldData().deleteExistLengthFieldData()
				.deleteExistWidthFieldData().deleteExistHeightFieldData();

		pom.getEditCommonAreaPage().updatedCommonAreaName(1);
		pom.getEditCommonAreaPage().enterLengthWidthHeight(1).updateButton();

		waitForPageLoad();

		try {
			
			Assert.assertEquals("Updated Successfull Toast Message is not displayed", "Updated Successfully!!",
					pom.getEditCommonAreaPage().getUpdatedSuccessfullToastMsgText());
			log(Status.PASS, "Updated Successfull Toast Message is displayed : "
					+ pom.getEditCommonAreaPage().getUpdatedSuccessfullToastMsgText());

			String createdCommonArea = readExcelFromLastRow("Test Datas", "CreatedCommonArea", 0);
			
			writeExcelToOverwrite("Test Datas", "EditCommonArea", 2, 6, createdCommonArea);

			pom.getAddCommonAreaPage().savedSuccessfulToastMsgOkButton();

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should verify all fields are updated successsfully in Edit Common Area popup Page")
	public void user_should_verify_all_fields_are_updated_successsfully_in_edit_common_area_popup_page() {

		stepName(methodName());

		try {
			waitForVisiblityOfElement(pom.getAddCommonAreaPage().getCreatedCommonAreaData(), 10);
			String expCommonAreaName = readExcel("Test Datas", "EditCommonArea", 2, 6);
			Assert.assertEquals("Displayed Common Area Mismatched", expCommonAreaName,
					pom.getAddCommonAreaPage().getCreatedCommonAreaNameDataText());
			log(Status.PASS, "Common Area Name is displayed successfully Exp CAN :" + expCommonAreaName
					+ " Actual CAN :" + pom.getAddCommonAreaPage().getCreatedCommonAreaNameDataText());

			String createdCommonAreaName = pom.getAddCommonAreaPage().getCreatedCommonAreaNameDataText();

			writeExcelToOverwrite("Test Datas", "EditCommonArea", 2, 6, createdCommonAreaName);
			writeExcelLastRow("Test Datas", "UpdatedCommonArea", 1, createdCommonAreaName);	
			
			// writeExcelToOverwrite("Test Datas","AddIndividuals", 2, 6,
			// createdCommonAreaName);

		} catch (AssertionError e1) {
			log(Status.FAIL, e1.getMessage());
			e1.printStackTrace();
		}

		try {
			String expLocation = readExcel("Test Datas", "EditCommonArea", 1, 1);
			Assert.assertEquals("Updated Location  Mismatched", expLocation,
					pom.getAddCommonAreaPage().getCommonAreaDefaultLocationDataText());
			log(Status.PASS, "Updated Location displayed successfully Exp Location : " + expLocation
					+ " Actual Location :" + pom.getAddCommonAreaPage().getCommonAreaDefaultLocationDataText());

		} catch (AssertionError e2) {
			log(Status.FAIL, e2.getMessage());
			e2.printStackTrace();
		}

		try {
			String expLength = readExcel("Test Datas", "EditCommonArea", 1, 2);
			Assert.assertEquals("Displayed Length data Mismatched", expLength,
					pom.getAddCommonAreaPage().getCreatedLengthDataText());
			log(Status.PASS, "Updated Length is displayed successfully Exp Length :" + expLength + " Actual Length :"
					+ pom.getAddCommonAreaPage().getCreatedLengthDataText());
		} catch (AssertionError e3) {
			log(Status.FAIL, e3.getMessage());
			e3.printStackTrace();
		}

		try {
			String expWidth = readExcel("Test Datas", "EditCommonArea", 1, 3);
			Assert.assertEquals("Updated width data  Mismatched", expWidth,
					pom.getAddCommonAreaPage().getCreatedWidthDataText());
			log(Status.PASS, "Updated Width is displayed successfully Exp width : " + expWidth + " Actual width :"
					+ pom.getAddCommonAreaPage().getCreatedWidthDataText());

		} catch (AssertionError e4) {
			log(Status.FAIL, e4.getMessage());
			e4.printStackTrace();
		}

		try {
			String expHeight = readExcel("Test Datas", "EditCommonArea", 1, 4);
			Assert.assertEquals("Updated height data Mismatched", expHeight,
					pom.getAddCommonAreaPage().getCreatedHeightDataText());
			log(Status.PASS, "Updated Height is displayed successfully Exp height : " + expHeight + " Actual height : "
					+ pom.getAddCommonAreaPage().getCreatedHeightDataText());

		} catch (AssertionError e5) {
			log(Status.FAIL, e5.getMessage());
			e5.printStackTrace();
		}

	}

	@Then("User should verify the breadcrums link should be display with module Common Area Name > Created Common Area name in edit Common Area page")
	public void user_should_verify_the_breadcrums_link_should_be_display_with_module_common_area_name_created_common_area_name_in_edit_common_area_page()
			throws Exception {

		stepName(methodName());

		String txtBreadCrum = pom.getAddCommonAreaPage().getBreadCrumLinkText();
		String getCreatedCommonArea = readExcelFromLastRow("Test Datas", "CreatedCommonArea",0);
		
		System.out.println("Breadcrums Common Area Name text - " + txtBreadCrum);
		System.out.println("Breadcrums Common Area > updatedCommonAreaName text - "
				+ pom.getEditCommonAreaPage().updatedCommonAreaNameBCText());

		if (txtBreadCrum.contains("Common Area") && pom.getEditCommonAreaPage().updatedCommonAreaNameBCText()
				.contains(getCreatedCommonArea)) {
			log(Status.PASS, "Breadcrums link name is displayed as expected :"
					+ pom.getEditCommonAreaPage().updatedCommonAreaNameBCText());

			System.out.println("Breadcrums link is displayed with updated Common Area Name");

		} else {
			log(Status.FAIL, "Breadcrums link name is NOT displayed with updated Common Area Name");
			throw new Exception("Assertion Failed : Breadcrums link is not displayed with updated Common Area Name");
		}
	}

	@Then("User should verify after click the breadcrums link it should be return to Common Area searched page in edit Common Area page")
	public void user_should_verify_after_click_the_breadcrums_link_it_should_be_return_to_common_area_searched_page_in_edit_common_area_page()
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
