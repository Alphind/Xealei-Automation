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

public class AddSuitesPage extends BaseClass {

	/*
	 * Description - All the Suites Module/Page locators are stored here.
	 * 
	 */
	private WebDriver driver;
	
	public AddSuitesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(xpath = "//h5[contains(text(),'Suites')]")
	private WebElement suitesPage;

	@FindBy(xpath = "//span[contains(text(),'Add Suites')]/parent::span/parent::button")
	private WebElement btnAddSuites;

	@FindBy(xpath = "//h2[contains(text(),'Add Suite')]")
	private WebElement addSuitePopupText;
	
	@FindBy(xpath = "//p[@class='msg-txt']")
	private WebElement closePopupContentText;
	
	@FindBy(xpath = "//h1[contains(text(),' Suite')]")
	private WebElement closePopupSuite;
	
	@FindBy(xpath = "//input[@placeholder='Enter Suite Name']")
	private WebElement suiteName;

	@FindBy(xpath = "//input[@placeholder='Enter Length']")
	private WebElement length;

	@FindBy(xpath = "//input[@placeholder='Enter Width ']")
	private WebElement width;
	
	@FindBy(xpath = "//input[@placeholder='Enter Height']")
	private WebElement height;

	@FindBy(xpath = "//button[@x-as-save-btn]")
	private WebElement btnAdd; 

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

	@FindBy(xpath = "//span[@class='btn-txt']")
	private WebElement searchCreatedSN;

	@FindBy(xpath = "//span[contains(text(),' View ')]/parent::button")
	private WebElement view;

	@FindBy(xpath = "//img[@class='profile-thumb']")
	private WebElement clickImageInSearchedSN;

	@FindBy(xpath = "(//span[@class='d-block'])[2]")
	private WebElement defaultLocationName;

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

	@FindBy(xpath = "//span[text()=' View ']")
	private WebElement btnView;

	@FindBy(xpath = "//ol[@class='breadcrumb']")
	private WebElement breadCrumLink;

	String BC = "//span[text()='createdSN']/parent::li/parent::ol";

	@FindBy(xpath = "//li[@class='breadcrumb-item']")
	private WebElement txtRtnToSuitesBreadCrum;

	@FindBy(xpath = "(//span[@class='d-block'])[1]")
	private WebElement createdSN;
	
	@FindBy(xpath = "//button[@mat-raised-button]")
	private WebElement EditSuite;

	@FindBy(xpath = "(//span[@class='btn-txt'])[1]")
	private WebElement exitSuites;
	
	@FindBy(xpath = "//span[contains(text(),'Yes')]/parent::button")
	private WebElement closepopupButtonIsEnabled;
	
	
	
	
	public String getExistSuite() {
	
		return getText(exitSuites);

	}
	
	public String getclosePopupContentText() {
		
		return getText(closePopupContentText);
	}
	
	
	public WebElement getBtnAddSuites() {
		return btnAddSuites;
	}
	
	public String getClosePopupSuiteName() {
		return getText(closePopupSuite);
	}

	public WebElement getBtnAdd() {
		return btnAdd;
	}

	public WebElement getSuiteName() {
		return suiteName;
	}

	public WebElement getLength() {
		return length;
	}
	
	public WebElement getWidth() {
		return width;
	}

	public WebElement getHeight() {
		return height;
	}
	
	public WebElement getActToastMsg() {
		return savedSuccessfullToastMsg;
	}

	public WebElement getSuitesSearchBox() {
		return suitesSearchBox;
	}

	public WebElement getSearchCreatedSN() {
		return searchCreatedSN;
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

	public WebElement getSuiteNameLimit() {
		return suiteNameLimit;
	}

	public WebElement getView() {
		return view;
	}

	public WebElement getSuitesPage() {
		return suitesPage;
	}

	public WebElement getAddSuitePopupText() {
		return addSuitePopupText;
	}

	public WebElement getValidationMsgForSuiteName() {
		return validationMsgForSuiteName;
	}

	public WebElement getSavedSuccessfullToastMessage() {
		return savedSuccessfullToastMsg;
	}

	public WebElement getSNExitsToastMsg() {
		return SNExitsToastMsg;
	}

	public WebElement getCreatedSuiteName() {
		return createdSN;
	}

	public WebElement getDefaultLocationName() {
		return defaultLocationName;
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

	public WebElement getBreadCrumLink() {
		return breadCrumLink;
	}

	public WebElement getTxtRtnToSuitesBreadCrum() {
		return txtRtnToSuitesBreadCrum;
	}

	public WebElement getClickViewBtn() {
		return view;
	}

	
	/*
	 * Description - Below methods helps to perform the Testcase actions for Add
	 * Suites page..
	 * 
	 */


	public AddSuitesPage btnAddSuite() {

			click(btnAddSuites);
			return this;
	}

	public AddSuitesPage suiteLimit() {
		
		sendKeys(suiteName, "AB");
		return this;
	}
	
	public void yesButton() {
		
		click(closepopupButtonIsEnabled);
	}
	
	public AddSuitesPage enterSuiteName(int rowNum) throws Exception{

		String suiteNameFromExcel = (readExcel("Test Datas", "AddSuites", rowNum, 0) + dateAndTime());
		log(Status.INFO, "Getting suite name data from excel -" + suiteNameFromExcel);
		sendKeys(suiteName, suiteNameFromExcel);
		return this;
	}

	public AddSuitesPage suiteName(int rowNum) throws Exception {

		String suiteNameFromExcel = (readExcel("Test Datas", "AddSuites", rowNum, 0) + dateAndTime());
		log(Status.INFO, "Getting suite name data from excel -" + suiteNameFromExcel);
		sendKeys(suiteName, suiteNameFromExcel);
		String enteredSN = getAttribute(suiteName, "value");
		String writeExcel = writeExcel("Test Datas", "CreatedSuites", 0, enteredSN);
		log(Status.INFO, "Write the created suite in excel -" + writeExcel);
		return this;
	}

	public AddSuitesPage existSuiteName(int rowNum) {
		
		String existSuite = getExistSuite();
		writeExcelToOverwrite("Test Datas", "AddSuites", 1, 6, existSuite);
		String duplicateSuiteName = readExcel("Test Datas", "AddSuites", rowNum, 6);
		sendKeys(suiteName, duplicateSuiteName);
		log(Status.INFO, "Getting suite name data from excel -" + duplicateSuiteName);
		return this;
	}


	public AddSuitesPage enterLengthWidthHeight(int rownum) {

		String lengthData = (readExcel("Test Datas", "AddSuites", rownum, 2));
		String widthData = (readExcel("Test Datas", "AddSuites", rownum, 3));
		String heightData = (readExcel("Test Datas", "AddSuites", rownum, 4));

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
		return this;
	}

	public AddSuitesPage nonMandatoryFieldIsNotEmpty() {
	
		if(getAttribute(length,"value").isEmpty() && getAttribute(width,"value").isEmpty() && getAttribute(height,"value").isEmpty()) {
			log(Status.FAIL, "Data is NOT entered in Non-Mandatory fields");
		} else {
			log(Status.PASS, "Data is entered in Non-Mandatory fields");
		}
		return this;

	}
	
	public AddSuitesPage addButton() {

		click(btnAdd);
		return this;
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

	

	public void searchBox() throws Exception {

		String createdSuite = readExcelFromLastRow("Test Datas", "CreatedSuites", 0);
		String[] split = createdSuite.split("-");
		String suiteName = split[0];
		String timeStamp = split[1];
		sendKeys(suitesSearchBox, suiteName+"-");
		for (int i = 0; i < timeStamp.length(); i++) {
			char letter = timeStamp.charAt(i);
			String letterAsString = String.valueOf(letter);
			sendKeys(suitesSearchBox, letterAsString);
		}
		waitForPageLoad();
		sleep(5000);
		backSpace(suitesSearchBox);
		int length = createdSuite.length();
        char lastLetter = createdSuite.charAt(length-1);
        String enterLastLetter = String.valueOf(lastLetter);
		sendKeys(suitesSearchBox, enterLastLetter);
		waitForFullPageElementLoad();
		
		if (getText(searchCreatedSN).equals(readExcelFromLastRow("Test Datas", "CreatedSuites",0))) {
			click(searchCreatedSN);
			waitForPageLoad();
			log(Status.PASS, "Searched suite is displayed successfully by clicking suite label name");
		} else {
			log(Status.FAIL, "Searched suite is not displayed as expected");
			throw new Exception("Assertion failed searched suite is not displayed as expected");
		}
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

		String createdSuite = readExcel("Test Datas", "AddSuites", 2, 6);
		BC = BC.replaceAll("createdSN", createdSuite);
		String textString = getTextString(BC);
		return textString;
	}

	public void returnToSuitesPageBCText() {

		click(txtRtnToSuitesBreadCrum);
	}

	
	
	
}