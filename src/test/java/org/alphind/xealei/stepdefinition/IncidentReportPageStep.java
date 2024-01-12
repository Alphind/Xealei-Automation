package org.alphind.xealei.stepdefinition;

import static org.testng.Assert.assertEquals;

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
	private WebDriver cheifnurseDriver;
	private WebDriver rmDriver;
	private WebDriver ccDriver;
	private WebDriver swDriver;

	private PageObjectManager staffpom = new PageObjectManager(staffDriver);
	private PageObjectManager cheifnursepom;
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


		try {
			Assert.assertEquals("Unable to navigate Reports>Incident Reports Module ", "Incident Reports",
					getText(staffpom.getIncidentReportPage().getIncidentReportModuleText()));
			log(Status.PASS, "Incident Report sub-module button is working");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

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
	public void user_should_verify_the_validation_info_message_under_all_fields1(String expIndDetailsInfoMsg,
			String expEventDateAndTimeInfoMsg, String expWhatCausedAFall, String expWasInjuredInfoMsg,
			String expInjuryDescriptionInfoMsg, String expInjurySiteInfoMsg, String expTreatmentReceivedInfoMsg,
			String expFutureTreatmentInfoMsg, String expInjuryTypeInfoMsg, String expInjuryColorInfoMsg,
			String expInjurySevereInfoMsg, String expPersonNotifiedInfoMsg, String expRelationshipInfoMsg,
			String expNotificationDateInfoMsg, String expNotificationTimeInfoMsg, String expNotifiedByInfoMsg) {
		
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
		
		staffpom.getIncidentReportPage().eventDateAndTime();
		
		
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
	public void user_should_verify_the_respective_individual_report_status(String expDraftStatus) {

		String IRStatus = staffpom.getIncidentReportPage().getStatus(staffpom.getIncidentReportPage().getRowNumber());
		System.out.println("Current IR Status -" + IRStatus);

		try {
			Assert.assertEquals("DRAFT Status is Not displayed IR Grid page", expDraftStatus, IRStatus);
			log(Status.PASS, "Required fields Note: info message is displayed as expected Exp info Msg - "+expDraftStatus+" Actual Msg - "+IRStatus);

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		
	}

	@Then("User should verify the view button is working in IR Grid")
	public void user_should_verify_the_view_button_is_working_in_ir_grid() {

		staffpom.getIncidentReportPage().viewButton(staffpom.getIncidentReportPage().getRowNumber());
	}

	@Then("User should verify the error message in Incident Report Page {string}")
	public void user_should_verify_the_error_message_in_incident_report_page(String expNoteMsg) {

		scrollDownToBottomOfThePage();
		
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

	@Then("User should verify the complete button is disabled")
	public void user_should_verify_the_complete_button_is_disabled() {

		String completeButtonDisabled = getAttribute(staffpom.getIncidentReportPage().getCompleteButton(),
				"ng-reflect-disabled");

		if (completeButtonDisabled.equalsIgnoreCase("true")) {
			log(Status.PASS, "Complete button is disabled after click view button");
		} else {
			log(Status.FAIL, "Complete button is NOT disabled after click view button");
		}
	}
		
	@Then("User should verify the edit button is working in IR submission page")
	public void user_should_verify_the_edit_button_is_working_in_IR_submission_page() throws Exception {

		staffpom.getIncidentReportPage().EditButton();

		if (staffpom.getIncidentReportPage().getSaveButton().isDisplayed()) {
			log(Status.PASS, "Edit button is working as expected");
		}
	}

	@Then("User should verify the injury question section should display with selected individual name in field")
	public void user_should_verify_the_injury_question_section_should_display_with_selected_individual_name_in_field() {
			
		System.out.println("Actual ind name -" + staffpom.getIncidentReportPage().getIndividualNameFromWasIndividualInjured());
		String selectedIndividualName = readExcel("Test Datas", "Incident Reports", 1, 19);

		try {
			Assert.assertEquals("Individual name is NOT displayed in Was injured? field",
					"Was " + selectedIndividualName + " injured?",
					staffpom.getIncidentReportPage().getIndividualNameFromWasIndividualInjured());
			log(Status.PASS, "Respective Individual name is displayed in Was injured? field");
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should enter the Event Date & Time greater than current time")
	public void user_should_enter_the_event_date_time_greater_than_current_time() {

		deleteExistFieldData(staffpom.getIncidentReportPage().getEventDateAndTimeCalenderIconButton());

		staffpom.getIncidentReportPage().eventDateAndFutureTime();
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

			@Then("User should verify that able to spot the injury on Injury site front & Back view")
			public void user_should_verify_that_able_to_spot_the_injury_on_injury_site_front_back_view() {

				staffpom.getIncidentReportPage().frontViewForeHeadInjury().frontViewFaceInjury().frontViewRightShoulderInjury()
				.frontViewRightArmInjury().frontViewRightWristInjury().frontViewRightKneeInjury().frontViewRightFootInjury()
				.frontViewChestInjury().frontViewAbdomenInjury().frontViewLeftShoulderInjury().frontViewLefttArmInjury()
				.frontViewLefttWristInjury().frontViewLeftKneeInjury().frontViewLeftFootInjury();
				
				
				staffpom.getIncidentReportPage().backViewHeadInjury().backViewRightShoulderInjury()
				.backViewRightArmInjury().backViewRightWristInjury().backViewRightKneeInjury().backViewRightFootInjury()
				.backViewLeftShoulderInjury().backViewLefttArmInjury().backViewLefttWristInjury().backViewLeftKneeInjury()
				.backViewLeftFootInjury().backViewHipInjury().backViewBackInjury();
			}

			@Then("User should verify that able to unselect the injury on Injury site front & Back view")
			public void user_should_verify_that_able_to_unselect_the_injury_on_injury_site_front_back_view() {

				staffpom.getIncidentReportPage().unselectFrontViewForeHeadInjury().unselectFrontViewFaceInjury().unselectFrontViewRightShoulderInjury()
				.unselectFrontViewRightArmInjury().unselectFrontViewRightWristInjury().unselectFrontViewRightKneeInjury().unselectFrontViewRightFootInjury()
				.unselectFrontViewChestInjury().unselectFrontViewAbdomenInjury().unselectFrontViewLeftShoulderInjury().unselectFrontViewLefttArmInjury()
				.unselectFrontViewLefttWristInjury().unselectFrontViewLeftKneeInjury().unselectFrontViewLeftFootInjury();
				
				staffpom.getIncidentReportPage().unselectBackViewHeadInjury().unselectBackViewRightShoulderInjury()
				.unselectBackViewRightArmInjury().unselectBackViewRightWristInjury().unselectBackViewRightKneeInjury().unselectBackViewRightFootInjury()
				.unselectBackViewLeftShoulderInjury().unselectBackViewLefttArmInjury().unselectBackViewLefttWristInjury().unselectBackViewLeftKneeInjury()
				.unselectBackViewLeftFootInjury().unselectBackViewHipInjury().unselectBackViewBackInjury();

				try {
					Assert.assertEquals("Unable to unselect the injury on Injury site front / Back view",
							"Please select injury site",
							getText(staffpom.getIncidentReportPage().getInjurySiteValidationInfoMsg()));
					log(Status.PASS, "Able to unselect the injury on Injury site front & Back view as expected");
				} catch (AssertionError e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}
	 	}
			
			@Then("User should verify that able to upload upload JFIF Format")
			public void user_should_verify_that_able_to_upload_upload_jfif_format() {

				staffpom.getIncidentReportPage().jfifFileUpload("JFIF Format", "jfif");
			}

			@Then("User should verify that able to upload more than 1MB File format")
			public void user_should_verify_that_able_to_upload_more_than_1mb_file_format() {

				staffpom.getIncidentReportPage().moreThan1MBImgFormatUpload("MoreThan1MB", "jpg");

			}

			@Then("User should verify that able to upload files or images")
			public void user_should_verify_that_able_to_upload_files_or_images() {

				staffpom.getIncidentReportPage().Upload("JPG", "jpg");
			}

			@Then("User should verify the delete icon is working on image under injury photo field")
			public void user_should_verify_the_delete_icon_is_working_on_image_under_injury_photo_field() {

				try {
					staffpom.getIncidentReportPage().deleteTheUploadedFile();

					log(Status.PASS, "Image is deleted successfully under injury photo field");
				} catch (Exception e) {
					log(Status.FAIL, e.getMessage());
					e.printStackTrace();
				}
			}
		
			@Then("User should verify that whether able to selecting multiple option values under Injury Type field")
			public void user_should_verify_that_whether_able_to_selecting_multiple_option_values_under_injury_type_field() {

				staffpom.getIncidentReportPage().abrasion().bleeding().bruise().scratch();
			}

			@Then("User should verify that whether able to unselect the selected option values under Injury Type field")
			public void user_should_verify_that_whether_able_to_unselect_the_selected_option_values_under_injury_type_field() {

				staffpom.getIncidentReportPage().abrasionForUnselect().bleedingForUnselect().bruiseForUnselect()
						.scratchForUnselect();
			}

			@Then("User should verify that whether able to select the option value under How severe was injury? field")
			public void user_should_verify_that_whether_able_to_select_the_option_value_under_how_severe_was_injury_field() {

				staffpom.getIncidentReportPage().lightOption().mediumOption().highOption();
			}

			@Then("User should verify that whether able to select the option value under Injury Color")
			public void user_should_verify_that_whether_able_to_select_the_option_value_under_injury_color() {

				staffpom.getIncidentReportPage().greenColor().redColor().blackColor().brownColor();

			}

			@Then("User should verify that whether default optional values is selected under was Event Notified?")
			public void user_should_verify_that_whether_default_optional_values_is_selected_under_was_event_notified()
					throws Exception {

				String defaultOptionIsSelected = getAttribute(staffpom.getIncidentReportPage().getEventNotifiedDefaultValue(),
						"ng-reflect-value");

				if (defaultOptionIsSelected.equals("true")) {
					log(Status.PASS, "Default option is selected under Was the event notified? radio button field");
				} else {
					log(Status.FAIL, "Default optional values is NOT selected under was Event Notified?");
					throw new Exception();
				}
			}
			
			@Then("User should verify that able to enter current date and time in Event Date & Time field")
			public void user_should_verify_that_able_to_enter_current_date_and_time_in_event_date_time_field() {

				deleteExistFieldData(staffpom.getIncidentReportPage().getEventDateAndTimeCalenderIconButton());
				staffpom.getIncidentReportPage().eventDateAndTime();
			}

			@Then("User should click on the Notification Date calendar icon")
			public void user_should_click_on_the_notification_date_calendar_icon() {

				staffpom.getIncidentReportPage().notificationDateFieldCalenderIconButton();
			}

			@Then("User should verify that the Notification Date calendar field only allows selecting dates from the event date and time to the current date")
			public void user_should_verify_that_the_notification_date_calendar_field_only_allows_selecting_dates_from_the_event_date_and_time_to_the_current_date() {

				staffpom.getIncidentReportPage().verifyPreviousDatesIsDisabled().verifyNextToTheCurrentDateIsDisabled();

			}

			@Then("User should select a notified date using dropdown in date picker and verify the selected notified date are updated accordingly")
			public void user_should_select_a_notified_date_using_dropdown_in_date_picker_and_verify_the_selected_notified_date_are_updated_accordingly() {

				staffpom.getIncidentReportPage().selectNotificateDateUsingDD();			
		}
									
		
		}
