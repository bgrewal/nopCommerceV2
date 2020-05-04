package com.nopcommerce.pageObjects;

import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Optional;
//import org.testng.annotations.Parameters;
//import org.apache.log4j.PropertyConfigurator;

import com.nopcommerce.utilities.ReadConfig;

public class BasicClass {
	
	final WebDriver driver;
	
	public BasicClass(WebDriver driver){
		this.driver = driver;
	}

	
	
	
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUseremail();
	public String password=readconfig.getPassword();
//	public static WebDriver driver;
	private static WebElement element=null;
	public static Logger logger; //Added logger
	
	protected WebElement returnElement(String str) {
		String[] str1 = str.split("\\|");
		if(str1[0].equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(str1[1]));
		}
		if(str1[0].equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(str1[1]));
		}
		if(str1[0].equalsIgnoreCase("PartialLinkText")) {
			element = driver.findElement(By.partialLinkText(str1[1]));
		}
		if(str1[0].equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(str1[1]));
		}
		if(str1[0].equalsIgnoreCase("css")) {
			element = driver.findElement(By.cssSelector(str1[1]));
		}
		if(str1[0].equalsIgnoreCase("className")) {
			element = driver.findElement(By.className(str1[1]));
		}
		if(str1[0].equalsIgnoreCase("tagName")) {
			element = driver.findElement(By.tagName(str1[1]));
		}
		if(str1[0].equalsIgnoreCase("linkText")) {
			element = driver.findElement(By.linkText(str1[1]));
		}
		
		return element;
	}
	
	public void enterDataInTextField(String str, String uname) throws InterruptedException
	{
		Thread.sleep(1000);
		returnElement(str);
		element.clear();
		element.sendKeys(uname);
	}
	public void clickOnElement(String str) {
		returnElement(str);
		element.click();
	}
	public void clickonElementJavaScript(String str) {
		returnElement(str);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	public String getTitle() throws InterruptedException {
		return driver.getTitle();
	}
	public void setManagerOfVendor(String str, String value)
	{
		returnElement(str);
		Select drp=new Select(element);
		drp.selectByVisibleText(value);
	}
	
	


	
}

