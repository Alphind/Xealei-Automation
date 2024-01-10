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
		   
			logStep(methodName());
			
		pom.getEditSuitesPage().searchBox(1);	
		}

		@Then("User should verify the Edit Suite button is working")
		public void user_should_verify_the_edit_suite_button_is_working(){
		    
			logStep(methodName());
		
			pom.getEditSuitesPage().editButton();            
		}

		@Then("User should verify the Edit Suite pop up screen is displayed")
		public void user_should_verify_the_edit_suite_pop_up_screen_is_displayed() throws Exception {
		    
			logStep(methodName());
			
			waitForPageLoad();
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
			
		    
			logStep(methodName());

			deleteExistFieldData(pom.getEditSuitesPage().getSuiteName());
			pom.getEditSuitesPage().dataForSuiteLimit();
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
			
			try {
				String expLocation = readExcel("Test Datas", "EditSuites", 1,1);
				Assert.assertEquals("Location  Mismatched in Edit Suite Page", expLocation,
						getText(pom.getAddSuitesPage().getDefaultLocationName()));
				log(Status.PASS, "Location displayed as expected Exp Location : " + expLocation + " Actual Location :"
						+ getText(pom.getAddSuitesPage().getDefaultLocationName()));

			} catch (AssertionError e2) {
				log(Status.FAIL, e2.getMessage());
				e2.printStackTrace();
			}
			
		    
		}
		
		@Then("User should verify the Edit Suite form for mandatory {string}")
		public void user_should_verify_the_edit_suite_form_for_mandatory_and(String expSNMandatoryTxt) {
		    
			logStep(methodName());

			waitForPageLoad();
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
		    
			logStep(methodName());

			pom.getEditSuitesPage().existSuiteName(1);
			pom.getEditSuitesPage().updateButton();

			waitForPageLoad();
			
			try {
				Assert.assertEquals("Suite Name already exists.Toast message is not displayed", expSuiteExistToastMessage,
						getText(pom.getEditSuitesPage().getSNExitsToastMsg()));
				log(Status.PASS, "Suite Name already exists. Toast Message is displayed - "
						+ getText(pom.getEditSuitesPage().getSNExitsToastMsg()));

			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}
			waitForPageLoad();
			pom.getEditSuitesPage().snAlreadyExistToastMsgOkButton();
		}
		
		@Then("User should verify the x icon in edit suite screen is working")
		public void user_should_verify_the_x_icon_in_edit_suite_screen_is_working() throws Exception {
		    
			logStep(methodName());

			pom.getEditSuitesPage().closePopup();

			if (pom.getEditSuitesPage().getBtnEditSuite().isEnabled()) {
				log(Status.PASS, "Edit Suite popup is closed");
			} else {
				log(Status.FAIL, "Edit Suite popup is not closed");
				throw new Exception("Assertion Failed");
			}   
		}
		
		@Then("User should verify the user able to change the status as InActive and is displayed accordingly on update of Availability field in Edit screen")
		public void user_should_verify_the_user_able_to_change_the_status_as_InActive_and_is_displayed_accordingly_on_update_of_availability_field_in_edit_screen() throws Exception {
		    	
			logStep(methodName());
    
           pom.getEditSuitesPage().editButton();
		    waitForPageLoad();
		    
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
				Assert.assertEquals("Saved Successfull Toast Message is not displayed", "Saved Successfully!!",
						getText(pom.getEditSuitesPage().getSavedSuccessfullToastMsg()));
				log(Status.PASS, "Toast Message is displayed : "
						+ getText(pom.getEditSuitesPage().getSavedSuccessfullToastMsg()));

			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}
			pom.getEditSuitesPage().savedSuccessfulToastMsgOkButton();
			
			waitForPageLoad();
			
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
				    
					logStep(methodName());
					
					waitForPageLoad();

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
				
					logStep(methodName());
					
					pom.getEditSuitesPage().returnToSuitesPageBCText();

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
					public void user_should_update_all_fields_and_verify_the_toast_message_after_update_all_fields_in_edit_suite_page(String string) {
					    
						logStep(methodName());
						
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

						waitForPageLoad();
						try {
							Assert.assertEquals("Saved Successfull Toast Message is not displayed", "Saved Successfully!!",
									getText(pom.getAddSuitesPage().getSavedSuccessfullToastMessage()));
							log(Status.PASS, "Toast Message is displayed : "
									+ getText(pom.getAddSuitesPage().getSavedSuccessfullToastMessage()));							

						} catch (AssertionError e) {
							log(Status.FAIL, e.getMessage());
							e.printStackTrace();
						}
						pom.getAddSuitesPage().savedSuccessfulToastMsgOkButton();
					}


					@Then("User should verify all fields are created successsfully in edit Suite Page")
					public void user_should_verify_all_fields_are_created_successsfully_in_edit_suite_page() throws Exception {
					    
						logStep(methodName());
						
						deleteExistFieldData(pom.getEditSuitesPage().getSuitesSearchBox());
						waitForPageLoad();
						
						pom.getEditSuitesPage().returnToSuitesPageBCText();
						waitForPageLoad();

						pom.getEditSuitesPage().searchBox(1);
						waitForPageLoad();
						waitForFullPageElementLoad();
						sleep(2000);

						try {
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