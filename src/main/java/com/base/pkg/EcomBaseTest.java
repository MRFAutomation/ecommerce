package com.base.pkg;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.Status;
import com.reports.pkg.ExtentReport;
import com.utils.pkg.StringConstants;
import com.utils.pkg.Utils;

public class EcomBaseTest {
	protected static WebDriver driver;
	Utils utils = new Utils();

	public EcomBaseTest() {
		PageFactory.initElements(driver, this);
	}

	@BeforeTest
	public void beforeTest() {
		createChromeDriverSession();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	/* Create Chrome Driver Session */
	public void createChromeDriverSession() {
		System.setProperty(StringConstants.CHROME_PROP, StringConstants.CHROME_PATH);
		driver = new ChromeDriver();
		utils.log().info("Chrome Driver initialized");
		ExtentReport.getTest().log(Status.INFO, "Chrome Driver initialized");
		driver.manage().window().maximize();
		utils.log().info("Window maximized");
	}

	/* Click on element overloaded method */
	public void click(WebElement e, String msg) {
		waitForElementVisibility(e);
		utils.log().info(msg);
		ExtentReport.getTest().log(Status.INFO, msg);
		e.click();
	}

	/*
	 * Send keys method public void sendKeys(WebElement e, String s) {
	 * utils.log().info("SendKeys method" + e.toString());
	 * waitForElementVisibility(e); e.sendKeys(s); }
	 */

	/* Send keys overloaded method */
	public void sendKeys(WebElement e, String s, String msg) {
		waitForElementVisibility(e);
		utils.log().info(msg);
		ExtentReport.getTest().log(Status.INFO, msg);
		e.sendKeys(s);
	}

	/* Wait for element method */
	public void waitForElementVisibility(WebElement e) {
		utils.log().info("Wait For Element Visibility");
		ExtentReport.getTest().log(Status.INFO, "Wait For Element Visibility");
		WebDriverWait webDriverWait = new WebDriverWait(driver, StringConstants.WAIT_IN_SECONDS);
		webDriverWait.until(ExpectedConditions.visibilityOf(e));
	}

	/* Get attribute with AttType */
	public String getAttributes(WebElement e, String attType) {
		waitForElementVisibility(e);
		utils.log().info("getAttributes methode called");
		ExtentReport.getTest().log(Status.INFO, "getAttributes methode called");
		return e.getAttribute(attType);
	}

	/* Wait Method */
	public void addPauseInSeconds(int timeInSeconds) {
		utils.log().info("Add delay for: " + timeInSeconds + " seconds");
		ExtentReport.getTest().log(Status.INFO, "Add delay for: " + timeInSeconds + " seconds");
		int timeInMilliSeconds = timeInSeconds * 1000;
		try {
			Thread.sleep(timeInMilliSeconds);
		} catch (Exception e) {
			utils.log().error("addPauseInSeconds");
			System.out.println("Exception in ThreadDotSleep");
			e.printStackTrace();
		}
	}

	/* Action Class Move to Method */
	public void moveToElement(WebElement e, String msg) {
		utils.log().info(msg);
		ExtentReport.getTest().log(Status.INFO, msg);
		Actions actions = new Actions(driver);
		actions.moveToElement(e).perform();
	}

	/* Get Date and Time common Method */
	public String dateTime() {
		utils.log().info("dateTime method called");
		ExtentReport.getTest().log(Status.INFO, "dateTime method called");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	/* Method TakeScreenshot with image path return */
	public String takeScreenshotWithImgPath() {
		utils.log().info("Taking screenshot");
		ExtentReport.getTest().log(Status.INFO, "Taking screenshot");
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

//		String imgPath = "C:\\Users\\eBricks\\eclipse-workspace\\SeleniumProject\\reports\\" + generateRandomString()+ ".png";

		String destImgPath = "Screenshots" + File.separator + dateTime() + File.separator + generateRandomString()
				+ ".png";
		try {
			FileUtils.copyFile(sourceFile, new File(destImgPath));
		} catch (IOException e) {

			e.printStackTrace();
		}
		return destImgPath;
	}

	/* Method GenerateRandomString */
	public String generateRandomString() {
		String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder stringBuilder = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 7; i++) {
			stringBuilder.append(string.charAt(random.nextInt(string.length())));
		}
		return stringBuilder.toString();
	}

}
