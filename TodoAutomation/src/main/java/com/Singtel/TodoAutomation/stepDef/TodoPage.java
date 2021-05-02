package com.Singtel.TodoAutomation.stepDef;
import static com.Singtel.TodoAutomation.utilities.PropertyLoader.*;
import java.io.IOException;
import java.util.logging.Logger;

import org.hamcrest.Matcher;

import static com.Singtel.TodoAutomation.utilities.DriverUtltils.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.hamcrest.MatcherAssert.assertThat;
import static com.Singtel.TodoAutomation.hooks.BeforeHook.scenario;

public class TodoPage {
	public static Logger logger = Logger.getLogger("TodoPage") ;
	@Given("Todo page url")
	public void todo_page_url() {
		scenario.log("Given url  "+getProperties("todoUrl"));	   
	}

	@Given("mvc user with all privileges to access todo page")
	public void mvc_user_with_all_privileges_to_access_todo_page() {
	   //Assuming the current user as mvc user ... we can use certificates as dedicated user for accessing 
		scenario.log("Given MVC user with privileges to access TODO page ");
	}
	@When("navigate to todo page")
	public void navigate_to_todo_page() throws IOException {
		lanuchBrowser();
		takesnapshot();
		String baseUrl = getProperties("todoUrl");
		logger.info("*********************************baseUrl******************************************" + baseUrl);
		scenario.log("Navigating to TODO page ");
		driver.get(baseUrl);
		takesnapshot();
	   
	}
	@Then("verify the todo page title")
	public void verify_the_todo_page_title() {
		logger.info("*********************************title*****************expecting Vue.js • TodoMVC*************************" + driver.getTitle());	
		 assertThat(driver.getTitle(), equals("Vue.js • TodoMVC")); 
	}
	@Then("verify the content under source")
	public void verify_the_content_under_source() {
	   
	   
	}
	@Then("verify the options under {string}")
	public void verify_the_options_under(String string) {
	   
	   
	}
	@Then("verify the doble click, written by and part of")
	public void verify_the_doble_click_written_by_and_part_of() {
	   
	   
	}
	@When("enter todo name in what needs to be done field")
	public void enter_todo_name_in_what_needs_to_be_done_field() {
	   
	   
	}
	@Then("read the entered todo name")
	public void read_the_entered_todo_name() {
	   
	   
	}
	@Then("verify all hyperlinks on the Todo page by clicking each hyper link")
	public void verify_all_hyperlinks_on_the_todo_page_by_clicking_each_hyper_link() {
	   
	   
	}

}
