package com.globant.restBack;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchGreyTest extends BaseTest {
	Logger log = Logger.getLogger(SearchGreyTest.class);
	SearchGreyPage searchGreyPage = new SearchGreyPage();

	@Test(enabled = true)
	public void searchGreyHeader() {

		try {
			Assert.assertNotNull(searchGreyPage.getResposeHeader());
		} catch (Exception e) {
			log.error("Error SearchGreyTest.searchGreyHeader()", e);
		}

	}

}
