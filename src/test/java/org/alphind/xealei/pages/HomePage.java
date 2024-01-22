package org.alphind.xealei.pages;

import java.util.Objects;

import org.alphind.xealei.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

public class HomePage extends BaseClass {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		if (Objects.nonNull(this.driver)) {
			this.driver = null;
		}
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='user-category']")
	private WebElement adminName;

	@FindBy(xpath = "//span[contains(text(),'Suites')]/parent::a")
	private WebElement suitesModule;

	@FindBy(xpath = "//span[contains(text(),'Individuals')]")
	private WebElement individualsModule;

	@FindBy(xpath = "//span[contains(text(),'Reports')]")
	private WebElement ReportsModule;

	@FindBy(xpath = "//span[contains(text(),'Incident Reports')]")
	private WebElement incidentReportModule;

	@FindBy(xpath = "//h5[text()=' Home ']")
	private WebElement homePageText;

	@FindBy(xpath = "//i[@class = 'nav-link notiicon']")
	private WebElement notificationIcon;

	private String idXpath = "//p[contains(text(),'ID')]";

	/**
	 * Get the login user name (text) in Home Page.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @return login user name (text).
	 */
	public String getAdminNameText() {
		return getText(adminName);
	}

	/**
	 * Get the Home page Module (text) in Home Page.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @return Home page (text).
	 */
	public String HomeText() {
		return getText(homePageText);
	}

	/**
	 * Click the Report Module.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public void navToReportsModule() {

		waitForPageLoad();
		click(ReportsModule);
	}

	/**
	 * Click the Report Module.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public void navToIncidentReportModule() {

		click(incidentReportModule);
		waitForPageLoad();
	}

	/**
	 * Check whether the 'Home' page is displayed
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public boolean isHomePageDisplayed() {
		waitForPageLoad();
		if (homePageText.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Check whether the 'Suite' page is displayed
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public void navToSuitesModule() {

		if (suitesModule.isDisplayed()) {
			click(suitesModule);
			waitForPageLoad();
		} else {
			log(Status.FAIL, "Unable to click the Suites Module");
		}
	}

	/**
	 * Check whether the 'Individual' page is displayed
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public void navToIndividualsModule() {
		if (individualsModule.isDisplayed()) {
			click(individualsModule);
			waitForPageLoad();
		} else {
			log(Status.FAIL, "Unable to click the Individual Module");
		}
	}

	public void notificationIcon(String ReportID) {
		waitForPageLoad(this.driver);
		click(notificationIcon);
		idXpath = idXpath.replace("ID", ReportID);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement notificationElement = this.driver.findElement(By.xpath(idXpath));
		waitForInVisiblityOfElement(this.driver, notificationElement, 5);
		click(notificationElement);
		waitForPageLoad(this.driver);
	}

}
