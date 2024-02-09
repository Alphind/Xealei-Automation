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

public class AddSuitesPageStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager(getDriver());
	
	@Then("User should verify suite page tab url address for suites page")
	public void user_should_verify_suite_page_tab_url_address_for_suites_page() throws Exception {

		logStep(methodName());
		
		try {

			String environment = getConfigureProperty("Environment");
			switch (environment) {
			case "QA": {
				Assert.assertEquals("Suite page tab url is wrong",
						readExcel("Test Datas", "Environments", 1, 1) + "main/suites", getCurrentUrl());
				log(Status.PASS, "Tab URL Address verified - Login using QA - " + getCurrentUrl());

				break;
			}
			case "PREPROD": {
				Assert.assertEquals("Suite page tab url is wrong",
						readExcel("Test Datas", "Environments", 2, 1) + "main/suites", getCurrentUrl());
				log(Status.PASS, "Tab URL Address verified - Login using PREPROD - " + getCurrentUrl());
				break;
			}
			case "PROD": {
				Assert.assertEquals("Suite page tab url is wrong",
						readExcel("Test Datas", "Environments", 3, 1) + "main/suites", getCurrentUrl());
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

	@Then("User should verify the Suite Module is working")
	public void user_should_verify_the_suite_module_is_working() {

		logStep(methodName());
		
		pom.getHomePage().navToSuitesModule();
		waitForPageLoad();
		try {
			Assert.assertEquals("Unable to navigate Suite Page", "Suites",
					getText(pom.getAddSuitesPage().getSuitesPage()));
			log(Status.PASS, "Navigate to Suites page");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}
	
	@Then("User should verify the Add Suite button is working")
	public void user_should_verify_the_add_suite_button_is_working() {

		logStep(methodName());
		
		pom.getAddSuitesPage().btnAddSuite();

	}

	@Then("User should verify the Add Suite pop up screen is displayed")
	public void user_should_verify_the_add_suite_pop_up_screen_is_displayed() throws Exception {

		logStep(methodName());
		String popupText = getText(pom.getAddSuitesPage().getAddSuitePopupText());

		if (popupText.contains("Add Suite")) {
			log(Status.PASS, "Add Suite popup is displayed");
		} else {
			log(Status.FAIL, "Add Suite popup is not displayed");
			throw new Exception("Assertion Failed");
		}

	}

	@Then("User should verify the limit error info message for Suite Name* field {string}")
	public void user_should_verify_the_limit_error_info_message_for_suite_name_field (String expLimitValidationMsgForSN) {
		

		logStep(methodName());

		pom.getAddSuitesPage().suiteLimit().addButton();
		
		try {
			waitForVisiblityOfElement(pom.getAddSuitesPage().getSuiteNameLimit(), 10);
			Assert.assertEquals("limit error info message for Suite Name* field is NOT displayed", expLimitValidationMsgForSN,
					getText(pom.getAddSuitesPage().getSuiteNameLimit()));
			log(Status.PASS, "limit error info message for Suite Name* field is displayed - "
					+ getText(pom.getAddSuitesPage().getSuiteNameLimit()));
			deleteExistFieldData(pom.getAddSuitesPage().getSuiteName());
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Then("User should verify the field Suite Name * is mandatory {string}")
	public void user_should_verify_the_field_suite_name_is_mandatory(String expSNMandatoryTxt) {

		logStep(methodName());

		deleteExistFieldData(pom.getAddSuitesPage().getSuiteName());
		pom.getAddSuitesPage().addButton();

		try {
			Assert.assertEquals("Validation message for suiteName not displayed", expSNMandatoryTxt,
					getText(pom.getAddSuitesPage().getValidationMsgForSuiteName()));
			log(Status.PASS, "Validation message for suiteName is displayed : "
					+ getText(pom.getAddSuitesPage().getValidationMsgForSuiteName()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("User should create a suite and verify duplicate validation for Suite name {string}")
	public void user_should_create_a_suite_and_verify_duplicate_validation_for_suite_name(String expSuiteExistToastMessage) throws Exception {

		logStep(methodName());

		pom.getAddSuitesPage().suiteName(1);

		pom.getAddSuitesPage().addButton();

		waitForPageLoad();

		try {
			Assert.assertEquals("Saved Successfull Toast Message is not displayed", "Saved Successfully!!",
					getText(pom.getAddSuitesPage().getSavedSuccessfullToastMessage()));
			log(Status.PASS, "Toast Message is displayed : "
					+ getText(pom.getAddSuitesPage().getSavedSuccessfullToastMessage()));
			
			String createdSuite = readExcelFromLastRow("Test Datas", "CreatedSuites", 0);
			writeExcelToOverwrite("Test Datas","AddSuites", 1, 6, createdSuite);
			
			pom.getAddSuitesPage().savedSuccessfulToastMsgOkButton();
			
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		
		
		try {
			pom.getAddSuitesPage().searchBox(1);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		

		try {
			waitForVisiblityOfElement(pom.getAddSuitesPage().getCreatedSuiteName(), 10);
			String expSuiteName = readExcel("Test Datas", "AddSuites", 1, 6);
			Assert.assertEquals("Created SuiteName Mismatched", expSuiteName,
					getText(pom.getAddSuitesPage().getCreatedSuiteName()));
			log(Status.PASS, "Suite Name is created successfully Exp SN :" + expSuiteName + " Actual SN :"
					+ getText(pom.getAddSuitesPage().getCreatedSuiteName()));

			String createdSuiteName = getText(pom.getAddSuitesPage().getCreatedSuiteName());
			writeExcelToOverwrite("Test Datas","EditSuites", 1, 6, createdSuiteName);
			writeExcelToOverwrite("Test Datas","AddIndividuals", 1, 6, createdSuiteName);
			
		} catch (AssertionError e1) {
			log(Status.FAIL, e1.getMessage());
			e1.printStackTrace();
		}
		
		pom.getAddSuitesPage().returnToSuitesPageBCText();

		waitForFullPageElementLoad();
		
		pom.getAddSuitesPage().btnAddSuite();
	
		pom.getAddSuitesPage().existSuiteName(1).addButton();
		
		try {
			Assert.assertEquals("Suite Name already exists.Toast message is not displayed", expSuiteExistToastMessage,
					getText(pom.getAddSuitesPage().getSNExitsToastMsg()));
			log(Status.PASS, "Suite Name already exists. Toast Message is displayed - "
					+ getText(pom.getAddSuitesPage().getSNExitsToastMsg()));

			pom.getAddSuitesPage().snAlreadyExistToastMsgOkButton();
			
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}		
	}

	@Then("User should perform only non-mandatory fields")
	public void user_should_perform_only_non_mandatory_fields() {

		logStep(methodName());
		deleteExistFieldData(pom.getAddSuitesPage().getSuiteName());
		pom.getAddSuitesPage().enterLengthWidthHeight(1).addButton();
	}

		@Then("User should verify the error message contains for Mandatory fields {string}")
		public void user_should_verify_the_error_message_contains_for_mandatory_fields (String expSNMandatoryTxt) {

			logStep(methodName());

			try {
				Assert.assertEquals("Validation message for suiteName not displayed", expSNMandatoryTxt,
						getText(pom.getAddSuitesPage().getValidationMsgForSuiteName()));
				log(Status.PASS, "Validation message for suiteName is displayed : "
						+ getText(pom.getAddSuitesPage().getValidationMsgForSuiteName()));
			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}
		}
		
		@Then("User should perform Add Suite without enter any fields")
		public void user__should_perform_add_suites_without_enter_any_fields() {

			logStep(methodName());
			
			deleteExistFieldData(pom.getAddSuitesPage().getLength());
			deleteExistFieldData(pom.getAddSuitesPage().getWidth());
			deleteExistFieldData(pom.getAddSuitesPage().getHeight());
			
			pom.getAddSuitesPage().enterLengthWidthHeight(1).addButton();
		}

		
			@Then("User should verify the x icon in add suites screen is working")
			public void user_should_verify_the_icon_in_add_suites_screen_is_working() throws Exception {

				logStep(methodName());

				pom.getAddSuitesPage().closePopup();

				if (pom.getAddSuitesPage().getBtnAddSuites().isEnabled()) {
					log(Status.PASS, "Add Suite popup is closed");
				} else {
					log(Status.FAIL, "Add Suite popup is not closed");
					throw new Exception("Assertion Failed");
				}
			}

			@Then("User should perform all fields and verify the toast message after perform all fields {string}")
			public void user_should_perform_all_fields_and_verify_the_toast_message_after_perform_all_fields(String expToastMsg)
					throws Exception {

				logStep(methodName());
				
				pom.getAddSuitesPage().suiteName(1);
				pom.getAddSuitesPage().enterLengthWidthHeight(1).addButton();

				waitForPageLoad();
				try {
					Assert.assertEquals("Saved Successfull Toast Message is not displayed", "Saved Successfully!!",
							getText(pom.getAddSuitesPage().getSavedSuccessfullToastMessage()));
					log(Status.PASS, "Toast Message is displayed : "
							+ getText(pom.getAddSuitesPage().getSavedSuccessfullToastMessage()));

					String createdSuite = readExcelFromLastRow("Test Datas", "CreatedSuites", 0);
					writeExcelToOverwrite("Test Datas","AddSuites", 2, 6, createdSuite);
					
					pom.getAddSuitesPage().savedSuccessfulToastMsgOkButton();
					
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}
				
	}

			@Then("User should verify all fields are created successsfully")
			public void user_should_verify_all_fields_are_created_successsfully() throws Exception {

				logStep(methodName());

				pom.getAddSuitesPage().searchBox(2);
				waitForFullPageElementLoad();

				try {
					waitForVisiblityOfElement(pom.getAddSuitesPage().getCreatedSuiteName(), 10);
					String expSuiteName = readExcel("Test Datas", "AddSuites", 2, 6);
					Assert.assertEquals("Created SuiteName Mismatched", expSuiteName,
							getText(pom.getAddSuitesPage().getCreatedSuiteName()));
					log(Status.PASS, "Suite Name is created successfully Exp SN :" + expSuiteName + " Actual SN :"
							+ getText(pom.getAddSuitesPage().getCreatedSuiteName()));

					String createdSuiteName = getText(pom.getAddSuitesPage().getCreatedSuiteName());
					
					writeExcelToOverwrite("Test Datas","EditSuites", 2, 6, createdSuiteName);
					writeExcelToOverwrite("Test Datas","AddIndividuals", 2, 6, createdSuiteName);
		
				} catch (AssertionError e1) {
					log(Status.FAIL, e1.getMessage());
					e1.printStackTrace();
				}
				
				try {
					String expAvailability = readExcel("Test Datas", "AddSuites", 1, 5);
					Assert.assertEquals("Suite availability Mismatched", expAvailability,
							getText(pom.getAddSuitesPage().getSuiteAvailability()));
					log(Status.PASS, "Suite availability is displayed as expected Exp Suite Availability :" + expAvailability + " Act Suite Availability:"
							+ getText(pom.getAddSuitesPage().getSuiteAvailability()));
					
				} catch (AssertionError e0) {
					log(Status.FAIL, e0.getMessage());
					e0.printStackTrace();
				}				
				
				try {
					String expLocation = readExcel("Test Datas", "AddSuites", 1,1);
					Assert.assertEquals("Location  Mismatched", expLocation,
							getText(pom.getAddSuitesPage().getDefaultLocationName()));
					log(Status.PASS, "Location displayed successfully Exp Location : " + expLocation + " Actual Location :"
							+ getText(pom.getAddSuitesPage().getDefaultLocationName()));

				} catch (AssertionError e2) {
					log(Status.FAIL, e2.getMessage());
					e2.printStackTrace();
				}

				try {
					String expLength = readExcel("Test Datas", "AddSuites", 1, 2);
					Assert.assertEquals("Created Length data Mismatched", expLength,
							getText(pom.getAddSuitesPage().getCreatedLength()));
					log(Status.PASS, "Length is created successfully Exp Length :" + expLength + " Actual Length :"
							+ getText(pom.getAddSuitesPage().getCreatedLength()));
				} catch (AssertionError e3) {
					log(Status.FAIL, e3.getMessage());
					e3.printStackTrace();
				}

				try {
					String expWidth = readExcel("Test Datas", "AddSuites", 1, 3);
					Assert.assertEquals("Created width data  Mismatched", expWidth,
							getText(pom.getAddSuitesPage().getCreatedWidth()));
					log(Status.PASS, "Width is created successfully Exp width : " + expWidth + " Actual width :"
							+ getText(pom.getAddSuitesPage().getCreatedWidth()));

				} catch (AssertionError e4) {
					log(Status.FAIL, e4.getMessage());
					e4.printStackTrace();
				}

				try {
					String expHeight = readExcel("Test Datas", "AddSuites", 1, 4);
					Assert.assertEquals("Created height data Mismatched", expHeight,
							getText(pom.getAddSuitesPage().getCreatedHeight()));
					log(Status.PASS, "Height is created successfully Exp height : " + expHeight + " Actual height : "
							+ getText(pom.getAddSuitesPage().getCreatedHeight()));

				} catch (AssertionError e5) {
					log(Status.FAIL, e5.getMessage());
					e5.printStackTrace();
				}
				
		
	}
			
	@Then("User should verify the breadcrums link should be display with module suite name > selected suite name")
	public void user_should_verify_the_breadcrums_link_should_be_display_with_module_suite_name_selected_suite_name()
			throws Exception {

		logStep(methodName());

		String txtBreadCrum = getText(pom.getAddSuitesPage().getBreadCrumLink());
		System.out.println("Breadcrums Suite text - " + txtBreadCrum);
		System.out.println("Breadcrums Suite>createdSN text - " + pom.getAddSuitesPage().breadCrumSuiteNameText());

		if (txtBreadCrum.contains("Suites") && pom.getAddSuitesPage().breadCrumSuiteNameText()
				.contains(pom.getAddSuitesPage().readExcel("Test Datas", "AddSuites", 2, 6))) {
			log(Status.PASS,
					"Breadcrums link name is displayed as expected :" + pom.getAddSuitesPage().breadCrumSuiteNameText());
			System.out.println("Breadcrums link is displayed with selected suiteName");
		} else {
			log(Status.FAIL, "Breadcrums link name is NOT displayed with selected suiteName");
			throw new Exception("Assertion Failed : Breadcrums link is not displayed with selected suiteName");
		}
	}

	@Then("User should verify after click the breadcrums link it should be return to Suite searched page")
	public void user_should_verify_after_click_the_breadcrums_link_it_should_be_return_to_suite_searched_page()
			throws Exception {

		logStep(methodName());
		
		pom.getAddSuitesPage().returnToSuitesPageBCText();

		waitForFullPageElementLoad();

		if (pom.getAddSuitesPage().getView().isDisplayed()) {
			log(Status.PASS, "Return to Suite searched page successfully after click the [Suites >] breadcrum link");
			System.out.println("Breadcrums link is successfully returned to suite searched page");
		} else {
			log(Status.FAIL, "Unable to Return to Suite searched page after click the [Suites >] breadcrum link");
			throw new Exception("Assertion Failed : Breadcrums link is not returned to suite searched page");
		}
	}

}