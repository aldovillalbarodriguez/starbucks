package com.globant.restBack;

import static io.restassured.RestAssured.given;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class SearchGreyTest extends BaseTest {
	Logger log = Logger.getLogger(SearchGreyTest.class);
	String urlSearchGrey = "https://gp_search.grey.com/gp_searchapi";

	@Test
	public void searchGreyHeader() {

		String valueHeader = "";

		Response response = given().headers("Authorization", valueHeader).param("u", "qa").param("q", "publish_6847")
				.get(urlSearchGrey);

		Assert.assertNotNull(response);

		log.info("jSon>>>" + response.asString());
	}

}
