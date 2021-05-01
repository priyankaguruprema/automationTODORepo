Feature: Test the functionality of the Todo page
	
	#Background:	MVC User is as require previlages for Todo page
	#Given User is on the Test Site "url"

	@Positive
	Scenario Outline: Verify the layout of the Todo page
	Given Todo url 
		Examples:
		|data Sr No|Name|country|
		|1|abcd| xyz|