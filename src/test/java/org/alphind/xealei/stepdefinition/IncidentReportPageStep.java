package org.alphind.xealei.stepdefinition;

import static org.testng.Assert.assertEquals;

import java.text.ParseException;

import org.alphind.xealei.baseclass.BaseClass;
import org.alphind.xealei.pom.PageObjectManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

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
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Individual’s Details field",
					expIndDetailsInfoMsg,
					getText(staffpom.getIncidentReportPage().getIndividualsDetailsValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Individual’s Details field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Event Date & Time field",
					expEventDateAndTimeInfoMsg,
					getText(staffpom.getIncidentReportPage().getEventDateAndTimeValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Event Date & Time field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		staffpom.getIncidentReportPage().selectIndividualDetailsDropdown();

		staffpom.getIncidentReportPage().eventDateAndTime();

		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under What caused the fall? field",
					expWhatCausedAFall, getText(staffpom.getIncidentReportPage().getFallCausedValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under What caused the fall? field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();

		}

		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Was injured? field",
					expWasInjuredInfoMsg,
					getText(staffpom.getIncidentReportPage().getChooseWasIndInjuredRadioButtonValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Was injured? field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		staffpom.getIncidentReportPage().wasPatientInjuredRadioButton();

		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Injury Description field",
					expInjuryDescriptionInfoMsg,
					getText(staffpom.getIncidentReportPage().getInjuryDescriptionValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Injury Description field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {
			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Injury Site field",
					expInjurySiteInfoMsg, getText(staffpom.getIncidentReportPage().getInjurySiteValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Injury Site field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {

			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Treatment Received field",
					expTreatmentReceivedInfoMsg,
					getText(staffpom.getIncidentReportPage().getTreatmentReceivedValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Treatment Received field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {

			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Future Treatment field",
					expFutureTreatmentInfoMsg,
					getText(staffpom.getIncidentReportPage().getFutureTreatmentValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Future Treatment field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {

			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Injury Type field",
					expInjuryTypeInfoMsg, getText(staffpom.getIncidentReportPage().getInjuryTypeValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Injury Type field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {

			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Injury Color field",
					expInjuryColorInfoMsg, getText(staffpom.getIncidentReportPage().getInjuryColorValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Injury Color field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {

			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Injury Serve field",
					expInjurySevereInfoMsg,
					getText(staffpom.getIncidentReportPage().getInjurySeverityValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Injury Serve field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {

			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Person Notified field",
					expPersonNotifiedInfoMsg,
					getText(staffpom.getIncidentReportPage().getPersonNotifiedValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Person Notified field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {

			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Relationship field",
					expRelationshipInfoMsg,
					getText(staffpom.getIncidentReportPage().getRelationshipValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Relationship field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {

			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Notification Date field",
					expNotificationDateInfoMsg,
					getText(staffpom.getIncidentReportPage().getChooseNotifiationDateValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Notification Date field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {

			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Notification Time field",
					expNotificationTimeInfoMsg,
					getText(staffpom.getIncidentReportPage().getChooseNotifiationTimeValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Notification Time field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		try {

			Assert.assertEquals("MF validation info msg is NOT displayed as expected under Notified By field",
					expNotifiedByInfoMsg, getText(staffpom.getIncidentReportPage().getNotifiedValidationInfoMsg()));
			log(Status.PASS, "MF validation info msg is displayed as expected under Notified By field");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("User should verify Save button is working in IR Page after perform Individuals Details and Event Date & Time fields")
	public void user_should_verify_save_button_is_working_in_ir_page_after_perform_individuals_details_and_event_date_time_fields() {

		staffpom.getIncidentReportPage().enterInjuryDescriptionData();

		staffpom.getIncidentReportPage().saveButton();

	}

	@Then("User should verify the toast message after click Save button in IR Page {string}")
	public void user_should_verify_the_toast_message_after_click_save_button_in_ir_page(String expSuccessfullToastMsg) {

		try {
			Assert.assertEquals("Saved Successfull Toast Message is not displayed", expSuccessfullToastMsg,
					getText(staffpom.getIncidentReportPage().getSavedSuccessfullToastMsg()));
			log(Status.PASS, "Toast Message is displayed : "
					+ getText(staffpom.getIncidentReportPage().getSavedSuccessfullToastMsg()));

			staffpom.getIncidentReportPage().savedSuccessfulToastMsgokButton();

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("User should verify the respective individual report status {string}")
	public void user_should_verify_the_respective_individual_report_status(String expDraftStatus) {

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

		deleteExistFieldData(staffpom.getIncidentReportPage().getEventDateAndTimeCalenderIconButton());

		staffpom.getIncidentReportPage().eventDateAndFutureTime();
	}

	@Then("User should validation info message is thrown under Event time for selecting  greater than current time of current date {string}")
	public void user_should_validation_info_message_is_thrown_under_event_time_for_selecting_greater_than_current_time_of_current_date(
			String expGreaterThanCurrentTime) {

		try {
			Assert.assertEquals(
					"validation info message is NOT thrown under Event time for selecting  greater than current time of current date as expected",
					expGreaterThanCurrentTime, getText(staffpom.getIncidentReportPage()
							.getExceedCurrentTimeIneventDateAndTimeValidationInfoMsg()));
			log(Status.PASS,
					"Validation info message is displayed after enter greater than current time of current date as expected Exp info Msg - "
							+ getText(staffpom.getIncidentReportPage()
									.getExceedCurrentTimeIneventDateAndTimeValidationInfoMsg()));

		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should verify that able to spot the injury on Injury site front & Back view")
	public void user_should_verify_that_able_to_spot_the_injury_on_injury_site_front_back_view() {

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

	@Then("User should verify the validation info message is thrown after selecting Notification Time field value is lesser than Event Date & Time field value {string}")
	public void user_should_verify_the_validation_info_message_is_thrown_after_selecting_notification_time_field_value_is_lesser_than_event_date_time_field_value(
			String expLesserThanNoticationTimeToastMsg) {

		staffpom.getIncidentReportPage().pastTimeInNotificationTime();

		try {
			Assert.assertEquals(
					"Lesser than event time info msg is NOT displayed as expected under Notification Time field",
					expLesserThanNoticationTimeToastMsg,
					getText(staffpom.getIncidentReportPage().getLesserThanToastMsgForNotificationTime()));
			log(Status.PASS,
					"Lesser than current time info msg is displayed as expected under Notification Time field Exp info msg - "
							+ expLesserThanNoticationTimeToastMsg + " Actual info msg - "
							+ getText(staffpom.getIncidentReportPage().getLesserThanToastMsgForNotificationTime()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should verify the validation info message is thrown after selecting greater than current time in Notification Time field {string}")
	public void user_should_verify_the_validation_info_message_is_thrown_after_selecting_greater_than_current_time_in_notification_time_field(
			String expGreaterThanNoticationTimeToastMsg) {

		staffpom.getIncidentReportPage().futureTimeInNotificationTime();

		try {
			Assert.assertEquals(
					"Greater than event time info msg is NOT displayed as expected under Notification Time field",
					expGreaterThanNoticationTimeToastMsg,
					getText(staffpom.getIncidentReportPage().getLesserThanToastMsgForNotificationTime()));
			log(Status.PASS,
					"Lesser than current time info msg is displayed as expected under Notification Time field Exp info msg - "
							+ expGreaterThanNoticationTimeToastMsg + " Actual info msg - "
							+ getText(staffpom.getIncidentReportPage().getLesserThanToastMsgForNotificationTime()));
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should verify that able to enter time in Notification Time field")
	public void user_should_verify_that_able_to_enter_time_in_notification_time_field() {

		staffpom.getIncidentReportPage().enterNotificationTime();
	}

	@Then("User should verify that after click the breadcrum text Report the page is navigated to the list of incident Reports page")
	public void user_should_verify_that_after_click_the_breadcrum_text_report_the_page_is_navigated_to_the_list_of_incident_reports_page() {

		staffpom.getIncidentReportPage().breadCrumREPORTTxtLink();
		waitForPageLoad();

		if (staffpom.getIncidentReportPage().getAddNewIncidentReportButton().isDisplayed()) {
			log(Status.PASS, "The page is navigated to the list of incident Reports page");
		} else {
			log(Status.FAIL, "Unable to Navigated to the list of incident Reports page");
		}
	}

	@Then("User should verify the edit button is working in IR Grid")
	public void user_should_verify_the_edit_button_is_working_in_ir_grid() {

		staffpom.getIncidentReportPage().editButton(staffpom.getIncidentReportPage().getRowNumber());

		if (staffpom.getIncidentReportPage().getSaveButton().isDisplayed()) {
			log(Status.PASS, "Edit button is working in IR Grid");
		} else {
			log(Status.FAIL, "Edit button is NOT working in IR Grid");
		}
	}

	@Then("User should verify that the IR form continues to display the previously entered draft datas")
	public void user_should_verify_that_the_ir_form_continues_to_display_the_previously_entered_draft_datas() {

		try {
			Assert.assertEquals("IR form is NOT displayed the previously entered draft datas",
					readExcel("Test Datas", "Incident Reports", 1, 18),
					getAttribute(staffpom.getIncidentReportPage().getInjuryDescriptionTxtBox(), "value"));
			log(Status.PASS, "IR form continues to display the previously entered draft datas");
		} catch (AssertionError e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@Then("User should verify the breadcrum text")
	public void user_should_verify_the_breadcrum_text() {

		if (getText(staffpom.getIncidentReportPage().getBreadCrumTxtLinkReports()).equals("Reports")
				&& getText(staffpom.getIncidentReportPage().getBreadCrumTxtLinkIncidentReport())
						.equals("Incident Report")) {
			log(Status.PASS,
					"Bread crum text is displayed as expected Exp BC Txt - Reports > Incident Report | Actual BC Txt - "
							+ getText(staffpom.getIncidentReportPage().getBreadCrumTxtLinkReports()) + ">"
							+ getText(staffpom.getIncidentReportPage().getBreadCrumTxtLinkIncidentReport()));

		} else {
			log(Status.FAIL,
					"Bread crum text is NOT displayed as expected Exp BC Txt - Reports > Incident Report | Actual BC Txt - "
							+ getText(staffpom.getIncidentReportPage().getBreadCrumTxtLinkReports()) + ">"
							+ getText(staffpom.getIncidentReportPage().getBreadCrumTxtLinkIncidentReport()));
		}
	}

	@Then("User should perform all the fields")
	public void user_should_perform_all_the_fields() {

		staffpom.getIncidentReportPage().eventDateAndTime();
		staffpom.getIncidentReportPage().enterWhatCausedTheFallData();
		staffpom.getIncidentReportPage().selectWasTheIndividiualInjured();
		staffpom.getIncidentReportPage().selectFrontViewInjurySite();
		staffpom.getIncidentReportPage().selectBackViewInjurySite();
		staffpom.getIncidentReportPage().enterTreatmentReceivedData();
		deleteExistFieldData(staffpom.getIncidentReportPage().getInjuryDescriptionTxtBox());
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
		// staffpom.getIncidentReportPage().selectNotificationMethod();

		staffpom.getIncidentReportPage().nextButton();
	}

	@Then("User should verify all the created details are displayed as expected")
	public void user_should_verify_all_the_created_details_are_displayed_as_expected() throws ParseException {

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
		System.out.println("Injury Color DATA - " + staffpom.getIncidentReportPage().getInjuryColorValue());
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
			String getColorAttribute = getAttribute(staffpom.getIncidentReportPage().getInjuryColorValue(), "style");
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

//			try {
//				String NotificationMethodExpDataFromExcel = readExcel("Test Datas", "Incident Reports", 1, 17);
//				Assert.assertEquals("Notification Method field :Entered data is NOT accurately displayed as expected", NotificationMethodExpDataFromExcel, staffpom.getIncidentReportPage().getNotificationMethodValue());
//				log(Status.PASS, "Notification Method field :Entered data is accurately displayed as expected | Exp Data - "+NotificationMethodExpDataFromExcel+" | Actual Data - "+staffpom.getIncidentReportPage().getNotificationMethodValue());
//			} catch (AssertionError e) {
//				log(Status.FAIL, e.getMessage());
//				e.printStackTrace();
//			}

	}

	@Then("User should verify the breadcrums texts")
	public void user_should_verify_the_breadcrums_texts() {

		String createdIndNameFromExcel = readExcel("Test Datas", "Incident Reports", 1, 28);
		String[] splitFirstNameAlone = createdIndNameFromExcel.split(" ");
		String getFirstName = splitFirstNameAlone[0];

		if (getText(staffpom.getIncidentReportPage().getBreadCrumTxtLinkReports()).equals("Reports")
				&& staffpom.getIncidentReportPage().breadCrumSuiteNameText().equals(getFirstName)
				&& staffpom.getIncidentReportPage().getBreadCrumTxtLinkIncidentReportInViewPage()
						.equals("Incident Report")) {
			log(Status.PASS,
					"Bread crum text is displayed as expected Exp BC Txt - Reports > " + getFirstName
							+ " > Incident Report | Actual BC Txt - "
							+ getText(staffpom.getIncidentReportPage().getBreadCrumTxtLinkReports()) + " > "
							+ staffpom.getIncidentReportPage().breadCrumSuiteNameText() + " > "
							+ staffpom.getIncidentReportPage().getBreadCrumTxtLinkIncidentReportInViewPage());

		} else {
			log(Status.FAIL,
					"Bread crum text is NOT displayed as expected Exp BC Txt - Reports > Incident Report | Actual BC Txt - "
							+ getText(staffpom.getIncidentReportPage().getBreadCrumTxtLinkReports()) + " > "
							+ staffpom.getIncidentReportPage().breadCrumSuiteNameText() + " > "
							+ staffpom.getIncidentReportPage().getBreadCrumTxtLinkIncidentReportInViewPage());
		}

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
		// staffpom.getIncidentReportPage().selectNotificationMethod();

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
	@When("Verify whether the report is in pending status.")
	public void verify_whether_the_report_is_in_pending_status() {
		String rowNumber = staffpom.getIncidentReportPage().getRowNumber();
		String status = staffpom.getIncidentReportPage().getStatus(rowNumber);
		assertEquals(status, "Pending", "The expected value is : Pending /nbut actual is : " + status);
		reportid = staffpom.getIncidentReportPage().getReportID(rowNumber);
	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Launch a new browser and enter xealei url for cheif nurse.")
	public void launch_a_new_browser_and_enter_xealei_url_for_cheif_nurse() {
		try {
			cheifnurseDriver = getNewDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logStep(methodName());
		cheifnurseDriver.get("https://xat.qa.xealei.com/login");
		cheifnursepom = new PageObjectManager(cheifnurseDriver);
		waitForPageLoad(cheifnurseDriver);
		cheifnurseDriver.manage().window().maximize();
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
	@Then("Login into Xealei application as Cheif nurse role with valid {string} and {string}.")
	public void login_into_xealei_application_as_cheif_nurse_role_with_valid_and(String cheifNurseUserName,
			String cheifNursePassWord) {

		logStep(methodName());
		sendKeys(cheifnursepom.getLoginPage().getUserName(), cheifNurseUserName);
		sendKeys(cheifnursepom.getLoginPage().getPassword(), cheifNursePassWord);
		waitForPageLoad(cheifnurseDriver);
		waitForFullPageElementLoad(cheifnurseDriver);
		cheifnursepom.getLoginPage().loginButton();
		waitForPageLoad(cheifnurseDriver);
	}

	@Then("Verify Incident report page is displayed.")
	public void verify_incident_report_page_is_displayed() {

		throw new io.cucumber.java.PendingException();
	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Verify whether notification is received by cheif nurse.")
	public void verify_whether_notification_is_received_by_cheif_nurse() {

		waitForFullPageElementLoad(cheifnurseDriver);
		cheifnursepom.getHomePage().notificationIcon(reportid);
	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Verify whether notification is received by residential manager.")
	public void verify_whether_notification_is_received_by_residential_manager() {
		waitForFullPageElementLoad(rmDriver);
		rmpom.getHomePage().notificationIcon(reportid);
	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Verify whether notification is received by Clinical Coordinator.")
	public void verify_whether_notification_is_received_by_Clinical_Coordinator() {
		waitForFullPageElementLoad(ccDriver);
		ccpom.getHomePage().notificationIcon(reportid);
	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Verify whether notification is received by Social Worker.")
	public void verify_whether_notification_is_received_by_Social_Worker() {
		waitForFullPageElementLoad(swDriver);
		swpom.getHomePage().notificationIcon(reportid);
	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Approve the report by Cheif Nurse user.")
	public void approve_the_report_by_Cheif_Nurse_user() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cheifnursepom.getIncidentReportPage().chiefNurseReviewerComments("approved");
		cheifnursepom.getIncidentReportPage().clickCompleteButton();
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
	@Then("Verify whether the report is in {string} status by Cheif Nurse user.")
	public void verify_whether_the_report_is_in_status_by_Cheif_Nurse_user(String status) {

		String rowNumber = cheifnursepom.getIncidentReportPage().getRowNumber();
		String actualStatus = cheifnursepom.getIncidentReportPage().getStatus(rowNumber);
		assertEquals(actualStatus, status,
				"The actual status is : " + actualStatus + " but the expected is : " + status);
	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Verify whether the report is in {string} status by Residential Manager user.")
	public void verify_whether_the_report_is_in_status_by_Residential_Manager_user(String status) {
		String rowNumber = cheifnursepom.getIncidentReportPage().getRowNumber();
		String actualStatus = cheifnursepom.getIncidentReportPage().getStatus(rowNumber);
		assertEquals(actualStatus, status,
				"The actual status is : " + actualStatus + " but the expected is : " + status);
	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Verify whether the report is in {string} status by Clinical Coordinator user.")
	public void verify_whether_the_report_is_in_status_by_Clinical_Coordinator_user(String status) {
		String rowNumber = cheifnursepom.getIncidentReportPage().getRowNumber();
		String actualStatus = cheifnursepom.getIncidentReportPage().getStatus(rowNumber);
		assertEquals(actualStatus, status,
				"The actual status is : " + actualStatus + " but the expected is : " + status);
	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Verify whether the report is in {string} status by Social Worker user.")
	public void verify_whether_the_report_is_in_status_by_Social_Worker_user(String status) {
		String rowNumber = swpom.getIncidentReportPage().getRowNumber();
		String actualStatus = swpom.getIncidentReportPage().getStatus(rowNumber);
		assertEquals(actualStatus, status,
				"The actual status is : " + actualStatus + " but the expected is : " + status);
	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Login into Xealei application as Residential Manager role with valid {string} and {string}.")
	public void login_into_xealei_application_as_residential_manager_role_with_valid_and(String rmUserName,
			String rmPassWord) {
		sendKeys(rmpom.getLoginPage().getUserName(), rmUserName);
		sendKeys(rmpom.getLoginPage().getPassword(), rmPassWord);
		waitForPageLoad(rmDriver);
		// waitForFullPageElementLoad(rmDriver);
		rmpom.getLoginPage().loginButton();
	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Login into Xealei application as CLinical Coordinator role with valid {string} and {string}.")
	public void login_into_xealei_application_as_c_linical_coordinator_role_with_valid_and(String ccUserName,
			String ccPassWord) {
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
	public void login_into_xealei_application_as_social_worker_role_with_valid_and(String swUserName,
			String swPassWord) {
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
	@Then("Deny the report.")
	public void deny_the_report() {

		throw new io.cucumber.java.PendingException();
	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Switch to Staff login and check whether sent back comments are available.")
	public void switch_to_staff_login_and_check_whether_sent_back_comments_are_available() {

		throw new io.cucumber.java.PendingException();
	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Again submit the report.")
	public void again_submit_the_report() {

		throw new io.cucumber.java.PendingException();
	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Switch to cheif nurse login and approve the incident report.")
	public void switch_to_cheif_nurse_login_and_approve_the_incident_report() {

		throw new io.cucumber.java.PendingException();
	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Switch to cheif nurse login and check whether sent back comments are available.")
	public void switch_to_cheif_nurse_login_and_check_whether_sent_back_comments_are_available() {

		throw new io.cucumber.java.PendingException();
	}

	/**
	 * Created by Nandhalala.
	 */
	@Then("Switch to Residential Manager login and approve the incident report.")
	public void switch_to_residential_manager_login_and_approve_the_incident_report() {

		throw new io.cucumber.java.PendingException();
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

	@Then("User should verify that whether able to select options under Injury Type field")
	public void user_should_verify_that_whether_able_to_select_options_under_injury_type_field() {

		staffpom.getIncidentReportPage().selectInjuryType();
	}
}
