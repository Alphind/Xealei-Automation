/** Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.pages;

import java.util.Objects;

import org.alphind.xealei.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

public class AddCommonAreaPage extends BaseClass {

	public AddCommonAreaPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h5[contains(text(),'Common Area')]")
	private WebElement commonAreaPageText;

	@FindBy(xpath = "//span[contains(text(),'Add Common Area')]/parent::span/parent::button")
	private WebElement btnAddCommonArea;

	@FindBy(xpath = "//h2[@x-s-addste]")
	private WebElement headerPopupText;

	@FindBy(xpath = "//h1[contains(text(),'Common')]")
	private WebElement closeCommonAreaPopupHeaderText;

	@FindBy(xpath = "//p[@class='msg-txt']")
	private WebElement closePopupContentText;

	@FindBy(xpath = "//button[@x-s-clic]")
	private WebElement closeAddCommonPopupXIcon;

	@FindBy(xpath = "//input[@placeholder='Enter Common Area Name']")
	private WebElement commonAreaNameTxtbox;

	@FindBy(xpath = "//input[@placeholder='Enter Length']")
	private WebElement length;

	@FindBy(xpath = "//input[@placeholder='Enter Width ']")
	private WebElement width;

	@FindBy(xpath = "//input[@placeholder='Enter Height']")
	private WebElement height;

	@FindBy(xpath = "//button[@x-as-save-btn]")
	private WebElement btnAdd;

	@FindBy(xpath = "//span[contains(text(),'Common area name must be minimum 3 characters')]")
	private WebElement checkLimitInfoMsgUnderIncommonAreaTextbox;

	@FindBy(xpath = "//span[contains(text(),'Please enter common area name')]")
	private WebElement validationInfoMsgForCommonAreaNameField;

	@FindBy(xpath = "//span[contains(text(),'Saved Successfully!!')]")
	private WebElement savedSuccessfullToastMsg;

	@FindBy(xpath = "//span[contains(text(),'Common Area Name already exists')]")
	private WebElement CANExitsToastMsg;

	@FindBy(xpath = "(//h1[@class='title1'])[1]")
	private WebElement existCommonAreaName;

	@FindBy(xpath = "//span[contains(text(),'ok')]/parent::button")
	private WebElement btnToastMsgSuccessOk;

	@FindBy(xpath = "//span[contains(text(),'OK')]/parent::button")
	private WebElement btnToastMsgAlreadyExistOk;

	@FindBy(xpath = "//span[contains(text(),'Yes')]/parent::button")
	private WebElement closePopupYesButton;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement commonAreaNameSearchBox;

	@FindBy(xpath = "(//h1[@class='title1'])[1]")
	private WebElement createdCommonArea;

	@FindBy(xpath = "//button[@x-s-view]")
	private WebElement viewButton;

	@FindBy(xpath = "(//span[@class='d-block'])[1]")
	private WebElement createdCommonAreaData;

	@FindBy(xpath = "(//span[@class='d-block'])[2]")
	private WebElement defaultLocationNameData;

	@FindBy(xpath = "(//span[@class='d-block'])[3]")
	private WebElement createdLengthData;

	@FindBy(xpath = "(//span[@class='d-block'])[4]")
	private WebElement createdWidthData;

	@FindBy(xpath = "(//span[@class='d-block'])[5]")
	private WebElement createdHeightData;

	@FindBy(xpath = "//ol[@class='breadcrumb']")
	private WebElement breadCrumLink;

	String BC = "//span[text()='createdCAN']/parent::li/parent::ol";

	@FindBy(xpath = "//li[@class='breadcrumb-item']")
	private WebElement txtRtnToCommonAreaBreadCrum;

	public WebElement getCreatedCommonAreaData() {
		return createdCommonAreaData;
	}

	public WebElement getCommonAreaNameTxtbox() {
		return commonAreaNameTxtbox;
	}

	public WebElement getCheckLimitInfoMsgUnderIncommonAreaTextbox() {
		return checkLimitInfoMsgUnderIncommonAreaTextbox;
	}

	public WebElement getCANExitsToastMsg() {
		return CANExitsToastMsg;
	}

	public WebElement getValidationInfoMsgForCommonAreaNameField() {
		return validationInfoMsgForCommonAreaNameField;
	}

	public WebElement getBtnAddCommonArea() {
		return btnAddCommonArea;
	}

	public WebElement getSavedSuccessfullToastMessage() {
		return savedSuccessfullToastMsg;
	}

	/**
	 * Retrieves the text content of the breadcrumb link.
	 * 
	 * @return The text content of the breadcrumb link.
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public String getBreadCrumLinkText() {
		return getText(breadCrumLink);
	}

	/**
	 * Retrieves the text content of the created common area name.
	 * 
	 * @return The text content of the created common area name.
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public String getCreatedCommonAreaNameDataText() {
		return getText(createdCommonAreaData);
	}

	/**
	 * Retrieves the text content of the default location in common area page.
	 * 
	 * @return The text content of the default location in common area page.
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public String getCommonAreaDefaultLocationDataText() {
		return getText(defaultLocationNameData);
	}

	/**
	 * Retrieves the text content of the created length in common area page.
	 * 
	 * @return The text content of the created length in common area page.
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public String getCreatedLengthDataText() {
		return getText(createdLengthData);
	}

	/**
	 * Retrieves the text content of the created width in common area page.
	 * 
	 * @return The text content of the created width in common area page.
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public String getCreatedWidthDataText() {
		return getText(createdWidthData);
	}

	/**
	 * Retrieves the text content of the created height in common area page.
	 * 
	 * @return The text content of the created height in common area page.
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public String getCreatedHeightDataText() {
		return getText(createdHeightData);
	}

	/**
	 * Retrieves the text content of the common area page.
	 * 
	 * @return The text content of the common area page.
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public String getCommonAreaPageText() {
		return getText(commonAreaPageText);
	}

	/**
	 * Retrieves the text header content of the common area popup
	 * 
	 * @return The text header content of the common area popup
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public String getHeaderPopupText() {
		return getText(headerPopupText);
	}

	/**
	 * Retrieves the text content of the closed common area popup
	 * 
	 * @return The text header content of the closed common area popup
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public String getClosePopupContentText() {
		return getText(closePopupContentText);
	}

	/**
	 * Retrieves the text header content of the close common area popup
	 * 
	 * @return The text header content of the close common area popup
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public String getCloseCommonAreaPopupHeaderText() {
		return getText(closeCommonAreaPopupHeaderText);
	}

	/**
	 * Click on Add Common Area Button.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public AddCommonAreaPage addCommonAreaButton() {

		waitForElementToBeClickable(btnAddCommonArea, 10);
		click(btnAddCommonArea);
		return this;
	}

	/**
	 * To enter minimum value of data in Common Area Name* field.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public AddCommonAreaPage checkLimitIncommonAreaTextbox() {

		sendKeys(commonAreaNameTxtbox, "AB");
		return this;
	}

	/**
	 * Click on Add Button in Add Common Area popup page.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public AddCommonAreaPage addButtonInCommenAreaPopup() {

		sleep(2000);
		if (btnAdd.isEnabled()) {
			click(btnAdd);
		}
		return this;
	}

	/**
	 * To enter exist common area name in Common Area Name* fieldbased on the data from the specified row number in the Excel sheet.
	 * @param rowNum The row number from which to read the data.
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public AddCommonAreaPage existCommonAreaName(int rowNum) {

		String existCommonArea = getExistCommonAreaName();
		writeExcelToOverwrite("Test Datas", "AddCommonArea", 1, 6, existCommonArea);
		String duplicateCommonArea = readExcel("Test Datas", "AddCommonArea", rowNum, 6);
		sendKeys(commonAreaNameTxtbox, duplicateCommonArea);
		log(Status.INFO, "Getting suite name data from excel -" + duplicateCommonArea);
		return this;
	}

	/**
	 * Click on "Saved Successfull!!" Toast Message [ok] button
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public void savedSuccessfulToastMsgOkButton() {

		click(btnToastMsgSuccessOk);
	}

	/**
	 * Click on (Duplicate Name) Toast Message [OK] button
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public void alreadyExistToastMsgOkButton() {

		click(btnToastMsgAlreadyExistOk);
	}

	/**
	 * To enter valid data in length, width, and height fields.
	 * 
	 * @param rownum The row number where the data will be taken.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public AddCommonAreaPage enterLengthWidthHeight(int rownum) {

		String lengthData = (readExcel("Test Datas", "AddCommonArea", rownum, 2));
		String widthData = (readExcel("Test Datas", "AddCommonArea", rownum, 3));
		String heightData = (readExcel("Test Datas", "AddCommonArea", rownum, 4));

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
	 * Check whether the Non-Mandatory fields are empty or not.
	 * 
	 * @returns false if non-mandatory fields are not empty or else it returns true.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public AddCommonAreaPage nonMandatoryFieldIsNotEmpty() {

		if (getAttribute(length, "value").isEmpty() && getAttribute(width, "value").isEmpty()
				&& getAttribute(height, "value").isEmpty()) {
			log(Status.FAIL, "Data is NOT entered in Non-Mandatory fields");
		} else {
			log(Status.PASS, "Data is entered in Non-Mandatory fields");
		}
		return this;

	}

	/**
	 * Check whether the Mandatory* field is empty or not.
	 * 
	 * @returns false if mandatory* field is not empty or else it returns true.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public AddCommonAreaPage mandatoryFieldIsNotEmpty() {

		if (getAttribute(commonAreaNameTxtbox, "value").isEmpty()) {
			log(Status.FAIL, "Data is NOT entered in Mandatory field");
		} else {
			log(Status.PASS, "Data is entered in Mandatory field");
		}
		return this;

	}

	/**
	 * Click on close icon [x] in common area popup
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public void closePopupXIcon() {

		click(closeAddCommonPopupXIcon);
	}

	/**
	 * To enter valid data in Common Area Name* field
	 * 
	 * @param rowNum The row number where the new data will be written.
	 * @throws Exception If there is an error while retrieving the current URL.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public AddCommonAreaPage commonAreaName(int rowNum) throws Exception {

		String commonAreaNameFromExcel = (readExcel("Test Datas", "AddCommonArea", rowNum, 0) + dateAndTime());
		log(Status.INFO, "Getting suite name data from excel -" + commonAreaNameFromExcel);
		sendKeys(commonAreaNameTxtbox, commonAreaNameFromExcel);
		String enteredData = getAttribute(commonAreaNameTxtbox, "value");
		String writeExcel = writeExcel("Test Datas", "CreatedCommonArea", 0, enteredData);
		log(Status.INFO, "Write the created suite in excel -" + writeExcel);
		return this;
	}

	/**
	 * Click on "Yes" button in common area popup
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public void yesButton() {

		click(closePopupYesButton);
	}

	/**
	 * Retrieves the text content of the existing common area name.
	 *
	 * @return The text content of the existing common area name.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public String getExistCommonAreaName() {

		return getText(existCommonAreaName);

	}

	String createdSuite;

	/**
	 * Performs a search operation in the search box.
	 *
	 * @throws Exception If an error occurs during the search operation.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void searchBox() throws Exception {

		// For Sanity Run
		deleteExistFieldData(commonAreaNameSearchBox);

		String createdSuite = readExcelFromLastRow("Test Datas", "CreatedCommonArea", 0);
		String[] split = createdSuite.split("-");
		String suiteName = split[0];
		String timeStamp = split[1];

		sendKeys(commonAreaNameSearchBox, suiteName + "-");
		for (int i = 0; i < timeStamp.length(); i++) {
			char letter = timeStamp.charAt(i);
			String letterAsString = String.valueOf(letter);
			sendKeys(commonAreaNameSearchBox, letterAsString);
		}
		sleep(5000);
		backSpace(commonAreaNameSearchBox);
		int length = createdSuite.length();
		char lastLetter = createdSuite.charAt(length - 1);
		String enterLastLetter = String.valueOf(lastLetter);
		sendKeys(commonAreaNameSearchBox, enterLastLetter);
		waitForFullPageElementLoad();

		if (getText(createdCommonArea).equals(readExcelFromLastRow("Test Datas", "CreatedCommonArea", 0))) {
			viewButton();
			waitForPageLoad();
			log(Status.PASS, "Searched Common Area is displayed successfully by clicking Common Area label name");
		} else {
			log(Status.FAIL, "Searched Common Area is NOT displayed as expected");
			throw new Exception("Assertion failed searched Common Area is NOT displayed as expected");
		}
	}

	/**
	 * Click on "view" button in common area view page.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public void viewButton() {

		click(viewButton);
	}

	/**
	 * Retrieves the text content of the breadcrumb link.
	 * 
	 * @return The text content of the breadcrumb link.
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public String commonAreaNameBCText() {

		String createdCommonArea = readExcel("Test Datas", "AddCommonArea", 2, 6);
		BC = BC.replaceAll("createdCAN", createdCommonArea);
		String textString = getTextString(BC);
		return textString;
	}

	/**
	 * Click on (Common Area Name) breadcrum text link to return the page.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public void returnToCommonAreaPageBCText() {

		waitForElementToBeClickable(txtRtnToCommonAreaBreadCrum, 5);
		click(txtRtnToCommonAreaBreadCrum);
	}

	/**
	 * Verifies if the view button is displayed or not.
	 * 
	 * @returns true if view button is displayed or else it returns false.
	 *
	 * @author Alphi-MohamedRazul
	 */
	public boolean isViewButtonisDisplayed() {

		if (viewButton.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * To enter max character in Common Area Name* field.
	 * 
	 * @return The max character.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public String checkCommonAreaNameFieldMaxLimit() {

		String inputMoreThan14Char = readExcel("Test Datas", "AddSuites", 1, 7);
		sendKeys(commonAreaNameTxtbox, inputMoreThan14Char);
		CharSequence subSequence = inputMoreThan14Char.subSequence(0, inputMoreThan14Char.length() - 1);
		return subSequence.toString();
	}

}
