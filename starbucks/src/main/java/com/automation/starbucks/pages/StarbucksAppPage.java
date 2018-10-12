package com.automation.starbucks.pages;

import java.util.List;

import javax.print.attribute.standard.RequestingUserName;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class StarbucksAppPage extends BasePage{
	
	Logger log = Logger.getLogger(StarbucksAppPage.class);

	public StarbucksAppPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//ul[@class='whiteSpace-truncate flex-auto sb-navbar-list']/li")
	public List<WebElement> mainMenu;
	
	public WebElement menuGiff;
	
	public StarbucksGiffPage getPageGiff () {
		
		log.info("llegas a getPageGiff ()");
		try {
			
			menuGiff = getMenu(mainMenu, "GIFT");
			menuGiff.click();
		} catch (Exception e) {
			log.error("error en StarbucksAppPage.getPageGiff()",e);
		}
		
		
		
		return new StarbucksGiffPage (getDriver());
	}
	

}
