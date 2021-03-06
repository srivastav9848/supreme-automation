package com.uiAutomation.Flipkart.homepage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uiAutomation.Flipkart.ExcelReader.Excel_reader;
import com.uiAutomation.Flipkart.TestBase.HelperUtility;
import com.uiAutomation.Flipkart.uiAction.TestPage_uiPage;

public class TestCase_Login extends HelperUtility{
	
	public static final Logger log	=Logger.getLogger(TestCase_Login.class.getName());
	TestPage_uiPage loginfunctionality;
	//String emailaddress="kanika_goyal490@yahoo.com";
	//String password = "Kanika@123";
	String menu = "Men";
	String subMenu = "Top wear";
			
	String Screenshot_path = "E://Screenshot.png";
	Excel_reader excel;
	
	@DataProvider(name="reading from Excel.")
		public String[][] getTestData() throws IOException{
		String[][] testdata = loadTestData("TestData.xlsx","flipkartdata");
		return testdata;
	}
	@BeforeTest
	public void setUp() throws InterruptedException{
		launchBrowser();
	}
	
	@Test(dataProvider ="reading from Excel.")
	public void login(String emailaddress, String password) throws IOException{
		loginfunctionality = new TestPage_uiPage(driver);
		log.info("Initializing the driver");
		//loginfunctionality.loginToFlipkart(emailaddress, password);
		//log.info("User is logging in using " +emailaddress+ "id");
		//loginfunctionality.hoverfunctionality();
		loginfunctionality.clickOnNavigationMenu(menu, subMenu);
		log.info("User wants to go to - "+menu+ "and wants to the "+subMenu );
		loginfunctionality.captureScrenshot(Screenshot_path);
		log.info("Screenshot is saved at - "+Screenshot_path.toString());
	}
	
	@AfterTest
	public void endTest(){
		//driver.quit();
	}

}
