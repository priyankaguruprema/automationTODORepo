@testTodo
Feature: Test the functionality of the Todo page
	
	Background: For Todo page
	Given Todo page url 
	
	Scenario Outline: Verify the layout of the Todo page	
	Given mvc user with all privileges to access todo page
	When navigate to todo page
	Then verify the todo page title
	Then verify the content under source
	Then verify the options under "Official Resources" 
	Then verify the options under "Community" 
	And verify the doble click, written by and part of
	When enter "<given todo name>" in what needs to be done field	
	Then read the entered todo name 
	And verify all hyperlinks on the Todo page by clicking each hyper link
		Examples:
			|given todo name|
			|Todo Name 1|
		
