package com.Singtel.TodoAutomation.utilities;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static com.Singtel.TodoAutomation.hooks.BeforeHook.scenario;
import static com.Singtel.TodoAutomation.locator.TodoLocator.quote;
import static com.Singtel.TodoAutomation.utilities.DriverUtltils.driver;

public class DriverUtltils {
	public static Logger logger = Logger.getLogger("DriverUtltils");
	public static WebDriver driver = null;

	public static void lanuchBrowser() throws IOException {
		if (System.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "resource\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			scenario.log("Chrome browser is lanuched");
		} else if (System.getProperty("browser").equals("edge")) {
			System.setProperty("webdriver.edge.driver", "resource\\drivers\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			scenario.log("edge browser is lanuched");
		}
		driver.manage().window().maximize();
	}

	public static void takesnapshot() throws IOException {
		String fileWithPath = "target\\screenShots";
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		scenario.attach(scrShot.getScreenshotAs(OutputType.BYTES), "image/png", "Attachment");

	}

	public static String getElementText(By locator) {
		return driver.findElement(locator).getText();
	}

	public static void clickElement(By locator) {
		driver.findElement(locator).click();
	}
	public static void clickElement( WebElement element) {
		element.click();
	}


	public static void typeInElement(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}
	
	public static void highLighterMethod( By locator) throws IOException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", driver.findElement(locator));
		takesnapshot();
		js.executeScript("arguments[0].removeAttribute('style','')", driver.findElement(locator));
	}
	public static void highLighterMethod( WebElement element) throws IOException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		takesnapshot();
		js.executeScript("arguments[0].removeAttribute('style','')", element);
	}
}
