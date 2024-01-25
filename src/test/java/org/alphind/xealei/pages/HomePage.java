package org.alphind.xealei.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import org.alphind.xealei.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		if(Objects.nonNull(this.driver)) {
			this.driver = null;
		}
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
	
	@FindBy(xpath = "//textarea[@formcontrolname='fallDescription']")
	private WebElement alertNotificationDescriptionText;
	
	@FindBy(xpath = "//tbody/tr/td[4]")
	private List<WebElement> dateAndTimeColumn;
	
	private String iminButton = "//tbody/tr[XX]/td[5]/button/span[contains(text(),'in')]";
	
	
	public WebElement getAdminName() {
		return adminName;
	}
	
	

	
	public void reportsModule() {
	
		waitForPageLoad();
        click(ReportsModule);
}
	
	
	
	public void incidentReportModule() {
		
		click(incidentReportModule);
		waitForPageLoad();
}
	
	
	public boolean isHomePageDisplayed() {
		waitForPageLoad();
		if(homePageText.isDisplayed()) {
			return true;
		}
		return false;
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
		waitForInVisiblityOfElement(this.driver,notificationElement, 5);
		click(notificationElement);
		waitForPageLoad(this.driver);
	}
	
	public void fallAlertNotification(String dateandtimeofFall) throws Exception {
		waitForPageLoad(this.driver);
		click(notificationIcon);
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
	public void alert() {
		click(alertNotificationSaveAndroceedToIRButton);
	}
	
	/**
	 * Created by Nandhalala
	 */
	public void alertNotificationFalladioButton() {
		waitForPageLoad(this.driver);
		click(alertNotificationFallRadioButton);
		waitForPageLoad(this.driver);
	}
	
	/**
	 * Created by Nandhalala
	 */
	public void alertNotificationNoFalladioButton() {
		waitForPageLoad(this.driver);
		click(alertNotificationNoFallRadioButton);
		waitForPageLoad(this.driver);
	}
	
	/**
	 * Created by Nandhalala
	 */
	public void alertNotificationDescription() {
		String description = readExcel("Test Datas", "Incident Reports", 1, 29).trim();
		sendKeys(alertNotificationDescriptionText, description);
	}
	
}
