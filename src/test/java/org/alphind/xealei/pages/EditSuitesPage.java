/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul, on date

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.pages;

import java.util.Objects;

import org.alphind.xealei.baseclass.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

public class EditSuitesPage extends BaseClass {

	/*
	 * Description - All the Suites Module/Page locators are stored here.
	 * 
	 */

	private WebDriver driver;
	
	public EditSuitesPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	} 

	@FindBy(xpath = "//mat-select[@placeholder='Select Location']")
	private WebElement location;

	@FindBy(xpath = "//input[@placeholder='Enter Length']")
	private WebElement length;

	@FindBy(xpath = "//input[@placeholder='Enter Width ']")
	private WebElement width;

	@FindBy(xpath = "//input[@placeholder='Enter Height']")
	private WebElement height;

	@FindBy(xpath = "//span[contains(text(),'Please Enter Suite Name')]")
	private WebElement validationMsgForSuiteName;
	
	@FindBy(xpath = "//span[contains(text(),'Saved Successfully!!')]")
	private WebElement savedSuccessfullToastMsg;

	@FindBy(xpath = "//span[contains(text(),'Suite Name already exists.')]")
	private WebElement SNExitsToastMsg;

	@FindBy(xpath = "//span[contains(text(),'Suite Name')]")
	private WebElement suiteNameLimit;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement suitesSearchBox;

	@FindBy(xpath = "(//span[@class='btn-txt'])[1]")
	private WebElement searchCreatedSN;
	
//	@FindBy(xpath = "(//span[@class='btn-txt'])[2]")
//	private WebElement searchUpdatedSN;

	@FindBy(xpath = "//img[@class='profile-thumb']")
	private WebElement clickImageInSearchedSN;

	@FindBy(xpath = "(//span[@class='d-block'])[2]")
	private WebElement createdLoc;

	@FindBy(xpath = "(//span[@class='d-block'])[3]")
	private WebElement createdLength;

	@FindBy(xpath = "(//span[@class='d-block'])[4]")
	private WebElement createdWidth;

	@FindBy(xpath = "(//span[@class='d-block'])[5]")
	private WebElement createdHeight;

	@FindBy(xpath = "//span[contains(text(),'Available')]")
	private WebElement suiteAvailability;

	@FindBy(xpath = "//a[contains(text(),'Suites')]")
	private WebElement rtnToSuitesPage;

	@FindBy(xpath = "//span[contains(text(),'ok')]/parent::button")
	private WebElement btnToastMsgSuccessOk;

	@FindBy(xpath = "//span[contains(text(),'OK')]/parent::button")
	private WebElement btnToastMsgAlreadyExistOk;

	@FindBy(xpath = "//button[@type='button']")
	private WebElement closePopup;

	@FindBy(xpath = "//ol[@class='breadcrumb']")
	private WebElement breadCrumLink;

	String BC = "//span[text()='createdSN']/parent::li/parent::ol";

	@FindBy(xpath = "//li[@class='breadcrumb-item']")
	private WebElement txtRtnToSuitesBreadCrum;

	@FindBy(xpath = "//mat-select[@placeholder='Select location']")
	private WebElement locationAvailability;
	
	@FindBy(xpath = "//mat-select[@placeholder='Select location']")
	private WebElement available;
	
	@FindBy(xpath = "//span[text()='Active']")
	private WebElement active;
	
	@FindBy(xpath = "//span[text()='In-Active']")
	private WebElement inActive;

	@FindBy(xpath = "//span[@class='d-block ng-star-inserted']")
	private WebElement checkAvailabilityStatus;
	
	

	String availability = "//span[text()='available']/parent::mat-option";


	@FindBy(xpath = "//span[contains(text(),'Edit')]/parent::button")
	private WebElement btnEditSuite;

	@FindBy(xpath = "//h2[contains(text(),' Edit Suite ')]")
	private WebElement editSuitePopup;

	@FindBy(xpath = "//span[contains(text(),' Update ')]/parent::button")
	private WebElement btnUpdateSuite;

	@FindBy(xpath = "(//span[@class='d-block'])[1]")
	private WebElement createdSN;

	@FindBy(xpath = "//input[@x-as-suitename-inp]")
	private WebElement suiteName;
	
	@FindBy(xpath = "//span[contains(text(),'Suite Name')]")
	private WebElement valMsgForsuiteNameLimit;
	
	@FindBy(xpath = "//span[contains(text(),'Add Suites')]/parent::span/parent::button")
	private WebElement btnAddSuites;
	
	@FindBy(xpath = "(//img[@x-s-usimg])[2]")
	private WebElement existSN;
	
	@FindBy(xpath = "//button[@x-as-save-btn]")
	private WebElement btnAdd; 
	
	@FindBy(xpath = "//span[contains(text(),' View ')]/parent::button")
	private WebElement view;
	
	
	
	
	
	public WebElement getExistSN() {
		return existSN;
	}

	public WebElement getValMsgForsuiteNameLimit() {
		return valMsgForsuiteNameLimit;
	}

	public WebElement getSuiteName() {
		return suiteName;
	}

	public WebElement getEditSuitePopup() {
		return editSuitePopup;
	}
	

	public WebElement getValidationMsgForSuiteName() {
		return validationMsgForSuiteName;
	}


	public WebElement getSavedSuccessfullToastMsg() {
		return savedSuccessfullToastMsg;
	}

	public WebElement getSNExitsToastMsg() {
		return SNExitsToastMsg;
	}

	public WebElement getSuiteNameLimit() {
		return suiteNameLimit;
	}

	public WebElement getSuitesSearchBox() {
		return suitesSearchBox;
	}

	public WebElement getSearchCreatedSN() {
		return searchCreatedSN;
	}

	public WebElement getClickImageInSearchedSN() {
		return clickImageInSearchedSN;
	}

	public WebElement getCreatedLoc() {
		return createdLoc;
	}

	public WebElement getCreatedLength() {
		return createdLength;
	}

	public WebElement getCreatedWidth() {
		return createdWidth;
	}

	public WebElement getCreatedHeight() {
		return createdHeight;
	}

	public WebElement getSuiteAvailability() {
		return suiteAvailability;
	}

	public WebElement getRtnToSuitesPage() {
		return rtnToSuitesPage;
	}

	public WebElement getBtnToastMsgSuccessOk() {
		return btnToastMsgSuccessOk;
	}

	public WebElement getBtnToastMsgAlreadyExistOk() {
		return btnToastMsgAlreadyExistOk;
	}

	public WebElement getClosePopup() {
		return closePopup;
	}

	public WebElement getView() {
		return view;
	}

	public WebElement getBreadCrumLink() {
		return breadCrumLink;
	}

	public String getBC() {
		return BC;
	}

	public WebElement getTxtRtnToSuitesBreadCrum() {
		return txtRtnToSuitesBreadCrum;
	}

	public WebElement getLocationAvailability() {
		return locationAvailability;
	}
	
	public String getAvailability() {
		return availability;
	}

	public WebElement getBtnEditSuite() {
		return btnEditSuite;
	}

	public WebElement getBtnUpdateSuite() {
		return btnUpdateSuite;
	}

	public WebElement getCreatedSN() {
		return createdSN;
	}

	public WebElement getBtnAddSuites() {
		return btnAddSuites;
	}

	public String getCreatedSuite() {
		return createdSuite;
	}

	public WebElement getInActive() {
		return inActive;
	}
	
	public WebElement getActive() {
		return active;
	}

	public WebElement getCheckAvailabilityStatus() {
		return checkAvailabilityStatus;
	}
	
	
	
	

	/*
	 * Description - Below methods helps to perform the Testcase actions for Add
	 * Suites page..
	 * 
	 */
	
	public void editButton() {
		
		waitForPageLoad();
		sleep(3000);
		click(btnEditSuite);
	}
	
	public void searchedSuiteimage() {
		
		click(clickImageInSearchedSN);
	}
	
	public void btnAddSuite() {

		if (btnAddSuites.isDisplayed()) {
			click(btnAddSuites);
			waitForPageLoad();
		} else {
			log(Status.FAIL, "Unable to click Add Suite button");
		}
	}

	public void dataForSuiteLimit() {
		
		sendKeys(suiteName, "AB");
	}
	
	public void updateButton() {
	
		click(btnUpdateSuite);
		waitForPageLoad();
	}
	public void updateSuiteName(int rowNum) {

		String suiteNameFromExcel = (readExcel("Test Datas", "EditSuites", rowNum, 0) + dateAndTime());
		log(Status.INFO, "Getting suite name data from excel -" + suiteNameFromExcel);
		sendKeys(suiteName, suiteNameFromExcel);
	}
	
	public void existSuiteName(int rowNum) {

		String lastCreatedSuite = readExcel("Test Datas", "EditSuites", rowNum, 6);
		log(Status.INFO, "Getting exist suite name data from excel -" + lastCreatedSuite);
		sendKeys(suiteName, lastCreatedSuite);
	}

	
	public void UpdatecreatedSuiteName(int rowNum) {

		String updateNewSN = (readExcel("Test Datas", "EditSuites", rowNum, 0) + dateAndTime());
		log(Status.INFO, "Getting suite name data from excel -" + updateNewSN);
		sendKeys(suiteName, updateNewSN);
		writeExcelToOverwrite("Test Datas", "EditSuites", 2, 6, updateNewSN);
		String writeExcel = writeExcelLastRow("Test Datas", "CreatedSuites", 0, updateNewSN);
		log(Status.INFO, "Write the created suite in excel -" + writeExcel);
	}

		public void updateLengthWidthHeight(int rownum) {

		String lengthData = (readExcel("Test Datas", "EditSuites", rownum, 2));
		String widthData = (readExcel("Test Datas", "EditSuites", rownum, 3));
		String heightData = (readExcel("Test Datas", "EditSuites", rownum, 4));

		log(Status.INFO, "Getting Length data from excel -" + lengthData);
		log(Status.INFO, "Getting Width data from excel -" + widthData);
		log(Status.INFO, "Getting Height data from excel -" + heightData);

		if (Objects.nonNull(lengthData) && !lengthData.equals("")) {
			sendKeys(length, lengthData);
		} else {
			log(Status.INFO, "Length data is empty.");
		}
		if (Objects.nonNull(widthData) && !widthData.equals("")) {
			sendKeys(width, widthData);
		} else {
			log(Status.INFO, "Width data is empty.");
		}
		if (Objects.nonNull(heightData) && !heightData.equals("")) {
			sendKeys(height, heightData);
		} else {
			log(Status.INFO, "Height data is empty.");
		}
	}

	public void addButton() {

		click(btnAdd);
	}

	public void closePopup() {

		click(closePopup);
	}

	public void savedSuccessfulToastMsgOkButton() {

		click(btnToastMsgSuccessOk);
	}

	public void snAlreadyExistToastMsgOkButton() {

		click(btnToastMsgAlreadyExistOk);
	}

	public void viewButton() {

		click(view);
	}

	String createdSuite;

	public void searchBox(int rowNum) throws Exception {

		createdSuite = readExcelFromLastRow("Test Datas", "CreatedSuites",0);
		
		for(int i=0; i<createdSuite.length();i++) {
		
			char letter = createdSuite.charAt(i);
			String valueOf = String.valueOf(letter);
			sendKeys(suitesSearchBox, valueOf);
		}
		waitForPageLoad();
		
		backSpace(suitesSearchBox);
		waitForPageLoad();
		int length = createdSuite.length();
        char lastLetter = createdSuite.charAt(length-1);
        String enterLastLetter = String.valueOf(lastLetter);
		sendKeys(suitesSearchBox, enterLastLetter);
		waitForPageLoad();
		waitForFullPageElementLoad();
		
		if (getText(searchCreatedSN).equals(createdSuite)) {
			click(view);
			log(Status.PASS, "Updated suite is displayed successfully exp updated suite "+createdSuite +" | Act updated suite "+getText(createdSN));
		} else {
			log(Status.FAIL, "Updated suite is NOT displayed as expected exp updated suite "+createdSuite +" | Act updated suite "+getText(createdSN));
			throw new Exception("Assertion failed searched suite is not displayed as expected");
		}
		
		waitForPageLoad();
		
		}
	
	public void createdSuiteLabelName(int rowNum) throws Exception {

		waitForFullPageElementLoad();
		System.out.println("Actual Suite : " + getText(searchCreatedSN));
		System.out.println("Exp Suite : " + readExcelFromLastRow("Test Datas", "CreatedSuites",0));

		if (getText(searchCreatedSN).equals(readExcelFromLastRow("Test Datas", "CreatedSuites",0))) {
			click(searchCreatedSN);
			log(Status.PASS, "Searched suite is displayed successfully by clicking suite label name");
		} else {
			log(Status.FAIL, "Searched suite is not displayed as expected");
			throw new Exception("Assertion failed searched suite is not displayed as expected");
		}
	}

	public String breadCrumSuiteNameText() {

		waitForPageLoad();
		createdSuite = readExcel("Test Datas", "EditSuites", 2, 6);
		BC = BC.replaceAll("createdSN", createdSuite);
		String textString = getTextString(BC);
		return textString;
	}

	public void returnToSuitesPageBCText() {

		click(txtRtnToSuitesBreadCrum);
	}

	public void getExistSuiteName() {
		
		click(existSN);
		waitForPageLoad();
		waitForFullPageElementLoad();
		String SN = getText(suiteName);
		writeExcelLastRow("Test Datas", "UpdatedSuites", 0, SN);
	}
	
	public void availabilityStatus(int rowNum) {
	
		click(available);
		String availableStatus = readExcel("Test Datas", "EditSuites", rowNum, 5);
		availability = availability.replaceAll("available", availableStatus);
		select(availability);
		log(Status.INFO, "Changed the status as In-Active");
	}
	
	public void enterLengthWidthHeight(int rownum) {

		String lengthData = (readExcel("Test Datas", "EditSuites", rownum, 2));
		String widthData = (readExcel("Test Datas", "EditSuites", rownum, 3));
		String heightData = (readExcel("Test Datas", "EditSuites", rownum, 4));

		log(Status.INFO, "Getting Length data from excel -" + lengthData);
		log(Status.INFO, "Getting Width data from excel -" + widthData);
		log(Status.INFO, "Getting Height data from excel -" + heightData);

		if (Objects.nonNull(lengthData) && !lengthData.equals("")) {
			sendKeys(length, lengthData);
		} else {
			log(Status.INFO, "Length data is empty.");
		}
		if (Objects.nonNull(widthData) && !widthData.equals("")) {
			sendKeys(width, widthData);
		} else {
			log(Status.INFO, "Width data is empty.");
		}
		if (Objects.nonNull(heightData) && !heightData.equals("")) {
			sendKeys(height, heightData);
		} else {
			log(Status.INFO, "Height data is empty.");
		}
	}

}	