package com.Singtel.TodoAutomation.stepDef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.Singtel.TodoAutomation.utilities.PropertyLoader.*;

import java.io.IOException;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;


public class TodoPage {
	@Before
	public void before(Scenario scenario) {
	    this.scenario = scenario;
	}
	Scenario scenario ;
	@Given("Todo url")
	public void todo_url()  throws InterruptedException, IOException {
		loadProperties();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dileepa\\workspace\\TodoAutomation\\resource\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = getProperties("todoUrl");
		logger.info("*********************************baseUrl******************************************"+baseUrl);
		driver.get(baseUrl);
		
		logger.info("*********************************naviagting to the url******************************************"+scenario.getName());
scenario.attach("testing", "text/plain", "adding string to report");
		Thread.sleep(2000);
		driver.quit();
	}

}
