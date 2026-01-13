package com.demoqa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ConfigReader{
	
	private static Properties properties;
	
	 private ConfigReader() {}
	 
	 static {
	        try {
	            FileInputStream fis = new FileInputStream(
	                    "src/test/resources/config/config.properties"
	            );
	            properties = new Properties();
	            properties.load(fis);
	        } catch (IOException e) {
	            throw new RuntimeException("Failed to load config.properties", e);
	        }
	    }
	 public static String get(String key) {
	        return properties.getProperty(key);
	    }
}
