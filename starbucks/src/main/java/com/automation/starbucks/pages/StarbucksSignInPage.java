package com.automation.starbucks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StarbucksSignInPage extends BasePage {

	public StarbucksSignInPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//div[@class='field__inputWrapper flex']//child::input[@name='username']")
	public WebElement userName;
	@FindBy(xpath="//div[@class='field__inputWrapper flex']//child::input[@name='password']")
	public WebElement password;
	@FindBy(xpath="//div[@class='visible']/button[@type='submit']")
	public WebElement buttonSignIn;
	
	public String getSignIn() {
		String sendGift="Send Gift";
		System.out.println("nos encontramos en StarbucksSignInPage");
		
		userName.sendKeys("tae.globant.training@gmail.com");
		password.sendKeys("GlobantTAE_1");
		
		getWait().until(ExpectedConditions.elementToBeClickable(buttonSignIn));
		buttonSignIn.submit();
		
		return sendGift;
	}
}
