package com.globant.restBack;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.globant.restBack.endpoints.SetUpEndPoints;

import io.restassured.response.Response;

/**
 * Class to Page https://jsonplaceholder.typicode.com" get all resources get
 * resources by id
 *
 * @author aldo.villalba
 *
 */

public class JsonPlaceHolderPage extends BasePage {

	Logger log = Logger.getLogger(JsonPlaceHolderPage.class);

	/**
	 * Method to return the endpoint ready to use
	 *
	 * @param url
	 * @return
	 */
	public SetUpEndPoints getStatusResource() {
		SetUpEndPoints endPoint = new SetUpEndPoints();
		String urlBasic = "https://jsonplaceholder.typicode.com";
		try {
			endPoint.initializeEndpoint(urlBasic);

		} catch (Exception e) {
			log.error("Error JsonPlaceHolderPage.getStatusResource()", e);
		}

		return endPoint;

	}

	/**
	 * Method to validate if Response is a correct JsonSchema or not
	 *
	 * @param nameResources
	 * @return
	 */

	public boolean getValidationJson(String nameResources) {
		boolean validation = true;
		try {
			InputStream file = getFileSquema(nameResources);

			get("/" + nameResources).then().assertThat().body(matchesJsonSchema(file));

		} catch (AssertionError e) {
			log.error("Error JsonPlaceHolderPage.getValidationJson()", e);
			return validation = false;
		}

		return validation;
	}

	/**
	 * Method to fill the data to compared vs Response by id
	 *
	 * @param idToGet
	 * @return
	 */

	public List<Object> getDataToProvider(String idToGet) {
		List<Object> values = new ArrayList<>();
		switch (idToGet) {
		case "20":

			values.add(2);
			values.add(20);
			values.add("doloribus ad provident suscipit at");
			values.add(
					"qui consequuntur ducimus possimus quisquam amet similique\nsuscipit porro ipsam amet\neos veritatis officiis exercitationem vel fugit aut necessitatibus totam\nomnis rerum consequatur expedita quidem cumque explicabo");
			break;
		case "50":
			values.add(5);
			values.add(50);
			values.add("repellendus qui recusandae incidunt voluptates tenetur qui omnis exercitationem");
			values.add(
					"error suscipit maxime adipisci consequuntur recusandae\nvoluptas eligendi et est et voluptates\nquia distinctio ab amet quaerat molestiae et vitae\nadipisci impedit sequi nesciunt quis consectetur");

			break;
		case "100":
			values.add(10);
			values.add(100);
			values.add("at nam consequatur ea labore ea harum");
			values.add(
					"cupiditate quo est a modi nesciunt soluta\nipsa voluptas error itaque dicta in\nautem qui minus magnam et distinctio eum\naccusamus ratione error aut");
			break;
		default:
			break;
		}

		return values;

	}

	/**
	 * Method fill the attributes of a call to resource
	 *
	 * @param id
	 * @return
	 */
	public List<Object> getAtributes(String id) {
		List<Object> atributesHoped = new ArrayList<>();
		try {

			Response responseed = given().param("id", id).when().get("/posts");
			List<Object> userIdReponse = responseed.path("userId");
			List<Object> idResponse = responseed.path("id");
			List<Object> titleResponse = responseed.path("title");
			List<Object> bodyResponse = responseed.path("body");
			atributesHoped.add(userIdReponse.get(0));
			atributesHoped.add(idResponse.get(0));
			atributesHoped.add(titleResponse.get(0));
			atributesHoped.add(bodyResponse.get(0));

			log.info("class name>> testGetid>>" + responseed.asString());

		} catch (Exception e) {
			log.error("error JsonPlaceHolderPage.getAtributes()");
		}

		return atributesHoped;
	}

	/**
	 * Method to call a response by id
	 * 
	 * @param resource
	 * @param id
	 * @param param
	 * @return
	 */
	public Response getIdResource(String resource, Integer id, String param) {
		Response respons = null;
		try {

			respons = given().param(param, id).when().get("/" + resource);

			log.info("getIdResource " + resource + " >>" + respons.asString());

		} catch (AssertionError e) {
			log.error("error JsonPlaceHolderPage.getIdResource()");
		}

		return respons;
	}

}
