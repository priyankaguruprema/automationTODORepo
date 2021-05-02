package com.Singtel.TodoAutomation.stepDef;

import static com.Singtel.TodoAutomation.utilities.PropertyLoader.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.openqa.selenium.WebElement;

import static com.Singtel.TodoAutomation.utilities.DriverUtltils.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.hamcrest.MatcherAssert.assertThat;
import static com.Singtel.TodoAutomation.hooks.BeforeHook.scenario;
import static com.Singtel.TodoAutomation.locator.TodoLocator.*;

public class TodoPage {
	public static Logger logger = Logger.getLogger("TodoPage");

	@Given("Todo page url")
	public void todo_page_url() {
		scenario.log("Given url  " + getProperties("todoUrl"));
	}

	@Given("mvc user with all privileges to access todo page")
	public void mvc_user_with_all_privileges_to_access_todo_page() {
		// Assuming the current user as mvc user ... we can use certificates as
		// dedicated user for accessing
		scenario.log("MVC user has privileges to access TODO page ");
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
		scenario.log("Todo page title is \n" + driver.getTitle());
		assertThat("Title doesnt match", driver.getTitle().equals("Vue.js • TodoMVC"));
	}

	@Then("verify the content under source")
	public void verify_the_content_under_source() throws IOException {
		scenario.log("Content under source is \n" + getElementText(quote));
		highLighterMethod(quote);
		assertThat("content under source doesnt match", getElementText(quote).equals(
				"Vue.js provides efficient MVVM data bindings with a simple and flexible API. It uses plain JavaScript object models, DOM-based templating and extendable directives and filters."));
	}

	@Then("verify the options under {string}")
	public void verify_the_options_under(String string) throws IOException {
		if (string.equals("Official Resources")) {
			highLighterMethod(officialResources);
			scenario.log("Official Resource   options \n");
			List<WebElement> officialRes = driver.findElements(officialResourcesList);
			List<String> expected = new ArrayList<String>();
			List<String> actual = new ArrayList<String>();
			expected.add("Documentation");
			expected.add("API Reference");
			expected.add("Examples");
			expected.add("Vue.js on GitHub");
			for (int loop = 0; loop < 4; loop++) {
				actual.add((officialRes.get(loop)).getText());
				scenario.log(actual.get(loop));
			}

			assertThat(" Options under Official Resources doesnt match", actual.equals(expected));
		} else if (string.equals("Community")) {
			highLighterMethod(community);
			scenario.log("Community  options \n");
			List<WebElement> comList = driver.findElements(communityList);
			List<String> expected = new ArrayList<String>();
			List<String> actual = new ArrayList<String>();
			expected.add("Twitter");
			expected.add("Gitter Channel");
			expected.add("Discussions on GitHub");

			for (int loop = 0; loop < 3; loop++) {
				actual.add((comList.get(loop)).getText());
				logger.info("******************actual  *********" + actual.get(loop));
				scenario.log(actual.get(loop));
			}

			assertThat("Options Community doesnt match", actual.equals(expected));
		}
	}

	@Then("verify the doble click, written by and part of")
	public void verify_the_doble_click_written_by_and_part_of() throws IOException {
		List<WebElement> middleList = driver.findElements(middle);
		List<String> expected = new ArrayList<String>();
		List<String> actual = new ArrayList<String>();
		expected.add("Double-click to edit a todo");
		expected.add("Written by Evan You");
		expected.add("Part of TodoMVC");

		for (int loop = 0; loop < 3; loop++) {
			actual.add((middleList.get(loop)).getText());
			highLighterMethod(middleList.get(loop));
			logger.info("******************actual  *********" + actual.get(loop));
			scenario.log(actual.get(loop));
		}

		assertThat(" The doble click, written by and part of doesnt match", actual.equals(expected));
	}

	@When("enter {string} in what needs to be done field")
	public void enter_in_what_needs_to_be_done_field(String string) throws IOException {
		highLighterMethod(todoName);
		typeInElement(todoName, string);
		highLighterMethod(todoName);
	}

	@Then("verify all hyperlinks on the Todo page are present")
	public void verify_all_hyperlinks_on_the_todo_page_are_present() throws IOException {
		scenario.log("List of all hyperlinks on the Todo page");
		List<WebElement> hyperlink = driver.findElements(hyperlinks);
		List<String> expected = new ArrayList<String>();
		List<String> actual = new ArrayList<String>();
		expected.add("Source");
		expected.add("Vue.js");
		expected.add("Documentation");
		expected.add("API Reference");
		expected.add("Examples");
		expected.add("Vue.js on GitHub");
		expected.add("Twitter");
		expected.add("Gitter Channel");
		expected.add("Discussions on GitHub");
		expected.add("let us know");
		expected.add("Evan You");
		expected.add("TodoMVC");

		for (int loop = 0; loop < 12; loop++) {
			actual.add((hyperlink.get(loop)).getText());
			logger.info("******************actual  *********" + actual.get(loop));
			scenario.log(actual.get(loop));
		}

		assertThat("Hyperlink doesnt match", actual.equals(expected));
	}

	@Then("verify all hyperlinks on the Todo page by clicking on each hyper link")
	public void verify_all_hyperlinks_on_the_todo_page_by_clicking_on_each_hyper_link() throws IOException {
		scenario.log("Each hyperlinks on the Todo page are opened and title of navigated page is validated");
		for (int loop = 0; loop < 12; loop++) {
			List<WebElement> hyperlink = driver.findElements(hyperlinks);
			scenario.log("Clicking on hyperlink : " + hyperlink.get(loop).getText());
			highLighterMethod(hyperlink.get(loop));
			clickElement(hyperlink.get(loop));
			driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			takesnapshot();
			assertThat("Title doesnt match", !driver.getTitle().equals("Vue.js • TodoMVC"));
			driver.navigate().back();
			driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			assertThat("Title doesnt match", driver.getTitle().equals("Vue.js • TodoMVC"));
			takesnapshot();
		}

	}

	@Then("click on create todo button")
	public void click_on_create_todo_button() {
		assertThat("There is no create todo button", getElementText(create).equals("create"));
	}

	@Then("verify the new todo item is created")
	public void verify_the_new_todo_item_is_created() {

	}

	@Then("click on edit button of {string} item")
	public void click_on_edit_button_of_item(String string) {
		assertThat("There is no existing todo items", getElementText(existing).equals("existing"));
	}

	@Then("verify the todo item is in edit mode")
	public void verify_the_todo_item_is_in_edit_mode() {

	}

	@When("perform edit")
	public void perform_edit() {
		assertThat("There is no edit todo button", getElementText(edit).equals("edit"));
	}

	@When("click on save button")
	public void click_on_save_button() {
	}

	@Then("existing todo item is updated with the latest changes")
	public void existing_todo_item_is_updated_with_the_latest_changes() {

	}

	@Then("verify there are some existing todo items")
	public void verify_there_are_some_existing_todo_items() {

	}

	@Then("click on delete button of {string} item")
	public void click_on_delete_button_of_item(String string) {
		assertThat("There is no existing todo items", getElementText(existing).equals("existing"));
	}

	@Then("verify the delete todo item pop up appears")
	public void verify_the_delete_todo_item_pop_up_appears() {

	}

	@When("click on confirm delete button")
	public void click_on_confirm_delete_button() {

	}

	@Then("existing todo item is deleted from the list")
	public void existing_todo_item_is_deleted_from_the_list() {

	}
	@Then("verify there are some existing todo item")
	public void verify_there_are_some_existing_todo_item() {
		assertThat("There is no existing todo items", getElementText(existing).equals("existing"));
	}
	
	@Given("non mvc user without all privileges to access todo page")
	public void non_mvc_user_without_all_privileges_to_access_todo_page() {
		// Assuming as non mvc user should fail.. the naviagtion
				scenario.log("Non MVC user without privileges to access TODO page has been given ");
				
	}



	@When("navigate to todo page with non mvc user")
	public void navigate_to_todo_page_with_non_mvc_user() throws IOException {
		String baseUrl = getProperties("todoUrl");
		logger.info("*********************************baseUrl******************************************" + baseUrl);
		scenario.log("Navigating to TODO page ");
		driver.get(baseUrl+"withNonMVC");
		takesnapshot();
	}
	@Then("verify the todo page title doesnt match with the expectation")
	public void verify_the_todo_page_title_doesnt_match_with_the_expectation() {
		assertThat("Title doesnt match", driver.getTitle().equals("Vue.js • TodoMVC"));
	}

}
