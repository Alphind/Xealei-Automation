package org.alphind.xealei.stepdefinition;

import org.alphind.xealei.baseclass.BaseClass;
import org.alphind.xealei.pom.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class IncidentReportPageStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();
	
	

	@When("User should perform login as facility admin {string} and {string}")
	public void user_should_perform_login_as_facility_admin (String userName, String password) {

			logStep(methodName());
			
//			pom.getLoginPage().validEmail(1);
//			pom.getLoginPage().validPassword(1);
//			pom.getLoginPage().loginButton();
//            waitForPageLoad();
			
			sendKeys(pom.getLoginPage().getUserName(),userName );
			sendKeys(pom.getLoginPage().getPassword(),password );
			pom.getLoginPage().loginButton();
			waitForPageLoad();
			
		}


			@Then("User should also verify the performed login as {string}")
			public void user_should_also_verify_the_performed_login_as (String adminName) {
			   
				String text = getText(pom.getHomePage().getAdminName());
				
			Assert.assertEquals("Login page url is wrong", adminName , text);
			System.out.println("EXP Value" +adminName);
			System.out.println("ACT Value" +text);
				
			}

			
			@Then("User should verify the Incident report module is working")
			public void user_should_verify_the_incident_report_module_is_working() {


				
			}
			
			
			@Then("User should verify the ADD New Incident Report button is working")
			public void user_should_verify_the_add_new_incident_report_button_is_working() {


			}
			
			/**
			 * Created by Nandhalala.
			 */
			@When("User is login into Xealei application as Staff role user with valid <username> and <passowrd>.")
			public void user_is_login_into_xealei_application_as_staff_role_user_with_valid_username_and_passowrd() {
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Verify Home page is displayed.")
			public void verify_home_page_is_displayed() {
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Navigate to Reports module.")
			public void navigate_to_reports_module() {
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Navigate to Incident Report sub module.")
			public void navigate_to_incident_report_sub_module() {
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Click on Add New Incident Report button.")
			public void click_on_add_new_incident_report_button() {
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Verify Incident report page is displayed.")
			public void verify_incident_report_page_is_displayed() {
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Select the individual for whom the incident report has to be created.")
			public void select_the_individual_for_whom_the_incident_report_has_to_be_created() {
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Enter all the details of the Incident.")
			public void enter_all_the_details_of_the_incident() {
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Click on next button.")
			public void click_on_next_button() {
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
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
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
			}

			/**
			 * Created by Nandhalala.
			 */
			@When("Verify whether the report is in pending status.")
			public void verify_whether_the_report_is_in_pending_status() {
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Launch a new browser and enter xealei url.")
			public void launch_a_new_browser_and_enter_xealei_url() {
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Login into Xealei application as Cheif nurse role with valid <username> and <passowrd>.")
			public void login_into_xealei_application_as_cheif_nurse_role_with_valid_username_and_passowrd() {
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
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
			@Then("Login into Xealei application as Residential Manager role with valid <username> and <passowrd>.")
			public void login_into_xealei_application_as_residential_manager_role_with_valid_username_and_passowrd() {
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Login into Xealei application as CLinical Coordinator role with valid <username> and <passowrd>.")
			public void login_into_xealei_application_as_c_linical_coordinator_role_with_valid_username_and_passowrd() {
			    // Write code here that turns the phrase above into concrete actions
			    throw new io.cucumber.java.PendingException();
			}

			/**
			 * Created by Nandhalala.
			 */
			@Then("Login into Xealei application as Social Worker role with valid <username> and <passowrd>.")
			public void login_into_xealei_application_as_social_worker_role_with_valid_username_and_passowrd() {
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


		
}
