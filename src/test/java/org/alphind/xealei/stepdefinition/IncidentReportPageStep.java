package org.alphind.xealei.stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.text.ParseException;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.alphind.xealei.baseclass.BaseClass;
import org.alphind.xealei.pom.PageObjectManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class IncidentReportPageStep extends BaseClass {

	private WebDriver staffDriver = getDriver();
	private WebDriver chiefnurseDriver;
	private WebDriver rmDriver;
	private WebDriver ccDriver;
	private WebDriver swDriver;

	private PageObjectManager staffpom = new PageObjectManager(staffDriver);
	private PageObjectManager chiefnursepom;
	private PageObjectManager rmpom;
	private PageObjectManager ccpom;
	private PageObjectManager swpom;

	private String reportid;

	@When("User should perform login as facility admin {string} and {string}")
	public void user_should_perform_login_as_facility_admin(String userName, String password) {

		logStep(methodName());

			staffpom.getLoginPage().validEmail(2);
			staffpom.getLoginPage().validPassword(2);
			waitForFullPageElementLoad(staffDriver);
			staffpom.getLoginPage().loginButton();
		
	}

	@When("User should perform login as staff {string} and {string}")
	public void user_should_perform_login_as_staff_and(String userName, String passWord) {
		
		logStep(methodName());

		staffpom.getLoginPage().validEmail(2);
		staffpom.getLoginPage().validPassword(2);
		
	waitForPageLoad(staffDriver);
	waitForFullPageElementLoad(staffDriver);
	sleep(2000);
	staffpom.getLoginPage().loginButton();
	}
	
	@Then("User should also verify the performed login as {string}")
	public void user_should_also_verify_the_performed_login_as(String adminName) {

		logStep(methodName());
		
		try {
		Assert.assertEquals("Login page url is wrong", adminName, staffpom.getHomePage().getAdminNameText());
		System.out.println("EXP Value" + adminName);
		System.out.println("ACT Value" + staffpom.getHomePage().getAdminNameText());
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("User should verify the Incident report module is working")
	public void user_should_verify_the_incident_report_module_is_working() {

		logStep(methodName());
		
		staffpom.getHomePage().navToReportsModule();
		staffpom.getHomePage().navToIncidentReportModule();

		try {
			Assert.assertEquals("Unable to navigate Reports>Incident Reports Module ", "Incident Reports", staffpom.getIncidentReportPage().getIncidentReportModuleText());
			log(Status.PASS, "Incident Report sub-module button is working");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		waitForPageLoad();
	}

	@Then("User should verify the ADD New Incident Report button is working")
	public void user_should_verify_the_add_new_incident_report_button_is_working() {
		
		logStep(methodName());
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
		
		logStep(methodName());
		
		if (staffpom.getIncidentReportPage().getSaveButtonAttributeValue("disabled").equalsIgnoreCase("true")) {
			log(Status.PASS, "SAVE button is disabled after enter into Add Incidet Report Page");
		} else {
			log(Status.FAIL, "SAVE button is NOT disabled after enter into Add Incidet Report Page");
		}
	}

	@Then("User should verify Next > button is working")
	public void user_should_verify_next_button_is_working() {
		
		logStep(methodName());
		
		staffpom.getIncidentReportPage().nextButton();
	}

	@Then("User should verify the validation info message under all fields {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void user_should_verify_the_validation_info_message_under_all_fields1(String expIndDetailsInfoMsgText,
			String expEventDateAndTimeInfoMsgText, String expWhatCausedAFall, String expWasInjuredInfoMsgText,
			String expInjuryDescriptionInfoMsgText, String expInjurySiteInfoMsgText, String expTreatmentReceivedInfoMsgText,
			String expFutureTreatmentInfoMsgText, String expInjuryTypeInfoMsgText, String expInjuryColorInfoMsgText,
			String expInjurySevereInfoMsgText, String expPersonNotifiedInfoMsgText, String expRelationshipInfoMsgText,
			String expNotificationDateInfoMsgText, String expNotificationTimeInfoMsgText, String expNotifiedByInfoMsgText) {

		logStep(methodName());
		
		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Individual’s Details field",
					expIndDetailsInfoMsgText, staffpom.getIncidentReportPage().getIndividualsDetailsValidationInfoMsgText());
			log(Status.PASS, "MF validation info msg is displayed as expected under Individual’s Details field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Event Date & Time field",
					expEventDateAndTimeInfoMsgText,
					staffpom.getIncidentReportPage().getEventDateAndTimeValidationInfoMsgText());
			log(Status.PASS, "MF validation info msg is displayed as expected under Event Date & Time field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		staffpom.getIncidentReportPage().selectIndividualDetailsDropdown();

		staffpom.getIncidentReportPage().eventDateAndTime();

		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under What caused the fall? field",
					expWhatCausedAFall, staffpom.getIncidentReportPage().getFallCausedValidationInfoMsgText());
			log(Status.PASS, "MF validation info msg is displayed as expected under What caused the fall? field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();

		}

		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Was injured? field",
					expWasInjuredInfoMsgText, staffpom.getIncidentReportPage().getChooseWasIndInjuredRadioButtonValidationInfoMsgText());
			log(Status.PASS, "MF validation info msg is displayed as expected under Was injured? field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		staffpom.getIncidentReportPage().wasIndividualInjuredRadioButton();

		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Injury Description field",
					expInjuryDescriptionInfoMsgText, staffpom.getIncidentReportPage().getInjuryDescriptionValidationInfoMsgText());
			log(Status.PASS, "MF validation info msg is displayed as expected under Injury Description field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Injury Site field",
					expInjurySiteInfoMsgText, staffpom.getIncidentReportPage().getInjurySiteValidationInfoMsgText());
			log(Status.PASS, "MF validation info msg is displayed as expected under Injury Site field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {

			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Treatment Received field",
					expTreatmentReceivedInfoMsgText, staffpom.getIncidentReportPage().getTreatmentReceivedValidationInfoMsgText());
			log(Status.PASS, "MF validation info msg is displayed as expected under Treatment Received field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {

			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Future Treatment field",
					expFutureTreatmentInfoMsgText, staffpom.getIncidentReportPage().getFutureTreatmentValidationInfoMsgText());
			log(Status.PASS, "MF validation info msg is displayed as expected under Future Treatment field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {

			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Injury Type field",
					expInjuryTypeInfoMsgText, staffpom.getIncidentReportPage().getInjuryTypeValidationInfoMsgText());
			log(Status.PASS, "MF validation info msg is displayed as expected under Injury Type field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {

			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Injury Color field",
					expInjuryColorInfoMsgText, staffpom.getIncidentReportPage().getInjuryColorValidationInfoMsgText());
			log(Status.PASS, "MF validation info msg is displayed as expected under Injury Color field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {

			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Injury Serve field",
					expInjurySevereInfoMsgText,
					staffpom.getIncidentReportPage().getInjurySeverityValidationInfoMsgText());
			log(Status.PASS, "MF validation info msg is displayed as expected under Injury Serve field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {

			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Person Notified field",
					expPersonNotifiedInfoMsgText,
					staffpom.getIncidentReportPage().getPersonNotifiedValidationInfoMsgText());
			log(Status.PASS, "MF validation info msg is displayed as expected under Person Notified field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {

			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Relationship field",
					expRelationshipInfoMsgText,
					staffpom.getIncidentReportPage().getRelationshipValidationInfoMsgText());
			log(Status.PASS, "MF validation info msg is displayed as expected under Relationship field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {

			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Notification Date field",
					expNotificationDateInfoMsgText,
					staffpom.getIncidentReportPage().getChooseNotifiationDateValidationInfoMsgText());
			log(Status.PASS, "MF validation info msg is displayed as expected under Notification Date field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {

			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Notification Time field",
					expNotificationTimeInfoMsgText,
					staffpom.getIncidentReportPage().getChooseNotifiationTimeValidationInfoMsgText());
			log(Status.PASS, "MF validation info msg is displayed as expected under Notification Time field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {

			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Notified By field",
					expNotifiedByInfoMsgText, staffpom.getIncidentReportPage().getNotifiedValidationInfoMsgText());
			log(Status.PASS, "MF validation info msg is displayed as expected under Notified By field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("User should verify Save button is working in IR Page after perform Individuals Details and Event Date & Time fields")
	public void user_should_verify_save_button_is_working_in_ir_page_after_perform_individuals_details_and_event_date_time_fields() {

		logStep(methodName());
		
		staffpom.getIncidentReportPage().enterInjuryDescriptionData();

		staffpom.getIncidentReportPage().saveButton();

	}

	@Then("User should verify the toast message after click Save button in IR Page {string}")
	public void user_should_verify_the_toast_message_after_click_save_button_in_ir_page(String expSuccessfullToastMsg) {

		logStep(methodName());
		
		try {
			Assert.assertEquals("Saved Successfull Toast Message is not displayed", expSuccessfullToastMsg,
					staffpom.getIncidentReportPage().getSavedSuccessfullToastMsgText());
			log(Status.PASS, "Toast Message is displayed : "
					+ staffpom.getIncidentReportPage().getSavedSuccessfullToastMsgText());

			staffpom.getIncidentReportPage().savedSuccessfulToastMsgokButton();

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("User should verify the respective individual report status {string}")
	public void user_should_verify_the_respective_individual_report_status(String expDraftStatus) {

		logStep(methodName());
		
		String IRStatus = staffpom.getIncidentReportPage().getStatus(staffpom.getIncidentReportPage().getRowNumber());
		System.out.println("Current IR Status -" + IRStatus);

		try {

			Assert.assertEquals("DRAFT Status is Not displayed IR Grid page", expDraftStatus, IRStatus);
			log(Status.PASS, "Required fields Note: info message is displayed as expected Exp info Msg - "
					+ expDraftStatus + " Actual Msg - " + IRStatus);
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("User should verify the view button is working in IR Grid")
	public void user_should_verify_the_view_button_is_working_in_ir_grid() {

		logStep(methodName());
		
		staffpom.getIncidentReportPage().viewButton(staffpom.getIncidentReportPage().getRowNumber());
	}

	@Then("User should verify the error message in Incident Report Page {string}")
	public void user_should_verify_the_error_message_in_incident_report_page(String expNoteMsg) {

		logStep(methodName());
		
		scrollDownToBottomOfThePage();

		try {
			Assert.assertEquals("Required fields Note: info message is Not displayed as expected", expNoteMsg, staffpom.getIncidentReportPage().getNOTEInfoMsgText());
			log(Status.PASS, "Required fields Note: info message is displayed as expected Exp info Msg - "
					+ staffpom.getIncidentReportPage().getNOTEInfoMsgText());

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should verify the complete button is disabled")
	public void user_should_verify_the_complete_button_is_disabled() {

		logStep(methodName());
		
		if (staffpom.getIncidentReportPage().isCompleteButtonIsDisabled()) {
			log(Status.PASS, "Complete button is disabled after click view button");
		} else {
			log(Status.FAIL, "Complete button is NOT disabled after click view button");
		}
	}

	@Then("User should verify the edit button is working in IR submission page")
	public void user_should_verify_the_edit_button_is_working_in_IR_submission_page() throws Exception {

		logStep(methodName());
		
		staffpom.getIncidentReportPage().EditButton();

		if (staffpom.getIncidentReportPage().isSaveButtonDisplayed()) {
			log(Status.PASS, "Edit button is working as expected");
		}
	}

	@Then("User should verify the injury question section should display with selected individual name in field")
	public void user_should_verify_the_injury_question_section_should_display_with_selected_individual_name_in_field() {

		logStep(methodName());
		
		System.out.println(
				"Actual ind name -" + staffpom.getIncidentReportPage().getIndividualNameFromWasIndividualInjured());
		String selectedIndividualName = readExcel("Test Datas", "Incident Reports", 1, 28);

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

		logStep(methodName());
		
		staffpom.getIncidentReportPage().deleteEventDtAndTimeFieldExistingData();

		staffpom.getIncidentReportPage().eventDateAndFutureTime();
	}

	@Then("User should validation info message is thrown under Event time for selecting  greater than current time of current date {string}")
	public void user_should_validation_info_message_is_thrown_under_event_time_for_selecting_greater_than_current_time_of_current_date(
			String expGreaterThanCurrentTime) {

		logStep(methodName());
		
		try {
			Assert.assertEquals(
					"validation info message is NOT thrown under Event time for selecting  greater than current time of current date as expected",
					expGreaterThanCurrentTime, staffpom.getIncidentReportPage().getExceedCurrentTimeIneventDateAndTimeValidationInfoMsgText());
			log(Status.PASS,
					"Validation info message is displayed after enter greater than current time of current date as expected Exp info Msg - "
							+ staffpom.getIncidentReportPage().getExceedCurrentTimeIneventDateAndTimeValidationInfoMsgText());

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should verify that able to spot the injury on Injury site front & Back view")
	public void user_should_verify_that_able_to_spot_the_injury_on_injury_site_front_back_view() {

		logStep(methodName());
		
		staffpom.getIncidentReportPage().frontViewForeHeadInjury().frontViewFaceInjury().frontViewRightShoulderInjury()
				.frontViewRightArmInjury().frontViewRightWristInjury().frontViewRightKneeInjury()
				.frontViewRightFootInjury().frontViewChestInjury().frontViewAbdomenInjury()
				.frontViewLeftShoulderInjury().frontViewLefttArmInjury().frontViewLefttWristInjury()
				.frontViewLeftKneeInjury().frontViewLeftFootInjury();

		staffpom.getIncidentReportPage().backViewHeadInjury().backViewRightShoulderInjury().backViewRightArmInjury()
				.backViewRightWristInjury().backViewRightKneeInjury().backViewRightFootInjury()
				.backViewLeftShoulderInjury().backViewLefttArmInjury().backViewLefttWristInjury()
				.backViewLeftKneeInjury().backViewLeftFootInjury().backViewHipInjury().backViewBackInjury();
	}

	@Then("User should verify that able to unselect the injury on Injury site front & Back view")
	public void user_should_verify_that_able_to_unselect_the_injury_on_injury_site_front_back_view() {

		logStep(methodName());
		
		staffpom.getIncidentReportPage().unselectFrontViewForeHeadInjury().unselectFrontViewFaceInjury()
				.unselectFrontViewRightShoulderInjury().unselectFrontViewRightArmInjury()
				.unselectFrontViewRightWristInjury().unselectFrontViewRightKneeInjury()
				.unselectFrontViewRightFootInjury().unselectFrontViewChestInjury().unselectFrontViewAbdomenInjury()
				.unselectFrontViewLeftShoulderInjury().unselectFrontViewLefttArmInjury()
				.unselectFrontViewLefttWristInjury().unselectFrontViewLeftKneeInjury()
				.unselectFrontViewLeftFootInjury();

		staffpom.getIncidentReportPage().unselectBackViewHeadInjury().unselectBackViewRightShoulderInjury()
				.unselectBackViewRightArmInjury().unselectBackViewRightWristInjury().unselectBackViewRightKneeInjury()
				.unselectBackViewRightFootInjury().unselectBackViewLeftShoulderInjury().unselectBackViewLefttArmInjury()
				.unselectBackViewLefttWristInjury().unselectBackViewLeftKneeInjury().unselectBackViewLeftFootInjury()
				.unselectBackViewHipInjury().unselectBackViewBackInjury();

		try {
			Assert.assertEquals("Unable to unselect the injury on Injury site front / Back view",
					"Please select injury site", staffpom.getIncidentReportPage().getInjurySiteValidationInfoMsgText());
			log(Status.PASS, "Able to unselect the injury on Injury site front & Back view as expected");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should verify that able to upload upload JFIF Format")
	public void user_should_verify_that_able_to_upload_upload_jfif_format() {

		logStep(methodName());
		
		staffpom.getIncidentReportPage().jfifFileUpload("JFIF Format", "jfif");
	}

	@Then("User should verify that able to upload more than 1MB File format")
	public void user_should_verify_that_able_to_upload_more_than_1mb_file_format() {

		logStep(methodName());
		
		staffpom.getIncidentReportPage().moreThan1MBImgFormatUpload("MoreThan1MB", "jpg");

	}

	@Then("User should verify that able to upload files or images")
	public void user_should_verify_that_able_to_upload_files_or_images() {

		logStep(methodName());
		
		staffpom.getIncidentReportPage().Upload("JPG", "jpg");
	}

	@Then("User should verify the delete icon is working on image under injury photo field")
	public void user_should_verify_the_delete_icon_is_working_on_image_under_injury_photo_field() {

		logStep(methodName());
		
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

		logStep(methodName());
		
		staffpom.getIncidentReportPage().abrasion().bleeding().bruise().scratch();
	}

	@Then("User should verify that whether able to unselect the selected option values under Injury Type field")
	public void user_should_verify_that_whether_able_to_unselect_the_selected_option_values_under_injury_type_field() {

		logStep(methodName());
		
		staffpom.getIncidentReportPage().abrasionForUnselect().bleedingForUnselect().bruiseForUnselect()
				.scratchForUnselect();
	}

	@Then("User should verify that whether able to select the option value under How severe was injury? field")
	public void user_should_verify_that_whether_able_to_select_the_option_value_under_how_severe_was_injury_field() {

		logStep(methodName());
		
		staffpom.getIncidentReportPage().lightOption().mediumOption().highOption();
	}

	@Then("User should verify that whether able to select the option value under Injury Color")
	public void user_should_verify_that_whether_able_to_select_the_option_value_under_injury_color() {

		logStep(methodName());
		
		staffpom.getIncidentReportPage().greenColor().redColor().blackColor().brownColor();

	}

	@Then("User should verify that whether default optional values is selected under was Event Notified?")
	public void user_should_verify_that_whether_default_optional_values_is_selected_under_was_event_notified()
			throws Exception {

		logStep(methodName());
		

		if (staffpom.getIncidentReportPage().isDefaultOptionIsSelected()) {
			log(Status.PASS, "Default option is selected under Was the event notified? radio button field");
		} else {
			log(Status.FAIL, "Default optional values is NOT selected under was Event Notified?");
			throw new Exception();
		}
	}

	@Then("User should verify that able to enter current date and time in Event Date & Time field")
	public void user_should_verify_that_able_to_enter_current_date_and_time_in_event_date_time_field() {

		logStep(methodName());
		
		staffpom.getIncidentReportPage().deleteEventDtAndTimeFieldExistingData();
		
		staffpom.getIncidentReportPage().eventDateAndTime();
	}

	@Then("User should click on the Notification Date calendar icon")
	public void user_should_click_on_the_notification_date_calendar_icon() {

		logStep(methodName());
		
		staffpom.getIncidentReportPage().notificationDateFieldCalenderIconButton();
	}

	@Then("User should verify that the Notification Date calendar field only allows selecting dates from the event date and time to the current date")
	public void user_should_verify_that_the_notification_date_calendar_field_only_allows_selecting_dates_from_the_event_date_and_time_to_the_current_date() {

		logStep(methodName());
		
		staffpom.getIncidentReportPage().verifyPreviousDatesIsDisabled().verifyNextToTheCurrentDateIsDisabled();

	}

	@Then("User should select a notified date using dropdown in date picker and verify the selected notified date are updated accordingly")
	public void user_should_select_a_notified_date_using_dropdown_in_date_picker_and_verify_the_selected_notified_date_are_updated_accordingly() {

		logStep(methodName());
		
		staffpom.getIncidentReportPage().selectNotificateDateUsingDD();
	}

	@Then("User should verify the validation info message is thrown after selecting Notification Time field value is lesser than Event Date & Time field value {string}")
	public void user_should_verify_the_validation_info_message_is_thrown_after_selecting_notification_time_field_value_is_lesser_than_event_date_time_field_value(
			String expLesserThanNoticationTimeToastMsg) {
		
		logStep(methodName());
		
		staffpom.getIncidentReportPage().pastTimeInNotificationTime();

		try {
			Assert.assertEquals(
					"Lesser than event time info msg is NOT displayed as expected under Notification Time field",
					expLesserThanNoticationTimeToastMsg,
					staffpom.getIncidentReportPage().getLesserThanNotifiedTimeInfoMsgText());
			log(Status.PASS,
					"Lesser than current time info msg is displayed as expected under Notification Time field Exp info msg - "
							+ expLesserThanNoticationTimeToastMsg + " Actual info msg - "
							+ staffpom.getIncidentReportPage().getLesserThanNotifiedTimeInfoMsgText());
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should verify the validation info message is thrown after selecting greater than current time in Notification Time field {string}")
	public void user_should_verify_the_validation_info_message_is_thrown_after_selecting_greater_than_current_time_in_notification_time_field(
			String expGreaterThanNoticationTimeToastMsg) {

		logStep(methodName());
		
		staffpom.getIncidentReportPage().futureTimeInNotificationTime();

		try {
			Assert.assertEquals(
					"Greater than event time info msg is NOT displayed as expected under Notification Time field",
					expGreaterThanNoticationTimeToastMsg,
					staffpom.getIncidentReportPage().getLesserThanNotifiedTimeInfoMsgText());
			log(Status.PASS,
					"Lesser than current time info msg is displayed as expected under Notification Time field Exp info msg - "
							+ expGreaterThanNoticationTimeToastMsg + " Actual info msg - "
							+ staffpom.getIncidentReportPage().getLesserThanNotifiedTimeInfoMsgText());
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should verify that able to enter time in Notification Time field")
	public void user_should_verify_that_able_to_enter_time_in_notification_time_field() {

		logStep(methodName());
		
		staffpom.getIncidentReportPage().enterNotificationTime();
	}

	@Then("User should verify that after click the breadcrum text Report the page is navigated to the list of incident Reports page")
	public void user_should_verify_that_after_click_the_breadcrum_text_report_the_page_is_navigated_to_the_list_of_incident_reports_page() {

		logStep(methodName());
		
		staffpom.getIncidentReportPage().breadCrumREPORTTxtLink();
		waitForPageLoad();

		if (staffpom.getIncidentReportPage().isAddNewIncidentReportButtonDisplayed()) {
			log(Status.PASS, "The page is navigated to the list of incident Reports page");
		} else {
			log(Status.FAIL, "Unable to Navigated to the list of incident Reports page");
		}
	}

	@Then("User should verify the edit button is working in IR Grid")
	public void user_should_verify_the_edit_button_is_working_in_ir_grid() {

		logStep(methodName());
		
		staffpom.getIncidentReportPage().editButton(staffpom.getIncidentReportPage().getRowNumber());

		if (staffpom.getIncidentReportPage().isSaveButtonDisplayed()) {
			log(Status.PASS, "Edit button is working in IR Grid");
		} else {
			log(Status.FAIL, "Edit button is NOT working in IR Grid");
		}
	}

	@Then("User should verify that the IR form continues to display the previously entered draft datas")
	public void user_should_verify_that_the_ir_form_continues_to_display_the_previously_entered_draft_datas() {

		logStep(methodName());
		
		try {
			Assert.assertEquals("IR form is NOT displayed the previously entered draft datas",
					readExcel("Test Datas", "Incident Reports", 1, 18),
					staffpom.getIncidentReportPage().getInjuryDescriptionTxtBoxAttributeValue());
			log(Status.PASS, "IR form continues to display the previously entered draft datas");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should verify the breadcrum text")
	public void user_should_verify_the_breadcrum_text() {

		logStep(methodName());
		
		if (staffpom.getIncidentReportPage().isBCReportsTextDisplayed() && staffpom.getIncidentReportPage().isBCIncidentReportTextDisplayed()) {
			log(Status.PASS, "Bread crum text is displayed as expected Exp BC Txt - Reports > Incident Report | Actual BC Txt - "
							+ staffpom.getIncidentReportPage().getBreadCrumTxtLinkReportsText() + " > " + staffpom.getIncidentReportPage().getBreadCrumTxtLinkIncidentReportText());

		} else {
			log(Status.FAIL,
					"Bread crum text is NOT displayed as expected Exp BC Txt - Reports > Incident Report | Actual BC Txt - "
							+ staffpom.getIncidentReportPage().getBreadCrumTxtLinkReportsText() + " > "
							+ staffpom.getIncidentReportPage().getBreadCrumTxtLinkIncidentReportText());
		}
	}

	@Then("User should perform all the fields")
	public void user_should_perform_all_the_fields() {

		logStep(methodName());
		
		staffpom.getIncidentReportPage().eventDateAndTime();
		staffpom.getIncidentReportPage().enterWhatCausedTheFallData();
		staffpom.getIncidentReportPage().selectWasTheIndividiualInjured();
		staffpom.getIncidentReportPage().selectFrontViewInjurySite();
		staffpom.getIncidentReportPage().selectBackViewInjurySite();
		staffpom.getIncidentReportPage().enterTreatmentReceivedData();
		
		staffpom.getIncidentReportPage().deleteInjuryDescriptionExistingTxtBoxValue();
		
		staffpom.getIncidentReportPage().enterInjuryDescriptionData();
		staffpom.getIncidentReportPage().enterFutureTreatmentData();
		staffpom.getIncidentReportPage().selectInjuryType();
		staffpom.getIncidentReportPage().selectInjuryColor();
		staffpom.getIncidentReportPage().selectHowSevereWasTheInjury();
		staffpom.getIncidentReportPage().enterPersonNotifiedData();
		staffpom.getIncidentReportPage().enterNotificationDate();
		staffpom.getIncidentReportPage().enterNotificationTime();
		staffpom.getIncidentReportPage().enterNotifiedByData();
		staffpom.getIncidentReportPage().selectRelationship();
	    staffpom.getIncidentReportPage().selectNotificationMethod();

		staffpom.getIncidentReportPage().nextButton();
	}

	@Then("User should verify all the created details are displayed as expected")
	public void user_should_verify_all_the_created_details_are_displayed_as_expected() throws ParseException {

		logStep(methodName());
		
		waitForPageLoad();

		System.out.println("Location DATA - " + staffpom.getIncidentReportPage().getLocationValue());
		System.out.println("CAUSE DATA - " + staffpom.getIncidentReportPage().getInjuryCausedValue());
		System.out.println("Injury DATA - " + staffpom.getIncidentReportPage().getWasInjuredValue());
		System.out.println("INJ DESCRIPTION DATA - " + staffpom.getIncidentReportPage().getInjuryDescriptionValue());
		System.out.println("SiteOfInjury FRONT DATA - " + staffpom.getIncidentReportPage().getSiteOfInjuryFrontValue());
		System.out.println("SiteOfInjury BACK DATA - " + staffpom.getIncidentReportPage().getSiteOfInjuryBackValue());
		System.out.println("Treatment Received DATA - " + staffpom.getIncidentReportPage().getTreatmentReceivedValue());
		System.out.println("Future Treatment DATA - " + staffpom.getIncidentReportPage().getFutureTreatmentValue());
		System.out.println("Injury Type DATA - " + staffpom.getIncidentReportPage().getInjuryTypeValue());
		System.out.println("Injury Severity DATA - " + staffpom.getIncidentReportPage().getInjurySeverityValue());
		System.out
				.println("Was Event Notified? DATA - " + staffpom.getIncidentReportPage().getEventNotifiStatusValue());
		System.out.println("Person Notified DATA - " + staffpom.getIncidentReportPage().getPersonNotifiedValue());
		System.out.println("Relationship DATA - " + staffpom.getIncidentReportPage().getRelationshipValue());
		System.out.println(
				"Noti Date& Time DATA - " + staffpom.getIncidentReportPage().getNotificationDateAndTimeValue());

		try {
			Assert.assertEquals("User Location is mismatched / NOT displayed as expected", "ATFacilityAdmin",
					staffpom.getIncidentReportPage().getLocationValue());
			log(Status.PASS, "Location Name is displayed as expected ");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String WhatCausedTheFallFieldExpDataFromExcel = readExcel("Test Datas", "Incident Reports", 1, 2);

			Assert.assertEquals("What caused the fall? field :Entered data is NOT accurately displayed as expected",
					WhatCausedTheFallFieldExpDataFromExcel, staffpom.getIncidentReportPage().getInjuryCausedValue());
			log(Status.PASS,
					"Entered data in What caused the fall? field is displayed as expected | Exp Data - "
							+ WhatCausedTheFallFieldExpDataFromExcel + " | Actual Data - "
							+ staffpom.getIncidentReportPage().getInjuryCausedValue());
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String wasInjuredFieldExpDataFromExcel = readExcel("Test Datas", "Incident Reports", 1, 4);
			Assert.assertEquals("Was injured? field :Selected data is NOT accurately displayed as expected",
					wasInjuredFieldExpDataFromExcel, staffpom.getIncidentReportPage().getWasInjuredValue());
			log(Status.PASS,
					"Selected data in Was injured? field is displayed as expected | Exp Data - "
							+ wasInjuredFieldExpDataFromExcel + " | Actual Data - "
							+ staffpom.getIncidentReportPage().getWasInjuredValue());
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String InjuredDescExpDataFromExcel = readExcel("Test Datas", "Incident Reports", 1, 18);
			Assert.assertEquals("Injury Description field :Entered data is NOT accurately displayed as expected",
					InjuredDescExpDataFromExcel, staffpom.getIncidentReportPage().getInjuryDescriptionValue());
			log(Status.PASS,
					"Injury Description field :Entered data is displayed as expected | Exp Data - "
							+ InjuredDescExpDataFromExcel + " | Actual Data - "
							+ staffpom.getIncidentReportPage().getInjuryDescriptionValue());
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String InjuryFrontSiteExpDataFromExcel = "Front: " + readExcel("Test Datas", "Incident Reports", 1, 5);
			Assert.assertEquals("Injury Front Site field :Selected site names are NOT accurately displayed as expected",
					InjuryFrontSiteExpDataFromExcel, staffpom.getIncidentReportPage().getSiteOfInjuryFrontValue());
			log(Status.PASS,
					"Injury Front Site field :Selected site names are accurately displayed as expected | Exp Data - "
							+ InjuryFrontSiteExpDataFromExcel + " | Actual Data - "
							+ staffpom.getIncidentReportPage().getSiteOfInjuryFrontValue());
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String InjuryBackSiteExpDataFromExcel = "Back: " + readExcel("Test Datas", "Incident Reports", 1, 6);
			Assert.assertEquals("Injury Back Site field :Selected site names are NOT accurately displayed as expected",
					InjuryBackSiteExpDataFromExcel, staffpom.getIncidentReportPage().getSiteOfInjuryBackValue());
			log(Status.PASS,
					"Injury Back Site field :Selected site names are accurately displayed as expected | Exp Data - "
							+ InjuryBackSiteExpDataFromExcel + " | Actual Data - "
							+ staffpom.getIncidentReportPage().getSiteOfInjuryBackValue());
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String TreatmentReceivedExpDataFromExcel = readExcel("Test Datas", "Incident Reports", 1, 7);
			Assert.assertEquals("Treatment Received field :Entered data is NOT accurately displayed as expected",
					TreatmentReceivedExpDataFromExcel, staffpom.getIncidentReportPage().getTreatmentReceivedValue());
			log(Status.PASS,
					"Treatment Received field :Entered data is accurately displayed as expected | Exp Data - "
							+ TreatmentReceivedExpDataFromExcel + " | Actual Data - "
							+ staffpom.getIncidentReportPage().getTreatmentReceivedValue());
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String FutureTreatmentExpDataFromExcel = readExcel("Test Datas", "Incident Reports", 1, 8);
			Assert.assertEquals("Future Treatment Received field :Entered data is NOT accurately displayed as expected",
					FutureTreatmentExpDataFromExcel, staffpom.getIncidentReportPage().getFutureTreatmentValue());
			log(Status.PASS,
					"Future Treatment Received field :Entered data is accurately displayed as expected | Exp Data - "
							+ FutureTreatmentExpDataFromExcel + " | Actual Data - "
							+ staffpom.getIncidentReportPage().getFutureTreatmentValue());
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String InjuryTypeExpDataFromExcel = readExcel("Test Datas", "Incident Reports", 1, 9);
			Assert.assertEquals("Injury Type field :Selected data is NOT accurately displayed as expected",
					InjuryTypeExpDataFromExcel, staffpom.getIncidentReportPage().getInjuryTypeValue());
			log(Status.PASS,
					"Injury Type field :Selected data is accurately displayed as expected | Exp Data - "
							+ InjuryTypeExpDataFromExcel + " | Actual Data - "
							+ staffpom.getIncidentReportPage().getInjuryTypeValue());
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String InjurySeverityExpDataFromExcel = readExcel("Test Datas", "Incident Reports", 1, 11);
			Assert.assertEquals("Injury severity field :Selected data is NOT accurately displayed as expected",
					InjurySeverityExpDataFromExcel, staffpom.getIncidentReportPage().getInjurySeverityValue());
			log(Status.PASS,
					"Injury severity field :Selected data is accurately displayed as expected | Exp Data - "
							+ InjurySeverityExpDataFromExcel + " | Actual Data - "
							+ staffpom.getIncidentReportPage().getInjurySeverityValue());
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String getColorAttribute = staffpom.getIncidentReportPage().getInjuryColorValueAttributeValue();
			System.out.println("Get Color Attribute - " + getColorAttribute);
			String getSelectedColor = readExcel("Test Datas", "Incident Reports", 1, 10).trim();

			switch (getSelectedColor) {

			case "Green": {
				boolean green = getColorAttribute.equals("background-color: rgb(165, 171, 107);");
				Assert.assertTrue("Injury color field :Selected color GREEN is NOT accurately displayed as expected",
						green);
				log(Status.PASS, "Injury color field :Selected color GREEN is displayed as expected");
				break;
			}

			case "Red": {

				boolean red = getColorAttribute.equals("background-color: rgb(221, 116, 103);");
				Assert.assertTrue("Injury color field :Selected color RED is NOT accurately displayed as expected",
						red);
				log(Status.PASS, "Injury color field :Selected color RED is displayed as expected");
				break;
			}
			case "Black": {

				boolean black = getColorAttribute.equals("background-color: rgb(72, 72, 87);");
				Assert.assertTrue("Injury color field :Selected color BLACK is NOT accurately displayed as expected",
						black);
				log(Status.PASS, "Injury color field :Selected color BLACK is displayed as expected");
				break;
			}
			case "Brown": {

				boolean brown = getColorAttribute.equals("background-color: rgb(176, 137, 100);");
				Assert.assertTrue("Injury color field :Selected color BROWN is NOT accurately displayed as expected",
						brown);
				log(Status.PASS, "Injury color field :Selected color BROWN is displayed as expected");
				break;
			}
			default: {
				log(Status.FAIL, "Selected Injury Color does NOT displayed as expected");
				break;
			}
			}
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String EventNotificationStatusExpData = "Yes";
			Assert.assertEquals("Was the event notified? field :Selected data is NOT accurately displayed as expected",
					EventNotificationStatusExpData, staffpom.getIncidentReportPage().getEventNotifiStatusValue());
			log(Status.PASS,
					"Was the event notified? field :Selected data is accurately displayed as expected | Exp Data - "
							+ EventNotificationStatusExpData + " | Actual Data - "
							+ staffpom.getIncidentReportPage().getEventNotifiStatusValue());
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String PersonNotifiedExpDataFromExcel = readExcel("Test Datas", "Incident Reports", 1, 12);
			Assert.assertEquals("Person Notified field :Entered data is NOT accurately displayed as expected",
					PersonNotifiedExpDataFromExcel, staffpom.getIncidentReportPage().getPersonNotifiedValue());
			log(Status.PASS,
					"Person Notified field :Entered data is accurately displayed as expected | Exp Data - "
							+ PersonNotifiedExpDataFromExcel + " | Actual Data - "
							+ staffpom.getIncidentReportPage().getPersonNotifiedValue());
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String RelationshipExpDataFromExcel = readExcel("Test Datas", "Incident Reports", 1, 13);
			Assert.assertEquals("Relationship field :Selected data is NOT accurately displayed as expected",
					RelationshipExpDataFromExcel, staffpom.getIncidentReportPage().getRelationshipValue());
			log(Status.PASS,
					"Relationship field :Selected data is accurately displayed as expected | Exp Data - "
							+ RelationshipExpDataFromExcel + " | Actual Data - "
							+ staffpom.getIncidentReportPage().getRelationshipValue());
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String GetNotifiedDateFromExcel = readExcel("Test Datas", "Incident Reports", 1, 14);
			String GetNotifiedTimeFromExcel = readExcel("Test Datas", "Incident Reports", 1, 15);
			Assert.assertEquals("Notification Date&Time field :Entered data is NOT accurately displayed as expected",
					dateConversion(GetNotifiedDateFromExcel, GetNotifiedTimeFromExcel),
					staffpom.getIncidentReportPage().getNotificationDateAndTimeValue());
			log(Status.PASS,
					"Notification Date&Time field :Entered data is accurately displayed as expected | Exp Data - "
							+ dateConversion(GetNotifiedDateFromExcel, GetNotifiedTimeFromExcel) + " | Actual Data - "
							+ staffpom.getIncidentReportPage().getNotificationDateAndTimeValue());
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			String NotifiedByExpDataFromExcel = readExcel("Test Datas", "Incident Reports", 1, 16);
			Assert.assertEquals("Notified By field :Entered data is NOT accurately displayed as expected",
					NotifiedByExpDataFromExcel, staffpom.getIncidentReportPage().getNotifiedByValue());
			log(Status.PASS,
					"Notified By field :Entered data is accurately displayed as expected | Exp Data - "
							+ NotifiedByExpDataFromExcel + " | Actual Data - "
							+ staffpom.getIncidentReportPage().getNotifiedByValue());
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}


			try {
				String NotificationMethodExpDataFromExcel = readExcel("Test Datas", "Incident Reports", 1, 17);
				Assert.assertEquals("Notification Method field :Entered data is NOT accurately displayed as expected", NotificationMethodExpDataFromExcel, staffpom.getIncidentReportPage().getNotificationMethodValue());
				log(Status.PASS, "Notification Method field :Entered data is accurately displayed as expected | Exp Data - "+NotificationMethodExpDataFromExcel+" | Actual Data - "+staffpom.getIncidentReportPage().getNotificationMethodValue());
			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}

	}

	@Then("User should verify the breadcrums texts")
	public void user_should_verify_the_breadcrums_texts() {

		logStep(methodName());
		
		if (staffpom.getIncidentReportPage().isBcIndividualNameTextIsEqualAsExpected()
				&& staffpom.getIncidentReportPage().isBCIncidentReportTextIsDisplayed()) {
			log(Status.PASS, "Bread crum text is displayed as expected Exp BC Txt - Reports > " + staffpom.getIncidentReportPage().breadCrumIndividualNameText()
							+ " > Incident Report | Actual BC Txt - "
							+ staffpom.getIncidentReportPage().getBreadCrumTxtLinkReportsText() + " > "
							+ staffpom.getIncidentReportPage().breadCrumIndividualNameText() + " > "
							+ staffpom.getIncidentReportPage().getBreadCrumTxtLinkIncidentReportInViewPage());

		} else {
			log(Status.FAIL,
					"Bread crum text is NOT displayed as expected Exp BC Txt - Reports > Incident Report | Actual BC Txt - "
							+ staffpom.getIncidentReportPage().getBreadCrumTxtLinkReportsText() + " > "
							+ staffpom.getIncidentReportPage().breadCrumIndividualNameText() + " > "
							+ staffpom.getIncidentReportPage().getBreadCrumTxtLinkIncidentReportInViewPage());
		}

	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Verify Home page is displayed.")
	public void verify_home_page_is_displayed() {

		logStep(methodName());
		
		staffpom.getHomePage().isHomePageDisplayed();
	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Navigate to Reports module.")
	public void navigate_to_reports_module() {
		
		logStep(methodName());
		
		staffpom.getHomePage().navToReportsModule();
	}
			/**
			 * Created by Nandhalala.
			 */
			@When("Click on complete button.")
			public void click_on_complete_button() {
				
				logStep(methodName());
				
			    staffpom.getIncidentReportPage().clickCompleteButton();
			    waitForPageLoad(staffDriver);
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("ReSubmit the Report by staff user.")
			public void ReSubmit_the_Report_by_staff_user() {
				
				logStep(methodName());
				
				staffpom.getIncidentReportPage().clickCompleteButton();
			    waitForPageLoad(staffDriver);
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("ReSubmit the Report by Chief nurse user.")
			public void ReSubmit_the_Report_by_chief_nurse_user() {
				
				logStep(methodName());
				
				chiefnursepom.getIncidentReportPage().clickCompleteButton();
			    waitForPageLoad(chiefnurseDriver);
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@When("Verify whether the report is in pending status.")
			public void verify_whether_the_report_is_in_pending_status() {
				
				logStep(methodName());
				
				String rowNumber = staffpom.getIncidentReportPage().getRowNumber();
			    String status =	staffpom.getIncidentReportPage().getStatus(rowNumber);
			    try {
				    assertEquals(status, "Pending",
				    		"The expected value is : Pending /nbut actual is : "+status);
				    log(Status.PASS, "The Incident Report submitted by the staff is in "
				    		+ "pending status.",staffDriver);
				} catch (Exception e) {
					log(Status.FAIL, "The Incident Report submitted by the staff is in "+status
				    		+ " not in pending status.",staffDriver);
				}
			    reportid =  staffpom.getIncidentReportPage().getReportID(rowNumber);
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Launch a new browser and enter xealei url for Chief nurse.")
			public void launch_a_new_browser_and_enter_xealei_url_for_Chief_nurse() {
				
				logStep(methodName());
				
				try {
					chiefnurseDriver = getNewDriver();
				} catch (Exception e) {
					e.printStackTrace();
				}
			    logStep(methodName());
			    chiefnurseDriver.get("https://xat.qa.xealei.com/login");
			    chiefnursepom = new PageObjectManager(chiefnurseDriver);
			    waitForPageLoad(chiefnurseDriver);
			    chiefnurseDriver.manage().window().maximize();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Launch a new browser and enter xealei url for residential manager.")
			public void launch_a_new_browser_and_enter_xealei_url_for_residential_manager() {
				
				logStep(methodName());
				
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
				
				logStep(methodName());
				
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
				
				logStep(methodName());
				
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
			@Then("Open notification received by staff.")
			public void Open_notification_received_by_Staff() {
				
				logStep(methodName());
				
				staffpom.getHomePage().notificationIcon(reportid);
			}
			
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Open notification received by Chief nurse.")
			public void Open_notification_received_by_Chief_nurse() {
				
				logStep(methodName());
				
				chiefnursepom.getHomePage().notificationIcon(reportid);
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Open notification received by residential manager.")
			public void Open_notification_received_by_residential_manager() {
				
				logStep(methodName());
				
				rmpom.getHomePage().notificationIcon(reportid);
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Open notification received by Clinical Coordinator.")
			public void Open_notification_received_by_Clinical_Coordinator() {
				
				logStep(methodName());
				
				ccpom.getHomePage().notificationIcon(reportid);
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Verify whether notification received by Social Worker.")
			public void verify_whether_notification_received_by_Social_Worker() {
				
				logStep(methodName());
				
				swpom.getHomePage().notificationIcon(reportid);
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Approve the report by Chief Nurse user.")
			public void approve_the_report_by_Chief_Nurse_user() {
				
				logStep(methodName());
				
				sleep(2000);
				waitForFullPageElementLoad(chiefnurseDriver);
			    chiefnursepom.getIncidentReportPage().chiefNurseReviewerComments("approved");
			    chiefnursepom.getIncidentReportPage().clickCompleteButton();
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Approve the report by Residential Manager user.")
			public void approve_the_report_by_Residential_Manager_user() {
				
				logStep(methodName());
				
				sleep(2000);
				waitForFullPageElementLoad(rmDriver);
				
			    rmpom.getIncidentReportPage().residentialManagerReviewerComments("approved");
			    rmpom.getIncidentReportPage().clickCompleteButton();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Approve the report by Clinical Coordinator user.")
			public void approve_the_report_by_Clinical_Coordinator_user() {
				
				logStep(methodName());
				
				sleep(2000);
				waitForFullPageElementLoad(ccDriver);
				
			    ccpom.getIncidentReportPage().clinicalCoordinatorReviewerComments("approved");
			    ccpom.getIncidentReportPage().clickCompleteButton();
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Approve the report by Social Worker user.")
			public void approve_the_report_by_Social_Worker_user() {
				
				logStep(methodName());
				
				sleep(2000);
				waitForFullPageElementLoad(swDriver);
				
			    swpom.getIncidentReportPage().socialWorkerReviewerComments("approved");
			    swpom.getIncidentReportPage().clickCompleteButton();
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Re-Send the report by Chief Nurse user to staff nurse.")
			public void re_send_the_report_by_Chief_nurse_user_to_staff_nurse() {
				
				logStep(methodName());
				
				sleep(2000);
				waitForFullPageElementLoad();
				
			    chiefnursepom.getIncidentReportPage().chiefNurseReviewerComments("rejected");
			    chiefnursepom.getIncidentReportPage().resubmitButton();
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Re-Send the report by Residential Manager user.")
			public void re_send_the_report_by_residential_manager_user() {
				
				logStep(methodName());
				
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
				
				logStep(methodName());
				
				Set<String> handle = staffDriver.getWindowHandles();
				staffDriver.getWindowHandle();
				//staffpom.getIncidentReportPage().navigateHome();
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Switch back to Chief nurse user login.")
			public void Switch_back_to_Chief_nurse_user_login() {
				
				logStep(methodName());
				
				Set<String> handle = staffDriver.getWindowHandles();
				staffDriver.getWindowHandle();
				staffpom.getIncidentReportPage().navigateHome();
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Verify whether the report is in {string} status by Chief Nurse user.")
			public void verify_whether_the_report_is_in_status_by_Chief_Nurse_user(String status) {
				
				logStep(methodName());
				
				String rowNumber = chiefnursepom.getIncidentReportPage().getRowNumber();
			    String actualStatus =	chiefnursepom.getIncidentReportPage().getStatus(rowNumber);
			    try {
			    	assertEquals(actualStatus, status, "The actual status is : "+actualStatus+
				    		" but the expected is : "+status);
				    log(Status.PASS, "The Incident Report approved by the Chief nurse is in "
				    		+ status+" status.",chiefnurseDriver);
				} catch (Exception e) {
					log(Status.FAIL, "The Incident Report submitted by the chief nurse is in "
				    		+actualStatus +" status not "+status,chiefnurseDriver);
				}
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Verify whether the report is in {string} status by Residential Manager user.")
			public void verify_whether_the_report_is_in_status_by_Residential_Manager_user(String status) {
				
				logStep(methodName());
				
				String rowNumber = rmpom.getIncidentReportPage().getRowNumber();
			    String actualStatus = rmpom.getIncidentReportPage().getStatus(rowNumber);
			    
			    try {
			    	assertEquals(actualStatus, status, "The actual status is : "+actualStatus+
				    		" but the expected is : "+status);
			    	log(Status.PASS, "The Incident Report approved by the residential manager is in "
				    		+ status+" status.",rmDriver);
				} catch (Exception e) {
					log(Status.FAIL, "The Incident Report submitted by the residential manager is in "
				    		+actualStatus +" status not "+status,rmDriver);
				}
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Verify whether the report is in {string} status by Clinical Coordinator user.")
			public void verify_whether_the_report_is_in_status_by_Clinical_Coordinator_user(String status) {
				
				logStep(methodName());
				
				String rowNumber = ccpom.getIncidentReportPage().getRowNumber();
			    String actualStatus =	ccpom.getIncidentReportPage().getStatus(rowNumber);
			    
			    try {
			    	assertEquals(actualStatus, status, "The actual status is : "+actualStatus+
				    		" but the expected is : "+status);
			    	log(Status.PASS, "The Incident Report approved by the Clincal Coordinator is in "
				    		+ status+" status.",ccDriver);
				} catch (Exception e) {
					log(Status.FAIL, "The Incident Report submitted by the Clincal Coordinator is in "
				    		+actualStatus +" status not "+status,ccDriver);
				}
			}
			
			/**
			 * Created by Nandhalala.
			 */
			@Then("Verify whether the report is in {string} status by Social Worker user.")
			public void verify_whether_the_report_is_in_status_by_Social_Worker_user(String status) {
				
				logStep(methodName());
				
				String rowNumber = swpom.getIncidentReportPage().getRowNumber();
			    String actualStatus =	swpom.getIncidentReportPage().getStatus(rowNumber);
			    
			    try {
			    	assertEquals(actualStatus, status, "The actual status is : "+actualStatus+
				    		" but the expected is : "+status);
			    	log(Status.PASS, "The Incident Report approved by the social worker is in "
				    		+ status+" status.",swDriver);
				} catch (Exception e) {
					log(Status.FAIL, "The Incident Report submitted by the social worker is in "
				    		+actualStatus +" status not "+status,swDriver);
				}
			}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Navigate to Incident Report sub module.")
	public void navigate_to_incident_report_sub_module() {
		
		logStep(methodName());
		
		staffpom.getHomePage().navToIncidentReportModule();
	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Click on Add New Incident Report button.")
	public void click_on_add_new_incident_report_button() {
		
		logStep(methodName());
		
		staffpom.getIncidentReportPage().addNewIncidentReportButton();
	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Verify Add Incident report page is displayed.")
	public void verify_add_incident_report_page_is_displayed() {
		
		logStep(methodName());
		
		staffpom.getIncidentReportPage().isIncidentReportPageDisplayed();
	}
			/**
			 * Created by Nandhalala.
			 */
			@Then("Login into Xealei application as Social Worker role with valid {string} and {string}.")
			public void login_into_xealei_application_as_social_worker_role_with_valid_and(String swUserName, String swPassWord) {
			   
				logStep(methodName());
				
//			   	sendKeys(swpom.getLoginPage().getUserName(), swUserName);
//			   	sendKeys(swpom.getLoginPage().getPassword(), swPassWord);
			   	
			   	swpom.getLoginPage().validEmail(6);
			   	swpom.getLoginPage().validPassword(6);
				
			   	waitForPageLoad(swDriver);
			   	waitForFullPageElementLoad(swDriver);
				sleep(2000);
			   	swpom.getLoginPage().loginButton();
			}
			    
			/**
			 * Created by Nandhalala.
			 */
			@Then("Close all the browsers.")
			public void Close_all_the_browsers() {
				
				logStep(methodName());
				
				if(Objects.nonNull(chiefnurseDriver)) {
					chiefnurseDriver.quit();
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
	@Then("Select the individual for whom the incident report has to be created.")
	public void select_the_individual_for_whom_the_incident_report_has_to_be_created() {
		
		logStep(methodName());
		
		staffpom.getIncidentReportPage().selectIndividualDetails();
	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Enter all the details of the Incident.")
	public void enter_all_the_details_of_the_incident() {
		
		logStep(methodName());
		
		staffpom.getIncidentReportPage().eventDateAndTime();
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
		staffpom.getIncidentReportPage().selectRelationship();
		staffpom.getIncidentReportPage().selectNotificationMethod();

	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Click on next button.")
	public void click_on_next_button() {
		
		logStep(methodName());
		
		staffpom.getIncidentReportPage().nextButton();
		waitForFullPageElementLoad(staffDriver);
	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Launch a new browser and enter xealei url for cheif nurse.")
	public void launch_a_new_browser_and_enter_xealei_url_for_cheif_nurse() {
		
		logStep(methodName());
		
		try {
			chiefnurseDriver = getNewDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logStep(methodName());
		chiefnurseDriver.get("https://xat.qa.xealei.com/login");
		chiefnursepom = new PageObjectManager(chiefnurseDriver);
		waitForPageLoad(chiefnurseDriver);
		chiefnurseDriver.manage().window().maximize();
	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Login into Xealei application as Chief nurse role with valid {string} and {string}.")
	public void login_into_xealei_application_as_Chief_nurse_role_with_valid_and(String ChiefNurseUserName, String ChiefNursePassWord) {
		
		logStep(methodName());
		
//		sendKeys(chiefnursepom.getLoginPage().getUserName(), ChiefNurseUserName);
//		sendKeys(chiefnursepom.getLoginPage().getPassword(), ChiefNursePassWord);
		
		chiefnursepom.getLoginPage().validEmail(3);
		chiefnursepom.getLoginPage().validPassword(3);
		
		waitForPageLoad(chiefnurseDriver);
		waitForFullPageElementLoad(chiefnurseDriver);
		sleep(2000);
		chiefnursepom.getLoginPage().loginButton();
	}
	
	/**
	 * Created by Nandhalala.
	 */
	@Then("Verify whether notification is received by cheif nurse.")
	public void verify_whether_notification_is_received_by_cheif_nurse() {

		logStep(methodName());
		
		waitForFullPageElementLoad(chiefnurseDriver);
		chiefnursepom.getHomePage().notificationIcon(reportid);
	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Verify whether notification is received by residential manager.")
	public void verify_whether_notification_is_received_by_residential_manager() {
		
		logStep(methodName());
		
		waitForFullPageElementLoad(rmDriver);
		rmpom.getHomePage().notificationIcon(reportid);
	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Verify whether notification is received by Clinical Coordinator.")
	public void verify_whether_notification_is_received_by_Clinical_Coordinator() {
		
		logStep(methodName());
		
		waitForFullPageElementLoad(ccDriver);
		ccpom.getHomePage().notificationIcon(reportid);
	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Verify whether notification is received by Social Worker.")
	public void verify_whether_notification_is_received_by_Social_Worker() {
		
		logStep(methodName());
		
		waitForFullPageElementLoad(swDriver);
		swpom.getHomePage().notificationIcon(reportid);
	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Approve the report by Cheif Nurse user.")
	public void approve_the_report_by_Cheif_Nurse_user() {
		
		logStep(methodName());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		chiefnursepom.getIncidentReportPage().chiefNurseReviewerComments("approved");
		chiefnursepom.getIncidentReportPage().clickCompleteButton();
	}

	


	/**
	 * Created by Nandhalala.
	 */
	@Then("Verify whether the report is in {string} status by Cheif Nurse user.")
	public void verify_whether_the_report_is_in_status_by_Cheif_Nurse_user(String status) {
		
		logStep(methodName());

		String rowNumber = chiefnursepom.getIncidentReportPage().getRowNumber();
		String actualStatus = chiefnursepom.getIncidentReportPage().getStatus(rowNumber);
		assertEquals(actualStatus, status,
				"The actual status is : " + actualStatus + " but the expected is : " + status);
	}


	/**
	 * Created by Nandhalala.
	 */
	@Then("Login into Xealei application as Residential Manager role with valid {string} and {string}.")
	public void login_into_xealei_application_as_residential_manager_role_with_valid_and(String rmUserName,
			String rmPassWord) {
		
		logStep(methodName());
		
//		sendKeys(rmpom.getLoginPage().getUserName(), rmUserName);
//		sendKeys(rmpom.getLoginPage().getPassword(), rmPassWord);
		
		rmpom.getLoginPage().validEmail(4);
		rmpom.getLoginPage().validPassword(4);
		
		waitForPageLoad(rmDriver);
		waitForFullPageElementLoad(rmDriver);
		sleep(2000);
		rmpom.getLoginPage().loginButton();
	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Login into Xealei application as CLinical Coordinator role with valid {string} and {string}.")
	public void login_into_xealei_application_as_c_linical_coordinator_role_with_valid_and(String ccUserName,
			String ccPassWord) {
		
		logStep(methodName());
		
//		sendKeys(ccpom.getLoginPage().getUserName(), ccUserName);
//		sendKeys(ccpom.getLoginPage().getPassword(), ccPassWord);
		
		ccpom.getLoginPage().validEmail(5);
		ccpom.getLoginPage().validPassword(5);
		
		waitForPageLoad(ccDriver);
		waitForFullPageElementLoad(ccDriver);
		sleep(2000);
		ccpom.getLoginPage().loginButton();
	}

	@Then("User should verify the toast message after try to upload JFIF Format {string}")
	public void user_should_verify_the_toast_message_after_try_to_upload_jfif_format(String string) {

		logStep(methodName());
		
		staffpom.getIncidentReportPage().Upload("JFIF Format", ".jfif");

	}

	@Then("User should verify the toast message after try to upload more than 1MB File format {string}")
	public void user_should_verify_the_toast_message_after_try_to_upload_more_than_1mb_file_format(String string) {

		logStep(methodName());
		
		staffpom.getAddIndividualsPage().moreThan1MBImgFormatUpload("MoreThan1MB", "jpg");
	}

	@Then("User should verify the user are able to attach file")
	public void user_should_verify_the_user_are_able_to_attach_file() {

		logStep(methodName());
		
		staffpom.getIncidentReportPage().Upload("JPG", "jpg");
	}

	@Then("User should verify that whether able to select options under Injury Type field")
	public void user_should_verify_that_whether_able_to_select_options_under_injury_type_field() {

		logStep(methodName());
		
		staffpom.getIncidentReportPage().selectInjuryType();
	}
	
	private String alertTime;
	/**
	 * Created by Nandhalala.
	 */
	@When("Notification is Triggered from a sensor.")
	public void Notification_is_Triggered_from_a_sensor() {
		String[] dateTime = getCurrentDtYearMonth("M/dd/yyyy hh:mma").split(" ");
		//String time = dateTime.replaceAll(".*(.{7})", "$1");
		String date = dateTime[0];
		String time = dateTime[1];
		try {
			alertTime = dateConversion(date,time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		File jsonFile = new File("./JSON/fall.json");
		RequestSpecification request = RestAssured.given();
		Response response = request.body(jsonFile).with().contentType(ContentType.JSON)
									.baseUri("https://api.qa.xealei.com/createEventAlertCaretakers")
									.post();
		sleep(5000);
	}
	
	/**
	 * Created by Nandhalala.
	 */
	@When("Notification Triggered from a sensor.")
	public void Notification_Triggered_from_a_sensor() {
		String dateTime = getCurrentDtYearMonth("MMM dd, yyyy, hh:mm");
		alertTime = dateTime;
		
		File jsonFile = new File("./JSON/fall.json");
		RequestSpecification request = RestAssured.given();
		Response response = request.body(jsonFile).with().contentType(ContentType.JSON)
									.baseUri("https://api.qa.xealei.com/createEventAlertCaretakers")
									.post();
		sleep(5000);
	}
	
	/**
	 * Created by Nandhalala.
	 */
	@Then("Open notification received by staff from sensor.")
	public void Open_notification_received_by_staff_from_sensor() {
		String[] temp = alertTime.split(",");
		temp[2] = temp[2].trim();
		if(temp[2].charAt(0) == '0') {
			temp[2]=temp[2].substring(1);
		}
		
		String time = temp[0]+","+temp[1]+","+" "+temp[2];
		
		try {
			staffpom.getHomePage().fallAlertNotification(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sleep(2000);
	}
	
	/**
	 * Created by Nandhalala.
	 */
	@Then("Open IR received by staff from sensor in Grid.")
	public void Open_IR_received_by_staff_from_sensor_in_Grid() {
		String[] temp = alertTime.split(",");
		temp[2] = temp[2].trim();
		if(temp[2].charAt(0) == '0') {
			temp[2]=temp[2].substring(1);
		}
		
		String time = temp[0]+","+temp[1]+","+" "+temp[2];
		try {
			staffpom.getHomePage().fallAlertFromGrid(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Created by Nandhalala.
	 */
	@Then("Select fall radio button and enter description.")
	public void Select_fall_radio_button_and_enter_description() {
		staffpom.getHomePage().alertNotificationFalladioButton();
		staffpom.getHomePage().alertNotificationDescription();
	}
	
	/**
	 * Created by Nandhalala.
	 */
	@Then("Click Save and Proceed to IR button.")
	public void Click_Save_and_Proceed_to_IR_button() {
		staffpom.getHomePage().saveandproccedtoTR();
	}
	
	/**
	 * Created by Nandhalala.
	 */
	@Then("Verify text in what casued the fall matches with Description.")
	public void Verify_text_in_what_casued_the_fall_matches_with_Description() {
		
		String actual = staffpom.getIncidentReportPage().getWhatCausedTheFall();
		String expected = readExcel("Test Datas", "Incident Reports", 1, 29).trim();
		assertEquals(actual, expected, "The actual value is : "+actual+"but the expected value is : "+expected);
		
	}
	
	private String staffName;
	private String chiefNurseName;
	private String managerName;
	private String clinicalCoordinatorName;
	private String socialWorkerName;
	private String staffMessage = "Staff test Message";
	private String chiefNurseMessage = "Chief nurse Message";
	private String managerMessage = "Manager Message";
	
	/**
	 * Created by Nandhalala.
	 */
	@Then("Click view button on staff user.")
	public void Click_view_button_on_staff_user() {
		staffpom.getIncidentReportPage().viewButton(staffpom.getIncidentReportPage().getRowNumber());
		staffName = staffpom.getIncidentReportPage().getUserName();
		staffName=staffName.replaceAll("Staff", "").trim();
	}
	
	/**
	 * Created by Nandhalala.
	 */
	@Then("Send chat message for staff user.")
	public void Send_chat_message_for_staff_user() {
		staffpom.getIncidentReportPage().sendChatMessage(staffMessage);
	}
	
	@Then("Open IR received by Chief nurse.")
	public void Open_IR_received_by_Chief_nurse() {
		
		sleep(5000);
		chiefnursepom.getHomePage().navToReportsModule();
		chiefnursepom.getHomePage().navToIncidentReportModule();
		sleep(7000);
		System.out.println(chiefnursepom.getIncidentReportPage().getRowNumber());
	}
	
	@Then("Click View button for chief nurse user.")
	public void Click_View_button_for_chief_nurse_user() {
		String rownumber = chiefnursepom.getIncidentReportPage().getRowNumber();
		chiefnursepom.getIncidentReportPage().viewButton(rownumber);
		chiefNurseName = chiefnursepom.getIncidentReportPage().getUserName();
		chiefNurseName = chiefNurseName.replaceAll("Chief Nurse", "").trim();
		System.out.println(chiefNurseName);
	}
	
	@Then("Verify staff message is received by cheif nurse.")
	public void Verify_staff_message_is_received_by_cheif_nurse() {
		boolean flag = false;
		Map<String, String> messages = chiefnursepom.getIncidentReportPage().getChatMessagesFromUser(staffName);
		for(Map.Entry<String, String> entry : messages.entrySet()) {
			System.out.println(entry.getKey() + "/" + entry.getValue());
			if(entry.getValue().equals(staffMessage)) {
				flag = true;
			}
		}
		assertEquals(flag, true,"The expected message from staff is : "+staffMessage);
	}
	
}
