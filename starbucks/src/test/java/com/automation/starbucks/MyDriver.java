package com.automation.starbucks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriver {

private WebDriver driver;
	
	public MyDriver () {
		String browser = System.getProperty("browser");
		
		System.out.println("El browser es: >>>>"+browser);
				
		try {
			
			switch (browser) {


			case "fireFox":
				//C:\Users\aldo.villalba\Documents\firefoxdriver
					System.setProperty("webdriver.gecko.driver", "C:\\Users\\aldo.villalba\\Documents\\firefoxdriver\\geckodriver.exe");
					driver = new FirefoxDriver();
				
				break;
				
			case "chrome":
				
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\aldo.villalba\\Documents\\chromedriver\\chromedriver.exe");		
					driver = new ChromeDriver();
				
				
				break;
				
				

			default:
				break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	public WebDriver getDriver() {
		
		return this.driver;
	}
	
	
}
