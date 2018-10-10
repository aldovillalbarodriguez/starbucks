package com.automation.starbucks.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.starbucks.MyDriver;
import com.automation.starbucks.pages.StarbucksHomePage;

public class BaseTests {
	
	MyDriver myDriver;
	
	private StarbucksHomePage starbucksHome;
	
	
	@BeforeSuite (alwaysRun = true)
	public void beforeSuite() {
		
		myDriver = new MyDriver();
				
		starbucksHome = new StarbucksHomePage(myDriver.getDriver());
		
		
	}
	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		
		starbucksHome.dispose();
	}
	
	public StarbucksHomePage getStarbucksPage () {
		return starbucksHome;
		

	}
	

}
