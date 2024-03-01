/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul, on date

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
	private AddCommonAreaPage addCommonAreaPage;
	private EditCommonAreaPage editCommonAreaPage;
	
	public PageObjectManager(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	
	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}
	
	public AddSuitesPage getAddSuitesPage() {
		return (addSuitesPage == null) ? addSuitesPage = new AddSuitesPage(driver) : addSuitesPage;
	}
	
	public EditSuitesPage getEditSuitesPage() {
		return (editSuitesPage == null) ? editSuitesPage = new EditSuitesPage(driver) : editSuitesPage;
		
	}
	
	public AddIndividualsPage getAddIndividualsPage() {
		return (addIndividualsPage == null) ? addIndividualsPage = new AddIndividualsPage(driver) : addIndividualsPage;
	}
	
	
	public EditIndividualsPage getEditIndividualsPage() {
		return (editIndividualsPage == null) ? editIndividualsPage = new EditIndividualsPage(driver) : editIndividualsPage;
	}
	
	
	public IncidentReportPage getIncidentReportPage() {
		return (incidentReportPage == null) ? incidentReportPage = new IncidentReportPage(driver) : incidentReportPage;
	}
	
	public ForgotPasswordPage getForgotPasswordPage() {
		return (forgotPasswordPage == null) ? forgotPasswordPage = new ForgotPasswordPage(driver) : forgotPasswordPage;
	}
	
	
	public AddCommonAreaPage getAddCommonAreaPage() {
		return (addCommonAreaPage == null) ? addCommonAreaPage = new AddCommonAreaPage() : addCommonAreaPage;
	}
	
	public EditCommonAreaPage getEditCommonAreaPage() {
		return (editCommonAreaPage == null) ? editCommonAreaPage = new EditCommonAreaPage() : editCommonAreaPage;
	}
}
