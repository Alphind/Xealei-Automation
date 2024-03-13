package org.alphind.xealei.pages;

import java.util.Objects;

import org.alphind.xealei.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

public class EditCommonAreaPage extends BaseClass{

	public EditCommonAreaPage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement commonAreaSearchBox;
	
	@FindBy(xpath = "(//h1[@class='title1'])[1]")
	private WebElement searchCreatedCAN;
	
	@FindBy(xpath = "(//span[@class='d-block'])[1]")
	private WebElement createdCommonAreaName;

	@FindBy(xpath = "(//button[@x-s-view])[1]")
	private WebElement view;
	
	@FindBy(xpath = "//span[contains(text(),'Edit')]/parent::button")
	private WebElement commonAreaEditButton;
	
	@FindBy(xpath = "//h2[contains(text(),' Edit Common ')]")
	private WebElement editCommonAreaPopupName;
	
	@FindBy(xpath = "//input[@x-as-suitename-inp]")
	private WebElement commonAreaNameField;
	
	@FindBy(xpath = "//input[@x-as-len-inp]")
	private WebElement lengthField;
	
	@FindBy(xpath = "//input[@x-as-bre-inp]")
	private WebElement widthField;
	
	@FindBy(xpath = "//input[@x-as-hei-inp]")
	private WebElement heightField;
	
	@FindBy(xpath = "//button[@type='button']")
	private WebElement closePopup;

	@FindBy(xpath = "//span[contains(text(),'Updated Successfully!!')]")
	private WebElement updatedSuccessfullToastMsg;
	
	@FindBy(xpath = "//h2[@x-s-addste]")
	private WebElement closeEditCommonAreaPopupHeaderText;
	
	@FindBy(xpath = "//span[contains(text(),' Update ')]/parent::button")
	private WebElement updateButton;

	String BC = "//span[text()='updatedCAN']/parent::li/parent::ol";

	public WebElement getCommonAreaEditButton() {
		return commonAreaEditButton;
	}
	
	public String getCloseEditCommonAreaPopupHeaderText() {
		return getText(closeEditCommonAreaPopupHeaderText);
	}
	
	public String getEditCommonAreaPopupName() {
		return getText(editCommonAreaPopupName);
	}
	
	public String getAttributeValueForCommonAreaNameField() {
	return getAttribute(commonAreaNameField,"value");
	}
	

	public String getUpdatedSuccessfullToastMsgText() {
		
		return getText(updatedSuccessfullToastMsg);

	}
	
	public EditCommonAreaPage deleteExistCommonAreaFieldData() {
		deleteExistFieldData(commonAreaNameField);
		return this;

	}
	
	public EditCommonAreaPage deleteExistLengthFieldData() {
		deleteExistFieldData(lengthField);
		return this;


	}
	
	public EditCommonAreaPage deleteExistWidthFieldData() {
		deleteExistFieldData(widthField);
		return this;


	}
	
	public EditCommonAreaPage deleteExistHeightFieldData() {
		deleteExistFieldData(heightField);
		return this;
	}
	
	String getCreatedCommonAreaNameFromExcel;

	public void searchBox(int rowNum) throws Exception {

		getCreatedCommonAreaNameFromExcel = readExcelFromLastRow("Test Datas", "CreatedCommonArea",0);
		
		for(int i=0; i<getCreatedCommonAreaNameFromExcel.length();i++) {
		
			char letter = getCreatedCommonAreaNameFromExcel.charAt(i);
			String valueOf = String.valueOf(letter);
			sendKeys(commonAreaSearchBox, valueOf);
		}
		
		waitForFullPageElementLoad();
		backSpace(commonAreaSearchBox);
		sleep(3000);
		int length = getCreatedCommonAreaNameFromExcel.length();
        char lastLetter = getCreatedCommonAreaNameFromExcel.charAt(length-1);
        String enterLastLetter = String.valueOf(lastLetter);
		sendKeys(commonAreaSearchBox, enterLastLetter);

		waitForFullPageElementLoad();
	
		waitForVisiblityOfElement(searchCreatedCAN, 10);
			String searchedCAN = getText(searchCreatedCAN);
			
		if (searchedCAN.equals(getCreatedCommonAreaNameFromExcel)) {
			waitForElementToBeClickable(view, 5);
			click(view);

			log(Status.PASS, "Searched common area is displayed successfully exp common area "+getCreatedCommonAreaNameFromExcel +" | Act common area "+getText(createdCommonAreaName));
		} else {
			log(Status.FAIL, "Searched common area is NOT displayed as expected exp common area "+getCreatedCommonAreaNameFromExcel +" | Act common area "+getText(createdCommonAreaName));
			throw new Exception("Assertion failed searched common area is not displayed as expected");
		}

		}
	
	
	public void editButton() {
		
		deleteExistFieldData(commonAreaSearchBox);
		
		sleep(2000);
		waitForElementToBeClickable(commonAreaEditButton, 10);
		click(commonAreaEditButton);
	}
	
	
public EditCommonAreaPage enterDataToCheckTheLimitIncommonAreaTextbox() {
		
		sendKeys(commonAreaNameField, "AB");
		return this;
	}
	
public void updateButton() {
	
	click(updateButton);
}
	
	
public EditCommonAreaPage enterLengthWidthHeight(int rownum) {

	String lengthData = (readExcel("Test Datas", "EditCommonArea", rownum, 2));
	String widthData = (readExcel("Test Datas", "EditCommonArea", rownum, 3));
	String heightData = (readExcel("Test Datas", "EditCommonArea", rownum, 4));

	log(Status.INFO, "Getting Length data from excel -" + lengthData);
	log(Status.INFO, "Getting Width data from excel -" + widthData);
	log(Status.INFO, "Getting Height data from excel -" + heightData);

	if (Objects.nonNull(lengthData) && !lengthData.equals("")) {
		sendKeys(lengthField, lengthData);
	} else {
		log(Status.INFO, "Length data is empty.");
	}
	if (Objects.nonNull(widthData) && !widthData.equals("")) {
		sendKeys(widthField, widthData);
	} else {
		log(Status.INFO, "Width data is empty.");
	}
	if (Objects.nonNull(heightData) && !heightData.equals("")) {
		sendKeys(heightField, heightData);
	} else {
		log(Status.INFO, "Height data is empty.");
	}
	return this;
}
	
	
public void existCommonAreaName(int rowNum) {

	String lastCreatedCommonAreaName = readExcel("Test Datas", "EditCommonArea", rowNum, 6);
	log(Status.INFO, "Getting exist suite name data from excel -" + lastCreatedCommonAreaName);
	sendKeys(commonAreaNameField, lastCreatedCommonAreaName);
}
	
public void closePopup() {

	click(closePopup);
}

//public void availabilityStatus(int rowNum) {
//	
//	click(available);
//	String availableStatus = readExcel("Test Datas", "EditSuites", rowNum, 5);
//	availability = availability.replaceAll("available", availableStatus);
//	select(availability);
//	log(Status.INFO, "Changed the status as In-Active");
//}

public EditCommonAreaPage  updatedCommonAreaName(int rowNum) throws Exception {

	String updateNewCAN = (readExcel("Test Datas", "EditCommonArea", rowNum, 0) + dateAndTime());
	log(Status.INFO, "Getting common area name data from excel -" + updateNewCAN);
	sendKeys(commonAreaNameField, updateNewCAN);
	writeExcelToOverwrite("Test Datas", "EditCommonArea", 2, 6, updateNewCAN);
	String writeExcel = writeExcelLastRow("Test Datas", "CreatedCommonArea", 0, updateNewCAN);
	log(Status.INFO, "Write the created common area in excel -" + writeExcel);
	return this;
}


//public String updatedCommonAreaNameBCText() {
//	
//	String updatedCommonArea = readExcel("Test Datas", "EditCommonArea", 2, 6);
//	BC = BC.replaceAll("updatedCAN", updatedCommonArea);
//	String textString = getTextString(BC);
//	return textString;
//}

public String updatedCommonAreaNameBCText() {

	BC = BC.replaceAll("updatedCAN", getCreatedCommonAreaNameFromExcel);
	String textString = getTextString(BC);
	return textString;
}

}
