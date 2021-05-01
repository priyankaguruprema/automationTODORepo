@testTodo
Feature: Test the functionality of the Todo page
	
	#Background:	MVC User is as require privileges for Todo page
	#Given User is on the Test Site "url"

	
	Scenario Outline: Verify the layout of the Todo page
	Given Todo url 
		Examples:
		|data Sr No|Name|country|
		|1|abcd| xyz|	
		

	Scenario Outline: Verify the creation of Todo on todo page
	Given Todo url 
		Examples:
		|data Sr No|Name|country|
		|1|abcd| xyz|
		
		Scenario Outline: Verify the update of todo item on todo page
	Given Todo url 
		Examples:
		|data Sr No|Name|country|
		|1|abcd| xyz|
		
			Scenario Outline: Verify the delete of todo item on todo page
	Given Todo url 
		Examples:
		|data Sr No|Name|country|
		|1|abcd| xyz|
		
			Scenario Outline: Verify the multiple creation, update and deletion of todo item on todo page
	Given Todo url 
		Examples:
		|data Sr No|Name|country|
		|1|abcd| xyz|
		
			Scenario Outline: Verify the creation, update and deletion of todo item on todo page with other than MVC user
	Given Todo url 
		Examples:
		|data Sr No|Name|country|
		|1|abcd| xyz|