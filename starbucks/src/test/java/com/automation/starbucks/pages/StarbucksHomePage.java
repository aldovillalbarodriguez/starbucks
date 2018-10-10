package com.automation.starbucks.pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StarbucksHomePage extends BasePage {

	public StarbucksHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
		driver.get("https://www.starbucks.com");
	}
	
	@FindBy(css="#nav > div.nav_menu > ul > li")
	private List<WebElement> listaMenu;
	
	
	private WebElement menuCoffe;
	
	
	public List<String> mostrarMenu() {
		List<String> todosMenus = new ArrayList<>();
		for(WebElement menu: listaMenu) {
			todosMenus.add(menu.getText());
		}
		return todosMenus;
	}
	
	public StarbucksPerfectCoffeePage gerPefectCoffee() {
		
		StarbucksPerfectCoffeePage pefectCoffeePage = new StarbucksPerfectCoffeePage(getDriver());
	
		
		for(WebElement menu: listaMenu) {
			if(menu.getText().equalsIgnoreCase("COFFEE"))
			{
				menuCoffe = menu;
				break;
			}
		}
		
		menuCoffe.click();
		
		return pefectCoffeePage;
		
		
	}
	
	

}
