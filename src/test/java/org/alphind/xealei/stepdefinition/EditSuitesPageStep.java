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

public class EditSuitesPageStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager(getDriver());
	
		@Then("User should search the created suite")
		public void user_should_search_the_created_suite() throws Exception {
		   
			logWithLabelName(getMethodName());
			
			waitForFullPageElementLoad();
			
		pom.getAddSuitesPage().searchBox();	
		}

		@Then("User should clicks on the Edit Suite button and verifies that the Edit Suite screen is displayed")
		public void user_should_clicks_on_the_edit_suite_button_and_verifies_that_the_edit_suite_screen_is_displayed() throws Exception {
			
			logWithLabelName(getMethodName());
			
			pom.getEditSuitesPage().editButton();           
		
			String popupText = getText(pom.getEditSuitesPage().getEditSuitePopup());

			if (popupText.contains("Edit Suite")) {
				log(Status.PASS, "Edit Suite popup is displayed");
			} else {
				log(Status.FAIL, "Edit Suite popup is not displayed");
				throw new Exception("Assertion Failed");
			}
		}
		
		@Then("User should verify the limit error info message for Suite Name* field {string} in edit suite page")
		public void user_should_verify_the_limit_error_info_message_for_suite_Name_field_in_edit_suite_page (String expLimitValidationMsgForSN) {
			
		    
			logWithLabelName(getMethodName());

			deleteExistFieldData(pom.getEditSuitesPage().getSuiteName());
			pom.getEditSuitesPage().enterDataToCheckTheLimitInSuiteTextbox();
			pom.getEditSuitesPage().updateButton();
			
			try {
				Assert.assertEquals("Validation message for suiteName limit is not displayed", expLimitValidationMsgForSN,
						getText(pom.getEditSuitesPage().getValMsgForsuiteNameLimit()));
				log(Status.PASS, "Limit validation message for suiteName limit is displayed - "
						+ getText(pom.getEditSuitesPage().getValMsgForsuiteNameLimit()));
			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}	
		    
		}
		
		@Then("User should verify the Edit Suite form for mandatory {string}")
		public void user_should_verify_the_edit_suite_form_for_mandatory_and(String expSNMandatoryTxt) {
		    
			logWithLabelName(getMethodName());
			
			deleteExistFieldData(pom.getEditSuitesPage().getSuiteName());
			deleteExistFieldData(pom.getAddSuitesPage().getLength());
			deleteExistFieldData(pom.getAddSuitesPage().getWidth());
			deleteExistFieldData(pom.getAddSuitesPage().getHeight());
			
			pom.getEditSuitesPage().enterLengthWidthHeight(1);
			
			pom.getEditSuitesPage().updateButton();
			
			try {
				Assert.assertEquals("Validation message for suiteName not displayed", expSNMandatoryTxt,
						getText(pom.getEditSuitesPage().getValidationMsgForSuiteName()));
				log(Status.PASS, "Validation message for suiteName is displayed : "
						+ getText(pom.getEditSuitesPage().getValidationMsgForSuiteName()));
			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}
		}
		
		
		@Then("User should verify duplicate validation for Suite name {string} in edit suite page")
		public void user_should_verify_duplicate_validation_for_suite_name_in_edit_suite_page(String expSuiteExistToastMessage) throws Exception {
		    
			logWithLabelName(getMethodName());

			pom.getEditSuitesPage().existSuiteName(1);
			pom.getEditSuitesPage().updateButton();

			waitForPageLoad();
			
			try {
				Assert.assertEquals("Suite Name already exists.Toast message is not displayed", expSuiteExistToastMessage,
						getText(pom.getEditSuitesPage().getSNExitsToastMsg()));
				log(Status.PASS, "Suite Name already exists. Toast Message is displayed - "
						+ getText(pom.getEditSuitesPage().getSNExitsToastMsg()));

				pom.getEditSuitesPage().snAlreadyExistToastMsgOkButton();
				
			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}
			
			// Next Step Request
			
		pom.getAddSuitesPage().deleteExistSuiteNameFieldData();
		
		}
		
		@Then("User should verify the field Suite Name* for limit in edit suite popup")
		public void user_should_verify_the_field_suite_name_for_limit_in_edit_suite_popup() {
			
			logWithLabelName(getMethodName());
			
			pom.getAddSuitesPage().deleteExistLengthWidthHeightFieldsData();
			
			String checkSuiteNameFieldMaxLimit = pom.getAddSuitesPage().checkSuiteNameFieldMaxLimit();
			int length = checkSuiteNameFieldMaxLimit.length();
			if(length==14) {
				
			log(Status.PASS, "Suite Name* field not allows to enter more than 14 characters");
			} else {
				log(Status.FAIL, "Suite Name* field allows to enter More Than 14 characters");
			}
		}

		@Then("User should verify the field Length* for limit in edit suite popup")
		public void user_should_verify_the_field_length_for_limit_in_edit_suite_popup() {

			logWithLabelName(getMethodName());
			
			String checkLengthFieldMaxLimit = pom.getAddSuitesPage().checkLengthFieldMaxLimit(2);
			
			int length = checkLengthFieldMaxLimit.length();
			if(length==11) {
				
				
				log(Status.PASS, "Length* field not allows to enter more than 11 characters");
			} else {
				log(Status.FAIL, "Length* field allows to enter More Than 11 characters");
			}
		}
		
		@Then("User should verify the field Width* for limit in edit suite popup")
		public void user_should_verify_the_field_width_for_limit_in_edit_suite_popup() {

			logWithLabelName(getMethodName());
			
             String checkWidthFieldMaxLimit = pom.getAddSuitesPage().checkWidthFieldMaxLimit(2);
			
			int length = checkWidthFieldMaxLimit.length();
			
			if(length==11) {
				
				log(Status.PASS, "Width* field not allows to enter more than 11 characters");
			} else {
				log(Status.FAIL, "Width* field allows to enter More Than 11 characters");
			}
		    
		}
		
		@Then("User should verify the field Height* for limit in edit suite popup")
		public void user_should_verify_the_field_height_for_limit() {

			logWithLabelName(getMethodName());
			
           String checkHeigthFieldMaxLimit = pom.getAddSuitesPage().checkHeigthFieldMaxLimit(2);
			
			int length = checkHeigthFieldMaxLimit.length();
			
			if(length==11) {
				log(Status.PASS, "Height* field not allows to enter more than 11 characters");
			} else {
				log(Status.FAIL, "Height* field allows to enter More Than 11 characters");
			}
		    
		}
		
		@Then("User should verify the field Length* for limit with decimal point in edit suite popup")
		public void user_should_verify_the_field_length_for_limit_with_decimal_point_in_edit_suite_popup() {

			logWithLabelName(getMethodName());
			
			pom.getAddSuitesPage().deleteExistLengthWidthHeightFieldsData();
			
	        String checkLengthFieldMaxLimit = pom.getAddSuitesPage().checkLengthFieldMaxLimit(3);
			
			int length = checkLengthFieldMaxLimit.length();
			if(length==11) {
				
				
				log(Status.PASS, "Length* field not allows to enter more than 11 decimal characters");
			} else {
				log(Status.FAIL, "Length* field allows to enter More Than 11 decimal characters");
			}
		}
		
		@Then("User should verify the field Width* for limit with decimal point in edit suite popup")
		public void user_should_verify_the_field_width_for_limit_with_decimal_point_in_edit_suite_popup() {

			logWithLabelName(getMethodName());
			
			 String checkWidthFieldMaxLimit = pom.getAddSuitesPage().checkWidthFieldMaxLimit(3);
				
				int length = checkWidthFieldMaxLimit.length();
				if(length==11) {
					
					log(Status.PASS, "Width* field not allows to enter more than 11 decimal characters");
				} else {
					log(Status.FAIL, "Width* field allows to enter More Than 11 decimal characters");
				}
		}
		
		
		@Then("User should verify the field Height* for limit with decimal point in edit suite popup")
		public void user_should_verify_the_field_height_for_limit_with_decimal_point_in_edit_suite_popup() {

			logWithLabelName(getMethodName());
			
			  String checkHeigthFieldMaxLimit = pom.getAddSuitesPage().checkHeigthFieldMaxLimit(3);
				
				int length = checkHeigthFieldMaxLimit.length();
				
				if(length==11) {
					log(Status.PASS, "Height* field not allows to enter more than 11 decimal characters");
				} else {
					log(Status.FAIL, "Height* field allows to enter More Than 11 decimal characters");
				}
		}
				
		@Then("User should verify the x icon in edit suite screen is working")
		public void user_should_verify_the_x_icon_in_edit_suite_screen_is_working() throws Exception {
		    
			logWithLabelName(getMethodName());

			pom.getEditSuitesPage().closePopup();
			
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

			if (pom.getEditSuitesPage().getBtnEditSuite().isEnabled()) {
				log(Status.PASS, "Edit Suite popup is closed");
			} else {
				log(Status.FAIL, "Edit Suite popup is not closed");
				throw new Exception("Assertion Failed");
			}   
		}
		
		@Then("User should verify the user able to change the status as InActive and is displayed accordingly on update of Availability field in Edit screen")
		public void user_should_verify_the_user_able_to_change_the_status_as_InActive_and_is_displayed_accordingly_on_update_of_availability_field_in_edit_screen() throws Exception {
		    	
			logWithLabelName(getMethodName());
    
           pom.getEditSuitesPage().editButton();
		    
		    try {
				Assert.assertEquals("The default Availability status is mismatched", readExcel("Test Datas", "EditSuites", 1, 5), getText(pom.getEditSuitesPage().getActive()));
			   log(Status.PASS, "Default Availability * field status is displayed as expected - " +"exp value - "+readExcel("Test Datas", "EditSuites", 1, 5)+ ",Act value - "+getText(pom.getEditSuitesPage().getActive()));
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}
		    pom.getEditSuitesPage().availabilityStatus(2);
		    pom.getEditSuitesPage().updateButton();  
		    
			try {
				waitForVisiblityOfElement(pom.getEditSuitesPage().getSavedSuccessfullToastMsg(), 10);
				Assert.assertEquals("Saved Successfull Toast Message is not displayed", "Saved Successfully!!",
						getText(pom.getEditSuitesPage().getSavedSuccessfullToastMsg()));
				log(Status.PASS, "Toast Message is displayed : "
						+ getText(pom.getEditSuitesPage().getSavedSuccessfullToastMsg()));

				pom.getEditSuitesPage().savedSuccessfulToastMsgOkButton();
				
			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}
			
			
			
			 try {
					Assert.assertEquals("The drop down field Availability status is mismatched", readExcel("Test Datas", "EditSuites", 2, 5), getText(pom.getEditSuitesPage().getInActive()));
				   log(Status.PASS, "The drop down Availability * field status is displayed as expected - " +"exp value - "+readExcel("Test Datas", "EditSuites", 2, 5)+ ",Act value - "+getText(pom.getEditSuitesPage().getInActive()));
					} catch (AssertionError e) {
						log(Status.FAIL, e.getMessage());
						e.printStackTrace();
					}
			
		}


@Then("User should verify the breadcrums link should be display with module suite name > selected suite name in edit suite page")
				public void user_should_verify_the_breadcrums_link_should_be_display_with_module_suite_name_selected_suite_name_in_edit_suite_page() throws Exception {
				    
					logWithLabelName(getMethodName());

					String txtBreadCrum = getText(pom.getEditSuitesPage().getBreadCrumLink());
					System.out.println("Breadcrums Suite text - " + txtBreadCrum);
					System.out.println("Breadcrums Suite> createdSN text - " + pom.getEditSuitesPage().breadCrumSuiteNameText());

					if (txtBreadCrum.contains("Suites") && pom.getEditSuitesPage().breadCrumSuiteNameText()
							.contains(pom.getEditSuitesPage().readExcel("Test Datas", "EditSuites", 2, 6))) {
						log(Status.PASS,
								"Breadcrums link is displayed as expected in Edit Suite page: "+pom.getEditSuitesPage().breadCrumSuiteNameText());
						System.out.println("Breadcrums link is displayed with selected suiteName");
					} else {
						log(Status.FAIL, "Breadcrums link is not displayed with selected suiteName in Edit Suite page");
						throw new Exception("Assertion Failed : Breadcrums link is not displayed with selected suiteName");
					}
					
				}
				
				@Then("User should verify after click the breadcrums link it should be return to Suite searched page in edit suite page")
				public void user_should_verify_after_click_the_breadcrums_link_it_should_be_return_to_suite_searched_page_in_edit_suite_page() throws Exception {
				
					logWithLabelName(getMethodName());
					
					pom.getEditSuitesPage().returnToSuitesPageBCText();

					deleteExistFieldData(pom.getEditSuitesPage().getSuitesSearchBox());
					
					waitForPageLoad();

					if (pom.getEditSuitesPage().getView().isDisplayed()) {
						
						log(Status.PASS, "Return to Suite searched page successfully after click the [Suites >] breadcrum link in Edit Suite page");
						System.out.println("Breadcrums link is successfully returned to suite searched page");
					} else {
						log(Status.FAIL, "Unable to Return to Suite searched page after click the [Suites >] breadcrum link in Edit Suite page");
						throw new Exception("Assertion Failed : Breadcrums link is not returned to suite searched page");
					}
				}

					@Then("User should update all fields and verify the toast message after update all fields {string} in edit Suite Page")
					public void user_should_update_all_fields_and_verify_the_toast_message_after_update_all_fields_in_edit_suite_page(String string) throws Exception {
					    
						logWithLabelName(getMethodName());
						
						writeExcel("Test Datas", "UpdatedSuites", 0, getAttribute(pom.getEditSuitesPage().getSuiteName(),"value"));
						
						deleteExistFieldData(pom.getAddSuitesPage().getSuiteName());
						deleteExistFieldData(pom.getAddSuitesPage().getLength());
						deleteExistFieldData(pom.getAddSuitesPage().getWidth());
						deleteExistFieldData(pom.getAddSuitesPage().getHeight());

						pom.getEditSuitesPage().UpdatecreatedSuiteName(1);
						pom.getEditSuitesPage().enterLengthWidthHeight(1);
						
						String checkSuiteStatus = getText(pom.getEditSuitesPage().getCheckAvailabilityStatus());
						
						if(checkSuiteStatus.equals("In-Active")) {
							pom.getEditSuitesPage().availabilityStatus(1);
							log(Status.INFO, "Changed the Suite Status to Active");
						}
						
						pom.getEditSuitesPage().updateButton();

						try {
							waitForVisiblityOfElement(pom.getAddSuitesPage().getSavedSuccessfullToastMessage(),10);
							Assert.assertEquals("Saved Successfull Toast Message is not displayed", "Saved Successfully!!",
									getText(pom.getAddSuitesPage().getSavedSuccessfullToastMessage()));
							log(Status.PASS, "Toast Message is displayed : "
									+ getText(pom.getAddSuitesPage().getSavedSuccessfullToastMessage()));							

							pom.getAddSuitesPage().savedSuccessfulToastMsgOkButton();
							
						} catch (AssertionError e) {
							log(Status.FAIL, e.getMessage());
							e.printStackTrace();
						}
						
					}


					@Then("User should verify all fields are updated successsfully in edit Suite Page")
					public void user_should_verify_all_fields_are_updated_successsfully_in_edit_suite_page() throws Exception {
					    
						logWithLabelName(getMethodName());
						
						//pom.getEditSuitesPage().searchBox(1);
						
						waitForPageLoad();
				
						try {
							waitForVisiblityOfElement(pom.getAddSuitesPage().getCreatedSuiteName(), 10);
							String expSuiteName = readExcel("Test Datas", "EditSuites", 2, 6);
							Assert.assertEquals("Updated SuiteName Mismatched", expSuiteName,
									getText(pom.getAddSuitesPage().getCreatedSuiteName()));
							log(Status.PASS, "Suite Name is updated successfully Exp SN :" + expSuiteName + " Actual SN :"
									+ getText(pom.getAddSuitesPage().getCreatedSuiteName()));

							String updatedSuite = getText(pom.getEditSuitesPage().getCreatedSN());
							
							writeExcelLastRow("Test Datas", "UpdatedSuites", 1, updatedSuite);	
							writeExcelToOverwrite("Test Datas","EditSuites", 2, 6, updatedSuite);
							writeExcelToOverwrite("Test Datas","AddIndividuals", 2, 6, updatedSuite);
							
						} catch (AssertionError e1) {
							log(Status.FAIL, e1.getMessage());
							e1.printStackTrace();
						}
						try {
							waitForVisiblityOfElement(pom.getAddSuitesPage().getDefaultLocationName(), 10);
							String expLocation = readExcel("Test Datas", "EditSuites", 1, 1);
							Assert.assertEquals("Default LocationName  Mismatched", expLocation,
									getText(pom.getAddSuitesPage().getDefaultLocationName()));
							log(Status.PASS, "Default Location is displayed Exp Location : " + expLocation + " Actual Location :"
									+ getText(pom.getAddSuitesPage().getDefaultLocationName()));

						} catch (AssertionError e2) {
							log(Status.FAIL, e2.getMessage());
							e2.printStackTrace();
						}

						try {
							waitForVisiblityOfElement(pom.getAddSuitesPage().getCreatedLength(), 10);
							String expLength = readExcel("Test Datas", "EditSuites", 1, 2);
							Assert.assertEquals("updated Length data Mismatched", expLength,
									getText(pom.getAddSuitesPage().getCreatedLength()));
							log(Status.PASS, "Length is updated successfully Exp Length :" + expLength + " Actual Length :"
									+ getText(pom.getAddSuitesPage().getCreatedLength()));
						} catch (AssertionError e3) {
							log(Status.FAIL, e3.getMessage());
							e3.printStackTrace();
						}

						try {
							waitForVisiblityOfElement(pom.getAddSuitesPage().getCreatedWidth(), 10);
							String expWidth = readExcel("Test Datas", "EditSuites", 1, 3);
							Assert.assertEquals("updated width data  Mismatched", expWidth,
									getText(pom.getAddSuitesPage().getCreatedWidth()));
							log(Status.PASS, "Width is updated successfully Exp width : " + expWidth + " Actual width :"
									+ getText(pom.getAddSuitesPage().getCreatedWidth()));

						} catch (AssertionError e4) {
							log(Status.FAIL, e4.getMessage());
							e4.printStackTrace();
						}

						try {
							waitForVisiblityOfElement(pom.getAddSuitesPage().getCreatedHeight(), 10);
							String expHeight = readExcel("Test Datas", "EditSuites", 1, 4);
							Assert.assertEquals("updated height data Mismatched", expHeight,
									getText(pom.getAddSuitesPage().getCreatedHeight()));
							log(Status.PASS, "Height is updated successfully Exp height : " + expHeight + " Actual height : "
									+ getText(pom.getAddSuitesPage().getCreatedHeight()));

						} catch (AssertionError e5) {
							log(Status.FAIL, e5.getMessage());
							e5.printStackTrace();
						}
					}
					
}