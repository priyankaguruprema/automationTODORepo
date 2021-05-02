package com.Singtel.TodoAutomation.utilities;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static com.Singtel.TodoAutomation.hooks.BeforeHook.scenario;

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

	}

	public static void takesnapshot() throws IOException {
		String fileWithPath = "target\\screenShots";
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);
		scenario.attach( scrShot.getScreenshotAs(OutputType.BYTES), "image/png", "Attachment");

	}
}
