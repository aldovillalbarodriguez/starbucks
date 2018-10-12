package com.automation.starbucks.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StarbucksSignInPage extends BasePage {
	
	Logger log = Logger.getLogger(StarbucksSignInPage.class);

	public StarbucksSignInPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//div[@class='field__inputWrapper flex']//child::input[@name='username']")
	public WebElement userName;
	@FindBy(xpath="//div[@class='field__inputWrapper flex']//child::input[@name='password']")
	public WebElement password;
	@FindBy(xpath="//div[@class='visible']/button[@type='submit']")
	public WebElement buttonSignIn;

	
	public StarbucksAppPage getSignIn() {
		
		
		try {
			userName.sendKeys("tae.globant.training@gmail.com");
			password.sendKeys("GlobantTAE_1");
			
			getWait().until(ExpectedConditions.textToBePresentInElement(buttonSignIn, "Sign in"));
			buttonSignIn.click();
			
		} catch (Exception e) {
			log.error("error StarbucksSignInPage.getSignIn()",e);
		}
		
				
		return new StarbucksAppPage (getDriver());
	}
}
