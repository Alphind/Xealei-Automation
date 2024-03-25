/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Nandhalala

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization   * is prohibited without prior and proper license agreement

*/package org.alphind.xealei.stepdefinition;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.
 * You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization
 * is prohibited without prior and proper license agreement
 *
 * created by Nandhalala
 *
*/

import org.alphind.xealei.baseclass.BaseClass;
import org.alphind.xealei.pom.PageObjectManager;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.AssertionFailedError;

public class UserManagementStep extends BaseClass {
	
	PageObjectManager pom = new PageObjectManager(getDriver());
	private WebDriver mailinatordriver ; 
	private PageObjectManager mailinatorpom;
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 12-FEB-2024.
	 * 
	 */
	@When("User is login as facility admin.")
	public void User_is_login_as_facility_admin() {
		
		logWithLabelName(getMethodName());

		pom.getLoginPage().validEmail(1);
		pom.getLoginPage().validPassword(1);
		
		waitForFullPageElementLoad();
		sleep(2000);
		pom.getLoginPage().loginButton();
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 12-FEB-2024.
	 * 
	 */
	@Then("Verify User Management module is available.")
	public void Verify_User_Management_module_is_available() {
		
		logWithLabelName(getMethodName());
		
		if(pom.getHomePage().isUserManagementPresent()){
			log(Status.PASS, "User Management module is present on Home Screen.");
		}
		else {
			log(Status.FAIL, "User Management Module is not present on home screen");
		}
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 12-FEB-2024.
	 * 
	 */
	@Then("Navigate to User Management Page.")
	public void Navigate_to_User_Management_Page() {
		
		logWithLabelName(getMethodName());
		
		pom.getHomePage().navigateToUserManagementModule();
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 12-FEB-2024.
	 * 
	 */
	@Then("Click on Create New user button.")
	public void Click_on_Create_New_user_button() {
		
		logWithLabelName(getMethodName());
		
		pom.getUserManagementPage().isUserManagementPageDisplayed();
		pom.getUserManagementPage().clickCreateNewUserButton();
		pom.getUserManagementPage().isCreateNewUserPopupDisplayed();
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 13-FEB-2024.
	 * 
	 */
	@Then("Click Next and verify Validations for FirstName, LastName and Role field.")
	public void Click_Next_and_verify_Validations_for_FirstName_LastName_and_Role_field() {
		
		logWithLabelName(getMethodName());
		
		pom.getUserManagementPage().clickNewUserNextButton();
		String firstNameErrorText = pom.getUserManagementPage().getFirstNameErrorText();
		try {
			Assert.assertEquals("The error text is : "+firstNameErrorText+" but the expected text is"
					+ "\"Please enter first name\"",
					firstNameErrorText,"Please enter first name");
			log(Status.PASS, "The error text for firstname field is "+firstNameErrorText);
		}catch (AssertionFailedError e) {
			log(Status.FAIL, "The error text for firstname field is "+firstNameErrorText);
		}
		String lastNameErrorText = pom.getUserManagementPage().getLastNameErrorText();
		try {
			Assert.assertEquals("The error text is : "+lastNameErrorText+" but the expected text is"
					+ "\"Please enter last name\"",
					lastNameErrorText,"Please enter last name");
			log(Status.PASS, "The error text for lastname field is "+lastNameErrorText);
		}catch (AssertionFailedError e) {
			log(Status.FAIL, "The error text for lastname field is "+lastNameErrorText);
		}
		String roleErrorText = pom.getUserManagementPage().getRoleErrorText();
		try {
			Assert.assertEquals("The error text is : "+roleErrorText+" but the expected text is"
					+ "\"Please select role\"",
					roleErrorText,"Please select role");
			log(Status.PASS, "The error text for role field is "+lastNameErrorText);
			
			pom.getUserManagementPage().clickTostrOkButton();
			
		}catch (AssertionFailedError e) {
			log(Status.FAIL, "The error text for role field is "+lastNameErrorText);
		}
		
		
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 27-FEB-2024
	 * 
	 */
	@Then("Verify limit of the firstname, middlename and lastname field.")
	public void Verify_limit_of_the_firstname_middlename_lastname_and_phone_number_field() {

		logWithLabelName(getMethodName());
		
		try {
			pom.getUserManagementPage().enterOverLimitFirstName();
			pom.getUserManagementPage().enterOverLimitLastName();
			pom.getUserManagementPage().enterOverLimitMiddleName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String firstNameErrorText = pom.getUserManagementPage().getFirstNameErrorText();
		try {
			Assert.assertEquals("\"The error text is : "+firstNameErrorText+" but the expected "
					+ "text is\"First name must be 30 characters\"", "First name must be "
							+ "30 characters", firstNameErrorText);
			log(Status.PASS, "The error text for firstname field is "+firstNameErrorText);
		}catch(Exception e) {
			log(Status.FAIL, "The error text for firstname field is "+firstNameErrorText);
		}
		
		String lastNameErrorText = pom.getUserManagementPage().getLastNameErrorText();
		try {
			Assert.assertEquals("\"The error text is : "+lastNameErrorText+" but the expected "
					+ "text is\"Last name must be 30 characters\"", "Last name must be "
							+ "30 characters", lastNameErrorText);
			log(Status.PASS, "The error text for firstname field is "+lastNameErrorText);
		}catch(Exception e) {
			log(Status.FAIL, "The error text for firstname field is "+lastNameErrorText);
		}
		
		String middleNameErrorText = pom.getUserManagementPage().getMiddleNameErrorText();
		try {
			Assert.assertEquals("\"The error text is : "+middleNameErrorText+" but the expected "
					+ "text is\"Middle name must be 30 characters\"", "Middle name must be "
							+ "30 characters", middleNameErrorText);
			log(Status.PASS, "The error text for firstname field is "+middleNameErrorText);
		}catch(Exception e) {
			log(Status.FAIL, "The error text for firstname field is "+middleNameErrorText);
		}
		
		try {
			pom.getUserManagementPage().enterValidPhoneNumber();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 13-MAR-2024.
	 * 
	 */
	@Then("Verify user is unable to upload image of size higher than 1MB.")
	public void Verify_user_is_unable_to_upload_image_of_size_higher_than_1MB(){

		logWithLabelName(getMethodName());
		
		pom.getUserManagementPage().uploadImageMoreThan1MB();
		String tostrText = pom.getUserManagementPage().getTostrText().trim();
		pom.getUserManagementPage().clickTostrOkButton();
		try {
			Assert.assertEquals("The expected tostr message is 'File size should be less than 1 MB'"
					+ " but found : "+tostrText, "File size should be less than 1 MB", tostrText);
		log(Status.PASS,"Validation for image upload with more than 1MB is : \n"+tostrText);
		}catch(AssertionFailedError e) {
			log(Status.FAIL,"Validation for image upload with more than 1MB is : \n"+tostrText);
		}
		
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 13-MAR-2024.
	 * 
	 */
	@Then("Verify user is unable to upload unsupported formats.")
	public void Verify_user_is_unable_to_upload_unsupported_formats() {

		logWithLabelName(getMethodName());
		
		pom.getUserManagementPage().uploadUnsupportedFormatImage();
		String tostrText = pom.getUserManagementPage().getTostrText().trim();
		pom.getUserManagementPage().clickTostrOkButton();
		try {
			Assert.assertEquals("The expected tostr message is 'Only jpg,jpeg,png type format is supported'"
					+ " but found : "+tostrText, "Only jpg,jpeg,png type format is supported", tostrText);
		log(Status.PASS,"Validation for unsupported format image upload is : \n"+tostrText);
		}catch(AssertionFailedError e) {
			log(Status.FAIL,"Validation for unsupported format image upload is : \n"+tostrText);
		}
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 13-MAR-2024.
	 * 
	 */
	@Then("Verify user able to upload supported format.")
	public void Verify_user_able_to_upload_supported_format() {

		logWithLabelName(getMethodName());
		
		pom.getUserManagementPage().uploadSupportedFormatImage();
		if(pom.getUserManagementPage().isProfilePictureDisplayed()) {
			log(Status.PASS, "Profile picture is uploaded.");
		}else {
			log(Status.FAIL,"Profile picture is not uploaded.");
		}
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 13-FEB-2024.
	 * 
	 */
	@Then("Validate phone number and Email field with invalid data and click next.")
	public void Validate_phone_number_and_Email_field_with_invalid_data_and_click_next() {

		logWithLabelName(getMethodName());
		
		try {
			pom.getUserManagementPage().enterInvalidEmailID();
			pom.getUserManagementPage().enterInvalidPhoneNumber();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String mailError = pom.getUserManagementPage().getEmailIDErrorText();
		try {
			Assert.assertEquals("The error text is : "+mailError+"but the expected text is"
					+ "\"Please select role\"","Please enter valid email ID",mailError);
			log(Status.PASS, "The error text for Email ID field is "+mailError);
		}catch (AssertionFailedError e) {
			log(Status.FAIL, "The error text for Email ID field is "+mailError);
		}
		
		
		String phoneNumberError = pom.getUserManagementPage().getPhoneNumberErrorText();
		try {
			Assert.assertEquals("The error text is : "+phoneNumberError+"but the expected text is"
					+ "\"Please select role\"","Please enter valid phone number",phoneNumberError);
			log(Status.PASS, "The error text for Phone Number field is "+phoneNumberError);
		}catch (AssertionFailedError e) {
			log(Status.FAIL, "The error text for Phone Number field is "+phoneNumberError);
		}
		
		pom.getUserManagementPage().clickNewUserNextButton();
		
		String tostrText = pom.getUserManagementPage().getTostrText();
		try {
			Assert.assertTrue("The text from tostr message is : "+tostrText+" but was expected "
					+ "/'Please enter valid data/'",
					tostrText.equalsIgnoreCase("Please enter valid data"));
			log(Status.PASS, "The Tostr message displayed is "+tostrText);
		}catch (AssertionFailedError e) {
			log(Status.FAIL, "The Tostr message displayed is "+tostrText);
		}
		
		pom.getUserManagementPage().clickTostrOkButton();
		
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 13-FEB-2024.
	 * 
	 */
	@Then("Enter valid data in all the fields of basic details.")
	public void Enter_valid_data_in_all_the_fields_of_basic_details() {

		logWithLabelName(getMethodName());
		
		pom.getUserManagementPage().enterValidFirstName();
		pom.getUserManagementPage().enterValidMiddleName();
		pom.getUserManagementPage().enterValidLastName();
		pom.getUserManagementPage().selectRole();
		try {
			pom.getUserManagementPage().enterValidEmailID();
			pom.getUserManagementPage().enterValidPhoneNumber();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String phoneNumer = pom.getUserManagementPage().getPhoneNumberText();
		
		Pattern pattern = Pattern.compile("^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$");
		if(pattern.matcher(phoneNumer).matches()){
			log(Status.PASS, "The phone number is in format '(###) ###-####'");
		}else {
			log(Status.FAIL, "The phone number is not in format '(###) ###-####'");
		}
		
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 28-FEB-2024.
	 * 
	 */
	@Then("Click Basic details page next button.")
	public void Click_Basic_details_page_next_button() {

		logWithLabelName(getMethodName());
		
		pom.getUserManagementPage().clickNewUserNextButton();
		sleep(5000);
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 15-FEB-2024.
	 * 
	 */
	@Then("Check validation for phone number for emergency contact 1 and emergency contact 2.")
	public void Check_validation_for_phone_number_for_emergency_contact_1_and_emergency_contact_2() {

		logWithLabelName(getMethodName());
		
		try {
			pom.getUserManagementPage().enterInvalidPhoneNumberEmergencyContact1();
			pom.getUserManagementPage().clickAddEmergencyContactButton();
			pom.getUserManagementPage().enterInvalidPhoneNumberEmergencyContact2();
			pom.getUserManagementPage().clickEmergencyContactText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String phoneNumberError = pom.getUserManagementPage()
				.getPhoneNumberErrorTextEmergenyContact1();
		try {
			Assert.assertEquals("The error text is : "+phoneNumberError+"but the expected text is"
					+ "\"Please select role\"","Please enter valid phone number",phoneNumberError);
			log(Status.PASS, "The error text from phone number is "+phoneNumberError);
		}catch (AssertionFailedError e) {
			log(Status.FAIL, "The error text from phone number is "+phoneNumberError);
		}
		
		String phoneNumberError2 = pom.getUserManagementPage()
				.getPhoneNumberErrorTextEmergenyContact2();
		try {
			Assert.assertEquals("The error text is : "+phoneNumberError2+"but the expected text is"
					+ "\"Please select role\"","Please enter valid phone number",phoneNumberError2);
			log(Status.PASS, "The error text from phone number is "+phoneNumberError2);
		}catch (AssertionFailedError e) {
			log(Status.FAIL, "The error text from phone number is "+phoneNumberError2);
		}
		
		
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 20-FEB-2024.
	 * 
	 */
	@Then("Click Next button and validate tostr message.")
	public void Click_Next_button() {

		logWithLabelName(getMethodName());
		
		pom.getUserManagementPage().clickNewUserNextButtonContactDetailsPage();
		
		String tostrText = pom.getUserManagementPage().getTostrText();
		try {
			Assert.assertTrue("The text from tostr message is : "+tostrText+" but was expected "
					+ "/'Please enter valid data/'",
					tostrText.equalsIgnoreCase("Please enter valid data"));
			log(Status.PASS,"The Tostr message is "+tostrText);
		}catch (AssertionFailedError e) {
			log(Status.FAIL,"The Tostr message is "+tostrText);
		}
		
		
		pom.getUserManagementPage().clickTostrOkButton();
		
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 21-FEB-2024.
	 * 
	 */
	@Then("Enter valid mandatory data in all fields of basic details.")
	public void Enter_valid_data_in_all_fields_of_basic_details() {

		logWithLabelName(getMethodName());
		
		pom.getUserManagementPage().enterValidFirstName();
		pom.getUserManagementPage().enterValidMiddleName();
		pom.getUserManagementPage().enterValidLastName();
		pom.getUserManagementPage().selectRole();
	}
	
	@Then("Click basic details create button.")
	public void Click_basic_details_create_button() {

		logWithLabelName(getMethodName());
		
		pom.getUserManagementPage().clickNewUserCreateAndSendInviteButton();
		sleep(1000);
		try {
			String tostrText = pom.getUserManagementPage().getTostrText();
			
			Assert.assertTrue("The tostr text is : "+tostrText+" but the expected text is \"Created "
					+ "User Successfully\"",tostrText.equals("Created User Successfully"));
			pom.getUserManagementPage().clickTostrOkButton();
			sleep(3000);
		}catch (NoSuchElementException e) {
			pom.getUserManagementPage().userCreatedSuccessfullyOK();
		}
		
		
	}
	
	@Then("Click basic details Create button.")
	public void Click_basic_details_Create_button() {

		logWithLabelName(getMethodName());
		
		pom.getUserManagementPage().clickNewUserCreateAndSendInviteButton();
		sleep(1000);
		pom.getUserManagementPage().userCreatedSuccessfullyOK();
	}
	
	
	/**
	 * Created by Nandhalala
	 * 
	 * Created on 21-FEB-2024.
	 * 
	 */
	@Then("Verify the status of the created user is in pending status.")
	public void Verify_the_status_of_the_created_user_is_in_pending_status() {

		logWithLabelName(getMethodName());
		
		String rowNumber = pom.getUserManagementPage().getRowNumber();
		System.out.println(rowNumber);
		String status = null;
		try {
			status = pom.getUserManagementPage().getStatus(rowNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Assert.assertEquals("The expected status is 'Pending' but found : "+status
					,"Pending",status);
			log(Status.PASS,"The status of created user is "+status);
		}catch (AssertionFailedError e) {
			log(Status.FAIL,"The status of created user is "+status);
		}
		
	}
	
	/**
	 * Created by Nandhalala
	 * 
	 * Created on 05-MAR-2024.
	 * 
	 */
	@Then("Verify the status of the created user is in active status.")
	public void Verify_the_status_of_the_created_user_is_in_active_status() {

		logWithLabelName(getMethodName());
		
		driver.navigate().refresh();
		sleep(5000);
		try {
			waitForPageLoad(driver);
		}catch (Exception e) {
			
		}
		
		String rowNumber = pom.getUserManagementPage().getRowNumber();
		String status = null;
		try {
			status = pom.getUserManagementPage().getStatus(rowNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Assert.assertEquals("The expected status is 'Active' but found : "+status
					,"Active",status);
			log(Status.PASS,"The status of created user is "+status);
		}catch (AssertionFailedError e) {
			log(Status.FAIL,"The status of created user is "+status);
		}
		
	}
	
	/**
	 * Created by Nandhalala
	 * 
	 * Created on 21-FEB-2024.
	 * 
	 */
	@Then("Verify the menu contains show QR Code option.")
	public void Verify_the_menu_contains_show_QR_Code_option() {

		logWithLabelName(getMethodName());
		
		List<String> expectedOptions = new ArrayList<>();
		expectedOptions.add("Show QR Code");
		String rowNumber = pom.getUserManagementPage().getRowNumber();
		List<String> options = null;
		try {
			options = pom.getUserManagementPage().getMenuOptions(rowNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean flag = options.containsAll(expectedOptions);
		try {
			Assert.assertTrue("The expected values are : /n"+options
					 +"/nbut the expected values are : /n"+expectedOptions, flag);
			log(Status.PASS,"The option for created user is "+options);
		}catch (AssertionFailedError e) {
			log(Status.FAIL,"The option for created user is "+options);
		}
		
	}
	
	/**
	 * Created by Nandhalala
	 * 
	 * Created on 06-MAR-2024.
	 * 
	 */
	@Then("Verify the menu contains show QR Code and Resend invite options.")
	public void Verify_the_menu_contains_show_QR_Code_and_Resend_invite_options() {

		logWithLabelName(getMethodName());
		
		List<String> expectedOptions = new ArrayList<>();
		expectedOptions.add("Show QR Code");
		expectedOptions.add("Resend Invite");
		String rowNumber = pom.getUserManagementPage().getRowNumber();
		List<String> options = null;
		try {
			options = pom.getUserManagementPage().getMenuOptions(rowNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean flag = options.containsAll(expectedOptions);
		try {
			Assert.assertTrue("The expected values are : /n"+options
					 +"/nbut the expected values are : /n"+expectedOptions, flag);
			log(Status.PASS,"The option for created user is "+options);
		}catch (AssertionFailedError e) {
			log(Status.FAIL,"The option for created user is "+options);
		}
		
	}
	
	/**
	 * Created by Nandhalala
	 * 
	 * Created on 21-FEB-2024.
	 * 
	 */
	@Then("Verify the menu options for created user.")
	public void Verify_the_menu_for_created_user() {

		logWithLabelName(getMethodName());
		
		List<String> expectedOptions = new ArrayList<>();
		expectedOptions.add("Block");
		expectedOptions.add("Pause");
		expectedOptions.add("Show QR Code");
		String rowNumber = pom.getUserManagementPage().getRowNumber();
		List<String> options = null;
		try {
			options = pom.getUserManagementPage().getMenuOptions(rowNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean flag = options.containsAll(expectedOptions);
		try {
			Assert.assertTrue("The expected values are : /n"+options
					 +"/nbut the expected values are : /n"+expectedOptions, flag);
			log(Status.PASS,"The option for created user is "+options);
		}catch (AssertionFailedError e) {
			log(Status.FAIL,"The option for created user is "+options);
		}
		
	}
	
	/**
	 * Created by Nandhalala
	 * 
	 * Created on 22-FEB-2024.
	 * 
	 */
	@And("Enter Valid Data in all the Contact Details page.")
	public void Enter_Valid_Data_in_all_the_Contact_Details_page() {

		logWithLabelName(getMethodName());
		
		pom.getUserManagementPage().enterValidPermanentAddress();
		pom.getUserManagementPage().enterValidResidingAddress();
		pom.getUserManagementPage().enterValidEmegrncyContact1Name();
		pom.getUserManagementPage().selectValidEmegrncyContact1Relationship();
		pom.getUserManagementPage().enterValidEmegrncyContact1Phone();
		pom.getUserManagementPage().enterValidEmegrncyContact2Name();
		pom.getUserManagementPage().selectValidEmegrncyContact2Relationship();
		pom.getUserManagementPage().enterValidEmegrncyContact2Phone();
		
	}
	
	/**
	 * Created by Nandhalala
	 * 
	 * Created on 01-MAR-2024.
	 * 
	 */
	@Then("Click back button in contact details and verify whether basic details page is displayed.")
	public void Click_back_button_in_contact_details_and_verify_whether_basic_details_page_is_displayed() {

		logWithLabelName(getMethodName());
		
		try {
			Assert.assertTrue("Basic details page is not displayed.",
					pom.getUserManagementPage().contactDetailsBackButton());
			log(Status.PASS,"Basic details page is dislayed after clicking back in "
					+ "contact details page.");
		}catch (Exception e) {
			log(Status.PASS,"Basic details page is not dislayed after clicking back in "
					+ "contact details page.");
		}
		
		pom.getUserManagementPage().clickNewUserNextButton();
	}
	
	
	/**
	 * Created by Nandhalala
	 * 
	 * Created on 23-FEB-2024.
	 * 
	 */
	@Then("Click Contact Details Next button.")
	public void Click_Contact_Details_Next_button() {

		logWithLabelName(getMethodName());
		
		pom.getUserManagementPage().clickNewUserNextButtonContactDetailsPage();
	}
	
	/**
	 * Created by Nandhalala
	 * 
	 * Created on 23-FEB-2024.
	 * 
	 */
	@And("Enter Invalid data in date fields of Qualification page.")
	public void Enter_Invalid_data_in_date_fields_of_Qualification_page() {

		logWithLabelName(getMethodName());
		
		pom.getUserManagementPage().enterInvalidGraduationDate();
		pom.getUserManagementPage().enterInvalidMastersGraduationDate();
		
		String graduationText = null;
		String mastersGraduationText = null;
		
		try {
			graduationText = pom.getUserManagementPage().getGraduationYearErrorText();
			mastersGraduationText = pom.getUserManagementPage()
					.getMastersGraduationYearErrorText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Assert.assertTrue("Expected error text is 'Please enter valid graduation year' "
					+ "but the actual error text is : "+graduationText, graduationText
					.equals("Please enter valid graduation year"));
			log(Status.PASS,"The error text for graduation year is "+graduationText);
		}catch (AssertionFailedError e) {
			log(Status.FAIL,"The error text for graduation year is "+graduationText);
		}
		
		try {
			Assert.assertTrue("Expected error text is 'Please enter valid graduation year' "
					+ "but the actual error text is : "+mastersGraduationText, mastersGraduationText
					.equals("Please enter valid graduation year"));
			log(Status.PASS,"The error text for master graduation year is "+graduationText);
		}catch (AssertionFailedError e) {
			log(Status.FAIL,"The error text for master graduation year is "+graduationText);
		}
		
		
	}
	
	/**
	 * Created by Nandhalala
	 * 
	 * Created on 23-FEB-2024.
	 * 
	 */
	@Then("Enter valid data in all the fields of Qualification page.")
	public void Enter_valid_data_in_all_the_fields_of_Qualification_page() {

		logWithLabelName(getMethodName());
		
		pom.getUserManagementPage().enterValidGraduation();
		pom.getUserManagementPage().enterValidGraduationYear();
		pom.getUserManagementPage().enterValidGraduationUniversity();
		pom.getUserManagementPage().enterValidMasterGraduation();
		pom.getUserManagementPage().enterValidMasterGraduationYear();
		pom.getUserManagementPage().enterValidMasterGraduationUniversity();
	}
	
	/**
	 * Created by Nandhalala
	 * 
	 * Created on 23-FEB-2024.
	 * 
	 */
	@Then("Click back button in qualification page and verify whether contact details page is displayed.")
	public void Click_back_button_in_qualification_page_and_verify_whether_contact_details_page_is_displayed() {

		logWithLabelName(getMethodName());
		
		pom.getUserManagementPage().qualificationBackButton();
		pom.getUserManagementPage().clickNewUserNextButtonContactDetailsPage();
		sleep(5000);
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 03-MAR-2024.
	 * 
	 */
	@Then("Click Create and send invite from contact details page.")
	public void Click_Create_and_send_invite_from_contact_details_page() {

		logWithLabelName(getMethodName());
		
		pom.getUserManagementPage().contactDeailsCreateButton();
		String tostrText = pom.getUserManagementPage().getTostrText();
		Assert.assertTrue("The tostr text is : "+tostrText+" but the expected text is \"Created "
				+ "User Successfully\"",tostrText.equals("Created User Successfully"));
		pom.getUserManagementPage().clickTostrOkButton();
		sleep(3000);
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 03-MAR-2024.
	 * 
	 */
	@Then("Click Create and send invite from qualification page.")
	public void Click_Create_and_send_invite_from_qualification_page() {

		logWithLabelName(getMethodName());
		
		pom.getUserManagementPage().qualificationCreateButton();
		String tostrText = pom.getUserManagementPage().getTostrText();
		Assert.assertTrue("The tostr text is : "+tostrText+" but the expected text is \"Created "
				+ "User Successfully\"",tostrText.equals("Created User Successfully"));
		pom.getUserManagementPage().clickTostrOkButton();
		sleep(3000);
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 04-MAR-2024.
	 * 
	 */
	@Then("Open Mailinator aplication.")
	public void Open_Mailinator_aplication() {

		logWithLabelName(getMethodName());
		
		ChromeOptions chromeOption = new ChromeOptions();
		if (getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("Yes")) {
			chromeOption.addArguments("--headless", "--window-size=1920,1080");
		}
		mailinatordriver = new ChromeDriver(chromeOption);
		mailinatordriver.get("https://www.mailinator.com/");
		mailinatordriver.manage().window().maximize();
		mailinatorpom = new PageObjectManager(mailinatordriver);
		mailinatorpom.getMailinatorPage().enterEmail();
		mailinatorpom.getMailinatorPage().goButton();
		
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 04-MAR-2024.
	 * 
	 */
	@And("Click xealei url from mail and login into application as new user.")
	public void Click_xealei_url_from_mail() {

		logWithLabelName(getMethodName());
		
//      mailinatorpom.getMailinatorPage().enterEmail();
//		mailinatorpom.getMailinatorPage().goButton();
		
		mailinatorpom.getMailinatorPage().firstEmail();
		
		//sleep(3000);
		
		WebElement iframe = findElementByXpath(mailinatordriver, mailinatorpom.getMailinatorPage().getIFrameInMailinator);
		mailinatordriver.switchTo().frame(iframe);
		
		sleep(3000);
		
		String userName = mailinatorpom.getMailinatorPage().getUserNameInMailinatorText();
		System.out.println("Mailinator User name -" +userName);
		
		//String userName = mailinatorpom.getMailinatorPage().getUserName(iframe);
		
		writeExcelToOverwrite("Test Datas", "User Management", 1, 29, userName);
		
		mailinatorpom.getMailinatorPage().desktopURL();
		
		mailinatorpom.getLoginPage().checkPrivacyPolicy();
		mailinatorpom.getLoginPage().clickIAgreeCheckBox();
		mailinatorpom.getLoginPage().loginButton();
		mailinatorpom.getLoginPage().newPassword();
		mailinatorpom.getLoginPage().confirmNewPassword();
		mailinatorpom.getLoginPage().completeNewPassword();
		mailinatorpom.getLoginPage().enterUserName(userName);
		mailinatorpom.getLoginPage().password(readExcel("Test Datas", "User Management", 1, 28).trim());
		
		mailinatorpom.getLoginPage().loginButton();
		
		mailinatordriver.quit();
	}
	
	String userName;
	String passWord;
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 15-MAR-2024.
	 * 
	 */
	@And("Click Xealei URL from mail and login into application as new user and logout.")
	public void Click_Xealei_URL_from_mail() {

		logWithLabelName(getMethodName());
		
//		mailinatorpom.getMailinatorPage().enterEmail();
//		mailinatorpom.getMailinatorPage().goButton();
		mailinatorpom.getMailinatorPage().waitForSecondEmail();
		mailinatorpom.getMailinatorPage().firstEmail();
		
		sleep(3000);
		
		WebElement iframe = findElementByXpath(mailinatordriver, mailinatorpom.getMailinatorPage().getIFrameInMailinator);
		mailinatordriver.switchTo().frame(iframe);
		
		sleep(3000);
		
		userName = mailinatorpom.getMailinatorPage().getUserNameInMailinatorText();
		System.out.println("Mailinator User name -" +userName);
		
		passWord = mailinatorpom.getMailinatorPage().getPasswordInMailinatorText();
		System.out.println("Mailinator Passowrd -" +passWord);
		
//		passWord = mailinatorpom.getMailinatorPage().getPassword();
		
		writeExcelToOverwrite("Test Datas", "User Management", 1, 29, userName);
		writeExcelToOverwrite("Test Datas", "User Management", 1, 31, passWord);
		
		
		mailinatorpom.getMailinatorPage().xealeiURL();
		
		mailinatorpom.getLoginPage().enterUserName(userName);
		mailinatorpom.getLoginPage().password(passWord);
//		pom.getLoginPage().clickTostrOkButton();
//		mailinatorpom.getLoginPage().checkPrivacyPolicy();
		mailinatorpom.getLoginPage().clickIAgreeCheckBox();
		mailinatorpom.getLoginPage().loginButton();
		mailinatorpom.getLoginPage().newPassword();
		mailinatorpom.getLoginPage().confirmNewPassword();
		mailinatorpom.getLoginPage().completeNewPassword();
//		mailinatorpom.getLoginPage().clickTostrOkButton();
		mailinatorpom.getLoginPage().enterUserName(userName);
		mailinatorpom.getLoginPage().password(readExcel("Test Datas", "User Management", 1, 28).trim());
		mailinatorpom.getLoginPage().loginButton();
		
		if(mailinatorpom.getHomePage().isHomePageDisplayed()) {
			log(Status.PASS, "Login as new user is successfull");
		}else {
			log(Status.PASS, "Login as new user is not successfull");
		}
		mailinatorpom.getHomePage().arrowDropDown();
		mailinatorpom.getHomePage().logout();
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 06-MAR-2024
	 */
	@Then("Verify whether all the fields are editable in edit mode.")
	public void Verify_whether_all_the_fields_are_editable_in_edit_mode() {

		logWithLabelName(getMethodName());
		
		String rownumber = pom.getUserManagementPage().getRowNumber();
		try {
			pom.getUserManagementPage().viewButton(rownumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sleep(3000);
		pom.getUserManagementPage().editButton();
		if(pom.getUserManagementPage().viewFieldsCanBeEdited()) {
			log(Status.PASS, "The fields are editable in edit mode.");
		}else {
			log(Status.FAIL,"The fields are non editable in edit mode.");
		}
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 07-MAR-2024
	 */
	@Then("Edit any field and click cancel button.")
	public void Edit_any_field_and_click_cancel_button() {

		logWithLabelName(getMethodName());
		
		pom.getUserManagementPage().editFirstName();
		pom.getUserManagementPage().editCancelButton();
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 07-MAR-2024
	 * 
	 */
	@Then("Verify able to save the edited data.")
	public void Verify_able_to_save_the_edited_data() {

		logWithLabelName(getMethodName());
		
		String rownumber = pom.getUserManagementPage().getRowNumber();
		try {
			pom.getUserManagementPage().viewButton(rownumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pom.getUserManagementPage().editButton();
		pom.getUserManagementPage().editRole();
		pom.getUserManagementPage().editSaveButton();
		String updatedRole = null;
		String expectedRole = readExcel("Test Datas", "User Management", 1, 30).trim();
		try {
			updatedRole = pom.getUserManagementPage().getRole(rownumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Assert.assertEquals("The Role expected is : "+expectedRole+" but actual role "
					+ "found is : "+updatedRole,expectedRole,updatedRole);
			log(Status.PASS, "User value is updated successfully.");
		}catch (AssertionFailedError e) {
			log(Status.PASS, "User value is not updated successfully.");
		}
		
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 07-MAR-2024.
	 */
	@Then("Search the created user and verify view info.")
	public void Search_the_created_user_and_verify_view_info() {

		logWithLabelName(getMethodName());
		
		pom.getUserManagementPage().searchUserwithFirstName();
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 12-MAR-2024.
	 */
	@And("Verify the data of the created user.")
	public void Verify_the_data_of_the_created_user() {

		logWithLabelName(getMethodName());
		
		String rownumber = pom.getUserManagementPage().getRowNumber();
		try {
			pom.getUserManagementPage().viewButton(rownumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String expectedFullName = readExcel("Test Datas", "User Management", 1,24).trim()+" "+
									readExcel("Test Datas", "User Management", 1,26).trim()+" "+
									readExcel("Test Datas", "User Management", 1,25).trim();
		String expectedRole = readExcel("Test Datas", "User Management", 1,30).trim();
		String expectedEmailID = readExcel("Test Datas", "User Management", 1,27).trim();
		String expectedPhoneNumber = readExcel("Test Datas", "User Management", 1,7).trim();
		String expectedPhonenumber = "("+expectedPhoneNumber.charAt(0)+expectedPhoneNumber.charAt(1)
								+expectedPhoneNumber.charAt(2)+") "+expectedPhoneNumber.charAt(3)
								+expectedPhoneNumber.charAt(4)+expectedPhoneNumber.charAt(5)+"-"
								+expectedPhoneNumber.charAt(6)+expectedPhoneNumber.charAt(7)
								+expectedPhoneNumber.charAt(8)+expectedPhoneNumber.charAt(9);
		
		String actualFullName = pom.getUserManagementPage().getFullNameFromViewPage();
		String actualRole = pom.getUserManagementPage().getRoleFromViewPage();
		String actualEmailID = pom.getUserManagementPage().getEmailIDFromViewPage();
		String actualPhoneNumber = pom.getUserManagementPage().getPhoneNumberFromViewPage();
		
		try {
			Assert.assertEquals("The expected Full name of the user is : "+expectedFullName
					+" but found : "+actualFullName, expectedFullName, actualFullName);
			log(Status.PASS, "The full name of the created user is same as entered in "
					+ "created user.");
		}catch(AssertionFailedError e) {
			log(Status.FAIL, "The full name of the created user is not same as entered in "
					+ "created user.");
			log(Status.FAIL,e.getMessage());
		}
		
		try {
			Assert.assertEquals("The expected Role of the user is : "+expectedRole
					+" but found : "+actualRole, expectedRole, actualRole);
			log(Status.PASS, "The role of the created user is same as entered in "
					+ "created user.");
		}catch(AssertionFailedError e) {
			log(Status.FAIL, "The role of the created user is not same as entered in "
					+ "created user.");
			log(Status.FAIL,e.getMessage());
		}
		
		try {
			Assert.assertEquals("The expected Email ID of the user is : "+expectedEmailID
					+" but found : "+actualEmailID, expectedEmailID, actualEmailID);
			log(Status.PASS, "The Email ID of the created user is same as entered in "
					+ "created user.");
		}catch(AssertionFailedError e) {
			log(Status.PASS, "The Email ID of the created user is not same as entered in "
					+ "created user.");
			log(Status.FAIL,e.getMessage());
		}
		
		try {
			Assert.assertEquals("The expected Phone Number of the user is : "+expectedPhonenumber
					+" but found : "+actualPhoneNumber, expectedPhonenumber, actualPhoneNumber);
			log(Status.PASS, "The Phone Number of the created user is same as entered in "
					+ "created user.");
		}catch(AssertionFailedError e) {
			log(Status.PASS, "The Phone Number of the created user is not same as entered in "
					+ "created user.");
			log(Status.FAIL,e.getMessage());
		}
		
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 12-MAR-2024.
	 */
	@Then("Navigate back to User management page.")
	public void Navigate_back_to_User_management_page() {

		logWithLabelName(getMethodName());
		
		pom.getUserManagementPage().navigateBacktoUserManagementFromViewEditPage();
		pom.getUserManagementPage().isUserManagementPageDisplayed();
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 12-MAR-2024.
	 */
	@Then("Verify whether able to {string} the user.")
	public void verify_whether_able_to_the_user(String string) {

		logWithLabelName(getMethodName());
		
		String rownumber = pom.getUserManagementPage().getRowNumber();
		try {
			pom.getUserManagementPage().menuAction(rownumber, string);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 12-MAR-2024.
	 */
	@Then("Verify whether user is in {string} Status.")
	public void verify_whether_user_is_in_status(String string) {

		logWithLabelName(getMethodName());
		
		String rowNumber = pom.getUserManagementPage().getRowNumber();
//		System.out.println(rowNumber);
		String status = null;
		try {
			status = pom.getUserManagementPage().getStatus(rowNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Assert.assertEquals("The expected status is : "+ string +" but found : "+status
					,string,status);
			log(Status.PASS,"The status of user is "+status);
		}catch (AssertionFailedError e) {
			log(Status.FAIL,"The status of user is "+status);
		}
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 12-MAR-2024.
	 */
	@Then("Verify whether validations are showing while creating a new user with same Email ID and Phone Number.")
	public void verify_whether_validations_are_showing_while_creating_a_new_user_with_same_email_id_and_phone_number() {

		logWithLabelName(getMethodName());
		
		pom.getUserManagementPage().clickCreateNewUserButton();
	    pom.getUserManagementPage().enterValidFirstName();
		pom.getUserManagementPage().enterValidMiddleName();
		pom.getUserManagementPage().enterValidLastName();
		pom.getUserManagementPage().selectRole();
		try {
			pom.getUserManagementPage().enterValidDuplicatePhoneNumber();
		} catch (Exception e) {
			e.printStackTrace();
		}
		pom.getUserManagementPage().clickNewUserCreateAndSendInviteButton();
		String tostrText = pom.getUserManagementPage().getTostrText();
		pom.getUserManagementPage().clickTostrOkButton();
		String expectedPhoneNumber = "Mobile number ("+
				readExcel("Test Datas", "User Management", 1, 7).trim()+") already exists!";
		try {
			Assert.assertEquals("The expected text is '"+expectedPhoneNumber+"' but found : "
					+tostrText, expectedPhoneNumber, tostrText);
			log(Status.PASS,"Error validation message for creating a user with duplicate "
					+ "phone number is : /n"+tostrText);
		}catch(AssertionFailedError e) {
			log(Status.FAIL,"Error validation message for creating a user with duplicate "
					+ "phone number is : /n"+tostrText);
		}
		
		try {
			pom.getUserManagementPage().enterValidDuplicateEmailID();
		} catch (Exception e) {
			e.printStackTrace();
		}
		pom.getUserManagementPage().clickNewUserCreateAndSendInviteButton();
		tostrText = pom.getUserManagementPage().getTostrText();
		pom.getUserManagementPage().clickTostrOkButton();
		String expectedEmail = "Email Id ("+readExcel("Test Datas", "User Management", 1, 27)
									.trim()+") already exists";
		try {
			Assert.assertEquals("The expected text is '"+expectedEmail+"' but found : "
					+tostrText, expectedEmail, tostrText);
			log(Status.PASS,"Error validation message for creating a user with duplicate "
					+ "email is : \n"+tostrText);
		}catch(AssertionFailedError e) {
			log(Status.FAIL,"Error validation message for creating a user with duplicate "
					+ "email is : \n"+tostrText);
		}
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 12-MAR-2024.
	 */
	@Then("Verify wheter edit button is diabled.")
	public void verify_wheter_edit_button_is_diabled() {

		logWithLabelName(getMethodName());
		
		String rowNumber = pom.getUserManagementPage().getRowNumber();
		try {
			pom.getUserManagementPage().viewButton(rowNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String editButtonStatus = pom.getUserManagementPage().getEditbuttonDisabledStatus();
		try {
			Assert.assertEquals("The edit button is not disabled", "true", editButtonStatus);
			log(Status.PASS,"The Edit button is disabled for Inactive user.");
		}catch(AssertionFailedError e) {
			log(Status.FAIL,"The Edit button is not disabled for Inactive user.");
		}
		
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 12-MAR-2024.
	 */
	@Then("Verify wheter edit button is enabled.")
	public void verify_wheter_edit_button_is_enabled() {

		logWithLabelName(getMethodName());
		
		String rowNumber = pom.getUserManagementPage().getRowNumber();
		try {
			pom.getUserManagementPage().viewButton(rowNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String editButtonStatus = pom.getUserManagementPage().getEditbuttonDisabledStatus();
		try {
			Assert.assertEquals("The edit button is not enabled", "false", editButtonStatus);
			log(Status.PASS,"The Edit button is enabled for Active user.");
		}catch(AssertionFailedError e) {
			log(Status.FAIL,"The Edit button is not enabled for Active user.");
		}
		
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 13-MAR-2024.
	 */
	@Then("Verify future date validations for Graduation and Master Graduation calender fields.")
	public void Verify_future_date_validations_for_Graduation_and_Master_Graduation_calender_fields() {

		logWithLabelName(getMethodName());
		
		pom.getUserManagementPage().clickGraduationCalendarIcon();
		try {
			pom.getUserManagementPage().futureDatesAreHidden();
			pom.getUserManagementPage().selectCurrentDateInDatePicker();
		}catch(Exception e) {
			
		}
		
		pom.getUserManagementPage().clickMasterGraduationCalendarIcon();
		try {
			pom.getUserManagementPage().futureDatesAreHidden();
			pom.getUserManagementPage().selectCurrentDateInDatePicker();
		}catch(Exception e) {
			
		}
		
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 15-MAR-2024.
	 */
	@Then("Click Resend Invite to resend a mail.")
	public void Click_Resend_Invite_to_resend_a_mail() {

		logWithLabelName(getMethodName());
		
		String rownumber = pom.getUserManagementPage().getRowNumber();
		try {
			//Resend Invite
			pom.getUserManagementPage().menuAction(rownumber, "Resend Invite");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 18-MAR-2024.
	 * 
	 */
	@Then("Verify whether not able to login with Inactive user.")
	public void Verify_whether_not_able_to_login_with_Inactive_user() {

		logWithLabelName(getMethodName());
		
		mailinatorpom.getLoginPage().enterUserName(userName);
		mailinatorpom.getLoginPage()
		.password(readExcel("Test Datas", "User Management", 1, 28).trim());
		
		sleep(2000);
		
		mailinatorpom.getLoginPage().loginButton();
		
		
		String tostrMessage = mailinatorpom.getLoginPage().getTostrText();
		String expected = "Account of the user has been inactive";
		
		try {
			Assert.assertEquals("The expected tostr message is '"+expected+"' but found : "
		+tostrMessage, expected, tostrMessage);
			log(Status.PASS,"The tostr message for login with Inactive user is :\n"+tostrMessage
					,mailinatordriver);
			
		}catch(AssertionFailedError e) {
			log(Status.FAIL,"The tostr message for login with Inactive user is :\n"+tostrMessage, 
					mailinatordriver);
		}
		
		mailinatorpom.getLoginPage().clickToastOkButton();
		
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 18-MAR-2024.
	 * 
	 */
	@Then("Verify whether able to login with Active user.")
	public void Verify_whether_able_to_login_with_Active_user() {

		logWithLabelName(getMethodName());
		
		mailinatorpom.getLoginPage().enterUserName(userName);
		mailinatorpom.getLoginPage().password(readExcel("Test Datas", "User Management", 1, 28).trim());
		
		mailinatorpom.getLoginPage().loginButton();
		
		if(mailinatorpom.getHomePage().isHomePageDisplayed()) {
			log(Status.PASS, "Login as new user is successfull", mailinatordriver);
		}else {
			log(Status.PASS, "Login as new user is not successfull", mailinatordriver);
		}
		mailinatorpom.getHomePage().arrowDropDown();
		mailinatorpom.getHomePage().logout();
		
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 18-MAR-2024.
	 * 
	 */
	@Then("Verify whether not able to login with Blocked user.")
	public void Verify_whether_not_able_to_login_with_Blocked_user() {

		logWithLabelName(getMethodName());
		
		mailinatorpom.getLoginPage().enterUserName(userName);
		mailinatorpom.getLoginPage().password(readExcel("Test Datas", "User Management", 1, 28).trim());
		mailinatorpom.getLoginPage().loginButton();
		String tostrMessage = mailinatorpom.getLoginPage().getTostrText();
		//Account of the user has been blocked
		String expected = "Account of the user has been blocked";
		try {
			Assert.assertEquals("The expected tostr message is '"+expected+"' but found : "
		+tostrMessage, expected, tostrMessage);
			log(Status.PASS,"The tostr message for login with Blocked user is :\n"+tostrMessage, 
					mailinatordriver);
		}catch(AssertionFailedError e) {
			log(Status.FAIL,"The tostr message for login with Blocked user is :\n"+tostrMessage, 
					mailinatordriver);
		}
		mailinatorpom.getLoginPage().clickToastOkButton();
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 18-MAR-2024.
	 * 
	 */
	@Then("Close all browsers.")
	public void Close_all_browser() {

		logWithLabelName(getMethodName());
		
		mailinatordriver.quit();
	}
	
}
