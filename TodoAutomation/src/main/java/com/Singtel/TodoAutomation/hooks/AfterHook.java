package com.Singtel.TodoAutomation.hooks;

import static com.Singtel.TodoAutomation.utilities.PropertyLoader.loadProperties;

import java.io.IOException;
import java.util.logging.Logger;
import static com.Singtel.TodoAutomation.utilities.DriverUtltils.*;

import io.cucumber.java.After;
import static com.Singtel.TodoAutomation.hooks.BeforeHook.scenario;

public class AfterHook {
	public static Logger logger = Logger.getLogger("AfterHook") ;
	
	@After
	public void beforeStep(  ) throws IOException {
		if(driver!=null && scenario.isFailed()) {
			takesnapshot();
			logger.info("*********************************closing the browser******************************************");
			}
		if(driver!=null) {
		driver.quit();		
		logger.info("*********************************closing the browser******************************************");
		}
		
		
		}
}
