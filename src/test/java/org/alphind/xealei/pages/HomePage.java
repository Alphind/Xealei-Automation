package org.alphind.xealei.pages;

import org.alphind.xealei.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='user-category']")
	private WebElement adminName;
	
	@FindBy(xpath = "//span[@class='navNameClass' and text()='Reports']")
	private WebElement ReportsModule;
	
	@FindBy(xpath = "//span[@class='navNameClass sub-link' and text()='Incident Reports']")
	private WebElement incidentReportModule;
	
	
	
	
	
	
	
	
	
	
	public WebElement getAdminName() {
		return adminName;
	}
	
	
	
	
	
	
	
	
	
	
	public void reportsModule() {
	

	}
}
