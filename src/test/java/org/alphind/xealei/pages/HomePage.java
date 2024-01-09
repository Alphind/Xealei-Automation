package org.alphind.xealei.pages;

import org.alphind.xealei.baseclass.BaseClass;
import org.openqa.selenium.By;
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
	
	@FindBy(xpath = "//i[@class = 'nav-link notiicon']")
	private WebElement notificationIcon;
	
	private String idXpath = "//p[contains(text(),'ID')]";
	
	
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
	
	
	public void notificationIcon(String ReportID) {
		click(notificationIcon);
		idXpath = idXpath.replace("ID", ReportID);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement notificationElement = this.driver.findElement(By.xpath(idXpath));
		waitForInVisiblityOfElement(notificationElement, 5);
		click(notificationElement);
		waitForFullPageElementLoad(this.driver);
	}
	
	
}
