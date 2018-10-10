package com.automation.starbucks.pages;

import org.openqa.selenium.WebDriver;

public class StarbucksPerfectCoffeePage extends BasePage {
	
	String urlPage="";
	public StarbucksPerfectCoffeePage(WebDriver driver) {
		super(driver);
		urlPage = driver.getCurrentUrl();
	}
	
	public String getUrlPage () {
		System.out.println("llega al nuevo objeto StarbucksPerfectCoffeePage");
		
		return urlPage;
	}

}
