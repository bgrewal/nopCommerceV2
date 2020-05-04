package com.nopcommerce.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass {
	

	@Test
	public void loginTest() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
//		BasicClass bc = new BasicClass(driver);
		lp.loginPage();
		lp.setUserName(username);
		logger.info("User provided"); //logger msg
		lp.setPassword(password);
		logger.info("Password provided");//logger msg
		lp.clickLogin();
		Thread.sleep(3000);
		logger.info("Login in Clicked");//logger msg
		if(lp.getPageTitle()) {
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("Login Passed");//logger msg
			
		}else {
			captureScreen(driver, "loginTest");
			logger.info("Login Failed");//logger msg
			Assert.assertTrue(false);
		}



	}

}
