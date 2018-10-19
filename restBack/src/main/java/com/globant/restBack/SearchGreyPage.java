package com.globant.restBack;

import static io.restassured.RestAssured.given;

import com.globant.restBack.endpoints.SetUpEndPoints;

import io.restassured.response.Response;

public class SearchGreyPage extends BasePage {

	/**
	 * Method to return the endpoint ready to use
	 *
	 * @param url
	 * @return
	 */

	public SetUpEndPoints getStatusResource() {
		SetUpEndPoints endPoint = new SetUpEndPoints();
		String urlBasic = "https://gp_search.grey.com/gp_searchapi/search";
		try {
			endPoint.initializeEndpoint(urlBasic);

		} catch (Exception e) {
			log.error("Error JsonPlaceHolderPage.getStatusResource()", e);
		}

		return endPoint;

	}

	/**
	 * Method to get reponse of resource wiht params and header
	 * 
	 * @return
	 */
	public Response getResposeHeader() {

		Response response = null;
		String valueHeader = "";

		try {
			response = given().headers("Authorization", valueHeader).param("u", "qa").param("q", "publish_6847")
					.param("d", "id").param("p", "t").param("c", "t").param("s", "publish").param("m", "all").get();
			log.info("jSon>>>" + response.asString());
		} catch (Exception e) {
			log.error("error SearchGreyPage.getResposeHeader()");
		}

		return response;

	}

}
