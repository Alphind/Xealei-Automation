/** Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.pom;

import org.alphind.xealei.pages.AddCommonAreaPage;
import org.alphind.xealei.pages.AddIndividualsPage;
import org.alphind.xealei.pages.AddSuitesPage;
import org.alphind.xealei.pages.EditCommonAreaPage;
import org.alphind.xealei.pages.EditIndividualsPage;
import org.alphind.xealei.pages.EditSuitesPage;
import org.alphind.xealei.pages.ForgotPasswordPage;
import org.alphind.xealei.pages.HomePage;
import org.alphind.xealei.pages.IncidentReportPage;
import org.alphind.xealei.pages.LoginPage;
import org.alphind.xealei.pages.MailinatorPage;
import org.alphind.xealei.pages.UserManagementPage;
import org.alphind.xealei.stepdefinition.ForgotPasswordPageStep;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	
	private WebDriver driver;
	
	/*
	 * Description - All the pages class i.e (POM) Objects are created Here..
	 */
	private LoginPage loginPage;
	private AddSuitesPage addSuitesPage;
	private EditSuitesPage editSuitesPage;
	private AddIndividualsPage addIndividualsPage;
	private EditIndividualsPage editIndividualsPage;
	private IncidentReportPage incidentReportPage;
	private HomePage homePage;
	private ForgotPasswordPage forgotPasswordPage;
	private UserManagementPage userManagementPage;
	private MailinatorPage mailinatorPage;
	private AddCommonAreaPage addCommonAreaPage;
	private EditCommonAreaPage editCommonAreaPage;

	
	public PageObjectManager(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	/**
	 * 
	 * Created Alphi-MohamedRazul
	 * 
	 * If login page is initialized returns the instance or create a new instance 
	 * and returns it.
	 * 
	 * @return instance of loginPage
	 */
	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}

	/**
	 * 
	 * Created Alphi-MohamedRazul
	 * 
	 * If Home page is initialized returns the instance or create a new instance 
	 * and returns it.
	 * 
	 * @return instance of homePage
	 */
	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}
	
	
	/**
	 * 
	 * Created Alphi-MohamedRazul
	 * 
	 * If addSuites page is initialized returns the instance or create a new instance 
	 * and returns it.
	 * 
	 * @return instance of addSuitesPage
	 */
	public AddSuitesPage getAddSuitesPage() {
		return (addSuitesPage == null) ? addSuitesPage = new AddSuitesPage(driver) : addSuitesPage;
	}
	
	/**
	 * 
	 * Created Alphi-MohamedRazul
	 * 
	 * If editSuites page is initialized returns the instance or create a new instance 
	 * and returns it.
	 * 
	 * @return instance of editSuitesPage
	 */
	public EditSuitesPage getEditSuitesPage() {
		return (editSuitesPage == null) ? editSuitesPage = new EditSuitesPage(driver) : editSuitesPage;
		
	}
	
	/**
	 * 
	 * Created Alphi-MohamedRazul
	 * 
	 * If addIndividuals page is initialized returns the instance or create a new instance 
	 * and returns it.
	 * 
	 * @return instance of addIndividualsPage
	 */
	public AddIndividualsPage getAddIndividualsPage() {
		return (addIndividualsPage == null) ? addIndividualsPage = new AddIndividualsPage(driver) : addIndividualsPage;
	}
	
	/**
	 * 
	 * Created Alphi-MohamedRazul
	 * 
	 * If editIndividuals page is initialized returns the instance or create a new instance 
	 * and returns it.
	 * 
	 * @return instance of editIndividualsPage
	 */
	public EditIndividualsPage getEditIndividualsPage() {
		return (editIndividualsPage == null) ? editIndividualsPage = new EditIndividualsPage(driver) : editIndividualsPage;
	}
	
	/**
	 * 
	 * Created Alphi-MohamedRazul
	 * 
	 * If incidentReport Page is initialized returns the instance or create a new instance 
	 * and returns it.
	 * 
	 * @return instance of incidentReportPage
	 */
	public IncidentReportPage getIncidentReportPage() {
		return (incidentReportPage == null) ? incidentReportPage = new IncidentReportPage(driver) : incidentReportPage;
	}
	
	/**
	 * 
	 * Created Alphi-MohamedRazul
	 * 
	 * If forgotPassword Page is initialized returns the instance or create a new instance 
	 * and returns it.
	 * 
	 * @return instance of forgotPasswordPage
	 */
	public ForgotPasswordPage getForgotPasswordPage() {
		return (forgotPasswordPage == null) ? forgotPasswordPage = new ForgotPasswordPage(driver) : forgotPasswordPage;
	}
	
	/**
	 * 
	 * Created by Nandhalala
	 * 
	 * Created on 12-FEB-204
	 * 
	 * If usermanagemant page is initialized returns the instance or create a new instance 
	 * and returns it.
	 * 
	 * @return instance of usermanagementpage
	 */
	public UserManagementPage getUserManagementPage() {
		return (userManagementPage == null) ? userManagementPage = new UserManagementPage(driver) : userManagementPage;
	}
	
	/**
	 * 
	 * Created by Nandhalala.
	 * 
	 * Created on 04-MAR-204.
	 * 
	 * If Mailinator page is initialized returns the instance or create a new instance 
	 * and returns it.
	 * 
	 * @return instance of mailinatorPage
	 */
	public MailinatorPage getMailinatorPage() {
		return (mailinatorPage == null) ? mailinatorPage = new MailinatorPage(driver) : mailinatorPage;
	}
	
	/**
	 * 
	 * Created Alphi-MohamedRazul
	 * 
	 * If addCommonArea Page is initialized returns the instance or create a new instance 
	 * and returns it.
	 * 
	 * @return instance of addCommonAreaPage
	 */
	public AddCommonAreaPage getAddCommonAreaPage() {
		return (addCommonAreaPage == null) ? addCommonAreaPage = new AddCommonAreaPage() : addCommonAreaPage;
	}
	
	/**
	 * 
	 * Created Alphi-MohamedRazul
	 * 
	 * If editCommonArea Page is initialized returns the instance or create a new instance 
	 * and returns it.
	 * 
	 * @return instance of editCommonAreaPage
	 */
	public EditCommonAreaPage getEditCommonAreaPage() {
		return (editCommonAreaPage == null) ? editCommonAreaPage = new EditCommonAreaPage() : editCommonAreaPage;
	}
}
