package com.globant.restBack;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class RestBackTest extends BaseTest {
	Logger log = Logger.getLogger(RestBackTest.class);
	String urlResources = "https://jsonplaceholder.typicode.com";

	@Test(priority = 2)
	public void backTestTraining() {
		try {
			Response response = get(urlResources);
			Assert.assertTrue(response.getStatusCode() == 200);
			System.out.println("show response >>" + response.getStatusCode());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(dataProvider = "sendResources", priority = 1)
	public void backTestCase2(String nameResources) {

		try {
			InputStream file = getFileSquema(nameResources);
			// hacer Assertrue
			get(urlResources + "/" + nameResources).then().assertThat().body(matchesJsonSchema(file));

		} catch (AssertionError e) {
			Assert.fail(e.getMessage());
		}

	}

	@DataProvider(name = "sendResources")
	public Object[][] sendResources() {

		return new Object[][] { { "posts" }, { "comments" }, { "albums" }, { "photos" }, { "todos" }, { "users" } };
	}

	@Test(dataProvider = "sendIdResources", priority = 3)
	public void testGetid(String id, List<Object> data) {
		List<Object> atributesHoped = new ArrayList<>();

		Response responseed = given().param("id", id).when().get(urlResources + "/posts");
		List<Object> userIdReponse = responseed.path("userId");
		List<Object> idResponse = responseed.path("id");
		List<Object> titleResponse = responseed.path("title");
		List<Object> bodyResponse = responseed.path("body");
		atributesHoped.add(userIdReponse.get(0));
		atributesHoped.add(idResponse.get(0));
		atributesHoped.add(titleResponse.get(0));
		atributesHoped.add(bodyResponse.get(0));

		log.info("class name>> testGetid>>" + responseed.asString());

		Assert.assertEquals(data, atributesHoped);

	}

	@DataProvider(name = "sendIdResources")
	public Object[][] sendIdResources() {

		List<Object> values20 = new ArrayList<>();
		values20.add(2);
		values20.add(20);
		values20.add("doloribus ad provident suscipit at");
		values20.add(
				"qui consequuntur ducimus possimus quisquam amet similique\nsuscipit porro ipsam amet\neos veritatis officiis exercitationem vel fugit aut necessitatibus totam\nomnis rerum consequatur expedita quidem cumque explicabo");

		List<Object> values50 = new ArrayList<>();
		values50.add(5);
		values50.add(50);
		values50.add("repellendus qui recusandae incidunt voluptates tenetur qui omnis exercitationem");
		values50.add(
				"error suscipit maxime adipisci consequuntur recusandae\nvoluptas eligendi et est et voluptates\nquia distinctio ab amet quaerat molestiae et vitae\nadipisci impedit sequi nesciunt quis consectetur");

		List<Object> values100 = new ArrayList<>();
		values100.add(10);
		values100.add(100);
		values100.add("at nam consequatur ea labore ea harum");
		values100.add(
				"cupiditate quo est a modi nesciunt soluta\nipsa voluptas error itaque dicta in\nautem qui minus magnam et distinctio eum\naccusamus ratione error aut");

		return new Object[][] { { "20", values20 }, { "50", values50 }, { "100", values100 } };
	}

	@Test(priority = 4)
	public void getExamples() {
		Response responsePost = given().param("userId", 1).when().get(urlResources + "/posts");
		Assert.assertNotNull(responsePost);
		log.info("getExamples  responsePost  >>" + responsePost.asString());

		Response responseComents = given().param("postId", 1).when().get(urlResources + "/comments");
		Assert.assertNotNull(responsePost);
		log.info("getExamples  responseComents>>" + responseComents.asString());
	}

}
