package org.alphind.xealei.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import org.alphind.xealei.baseclass.BaseClass;
import org.apache.commons.exec.LogOutputStream;
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
	
	@FindBy(xpath = "//mat-icon[contains(text(),'logout')]/parent::div/parent::button")
	private WebElement logoutButton;

	@FindBy(xpath = "//span[contains(text(),'Occ')]")
	private WebElement occupancyZone;
	
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
	
	private String fallAlertXpath = "(//h1[text() = 'Fall Alert! ']/following-sibling::div)[XX]";
	
	@FindBy(xpath = "//h1[text() = 'Fall Alert! ']/following-sibling::div")
	private List<WebElement> fallAlerts;
	
	@FindBy(xpath = "//span[contains(text(),'Save & Proceed to IR')]/parent::button")
	private WebElement alertNotificationSaveAndroceedToIRButton;
	
	@FindBy(xpath = "//span[contains(text(),'Confirm')]/parent::button")
	private WebElement alertNotificationConfirmButton;
	
	@FindBy(xpath = "//div[text() = 'Fall']/parent::label/parent::mat-radio-button")
	private WebElement alertNotificationFallRadioButton;
	
	@FindBy(xpath = "//div[text() = 'No Fall']/parent::label/parent::mat-radio-button")
	private WebElement alertNotificationNoFallRadioButton;
	
	@FindBy(xpath = "//mat-select[@formcontrolname='noFallReason']")
	private WebElement noFallReasonDropDown;
	
	private String dropdownOption = "//span[@class = 'mat-option-text' "
			+ "and contains(text(),'XX')]";
	
	@FindBy(xpath = "//textarea[@formcontrolname='fallDescription']")
	private WebElement alertNotificationDescriptionText;
	
	@FindBy(xpath = "//tbody/tr/td[4]")
	private List<WebElement> dateAndTimeColumn;
	
	private String iminButton = "//tbody/tr[XX]/td[5]/button/span[contains(text(),'in')]";
	
	private String eventValue = "//tbody/tr[XX]/td[3]/div/span";
	
	@FindBy(xpath = "(//h1[contains(text(),'Fall Alert!')])[1]/following::button[1]")
	private WebElement firstFallAlert;
	


	
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
	
	public WebElement getAdminName() {
		return adminName;
	}
	
	public HomePage adminName() {
		
		click(adminName);
		return this;
	}
	
	
	public void logout() {
	
		click(logoutButton);
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

		waitForPageLoad(this.driver);
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
		waitForPageLoad(this.driver);
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
	 * Check whether the 'Occupancy Zone' page is displayed
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @created on 15/02/2024
	 * 
	 */
	public HomePage navToOccupancyZoneModule() {

		if (occupancyZone.isDisplayed()) {
			click(occupancyZone);
		} else {
			log(Status.FAIL, "Unable to click the Occupancy Zone Module");
		}
		return this;
	}

	
	/**
	 * Check whether the 'Individual' page is displayed
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public void navToIndividualsModule() {
		
		if (individualsModule.isDisplayed()) {
			waitForFullPageElementLoad();
			click(individualsModule);
			waitForPageLoad();
		} else {
			log(Status.FAIL, "Unable to click the Individual Module");
		}
	}

	public void notificationIcon(String ReportID) {
		waitForPageLoad(this.driver);
		sleep(6000);
		click(notificationIcon);
		waitForFullPageElementLoad(this.driver);
		
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

	
	public void fallAlertNotification(String dateandtimeofFall) throws Exception {
		waitForPageLoad(this.driver);
		click(notificationIcon);
		sleep(2000);
		List<String> fallAlertTexts = new ArrayList<String>();
		int count = 0;
		for(WebElement alert : fallAlerts) {
			fallAlertTexts.add(alert.getText());
		}
		if(Objects.isNull(fallAlertTexts)) {
			throw new Exception("No Fall alert found.");
		}
		for(String falltime : fallAlertTexts) {
			++count;
			if(falltime.contains(dateandtimeofFall)) {
				break;
			}
		}
		fallAlertXpath =fallAlertXpath.replaceAll("XX", String.valueOf(count));
		click(this.driver.findElement(By.xpath(fallAlertXpath)));
	}
	

	
//	public void firstFallAlertNotification() throws Exception {
//		waitForPageLoad(this.driver);
//		click(notificationIcon);
//		sleep(2000);
////		List<String> fallAlertTexts = new ArrayList<String>();
////		int count = 0;
////		for(WebElement alert : fallAlerts) {
////			fallAlertTexts.add(alert.getText());
////		}
////		if(Objects.isNull(fallAlertTexts)) {
////			throw new Exception("No Fall alert found.");
////		}
////		for(String falltime : fallAlertTexts) {
////			++count;
////			if(falltime.contains(dateandtimeofFall)) {
////				break;
////			}
////		}
////		fallAlertXpath =fallAlertXpath.replaceAll("XX", String.valueOf(count));
////		click(this.driver.findElement(By.xpath(fallAlertXpath)));
//		
//		click(firstFallAlert);
		

	public void firstFallAlertNotification() throws Exception {
		waitForPageLoad(this.driver);
		click(notificationIcon);
		waitForPageLoad(this.driver);
		sleep(7000);
		click(firstFallAlert);

	}
	
	
	/**
	 * created by Nandhalala
	 * @throws Exception 
	 */
	public void fallAlertFromGrid(String dateandtimeofFall) throws Exception {
		List<String> dateAndTime = new ArrayList<String>();
		for(WebElement dateandtime : dateAndTimeColumn) {
			dateAndTime.add(dateandtime.getText());
		}
		int count = 0;
		boolean flag = false;
		for(String datetime : dateAndTime) {
			++count;
			//if(Pattern.compile(Pattern.quote(""), Pattern.CASE_INSENSITIVE).matcher("").find());

			if(Pattern.compile(dateandtimeofFall, Pattern.CASE_INSENSITIVE).matcher(datetime).find()) {
				flag = true;
				break;
			}
		}
		if(flag) {
			iminButton = iminButton.replaceAll("XX", String.valueOf(count));
			click(this.driver.findElement(By.xpath(iminButton)));
		}
		else {
			throw new Exception("Time not found");
		}
		
	}
	
	/**
	 * Created by Nandhalala
	 */
	public void saveandproccedtoTR() {
		click(alertNotificationSaveAndroceedToIRButton);
		waitForPageLoad(this.driver);
	}
	
	/**
	 * Created by Nandhalala
	 */
	public void alertConfirmButton() {
		click(alertNotificationConfirmButton);
		waitForPageLoad(this.driver);
	}
	
	/**
	 * Created by Nandhalala
	 */
	public void alert() {
		click(alertNotificationSaveAndroceedToIRButton);
	}
	
	/**
	 * Created by Nandhalala
	 */
	public void alertNotificationFallRadioButton() {
		waitForPageLoad(this.driver);
		click(alertNotificationFallRadioButton);
		waitForPageLoad(this.driver);
	}
	
	/**
	 * Created by Nandhalala
	 */
	public void alertNotificationNoFallRadioButton() {
		waitForPageLoad(this.driver);
		click(alertNotificationNoFallRadioButton);
		waitForPageLoad(this.driver);
	}
	
	/**
	 * Created by Nandhalala
	 */
	public void alertNotificationSelectNoFallReason() {
		waitForPageLoad(this.driver);
		click(noFallReasonDropDown);
		waitForPageLoad(this.driver);
		String noFallReason = readExcel("Test Datas", "Incident Reports", 1, 33).trim();
		String noFallReasonXpath = dropdownOption.replaceAll("XX", noFallReason);
		click(this.driver.findElement(By.xpath(noFallReasonXpath)));
	}
	
	/**
	 * Created by Nandhalala
	 */
	public String firstEventTextInGrid() {
		waitForPageLoad(this.driver);
		String noFallReasonXpath = eventValue.replaceAll("XX", "1");
		return getTextString(noFallReasonXpath).trim();
	}
	
	/**
	 * Created by Nandhalala
	 */
	public void alertNotificationDescription() {
		String description = readExcel("Test Datas", "Incident Reports", 1, 29).trim();
		sendKeys(alertNotificationDescriptionText, description);
	}
	
	/**
	 * Created by Nandhalala
	 */
	public void alertNotificationNoFallDescription() {
		String description = readExcel("Test Datas", "Incident Reports", 1, 34).trim();
		sendKeys(alertNotificationDescriptionText, description);
	}
	
	

}
