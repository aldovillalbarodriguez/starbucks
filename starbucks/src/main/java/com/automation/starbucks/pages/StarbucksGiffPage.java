package com.automation.starbucks.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class of starbucks page to send gifts and send it
 * 
 * @author aldo.villalba
 *
 */
public class StarbucksGiffPage extends BasePage {

	Logger log = Logger.getLogger(StarbucksGiffPage.class);

	public StarbucksGiffPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Param to card Gift to send
	 */
	@FindBy(xpath = "//a[@href='/gift/873069448']")
	public WebElement cardGift;
	/**
	 * Param to input text of reciptName
	 */
	@FindBy(xpath = "//div[@class='field__inputWrapper flex']/input[@name='recipientName']")
	public WebElement reciptName;
	/**
	 * Param to input text of reciptMail
	 */
	@FindBy(xpath = "//div[@class='field__inputWrapper flex']/input[@name='recipientEmail']")
	public WebElement reciptMail;
	/**
	 * Param to input text of message
	 */
	@FindBy(xpath = "//div[@class='field__inputWrapper flex']/input[@name='message']")
	public WebElement message;
	/**
	 * Param to validate of elemntos of form
	 */
	@FindBy(xpath = "//div[@class='pt3 lg-pt5']/form")
	public WebElement formFields;
	/**
	 * Param to button "Checkout" of page
	 */
	@FindBy(xpath = "//div[@class='visible']/button[text()='Checkout']")
	public WebElement buttonCheout;
	/**
	 * Param to button send Gift
	 */
	@FindBy(xpath = "//div[@class='visible']/button[text()='Send gift']")
	public WebElement buttonSendGift;
	/**
	 * Param to select one of page gift Send
	 */
	@FindBy(xpath = "//select/option[@value='masterpass']")
	public WebElement selectionMaster;
	/**
	 * Param to Button Continue
	 */
	@FindBy(xpath = "//div[@class='visible']/button[text()='Continue']")
	public WebElement buttonContinue;

	/**
	 * Method to fill the form to send card
	 * 
	 * @return
	 */
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
			log.error("StarbucksGiffPage.getGiftCards()", e);
		}

		return giftCard;
	}

	/**
	 * Method to verify that de button says "Continue"
	 * 
	 * @return Text of button
	 */
	public String getVerifyContinue() {

		String buttonSays = "";
		try {

			selectionMaster.click();

			getWait().until(ExpectedConditions.elementToBeClickable(buttonContinue));
			buttonSays = buttonContinue.getText();

		} catch (Exception e) {
			log.error("Error en StarbucksGiffPage.getVerifyContinue()", e);
		}

		return buttonSays;

	}
}
