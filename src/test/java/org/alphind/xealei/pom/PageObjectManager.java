/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul, on date

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.pom;

import org.alphind.xealei.pages.AddIndividualsPage;
import org.alphind.xealei.pages.AddSuitesPage;
import org.alphind.xealei.pages.EditIndividualsPage;
import org.alphind.xealei.pages.EditSuitesPage;
import org.alphind.xealei.pages.HomePage;
import org.alphind.xealei.pages.IncidentReportPage;
import org.alphind.xealei.pages.LoginPage;

public class PageObjectManager {

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
	
	
	
	
	
	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage() : homePage;
	}
	
	public AddSuitesPage getAddSuitesPage() {
		return (addSuitesPage == null) ? addSuitesPage = new AddSuitesPage() : addSuitesPage;
	}
	

	public EditSuitesPage getEditSuitesPage() {
		return (editSuitesPage == null) ? editSuitesPage = new EditSuitesPage() : editSuitesPage;
		
	}
	
	
	public AddIndividualsPage getAddIndividualsPage() {
		return (addIndividualsPage == null) ? addIndividualsPage = new AddIndividualsPage() : addIndividualsPage;
	}
	
	
	public EditIndividualsPage getEditIndividualsPage() {
		return (editIndividualsPage == null) ? editIndividualsPage = new EditIndividualsPage() : editIndividualsPage;
	}
	
	
	public IncidentReportPage getIncidentReportPage() {
		return (incidentReportPage == null) ? incidentReportPage = new IncidentReportPage() : incidentReportPage;
	}
	
	
}
