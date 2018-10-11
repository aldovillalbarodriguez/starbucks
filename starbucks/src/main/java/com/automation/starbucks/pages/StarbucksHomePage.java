package com.automation.starbucks.pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StarbucksHomePage extends BasePage {

	public StarbucksHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
		driver.get("https://www.starbucks.com");
	}
	/**
	 * Variable para poder ver todo el menú principal de la pagina de starbucks
	 */
	@FindBy(css="#nav > div.nav_menu > ul > li")
	private List<WebElement> listaMenu;
	
	/**
	 * Variable para poder elegir el menu de Coffee
	 */
	private WebElement menuCoffe;
	/**
	 * Variable para poder revisar el subMenu desplegable de coffee
	 */
	@FindBy(css="#menu_coffee > div.region.size4of5.menu_content > ol > li") 
	private List<WebElement> menuDesplegableCoffee;
	
	/**
	 * variable para poder ver el submenu y poder elegir el cafe perfecto
	 * 
	 */
	private WebElement subMenuPerfectCoffee;
	
	/**
	 * Var to object to signIn 
	 */
	@FindBy(id="signIn")
	private WebElement signIn;
	
	/**
	 * Metodo para poder revisar las opciones del menu principal
	 * del home de starbucks
	 * @return
	 */
	public List<String> mostrarMenu() {
		List<String> todosMenus = new ArrayList<>();

		for(WebElement menu: listaMenu) {
			
			todosMenus.add(menu.getText());
		}
		return todosMenus;
	}
	
	/**
	 * Metodo que utiliza para poder llegar a la pagina 
	 * para elegir tu perfect coffee
	 * @return
	 */
	public StarbucksPerfectCoffeePage gerPefectCoffee() {
			
		try {
			for(WebElement menu: listaMenu) {
				if(menu.getText().equalsIgnoreCase("COFFEE"))
				{
					menuCoffe = menu;
					break;
				}
			}
			menuCoffe.click();
			
			getWait().until(ExpectedConditions.visibilityOfAllElements(menuDesplegableCoffee));
			
			for(WebElement subMenu:menuDesplegableCoffee) {
				if(subMenu.getText().equalsIgnoreCase("Find Your Perfect Coffee")) {
					subMenuPerfectCoffee = subMenu;
					break;
				}
			}
			
			subMenuPerfectCoffee.click();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new StarbucksPerfectCoffeePage(getDriver());
		
	}
	
	public StarbucksSignInPage signIn() {
		System.out.println("3.- entras a signIn");
		
		signIn.click();
		
		return new StarbucksSignInPage(getDriver());
	}

}
