package com.globant.restBack.endpoints;

import org.apache.log4j.Logger;

import io.restassured.RestAssured;

/**
 * Class to get up in RestAssured all the endpoints
 *
 * @author aldo.villalba
 *
 */

public class SetUpEndPoints {

	Logger log = Logger.getLogger(SetUpEndPoints.class);

	/**
	 * Method to get init the endpoint
	 *
	 * @param url
	 *            get the string to get up the endpoint
	 */
	public void initializeEndpoint(String url) {
		try {

			RestAssured.baseURI = url;

		} catch (Exception e) {
			log.error("Error SetUpEndPoints.initializeEndpoint()", e);
		}

	}

}
