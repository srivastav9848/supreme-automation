package com.uiAutomation.Flipkart.uiAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.uiAutomation.Flipkart.TestBase.HelperUtility;

public class TestPage_uiPage extends HelperUtility{
	
	public TestPage_uiPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.LINK_TEXT, using ="//a[@href='/account/login?signup=true']")
	WebElement signupLink;	
	@FindBy(how=How.XPATH, using ="//a[@href='/account/login?ret=/']")
	WebElement loginLink;
	@FindBy(how=How.XPATH, using ="//input[@class='_2zrpKA']")
	WebElement enterEmail;
	@FindBy(how=How.XPATH, using ="//input[@type='password']")
	WebElement enterPassword;
	@FindBy(how=How.XPATH, using ="//span[contains(text(),'Forgot?')]")
	WebElement forgotPassword;
	@FindBy(how=How.XPATH, using ="//button[@type='submit']//span[contains(text(),'Login')]")
	WebElement loginButton;
	@FindBy(how=How.XPATH, using ="//span[contains(text(),'New to Flipkart? Sign up')]")
	WebElement signUp_loginWindow;
	
	
	
	public void loginToFlipkart(String emailaddress,String password){
		loginLink.click();
		enterEmail.sendKeys(emailaddress);
		enterPassword.sendKeys(password);
		loginButton.click();
	}

}