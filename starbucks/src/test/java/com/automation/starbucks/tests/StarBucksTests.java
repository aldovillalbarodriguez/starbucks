package com.automation.starbucks.tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.starbucks.pages.StarbucksHomePage;

public class StarBucksTests extends BaseTests {
	
//	@Test
//	public void testStarBucks() {
//		
//		System.out.println("0.- entrando tests");
//		
//		StarbucksHomePage starbucksMenu = getStarbucksPage();
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
//		
//		List<String> todosMenus = starbucksMenu.mostrarMenu();
//		
//		try {
//		
//				
//				Assert.assertEquals(todosMenus, menusEsperados);
//				
//				
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("0.- Finalizó correctamente");
//		
//	}
	
	@Test
	public void testFindPerfecCoffee () {
		System.out.println("1.- entró al StarbucksPerfectCoffeePage");
		StarbucksHomePage starbucksMenu = getStarbucksPage();
		
		starbucksMenu.gerPefectCoffee();
		
	}

}
