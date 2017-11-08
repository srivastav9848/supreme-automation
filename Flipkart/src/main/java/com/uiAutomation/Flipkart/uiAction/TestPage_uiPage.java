package com.uiAutomation.Flipkart.uiAction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@FindBy(how=How.XPATH, using ="//a[@title='Electronics']/span")
	WebElement Elex;
	
	@FindBy(how=How.XPATH, using ="//a[@title='Mobiles']/span[1]")
	WebElement Mobile;
	
	
	
	
	public void loginToFlipkart(String emailaddress,String password){
		loginLink.click();
		enterEmail.sendKeys(emailaddress);
		enterPassword.sendKeys(password);
		loginButton.click();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	}
	
	public void hoverfunctionality(){
		
		Actions builder = new Actions(driver);
		builder.moveToElement(Elex).perform();
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(Mobile));
		Mobile.click();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	}

}
