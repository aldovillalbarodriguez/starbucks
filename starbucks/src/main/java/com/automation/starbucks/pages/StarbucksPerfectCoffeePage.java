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
	 * Lista de objetos de tipo respuestas para la pregunta 1
	 * 
	 */
	@FindBy(css="#question1 > button")
	private List<WebElement> answerQuestion1;
	/**
	 * Lista de objetos de tipo respuestas para la pregunta 2
	 * 
	 */
	
	@FindBy(css="#question2 > button")
	private List<WebElement> answerQuestion2;
	
	/**
	 * Lista de objetos de tipo respuestas para la pregunta 3
	 * 
	 */
	
	@FindBy(css="#light-questions > button")
	private List<WebElement> answerQuestion3;
	
	/**
	 * Lista de objetos de tipo respuestas para la pregunta 4
	 * 
	 */
	
	@FindBy(css="#question4 > button")
	private List<WebElement> answerQuestion4;
	
	/**
	 * Lista de objetos de tipo respuestas para la pregunta 5
	 * 
	 */

	@FindBy(css="#medium-questions > button")
	private List<WebElement> answerQuestion5;
	
	/**
	 * Lista de objetos de tipo respuestas para la pregunta 4
	 * 
	 */
	
	@FindBy(css="#dark-questions > button")
	private List<WebElement> answerQuestion6;
	
	/**
	 * Objeto para definir el boton para mostra el cafe Perfecto
	 * 
	 */
	
	@FindBy(id="find-my-coffee")
	private WebElement botonFindMyCoffee;
	
	
	
	public String getUrlPage () {
		return urlPage;
	}
	/**
	 * Metodo que sirve para responder las preguntas y encontrar el perfect coffee
	 * el parametro numRespuesta sirve para elegir las combinaciones posibles
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
	 * Método que realiza 
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
