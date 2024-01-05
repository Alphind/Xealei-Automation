package org.alphind.xealei.pages;

import org.alphind.xealei.baseclass.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='user-category']")
	private WebElement adminName;
	
	@FindBy(xpath = "//span[contains(text(),'Reports')]")
	private WebElement ReportsModule;
	
	@FindBy(xpath = "//span[contains(text(),'Incident Reports')]")
	private WebElement incidentReportModule;
	
	@FindBy(xpath = "//h5[text()=' Home ']")
	private WebElement homePageText;
	
	
	
	
	
	public WebElement getAdminName() {
		return adminName;
	}
	
	

	
	public void reportsModule() {
	
		waitForPageLoad();
        click(ReportsModule);
}
	
	
	
	public void incidentReportModule() {
		
		click(incidentReportModule);
}
	
	
	public boolean isHomePageDisplayed() {
		waitForPageLoad();
		if(homePageText.isDisplayed()) {
			return true;
		}
		return false;
	}
	
	
	
}
