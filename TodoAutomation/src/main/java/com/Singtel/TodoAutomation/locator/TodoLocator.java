package com.Singtel.TodoAutomation.locator;
import org.openqa.selenium.By;
public class TodoLocator {
	
	public static By quote = By.xpath("//*[@class=\"quote speech-bubble\"]//p");
	public static By officialResources = By.xpath("//*[text() ='Official Resources']");
	public static By community = By.xpath("//*[text() ='Community']");
	public static By officialResourcesList = By.xpath("//*[text() ='Official Resources']//following-sibling::ul[1]/li/a");
	public static By communityList = By.xpath("//*[text() ='Community']//following-sibling::ul[1]/li/a");
	public static By hyperlinks = By.xpath("//a[not(contains(@href,'#'))]");
	public static By middle = By.xpath("//*[@class='info']//child::p");
	public static By todoName = By.xpath("//*[@placeholder='What needs to be done?']");

}
