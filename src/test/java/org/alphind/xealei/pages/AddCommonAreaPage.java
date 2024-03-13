package org.alphind.xealei.pages;

import java.util.Objects;

import org.alphind.xealei.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

public class AddCommonAreaPage extends BaseClass {
	
	public AddCommonAreaPage() {
		PageFactory.initElements(driver,this);
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
	
	@FindBy(xpath = "//h1[@class='title1']")
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
	
	public String getBreadCrumLinkText() {
		return getText(breadCrumLink);
	}
	
	
	public String getCreatedCommonAreaNameDataText() {
		return getText(createdCommonAreaData);
	}
	public String getCommonAreaDefaultLocationDataText() {
		return getText(defaultLocationNameData);
	}
	public String getCreatedLengthDataText() {
		return getText(createdLengthData);
	}
	
	public String getCreatedWidthDataText() {
		return getText(createdWidthData);
	}
	public String getCreatedHeightDataText() {
		return getText(createdHeightData);
	}
	
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
	
	public String  getCommonAreaPageText() {
		return getText(commonAreaPageText);
	}
	
	public String getHeaderPopupText() {
		return getText(headerPopupText);
	}
	
	public String getClosePopupContentText() {
		return getText(closePopupContentText);
	}
	
	public String getCloseCommonAreaPopupHeaderText() {
		return getText(closeCommonAreaPopupHeaderText);
	}
	
	public WebElement getBtnAddCommonArea() {
		return btnAddCommonArea;
	}
	
	public WebElement getSavedSuccessfullToastMessage() {
		return savedSuccessfullToastMsg;
	}
	
	
	
	public AddCommonAreaPage addCommonAreaButton() {

		waitForElementToBeClickable(btnAddCommonArea, 10);
		click(btnAddCommonArea);
		return this;
}
	
	
public AddCommonAreaPage checkLimitIncommonAreaTextbox() {
		
		sendKeys(commonAreaNameTxtbox, "AB");
		return this;
	}

	public AddCommonAreaPage addButtonInCommenAreaPopup() {
		
			click(btnAdd);
			return this;
	}

	
public AddCommonAreaPage existCommonAreaName(int rowNum) {
		
		String existCommonArea = getExistCommonAreaName();
		writeExcelToOverwrite("Test Datas", "AddCommonArea", 1, 6, existCommonArea);
		String duplicateCommonArea = readExcel("Test Datas", "AddCommonArea", rowNum, 6);
		sendKeys(commonAreaNameTxtbox, duplicateCommonArea);
		log(Status.INFO, "Getting suite name data from excel -" + duplicateCommonArea);
		return this;
	}

public void savedSuccessfulToastMsgOkButton() {

	click(btnToastMsgSuccessOk);
}

public void alreadyExistToastMsgOkButton() {

	click(btnToastMsgAlreadyExistOk);
}

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

public AddCommonAreaPage nonMandatoryFieldIsNotEmpty() {

	if(getAttribute(length,"value").isEmpty() && getAttribute(width,"value").isEmpty() && getAttribute(height,"value").isEmpty()) {
		log(Status.FAIL, "Data is NOT entered in Non-Mandatory fields");
	} else {
		log(Status.PASS, "Data is entered in Non-Mandatory fields");
	}
	return this;

}


public void closePopup() {

	click(closeAddCommonPopupXIcon);
}

public AddCommonAreaPage commonAreaName(int rowNum) throws Exception {

	String commonAreaNameFromExcel = (readExcel("Test Datas", "AddCommonArea", rowNum, 0) + dateAndTime());
	log(Status.INFO, "Getting suite name data from excel -" + commonAreaNameFromExcel);
	sendKeys(commonAreaNameTxtbox, commonAreaNameFromExcel);
	String enteredData = getAttribute(commonAreaNameTxtbox, "value");
	String writeExcel = writeExcel("Test Datas", "CreatedCommonArea", 0, enteredData);
	log(Status.INFO, "Write the created suite in excel -" + writeExcel);
	return this;
}

	public void yesButton() {
		
		click(closePopupYesButton);
	}
	
	public String getExistCommonAreaName() {
		
		return getText(existCommonAreaName);

	}

	
	String createdSuite;

	public void searchBox() throws Exception {

		String createdSuite = readExcelFromLastRow("Test Datas", "CreatedCommonArea", 0);
		String[] split = createdSuite.split("-");
		String suiteName = split[0];
		String timeStamp = split[1];
		sendKeys(commonAreaNameSearchBox, suiteName+"-");
		for (int i = 0; i < timeStamp.length(); i++) {
			char letter = timeStamp.charAt(i);
			String letterAsString = String.valueOf(letter);
			sendKeys(commonAreaNameSearchBox, letterAsString);
		}
		sleep(5000);
		backSpace(commonAreaNameSearchBox);
		int length = createdSuite.length();
        char lastLetter = createdSuite.charAt(length-1);
        String enterLastLetter = String.valueOf(lastLetter);
		sendKeys(commonAreaNameSearchBox, enterLastLetter);
		waitForFullPageElementLoad();
		
		if (getText(createdCommonArea).equals(readExcelFromLastRow("Test Datas", "CreatedCommonArea",0))) {
			viewButton();
			waitForPageLoad();
			log(Status.PASS, "Searched Common Area is displayed successfully by clicking Common Area label name");
		} else {
			log(Status.FAIL, "Searched Common Area is NOT displayed as expected");
			throw new Exception("Assertion failed searched Common Area is NOT displayed as expected");
		}
	}

	public void viewButton() {

		click(viewButton);
	}


	public String commonAreaNameBCText() {

	String createdCommonArea = readExcel("Test Datas", "AddCommonArea", 2, 6);
		BC = BC.replaceAll("createdCAN", createdCommonArea);
		String textString = getTextString(BC);
		return textString;
	}
	
	public void returnToCommonAreaPageBCText() {

		waitForElementToBeClickable(txtRtnToCommonAreaBreadCrum, 5);
		click(txtRtnToCommonAreaBreadCrum);
	}
	
	
	public boolean isViewButtonisDisplayed() {
	
		if(viewButton.isDisplayed()) {
			return true;
		} 
		return false;
	}

	public String checkCommonAreaNameFieldMaxLimit() {

		String inputMoreThan14Char = readExcel("Test Datas", "AddSuites", 1, 7);
		sendKeys(commonAreaNameTxtbox, inputMoreThan14Char);
		CharSequence subSequence = inputMoreThan14Char.subSequence(0,inputMoreThan14Char.length()-1);		
	    return subSequence.toString();
	}
	
}
