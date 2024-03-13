package org.alphind.xealei.pages;

import java.util.Set;

/**
 * Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.
 * You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization
 * is prohibited without prior and proper license agreement
 *
 * created by Nandhalala
 *
*/

import org.alphind.xealei.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import groovy.transform.Final;

public class MailinatorPage extends BaseClass {
	
	private WebDriver driver;
	
	@FindBy(xpath = "(//input[@placeholder = 'Enter Public Mailinator Inbox'])[1]")
	private WebElement mailinatorMailTextBox;
	
	@FindBy(xpath = "(//input[@placeholder = 'Enter Public Mailinator Inbox'])[1]"
			+ "/following-sibling::button")
	private WebElement mailinatorGoButton;
	
	@FindBy(xpath = "//h4[contains(text(),'Public Messages')]")
	private WebElement publicmessagesHeading;
	
	@FindBy(xpath = "(//tbody)[2]/tr/td/div/input")
	private WebElement checkbox;
	
	@FindBy(xpath = "(//tbody)[2]/tr/td[2]")
	private WebElement senderMailID;
	
	@FindBy(xpath = "//p[contains(text(),'Username :')]")
	private WebElement usernamefromMail;
	
	@FindBy(xpath = "//p[contains(text(),'Password :')]")
	private WebElement passwordfromMail;
	
	@FindBy(xpath = "//a[contains(text(),'Desktop URL')]")
	private WebElement xealeiAppMailLink;
	
	@FindBy(xpath = "(//iframe)[2]")
	private WebElement iframe;
	
	private String mailinatorWindow;
	private String xealeiWindow;
	
	
	public MailinatorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 04-MAR-2024.
	 * 
	 * Enter email in email box.
	 * 
	 */
	public void enterEmail() {
		sendKeys(mailinatorMailTextBox, readExcel("Test Datas", "User Management", 1, 27).trim());
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 04-MAR-2024.
	 * 
	 * Click Go button.
	 * 
	 */
	public void goButton() {
		click(mailinatorGoButton);
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 04-MAR-2024.
	 * 
	 * Click first Email.
	 * 
	 */
	public void firstEmail() {
		waitForVisiblityOfElement(senderMailID, 10);
		mailinatorWindow = this.driver.getWindowHandle();
//		System.out.println("Mailinator window : "+mailinatorWindow);
		click(senderMailID);
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 04-MAR-2024.
	 * 
	 * Click desktop url to switch to xealei application.
	 * 
	 */
	public void desktopURL() {
		sleep(5000);
		WebDriver frame = this.driver.switchTo().frame(1);
//		WebDriver frame = this.driver.switchTo()
//				.frame("(//iframe[@title='HTML Email Message Body'])[1]");
		WebElement desktopURL = frame
				.findElement(By.xpath("//a[contains(text(),'Desktop URL')]"));
		waitForVisiblityOfElement(desktopURL, 10);
		click(desktopURL);
		sleep(3000);
		Set<String> windows = this.driver.getWindowHandles();
//		System.out.println(windows);
//		System.out.println(windows.size());
		for(String str : windows) {
			if(!str.equals(mailinatorWindow))
				xealeiWindow = str;
		}
		this.driver.switchTo().window(xealeiWindow);
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 05-MAR-2024.
	 * 
	 * Get first name from 	
	 * 
	 */
	public String getUserName() {
		sleep(5000);
		WebDriver frame = this.driver.switchTo().frame(1);
		WebElement usernamemail = frame
				.findElement(By.xpath("//p[contains(text(),'Username :')]"));
		waitForVisiblityOfElement(usernamemail, 10);
		String userName = usernamemail.getText();
		frame.switchTo().defaultContent();
		return userName.split(":")[1].trim();
		
	}
	
}
