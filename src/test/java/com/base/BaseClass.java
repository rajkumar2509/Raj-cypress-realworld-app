package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	
	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;
	}
	public byte[] screenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] b = screenshot.getScreenshotAs(OutputType.BYTES);
		return b;
	}
	public static String getPropertyFilevalue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath() + "\\Config\\Config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;
	}
	public static void getDriver(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");

			driver = new ChromeDriver(options);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			break;
		}
	}
	public static void getChromeDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		
	}
	public static void getFirefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	public static void getEdgeDriver() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	public static void enterApplnUrl(String url) {
		driver.get(url);
	}
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}
	public void enter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public void elementSendKeys(WebElement element, String data) {
		element.sendKeys(data);
	}
	public void elementSendKeysJs(WebElement element, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttributes('value', '" + data + "')", element);
	}
	public void jsClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
	}
	public Object jsGetAttribute(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object executeScript = executor.executeScript("return arguments[0].getAttribute('value')", element);
		return executeScript;
	}
	public void jsScrollDown(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	public void jsScrollUp(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(false)", element);
	}
	public void elementClick(WebElement element) {
		element.click();
	}
	public String getApplnTitle() {
		String title = driver.getTitle();
		return title;
	}
	public WebElement findElementById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}
	public WebElement findElementByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;
	}
	public WebElement findElementByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
	}
	public WebElement findElementByXpath(String xpathExpression) {
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		return element;
	}
	public WebElement findElementByTagName(String attributeValue) {
		WebElement element = driver.findElement(By.tagName(attributeValue));
		return element;
	}
	public WebElement findElementByLinkedText(String attributeValue) {
		WebElement element = driver.findElement(By.linkText(attributeValue));
		return element;
	}
	public WebElement findElementByCssSeletor(String attributeValue) {
		WebElement element = driver.findElement(By.cssSelector(attributeValue));
		return element;
	}
	public WebElement findElementByPartialLT(String partialLinkText) {
		WebElement element = driver.findElement(By.partialLinkText(partialLinkText));
		return element;
	}
	public String getApplnUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	public String elementGetText(WebElement element) {
		String text = element.getText();
		return text;
	}
	public void closeWindow() {
		driver.close();
	}
	public static void quitWindow() {
		driver.quit();
	}
	public String elementGetAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}
	public String elementGetAttribute(WebElement element, String attributeName) {
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}
	public void selectOptionByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	public WebElement firstSelectedOptiontext(WebElement element) {
		Select select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		return firstSelectedOption;
	}
	public boolean multiselectOption(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}
	public List<WebElement> getOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}
	public void selectOptionByAttribute(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	public void selectOptionByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public void deselectOptionByText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}
	public void deselectOptionByAttribute(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}
	public void deselectOptionByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}
	public void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}
	public void okInAlert(Alert alert) {
		alert.accept();
	}
	public void clickOkAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public void cancelInAlert(Alert alert) {
		alert.dismiss();
	}
	public Alert switchToAlert() {
		Alert alert = driver.switchTo().alert();
		return alert;
	}
	public WebDriver switchToFrameByName(String name) {
		WebDriver frame = driver.switchTo().frame(name);
		return frame;
	}
	public WebDriver switchToFrameByIndex(int index) {
		WebDriver frame = driver.switchTo().frame(index);
		return frame;
	}
	public WebDriver switchToFrameByFrameId(String text) {
		WebDriver frame = driver.switchTo().frame(text);
		return frame;
	}
	public WebDriver switchToFrameByWebElement(WebElement element) {
		WebDriver frame = driver.switchTo().frame(element);
		return frame;
	}
	public WebDriver previousframe() {
		WebDriver parentFrame = driver.switchTo().parentFrame();
		return parentFrame;
	}
	public WebDriver goToWebpage() {
		WebDriver defaultContent = driver.switchTo().defaultContent();
		return defaultContent;
	}
	public boolean verifyIsDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}
	public boolean verifyIsEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}
	public boolean verifyIsSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}
	public String getParentWindow() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}
	public Set<String> getAllWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}
	public WebDriver switchToChildWindow(String id) {
		WebDriver window = driver.switchTo().window(id);
		return window;
	}
	public void clearTextBox(WebElement element) {
		element.clear();
	}
	public File takeScreenshot() {
		TakesScreenshot take = (TakesScreenshot) driver;
		File screenshotAs = take.getScreenshotAs(OutputType.FILE);
		return screenshotAs;
	}
	public File takeScreenshotForElement(WebElement element) {
		TakesScreenshot take = (TakesScreenshot) element;
		File screenshotAs = take.getScreenshotAs(OutputType.FILE);
		return screenshotAs;
	}
	public void mouseOverActionForSingleOption(WebElement element) {
		Actions obj = new Actions(driver);
		obj.moveToElement(element).perform();
	}
	public void dragAndDrop(WebElement element) {
		Actions obj = new Actions(driver);
		obj.dragAndDrop(element, element).perform();
	}
	public void rightClick(WebElement element) {
		Actions obj = new Actions(driver);
		obj.contextClick(element).perform();
	}
	public void doubleClick(WebElement element) {
		Actions obj = new Actions(driver);
		obj.doubleClick(element).perform();
	}
	public void robotKeyPress() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
	}
	public void robotKeyRelease() throws AWTException {
		Robot robot = new Robot();
		robot.keyRelease(KeyEvent.VK_DOWN);
	}
	public void navigateTo(String url) {
		driver.navigate().to(url);
	}
	public void navigateBack() {
		driver.navigate().back();
	}
	public void navigateForward() {
		driver.navigate().forward();
	}
	public void navigateRefresh() {
		driver.navigate().refresh();
	}
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	// Read value from Excel sheet
	public String readDataFromCell(String sheetName, int rownum, int cellnum) throws IOException {
		String res = "";
		File file = new File("C:\\Users\\jackr\\eclipse-workspace\\FrameworkDay1Task\\Excel\\TaskWorkbook (1).xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType type = cell.getCellType();

		switch (type) {
		case STRING:
			res = cell.getStringCellValue();
			break;

		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				res = dateFormat.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long check = Math.round(numericCellValue);
				if (check == Math.round(numericCellValue)) {
					res = String.valueOf(check);
				} else {
					res = String.valueOf(numericCellValue);
				}
			}
			break;

		default:

			break;
		}
		return res;
	}
	// Update or replace the existing data in Excel file
	public void updateCellData(String sheetName, int rownum, int cellnum, String oldData, String newData)
			throws IOException {
		File file = new File("C:\\Users\\jackr\\eclipse-workspace\\FrameworkDay1Task\\Excel\\TaskWorkbook (1).xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();

		if (value.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
	}
	// Create cell and insert value
		public void createAndInsertValue(String sheetName, int rownum, int cellnum, String data) throws IOException {
			File file = new File("C:\\Users\\jackr\\eclipse-workspace\\FrameworkDay1Task\\Excel\\TaskWorkbook (1).xlsx");
			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rownum);
			Cell cell = row.createCell(cellnum);

			cell.setCellValue(data);

			FileOutputStream fileOutputStream = new FileOutputStream(file);
			workbook.write(fileOutputStream);
		}
}
