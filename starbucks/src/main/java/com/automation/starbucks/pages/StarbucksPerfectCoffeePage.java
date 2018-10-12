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
	/**
	 * Answers Object List to question 1
	 * 
	 */
	@FindBy(css="#question1 > button")
	private List<WebElement> answerQuestion1;
	/**
	 * Answers Object List to question 2
	 * 
	 */
	
	@FindBy(css="#question2 > button")
	private List<WebElement> answerQuestion2;
	
	/**
	 * Answers Object List to question 3
	 * 
	 */
	
	@FindBy(css="#light-questions > button")
	private List<WebElement> answerQuestion3;
	
	/**
	 * Answers Object List to question 4
	 * 
	 */
	
	@FindBy(css="#question4 > button")
	private List<WebElement> answerQuestion4;
	
	/**
	 * Answers Object List to question 5
	 * 
	 */

	@FindBy(css="#medium-questions > button")
	private List<WebElement> answerQuestion5;
	
	/**
	 * Answers Object List to question 6
	 * 
	 */
	
	@FindBy(css="#dark-questions > button")
	private List<WebElement> answerQuestion6;
	
	/**
	 * Object to define find my coffee
	 * 
	 */
	
	@FindBy(id="find-my-coffee")
	private WebElement botonFindMyCoffee;
	
	
	/**
	 * Method to get the url of page 
	 * @return
	 */
	
	public String getUrlPage () {
		return urlPage;
	}
	/**
	 * Method to get answers and find the perfect coffee the param 
	 * works to do possible outputs
	 * @param numRespuesta
	 * @return
	 */
	public String questionPerfectCoffePage(Integer numRespuesta) {
		String respuesta = "";
			
		try {
			
			List<String> respuestas = new ArrayList<>();
			respuestas.add(this.clikeaRepuesta(answerQuestion1, numRespuesta));
			respuestas.add(this.clikeaRepuesta(answerQuestion2, numRespuesta));
			
			switch (numRespuesta) {
			case 0:
				respuestas.add(this.clikeaRepuesta(answerQuestion3, numRespuesta));
				break;
			case 1:	
				respuestas.add(this.clikeaRepuesta(answerQuestion5, numRespuesta));
				break;
			case 2:
				respuestas.add(this.clikeaRepuesta(answerQuestion6, numRespuesta));
				break;

			default:
				break;
			}
			
			respuestas.add(this.clikeaRepuesta(answerQuestion4, numRespuesta));
			
			getWait().until(ExpectedConditions.elementToBeClickable(botonFindMyCoffee));
			
			botonFindMyCoffee.click();
			
			respuesta = getDriver().getCurrentUrl();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return respuesta;
		
		
	}
	
	
	/**
	 * Method to do click in some number answer
	 * @param listaRepuestas
	 * @param numRepuesta
	 * @return
	 */
	public String clikeaRepuesta(List<WebElement> listaRepuestas, Integer numRepuesta ) {
	
		WebElement objetoRepuesta = null;
		
		try {
			
			getWait().until(ExpectedConditions.visibilityOfAllElements(listaRepuestas));
			objetoRepuesta = listaRepuestas.get(numRepuesta);
			
			getWait().until(ExpectedConditions.elementToBeClickable(objetoRepuesta));
			objetoRepuesta.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaRepuestas.get(numRepuesta).getText();
		
	}


}
