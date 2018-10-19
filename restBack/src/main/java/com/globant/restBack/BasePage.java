package com.globant.restBack;

import java.io.InputStream;

import org.apache.log4j.Logger;

public class BasePage {

	Logger log = Logger.getLogger(BasePage.class);

	public InputStream getFileSquema(String nameSquema) {
		String folder = "jsonSchemas";
		InputStream file = null;

		try {

			file = this.getClass().getClassLoader().getResourceAsStream(folder + "/" + nameSquema + ".json");

		} catch (Exception e) {
			log.error("error BaseTest.getFileSquema()", e);
		}

		return file;
	}

}
