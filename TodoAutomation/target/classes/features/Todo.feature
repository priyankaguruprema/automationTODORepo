@testTodo
Feature: Test the functionality of the Todo page
	
	Background: For Todo page
	Given Todo page url 

	#only scenario with all step automated
	Scenario Outline: Verify the layout of the Todo page	
	
	Given mvc user with all privileges to access todo page
	When navigate to todo page
	Then verify the todo page title
	Then verify the content under source
	Then verify the options under "Official Resources" 
	Then verify the options under "Community" 
	And verify the doble click, written by and part of
	When enter "<given todo name>" in what needs to be done field	
	Then verify all hyperlinks on the Todo page are present
	And verify all hyperlinks on the Todo page by clicking on each hyper link
		Examples:
			|given todo name|
			|Todo Name 1    |
	
	
#scenario fails as there is no create todo button
Scenario Outline: Verify the creation of Todo on todo page
	
	Given mvc user with all privileges to access todo page
	When navigate to todo page
	Then verify the todo page title
	When enter "<given todo name>" in what needs to be done field	
	Then click on create todo button
	And verify the new todo item is created 
 	Examples:
 			|given todo name|
			|Todo Name 1    |

	
# scenario fails as there is no existing todo items
 Scenario Outline: Verify the update of todo item on todo page
 	
 	Given mvc user with all privileges to access todo page
	When navigate to todo page
	Then verify the todo page title
	Then click on edit button of "<existing todo>" item
	And verify the todo item is in edit mode
	When perform edit
	And click on save button
	Then existing todo item is updated with the latest changes
 		Examples:
 			|existing todo |
			|Todo Name 1    |
			


	# scenario fails as there is no existing todo items
 Scenario Outline: Verify the delete of todo item on todo page
  	
  	Given mvc user with all privileges to access todo page
	When navigate to todo page
	Then verify the todo page title
	And verify there are some existing todo items
	When enter "<given todo name>" in what needs to be done field	
	Then click on delete button of "<existing todo>" item
	And verify the delete todo item pop up appears
	When click on confirm delete button
	Then existing todo item is deleted from the list
 		Examples:
 			|existing todo |
			|Todo Name 1    |
			
		
Scenario Outline: Verify the multiple creation of todo items
	
	Given mvc user with all privileges to access todo page
	When navigate to todo page
	Then verify the todo page title
	And verify there are some existing todo item
	When enter "<given todo name>" in what needs to be done field	
	Then click on create todo button
	And verify the new todo item is created 
 	Examples:
 			|given todo name|
			|Todo Name 1    |
			
	
Scenario: Verify only mvc user can access todo page but not the non MVC user
	Given mvc user with all privileges to access todo page
	When navigate to todo page
	Then verify the todo page title
	Given non mvc user without all privileges to access todo page
	When navigate to todo page with non mvc user
	Then verify the todo page title doesnt match with the expectation
			
	
	
