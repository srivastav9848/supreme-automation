package com.uiAutomation.Flipkart.homepage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.uiAutomation.Flipkart.TestBase.HelperUtility;
import com.uiAutomation.Flipkart.uiAction.TestPage_uiPage;

public class TestCase_Login extends HelperUtility{
	
	TestPage_uiPage loginfunctionality;
	String emailaddress="kanika_goyal490@yahoo.com";
	String password = "Kanika@123";
	@BeforeTest
	public void setUp(){
		launchBrowser();
	}
	
	@Test
	public void login(){
		loginfunctionality = new TestPage_uiPage(driver);
		loginfunctionality.loginToFlipkart(emailaddress, password);
	}
	
	@AfterTest
	public void endTest(){
		driver.quit();
	}

}
