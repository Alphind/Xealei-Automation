package org.alphind.xealei.stepdefinition;

import static org.testng.Assert.assertEquals;

import java.util.Objects;
import java.util.Set;

import org.alphind.xealei.baseclass.BaseClass;
import org.alphind.xealei.pom.PageObjectManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IncidentReportPageStep extends BaseClass {
	
	private WebDriver staffDriver = getDriver();
	private WebDriver ChiefnurseDriver;
	private WebDriver rmDriver;
	private WebDriver ccDriver;
	private WebDriver swDriver;

	private PageObjectManager staffpom = new PageObjectManager(staffDriver);
	private PageObjectManager Chiefnursepom;
	private PageObjectManager rmpom;
	private PageObjectManager ccpom;
	private PageObjectManager swpom;
	
	private String reportid;
	
	@When("User should perform login as facility admin {string} and {string}")
	public void user_should_perform_login_as_facility_admin(String userName, String password) {

		logStep(methodName());

//			pom.getLoginPage().validEmail(1);
//			pom.getLoginPage().validPassword(1);
//			pom.getLoginPage().loginButton();
//            waitForPageLoad();

		sendKeys(staffpom.getLoginPage().getUserName(), userName);
		sendKeys(staffpom.getLoginPage().getPassword(), password);
		waitForPageLoad(staffDriver);
		waitForFullPageElementLoad(staffDriver);
		staffpom.getLoginPage().loginButton();
		

	}

	@When("User should perform login as staff {string} and {string}")
	public void user_should_perform_login_as_staff_and(String userName, String passWord) {
		logStep(methodName());

//		pom.getLoginPage().validEmail(1);
//		pom.getLoginPage().validPassword(1);
//		pom.getLoginPage().loginButton();
//        waitForPageLoad();

	sendKeys(staffpom.getLoginPage().getUserName(), userName);
	sendKeys(staffpom.getLoginPage().getPassword(), passWord);
	waitForPageLoad(staffDriver);
	waitForFullPageElementLoad(staffDriver);
	staffpom.getLoginPage().loginButton();
	}
	
	@Then("User should also verify the performed login as {string}")
	public void user_should_also_verify_the_performed_login_as(String adminName) {

		String text = getText(staffpom.getHomePage().getAdminName());

		Assert.assertEquals("Login page url is wrong", adminName, text);
		System.out.println("EXP Value" + adminName);
		System.out.println("ACT Value" + text);

	}

	@Then("User should verify the Incident report module is working")
	public void user_should_verify_the_incident_report_module_is_working() {

		staffpom.getHomePage().reportsModule();
		staffpom.getHomePage().incidentReportModule();
		waitForPageLoad();

//		try {
//			Assert.assertEquals("Unable to navigate Reports>Incident Reports Module ", "Incident Reports",
//					getText(staffpom.getIncidentReportPage().getIncidentReportModuleText()));
//			log(Status.PASS, "Incident Report sub-module button is working");
//		} catch (AssertionError e) {
//			log(Status.FAIL, e.getMessage());
//			e.printStackTrace();
//		}
	}

	@Then("User should verify the ADD New Incident Report button is working")
	public void user_should_verify_the_add_new_incident_report_button_is_working() {

		try {
			staffpom.getIncidentReportPage().addNewIncidentReportButton();
			log(Status.INFO, "ADD New Incident Report button is working as expected");
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

		@Then("User should verify the save button is disabled")
		public void user_should_verify_the_save_button_is_disabled() {
		    
			String saveButtonDisabled = getAttribute(staffpom.getIncidentReportPage().getSaveButton(), "disabled");
			if (saveButtonDisabled.equalsIgnoreCase("true")) {
				log(Status.PASS, "SAVE button is disabled after enter into Add Incidet Report Page");
			} else {
				log(Status.FAIL, "SAVE button is NOT disabled after enter into Add Incidet Report Page");
			}
		}
	
		@Then("User should verify Next > button is working")
		public void user_should_verify_next_button_is_working() {
		
			staffpom.getIncidentReportPage().nextButton();
		}
		
		@Then("User should verify the validation info message under all fields {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
		public void user_should_verify_the_validation_info_message_under_all_fields(String expIndDetailsInfoMsg, String expEventDateAndTimeInfoMsg, String expWhatCausedAFall, String expWasInjuredInfoMsg, String expInjuryDescriptionInfoMsg, String expInjurySiteInfoMsg, String expTreatmentReceivedInfoMsg, String expFutureTreatmentInfoMsg, String expInjuryTypeInfoMsg, String expInjuryColorInfoMsg, String expInjurySevereInfoMsg, String expPersonNotifiedInfoMsg, String expRelationshipInfoMsg, String expNotificationDateInfoMsg, String expNotificationTimeInfoMsg, String expNotifiedByInfoMsg) {
		 
			
			try {
				Assert.assertEquals("MF validation info msg is NOT displayed as expected under Individual’s Details field", expIndDetailsInfoMsg,
						getText(staffpom.getIncidentReportPage().getIndividualsDetailsValidationInfoMsg()));
				log(Status.PASS, "MF validation info msg is displayed as expected under Individual’s Details field");
			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}
						
			try {
				Assert.assertEquals("MF validation info msg is NOT displayed as expected under Event Date & Time field", expEventDateAndTimeInfoMsg,
						getText(staffpom.getIncidentReportPage().getEventDateAndTimeValidationInfoMsg()));
				log(Status.PASS, "MF validation info msg is displayed as expected under Event Date & Time field");
			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}
		
			staffpom.getIncidentReportPage().selectIndividualDetailsDropdown();	
			
			staffpom.getIncidentReportPage().eventDateAndTime(0);
			
			
			try {
				Assert.assertEquals("MF validation info msg is NOT displayed as expected under What caused the fall? field", expWhatCausedAFall,
						getText(staffpom.getIncidentReportPage().getFallCausedValidationInfoMsg()));
				log(Status.PASS, "MF validation info msg is displayed as expected under What caused the fall? field");
			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}
			
			try {
				Assert.assertEquals("MF validation info msg is NOT displayed as expected under Was injured? field", expWasInjuredInfoMsg,
						getText(staffpom.getIncidentReportPage().getChooseWasIndInjuredRadioButtonValidationInfoMsg()));
				log(Status.PASS, "MF validation info msg is displayed as expected under Was injured? field");
			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}
			
			staffpom.getIncidentReportPage().wasPatientInjuredRadioButton();
		
		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Injury Description field", expInjuryDescriptionInfoMsg,
					getText(staffpom.getIncidentReportPage().getInjuryDescriptionValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Injury Description field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Injury Site field", expInjurySiteInfoMsg,
					getText(staffpom.getIncidentReportPage().getInjurySiteValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Injury Site field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
			
		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Treatment Received field", expTreatmentReceivedInfoMsg,
					getText(staffpom.getIncidentReportPage().getTreatmentReceivedValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Treatment Received field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Future Treatment field", expFutureTreatmentInfoMsg,
					getText(staffpom.getIncidentReportPage().getFutureTreatmentValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Future Treatment field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Injury Type field", expInjuryTypeInfoMsg,
					getText(staffpom.getIncidentReportPage().getInjuryTypeValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Injury Type field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Injury Color field", expInjuryColorInfoMsg,
					getText(staffpom.getIncidentReportPage().getInjuryColorValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Injury Color field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Injury Serve field", expInjurySevereInfoMsg,
					getText(staffpom.getIncidentReportPage().getInjurySeverityValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Injury Serve field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Person Notified field", expPersonNotifiedInfoMsg,
					getText(staffpom.getIncidentReportPage().getPersonNotifiedValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Person Notified field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Relationship field", expRelationshipInfoMsg,
					getText(staffpom.getIncidentReportPage().getRelationshipValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Relationship field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Notification Date field", expNotificationDateInfoMsg,
					getText(staffpom.getIncidentReportPage().getChooseNotifiationDateValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Notification Date field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Notification Time field", expNotificationTimeInfoMsg,
					getText(staffpom.getIncidentReportPage().getChooseNotifiationTimeValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Notification Time field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Notified By field", expNotifiedByInfoMsg,
					getText(staffpom.getIncidentReportPage().getNotifiedValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Notified By field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
		
	}

		@Then("User should verify Save button is working in IR Page after perform Individuals Details and Event Date & Time fields")
		public void user_should_verify_save_button_is_working_in_ir_page_after_perform_individuals_details_and_event_date_time_fields() {
		    			
	    staffpom.getIncidentReportPage().injuryDescription();
	    
		staffpom.getIncidentReportPage().saveButton();
	
		}
		
		@Then("User should verify the toast message after click Save button in IR Page {string}")
		public void user_should_verify_the_toast_message_after_click_save_button_in_ir_page(String expSuccessfullToastMsg) {
		  
			try {
				Assert.assertEquals("Saved Successfull Toast Message is not displayed", expSuccessfullToastMsg,
						getText(staffpom.getIncidentReportPage().getSavedSuccessfullToastMsg()));
				log(Status.PASS, "Toast Message is displayed : "
						+ getText(staffpom.getIncidentReportPage().getSavedSuccessfullToastMsg()));
				
			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}
			staffpom.getIncidentReportPage().savedSuccessfulToastMsgokButton();
		
		}
		
		@Then("User should verify the respective individual report status {string}")
		public void user_should_verify_the_respective_individual_report_status(String string) {
		
	     String IRStatus = staffpom.getIncidentReportPage().getStatus(staffpom.getIncidentReportPage().getRowNumber());
		 System.out.println("Current IR Status -" +IRStatus);
		 
		}

			@Then("User should verify the view button is working in IR Grid")
			public void user_should_verify_the_view_button_is_working_in_ir_grid() {
			  
				staffpom.getIncidentReportPage().viewButton(staffpom.getIncidentReportPage().getRowNumber());
			}
			
			@Then("User should verify the error message in Incident Report Page {string}")
			public void user_should_verify_the_error_message_in_incident_report_page(String expNoteMsg) {

				try {             
  				Assert.assertEquals("Required fields Note: info message is Not displayed as expected", expNoteMsg,
  						getText(staffpom.getIncidentReportPage().getRequiredFieldsNOTEInfoMessage()));
  				log(Status.PASS, "Required fields Note: info message is displayed as expected Exp info Msg - "
  						+ getText(staffpom.getIncidentReportPage().getRequiredFieldsNOTEInfoMessage()));
  				
  			} catch (AssertionError e) {
  				log(Status.FAIL, e.getMessage());
  				e.printStackTrace();
  			}
		}
			
			@Then("User should verify the edit button is working in IR submission page")
			public void user_should_verify_the_edit_button_is_working_in_IR_submission_page() {
						
			}
			
	
			@Then("User should enter the Event Date & Time greater than current time")
			public void user_should_enter_the_event_date_time_greater_than_current_time() {
			  
				staffpom.getIncidentReportPage().eventDateAndTime(0);
			}
			
			
			@Then("User should validation info message is thrown under Event time for selecting  greater than current time of current date {string}")
			public void user_should_validation_info_message_is_thrown_under_event_time_for_selecting_greater_than_current_time_of_current_date(String expGreaterThanCurrentTime) {
			   
				try {             
	  				Assert.assertEquals("validation info message is NOT thrown under Event time for selecting  greater than current time of current date as expected", expGreaterThanCurrentTime,
	  						getText(staffpom.getIncidentReportPage().getExceedCurrentTimeIneventDateAndTimeValidationInfoMsg()));
	  				log(Status.PASS, "Validation info message is displayed after enter greater than current time of current date as expected Exp info Msg - "
	  						+ getText(staffpom.getIncidentReportPage().getExceedCurrentTimeIneventDateAndTimeValidationInfoMsg()));
	  				
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

				sendKeys(staffpom.getLoginPage().getUserName(), StaffUserName);
				sendKeys(staffpom.getLoginPage().getPassword(), StaffPassWord);
				staffpom.getLoginPage().loginButton();
				waitForPageLoad();
				

			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Verify Home page is displayed.")
			public void verify_home_page_is_displayed() {
				
			    staffpom.getHomePage().isHomePageDisplayed();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Navigate to Reports module.")
			public void navigate_to_reports_module() {
			    staffpom.getHomePage().reportsModule();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Navigate to Incident Report sub module.")
			public void navigate_to_incident_report_sub_module() {
				staffpom.getHomePage().incidentReportModule();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Click on Add New Incident Report button.")
			public void click_on_add_new_incident_report_button() {
			    staffpom.getIncidentReportPage().addNewIncidentReportButton();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Verify Add Incident report page is displayed.")
			public void verify_add_incident_report_page_is_displayed() {
			    staffpom.getIncidentReportPage().isIncidentReportPageDisplayed();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Select the individual for whom the incident report has to be created.")
			public void select_the_individual_for_whom_the_incident_report_has_to_be_created() {
				staffpom.getIncidentReportPage().selectIndividualDetails();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Enter all the details of the Incident.")
			public void enter_all_the_details_of_the_incident() {
				staffpom.getIncidentReportPage().eventDateAndTime(0);
			    staffpom.getIncidentReportPage().enterWhatCausedTheFallData();
			    staffpom.getIncidentReportPage().selectWasTheIndividiualInjured();
			    staffpom.getIncidentReportPage().selectFrontViewInjurySite();
			    staffpom.getIncidentReportPage().selectBackViewInjurySite();
			    staffpom.getIncidentReportPage().enterTreatmentReceivedData();
			    staffpom.getIncidentReportPage().enterInjuryDescriptionData();
			    staffpom.getIncidentReportPage().enterFutureTreatmentData();
			    staffpom.getIncidentReportPage().selectInjuryType();
			    staffpom.getIncidentReportPage().selectInjuryColor();
			    staffpom.getIncidentReportPage().selectHowSevereWasTheInjury();
			    staffpom.getIncidentReportPage().enterPersonNotifiedData();
			    staffpom.getIncidentReportPage().enterNotificationDate();
			    staffpom.getIncidentReportPage().enterNotificationTime();
			    staffpom.getIncidentReportPage().enterNotifiedByData();
			    staffpom.getIncidentReportPage().selectReletionship();
			    //staffpom.getIncidentReportPage().selectNotificationMethod();
			    
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Click on next button.")
			public void click_on_next_button() {
			    staffpom.getIncidentReportPage().nextButton();
			    waitForFullPageElementLoad(staffDriver);
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
			    staffpom.getIncidentReportPage().clickCompleteButton();
			    waitForPageLoad(staffDriver);
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("ReSubmit the Report by staff user.")
			public void ReSubmit_the_Report_by_staff_user() {
				staffpom.getIncidentReportPage().clickCompleteButton();
			    waitForPageLoad(staffDriver);
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("ReSubmit the Report by Chief nurse user.")
			public void ReSubmit_the_Report_by_chief_nurse_user() {
				Chiefnursepom.getIncidentReportPage().clickCompleteButton();
			    waitForPageLoad(ChiefnurseDriver);
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@When("Verify whether the report is in pending status.")
			public void verify_whether_the_report_is_in_pending_status() {
				String rowNumber = staffpom.getIncidentReportPage().getRowNumber();
			    String status =	staffpom.getIncidentReportPage().getStatus(rowNumber);
			    try {
				    assertEquals(status, "Pending",
				    		"The expected value is : Pending /nbut actual is : "+status);
				    log(Status.PASS, "The Incident Report submitted by the staff is in "
				    		+ "pending status.");
				} catch (Exception e) {
					log(Status.FAIL, "The Incident Report submitted by the staff is in "+status
				    		+ " not in pending status.");
				}
			    reportid =  staffpom.getIncidentReportPage().getReportID(rowNumber);
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Launch a new browser and enter xealei url for Chief nurse.")
			public void launch_a_new_browser_and_enter_xealei_url_for_Chief_nurse() {
				try {
					ChiefnurseDriver = getNewDriver();
				} catch (Exception e) {
					e.printStackTrace();
				}
			    logStep(methodName());
			    ChiefnurseDriver.get("https://xat.qa.xealei.com/login");
			    Chiefnursepom = new PageObjectManager(ChiefnurseDriver);
			    waitForPageLoad(ChiefnurseDriver);
			    ChiefnurseDriver.manage().window().maximize();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Launch a new browser and enter xealei url for residential manager.")
			public void launch_a_new_browser_and_enter_xealei_url_for_residential_manager() {
				try {
					rmDriver = getNewDriver();
				} catch (Exception e) {
					e.printStackTrace();
				}
			    logStep(methodName());
			    rmDriver.get("https://xat.qa.xealei.com/login");
			    rmpom = new PageObjectManager(rmDriver);
			    waitForPageLoad(rmDriver);
			    rmDriver.manage().window().maximize();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Launch a new browser and enter xealei url for clinical coordinator.")
			public void launch_a_new_browser_and_enter_xealei_url_for_clinical_coordinator() {
				try {
					ccDriver = getNewDriver();
				} catch (Exception e) {
					e.printStackTrace();
				}
			    logStep(methodName());
			    ccDriver.get("https://xat.qa.xealei.com/login");
			    ccpom = new PageObjectManager(ccDriver);
			    waitForPageLoad(ccDriver);
			    ccDriver.manage().window().maximize();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Launch a new browser and enter xealei url for social worker.")
			public void launch_a_new_browser_and_enter_xealei_url_for_social_worker() {
				try {
					swDriver = getNewDriver();
				} catch (Exception e) {
					e.printStackTrace();
				}
			    logStep(methodName());
			    swDriver.get("https://xat.qa.xealei.com/login");
			    swpom = new PageObjectManager(swDriver);
			    waitForPageLoad(swDriver);
			    swDriver.manage().window().maximize();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Login into Xealei application as Chief nurse role with valid {string} and {string}.")
			public void login_into_xealei_application_as_Chief_nurse_role_with_valid_and(String ChiefNurseUserName, String ChiefNursePassWord) {
				logStep(methodName());
				sendKeys(Chiefnursepom.getLoginPage().getUserName(), ChiefNurseUserName);
				sendKeys(Chiefnursepom.getLoginPage().getPassword(), ChiefNursePassWord);
				//waitForPageLoad(ChiefnurseDriver);
				waitForFullPageElementLoad(ChiefnurseDriver);
				Chiefnursepom.getLoginPage().loginButton();
				waitForPageLoad(ChiefnurseDriver);
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Open notification received by staff.")
			public void Open_notification_received_by_Staff() {
				staffpom.getHomePage().notificationIcon(reportid);
			}
			
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Open notification received by Chief nurse.")
			public void Open_notification_received_by_Chief_nurse() {
				Chiefnursepom.getHomePage().notificationIcon(reportid);
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Open notification received by residential manager.")
			public void Open_notification_received_by_residential_manager() {
				rmpom.getHomePage().notificationIcon(reportid);
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Open notification received by Clinical Coordinator.")
			public void Open_notification_received_by_Clinical_Coordinator() {
				ccpom.getHomePage().notificationIcon(reportid);
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Verify whether notification received by Social Worker.")
			public void verify_whether_notification_received_by_Social_Worker() {
				swpom.getHomePage().notificationIcon(reportid);
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Approve the report by Chief Nurse user.")
			public void approve_the_report_by_Chief_Nurse_user() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			    Chiefnursepom.getIncidentReportPage().chiefNurseReviewerComments("approved");
			    Chiefnursepom.getIncidentReportPage().clickCompleteButton();
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Approve the report by Residential Manager user.")
			public void approve_the_report_by_Residential_Manager_user() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			    rmpom.getIncidentReportPage().residentialManagerReviewerComments("approved");
			    rmpom.getIncidentReportPage().clickCompleteButton();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Approve the report by Clinical Coordinator user.")
			public void approve_the_report_by_Clinical_Coordinator_user() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			    ccpom.getIncidentReportPage().clinicalCoordinatorReviewerComments("approved");
			    ccpom.getIncidentReportPage().clickCompleteButton();
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Approve the report by Social Worker user.")
			public void approve_the_report_by_Social_Worker_user() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			    swpom.getIncidentReportPage().socialWorkerReviewerComments("approved");
			    swpom.getIncidentReportPage().clickCompleteButton();
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Re-Send the report by Chief Nurse user to staff nurse.")
			public void re_send_the_report_by_Chief_nurse_user_to_staff_nurse() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			    Chiefnursepom.getIncidentReportPage().chiefNurseReviewerComments("rejected");
			    Chiefnursepom.getIncidentReportPage().resubmitButton();
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Re-Send the report by Residential Manager user.")
			public void re_send_the_report_by_residential_manager_user() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			    rmpom.getIncidentReportPage().residentialManagerReviewerComments("rejected");
			    rmpom.getIncidentReportPage().resubmitButton();
			    
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Switch back to staff user login.")
			public void Switch_back_to_staff_user_login() {
				Set<String> handle = staffDriver.getWindowHandles();
				staffDriver.getWindowHandle();
				staffpom.getIncidentReportPage().navigateHome();
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Switch back to Chief nurse user login.")
			public void Switch_back_to_Chief_nurse_user_login() {
				Set<String> handle = staffDriver.getWindowHandles();
				staffDriver.getWindowHandle();
				staffpom.getIncidentReportPage().navigateHome();
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Verify whether the report is in {string} status by Chief Nurse user.")
			public void verify_whether_the_report_is_in_status_by_Chief_Nurse_user(String status) {
				String rowNumber = Chiefnursepom.getIncidentReportPage().getRowNumber();
			    String actualStatus =	Chiefnursepom.getIncidentReportPage().getStatus(rowNumber);
			    try {
			    	assertEquals(actualStatus, status, "The actual status is : "+actualStatus+
				    		" but the expected is : "+status);
				    log(Status.PASS, "The Incident Report approved by the Chief nurse is in "
				    		+ status+" status.");
				} catch (Exception e) {
					log(Status.FAIL, "The Incident Report submitted by the chief nurse is in "
				    		+actualStatus +" status not "+status);
				}
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Verify whether the report is in {string} status by Residential Manager user.")
			public void verify_whether_the_report_is_in_status_by_Residential_Manager_user(String status) {
				String rowNumber = rmpom.getIncidentReportPage().getRowNumber();
			    String actualStatus = rmpom.getIncidentReportPage().getStatus(rowNumber);
			    
			    try {
			    	assertEquals(actualStatus, status, "The actual status is : "+actualStatus+
				    		" but the expected is : "+status);
			    	log(Status.PASS, "The Incident Report approved by the residential manager is in "
				    		+ status+" status.");
				} catch (Exception e) {
					log(Status.FAIL, "The Incident Report submitted by the residential manager is in "
				    		+actualStatus +" status not "+status);
				}
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Verify whether the report is in {string} status by Clinical Coordinator user.")
			public void verify_whether_the_report_is_in_status_by_Clinical_Coordinator_user(String status) {
				String rowNumber = Chiefnursepom.getIncidentReportPage().getRowNumber();
			    String actualStatus =	Chiefnursepom.getIncidentReportPage().getStatus(rowNumber);
			    
			    try {
			    	assertEquals(actualStatus, status, "The actual status is : "+actualStatus+
				    		" but the expected is : "+status);
			    	log(Status.PASS, "The Incident Report approved by the Clincal Coordinator is in "
				    		+ status+" status.");
				} catch (Exception e) {
					log(Status.FAIL, "The Incident Report submitted by the Clincal Coordinator is in "
				    		+actualStatus +" status not "+status);
				}
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Verify whether the report is in {string} status by Social Worker user.")
			public void verify_whether_the_report_is_in_status_by_Social_Worker_user(String status) {
				String rowNumber = swpom.getIncidentReportPage().getRowNumber();
			    String actualStatus =	swpom.getIncidentReportPage().getStatus(rowNumber);
			    
			    try {
			    	assertEquals(actualStatus, status, "The actual status is : "+actualStatus+
				    		" but the expected is : "+status);
			    	log(Status.PASS, "The Incident Report approved by the social worker is in "
				    		+ status+" status.");
				} catch (Exception e) {
					log(Status.FAIL, "The Incident Report submitted by the social worker is in "
				    		+actualStatus +" status not "+status);
				}
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Login into Xealei application as Residential Manager role with valid {string} and {string}.")
			public void login_into_xealei_application_as_residential_manager_role_with_valid_and(String rmUserName, String rmPassWord) {
				sendKeys(rmpom.getLoginPage().getUserName(), rmUserName);
				sendKeys(rmpom.getLoginPage().getPassword(), rmPassWord);
				waitForPageLoad(rmDriver);
				//waitForFullPageElementLoad(rmDriver);
				rmpom.getLoginPage().loginButton();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Login into Xealei application as CLinical Coordinator role with valid {string} and {string}.")
			public void login_into_xealei_application_as_c_linical_coordinator_role_with_valid_and(String ccUserName, String ccPassWord) {
				logStep(methodName());
				sendKeys(ccpom.getLoginPage().getUserName(), ccUserName);
				sendKeys(ccpom.getLoginPage().getPassword(), ccPassWord);
				waitForPageLoad(ccDriver);
				waitForFullPageElementLoad(ccDriver);
				ccpom.getLoginPage().loginButton();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Login into Xealei application as Social Worker role with valid {string} and {string}.")
			public void login_into_xealei_application_as_social_worker_role_with_valid_and(String swUserName, String swPassWord) {
			   	logStep(methodName());
			   	sendKeys(swpom.getLoginPage().getUserName(), swUserName);
			   	sendKeys(swpom.getLoginPage().getPassword(), swPassWord);
			   	waitForPageLoad(swDriver);
			   	waitForFullPageElementLoad(swDriver);
			   	swpom.getLoginPage().loginButton();
			}
			    
			/**
			 * Created by Nandhalala.
			 */
			@Then("Close all the browsers.")
			public void Close_all_the_browsers() {
				if(Objects.nonNull(ChiefnurseDriver)) {
					ChiefnurseDriver.quit();
				}
				if(Objects.nonNull(rmDriver)) {
					rmDriver.quit();
				}
				if(Objects.nonNull(ccDriver)) {
					ccDriver.quit();
				}
				if(Objects.nonNull(swDriver)) {
					swDriver.quit();
				}
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
			@Then("Switch to Chief nurse login and approve the incident report.")
			public void switch_to_Chief_nurse_login_and_approve_the_incident_report() {
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Switch to Chief nurse login and check whether sent back comments are available.")
			public void switch_to_Chief_nurse_login_and_check_whether_sent_back_comments_are_available() {
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
			   
				staffpom.getIncidentReportPage().eventDateAndTime(0);				
				
			}
			
				@Then("User should verify the toast message after try to upload JFIF Format {string}")
				public void user_should_verify_the_toast_message_after_try_to_upload_jfif_format(String string) {
				    
					staffpom.getIncidentReportPage().Upload("JFIF Format", ".jfif");
				}

				@Then("User should verify the toast message after try to upload more than 1MB File format {string}")
				public void user_should_verify_the_toast_message_after_try_to_upload_more_than_1mb_file_format(String string) {
				    
					staffpom.getAddIndividualsPage().moreThan1MBImgFormatUpload("MoreThan1MB", "jpg");
				}
				
				
				@Then("User should verify the user are able to attach file")
				public void user_should_verify_the_user_are_able_to_attach_file() {
				    
					staffpom.getIncidentReportPage().Upload("JPG", "jpg");
				}
				
				
				@Then("User should verify the delete icon is working on image under injury photo field")
				public void user_should_verify_the_delete_icon_is_working_on_image_under_injury_photo_field() {
				    
				    staffpom.getIncidentReportPage().deleteTheUploadedFile();
				}

				@Then("User should click on the Notification Date calendar icon")
				public void user_should_click_on_the_notification_date_calendar_icon() {
				  
					staffpom.getAddIndividualsPage().datePicker();
				}
				
				
					@Then("User should verify that whether able to select options under Injury Type field")
					public void user_should_verify_that_whether_able_to_select_options_under_injury_type_field() {
					 
						staffpom.getIncidentReportPage().selectInjuryType();
				}

					@Then("User should verify that whether able to selecting multiple option values under Injury Type field")
					public void user_should_verify_that_whether_able_to_selecting_multiple_option_values_under_injury_type_field() {
					
						
						staffpom.getIncidentReportPage().selectMultipleOptionInjuryType();
					}
					
						@Then("User should verify that whether able to unselect the selected option values under Injury Type field")
						public void user_should_verify_that_whether_able_to_unselect_the_selected_option_values_under_injury_type_field() {
						    
							staffpom.getIncidentReportPage().selectMultipleOptionInjuryType();
						}
						
						@Then("User should verify that whether able to select the option value under How severe was injury? field")
						public void user_should_verify_that_whether_able_to_select_the_option_value_under_how_severe_was_injury_field() {
						   
							
							staffpom.getIncidentReportPage().selectOptionHowSevereWasTheInjury();
						}
						
						@Then("User should verify that whether able to select the option value under Injury Color")
						public void user_should_verify_that_whether_able_to_select_the_option_value_under_injury_color() {
						   
							staffpom.getIncidentReportPage().selectInjuryColorOption();

						}
						
						@Then("User should verify that whether default optional values is selected under was Event Notified?")
						public void user_should_verify_that_whether_default_optional_values_is_selected_under_was_event_notified() throws Exception {
						 
							
							String defaultOptionIsSelected = getAttribute(staffpom.getIncidentReportPage().getEventNotifiedDefaultValue(), "ng-reflect-value");
							
                            if (defaultOptionIsSelected.equals("true")) {
	                       log(Status.PASS, "Default option is selected under Was the event notified? radio button field");
                            } else {
                           	log(Status.FAIL, "Default optional values is NOT selected under was Event Notified?");
                           	throw new Exception();
                            }							
               }
						
						
						
						
						
						
						
						}
