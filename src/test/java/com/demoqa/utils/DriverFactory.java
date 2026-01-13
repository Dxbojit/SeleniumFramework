package com.demoqa.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class DriverFactory {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	private DriverFactory() {}
	
	public static void initDriver() {

        String browser = ConfigReader.get("browser");
        boolean headless = Boolean.parseBoolean(ConfigReader.get("headless"));

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (headless) {
                options.addArguments("--headless=new");
            }
            driver.set(new ChromeDriver(options));
        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }

        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().pageLoadTimeout(
                java.time.Duration.ofSeconds(
                        Integer.parseInt(ConfigReader.get("pageLoadTimeout"))
                )
        );
	}
	
    public static WebDriver getDriver() {
        return driver.get();
    }
    
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
