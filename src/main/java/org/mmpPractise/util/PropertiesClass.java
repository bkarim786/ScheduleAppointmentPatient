package org.mmpPractise.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesClass {

	Properties pro = new Properties();
	public Properties loadProperties() throws IOException {
		String filePath = System.getProperty("user.dir")+"\\config\\mmpPractise.properties";
		FileInputStream fis = new FileInputStream(filePath);
		pro.load(fis); //loads the mmpPractise file in memory...
		return pro;
	}

}
