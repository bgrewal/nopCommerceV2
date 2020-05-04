package com.nopcommerce.pageObjects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
public class LoginPage extends BasicClass{
	public String baseURL="http://admin-demo.nopcommerce.com/";
	public String username="admin@yourstore.com ";
	public String password="admin";
//	final WebDriver driver;
	
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	public void loginPage() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(1200, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
		Thread.sleep(3000);
//		logger.info("URL is opened......");//logger msg
	}
	
	String USER_EMAIL="id|Email";
	String USER_PASSWORD="id|Password";
	String LOGIN_BUTTON ="xpath|//input[@value='Log in']";
	String LOGON_BUTTON = "linkText|Logout";
	public void setUserName(String username) throws InterruptedException {
		enterDataInTextField(USER_EMAIL, username);
	}
	public void setPassword(String pwd) throws InterruptedException
	{
		enterDataInTextField(USER_PASSWORD, pwd);
	}
		
	public void clickLogin()
	{
		clickOnElement(LOGIN_BUTTON);
	}
	
	public void clickLogout()
	{
		clickOnElement(LOGON_BUTTON);
	}
	public boolean getPageTitle() throws InterruptedException {
		if(getTitle().equals("Dashboard / nopCommerce administration")) {
			return true;
		}else {
			return false;
		}
	}
	
	
}
