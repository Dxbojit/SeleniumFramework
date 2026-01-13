package com.demoqa.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	private WaitUtils() {}
	
	 public static WebDriverWait getWait(WebDriver driver) {
	        int timeout = Integer.parseInt(
	                ConfigReader.get("explicitWait")
	        );
	        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
	    }
}
