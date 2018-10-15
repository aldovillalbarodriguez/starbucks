package com.automation.starbucks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriver {

private WebDriver driver;
	
	public MyDriver () {
		String browser = System.getProperty("browser");
		
		String os = System.getProperty("os.name").toLowerCase();
		
		System.out.println("meustrame el sitema operativo>>"+os);
		
		String pipe = System.getProperty("file.separator");
			
		try {
			
			switch (browser) {

			case "fireFox":
					
					if(os.contains("win")) {
						System.setProperty("webdriver.gecko.driver", "src"+pipe+"test"+pipe+"resources"+pipe+"drivers"+pipe+"geckodriver.exe");
					}
					if(os.contains("mac")) {
						System.setProperty("webdriver.gecko.driver", "src"+pipe+"test"+pipe+"resources"+pipe+"drivers"+pipe+"geckodriver");
					}
					
					driver = new FirefoxDriver();
				
				break;
				
			case "chrome":
				
					if(os.contains("win")) {
						System.setProperty("webdriver.gecko.driver", "src"+pipe+"test"+pipe+"resources"+pipe+"drivers"+pipe+"chromedriver.exe");
					}
					if(os.contains("mac")) {
						System.setProperty("webdriver.gecko.driver", "src"+pipe+"test"+pipe+"resources"+pipe+"drivers"+pipe+"chromedriver");
					}	
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
