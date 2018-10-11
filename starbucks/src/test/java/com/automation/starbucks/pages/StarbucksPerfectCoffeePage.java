package com.automation.starbucks.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StarbucksPerfectCoffeePage extends BasePage {
	
	String urlPage="";
	public StarbucksPerfectCoffeePage(WebDriver driver) {
		super(driver);
		urlPage = driver.getCurrentUrl();
	}
	
	@FindBy(css="#question1 > button")
	private List<WebElement> answerQuestion1;
	
	@FindBy(css="#question2 > button")
	private List<WebElement> answerQuestion2;
	
	@FindBy(css="#light-questions > button")
	private List<WebElement> answerQuestion3;
	
	@FindBy(css="#question4 > button")
	private List<WebElement> answerQuestion4;

	@FindBy(id="find-my-coffee")
	private WebElement botonFindMyCoffee;
	
	
	
	public String getUrlPage () {
		return urlPage;
	}
	
	public String questionPerfectCoffePage() {
		String respuesta = "";
		
	
		try {
			List<String> respuestas = new ArrayList<>();
			respuestas.add(this.clikeaRepuesta(answerQuestion1, 0));
			respuestas.add(this.clikeaRepuesta(answerQuestion2, 0));
			respuestas.add(this.clikeaRepuesta(answerQuestion3, 0));
			respuestas.add(this.clikeaRepuesta(answerQuestion4, 0));
			
			for(String verResp:respuestas ) {
				
				System.out.println("Verifica la respuesta es>>>"+verResp);
				
			}
			
			getWait().until(ExpectedConditions.elementToBeClickable(botonFindMyCoffee));
			
			botonFindMyCoffee.click();
			
			respuesta = getDriver().getCurrentUrl();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return respuesta;
		
		
	}
	
	public String clikeaRepuesta(List<WebElement> listaRepuestas, Integer numRepuesta ) {
		
	
		WebElement objetoRepuesta = null;
		getWait().until(ExpectedConditions.visibilityOfAllElements(listaRepuestas));
		objetoRepuesta = listaRepuestas.get(numRepuesta);
		objetoRepuesta.click();
		return listaRepuestas.get(numRepuesta).getText();
		
	}
	

}
