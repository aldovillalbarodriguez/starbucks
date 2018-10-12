package com.automation.starbucks.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.starbucks.pages.StarbucksHomePage;
import com.automation.starbucks.pages.StarbucksPerfectCoffeePage;
import com.automation.starbucks.pages.StarbucksSignInPage;

public class StarBucksTests extends BaseTests {
	
	@Test
	public void testStarBucks() {
		System.out.println("0.- entrando tests");
		StarbucksHomePage starbucksMenu = getStarbucksPage();
		
		List<String> menusEsperados = new ArrayList<>();
		menusEsperados.add("COFFEE");
		menusEsperados.add("TEA");
		menusEsperados.add("MENU");
		menusEsperados.add("COFFEEHOUSE");
		menusEsperados.add("SOCIAL IMPACT");
		menusEsperados.add("STARBUCKS REWARDS");
		menusEsperados.add("BLOG");
		menusEsperados.add("GIFT CARDS");
		
		List<String> todosMenus = starbucksMenu.mostrarMenu();
		
		try {
				Assert.assertEquals(todosMenus, menusEsperados);				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("0.- Finalizó correctamente");
		
	}
	
	@Test(dataProvider="testAllAnswers")
	public void testFindPerfecCoffee (Integer numRespuesta) {
		System.out.println("1.- entró al StarbucksPerfectCoffeePage");
		StarbucksHomePage starbucksMenu = getStarbucksPage();
		StarbucksPerfectCoffeePage perfectCoffee= null;
		String nombreUrl="";
		try {
			String urlEsperada = "https://athome.starbucks.com/coffee-finder/";
			
			perfectCoffee = starbucksMenu.gerPefectCoffee();
			
			nombreUrl = perfectCoffee.questionPerfectCoffePage(numRespuesta);
			 
			Assert.assertEquals(urlEsperada, nombreUrl);
			
			System.out.println("1- terminó y la url es?>>>>"+nombreUrl);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			
	}
	
	@DataProvider(name="testAllAnswers")
	public Object[][] testAllAnswers() {
				
		return new Object[][] {{ 0 }, { 1 },{ 2 }}; 
	}
	
	@Test()
	public void giftCarts() {
		System.out.println("2.- entró al giftCarts");
		StarbucksHomePage starbucksMenu = getStarbucksPage();
		StarbucksSignInPage starbucksSignInPage = starbucksMenu.signIn();
		
		starbucksSignInPage.getSignIn();
		
		System.out.println("2.- finalizó al giftCarts");
	}
	
}
