package com.automation.starbucks.pages;

import java.util.List;

import javax.xml.xpath.XPath;

import org.apache.log4j.Logger;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class StarbucksGiffPage extends BasePage {
	
	Logger log = Logger.getLogger(StarbucksGiffPage.class);

	public StarbucksGiffPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[@href='/gift/873069715']")
	public WebElement cardGift;
	
	@FindBy(xpath="//div[@class='field__inputWrapper flex']/input[@name='recipientName']")
	public WebElement reciptName;
	@FindBy(xpath="//div[@class='field__inputWrapper flex']/input[@name='recipientEmail']")
	public WebElement reciptMail;
	@FindBy(xpath="//div[@class='field__inputWrapper flex']/input[@name='message']")
	public WebElement message;
	@FindBy(xpath="//div[@class='pt3 lg-pt5']/form")
	public WebElement formFields;
	@FindBy(xpath="//div[@class='visible']/button[text()='Checkout']")	
	public WebElement buttonCheout;
	@FindBy(xpath="//div[@class='visible']/button[text()='Send gift']")
	public WebElement buttonSendGift;
	
	@FindBy(xpath="//select/option[@value='masterpass']")
	public WebElement selectionMaster;
	@FindBy(xpath="//div[@class='visible']/button[text()='Continue']")
	public WebElement buttonContinue;
	
	
	
	
	
	public String getGiftCards() {
		String giftCard = "";
		
		try {
			
			getWait().until(ExpectedConditions.elementToBeClickable(cardGift));
			cardGift.click();
			reciptName.sendKeys("paula.armenta");
			reciptMail.sendKeys("paula.armenta@mailito.com");
			message.sendKeys("test case 3 is finished");
			getWait().until(ExpectedConditions.elementToBeClickable(buttonCheout));
			buttonCheout.click();		
			getWait().until(ExpectedConditions.elementToBeClickable(buttonSendGift));
			
			giftCard = buttonSendGift.getText();
			
					
		} catch (Exception e) {
			log.error("StarbucksGiffPage.getGiftCards()",e);
		}
		
		
		
		
		return giftCard;
	}
	
	
	public String getVerifyContinue() {
		
		String buttonSays ="";
		try {
			
			selectionMaster.click();
			
			getWait().until(ExpectedConditions.elementToBeClickable(buttonContinue));
			buttonSays=buttonContinue.getText();
			
			log.info("que dice?"+buttonSays);
			
			
		} catch (Exception e) {
			log.error("Error en StarbucksGiffPage.getVerifyContinue()",e);
		}
		
		return buttonSays;
		
		
	}
}
