package com.Singtel.TodoAutomation.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;


public class PropertyLoader {
	public static Logger logger = Logger.getLogger("PropertyLoader") ;
	public static Properties utilsProp = new Properties();
	
	
	public static void loadProperties() throws IOException {
	String	filepath = "resource\\properties\\application.properties";
	logger.info("*********************************loading application property file******************************************");
			FileInputStream in = new FileInputStream(filepath);
			utilsProp.load(in);
			in.close();
	}

	
	public static String getProperties(String property) {
		
		String value = utilsProp.getProperty(property);
		logger.info("******************************property************"+property+"********************value*************"+value);
		
		return value;
	}
	
}
