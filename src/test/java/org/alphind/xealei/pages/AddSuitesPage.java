/** Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.pages;

import java.util.Objects;

import org.alphind.xealei.baseclass.BaseClass;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

public class AddSuitesPage extends BaseClass {

	public AddSuitesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h5[@x-page='suites']")
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

	@FindBy(xpath = "//span[contains(text(), 'Add')]/parent::button")
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

	@FindBy(xpath = "//p[@x-s-avai]/following::div[1]")
	private WebElement occupiedStatus;

	@FindBy(xpath = "//div[@class='col-md-12']")
	private WebElement zeroSearchText;

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

	@FindBy(xpath = "//span[@class='d-block ng-star-inserted']")
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
	private WebElement closepopupYesButton;

	@FindBy(xpath = "//span[contains(text(),'Note:')]")
	private WebElement maxSuiteLimitValMsg;

	public WebElement getmaxSuiteLimitValMsgText() {
		return maxSuiteLimitValMsg;

	}
	
	public WebElement getBtnAddSuites() {
		return btnAddSuites;
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

	/**
	 * Retrieves the text content of the exist suite name.
	 *
	 * @return The text content of the exist suite name.
	 * @author Alphi-MohamedRazul
	 */
	public String getExistSuite() {

		return getText(exitSuites);
	}

	/**
	 * Retrieves the text content of the closed suite popup.
	 *
	 * @return The text content of the closed suite popup.
	 * @author Alphi-MohamedRazul
	 */
	public String getclosePopupContentText() {

		return getText(closePopupContentText);
	}

	/**
	 * Retrieves the name of the suite popup element.
	 *
	 * @return The name of the suite popup element (text).
	 * @author Alphi-MohamedRazul
	 */
	public String getClosePopupSuiteName() {
		return getText(closePopupSuite);
	}

	/**
	 * Retrieves the text content of the zero search message.
	 *
	 * @return The text content of the zero search message.
	 * @author Alphi-MohamedRazul
	 */
	public String getZeroSearchText() {
		return getText(zeroSearchText);
	}

	/**
	 * Retrieves the value of a suite name attribute.
	 * 
	 * @return The value of the suite name attribute.
	 * @author Alphi-MohamedRazul
	 */
	public String getAttributeValueOfSuiteNameField() {

		return getAttribute(suiteName, "value");
	}

	/**
	 * Retrieves the value of a length attribute.
	 * 
	 * @return The value of the length attribute.
	 * @author Alphi-MohamedRazul
	 */
	public String getAttributeValueOfLengthField() {

		return getAttribute(length, "value");
	}

	/**
	 * Retrieves the value of a width attribute.
	 * 
	 * @return The value of the width attribute.
	 * @author Alphi-MohamedRazul
	 */
	public String getAttributeValueOfWidthField() {

		return getAttribute(width, "value");
	}

	/**
	 * Retrieves the value of a height attribute.
	 * 
	 * @return The value of the height attribute.
	 * @author Alphi-MohamedRazul
	 */
	public String getAttributeValueOfHeightField() {

		return getAttribute(height, "value");
	}

	/**
	 * To enter the invalid data in suite search box.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void searchBoxForZeroSearch() {

		sendKeys(suitesSearchBox, "CFGHQW");
		waitForPageLoad();
		backSpace(suitesSearchBox);
	}

	/**
	 * Click on 'Add Suite' button to create suite.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public AddSuitesPage btnAddSuite() {

		click(btnAddSuites);
		return this;
	}

	/**
	 * To enter minimum character in suite name field.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public AddSuitesPage suiteLimit() {

		sendKeys(suiteName, "AB");
		return this;
	}

	/**
	 * To enter the max characters of data in suite name* field based on the data
	 * from the excel.
	 * 
	 * @author Alphi-MohamedRazul
	 * @return The attribute value of the suiteName.
	 */
	public String checkSuiteNameFieldMaxLimit() {

		String inputMoreThan14Char = readExcel("Test Datas", "AddSuites", 1, 7);
		sendKeys(suiteName, inputMoreThan14Char);
		CharSequence subSequence = inputMoreThan14Char.subSequence(0, inputMoreThan14Char.length() - 1);
		return subSequence.toString();
	}

	/**
	 * To enter the max characters of data in Length* field based on the data from
	 * the excel.
	 * 
	 * @author Alphi-MohamedRazul
	 * @return The attribute value of the length.
	 */
	public String checkLengthFieldMaxLimit(int rowNum) {

		String inputMoreThan11Digits = readExcel("Test Datas", "AddSuites", rowNum, 7);
		sendKeys(length, inputMoreThan11Digits);
		CharSequence subSequence = inputMoreThan11Digits.subSequence(0, inputMoreThan11Digits.length() - 1);
		return subSequence.toString();
	}

	/**
	 * To enter the max characters of data in Width* field based on the data from
	 * the excel.
	 * 
	 * @author Alphi-MohamedRazul
	 * @return The attribute value of the width.
	 */
	public String checkWidthFieldMaxLimit(int rowNum) {

		String inputMoreThan11Digits = readExcel("Test Datas", "AddSuites", rowNum, 7);
		sendKeys(width, inputMoreThan11Digits);
		CharSequence subSequence = inputMoreThan11Digits.subSequence(0, inputMoreThan11Digits.length() - 1);
		return subSequence.toString();
	}

	/**
	 * To enter the max characters of data in height* field based on the data from
	 * the excel.
	 * 
	 * @author Alphi-MohamedRazul
	 * @return The attribute value of the height.
	 */
	public String checkHeigthFieldMaxLimit(int rowNum) {

		String inputMoreThan11Digits = readExcel("Test Datas", "AddSuites", rowNum, 7);
		sendKeys(height, inputMoreThan11Digits);
		CharSequence subSequence = inputMoreThan11Digits.subSequence(0, inputMoreThan11Digits.length() - 1);
		return subSequence.toString();
	}

	/**
	 * Click on 'Yes' button
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void yesButton() {

		click(closepopupYesButton);
	}

	/**
	 * Create Suite till the Suite limit is breached.
	 * 
	 * @param rowNum The row number from which to read the data from excel.
	 * @throws Exception If an error occurs during this operation.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void enterSuiteName(int rowNum) throws Exception {
		
		while(true) {
			
			try {
				if(maxSuiteLimitValMsg.isDisplayed()) {
				break;
				}
				
			}catch(NoSuchElementException e){
				
				waitForFullPageElementLoad();
				
				btnAddSuite();
				
				String suiteNameFromExcel = (readExcel("Test Datas", "AddSuites", rowNum, 0) + dateAndTime());
				log(Status.INFO, "Getting suite name data from excel -" + suiteNameFromExcel);
				sendKeys(suiteName, suiteNameFromExcel);
			//	String enteredSN = getAttribute(suiteName, "value");
			//	String writeExcel = writeExcel("Test Datas", "CreatedSuites", 0, enteredSN);
		    //  log(Status.INFO, "Write the created suite in excel -" + writeExcel);
				addButton();
				
				savedSuccessfulToastMsgOkButton();
				
				waitForPageLoad();
				
				continue;
				
	}
		}
	}

	/**
	 * To enter the valid data in suite name* field based on the data from the
	 * specified row number in the Excel sheet..
	 * 
	 * @param rowNum The row number from which to read the data from excel.
	 * @throws Exception If an error occurs during this operation.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public AddSuitesPage suiteName(int rowNum) throws Exception {

		String suiteNameFromExcel = (readExcel("Test Datas", "AddSuites", rowNum, 0) + dateAndTime());
		log(Status.INFO, "Getting suite name data from excel -" + suiteNameFromExcel);
		sendKeys(suiteName, suiteNameFromExcel);
		String enteredSN = getAttribute(suiteName, "value");
		String writeExcel = writeExcel("Test Datas", "CreatedSuites", 0, enteredSN);
		log(Status.INFO, "Write the created suite in excel -" + writeExcel);
		return this;
	}

	/**
	 * To enter the exist data in suite name* field based on the data from the
	 * specified row number in the Excel sheet..
	 * 
	 * @param rowNum The row number from which to read the data from excel. *
	 * @author Alphi-MohamedRazul
	 */
	public AddSuitesPage existSuiteName(int rowNum) {

		String existSuite = getExistSuite();
		writeExcelToOverwrite("Test Datas", "AddSuites", 1, 6, existSuite);
		String duplicateSuiteName = readExcel("Test Datas", "AddSuites", rowNum, 6);
		sendKeys(suiteName, duplicateSuiteName);
		log(Status.INFO, "Getting suite name data from excel -" + duplicateSuiteName);
		return this;
	}

	/**
	 * To enter the valid data in length, width, height fields based on the data
	 * from the specified row number in the Excel sheet..
	 * 
	 * @param rowNum The row number from which to read the data from excel. *
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Check the Non-Mandatory fields are empty or not.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public AddSuitesPage nonMandatoryFieldIsNotEmpty() {

		if (getAttribute(length, "value").isEmpty() && getAttribute(width, "value").isEmpty()
				&& getAttribute(height, "value").isEmpty()) {
			log(Status.FAIL, "Data is NOT entered in Non-Mandatory fields");
		} else {
			log(Status.PASS, "Data is entered in Non-Mandatory fields");
		}
		return this;

	}

	/**
	 * Check the Suite Name* field are empty or not.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public AddSuitesPage suiteNameIsNotEmpty() {

		if (getAttribute(suiteName, "value").isEmpty()) {
			log(Status.FAIL, "Data is NOT entered in Suite Name* field");
		} else {
			log(Status.PASS, "Data is entered in Suite Name* field");
		}
		return this;

	}

	/**
	 * Click on 'Add' button in Suite popup.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public AddSuitesPage addButton() {

		click(btnAdd);
		return this;

	}

	/**
	 * Click on 'x' icon in Suite popup.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void closePopup() {

		click(closePopup);
	}

	/**
	 * Click on Toast message 'OK' button
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void savedSuccessfulToastMsgOkButton() {

		click(btnToastMsgSuccessOk);
	}

	/**
	 * Click on Toast message 'ok' button
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void snAlreadyExistToastMsgOkButton() {

		click(btnToastMsgAlreadyExistOk);
	}

	/**
	 * Click on 'View' button
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void viewButton() {

		click(view);
	}

	/**
	 * Search the mapped suite with individul and check whether the availability
	 * status is changed or not.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 * @throws Exception If an error occurs during this operation.
	 */
	public void toCheckTheSuiteStatusIsChangedOrNot() throws Exception {

		// For Sanity Run
		deleteExistFieldData(suitesSearchBox);

		String createdSuite = readExcelFromLastRow("Test Datas", "CreatedSuites", 0);
		String[] split = createdSuite.split("-");
		String suiteName = split[0];
		String timeStamp = split[1];
		sendKeys(suitesSearchBox, suiteName + "-");
		for (int i = 0; i < timeStamp.length(); i++) {
			char letter = timeStamp.charAt(i);
			String letterAsString = String.valueOf(letter);
			sendKeys(suitesSearchBox, letterAsString);
		}
		waitForPageLoad();
		sleep(5000);
		backSpace(suitesSearchBox);
		int length = createdSuite.length();
		char lastLetter = createdSuite.charAt(length - 1);
		String enterLastLetter = String.valueOf(lastLetter);
		sendKeys(suitesSearchBox, enterLastLetter);
		waitForFullPageElementLoad();
		sleep(3000);
		if (getText(searchCreatedSN).equals(readExcelFromLastRow("Test Datas", "CreatedSuites", 0))) {
			String actSuiteStatus = getText(occupiedStatus).trim();
			String expSuiteStatus = "Occupied";
			if (actSuiteStatus.equals(expSuiteStatus)) {
				log(Status.PASS, "Status " + actSuiteStatus + " is displayed after mapped to Individual");
			} else {
				log(Status.FAIL,
						"Suite status is NOT displayed as expected after mapped to individuals displayed status - "
								+ actSuiteStatus);
			}
		} else {
			log(Status.FAIL, "Searched suite is NOT displayed as expected");
			throw new Exception("Assertion failed searched suite is NOT displayed as expected");
		}
	}

	/**
	 * To enter created suite name in search box.
	 * 
	 * @throws Exception If an error occurs during this operation.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void searchBox() throws Exception {

		// For Sanity Run
		deleteExistFieldData(suitesSearchBox);

		String createdSuite = readExcelFromLastRow("Test Datas", "CreatedSuites", 0);
		String[] split = createdSuite.split("-");
		String suiteName = split[0];
		String timeStamp = split[1];

		sendKeys(suitesSearchBox, suiteName + "-");
		for (int i = 0; i < timeStamp.length(); i++) {
			char letter = timeStamp.charAt(i);
			String letterAsString = String.valueOf(letter);
			sendKeys(suitesSearchBox, letterAsString);
		}
		waitForPageLoad();
		sleep(5000);
		backSpace(suitesSearchBox);
		int length = createdSuite.length();
		char lastLetter = createdSuite.charAt(length - 1);
		String enterLastLetter = String.valueOf(lastLetter);
		sendKeys(suitesSearchBox, enterLastLetter);
		waitForFullPageElementLoad();
		sleep(3000);
		if (getText(searchCreatedSN).equals(readExcelFromLastRow("Test Datas", "CreatedSuites", 0))) {
			waitForFullPageElementLoad();
			sleep(2000);
			click(searchCreatedSN);
			waitForPageLoad();
			log(Status.PASS, "Searched suite is displayed successfully by clicking suite label name");
		} else {
			log(Status.FAIL, "Searched suite is NOT displayed as expected");
			throw new Exception("Assertion failed searched suite is NOT displayed as expected");
		}
	}


	/**
	 * Retrieves the text content of the breadcrumb link.
	 * 
	 * @return The text content of the breadcrumb link.
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public String breadCrumSuiteNameText() {

		String createdSuite = readExcel("Test Datas", "AddSuites", 2, 6);
		BC = BC.replaceAll("createdSN", createdSuite);
		String textString = getTextString(BC);
		return textString;
	}

	/**
	 * Click on (Suite Name) breadcrum text link to return the page.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public void returnToSuitesPageBCText() {

		click(txtRtnToSuitesBreadCrum);
	}

	/**
	 * Delete the length, width, height fields data.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void deleteExistLengthWidthHeightFieldsData() {

		deleteExistFieldData(length);
		deleteExistFieldData(width);
		deleteExistFieldData(height);
	}

	/**
	 * Delete the Suite Name field data.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void deleteExistSuiteNameFieldData() {

		deleteExistFieldData(suiteName);

	}
}