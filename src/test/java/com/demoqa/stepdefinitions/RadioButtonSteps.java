package com.demoqa.stepdefinitions;

import org.testng.Assert;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.elements.RadioButtonPage;
import com.demoqa.utils.ConfigReader;
import com.demoqa.utils.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RadioButtonSteps {
	RadioButtonPage radioButtonPage;
	HomePage homePage ;
	
	@Given("user is on radio button page")
	public void user_is_on_radio_button_page() {
		
		homePage = new HomePage(DriverFactory.getDriver());
		homePage.clickElementsCard();
		
		DriverFactory.getDriver().get(ConfigReader.get("radioButtonUrl"));
		
		radioButtonPage = new RadioButtonPage(DriverFactory.getDriver());
	}
	
	@When("user selects {string} radio button")
	public void user_selects_Radio_button(String option) {
		radioButtonPage.selectRadioOption(option);
	}
	
	@Then("selected message should be {string}")
	public void selected_message_should_be(String expected) {
		String actual = radioButtonPage.getSelectedRadioText();
		Assert.assertEquals(actual, expected,"Radio button selection result mismatch");
	}
}
