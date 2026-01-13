package com.demoqa.stepdefinitions;

import com.demoqa.utils.ConfigReader;
import com.demoqa.utils.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	@Before
	public void setUp() {
		DriverFactory.initDriver();
        DriverFactory.getDriver().get(ConfigReader.get("baseUrl"));
	}
	
	@After
	 public void tearDown() {
        DriverFactory.quitDriver();
    }
}
