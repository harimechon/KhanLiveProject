package com.khanacademy.resources;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.maven.shared.utils.io.FileUtils;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FunctionalLibrary {
	public static WebDriver driver;
	private static String homeWindow = null;

	public static WebDriver driverInit(String BrowserName) {

		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\lib\\chromedriver.exe");
		if (BrowserName.equals("Chrome")) {
			driver = new ChromeDriver();
			driver.get("https://www.khanacademy.org/");
			driver.manage().window().maximize();
		}

		else if (BrowserName.equals("ie")) {
			driver = new InternetExplorerDriver();
		}

		else if (BrowserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}

	/**
	 * To Launch the browser
	 * 
	 * @param browser
	 * @return
	 */

	public static String getCurrentDate() {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
		LocalDate now = LocalDate.now();
		String exec_Date = now.toString(fmt);
		return exec_Date;
	}

	public static String getCurrentTime() {
		LocalDateTime now = LocalDateTime.now();
		int hour = now.getHourOfDay();
		int minute = now.getMinuteOfHour();
		int second = now.getSecondOfMinute();
		String exec_StartTime = hour + ":" + minute + ":" + second;
		return exec_StartTime;
	}

	/**
	 * Method to accept alert
	 */
	public static void accept_Alert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	/**
	 * Method to Capture screen
	 * 
	 * @return
	 * @throws IOException
	 **/

	public static String screenCapture(String imgLocation) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(imgLocation));
		return imgLocation;
	}

	/**
	 * Method to switch to the newly opened window
	 */
	public static void switchToWindow() {
		homeWindow = driver.getWindowHandle();
		for (String window : driver.getWindowHandles()) {
			driver.switchTo().window(window);
		}
	}

	/**
	 * To navigate to the main window from child window
	 */
	public static void switchToMainWindow() {
		for (String window : driver.getWindowHandles()) {
			if (!window.equals(homeWindow)) {
				driver.switchTo().window(window);
				driver.close();
			}
			driver.switchTo().window(homeWindow);
		}
	}

	/**
	 * This method returns the no.of windows present
	 * 
	 * @return
	 */
	public static int getWindowCount() {
		return driver.getWindowHandles().size();
	}

	/****************** frames *********************/

	public static void frames(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	public static void switchToDefaultcontent() {
		try {
			driver.switchTo().defaultContent();
		} catch (NoSuchElementException e) {
		}
	}

	public static void navigateToUrl(String url) {
		driver.navigate().to(url);

	}

	public static void closeBrowser() {
		driver.close();
	}

	public static void setText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	/**
	 * Verifying the visibility of element only for assert conditions
	 */

	public static boolean isElementPresent(WebElement element) {
		boolean elementPresent = false;
		waitForElementVisibility(element);
		if (element.isDisplayed()) {
			elementPresent = true;
		}
		return elementPresent;
	}

	/**
	 * Verifying the visibility of element only for assert conditions
	 */

	public static boolean isElementNotPresent(WebElement element) {
		boolean elementNotPresent = true;
		if (element.isDisplayed()) {
			elementNotPresent = false;
		}
		return elementNotPresent;
	}

	/**
	 * Method to click the element
	 * 
	 * @param object
	 */
	public static void click(WebElement ele) {
		ele.click();

	}

	/******************
	 * getting the text from non editable field
	 *********************/

	public static String getText(WebElement element) {
		String text = null;
		waitForElementVisibility(element);
		if (element.getText() != null) {
			text = element.getText();
		}
		return text;
	}

	/**
	 * Method to get the value from textbox
	 * 
	 * @param element
	 * @return
	 */
	public static String getValue(WebElement element) {
		String value = null;
		waitForElementVisibility(element);
		if (element.getAttribute("value") != null) {
			value = element.getAttribute("value");
		}
		return value;
	}

	/**
	 * Method to select the option from dropdown by value
	 */
	public static void selectByValue(WebElement element, String value) {
		Select obj_select = new Select(element);
		obj_select.selectByValue(value);
	}

	/**
	 * Method to select the option from drop down by visible text
	 */
	public static void selectByText(WebElement element, String Text) {
		Select obj_select = new Select(element);
		obj_select.selectByVisibleText(Text);
	}

	/**
	 * Method to select the option from dropdown by index
	 */
	public static void selectByIndex(WebElement element, int index) {
		Select obj_select = new Select(element);
		obj_select.selectByIndex(index);
	}

	/**
	 * To pause execution until get expected elements visibility
	 * 
	 * @param element
	 */
	public static void waitForElementVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForElementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForTitle(String title) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.titleContains(title));
	}

	/**
	 * To pause the execution @throws
	 */
	public static void pause(int milliSeconds) throws InterruptedException {
		Thread.sleep(milliSeconds);
	}

	/**
	 * To create a connectivity to Database and update the scenario execution status
	 */
	public static void createDBConnection(String scName, String scStatus) {
		try {
			// convert current date from string to sql date data type
			String currentDate = getCurrentDate();
			DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = dateFormatter.parse(currentDate);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());

			String[] tcName = scName.split("-");
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url = "jdbc:ucanaccess://src\\main\\resources\\lib\\Sabre_Automation_Reports.accdb";
			Connection conn = DriverManager.getConnection(url);
			String qry = "INSERT INTO TestCaseStatus (TestCase_Name, TestScenario_Name, Exec_Date, Execution_Status)"
					+ "VALUES (?, ?, ?, ?)";
			PreparedStatement stment = conn.prepareStatement(qry);

			stment.setString(1, tcName[0]);
			stment.setString(2, tcName[1]);
			stment.setDate(3, sqlDate);
			stment.setString(4, scStatus);
			stment.executeUpdate();
			conn.commit();
			conn.close();
		} catch (Exception err) {
		}
	}

	/**
	 * Method to get the available option from dropdown
	 * 
	 * @return
	 */
	public static List<String> getOptionFromDropDown(WebElement element) {
		List<String> AvailableOptions = new ArrayList<String>();

		Select obj_select = new Select(element);
		List<WebElement> optionElements = obj_select.getOptions();
		for (int i = 0; i < optionElements.size(); i++) {
			AvailableOptions.add(optionElements.get(i).getText());
		}
		return AvailableOptions;
	}

	/**
	 * Method to perform mouseover action on required element
	 * 
	 * @param element
	 */
	public void jsMouseOver(WebElement element) {
		String code = "var fireOnThis = arguments[0];" + "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initEvent( 'mouseover', true, true );" + "fireOnThis.dispatchEvent(evObj);";
		((JavascriptExecutor) driver).executeScript(code, element);

	}

	public static void mouseOver(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	/**
	 * Method to wait for page load using javascript
	 */
	public static void jsWaitForPageLoad() {
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		String pageReadyState = (String) ((JavascriptExecutor) driver).executeScript("return document.readyState");
		while (!pageReadyState.equals("complete")) {
			pageReadyState = (String) ((JavascriptExecutor) driver).executeScript("return document.readyState");
		}

	}

	public static String getRandomString(int length) {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		return sb.toString();
	}

	public static String getRandomNumber(int length) {
		char[] chars = "1234567890".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		return sb.toString();
	}

	public String dropDownSelectedValue(WebElement element) {
		Select select = new Select(element);
		String selectedOption = select.getFirstSelectedOption().getText();
		return selectedOption;
	}

	public static BigDecimal truncateDecimal(double x, int numberofDecimals) {
		if (x > 0) {
			return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR);
		} else {
			return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
		}
	}

	/**
	 * To get default selected value from drop down
	 * 
	 * @param element
	 * @return String
	 */

	public static String getDefaultDropDownValue(WebElement element) throws InterruptedException {

		Select obj_select = new Select(element);
		return obj_select.getFirstSelectedOption().getText();

	}

	/**
	 * To get checkbox is selected or not from list of checkboxes
	 * 
	 * @param List <WebElement>
	 * @return
	 */
	public static boolean isCheckBoxSelectedInDropdown(List<WebElement> elements) {
		boolean flag = true;
		int noOfCheckBox = elements.size();
		for (int i = 0; i < noOfCheckBox; i++) {
			flag = elements.get(i).isSelected();
			if (flag == true)
				break;
		}
		return flag;
	}

	public static void clickjs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	/**
	 * Method to scroll page up for element visibility using java script
	 * 
	 * @author Ganesh Bharathy
	 * @param element
	 */
	public void jsScrollPageUp(WebElement element) {
		int yScrollPosition = element.getLocation().getY();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0, " + -yScrollPosition + ")", "");

	}

	/**
	 * Method to get size of list
	 * 
	 * @author Ganesh Bharathy
	 * @param List
	 * @return size of list
	 */
	public static int getListSize(List<WebElement> element) {
		int size = 0;
		size = element.size();
		return size;
	}

	/**
	 * quit Browser
	 * 
	 * @author Ganesh Bharathy
	 * 
	 */
	public static void quitBrowser() {
		driver.quit();
	}

	/**
	 * verify if list in Ascending Order
	 * 
	 * @param list
	 * @author Ganesh Bharathy
	 * @return boolean
	 */
	public boolean checkAscendingOrder(List<String> list) {
		String previous = "";// empty string

		boolean flag = true;
		for (String current : list) {
			if (current.compareTo(previous) < 0) {
				flag = false;
				return flag;
			}

			previous = current;
		}
		return flag;
	}

	/**
	 * verify if list in descending Order
	 * 
	 * @param list
	 * @author Ganesh Bharathy
	 * @return boolean
	 */

	public boolean checkDescendingOrder(List<String> list) {
		String previous = list.get(0);
		boolean flag = true;
		for (String current : list) {
			if (previous.compareTo(current) < 0) {

				flag = false;
				return flag;
			}

			previous = current;
		}
		return flag;
	}

	/**
	 * verify Option is available In DropDown
	 * 
	 * @param Dropdown and option
	 * @author Ganesh Bharathy
	 * @return boolean
	 */

	public boolean verifyOptionIsAvailableInDropDown(WebElement dropDown, String option) {
		boolean flag = false;
		List<String> TaxSetupOption = getOptionFromDropDown(dropDown);
		for (String string : TaxSetupOption) {
			if (string.contains(option)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/**
	 * select Multiple Values From ListBox
	 * 
	 * @param list
	 * @author Ganesh Bharathy
	 * @return List of selected values
	 */
	public static List<String> selectMultipleValuesFromList(WebElement Listbox, int count) {
		List<String> codeList = new LinkedList<>();
		Select select = new Select(Listbox);
		Actions builder = new Actions(driver);
		for (int i = 0; i < count; i++) {

			builder.keyDown(Keys.CONTROL).click(select.getOptions().get(i)).keyUp(Keys.CONTROL);
			builder.build().perform();
			codeList.add(select.getAllSelectedOptions().get(i).getText());
		}
		return codeList;
	}

	/**
	 * verify if list of integer in Descending Order
	 * 
	 * @param list
	 * @author Ganesh Bharathy
	 * @return boolean
	 */
	public boolean checkDescendingOrderForInteger(List<Integer> list) {
		int previous = list.get(0);// empty string

		boolean flag = true;
		for (Integer current : list) {
			if (current > previous) {
				flag = false;
				return flag;
			}

			previous = current;
		}
		return flag;
	}

	/**
	 * verify if list of integer in Ascending Order
	 * 
	 * @param list
	 * @author Ganesh Bharathy
	 * @return boolean
	 */
	public boolean checkAscendingOrderForInteger(List<Integer> list) {
		int previous = list.get(0);// empty string
		boolean flag = true;
		for (Integer current : list) {

			if (current < previous) {
				flag = false;
				return flag;
			}

			previous = current;
		}
		return flag;
	}

	/**
	 * get random special characters
	 * 
	 * @param list
	 * @author Ganesh Bharathy
	 * @return boolean
	 */
	public static String getRandomSpecialCharacters(int length) {
		char[] chars = "!#$%&'()*+|\\,-./:;<=>?@[]^_`{|}~".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		return sb.toString();
	}

	/**
	 * Method to clear the text box
	 * 
	 * @param WebElement
	 * @author Ganesh Bharathy
	 */

	public static void clearTextBox(WebElement element) {
		waitForElementVisibility(element);
		element.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
	}

	public static void waitForElementTodisappear(By ByElement) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(ByElement));

	}

	public static String getCurrentDateMMMDDYYYY() {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("MMM. dd, YYYY");
		LocalDate now = LocalDate.now();
		String exec_Date = now.toString(fmt);
		return exec_Date;
	}

	/**
	 * Modify drop down value if something is already selected
	 * 
	 * @param Dropdown
	 * @author Ganesh Bharathy
	 * @return
	 */
	public void modifyDDValue(WebElement element) {
		List<String> option = getOptionFromDropDown(element);
		String DDSelectedValue = dropDownSelectedValue(element);
		System.out.println("DDSelectedValue " + DDSelectedValue);
		for (String text : option) {
			System.out.println("option in list " + text);
			if (text.isEmpty()) {
				System.out.println("continue...");
				continue;
			} else if (!text.equals(DDSelectedValue)) {
				selectByText(element, text);
				break;
			}
		}
	}

	/**
	 * enter integer number using keypress
	 * 
	 * @param String number
	 * @author Ganesh Bharathy
	 * @return
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public void enterNumberUsingkeypress(String number) throws InterruptedException, AWTException {
		Robot robot = new Robot();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('0', KeyEvent.VK_0);
		map.put('1', KeyEvent.VK_1);
		map.put('2', KeyEvent.VK_2);
		map.put('3', KeyEvent.VK_3);
		map.put('4', KeyEvent.VK_4);
		map.put('5', KeyEvent.VK_5);
		map.put('6', KeyEvent.VK_6);
		map.put('7', KeyEvent.VK_7);
		map.put('8', KeyEvent.VK_8);
		map.put('9', KeyEvent.VK_9);
		int lenght = number.length();
		// System.out.println("number lenght "+lenght);
		char[] numberInChar = number.toCharArray();
		int keyInput[] = new int[lenght];
		for (int i = 0; i < numberInChar.length; i++) {
			if (numberInChar != null && map != null) {
				keyInput[i] = map.get(numberInChar[i]);
			}

		}
		for (int i = 0; i < keyInput.length; i++) {
			robot.keyPress(keyInput[i]);
			pause(1000);
		}
	}

	/**
	 * click on specific co-ordinates for a Webelement
	 * 
	 * @param String number
	 * @author Ganesh Bharathy
	 * @return
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public void clickOnSpecificCoordinate(WebElement element, int x, int y) {
		Actions clicker = new Actions(driver);
		clicker.moveToElement(element).moveByOffset(x, y).click().perform();
	}

	/**
	 * Method to scroll page down for element visibility using java script
	 * 
	 * @author Ganesh Bharathy
	 * @param element
	 */
	public void jsScrollPageDown(WebElement element) {
		int yScrollPosition = element.getLocation().getY();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0, " + yScrollPosition + ")", "");

	}

	/**
	 * verify specific string is available in a list of String
	 * 
	 * @author Ganesh Bharathy
	 * @param List
	 * @return flag
	 */
	public boolean verifyTextInList(List<String> list, String text) {
		boolean flag = false;
		for (String string : list) {
			if (string.contains(text)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/**
	 * Method to verify a field is disabled
	 * 
	 * @param WebElement
	 * @author Ganesh Bharathy user your xpath in this way
	 */

	public static boolean elementDisabled(WebElement element) {
		boolean flag = false;
		waitForElementVisibility(element);
		String disabled = element.getAttribute("class");
		if (disabled.contains("disabled")) {
			flag = true;
		}
		return flag;
	}

}
