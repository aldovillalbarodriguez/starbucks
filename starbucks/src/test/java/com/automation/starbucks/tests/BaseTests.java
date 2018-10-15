package com.automation.starbucks.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.starbucks.MyDriver;
import com.automation.starbucks.pages.StarbucksHomePage;
import com.automation.starbucks.pages.StarbucksPerfectCoffeePage;
import com.automation.starbucks.pages.StarbucksSignInPage;

/**
 * Class to config of all Tests
 * @author aldo.villalba
 *
 */
public class BaseTests {
	
	MyDriver myDriver;
	
	private StarbucksHomePage starbucksHome;
	private StarbucksPerfectCoffeePage perfecCoffePage;
	private StarbucksSignInPage singInPage;
	
	@BeforeMethod (alwaysRun = true)
	public void beforeSuite() {
		
		myDriver = new MyDriver();
		starbucksHome = new StarbucksHomePage(myDriver.getDriver());
		
		
	}

	@AfterMethod(alwaysRun = true)
	public void afterSuite() {
		
		starbucksHome.dispose();
	}
	
	public StarbucksHomePage getStarbucksPage () {
		return starbucksHome;

	}
	
	public StarbucksPerfectCoffeePage getPefectCoffePage() {
		return perfecCoffePage;
	}
	
	public StarbucksSignInPage getSignInPage() {
		return singInPage;
	}

}
