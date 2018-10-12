package com.automation.starbucks.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.starbucks.pages.StarbucksAppPage;
import com.automation.starbucks.pages.StarbucksGiffPage;
import com.automation.starbucks.pages.StarbucksHomePage;
import com.automation.starbucks.pages.StarbucksPerfectCoffeePage;
import com.automation.starbucks.pages.StarbucksSignInPage;

public class StarBucksTests extends BaseTests {
	
	Logger log = Logger.getLogger(StarBucksTests.class);
	
//	@Test
//	public void testStarBucks() {
//		
//		StarbucksHomePage starbucksMenu = getStarbucksPage();
//		
//		List<String> menusEsperados = new ArrayList<>();
//		menusEsperados.add("COFFEE");
//		menusEsperados.add("TEA");
//		menusEsperados.add("MENU");
//		menusEsperados.add("COFFEEHOUSE");
//		menusEsperados.add("SOCIAL IMPACT");
//		menusEsperados.add("STARBUCKS REWARDS");
//		menusEsperados.add("BLOG");
//		menusEsperados.add("GIFT CARDS");
//		
//		List<String> todosMenus = starbucksMenu.mostrarMenu();
//		
//		try {
//				Assert.assertEquals(todosMenus, menusEsperados);				
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		
//		
//	}
	
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
		log.info("2.- entró a la prueba giftCarts()");
		String verifySendGift ="Send gift";
		String verifyContinue ="Continue";
		String answerSendGift ="";
		String answerContinue ="";
		
		StarbucksHomePage starbucksMenu = getStarbucksPage();
		StarbucksSignInPage starbucksSignInPage = starbucksMenu.signIn();
		
		StarbucksAppPage starbucksAppPage = starbucksSignInPage.getSignIn();
		
		StarbucksGiffPage starbucksGiftPage = starbucksAppPage.getPageGiff();
		
		answerSendGift = starbucksGiftPage.getGiftCards();
		
		answerContinue = starbucksGiftPage.getVerifyContinue();
		
		Assert.assertEquals(verifySendGift, answerSendGift);
		Assert.assertEquals(verifyContinue, answerContinue);
		
		log.info("2.- finalizó al giftCarts");
	}
	
}
