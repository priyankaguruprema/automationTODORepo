package com.Singtel.TodoAutomation.Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "resource\\features", 
	glue = "/com/Singtel/TodoAutomation",
	tags = "@testTodo",
	monochrome = true, 
	plugin = {"pretty", "html:target/html", "json:target/json/Cucumber.json", "junit:target/cucumber-reports/Cucumber.xml" }

)
public class TodoRunner {

}

