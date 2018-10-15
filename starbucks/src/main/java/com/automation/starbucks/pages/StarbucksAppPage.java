package com.automation.starbucks.pages;

import java.util.List;

import javax.print.attribute.standard.RequestingUserName;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class of Starbucks App Page
 * @author aldo.villalba
 *
 */

public class StarbucksAppPage extends BasePage{
	
	Logger log = Logger.getLogger(StarbucksAppPage.class);

	public StarbucksAppPage(WebDriver driver) {
		super(driver);
		
	}
	
	/**
	 * Object to main Menu of page
	 */
	@FindBy(xpath="//ul[@class='whiteSpace-truncate flex-auto sb-navbar-list']/li")
	public List<WebElement> mainMenu;
	
	/**
	 * Object to one of menu of Main menu
	 */
	public WebElement menuGiff;
	
	/**
	 * Method to get the menu "GIFT"
	 * @return
	 */
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
