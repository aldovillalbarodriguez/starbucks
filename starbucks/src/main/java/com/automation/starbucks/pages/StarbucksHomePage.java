package com.automation.starbucks.pages;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class of home of Starbucks Page
 * @author aldo.villalba
 *
 */
public class StarbucksHomePage extends BasePage {

	Logger log = Logger.getLogger(StarbucksHomePage.class);
	public StarbucksHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
		driver.get("https://www.starbucks.com");
	}
	/**
	 * Param to get the main menu of starbucks page
	 */
	@FindBy(css="#nav > div.nav_menu > ul > li")
	private List<WebElement> listaMenu;
	
	/**
	 * Param to get one menu of coffee
	 */
	private WebElement menuCoffe;
	/**
	 * Param to get submenu of coffee
	 */
	@FindBy(css="#menu_coffee > div.region.size4of5.menu_content > ol > li") 
	private List<WebElement> menuDesplegableCoffee;
	
	/**
	 * Param to get pefect coffee option of submenu
	 * 
	 */
	private WebElement subMenuPerfectCoffee;
	
	/**
	 * Var to object to signIn 
	 */
	@FindBy(id="signIn")
	private WebElement signIn;
	
	/**
	 * Method to get all options of main menu of starbucks
	 * @return a list of string of all menu
	 */
	public List<String> mostrarMenu() {
		List<String> todosMenus = new ArrayList<>();

		for(WebElement menu: listaMenu) {
			
			todosMenus.add(menu.getText());
		}
		return todosMenus;
	}
	
	/**
	 * Method to get of perfect coffe menu
	 * @return
	 */
	public StarbucksPerfectCoffeePage gerPefectCoffee() {
			
		try {
			
			menuCoffe = getMenu(listaMenu, "COFFEE");
			menuCoffe.click();
			
			getWait().until(ExpectedConditions.visibilityOfAllElements(menuDesplegableCoffee));
			
			subMenuPerfectCoffee = getMenu(menuDesplegableCoffee, "Find Your Perfect Coffee");
			
			subMenuPerfectCoffee.click();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new StarbucksPerfectCoffeePage(getDriver());
		
	}
	/**
	 * Method to get the signIn Page of starBucks
	 * @return
	 */
	
	public StarbucksSignInPage signIn() {
		log.info("3.- entras a signIn");
		
		signIn.click();
		
		return new StarbucksSignInPage(getDriver());
	}

}
