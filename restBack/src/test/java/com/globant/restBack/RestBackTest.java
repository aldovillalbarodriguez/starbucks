package com.globant.restBack;

import static io.restassured.RestAssured.get;

import java.util.List;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Class to run all Back test
 *
 * @author aldo.villalba
 *
 */
public class RestBackTest extends BaseTest {
	Logger log = Logger.getLogger(RestBackTest.class);
	JsonPlaceHolderPage placeHolderPage = new JsonPlaceHolderPage();

	/**
	 * Method to exercise 1
	 *
	 * get the resource to geting up the endpoind and send the httpStatus
	 *
	 */

	@Test(priority = 1, enabled = true)
	public void backTestTraining() {
		try {

			placeHolderPage.getStatusResource();
			Assert.assertEquals(get().statusCode(), HttpStatus.SC_OK);
			log.info("Exercise 1 HttpStatus>>>" + get().statusCode());

		} catch (Exception e) {
			log.error("Erro RestBackTest.backTestTraining()", e);
		}

	}

	/**
	 * Method to exercise 2.1 Validate schema of json of response a resource vs file
	 * schema
	 *
	 * @param nameResources
	 */
	@Test(dataProvider = "sendResources", enabled = true, priority = 2)
	public void backTestCase2(String nameResources) {

		try {

			placeHolderPage.getStatusResource();

			boolean isItRight = placeHolderPage.getValidationJson(nameResources);

			Assert.assertTrue(isItRight);

		} catch (Exception e) {
			log.error("error RestBackTest.backTestCase2()", e);
		}

	}

	/**
	 * Method to set dataprovider to exercise 2.1
	 *
	 * @return
	 */
	@DataProvider(name = "sendResources")
	public Object[][] sendResources() {

		return new Object[][] { { "posts" }, { "comments" }, { "albums" }, { "photos" }, { "todos" }, { "users" } };
	}

	/**
	 * Exercise 2.2 get by id (20,50,100)resources to posts
	 *
	 * @param id
	 * @param data
	 */
	@Test(dataProvider = "sendIdResources", enabled = true, priority = 3)
	public void testGetid(String id, List<Object> data) {

		placeHolderPage.getStatusResource();
		Assert.assertEquals(data, placeHolderPage.getAtributes(id));

	}

	/**
	 * Method to set dataprovider to exercise 2.2
	 *
	 * @return
	 */
	@DataProvider(name = "sendIdResources")
	public Object[][] sendIdResources() {

		placeHolderPage.getStatusResource();

		return new Object[][] { { "20", placeHolderPage.getDataToProvider("20") },
				{ "50", placeHolderPage.getDataToProvider("50") },
				{ "100", placeHolderPage.getDataToProvider("100") } };
	}

	/**
	 * Method to exercise 2.3 call resources to posts by id 1
	 */
	@Test(enabled = true, priority = 4)
	public void getIdPost() {

		try {
			placeHolderPage.getStatusResource();
			Assert.assertNotNull(placeHolderPage.getIdResource("posts", 1, "userId"));
		} catch (Exception e) {
			log.error("error RestBackTest.getIdPost()", e);
		}

	}

	/**
	 * Method to exercise 2.3 call resources to comments by id 1
	 */
	@Test(enabled = true, priority = 5)
	public void getIdComents() {
		try {
			placeHolderPage.getStatusResource();
			Assert.assertNotNull(placeHolderPage.getIdResource("comments", 1, "postId"));
		} catch (Exception e) {
			log.error("error RestBackTest.getIdComents()", e);
		}

	}

}
