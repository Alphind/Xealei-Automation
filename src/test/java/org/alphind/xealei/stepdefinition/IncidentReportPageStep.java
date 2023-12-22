package org.alphind.xealei.stepdefinition;

import org.alphind.xealei.baseclass.BaseClass;
import org.alphind.xealei.pom.PageObjectManager;
import org.junit.Assert;

import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IncidentReportPageStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@When("User should perform login as facility admin {string} and {string}")
	public void user_should_perform_login_as_facility_admin(String userName, String password) {

		logStep(methodName());

//			pom.getLoginPage().validEmail(1);
//			pom.getLoginPage().validPassword(1);
//			pom.getLoginPage().loginButton();
//            waitForPageLoad();

		sendKeys(pom.getLoginPage().getUserName(), userName);
		sendKeys(pom.getLoginPage().getPassword(), password);
		pom.getLoginPage().loginButton();
		waitForPageLoad();

	}

	@Then("User should also verify the performed login as {string}")
	public void user_should_also_verify_the_performed_login_as(String adminName) {

		String text = getText(pom.getHomePage().getAdminName());

		Assert.assertEquals("Login page url is wrong", adminName, text);
		System.out.println("EXP Value" + adminName);
		System.out.println("ACT Value" + text);

	}

	@Then("User should verify the Incident report module is working")
	public void user_should_verify_the_incident_report_module_is_working() {

		pom.getHomePage().reportsModule().incidentReportModule();
		waitForPageLoad();

		try {
			Assert.assertEquals("Unable to navigate Reports>Incident Reports Module ", "Incident Reports",
					getText(pom.getIncidentReportPage().getIncidentReportModuleText()));
			log(Status.PASS, "Incident Report sub-module button is working");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should verify the ADD New Incident Report button is working")
	public void user_should_verify_the_add_new_incident_report_button_is_working() {

		try {
			pom.getIncidentReportPage().addNewIncidentReportButton();
			log(Status.INFO, "ADD New Incident Report button is working as expected");
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

		@Then("User should verify the save button is disabled")
		public void user_should_verify_the_save_button_is_disabled() {
		    
			String saveButtonDisabled = getAttribute(pom.getIncidentReportPage().getSaveButton(), "disabled");
			if (saveButtonDisabled.equalsIgnoreCase("true")) {
				log(Status.PASS, "SAVE button is disabled after enter into Add Incidet Report Page");
			} else {
				log(Status.FAIL, "SAVE button is NOT disabled after enter into Add Incidet Report Page");
			}
		}
	
		@Then("User should verify Next > button is working")
		public void user_should_verify_next_button_is_working() {
		
			pom.getIncidentReportPage().nextButton();
		}
		
		@Then("User should verify the validation info message under all fields {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
		public void user_should_verify_the_validation_info_message_under_all_fields(String expIndDetailsInfoMsg, String expEventDateAndTimeInfoMsg, String expWhatCausedAFall, String expWasInjuredInfoMsg, String expInjuryDescriptionInfoMsg, String expInjurySiteInfoMsg, String expTreatmentReceivedInfoMsg, String expFutureTreatmentInfoMsg, String expInjuryTypeInfoMsg, String expInjuryColorInfoMsg, String expInjurySevereInfoMsg, String expPersonNotifiedInfoMsg, String expRelationshipInfoMsg, String expNotificationDateInfoMsg, String expNotificationTimeInfoMsg, String expNotifiedByInfoMsg) {
		 
			
			try {
				Assert.assertEquals("MF validation info msg is NOT displayed as expected under Individual’s Details field", expIndDetailsInfoMsg,
						getText(pom.getIncidentReportPage().getIndividualsDetailsValidationInfoMsg()));
				log(Status.PASS, "MF validation info msg is displayed as expected under Individual’s Details field");
			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}
						
			try {
				Assert.assertEquals("MF validation info msg is NOT displayed as expected under Event Date & Time field", expEventDateAndTimeInfoMsg,
						getText(pom.getIncidentReportPage().getEventDateAndTimeValidationInfoMsg()));
				log(Status.PASS, "MF validation info msg is displayed as expected under Event Date & Time field");
			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}
		
			
		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under What caused the fall? field", expWhatCausedAFall,
					getText(pom.getIncidentReportPage().getFallCausedValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under What caused the fall? field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Was injured? field", expWasInjuredInfoMsg,
					getText(pom.getIncidentReportPage().getChooseWasIndInjuredRadioButtonValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Was injured? field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		pom.getIncidentReportPage().selectIndividualDetailsDropdown();
	
		pom.getIncidentReportPage().wasPatientInjuredRadioButton();
		
		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Injury Description field", expInjuryDescriptionInfoMsg,
					getText(pom.getIncidentReportPage().getInjuryDescriptionValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Injury Description field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Injury Site field", expInjurySiteInfoMsg,
					getText(pom.getIncidentReportPage().getInjurySiteValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Injury Site field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Treatment Received field", expTreatmentReceivedInfoMsg,
					getText(pom.getIncidentReportPage().getTreatmentReceivedValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Treatment Received field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Future Treatment field", expFutureTreatmentInfoMsg,
					getText(pom.getIncidentReportPage().getFutureTreatmentValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Future Treatment field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Injury Type field", expInjuryTypeInfoMsg,
					getText(pom.getIncidentReportPage().getInjuryTypeValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Injury Type field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Injury Color field", expInjuryColorInfoMsg,
					getText(pom.getIncidentReportPage().getInjuryColorValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Injury Color field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Injury Serve field", expInjurySevereInfoMsg,
					getText(pom.getIncidentReportPage().getInjurySeverityValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Injury Serve field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Person Notified field", expPersonNotifiedInfoMsg,
					getText(pom.getIncidentReportPage().getPersonNotifiedValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Person Notified field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Relationship field", expRelationshipInfoMsg,
					getText(pom.getIncidentReportPage().getRelationshipValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Relationship field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Notification Date field", expNotificationDateInfoMsg,
					getText(pom.getIncidentReportPage().getChooseNotifiationDateValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Notification Date field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Notification Time field", expNotificationTimeInfoMsg,
					getText(pom.getIncidentReportPage().getChooseNotifiationTimeValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Notification Time field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Notified By field", expNotifiedByInfoMsg,
					getText(pom.getIncidentReportPage().getNotifiedValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Notified By field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		pom.getIncidentReportPage().injuryDescription();
	}

		@Then("User should verify after perform individual deta Save button is working in IR Page")
		public void user_should_verify_after_perform_individual_deta_save_button_is_working_in_ir_page() {
		
		pom.getIncidentReportPage().saveButton();
	
		}
		
		@Then("User should verify the toast message after click Save button in IR Page {string}")
		public void user_should_verify_the_toast_message_after_click_save_button_in_ir_page(String string) {
		  
			try {
				Assert.assertEquals("Saved Successfull Toast Message is not displayed", "Saved Successfully!!",
						getText(pom.getIncidentReportPage().getSavedSuccessfullToastMsg()));
				log(Status.PASS, "Toast Message is displayed : "
						+ getText(pom.getIncidentReportPage().getSavedSuccessfullToastMsg()));
				
			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}
			pom.getIncidentReportPage().savedSuccessfulToastMsgOkButton();
		
		}
		
		@Then("User should verify the respective individual report status {string}")
		public void user_should_verify_the_respective_individual_report_status(String string) {
		
		pom.getIncidentReportPage().getIndividualsGrid();
		
		}

			@Then("User should verify the view button is working in IR Grid")
			public void user_should_verify_the_view_button_is_working_in_ir_grid() {
			  
				pom.getIncidentReportPage().viewButton();				
			}
			
			
			@Then("User should verify the error message in Incident Report Page {string}")
			public void user_should_verify_the_error_message_in_incident_report_page(String expNoteMsg) {

				try {             
  				Assert.assertEquals("Required fields Note: info message is Not displayed as expected", expNoteMsg,
  						getText(pom.getIncidentReportPage().getRequiredFieldsNOTEInfoMessage()));
  				log(Status.PASS, "Required fields Note: info message is displayed as expected Exp info Msg - "
  						+ getText(pom.getIncidentReportPage().getRequiredFieldsNOTEInfoMessage()));
  				
  			} catch (AssertionError e) {
  				log(Status.FAIL, e.getMessage());
  				e.printStackTrace();
  			}
		}
			
			@Then("User should verify the edit button is working in IR submission page")
			public void user_should_verify_the_edit_button_is_working_in_IR_submission_page() {
			
			pom.getIncidentReportPage().editButton();
			
			}
			
	
			@Then("User should enter the Event Date & Time greater than current time")
			public void user_should_enter_the_event_date_time_greater_than_current_time() {
			  
				pom.getIncidentReportPage().eventDateAndTime(0);
			}
			
			
			@Then("User should validation info message is thrown under Event time for selecting  greater than current time of current date {string}")
			public void user_should_validation_info_message_is_thrown_under_event_time_for_selecting_greater_than_current_time_of_current_date(String expGreaterThanCurrentTime) {
			   
				try {             
	  				Assert.assertEquals("validation info message is NOT thrown under Event time for selecting  greater than current time of current date as expected", expGreaterThanCurrentTime,
	  						getText(pom.getIncidentReportPage().getExceedCurrentTimeIneventDateAndTimeValidationInfoMsg()));
	  				log(Status.PASS, "Validation info message is displayed after enter greater than current time of current date as expected Exp info Msg - "
	  						+ getText(pom.getIncidentReportPage().getExceedCurrentTimeIneventDateAndTimeValidationInfoMsg()));
	  				
	  			} catch (AssertionError e) {
	  				log(Status.FAIL, e.getMessage());
	  				e.printStackTrace();
	  			}
			}
			
			
			@Then("User should verify that able to enter before current date and time in Event Date & Time field")
			public void user_should_verify_that_able_to_enter_before_current_date_and_time_in_event_date_time_field() {
			   
				pom.getIncidentReportPage().eventDateAndTime(0);				
				
			}
			
				@Then("User should verify the toast message after try to upload JFIF Format {string}")
				public void user_should_verify_the_toast_message_after_try_to_upload_jfif_format(String string) {
				    
					pom.getIncidentReportPage().Upload("JFIF Format", ".jfif");
				}

				@Then("User should verify the toast message after try to upload more than 1MB File format {string}")
				public void user_should_verify_the_toast_message_after_try_to_upload_more_than_1mb_file_format(String string) {
				    
					pom.getAddIndividualsPage().moreThan1MBImgFormatUpload("MoreThan1MB", "jpg");
				}
				
				
				@Then("User should verify the user are able to attach file")
				public void user_should_verify_the_user_are_able_to_attach_file() {
				    
					pom.getIncidentReportPage().Upload("JPG", "jpg");
				}
				
				
				@Then("User should verify the delete icon is working on image under injury photo field")
				public void user_should_verify_the_delete_icon_is_working_on_image_under_injury_photo_field() {
				    
				    pom.getIncidentReportPage().deleteTheUploadedFile();
				}

				@Then("User should click on the Notification Date calendar icon")
				public void user_should_click_on_the_notification_date_calendar_icon() {
				  
					pom.getAddIndividualsPage().datePicker();
				}
				
				 
				
				
				
	
}
