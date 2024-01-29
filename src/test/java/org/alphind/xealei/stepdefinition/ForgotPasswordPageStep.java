package org.alphind.xealei.stepdefinition;


import org.alphind.xealei.baseclass.BaseClass;
import org.alphind.xealei.pom.PageObjectManager;
import org.junit.Assert;

import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Then;

public class ForgotPasswordPageStep extends BaseClass{

	PageObjectManager pom = new PageObjectManager(getDriver());
	
	@Then("User should verify Forget password link is working")
	public void user_should_verify_forget_password_link_is_working() {

		logStep(methodName());

		if (pom.getLoginPage().isForgotPasswordLinkDisplayed()) {
			
			pom.getLoginPage().forgotPasswordHyperLink();

			try {
				Assert.assertTrue(pom.getForgotPasswordPage().isForgotPasswordPageIsDisplayed());
				log(Status.PASS, "Navigate to Forgot Password Page");
			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}
			
		} else {
			log(Status.FAIL, "Unable to click Forget password? textlink");
			System.err.println("[ERROR] >>>> Unable to click Forget password? textlink");
		}
	}
	
		@Then("User must verify the tab url address for FORGOT PASSWORD screen")
		public void user_must_verify_the_tab_url_address_for_forgot_password_screen() {
		    
		    
			try {
				
				String environment = getConfigureProperty("Environment");
				switch (environment) {
				case "QA": {
					Assert.assertEquals("Login page url is wrong", readExcel("Test Datas", "Environments", 1, 1) + "login/forgot",
							getCurrentUrl());
					log(Status.INFO, "Forgot Password tab URL Address verified - " + getCurrentUrl());

					break;
				}
				case "PREPROD": {
					Assert.assertEquals("Login page url is wrong", readExcel("Test Datas", "Environments", 2, 1) + "login/forgot",
							getCurrentUrl());
					log(Status.INFO, "Forgot Password tab URL Address verified - " + getCurrentUrl());
					break;
				}
				case "PROD": {
					Assert.assertEquals("Login page url is wrong", readExcel("Test Datas", "Environments", 3, 1) + "login/forgot",
							getCurrentUrl());
					log(Status.INFO, "Forgot Password tab URL Address verified - " + getCurrentUrl());
					break;
				}
				default: {
					break;
				}
				}
			} catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}

		
		}
		
		@Then("User must verify the Forgot Password text is displayed {string}")
		public void user_must_verify_the_forgot_password_text_is_displayed(String getExpForgotPassTxt) {
		    
		    try {
		    	Assert.assertEquals("FORGOT PASSWORD text is NOT Displayed as expected", getExpForgotPassTxt, pom.getForgotPasswordPage().getForgotPasswordText());
		    log(Status.PASS, "FP text is displayed as expected");
		    } catch (AssertionError e) {
				log(Status.FAIL, e.getMessage());
				e.printStackTrace();
		    }
		}
		
		@Then("User must verify the Lable name & Place holder text for Email field")
		public void user_must_verify_the_lable_name_place_holder_text_for_email_field() {
		    
			try {
				
				Assert.assertTrue("Lable name in Email* text is not displayed as expected", pom.getForgotPasswordPage().verifyEmailLabelText());
				log(Status.PASS, "Field Lable name is displayed as expected");
			} catch (AssertionError e) {
				log(Status.FAIL,e.getMessage());
				e.printStackTrace();
			}
			
             try {
				
			Assert.assertTrue("Placeholder text in Email* field is not displayed as expected", pom.getForgotPasswordPage().verifyEmailPlaceHolderText());
				log(Status.PASS, "Placeholder text in Email* field is displayed as expected");
			} catch (AssertionError e) {
				log(Status.FAIL,e.getMessage());
				e.printStackTrace();
			}
		    
		}
		
		@Then("User must click  the Reset button without perform Email field and verify the info message is displayed {string}")
		public void user_must_click_the_reset_button_without_perform_email_field_and_verify_the_info_message_is_displayed(String expInfoMsg) {
		  
	pom.getForgotPasswordPage().resetButton();
	
	try {
	Assert.assertEquals("Info message is NOT displayed as expected", expInfoMsg, pom.getForgotPasswordPage().getInfoMsgText());
	log(Status.PASS, "Info message is displayed as expected Exp Info Text - "+expInfoMsg+" | Actual Info Text - "+pom.getForgotPasswordPage().getInfoMsgText());
} catch (AssertionError e) {
	log(Status.FAIL, e.getMessage());
	e.printStackTrace();
}
	
}

@Then("User must verify the Email field for formats {string}")
public void user_must_verify_the_email_field_for_formats(String expInfoMsgText) {
		    
           pom.getForgotPasswordPage().email(1,0).resetButton();
           
           try {
        		Assert.assertEquals(""+expInfoMsgText+" Info message is NOT displayed as expected after perform invalid email format", expInfoMsgText, pom.getForgotPasswordPage().getInfoMsgText());
        		log(Status.PASS, "Info message is displayed as expected Exp Info Text - "+expInfoMsgText+" | Actual Info Text - "+pom.getForgotPasswordPage().getInfoMsgText());
        	} catch (AssertionError e) {
        		log(Status.FAIL, e.getMessage());
        		e.printStackTrace();
        	}
           
           pom.getForgotPasswordPage().deleteEmailFieldData();
         	pom.getForgotPasswordPage().email(2,0).resetButton();
         	
         	// TEMP STEPS
         	waitForPageLoad();
         	pom.getForgotPasswordPage().toastMsgokButton();
         	
         	//*** ISSUE **** 
         	
//        try {
//    		Assert.assertEquals(""+expInfoMsgText+" Info message is NOT displayed as expected after perform invalid email format", expInfoMsgText, pom.getForgotPasswordPage().getInfoMsgText());
//    		log(Status.PASS, "Info message is displayed as expected Exp Info Text - "+expInfoMsgText+" | Actual Info Text - "+pom.getForgotPasswordPage().getInfoMsgText());
//    	} catch (AssertionError e) {
//    		log(Status.FAIL, e.getMessage());
//    		e.printStackTrace();
//    	}
}


@Then("User must verify the Email field with invalid data {string}")
public void user_must_verify_the_email_field_with_invalid_data(String expNotFoundToastMsgText) {
   
           pom.getForgotPasswordPage().deleteEmailFieldData();
           pom.getForgotPasswordPage().email(3,0).resetButton();
           
           try {
        	   waitForPageLoad();
        	   
          		Assert.assertEquals(""+expNotFoundToastMsgText+" Toast message is NOT displayed as expected after perform invalid email format", expNotFoundToastMsgText, pom.getForgotPasswordPage().getEmailIDNotFoundToastMsgText());
          		log(Status.PASS, "Toast message is displayed as expected Exp Text - "+expNotFoundToastMsgText+" | Actual Text - "+pom.getForgotPasswordPage().getEmailIDNotFoundToastMsgText());
          
          		pom.getForgotPasswordPage().toastMsgokButton();
          		
              } catch (AssertionError e) {
          		log(Status.FAIL, e.getMessage());
          		e.printStackTrace();
          	}        
}
		
		@Then("User must verify the email field for unregistered user {string}")
		public void user_must_verify_the_email_field_for_unregistered_user(String expNotFoundToastMsgText) {
		    
            pom.getForgotPasswordPage().deleteEmailFieldData();
	        
			pom.getForgotPasswordPage().email(1,1).resetButton();
	           
	           try {
	        	   
	        	   waitForPageLoad();
	        	   
	       		Assert.assertEquals(""+expNotFoundToastMsgText+" Toast message is NOT displayed as expected after perform invalid email format", expNotFoundToastMsgText, pom.getForgotPasswordPage().getEmailIDNotFoundToastMsgText());
	       		log(Status.PASS, "Toast message is displayed as expected Exp Text - "+expNotFoundToastMsgText+" | Actual Text - "+pom.getForgotPasswordPage().getEmailIDNotFoundToastMsgText());
	       
	       		pom.getForgotPasswordPage().toastMsgokButton();
	       		
	           } catch (AssertionError e) {
	       		log(Status.FAIL, e.getMessage());
	       		e.printStackTrace();
	       	}        
		    
		}
		
		@Then("User must verify the email for blocked user")
		public void user_must_verify_the_email_for_blocked_user() {
		    
		    
		}
		
		@Then("User must verify the email for Inactive user")
		public void user_must_verify_the_email_for_inactive_user() {
		    
		    
		}
		
		
		@Then("User must verify the email field with valid data")
		public void user_must_verify_the_email_field_with_valid_data() {
		    
			 pom.getForgotPasswordPage().deleteEmailFieldData();
		        
				pom.getForgotPasswordPage().email(1,4).resetButton();
				
				try {
					waitForPageLoad();
					
		        	String expText = "EMAIL SENT!";
		       		Assert.assertEquals("Unable to reset the password using valid email address", expText, pom.getForgotPasswordPage().getEmailSentVerifyText());
		       		log(Status.PASS, "Successfully Reset the password using valid email address");
		       		
		           } catch (AssertionError e) {
		       		log(Status.FAIL, e.getMessage());
		       		e.printStackTrace();
		       	}        
		}
		
		@Then("User must verify the email sent successfully content")
		public void user_must_verify_the_email_sent_successfully_content() {
		  
			try {
	        	String expTextContent = "We sent an email to mohamedrazul.s+1@alphind.com so you can create your new password";
	        	
	       		Assert.assertEquals("Email Sent successfully content is NOT displayed as expected", expTextContent, pom.getForgotPasswordPage().getForgotPasswordMsgContent());
	       		log(Status.PASS, "Email Sent successfully content is displayed as expected Exp Content text - "+expTextContent+" | Actual Content Text - "+pom.getForgotPasswordPage().getForgotPasswordMsgContent());
	       		
	           } catch (AssertionError e) {
	       		log(Status.FAIL, e.getMessage());
	       		e.printStackTrace();
	       	}        
			
		}
		
		
		@Then("User must verify the Try Again text link is working")
		public void user_must_verify_the_try_again_text_link_is_working() {
		    
		    pom.getForgotPasswordPage().TryAgain();
		    
		    try {
		    	Assert.assertTrue("Try Again link is NOT Working as expected", pom.getForgotPasswordPage().isTryAgainLinkIsWork());
		    log(Status.PASS, "Try Again text link is working as expected");
		    } catch (AssertionError e) {
		    	log(Status.FAIL, e.getMessage());
		    	e.printStackTrace();
			}
		}
		
		@Then("User must verify the login button in forgot password screen")
		public void user_must_verify_the_login_button_in_forgot_password_screen() {
		    
		    pom.getForgotPasswordPage().loginTextLink();
		    
		    try {
		    	Assert.assertTrue("Login link is NOT Working as expected", pom.getLoginPage().isLoginPageIsDisplayed());
		    log(Status.PASS, "Login text link is working as expected");
		    } catch (AssertionError e) {
		    	log(Status.FAIL, e.getMessage());
		    	e.printStackTrace();
			}  
			
		}

	
}
