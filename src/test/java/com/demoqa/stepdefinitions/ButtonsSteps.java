package com.demoqa.stepdefinitions;

import org.testng.Assert;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.elements.ButtonsPage;
import com.demoqa.utils.ConfigReader;
import com.demoqa.utils.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ButtonsSteps {
	 ButtonsPage buttonsPage;
	 
	 @Given("user is on Buttons page")
	    public void user_is_on_buttons_page() {

	        HomePage homePage = new HomePage(DriverFactory.getDriver());
	        homePage.clickElementsCard();

	        DriverFactory.getDriver()
	                .get(ConfigReader.get("buttonsUrl"));

	        buttonsPage = new ButtonsPage(DriverFactory.getDriver());
	    }
	 
	 	@When("user performs double click")
	    public void user_performs_double_click() {
	        buttonsPage.doubleClick();
	    }
	 	
	 	@When("user performs right click")
	    public void user_performs_right_click() {
	        buttonsPage.rightClick();
	    }

	    @When("user performs dynamic click")
	    public void user_performs_dynamic_click() {
	        buttonsPage.dynamicClick();
	    }
	    @Then("message should be {string}")
	    public void message_should_be(String expectedMessage) {

	        String actualMessage;

	        if (expectedMessage.contains("double")) {
	            actualMessage = buttonsPage.getMessage("double");
	        } else if (expectedMessage.contains("right")) {
	            actualMessage = buttonsPage.getMessage("right");
	        } else {
	            actualMessage = buttonsPage.getMessage("dynamic");
	        }

	        Assert.assertEquals(
	                actualMessage,
	                expectedMessage,
	                "Button action message mismatch"
	        );
	    }
}
