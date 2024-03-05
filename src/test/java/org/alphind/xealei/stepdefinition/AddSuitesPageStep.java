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

		stepName(methodName());
		
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

	@Then("User should verify the Occupancy Zone Module is working")
	public void user_should_verify_the_occupancy_zone_module_is_working() {

		stepName(methodName());
		
		pom.getHomePage().navToOccupancyZoneModule();
	}
	
	@Then("User should verify the Suite Module is working")
	public void user_should_verify_the_suite_module_is_working() {

		stepName(methodName());
		
		pom.getHomePage().navToSuitesModule();
		
		try {
			Assert.assertEquals("Unable to navigate Suite Page", "Suites",
					getText(pom.getAddSuitesPage().getSuitesPage()));
			log(Status.PASS, "Navigate to Suites page");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}
	
	@Then("User should clicks on the Add Suite button and verifies that the Add Suite popup screen is displayed")
	public void user_should_clicks_on_the_add_suite_button_and_verifies_that_the_add_suite_popup_screen_is_displayed() throws Exception {
		
		stepName(methodName());
		
		pom.getAddSuitesPage().btnAddSuite();
		
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
		

		stepName(methodName());

		pom.getAddSuitesPage().suiteLimit().addButton();
		
		try {
			waitForVisiblityOfElement(pom.getAddSuitesPage().getSuiteNameLimit(), 10);
			Assert.assertEquals("limit error info message for Suite Name* field is NOT displayed", expLimitValidationMsgForSN,
					getText(pom.getAddSuitesPage().getSuiteNameLimit()));
			log(Status.PASS, "limit error info message for Suite Name* field is displayed - "
					+ getText(pom.getAddSuitesPage().getSuiteNameLimit()));
			pom.getAddSuitesPage().deleteExistSuiteNameFieldData();
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Then("User should verify the field Suite Name * is mandatory {string}")
	public void user_should_verify_the_field_suite_name_is_mandatory(String expSNMandatoryTxt) {

		stepName(methodName());

		pom.getAddSuitesPage().deleteExistSuiteNameFieldData();
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

	@Then("User should verify duplicate validation for Suite name {string}")
	public void user_should_verify_duplicate_validation_for_suite_name(String expSuiteExistToastMessage) throws Exception {

		stepName(methodName());
		
		pom.getAddSuitesPage().existSuiteName(1).addButton();
	
		try {
			waitForPageLoad();
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

	@Then("User should perform only non-mandatory fields and verify the info message contains for Mandatory fields {string}")
	public void user_should_perform_only_non_mandatory_fields_and_verify_the_info_message_contains_for_mandatory_fields(String expSNMandatoryTxt) {

		stepName(methodName());
		
		pom.getAddSuitesPage().deleteExistSuiteNameFieldData();
		
		pom.getAddSuitesPage().enterLengthWidthHeight(1);
		pom.getAddSuitesPage().nonMandatoryFieldIsNotEmpty().addButton();

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
		
		@Then("User should verify the field Suite Name* for limit")
		public void user_should_verify_the_field_suite_name_for_limit() {
			
			stepName(methodName());
			
			pom.getAddSuitesPage().deleteExistLengthWidthHeightFieldsData();
			
			String checkSuiteNameFieldMaxLimit = pom.getAddSuitesPage().checkSuiteNameFieldMaxLimit();
			int length = checkSuiteNameFieldMaxLimit.length();
			if(length==14) {
				
			log(Status.PASS, "Suite Name* field not allows to enter more than 14 characters");
			} else {
				log(Status.FAIL, "Suite Name* field allows to enter More Than 14 characters");
			}
		}

		@Then("User should verify the field Length* for limit")
		public void user_should_verify_the_field_length_for_limit() {

			stepName(methodName());
			
			String checkLengthFieldMaxLimit = pom.getAddSuitesPage().checkLengthFieldMaxLimit(2);
			
			int length = checkLengthFieldMaxLimit.length();
			if(length==11) {
				
				
				log(Status.PASS, "Length* field not allows to enter more than 11 characters");
			} else {
				log(Status.FAIL, "Length* field allows to enter More Than 11 characters");
			}
		}
		
		@Then("User should verify the field Width* for limit")
		public void user_should_verify_the_field_width_for_limit() {

			stepName(methodName());
			
			
             String checkWidthFieldMaxLimit = pom.getAddSuitesPage().checkWidthFieldMaxLimit(2);
			
			int length = checkWidthFieldMaxLimit.length();
			if(length==11) {
				
				log(Status.PASS, "Width* field not allows to enter more than 11 characters");
			} else {
				log(Status.FAIL, "Width* field allows to enter More Than 11 characters");
			}
		    
		}
		
		@Then("User should verify the field Height* for limit")
		public void user_should_verify_the_field_height_for_limit() {

			stepName(methodName());
			
           String checkHeigthFieldMaxLimit = pom.getAddSuitesPage().checkHeigthFieldMaxLimit(2);
			
			int length = checkHeigthFieldMaxLimit.length();
			
			if(length==11) {
				log(Status.PASS, "Height* field not allows to enter more than 11 characters");
			} else {
				log(Status.FAIL, "Height* field allows to enter More Than 11 characters");
			}
		    
		}
		
		@Then("User should verify the field Length* for limit with decimal point")
		public void user_should_verify_the_field_length_for_limit_with_decimal_point() {

			stepName(methodName());
			
			pom.getAddSuitesPage().deleteExistLengthWidthHeightFieldsData();
			
	        String checkLengthFieldMaxLimit = pom.getAddSuitesPage().checkLengthFieldMaxLimit(3);
			
			int length = checkLengthFieldMaxLimit.length();
			if(length==11) {
				
				
				log(Status.PASS, "Length* field not allows to enter more than 11 decimal characters");
			} else {
				log(Status.FAIL, "Length* field allows to enter More Than 11 decimal characters");
			}
		}
		
		@Then("User should verify the field Width* for limit with decimal point")
		public void user_should_verify_the_field_width_for_limit_with_decimal_point() {

			stepName(methodName());
			
			 String checkWidthFieldMaxLimit = pom.getAddSuitesPage().checkWidthFieldMaxLimit(3);
				
				int length = checkWidthFieldMaxLimit.length();
				if(length==11) {
					
					log(Status.PASS, "Width* field not allows to enter more than 11 decimal characters");
				} else {
					log(Status.FAIL, "Width* field allows to enter More Than 11 decimal characters");
				}
		}
		
		@Then("User should verify the field Height* for limit with decimal point")
		public void user_should_verify_the_field_height_for_limit_with_decimal_point() {

			stepName(methodName());
			
			  String checkHeigthFieldMaxLimit = pom.getAddSuitesPage().checkHeigthFieldMaxLimit(3);
				
				int length = checkHeigthFieldMaxLimit.length();
				
				if(length==11) {
					log(Status.PASS, "Height* field not allows to enter more than 11 decimal characters");
				} else {
					log(Status.FAIL, "Height* field allows to enter More Than 11 decimal characters");
				}
			    
		}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
			@Then("User should verify the x icon in add suites screen is working")
			public void user_should_verify_the_icon_in_add_suites_screen_is_working() throws Exception {

				stepName(methodName());

              pom.getAddSuitesPage().closePopup();
				
				String expContent = "Changes you made may not be saved. Are you sure you want to Cancel?";
				
				if(pom.getAddSuitesPage().getClosePopupSuiteName().equals("Suite")) {
					log(Status.PASS, "Close popup is displayed");
				} else {
					log(Status.FAIL, "Close popup is NOT displayed");
					throw new Exception("Assertion Error");
				}
				
				try {
					Assert.assertEquals("Close popup content is NOT displayed as expected", expContent, pom.getAddSuitesPage().getclosePopupContentText());
					log(Status.PASS, "Close popup content is displayed as expected - "+pom.getAddSuitesPage().getclosePopupContentText());
				
					pom.getAddSuitesPage().yesButton();	
					
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}

				waitForFullPageElementLoad();
				
				if (pom.getAddSuitesPage().getBtnAddSuites().isEnabled()) {
					log(Status.PASS, "Add Suite popup is closed");
				} else {
					log(Status.FAIL, "Add Suite popup is not closed");
					throw new Exception("Assertion Failed");
				}
			}

			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			@Then("User should perform suite by entering only Mandatory field")
			public void user_should_perform_suite_by_entering_only_mandatory_field() throws Exception {
			  
				stepName(methodName());
				
				pom.getAddSuitesPage().suiteName(1);
				waitForFullPageElementLoad();
				
				pom.getAddSuitesPage().suiteNameIsNotEmpty();
				pom.getAddSuitesPage().addButton();

				waitForPageLoad();
				try {
					waitForVisiblityOfElement(pom.getAddSuitesPage().getSavedSuccessfullToastMessage(), 10);
					Assert.assertEquals("Saved Successfull Toast Message is not displayed", "Saved Successfully!!",
							getText(pom.getAddSuitesPage().getSavedSuccessfullToastMessage()));
					log(Status.PASS, "Toast Message is displayed : "
							+ getText(pom.getAddSuitesPage().getSavedSuccessfullToastMessage()));

					String createdSuite = readExcelFromLastRow("Test Datas", "CreatedSuites", 0);
					writeExcelToOverwrite("Test Datas","AddSuites", 1, 6, createdSuite);
					writeExcelToOverwrite("Test Datas","EditSuites", 1, 6, createdSuite);
					writeExcelToOverwrite("Test Datas","AddIndividuals", 1, 6, createdSuite);
					
					pom.getAddSuitesPage().savedSuccessfulToastMsgOkButton();
					
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}
			}
			
			@Then("User should perform all fields and verify the toast message after perform all fields {string}")
			public void user_should_perform_all_fields_and_verify_the_toast_message_after_perform_all_fields(String expToastMsg)
					throws Exception {

				stepName(methodName());
				
				pom.getAddSuitesPage().suiteName(1);
				
				waitForFullPageElementLoad();
				pom.getAddSuitesPage().suiteNameIsNotEmpty();
				
				pom.getAddSuitesPage().enterLengthWidthHeight(1);
				pom.getAddSuitesPage().nonMandatoryFieldIsNotEmpty();
				pom.getAddSuitesPage().addButton();

				waitForPageLoad();
				try {
					waitForVisiblityOfElement(pom.getAddSuitesPage().getSavedSuccessfullToastMessage(), 10);
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

			@Then("User should search the created suite by performed all fields")
			public void user_should_search_the_created_suite_by_performed_all_fields() throws Exception {
			   
				stepName(methodName());
				
				pom.getAddSuitesPage().searchBox();
				waitForFullPageElementLoad();

			}
			
			@Then("User should verify all fields are created successsfully")
			public void user_should_verify_all_fields_are_created_successsfully() throws Exception {

				stepName(methodName());

				try {
					waitForVisiblityOfElement(pom.getAddSuitesPage().getCreatedSuiteName(), 10);
					String expSuiteName = readExcel("Test Datas", "AddSuites", 2, 6);
					Assert.assertEquals("Displayed SuiteName Mismatched", expSuiteName,
							getText(pom.getAddSuitesPage().getCreatedSuiteName()));
					log(Status.PASS, "Suite Name is displayed successfully Exp SN :" + expSuiteName + " Actual SN :"
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
					Assert.assertEquals("Displayed Length data Mismatched", expLength,
							getText(pom.getAddSuitesPage().getCreatedLength()));
					log(Status.PASS, "Length is displayed successfully Exp Length :" + expLength + " Actual Length :"
							+ getText(pom.getAddSuitesPage().getCreatedLength()));
				} catch (AssertionError e3) {
					log(Status.FAIL, e3.getMessage());
					e3.printStackTrace();
				}

				try {
					String expWidth = readExcel("Test Datas", "AddSuites", 1, 3);
					Assert.assertEquals("Created width data  Mismatched", expWidth,
							getText(pom.getAddSuitesPage().getCreatedWidth()));
					log(Status.PASS, "Width is displayed successfully Exp width : " + expWidth + " Actual width :"
							+ getText(pom.getAddSuitesPage().getCreatedWidth()));

				} catch (AssertionError e4) {
					log(Status.FAIL, e4.getMessage());
					e4.printStackTrace();
				}

				try {
					String expHeight = readExcel("Test Datas", "AddSuites", 1, 4);
					Assert.assertEquals("Created height data Mismatched", expHeight,
							getText(pom.getAddSuitesPage().getCreatedHeight()));
					log(Status.PASS, "Height is displayed successfully Exp height : " + expHeight + " Actual height : "
							+ getText(pom.getAddSuitesPage().getCreatedHeight()));

				} catch (AssertionError e5) {
					log(Status.FAIL, e5.getMessage());
					e5.printStackTrace();
				}
				
		
	}
			
	@Then("User should verify the breadcrums link should be display with module suite name > selected suite name")
	public void user_should_verify_the_breadcrums_link_should_be_display_with_module_suite_name_selected_suite_name()
			throws Exception {

		stepName(methodName());

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

		stepName(methodName());
		
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