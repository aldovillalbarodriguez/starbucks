package com.automation.starbucks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriver {

private WebDriver driver;
	
	public MyDriver () {
		String browser = System.getProperty("browser");
			
		try {
			
			switch (browser) {

			case "fireFox":
				
					System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\drivers\\geckodriver.exe");
					driver = new FirefoxDriver();
				
				break;
				
			case "chrome":
				
					System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");		
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
