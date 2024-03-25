/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Nandhalala

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization   * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.pages;

import java.util.Set;
import org.alphind.xealei.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	private WebElement mailDeskTopURLLink;
	
	@FindBy(xpath = "//a[contains(text(),'Xealei')]")
	private WebElement mailXealeiAppURLLink;
		
	@FindBy(xpath = "(//iframe)[2]")
	private WebElement iframe;
	

	public String getIFrameInMailinator = "(//iframe[@title='HTML Email Message Body'])[1]";
	

	
	private String mailinatorWindow;
	private String xealeiWindow;
	
	
	public MailinatorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * Created by Alphi-MohamedRazul
	 * 
	 * Created on 20-MAR-2024.
	 * 
	 * Get userName text from mailinator.
	 * 
	 */
	public String getUserNameInMailinatorText() {
		
		return getText(usernamefromMail).split(":")[1];
	}
	

	/**
	 * Created by Alphi-MohamedRazul
	 * 
	 * Created on 20-MAR-2024.
	 * 
	 * Get password text from mailinator.
	 * 
	 */
public String getPasswordInMailinatorText() {
		
		return getText(passwordfromMail).split(":")[1];
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
		waitForVisiblityOfElementwithException(senderMailID, 120);
		mailinatorWindow = this.driver.getWindowHandle();
//		System.out.println("Mailinator window : "+mailinatorWindow);
		forceClick(senderMailID);
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 18-MAR-2024.
	 * 
	 * Wait for second mail.
	 * 
	 */
	public void waitForSecondEmail() {
		//(//tbody)[2]/tr/td[2]
		while(true) {
			try {
				waitForVisiblityOfElementwithException(this.driver
						.findElement(By.xpath("(//tbody)[2]/tr[2]/td[2]")), 10);
				break;
			}catch(NoSuchElementException e){
				this.driver.findElement(By.xpath
						("(//input[@aria-label='inbox field'])[1]/following-sibling::button"))
							.click();
				continue;
			}
		}
		
		waitForVisiblityOfElement(this.driver.findElement(By.xpath("(//tbody)[2]/tr[2]/td[2]")), 
				10);
//		waitForVisiblityOfElement(senderMailID, 10);
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
//	public void desktopURL(WebElement frame) {
//		
//      WebDriver frame = this.driver.switchTo().frame(1);
//		WebElement desktopURL = frame.findElement(By.xpath("//a[contains(text(),'Desktop URL')]"));
//		waitForVisiblityOfElement(desktopURL, 10);
//		click(desktopURL);
//		sleep(3000);
//		Set<String> windows = this.driver.getWindowHandles();
////		System.out.println(windows);
////		System.out.println(windows.size());
//		for(String str : windows) {
//			if(!str.equals(mailinatorWindow))
//				xealeiWindow = str;
//		}
//		this.driver.switchTo().window(xealeiWindow);
//	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 20-MAR-2024.
	 * 
	 * Click desktop url to switch to xealei application.
	 * 
	 */
	public void desktopURL() {
		
		sleep(2000);
		click(mailDeskTopURLLink);
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
	 * Created on 15-MAR-2024.
	 * 
	 * Click desktop url to switch to xealei application.
	 * 
	 */
//	public void xealeiURL(WebElement frame) {
	
////		sleep(5000);
////		WebDriver frame = this.driver.switchTo().frame(1);
//		WebElement URL = frame
//				.findElement(By.xpath("//a[contains(text(),'Xealei')]"));
//		waitForVisiblityOfElement(URL, 10);
//		click(URL);
//		sleep(3000);
//		Set<String> windows = this.driver.getWindowHandles();
////		System.out.println(windows);
////		System.out.println(windows.size());
//		for(String str : windows) {
//			if(!str.equals(mailinatorWindow))
//				xealeiWindow = str;
//		}
//		this.driver.switchTo().window(xealeiWindow);
//	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 15-MAR-2024.
	 * 
	 * Click desktop url to switch to xealei application.
	 * 
	 */
	public void xealeiURL() {
		
		sleep(3000);
		click(mailXealeiAppURLLink);
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
	 * Get first name from Mail.	
	 * 
	 */
	public String getUserName(WebElement frame) {
		
//		sleep(5000);
//		WebDriver frame = this.driver.switchTo().frame(1);
				
		WebElement usernamemail = frame
				.findElement(By.xpath("//p[contains(text(),'Username :')]"));
		waitForVisiblityOfElement(usernamemail, 10);
		String userName = usernamemail.getText();
//		frame.switchTo().defaultContent();
		return userName.split(":")[1].trim();
		
	}
	
	/**
	 * Created by Nandhalala.
	 * 
	 * Created on 15-MAR-2024.
	 * 
	 * Get password from Mail.
	 * 
	 */
	public String getPassword() {
		sleep(5000);
		WebDriver frame = this.driver.switchTo().frame(1);
		WebElement passwordmail = frame
				.findElement(By.xpath("//p[contains(text(),'Password :')]"));
		waitForVisiblityOfElement(passwordmail, 10);
		String userName = passwordmail.getText();
		frame.switchTo().defaultContent();
		return userName.split(":")[1].trim();
		
	}
	
}
