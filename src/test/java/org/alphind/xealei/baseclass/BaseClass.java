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
import org.openqa.selenium.ElementClickInterceptedException;
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

import groovyjarjarantlr4.v4.parse.ANTLRParser.parserRule_return;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.timeout.TimeoutException;

public class BaseClass {

	// Driver initialized in class level
	protected Scenario s;
	// public ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();

	public static WebDriver driver;

	/**
	 * Sets up a WebDriver instance based on the browser type specified in the
	 * configuration properties.
	 * 
	 * @Created by Nandhalala
	 *
	 */
	public void browserType() throws Exception {

		if (getConfigureProperty("Browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(getChromeOptions());
			log(Status.INFO, "Browser launched in Chrome");

		} else if (getConfigureProperty("Browser").equalsIgnoreCase("edge")) {
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver(getEdgeOptions());
			log(Status.INFO, "Browser launched in Chrome");

		} else if (getConfigureProperty("Browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver(getFirefoxOptions());
			log(Status.INFO, "Browser launched in Chrome");
		} else {
			log(Status.FAIL, "Browser Value is not valid in config.properties file.");
			throw new Exception("Browser Value is not valid in config.properties file.");
		}
	}

	/**
	 * Retrieves a new instance of WebDriver based on the browser type specified in
	 * the configuration properties.
	 * 
	 * @Created by Nandhalala
	 * 
	 */
	public WebDriver getNewDriver() throws Exception {

		WebDriver newDriver;

		if (getConfigureProperty("Browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			newDriver = new ChromeDriver(getChromeOptions());
			log(Status.INFO, "Browser launched in Chrome");

		} else if (getConfigureProperty("Browser").equalsIgnoreCase("edge")) {
			WebDriverManager.chromedriver().setup();
			newDriver = new EdgeDriver(getEdgeOptions());
			log(Status.INFO, "Browser launched in Chrome");

		} else if (getConfigureProperty("Browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			newDriver = new FirefoxDriver(getFirefoxOptions());
			log(Status.INFO, "Browser launched in Chrome");
		} else {
			log(Status.FAIL, "Browser Value is not valid in config.properties file.");
			throw new Exception("Browser Value is not valid in config.properties file.");
		}

		return newDriver;

	}

	/**
	 * Generates ChromeOptions based on the configuration properties, including
	 * headless mode if specified
	 * 
	 * @Created by Nandhalala
	 * 
	 */
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

	/**
	 * Generates EdgeOptions based on the configuration properties, including
	 * headless mode if specified
	 * 
	 * @Created by Nandhalala
	 * 
	 */
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

	/**
	 * Generates FirefoxOptions based on the configuration properties, including
	 * headless mode if specified
	 * 
	 * @Created by Nandhalala
	 */
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

	/**
	 * 
	 * Send the Data's to the specified WebElement.
	 * 
	 * @param element
	 * @param datasToSend
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public void sendKeys(WebElement element, String datasToSend) {
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		try {
			element.sendKeys(datasToSend);
			log(Status.INFO, "Data entered in the " + methodName + " field is - " + datasToSend);
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
		}
	}

	/**
	 * 
	 * Send the Data's to the specified WebElement.
	 * 
	 * @param element
	 * @param datasToSend
	 * 
	 * @Created by Nandhalala
	 * 
	 */
	public void sendKeyswithException(WebElement element, String datasToSend) {
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		try {
			element.sendKeys(datasToSend);
			log(Status.INFO, "Data entered in the " + methodName + " field is - " + datasToSend);
		} catch (Exception e) {

		}

	}

	/**
	 * Sends a Backspace key to the specified WebElement to delete the last
	 * character.
	 * 
	 * @param element
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void backSpace(WebElement element) {

		element.sendKeys(Keys.BACK_SPACE);
		log(Status.INFO, "Delete the last keyword");
	}

	/**
	 * Retrieves the value of the specified attribute from the WebElement.
	 * 
	 * @param element
	 * @param value
	 * @return elementValue
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public String getAttribute(WebElement element, String value) {

		String text = element.getAttribute(value);
		return text;

	}

	/**
	 * Sets the implicit wait time for the WebDriver to the specified number of
	 * seconds.
	 * 
	 * @param seconds
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void implicitWaitBySeconds(long seconds) {
		// dr.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	/**
	 * Waits for the alert to be present for the specified number of seconds.
	 * 
	 * @param seconds
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void waitForAlertIsPresent(long seconds) {
		// WebDriverWait wait = new WebDriverWait(dr.get(),
		// Duration.ofSeconds(seconds));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	/**
	 * Waits for the specified WebElement to be clickable for the given number of
	 * seconds.
	 * 
	 * @param element
	 * @param seconds
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void waitForElementToBeClickable(WebElement element, long seconds) {
		// WebDriverWait wait = new WebDriverWait(dr.get(),
		// Duration.ofSeconds(seconds));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Takes a screenshot of the current page
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Takes a screenshot of the current page
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public String takesScreenshot(WebDriver currentDriver) {

		return ((TakesScreenshot) currentDriver).getScreenshotAs(OutputType.BASE64);

	}

	/**
	 * Clicks on the specified WebElement.
	 * 
	 * @param element
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Simulates clicking the Enter key on the specified WebElement.
	 * 
	 * @param element
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void clickEnter(WebElement element) {
		try {
			element.sendKeys(Keys.ENTER);
			log(Status.INFO, "Click ENTER key");
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Simulates (force) clicking the Enter key on the specified WebElement.
	 * 
	 * @param element
	 * 
	 * @Created by Nandhalala
	 */
	public void forceClick(WebElement element) {
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		while (true) {
			try {
				element.click();
				log(Status.INFO, "Click the " + methodName);
				break;
			} catch (ElementClickInterceptedException e) {
				continue;
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}

	}

	/**
	 * Deletes the existing data in the specified WebElement field.
	 * 
	 * @param element
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Deletes the existing data in the specified WebElement field using
	 * (backspace).
	 * 
	 * @param element
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Close the browser
	 * 
	 * @param element
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void close() {
		// dr.get().close();
		log(Status.INFO, "Close the browser");
		driver.close();
	}

	/**
	 * Quit the browser
	 * 
	 * @param element
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void quit() {
		// dr.get().quit();
		log(Status.INFO, "Quit the browser");
		driver.quit();
	}

	/**
	 * 
	 * @return WebDriver instance.
	 */
	public static WebDriver getDriver() {
		return driver;
	}

	/**
	 * Read data from last row of an Excel file.
	 * 
	 * @param fileName  The name of the Excel file.
	 * @param sheetName The name of the sheet in the Excel file.
	 * @param rowNum    The row number where the data will be taken.
	 * @param cellNum   The cell number where the data will be taken.
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Read data from last row of an Excel file.
	 * 
	 * @param fileName  The name of the Excel file.
	 * @param sheetName The name of the sheet in the Excel file.
	 * @param cellNum   The cell number where the data will be taken.
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * Retrieves the value associated with the specified key from the configuration
	 * properties.
	 *
	 * @param key The key whose associated value is to be retrieved.
	 * 
	 * @return The value associated with the specified key, or null if no value is
	 *         found.
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Retrieves the value associated with the specified key from the Spark
	 * configuration.
	 *
	 * @param key The key whose associated value is to be retrieved.
	 * 
	 * @return The value associated with the specified key, or null if no value is
	 *         found.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public String getSparkConfig(String key) {

		try {
			FileInputStream stream = new FileInputStream(".extent.properties");
			Properties properties = new Properties();
			properties.load(stream);
			return properties.get(key).toString();
		} catch (IOException e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * Waits for the specified WebElement to be clickable within the given time
	 * duration.
	 *
	 * @param element The WebElement to wait for.
	 * @param seconds The time duration to wait in seconds.
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Waits for the specified text to be present in the WebElement within the given
	 * time duration.
	 *
	 * @param element The WebElement to wait for.
	 * @param text    The text to wait for.
	 * @param seconds The time duration to wait in seconds.
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Waits for the specified WebElement to be visible within the given time
	 * duration.
	 *
	 * @param element The WebElement to wait for.
	 * @param seconds The time duration to wait in seconds.
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Finds the first WebElement using the given tag name.
	 *
	 * @param tagName The tag name of the element to find.
	 * 
	 * @return The first WebElement with the given tag name
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public WebElement findElementByTagName(String tagName) {

		// WebElement element = dr.get().findElement(By.tagName(tagName));
		WebElement element = driver.findElement(By.tagName(tagName));
		return element;
	}

	/**
	 * Finds the first WebElement using the given xpath.
	 *
	 * @param xpath The tag name of the element to find.
	 * 
	 * @return The first WebElement with the given xpath
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public WebElement findElementByXpath(String xpath) {

		// WebElement elements = dr.get().findElement(By.xpath(xpath));
		WebElement elements = driver.findElement(By.xpath(xpath));
		return elements;
	}

	/**
	 * Finds the first WebElement using the given XPath expression.
	 *
	 * @param currentDriver The WebDriver instance to use for finding the element.
	 * @param xpath         The XPath expression to locate the element.
	 * 
	 * @return The first WebElement found using the XPath expression, or null if no
	 *         such element is found.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public WebElement findElementByXpath(WebDriver currentDriver, String xpath) {

		// WebElement elements = dr.get().findElement(By.xpath(xpath));
		WebElement elements = currentDriver.findElement(By.xpath(xpath));
		return elements;
	}

	/**
	 * Select an option from a dropdown menu using the given XPath.
	 *
	 * @param elementxpath The XPath of the dropdown element.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void select(String elementxpath) {
		// click(dr.get().findElement(By.xpath(elementxpath)));
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		try {

			click(driver.findElement(By.xpath(elementxpath)));
			log(Status.INFO, "Select the " + methodName);
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
		}
	}

	/**
	 * Selects an option from a dropdown menu using the given XPath with the
	 * specified WebDriver instance.
	 *
	 * @param driver       The WebDriver instance to use for selecting the option.
	 * @param elementxpath The XPath expression of the dropdown element.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void select(WebDriver driver, String elementxpath) {
		// click(dr.get().findElement(By.xpath(elementxpath)));
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		try {

			click(driver.findElement(By.xpath(elementxpath)));
			log(Status.INFO, "Select the" + methodName);
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
		}
	}

	/**
	 * Generates the current date and time.
	 *
	 * @return A string representing the current date and time.
	 * @throws Exception If an error occurs while retrieving the date and time.
	 *
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Writes data to an Excel file.
	 *
	 * @param fileName    The name of the Excel file.
	 * @param sheetname   The name of the sheet in the Excel file.
	 * @param cellnum     The cell number where the new data will be written.
	 * @param newdatacell The new data to be written to the specified cell.
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Writes data (Overwrite) to an Excel file.
	 *
	 * @param fileName    The name of the Excel file.
	 * @param sheetname   The name of the sheet in the Excel file.
	 * @param cellnum     The cell number where the new data will be written.
	 * @param rowNum      The row number where the new data will be written.
	 * @param newdatacell The new data to be written to the specified cell.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public String writeExcelToOverwrite(String fileName, String sheetname, int rowNum, int cellnum,
			String newdatacell) {

		File file = new File(".//Excel//" + fileName + ".xlsx");
		try {
			FileInputStream stream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(stream);
			Sheet sheet = workbook.getSheet(sheetname);
			Row row = sheet.getRow(rowNum);
			Cell cell = row.getCell(cellnum);
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

	/**
	 * Writes data to the last row of a specific column in an Excel file.
	 *
	 * @param fileName    The name of the Excel file.
	 * @param sheetname   The name of the sheet in the Excel file.
	 * @param cellnum     The column number where the new data will be written.
	 * @param newdatacell The new data to be written to the specified column in the
	 *                    last row.
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Retrieves the text from the specified WebElement.
	 *
	 * @param element The WebElement from which to retrieve the text.
	 * @return The text retrieved from the WebElement.
	 *
	 * @author Alphi-MohamedRazul
	 */
	public String getText(WebElement element) {

		try {
			String text = element.getText();
			return text;
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Sends keys followed by Enter key to the specified WebElement.
	 *
	 * @param element The WebElement to which keys are sent.
	 * @param data    The data to be sent to the WebElement.
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Waits for the specified WebElement to be visible within the given time
	 * duration.
	 *
	 * @param element The WebElement to wait for visibility.
	 * @param seconds The time duration to wait in seconds.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void waitForVisiblityOfElement(WebElement element, long seconds) {
		// WebDriverWait wait = new WebDriverWait(dr.get(),
		// Duration.ofSeconds(seconds));
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			// wait.until(ExpectedConditions.elementToBeClickable(element));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves the text content of the WebElement identified by the given XPath.
	 *
	 * @param elementxpath The XPath identifying the WebElement.
	 * @return The text content of the identified WebElement.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public String getTextString(String elementxpath) {
		// String text = getText(dr.get().findElement(By.xpath(elementxpath)));
		String text = getText(driver.findElement(By.xpath(elementxpath)));
		return text;
	}

	/**
	 * Retrieves the text content of the WebElement identified by the given XPath
	 * using the specified WebDriver instance.
	 *
	 * @param currentdriver The WebDriver instance to use for finding the
	 *                      WebElement.
	 * @param elementxpath  The XPath identifying the WebElement.
	 * @return The text content of the identified WebElement.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public String getTextString(WebDriver currentdriver, String elementxpath) {
		// String text = getText(dr.get().findElement(By.xpath(elementxpath)));
		String text = getText(currentdriver.findElement(By.xpath(elementxpath)));
		return text;
	}

	/**
	 * Waits for page loading to complete.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void waitForPageLoad() {

		try {
			WebElement loading = driver.findElement(By.xpath("//span[contains(@class,'cloader')]"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
			wait.until(ExpectedConditions.invisibilityOf(loading));
		} catch (NoSuchElementException e) {
		}

	}

	/**
	 * Waits for AJAX page loading to complete.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void waitForAjexPageLoad() {

		try {
			WebElement loading = driver.findElement(By.xpath("//progress[@class='ajaxProgress']"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
			wait.until(ExpectedConditions.invisibilityOf(loading));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Waits for the page to be fully loaded using the specified WebDriver instance.
	 *
	 * @param currentdriver The WebDriver instance to use for waiting.
	 * 
	 * @author Nandhalala
	 */
	public void waitForPageLoad(WebDriver currentdriver) {

		try {
//			WebElement loading = dr.get().findElement(By.xpath("//div[contains(text(),'Loading')]"));
//			WebDriverWait wait = new WebDriverWait(dr.get(), Duration.ofMinutes(3));
			WebElement loading = currentdriver.findElement(By.xpath("//span[contains(@class,'cloader')]"));
			WebDriverWait wait = new WebDriverWait(currentdriver, Duration.ofMinutes(3));
			wait.until(ExpectedConditions.invisibilityOf(loading));
		} catch (NoSuchElementException e) {

		}

	}

	/**
	 * Pauses the execution for the specified number of milliseconds.
	 *
	 * @param millis The number of milliseconds to pause the execution.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void sleep(long millis) {

		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Uploads an image from the specified image path using robot class.
	 *
	 * @param imagePath The path to the image/file to be uploaded.
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Cleans records from the database based on the provided parameters.
	 *
	 * @param cleanRecord    A boolean indicating whether to clean records from the
	 *                       database.
	 * @param collectionName The name of the collection/table from which records
	 *                       will be cleaned.
	 * @param key            The key to identify the record(s) to be cleaned.
	 * @param value          The value associated with the key to identify the
	 *                       record(s) to be cleaned.
	 *
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Waits for the specified WebElement to become invisible within the given time
	 * duration.
	 *
	 * @param element The WebElement to wait for invisibility.
	 * @param seconds The time duration to wait in seconds.
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Waits for the specified WebElement to become invisible using the specified
	 * WebDriver instance within the given time duration .
	 *
	 * @param currentdriver The WebDriver instance to use for waiting.
	 * @param element       The WebElement to wait for invisibility.
	 * @param seconds       The time duration to wait in seconds.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void waitForInVisiblityOfElement(WebDriver currentdriver, WebElement element, long seconds) {
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

	/**
	 * Clears the text present in the specified WebElement.
	 *
	 * @param element The WebElement from which to clear the text.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void clearText(WebElement element) {
		element.clear();
	}

	/**
	 * Choose the environment(Url) based on the specified key value from the
	 * configuration properties.
	 * 
	 * @author Alphi-MohamedRazul
	 * @throws Exception If there is an error while retrieving the current URL.
	 */
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

	/**
	 * Retrieves the current URL from the browser.
	 *
	 * @return The current URL as a string.
	 * @throws Exception If there is an error while retrieving the current URL.
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Retrieves the current URL from the specified WebDriver instance.
	 *
	 * @param driver The WebDriver instance from which to retrieve the current URL.
	 * @return The current URL as a string.
	 * @throws Exception If there is an error while retrieving the current URL.
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Scrolls the page to bring the specified WebElement into view.
	 *
	 * @param element The WebElement to scroll into view.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void scrollIntoView(WebElement element) {

		// JavascriptExecutor executor = (JavascriptExecutor)dr.get();
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			// .scrollIntoView(true);
			executor.executeScript("argument[0].scrollIntoView(true);", element);
			log(Status.INFO, "Scroll into an view");
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Scrolls down to the bottom of the page.
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Waits for the full page loaded.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void waitForFullPageElementLoad() {

		driver.manage().timeouts().getPageLoadTimeout();
	}

	/**
	 * Waits for the full page loaded from the specified WebDriver instance.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void waitForFullPageElementLoad(WebDriver currentdriver) {

		currentdriver.manage().timeouts().getPageLoadTimeout();
	}

	private static ExtentReports extent;
	private static ExtentSparkReporter spark;
	public static ExtentTest test;

	/**
	 * Extent Report setup configuration.
	 * 
	 * @author Nadhalala
	 */
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

	/**
	 * Flushes the report, after all information is written to the report output.
	 *
	 * @author Nadhalala
	 */
	public void reportFlush() {

		extent.flush();
	}

	/**
	 * Decides the log screenshot, specified in the configuration properties.
	 *
	 * @param status  The status of the log message.
	 * @param message The message to be logged.
	 * 
	 * @author Nadhalala
	 */
	public void log(Status status, String message) {

		String passed = getConfigureProperty("PassedScreenshots");
		String failed = getConfigureProperty("FailedScreenshots");

		if (getConfigureProperty("IgnoreInfo").equalsIgnoreCase("No")) {

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

		} else if (getConfigureProperty("IgnoreInfo").equalsIgnoreCase("Yes")) {
			if (!status.toString().equalsIgnoreCase("INFO")) {
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

	/**
	 * Waits for the specified WebElement to become visible within the given time
	 * duration,
	 *
	 * @param element The WebElement to wait for visibility.
	 * @param seconds The time duration to wait in seconds.
	 * @throws TimeoutException If the element is not visible within the specified
	 *                          time.
	 * 
	 * @author Nandhalala
	 */
	public void waitForVisiblityOfElementwithException(WebElement element, long seconds) {
		// WebDriverWait wait = new WebDriverWait(dr.get(),
		// Duration.ofSeconds(seconds));
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * Decides the log screenshot, specified in the configuration properties from
	 * the specified WebDriver instance..
	 *
	 * @param status        The status of the log message.
	 * @param message       The message to be logged.
	 * @param currentDriver The WebDriver instance from which to retrieve the
	 *                      current URL.
	 * 
	 * @author Nadhalala
	 */
	public void log(Status status, String message, WebDriver currentDriver) {

		String passed = getConfigureProperty("PassedScreenshots");
		String failed = getConfigureProperty("FailedScreenshots");
		if (getConfigureProperty("IgnoreInfo").equalsIgnoreCase("No")) {

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
		} else if (getConfigureProperty("IgnoreInfo").equalsIgnoreCase("Yes")) {

			if (!status.toString().equalsIgnoreCase("INFO")) {
				if (passed.equalsIgnoreCase("Yes") && failed.equalsIgnoreCase("Yes")
						&& (status.toString().equalsIgnoreCase("PASS") || status.toString().equalsIgnoreCase("FAIL"))) {
					test.log(status, message, MediaEntityBuilder
							.createScreenCaptureFromBase64String(takesScreenshot(currentDriver)).build());

				} else if (passed.equalsIgnoreCase("Yes") && failed.equalsIgnoreCase("No")
						&& status.toString().equalsIgnoreCase("PASS")) {
					test.log(status, message, MediaEntityBuilder
							.createScreenCaptureFromBase64String(takesScreenshot(currentDriver)).build());
				} else if (passed.equalsIgnoreCase("No") && failed.equalsIgnoreCase("Yes")
						&& status.toString().equalsIgnoreCase("FAIL")) {
					test.log(status, message, MediaEntityBuilder
							.createScreenCaptureFromBase64String(takesScreenshot(currentDriver)).build());
				} else {
					test.log(status, message);
				}
			}
		}
	}

	/**
	 * Navigates the browser to the previous page.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void pageBackward() {

		try {
			driver.navigate().back();
			log(Status.PASS, "Navigate to backward (Back to Login page)");
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Logs the provided message with the specified status and label color.
	 *
	 * @param name The message to be logged.
	 * 
	 * @author Alphi-MohamedRazul
	 * 
	 */
	public void logWithLabelName(String name) {
		test.log(Status.INFO, MarkupHelper.createLabel(name, ExtentColor.AMBER));
	}

	/**
	 * Retrieves the name of the calling method.
	 *
	 * @return The name of the calling method.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public String getMethodName() {

		String name = Thread.currentThread().getStackTrace()[2].getMethodName();
		return name;
	}

	/**
	 * Refreshes the current page in the browser.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public void pageRefresh() {

		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Creates a DateTimeFormatter in (minutes & seconds).
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Scrolls into top of the page.
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Obtains the current date, increments it by one day, and returns the
	 * incremented date as a string.
	 *
	 * @param num The string (num) that need to increment
	 * @return The incremented date as a string.
	 * @throws Exception If an error occurs during the process.
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Retrieves the next day's date as a string.
	 *
	 * @return The next day's date as a string.
	 * @throws Exception If an error occurs during the process.
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Retrieves the current date and time with the specified pattern and returns it
	 * as a string.
	 *
	 * @param EnterPattern The pattern to format the current date and time.
	 * @return The current date and time formatted as per the given pattern.
	 * @throws Exception If an error occurs during the process.
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Retrieves the future date and time, which is three minutes ahead of the
	 * current date and time in the Asia/Kolkata timezone.
	 *
	 * @param EnterPattern The pattern to format the future date and time.
	 * @return The future date and time formatted as per the given pattern.
	 * @throws Exception If an error occurs during the process.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public String getFutureTime(String EnterPattern) throws Exception {

		try {
			LocalDateTime currentDateYearMonth = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
			LocalDateTime plusMinutes = currentDateYearMonth.plusMinutes(3);
			DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern(EnterPattern);
			String DateAsPerGiven = plusMinutes.format(ofPattern).toUpperCase();
			return DateAsPerGiven;
		} catch (Exception e) {
			log(Status.FAIL, e.getMessage());
			e.printStackTrace();
			throw new Exception("Facing exception in getFutureTime() Method");
		}

	}

	/**
	 * Retrieves the past date and time ahead of the current date and time in the
	 * Europe/London timezone.
	 *
	 * @param EnterPattern The pattern to format the past date and time.
	 * @return The past date and time formatted as per the given pattern.
	 * @throws Exception If an error occurs during the process.
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Obtains the current date, and returns the date as a string.
	 *
	 * @return The date as a string.
	 * @throws Exception If an error occurs during the process.
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Generate Random 10 digits Mobile Number.
	 * 
	 * @return The number as string
	 * @throws Exception If an error occurs during the process.
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Obtains the current month, decrement it by one month, and returns the
	 * decremented month as a string.
	 *
	 * @param pattern
	 * @return The decrement month as a string.
	 * @throws Exception If an error occurs during the process.
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Get the current month as string.
	 * 
	 * @return Current month as string.
	 * 
	 * @throws Exception If an error occurs during the process.
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Get the current year as string and check whether the year is current year or
	 * not.
	 * 
	 * @return Current year as string.
	 * 
	 * @throws Exception If an error occurs during the process.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public String getYear() {

		LocalDate currentDate = LocalDate.now();

		if (currentDate.getMonth().toString().equals("JANUARY")) {
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

	/**
	 * Get the current month as string.
	 * 
	 * @return Current month as string.
	 * 
	 * @throws Exception If an error occurs during the process.
	 * 
	 * @author Alphi-MohamedRazul
	 */
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

	/**
	 * Converts the provided date and time strings into a format.
	 *
	 * @param Date The date string to be converted.
	 * @param Time The time string to be converted.
	 * @return A formatted string representing the combined date and time.
	 * @throws ParseException If an error occurs during the parsing process.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public String dateConversionForHandleAlert(String Date, String Time) throws ParseException {

		// Specify the input date format
		SimpleDateFormat inputFormat = new SimpleDateFormat("M/dd/yyyy hh:mma", Locale.ENGLISH);

		// Specify the desired output date format
		SimpleDateFormat outputFormat = new SimpleDateFormat("EEEE, MMMM dd yyyy, hh:mm a", Locale.ENGLISH);

		// Parse the input date string
		Date date = inputFormat.parse(Date + " " + Time);

		// Format the date to the desired output format
		String outputDateString = outputFormat.format(date);
		return outputDateString;

	}

	/**
	 * Converts the provided date and time strings into a format.
	 *
	 * @param DMY  The date string to be converted.
	 * @param time The time string to be converted.
	 * @return A formatted string representing the combined date and time.
	 * @throws ParseException If an error occurs during the parsing process.
	 * 
	 * @author Alphi-MohamedRazul
	 */
	public String dayMonthYearConversion(String DMY, String time) {

		SimpleDateFormat inputFormat = new SimpleDateFormat("M/d/yyyy hh:mma", Locale.ENGLISH);

		// Define the desired output date format
		SimpleDateFormat outputFormat = new SimpleDateFormat("EEEE, MMMM d yyyy, hh:mm a", Locale.ENGLISH);

		// Provide an example input date string
		// String inputDateString = "2/1/2024 10:30AM";

		String outputDateString = null;

		try {
			// Parse the input date string
			Date date = inputFormat.parse(DMY + " " + time);

			// Format the day using single 'd' if the day is before 10, 'dd' otherwise
			String dayFormat = (date.getDate() <= 9) ? "d" : "dd";
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