package org.alphind.xealei.stepdefinition;

import org.alphind.xealei.baseclass.BaseClass;
import org.alphind.xealei.pom.PageObjectManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IncidentReportPageStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();
	
	private WebDriver staffDriver = getDriver();
	private WebDriver cheifnurseDriver;
	private WebDriver rmDriver;
	private WebDriver ccDriver;
	private WebDriver swDriver;
	

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
	
		pom.getIncidentReportPage().wasIndividualInjuredRadioButton();
		
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
			
			/**
			 * Created by Nandhalala.
			 */
			@When("User is login into Xealei application as Staff role user with valid {string} and {string}.")
			public void user_is_login_into_xealei_application_as_staff_role_user_with_valid_and(String StaffUserName, String StaffPassWord) {
			    
				logStep(methodName());

				sendKeys(pom.getLoginPage().getUserName(), StaffUserName);
				sendKeys(pom.getLoginPage().getPassword(), StaffPassWord);
				pom.getLoginPage().loginButton();
				waitForPageLoad();
				

			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Verify Home page is displayed.")
			public void verify_home_page_is_displayed() {
			    pom.getHomePage().isHomePageDisplayed();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Navigate to Reports module.")
			public void navigate_to_reports_module() {
			    pom.getHomePage().reportsModule();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Navigate to Incident Report sub module.")
			public void navigate_to_incident_report_sub_module() {
				pom.getHomePage().incidentReportModule();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Click on Add New Incident Report button.")
			public void click_on_add_new_incident_report_button() {
			    pom.getIncidentReportPage().addNewIncidentReportButton();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Verify Add Incident report page is displayed.")
			public void verify_add_incident_report_page_is_displayed() {
			    pom.getIncidentReportPage().isIncidentReportPageDisplayed();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Select the individual for whom the incident report has to be created.")
			public void select_the_individual_for_whom_the_incident_report_has_to_be_created() {
				pom.getIncidentReportPage().selectIndividualDetails();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Enter all the details of the Incident.")
			public void enter_all_the_details_of_the_incident() {
			    pom.getIncidentReportPage().enterWhatCausedTheFallData();
			    pom.getIncidentReportPage().selectWasTheIndividiualInjured();
			    pom.getIncidentReportPage().selectFrontViewInjurySite();
			    pom.getIncidentReportPage().selectBackViewInjurySite();
			    pom.getIncidentReportPage().enterTreatmentReceivedData();
			    pom.getIncidentReportPage().enterFutureTreatmentData();
			    pom.getIncidentReportPage().selectInjuryType();
			    pom.getIncidentReportPage().selectInjuryColor();
			    pom.getIncidentReportPage().selectHowSevereWasTheInjury();
			    pom.getIncidentReportPage().enterPersonNotifiedData();
			    pom.getIncidentReportPage().enterNotifiedByData();
			    pom.getIncidentReportPage().selectReletionship();
			    pom.getIncidentReportPage().selectNotificationMethod();
			    
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Click on next button.")
			public void click_on_next_button() {
			    pom.getIncidentReportPage().nextButton();
			}

			/**
			 * Created by Nandhalala.
			 */
			@When("Incident report page is displayed verify whether all the data is displayed correctly.")
			public void incident_report_page_is_displayed_verify_whether_all_the_data_is_displayed_correctly() {
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
			}

			/**
			 * Created by Nandhalala.
			 */
			@When("Click on complete button.")
			public void click_on_complete_button() {
			    pom.getIncidentReportPage().clickCompleteButton();
			}

			/**
			 * Created by Nandhalala.
			 */
			@When("Verify whether the report is in pending status.")
			public void verify_whether_the_report_is_in_pending_status() {
				String rowNumber = pom.getIncidentReportPage().getRowNumber();
			    String status =	pom.getIncidentReportPage().getStatus(rowNumber);
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Launch a new browser and enter xealei url.")
			public void launch_a_new_browser_and_enter_xealei_url() {
			    cheifnurseDriver = new ChromeDriver();
			    logStep(methodName());
			    cheifnurseDriver.get("https://xat.qa.xealei.com/login");
			    
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Login into Xealei application as Cheif nurse role with valid {string} and {string}.")
			public void login_into_xealei_application_as_cheif_nurse_role_with_valid_and(String cheifNurseUserName, String cheifNursePassWord) {
				cheifnurseDriver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(cheifNurseUserName);
				cheifnurseDriver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(cheifNursePassWord);
//				sendKeys(pom.getLoginPage().getUserName(), cheifNurseUserName);
//				sendKeys(pom.getLoginPage().getPassword(), cheifNursePassWord);
				cheifnurseDriver.findElement(By.xpath("//button[text()='Login ']")).click();
				//pom.getLoginPage().loginButton();
				waitForPageLoad(cheifnurseDriver);
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Verify whether notification is received.")
			public void verify_whether_notification_is_received() {
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Approve the report.")
			public void approve_the_report() {
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Verify whether the report is in {string} status.")
			public void verify_whether_the_report_is_in_status(String string) {
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Login into Xealei application as Residential Manager role with valid {string} and {string}.")
			public void login_into_xealei_application_as_residential_manager_role_with_valid_and(String string, String string2) {
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Login into Xealei application as CLinical Coordinator role with valid {string} and {string}.")
			public void login_into_xealei_application_as_c_linical_coordinator_role_with_valid_and(String string, String string2) {
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
			}

			/**
			 * Created by Nandhalala.
			 */
			    @Then("Login into Xealei application as Social Worker role with valid {string} and {string}.")
			    public void login_into_xealei_application_as_social_worker_role_with_valid_and(String string, String string2) {
			        // Write code here that turns the phrase above into concrete actions
			        throw new io.cucumber.java.PendingException();
			    }

			/**
			 * Created by Nandhalala.
			 */
			@Then("Deny the report.")
			public void deny_the_report() {
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Switch to Staff login and check whether sent back comments are available.")
			public void switch_to_staff_login_and_check_whether_sent_back_comments_are_available() {
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Again submit the report.")
			public void again_submit_the_report() {
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Switch to cheif nurse login and approve the incident report.")
			public void switch_to_cheif_nurse_login_and_approve_the_incident_report() {
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Switch to cheif nurse login and check whether sent back comments are available.")
			public void switch_to_cheif_nurse_login_and_check_whether_sent_back_comments_are_available() {
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Switch to Residential Manager login and approve the incident report.")
			public void switch_to_residential_manager_login_and_approve_the_incident_report() {
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
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
