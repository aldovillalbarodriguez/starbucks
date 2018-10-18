package com.globant.restBack;

import java.io.InputStream;

import org.apache.log4j.Logger;

public class BaseTest {
	Logger log = Logger.getLogger(BaseTest.class);

	public InputStream getFileSquema(String nameSquema) {
		String folder = "jsonSquemas";
		InputStream file = null;

		try {

			file = this.getClass().getClassLoader().getResourceAsStream(folder + "/" + nameSquema + ".json");

		} catch (Exception e) {
			log.error("error BaseTest.getFileSquema()", e);
		}

		return file;
	}

}
