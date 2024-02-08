/** Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import io.cucumber.java.Scenario;


public class BaseClass {

	// Driver initialized in class level
	protected Scenario s;
	// public ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();

	public static WebDriver driver;

	/**
	 * To launch the browser that to be automated.
	 * 
	 * @throws Exception - if the browser value is invalid.
	 */
	public void browserType() throws Exception {

		if (getConfigureProperty("Browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(getChromeOptions());
			log(Status.INFO, "Browser launched in Chrome");

		} else if (getConfigureProperty("Browser").equalsIgnoreCase("edge")) {
			driver = new EdgeDriver(getEdgeOptions());
			log(Status.INFO, "Browser launched in Chrome");

		} else if (getConfigureProperty("Browser").equalsIgnoreCase("firefox")) {
			 driver = new FirefoxDriver(getFirefoxOptions());
			log(Status.INFO, "Browser launched in Chrome");
		} else {
			log(Status.FAIL, "Browser Value is not valid in config.properties file.");
			throw new Exception("Browser Value is not valid in config.properties file.");
		}
	}
	
	public WebDriver getNewDriver() throws Exception {

		WebDriver newDriver;
		
		if (getConfigureProperty("Browser").equalsIgnoreCase("chrome")) {
			newDriver = new ChromeDriver(getChromeOptions());
			log(Status.INFO, "Browser launched in Chrome");

		} else if (getConfigureProperty("Browser").equalsIgnoreCase("edge")) {
			newDriver = new EdgeDriver(getEdgeOptions());
			log(Status.INFO, "Browser launched in Chrome");

		} else if (getConfigureProperty("Browser").equalsIgnoreCase("firefox")) {
			 newDriver = new FirefoxDriver(getFirefoxOptions());
			log(Status.INFO, "Browser launched in Chrome");
		} else {
			log(Status.FAIL, "Browser Value is not valid in config.properties file.");
			throw new Exception("Browser Value is not valid in config.properties file.");
		}

		return newDriver;
		
	}

	private ChromeOptions getChromeOptions() {
		
		ChromeOptions chromeOption = new ChromeOptions();
		if (getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("Yes")) {
			chromeOption.addArguments("--headless", "--window-size=1920,1080");
		} else {
			System.out.println("Running in UI mode.");
		}
		if (getConfigureProperty("StartMaximized").equalsIgnoreCase("Yes")) {
			chromeOption.addArguments("start-maximized");
		} else {
			System.out.println("Browser not maximized.");		
		}
//		chromeOption.setExperimentalOption("mobileEmulation", new HashMap<String, Object>() {
//			            {
//			                put("deviceName", "iPhone 12 Pro");
//			            }
//			        });
		return chromeOption;
	}

	private EdgeOptions getEdgeOptions() {
		EdgeOptions edgeOption = new EdgeOptions();
		if (getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("Yes")) {
			edgeOption.addArguments("--headless", "--window-size=1920,1080");
		} else {
			System.out.println("Running in UI mode.");
		}
		if (getConfigureProperty("StartMaximized").equalsIgnoreCase("Yes")) {
			edgeOption.addArguments("start-maximized");
		} else {
			System.out.println("Browser not maximized.");
		}
		return edgeOption;
	}

	private FirefoxOptions getFirefoxOptions() {
		FirefoxOptions fireFoxOption = new FirefoxOptions();
		if (getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("Yes")) {
			fireFoxOption.addArguments("--headless", "--window-size=1920,1080");
		} else {
			System.out.println("Running in UI mode.");
		}
		if (getConfigureProperty("StartMaximized").equalsIgnoreCase("Yes")) {
			fireFoxOption.addArguments("start-maximized");
		} else {
			System.out.println("Browser not maximized.");
		}
		return fireFoxOption;
	}

	// 8. Send the Data's using SENDKEYS

	public void sendKeys(WebElement element, String datasToSend) {
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		try {
			element.sendKeys(datasToSend);
			log(Status.INFO, "Data entered in the " + methodName + " field is - " + datasToSend);
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
		}

	}

	// BACK SPACE

	public void backSpace(WebElement element) {

		element.sendKeys(Keys.BACK_SPACE);
		log(Status.INFO, "Delete the last keyword");
	}

	// 9. To get the text/data's

	public String getAttribute(WebElement element, String value) {

		String text = element.getAttribute(value);
		return text;

	}

	// 10. To set the timeout for findElement and findElements

	public void implicitWaitBySeconds(long seconds) {
		// dr.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	// 11. Explicit wait - WebDriverWait for alertIsPresent

	public void waitForAlertIsPresent(long seconds) {
		// WebDriverWait wait = new WebDriverWait(dr.get(),
		// Duration.ofSeconds(seconds));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	// 12. Explicit wait - WebDriverWait for elementToBeClickable

	public void waitForElementToBeClickable(WebElement element, long seconds) {
		// WebDriverWait wait = new WebDriverWait(dr.get(),
		// Duration.ofSeconds(seconds));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// 13. Screenshot

	public String takesScreenshot() {

		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

//		// TakesScreenshot screen = (TakesScreenshot) dr.get();
//		TakesScreenshot screen = (TakesScreenshot) driver;
//		File source = screen.getScreenshotAs(OutputType.FILE);
//		File destination = new File(".//ExtentReports//Screenshots//" + "Screenshot" + ".png");
//		FileUtils.copyFile(source, destination);
//		FileInputStream fis = new FileInputStream(destination);
//		byte[] bytes = new byte[(int) destination.length()];
//		fis.read(bytes);
//		String base64 = new String((bytes));
//		fis.close();
//		return "data:image/png;base64" + base64;
	}
	
	public String takesScreenshot(WebDriver currentDriver) {

		return ((TakesScreenshot) currentDriver).getScreenshotAs(OutputType.BASE64);

	}

	// 15. Click
	public void click(WebElement element) {
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		try {
			element.click();
			log(Status.INFO, "Click the " + methodName);
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	public void clickEnter(WebElement element) {
		try {
			element.sendKeys(Keys.ENTER);
			log(Status.INFO, "Click ENTER key");
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	public void deleteExistFieldData(WebElement element) {
		
		try {
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.BACK_SPACE);
		log(Status.INFO, "Delete the existing field data");
	   } catch (NoSuchElementException e) {
		   log(Status.FAIL, e.getMessage());
		   e.printStackTrace();
	} catch (ElementNotInteractableException e) {
		   log(Status.FAIL, e.getMessage());
		   e.printStackTrace();
	}
	}
	
	public void deleteExistPhoneData(WebElement element) {
		try {
		for (int i = 0; i < 15; i++)
			element.sendKeys(Keys.BACK_SPACE);
		log(Status.INFO, "Delete the existing phone data");
		
		 } catch (NoSuchElementException e) {
			   log(Status.FAIL, e.getMessage());
			   e.printStackTrace();
		} catch (ElementNotInteractableException e) {
			   log(Status.FAIL, e.getMessage());
			   e.printStackTrace();
		}
	}

	// 16. Close

	public void close() {
		// dr.get().close();
		log(Status.INFO, "Close the browser");
		driver.close();
	}

	// 17. Quit Driver
	

	public void quit() {
		// dr.get().quit();
		log(Status.INFO, "Quit the browser");
		driver.quit();
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
	
	// 18. readData from Excel

	public String readExcel(String fileName, String sheetName, int rowNum, int cellNum) {

		String res = null;
		File file = new File(".//Excel//" + fileName + ".xlsx");
		try {
			FileInputStream stream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(stream);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rowNum);
			Cell cell = row.getCell(cellNum);
			CellType cellType = cell.getCellType();
			switch (cellType) {

			case STRING:
				res = cell.getStringCellValue();
				break;
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					Date date = cell.getDateCellValue();
					SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
					res = dateFormat.format(date).toString();
				} else {
					double numericCellValue = cell.getNumericCellValue();
					BigDecimal b = BigDecimal.valueOf(numericCellValue);
					res = b.toString();
				}
				break;
			default:
				break;
			}
			workbook.close();

		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		return res;

	}

//     // read lastRow Data from Excel
	public String readExcelFromLastRow(String fileName, String sheetName, int cellNum) {

		String res = null;
		File file = new File(".//Excel//" + fileName + ".xlsx");
		try {
			FileInputStream stream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(stream);
			Sheet sheet = workbook.getSheet(sheetName);
			int lastRowNum = sheet.getLastRowNum();
			Row row = sheet.getRow(lastRowNum);
			Cell cell = row.getCell(cellNum);
			CellType cellType = cell.getCellType();
			switch (cellType) {

			case STRING:
				res = cell.getStringCellValue();
				break;
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					Date date = cell.getDateCellValue();
					SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
					res = dateFormat.format(date).toString();
				} else {
					double numericCellValue = cell.getNumericCellValue();
					BigDecimal b = BigDecimal.valueOf(numericCellValue);
					res = b.toString();
				}
				break;
			default:
				break;
			}
			workbook.close();

		}  catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

	// 19. Configuration Property File

	public String getConfigureProperty(String key) {

		try {
			FileInputStream stream = new FileInputStream(".//Configuration Property file//Config.properties");
			Properties properties = new Properties();
			properties.load(stream);
			return properties.get(key).toString();
		} catch (IOException e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
			return "";
		}

	}

	// 26. explicitWait for element is Clickable

	public void elementIsClickable(WebElement element, long seconds) {

		// WebDriverWait wait = new WebDriverWait(dr.get(),
		// Duration.ofSeconds(seconds));
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			log(Status.INFO, "Wait for elementToBeClickable");
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
		}
	}

	// 27. explicitWait for textToBePresentInElement

	public void waitFortextToBePresentInElement(WebElement element, String text, long seconds) {
		// WebDriverWait wait = new WebDriverWait(dr.get(),
		// Duration.ofSeconds(seconds));
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.textToBePresentInElement(element, text));
			log(Status.INFO, "Wait for textToBePresentInElement");
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
		}
	}

	// 28. explicitWait for visibilityOfElement

	public void visibilityOfElement(WebElement element, long seconds) {
		// WebDriverWait wait = new WebDriverWait(dr.get(),
		// Duration.ofSeconds(seconds));
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
		log(Status.INFO, "Wait for Page Loading...");
	} catch (Exception e) {
		log(Status.FAIL, e.getMessage());
	}
	}

	// 30. findElement --- > ByTagName

	public WebElement findElementByTagName(String tagName) {

		// WebElement element = dr.get().findElement(By.tagName(tagName));
		WebElement element = driver.findElement(By.tagName(tagName));
		return element;
	}
// 31. findElement --- > xpath

	public WebElement findElementByXpath(String xpath) {

		// WebElement elements = dr.get().findElement(By.xpath(xpath));
		WebElement elements = driver.findElement(By.xpath(xpath));
		return elements;
	}

	// 31. listOfWebElement --- > ByTagName

	public List<WebElement> findElementsByXpath(String xpath) {

		// List<WebElement> elements = dr.get().findElements(By.xpath(xpath));
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		return elements;
	}

	// 32. String click

	public void select(String elementxpath) {
		// click(dr.get().findElement(By.xpath(elementxpath)));
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		try {

			click(driver.findElement(By.xpath(elementxpath)));
			log(Status.INFO, "Select the "+ methodName);
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
		}
	}

	public void select(WebDriver driver,String elementxpath) {
		// click(dr.get().findElement(By.xpath(elementxpath)));
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		try {

			click(driver.findElement(By.xpath(elementxpath)));
			log(Status.INFO, "Select the" + methodName);
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
		}
	}
	
	// 33. Current Date and Time Generator
	public String dateAndTime() throws Exception {
		try {
			
		DateTimeFormatter Dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String a = "-" + Dtf.format(now);
		return a;
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			throw new Exception("Facing exception in dateAndTime() Method");
		}
	}

	// 34. Write Data to Excel

	public String writeExcel(String fileName, String sheetname, int cellnum, String newdatacell) {

		File file = new File(".//Excel//" + fileName + ".xlsx");
		try {
			FileInputStream stream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(stream);
			Sheet sheet = workbook.getSheet(sheetname);
			int lastRowNum = sheet.getLastRowNum();
			Row row = sheet.createRow(lastRowNum + 1);
			Cell cell = row.createCell(cellnum);
			cell.setCellValue(newdatacell);
			FileOutputStream stream1 = new FileOutputStream(file);
			workbook.write(stream1);
			workbook.close();
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		return newdatacell;
	}

	public String writeExcelToOverwrite(String fileName, String sheetname, int rowNum, int cellNum,
			String newdatacell) {

		File file = new File(".//Excel//" + fileName + ".xlsx");
		try {
			FileInputStream stream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(stream);
			Sheet sheet = workbook.getSheet(sheetname);
			Row row = sheet.getRow(rowNum);
			Cell cell = row.getCell(cellNum);
			cell.setCellValue(newdatacell);
			FileOutputStream stream1 = new FileOutputStream(file);
			workbook.write(stream1);
			workbook.close();
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		return newdatacell;
	}

	public String writeExcelLastRow(String fileName, String sheetname, int cellnum, String newdatacell) {

		File file = new File(".//Excel//" + fileName + ".xlsx");
		FileInputStream stream;
		try {
			stream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(stream);
			Sheet sheet = workbook.getSheet(sheetname);
			int lastRowNum = sheet.getLastRowNum();
			Row row = sheet.getRow(lastRowNum);
			Cell cell = row.createCell(cellnum);
			cell.setCellValue(newdatacell);
			FileOutputStream stream1 = new FileOutputStream(file);
			workbook.write(stream1);
			workbook.close();
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}

		return newdatacell;
	}

	// 35.getText

	public String getText(WebElement updatedSuiteName) {

		try {
		String text = updatedSuiteName.getText();
		return text;
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	// 36. Robot key ---> KeyPress

	public void keyPress(int keyCode) {

		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(keyCode);

		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	// 37. Robot key ---> keyRelease

	public void keyRelease(int keyCode) {

		try {
			Robot robot = new Robot();
			robot.keyRelease(keyCode);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	// 38. sendKeysWithEnter

	public void sendKeyWithEnter(WebElement element, String data) {
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		try {
			element.sendKeys(data, Keys.ENTER);
			log(Status.INFO, "Click the " + methodName + "using sendKeyWithEnter");
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	// 40. Explicit wait - WebDriverWait for VisiblityOfElement

	public void waitForVisiblityOfElement(WebElement element, long seconds) {
		// WebDriverWait wait = new WebDriverWait(dr.get(),
		// Duration.ofSeconds(seconds));
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	// 41. getText - String

	public String getTextString(String elementxpath) {
		// String text = getText(dr.get().findElement(By.xpath(elementxpath)));
		String text = getText(driver.findElement(By.xpath(elementxpath)));
		return text;
	}
	
	public String getTextString(WebDriver currentdriver,String elementxpath) {
		// String text = getText(dr.get().findElement(By.xpath(elementxpath)));
		String text = getText(currentdriver.findElement(By.xpath(elementxpath)));
		return text;
	}

	// 42. Wait for Loading

	public void waitForPageLoad() {

		
//		try {
////			WebElement loading = dr.get().findElement(By.xpath("//div[contains(text(),'Loading')]"));
////			WebDriverWait wait = new WebDriverWait(dr.get(), Duration.ofMinutes(3));
//			WebElement loading = driver
//					.findElement(By.xpath("//span[contains(@class,'cloader')]"));
////			WebElement loading = driver.findElement(By.xpath("//div[contains(text(),'Loading')]"));
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
//			wait.until(ExpectedConditions.invisibilityOf(loading));
//		}catch (NoSuchElementException e) {
//			
//		}



		try {
		WebElement loading = driver.findElement(By.xpath("//span[contains(@class,'cloader')]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		wait.until(ExpectedConditions.invisibilityOf(loading));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public void waitForAjexPageLoad() {

		try {
		WebElement loading = driver.findElement(By.xpath("//progress[@class='ajaxProgress']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		wait.until(ExpectedConditions.invisibilityOf(loading));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

	}
	
	//Added new method for handling multiple drivers
	//CREATED BY NANDHALALA
	public void waitForPageLoad(WebDriver currentdriver) {


		try {
//			WebElement loading = dr.get().findElement(By.xpath("//div[contains(text(),'Loading')]"));
//			WebDriverWait wait = new WebDriverWait(dr.get(), Duration.ofMinutes(3));
			//span[contains(@class,'cloader')] --> new load element
			WebElement loading = currentdriver
					.findElement(By.xpath("//span[contains(@class,'cloader')]"));
//			WebElement loading = currentdriver.findElement(By.xpath("//div[contains(text(),"
//					+ "'Loading')]"));
			WebDriverWait wait = new WebDriverWait(currentdriver, Duration.ofMinutes(3));
			wait.until(ExpectedConditions.invisibilityOf(loading));
		}catch (NoSuchElementException e) {
			
		}

////		WebElement loading = dr.get().findElement(By.xpath("//div[contains(text(),'Loading')]"));
////		WebDriverWait wait = new WebDriverWait(dr.get(), Duration.ofMinutes(3));
//		//span[contains(@class,'cloader')] --> new load element
////		WebElement loading = currentdriver.findElement(By.xpath("//div[contains(text(),'Loading')]"));
//		WebElement loading = currentdriver.findElement(By.xpath("//span[contains(@class,'cloader')]"));
//		WebDriverWait wait = new WebDriverWait(currentdriver, Duration.ofMinutes(3));
//		wait.until(ExpectedConditions.invisibilityOf(loading));


	}

	// 43. Thread-Sleep

	public void sleep(long millis) {

		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	// 44. Robot class for upload photo

	public void uploadImage(String imagePath) {
		StringSelection stringSelection = new StringSelection(imagePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void cleanRecordFromDB(boolean CleanRecord, String collectionName, String key, String value) {

		if (CleanRecord == true) {

//			// ************* MongoDB deployment's connection string *************
			String uri = "mongodb+srv://adminXealei:hNntCLqUSkTxbJel@xealei-qa.1of90.mongodb.net"
					+ "/xealeiqa?retryWrites=true&w=majority";

			MongoClient mongoClient = MongoClients.create(uri);

//			// ************* Create one Collection *************
			MongoDatabase db = mongoClient.getDatabase("xealeiqa");

//			//************* To delete particular document *************
			db.getCollection(collectionName).findOneAndDelete(Filters.eq(key, value));
			System.out.println("Document deleted successfully..!");

		}
	}

//		// 40. Explicit wait - WebDriverWait for inVisiblityOfElement

	public void waitForInVisiblityOfElement(WebElement element, long seconds) {
		// WebDriverWait wait = new WebDriverWait(dr.get(),
		// Duration.ofSeconds(seconds));
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	} catch (Exception e) {
		log(Status.FAIL, e.getMessage());
		e.printStackTrace();
	}
	}
	
	public void waitForInVisiblityOfElement(WebDriver currentdriver,WebElement element, long seconds) {
		// WebDriverWait wait = new WebDriverWait(dr.get(),
		// Duration.ofSeconds(seconds));
		try {
			WebDriverWait wait = new WebDriverWait(currentdriver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	} catch (Exception e) {
		log(Status.FAIL, e.getMessage());
		e.printStackTrace();
	}
	}

//     //  41. Clear Text

	public void clearText(WebElement element) {
		element.clear();
	}

//	     //  43. Environment set up

	public void env() throws Exception {

		String chooseEnvironment = getConfigureProperty("Environment");

		switch (chooseEnvironment) {

		case "QA": {
			driver.get(readExcel("Test Datas", "Environments", 1, 1));
			log(Status.INFO, "Choosed environment - QA");
			break;
		}
		case "PREPROD": {
			driver.get(readExcel("Test Datas", "Environments", 2, 1));
			log(Status.INFO, "Choosed environment - PREPROD");
			break;
		}
		case "PROD": {
			driver.get(readExcel("Test Datas", "Environments", 3, 1));
			log(Status.INFO, "Choosed environment - PROD");
			break;
		}
		default: {
			log(Status.FAIL, "Environment value is not valid in config.properties file");
			break;
		}
		}

	}

//	     //  44. get Current URL

	public String getCurrentUrl() throws Exception {

		try {
		// String currentUrl = dr.get().getCurrentUrl();
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
			throw new Exception("Facing exception in getCurrentUrl() Method");
		}
	}
	
	public String getCurrentUrl(WebDriver driver) throws Exception {

		// String currentUrl = dr.get().getCurrentUrl();
		try {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
			throw new Exception("Facing exception in getCurrentUrl(driver) Method");
		}
	}

//		// 45. Scroll Down - (JavaScript Executor)

	public void scrollIntoView(WebElement element) {

		// JavascriptExecutor executor = (JavascriptExecutor)dr.get();
		try {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].scrollIntoView()", element);
		log(Status.INFO, "Scroll into an view");
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

//		// 46. Scroll Bottom of the page - (JavaScript Executor)

	public void scrollDownToBottomOfThePage() {
try {
		// JavascriptExecutor executor = (JavascriptExecutor)dr.get();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		log(Status.INFO, "Scroll down to  bottom of the page");
	} catch (Exception e) {
		log(Status.FAIL, e.getMessage());
		e.printStackTrace();
	}
	}

//      //49. Full Page Load - getPageLoad

	public void waitForFullPageElementLoad() {

		driver.manage().timeouts().getPageLoadTimeout();
	}

	public void waitForFullPageElementLoad(WebDriver currentdriver) {

		currentdriver.manage().timeouts().getPageLoadTimeout();
	}
	
//     //50. Extent Report 

	private static ExtentReports extent;
	private static ExtentSparkReporter spark;
	public static ExtentTest test;

	public void reportSetup(String name) {

		String reportPath = ".//Extent Reports/Report.html";
		if (extent == null) {
			extent = new ExtentReports();
			spark = new ExtentSparkReporter(reportPath);
			extent.attachReporter(spark);
			spark.config().setReportName("Automation Testing");
			spark.config().setDocumentTitle("Xealei");
			spark.config().setCss(reportPath);

		}
		String ReportTheme = getConfigureProperty("ReportTheme");

		if (ReportTheme.equalsIgnoreCase("DARK")) {
			spark.config().setTheme(Theme.DARK);
		} else if (ReportTheme.equalsIgnoreCase("STANDARD")) {
			spark.config().setTheme(Theme.STANDARD);
		} else {
			spark.config().setTheme(Theme.STANDARD);
		}

		test = extent.createTest(name);

	}

//  //51. Extent Report - Flush

	public void reportFlush() {

		extent.flush();
	}

//  //52. Extent Report - Log Attachment
	public void log(Status status, String message) {

		String passed = getConfigureProperty("PassedScreenshots");
		String failed = getConfigureProperty("FailedScreenshots");
		
		if(getConfigureProperty("IgnoreInfo").equalsIgnoreCase("No")) {
			
				if (passed.equalsIgnoreCase("Yes") && failed.equalsIgnoreCase("Yes")
						&& (status.toString().equalsIgnoreCase("PASS") || status.toString().equalsIgnoreCase("FAIL"))) {
					test.log(status, message,
							MediaEntityBuilder.createScreenCaptureFromBase64String(takesScreenshot()).build());

				} else if (passed.equalsIgnoreCase("Yes") && failed.equalsIgnoreCase("No")
						&& status.toString().equalsIgnoreCase("PASS")) {
					test.log(status, message,
							MediaEntityBuilder.createScreenCaptureFromBase64String(takesScreenshot()).build());

				} else if (passed.equalsIgnoreCase("No") && failed.equalsIgnoreCase("Yes")
						&& status.toString().equalsIgnoreCase("FAIL")) {
					test.log(status, message,
							MediaEntityBuilder.createScreenCaptureFromBase64String(takesScreenshot()).build());
				} else {
					test.log(status, message);
				}
			
		}else if(getConfigureProperty("IgnoreInfo").equalsIgnoreCase("Yes")) {
			if(!status.toString().equalsIgnoreCase("INFO")) {
				if (passed.equalsIgnoreCase("Yes") && failed.equalsIgnoreCase("Yes")
						&& (status.toString().equalsIgnoreCase("PASS") || status.toString().equalsIgnoreCase("FAIL"))) {
					test.log(status, message,
							MediaEntityBuilder.createScreenCaptureFromBase64String(takesScreenshot()).build());

				} else if (passed.equalsIgnoreCase("Yes") && failed.equalsIgnoreCase("No")
						&& status.toString().equalsIgnoreCase("PASS")) {
					test.log(status, message,
							MediaEntityBuilder.createScreenCaptureFromBase64String(takesScreenshot()).build());

				} else if (passed.equalsIgnoreCase("No") && failed.equalsIgnoreCase("Yes")
						&& status.toString().equalsIgnoreCase("FAIL")) {
					test.log(status, message,
							MediaEntityBuilder.createScreenCaptureFromBase64String(takesScreenshot()).build());
				} else {
					test.log(status, message);
				}
			}
		}
}
		
	
	public void log(Status status, String message, WebDriver currentDriver) {

		String passed = getConfigureProperty("PassedScreenshots");
		String failed = getConfigureProperty("FailedScreenshots");
		if(getConfigureProperty("IgnoreInfo").equalsIgnoreCase("No")) {

			if (passed.equalsIgnoreCase("Yes") && failed.equalsIgnoreCase("Yes")
					&& (status.toString().equalsIgnoreCase("PASS") || status.toString().equalsIgnoreCase("FAIL"))) {
				test.log(status, message,
						MediaEntityBuilder.createScreenCaptureFromBase64String(takesScreenshot(currentDriver)).build());

			} else if (passed.equalsIgnoreCase("Yes") && failed.equalsIgnoreCase("No")
					&& status.toString().equalsIgnoreCase("PASS")) {
				test.log(status, message,
						MediaEntityBuilder.createScreenCaptureFromBase64String(takesScreenshot(currentDriver)).build());

			} else if (passed.equalsIgnoreCase("No") && failed.equalsIgnoreCase("Yes")
					&& status.toString().equalsIgnoreCase("FAIL")) {
				test.log(status, message,
						MediaEntityBuilder.createScreenCaptureFromBase64String(takesScreenshot(currentDriver)).build());
			} else {
				test.log(status, message);
			}
		}else if(getConfigureProperty("IgnoreInfo").equalsIgnoreCase("Yes")) {
		
		if(!status.toString().equalsIgnoreCase("INFO")) {
			if (passed.equalsIgnoreCase("Yes") && failed.equalsIgnoreCase("Yes")
					&& (status.toString().equalsIgnoreCase("PASS") || status.toString().equalsIgnoreCase("FAIL"))) {
				test.log(status, message,
						MediaEntityBuilder.createScreenCaptureFromBase64String(takesScreenshot(currentDriver)).build());

			} else if (passed.equalsIgnoreCase("Yes") && failed.equalsIgnoreCase("No")
					&& status.toString().equalsIgnoreCase("PASS")) {
				test.log(status, message,
						MediaEntityBuilder.createScreenCaptureFromBase64String(takesScreenshot(currentDriver)).build());
			} else if (passed.equalsIgnoreCase("No") && failed.equalsIgnoreCase("Yes")
					&& status.toString().equalsIgnoreCase("FAIL")) {
				test.log(status, message,
						MediaEntityBuilder.createScreenCaptureFromBase64String(takesScreenshot(currentDriver)).build());
			} else {
				test.log(status, message);
			}
		}
}
	}

//   // 53. Page Backward

	public void pageBackward() {

		try {
		driver.navigate().back();
		log(Status.PASS, "Navigate to backward (Back to Login page)");
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	public void logStep(String name) {
		test.log(Status.INFO, MarkupHelper.createLabel(name, ExtentColor.AMBER));
	}

	public String methodName() {

		String name = Thread.currentThread().getStackTrace()[2].getMethodName();
		return name;
	}

	public void pageRefresh() {

		try {
		driver.navigate().refresh();
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	public String secondsCount() throws Exception {

		try {
		DateTimeFormatter Dtf = DateTimeFormatter.ofPattern("mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String a = "-" + Dtf.format(now);
		return a;
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
			throw new Exception("Facing exception in secondsCount() Method");
		}
	}

	public void scrollIntoUp() {

		// JavascriptExecutor executor = (JavascriptExecutor)dr.get();
		try {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,-250)");
		log(Status.INFO, "Scroll into an view");
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	public String futureDate(int num) throws Exception {
		
		try {
		LocalDate date = LocalDate.now();
		int dayOfMonth = date.getDayOfMonth();

		String datePattern = (dayOfMonth <= 9) ? "d" : "dd";

		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern(datePattern);

		String currentDate = date.format(ofPattern);
		System.out.println("Current Date : " + currentDate);

		int intValue = Integer.parseInt(currentDate);
		int nextDate = intValue + 1;

		String nxtDate = Integer.toString(nextDate);
		System.out.println("Current Date + 1 - " + nxtDate);

		return nxtDate;
		
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
			throw new Exception("Facing exception in futureDate() Method");
		}

	}
	
	public String nextToCurrentDate() throws Exception {

		try {
		LocalDate date = LocalDate.now();
//		int dayOfMonth = date.getDayOfMonth();
//
//		//String datePattern = (dayOfMonth <= 9) ? "d" : "dd";

		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("dd");

		String currentDate = date.format(ofPattern);
		System.out.println("Current Date : " + currentDate);

		int intValue = Integer.parseInt(currentDate);
		int nextDate = intValue + 1;

		String nxtDate = Integer.toString(nextDate);
		System.out.println("Current Date + 1 - " + nxtDate);

		return nxtDate;
		
		
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
			throw new Exception("Facing exception in nextToCurrentDate() Method");
		}

	}

	public String getCurrentDtYearMonth(String EnterPattern) throws Exception {

		try {
		LocalDateTime currentDateYearMonth = LocalDateTime.now();
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern(EnterPattern);
		String DateAsPerGiven = currentDateYearMonth.format(ofPattern).toUpperCase();
		return DateAsPerGiven;
		
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
			throw new Exception("Facing exception in getCurrentDtYearMonth() Method");
		}
	}
	
	public String getFutureTime(String EnterPattern) throws Exception {

		try {
		LocalDateTime currentDateYearMonth = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
		LocalDateTime plusMinutes = currentDateYearMonth.plusMinutes(2);
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern(EnterPattern);
		String DateAsPerGiven = plusMinutes.format(ofPattern).toUpperCase();
		return DateAsPerGiven;
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
			throw new Exception("Facing exception in getFutureTime() Method");
		}
		
	}
	
	public String getPastTime(String EnterPattern) throws Exception {

		try {
		LocalDateTime currentDateYearMonth = LocalDateTime.now(ZoneId.of("Europe/London"));
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern(EnterPattern);
		String DateAsPerGiven = currentDateYearMonth.format(ofPattern).toUpperCase();
		return DateAsPerGiven;
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
			throw new Exception("Facing exception in getPastTime() Method");
		}
	}

	public String getCurrentDate() throws Exception {

		try {
		LocalDate date = LocalDate.now();
		int day = date.getDayOfMonth();
		String format = (day <= 9) ? "d" : "dd";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		String formattedDate = date.format(formatter);
		return formattedDate;
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
			throw new Exception("Facing exception in getCurrentDate() Method");
		}
	}
	
	public String randomMobileNumber() throws Exception {

		try {
		Random random = new Random();
		StringBuilder mobileNumber = new StringBuilder("9");

		for (int i = 1; i < 10; i++) {
			mobileNumber.append(random.nextInt(10));
		}
		return mobileNumber.toString();
		
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
			throw new Exception();
		}
	}

	public String previousMonth(String pattern) throws Exception {

		try {
		LocalDate currentDate = LocalDate.now();

		LocalDate previousMonthDate = currentDate.minusMonths(1);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		String formattedDate = previousMonthDate.format(formatter);

		return formattedDate.toUpperCase();
		
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
			throw new Exception();
		}
	}

	public String getMonth() throws Exception {

		try {
		LocalDate currentDate = LocalDate.now();
		int day = currentDate.getMonthValue();
		
		LocalDate previousMonthDate = currentDate.minusMonths(1);
		String format = (day <= 9) ? "M" : "MM";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		String formattedDate = previousMonthDate.format(formatter);

		return formattedDate.toUpperCase();
		
	} catch (Exception e) {
		log(Status.FAIL, e.getMessage());
		e.printStackTrace();
		throw new Exception("Facing exception in getMonth() Method");
}
	}

	public String getYear() {

		LocalDate currentDate = LocalDate.now();

		if(currentDate.getMonth().toString().equals("JANUARY")) {
			LocalDate previousMonthDate = currentDate.minusMonths(1);

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY");
			String formattedDate = previousMonthDate.format(formatter);
			return formattedDate;

		} else {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY");
			String formattedDate = currentDate.format(formatter);
			return formattedDate;
		}
		
	}
	
	
	
	
	public String getCurrentMonth() throws Exception {

try {
	LocalDate currentDate = LocalDate.now();
	int day = currentDate.getMonthValue();
	String format = (day <= 9) ? "M" : "MM";
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
	String formattedDate = currentDate.format(formatter);
	return formattedDate.toUpperCase();
} catch (Exception e) {
	log(Status.FAIL, e.getMessage());
	e.printStackTrace();
	throw new Exception("Facing exception in getCurrentMonth() Method");
}
}
	
	
	public String dateConversionForHandleAlert(String Date, String Time) throws ParseException {
					
		        // Specify the input date format
	        SimpleDateFormat inputFormat = new SimpleDateFormat("M/dd/yyyy hh:mma", Locale.ENGLISH);

	        // Specify the desired output date format
	        SimpleDateFormat outputFormat = new SimpleDateFormat("EEEE, MMMM dd yyyy, hh:mm a", Locale.ENGLISH);

	        // Parse the input date string
				Date date = inputFormat.parse(Date+" "+Time);
				
				// Format the date to the desired output format
				String outputDateString = outputFormat.format(date);
				return outputDateString;
				
}
	
	
	public String dayMonthYearConversion(String DMY, String time) {
	
	 SimpleDateFormat inputFormat = new SimpleDateFormat("M/d/yyyy hh:mma", Locale.ENGLISH);

     // Define the desired output date format
     SimpleDateFormat outputFormat = new SimpleDateFormat("EEEE, MMMM d yyyy, hh:mm a", Locale.ENGLISH);

     // Provide an example input date string
    // String inputDateString = "2/1/2024 10:30AM";
     
     String outputDateString = null;

     try {
         // Parse the input date string
         Date date = inputFormat.parse(DMY+" "+time);

         // Format the day using single 'd' if the day is before 10, 'dd' otherwise
         String dayFormat = (date.getDate() < 9) ? "d" : "dd";
         outputFormat.applyPattern("EEEE, MMMM " + dayFormat + " yyyy, hh:mm a");

         // Format the parsed date using the output format
         outputDateString = outputFormat.format(date);

         System.out.println("Input Date: " + date);
         System.out.println("Output Date: " + outputDateString);
     } catch (ParseException e) {
         e.printStackTrace();
     }
     
    	 return outputDateString;
	}
	

	
}
