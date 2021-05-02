package com.Singtel.TodoAutomation.hooks;


import static com.Singtel.TodoAutomation.utilities.PropertyLoader.loadProperties;

import java.io.IOException;
import java.util.logging.Logger;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BeforeHook {
	public static Logger logger = Logger.getLogger("BeforeHook") ;
	public static Scenario scenario ;
	@Before
	public void beforeStep(Scenario scene ) throws IOException {
		this.scenario = scene;
		loadProperties();
		logger.info("*********************************LoadedPropertyFile******************************************");
		logger.info("*********************************starting scenario*****************************************"+scenario.getName());
		}
	
}
