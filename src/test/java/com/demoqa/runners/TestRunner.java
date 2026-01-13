package com.demoqa.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features = "src/test/resources",
glue= "com.demoqa.stepdefinitions",
tags= "${cucumber.filter.tags}",
plugin= {"pretty","html:target/cucumber-report.html","json:target/cucumber-reports/cucumber.json"},
monochrome= true
)

public class TestRunner extends AbstractTestNGCucumberTests{

}
