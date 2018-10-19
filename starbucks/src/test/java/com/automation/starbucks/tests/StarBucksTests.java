package com.automation.starbucks.tests;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.starbucks.pages.StarbucksAppPage;
import com.automation.starbucks.pages.StarbucksGiffPage;
import com.automation.starbucks.pages.StarbucksHomePage;
import com.automation.starbucks.pages.StarbucksPerfectCoffeePage;
import com.automation.starbucks.pages.StarbucksSignInPage;

public class StarBucksTests extends BaseTests {

	Logger log = Logger.getLogger(StarBucksTests.class);

	@Test(priority = 1)
	public void testStarBucks() {

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

	}

	@Test(dataProvider = "testAllAnswers", priority = 2)
	public void testFindPerfecCoffee(Integer numRespuesta, List<String> answersHope) {

		StarbucksHomePage starbucksMenu = getStarbucksPage();
		StarbucksPerfectCoffeePage perfectCoffee = null;
		List<String> answerSended = new ArrayList<>();
		String nombreUrl = "";
		try {
			String urlEsperada = "https://athome.starbucks.com/coffee-finder/";

			perfectCoffee = starbucksMenu.gerPefectCoffee();

			answerSended = perfectCoffee.questionPerfectCoffePage(numRespuesta);

			Assert.assertEquals(answersHope, answerSended);

			nombreUrl = perfectCoffee.getUrlPage();

			Assert.assertEquals(urlEsperada, nombreUrl);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@DataProvider(name = "testAllAnswers")
	public Object[][] testAllAnswers() {

		List<String> answer0 = new ArrayList<>();
		answer0.add("Lighthearted and sunny");
		answer0.add("A group of friends");
		answer0.add("Cocoa");
		answer0.add("I like things simple");

		List<String> answer1 = new ArrayList<>();
		answer1.add("Balanced and easy-going");
		answer1.add("A quiet moment");
		answer1.add("Citrus");
		answer1.add("I can mix it up sometimes");

		List<String> answer2 = new ArrayList<>();
		answer2.add("Bold and complex");
		answer2.add("A busy day");
		answer2.add("Nuts and spices");
		answer2.add("I love to try something new and different");

		return new Object[][] { { 0, answer0 }, { 1, answer1 }, { 2, answer2 } };
	}

	@Test(priority = 3)
	public void giftCarts() {

		String verifySendGift = "Send gift";
		String verifyContinue = "Continue";
		String answerSendGift = "";
		String answerContinue = "";

		StarbucksHomePage starbucksMenu = getStarbucksPage();
		StarbucksSignInPage starbucksSignInPage = starbucksMenu.signIn();

		StarbucksAppPage starbucksAppPage = starbucksSignInPage.getSignIn();

		StarbucksGiffPage starbucksGiftPage = starbucksAppPage.getPageGiff();

		answerSendGift = starbucksGiftPage.getGiftCards();

		answerContinue = starbucksGiftPage.getVerifyContinue();

		Assert.assertEquals(verifySendGift, answerSendGift);
		Assert.assertEquals(verifyContinue, answerContinue);

	}

}
