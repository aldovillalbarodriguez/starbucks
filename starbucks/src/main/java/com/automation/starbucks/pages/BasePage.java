package com.automation.starbucks.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class to get de Driver of Browser
 * @author aldo.villalba
 *
 */
public class BasePage {
	
	Logger log = Logger.getLogger(BasePage.class);
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public BasePage(WebDriver pDriver) {
		
		PageFactory.initElements(pDriver, this);
		wait = new WebDriverWait(pDriver, 10);
		driver = pDriver;
		
	}
	
	public WebDriverWait getWait() {
		return wait;

	}
	
	protected WebDriver getDriver() {	
		return driver;
	}
	
	public void dispose() {
		if (driver != null) {
			driver.quit();
		}
	}
	/**
	 * Method to get a option of menu 
	 * @param listMenu. All option of a mainMenu
	 * @param stringMenu. Text of menu to get 
	 * @return the webElemento of page
	 */
	public WebElement getMenu(List<WebElement> listMenu, String stringMenu) {
		WebElement menu = null;
		
		getWait().until(ExpectedConditions.visibilityOfAllElements(listMenu));
		for(WebElement subMenu:listMenu) {
			
			if(subMenu.getText().equalsIgnoreCase(stringMenu)) {
				menu = subMenu;
				break;
			}
		}
			
		return menu;
	}
	
	/**
	 * Method to get a Img of a page of Starbucks
	 * @param typeFind
	 * @param stringFind
	 * @return
	 */
	public WebElement getImg(String typeFind, String stringFind) {
		WebElement img = null;
		
		switch (typeFind) {
		case "xpath":
			img = getDriver().findElement(By.xpath(stringFind));
			break;
		case "name":
			img = getDriver().findElement(By.name(stringFind));
			    
		case "id":
			img = getDriver().findElement(By.id(stringFind));
				
		case "claseName":
			img = getDriver().findElement(By.className(stringFind));
			    
		default:
			break;
		}
		
		
		return img;
	}
}
