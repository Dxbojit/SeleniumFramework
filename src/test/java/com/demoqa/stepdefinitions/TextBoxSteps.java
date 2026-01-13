package com.demoqa.stepdefinitions;

import org.testng.Assert;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.elements.TextBoxPage;
import com.demoqa.utils.ConfigReader;
import com.demoqa.utils.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TextBoxSteps {
	HomePage homePage;
	TextBoxPage textboxPage;
	
	@Given ("user is on Text Box Page")
	public void user_is_on_Text_Box_Page() {
		homePage = new HomePage(DriverFactory.getDriver());
		homePage.clickElementsCard();
		
		DriverFactory.getDriver().get(ConfigReader.get("textBoxUrl"));
	}
	
	@When("user enters dummy data in text box")
	public void user_enters_dummy_data_in_text_box() {
		textboxPage = new TextBoxPage(DriverFactory.getDriver());
		textboxPage.fillTextBoxForm("Test User","testUser@test.com", "Bangalore", "Kolkata");
	}
	
	@And("user submits the text box form")
	public void user_submits_text_box_form() {
		textboxPage.submitForm();
	}
	
	@Then("submitted data should be displayed")
	public void submitted_data_should_display() {
		Assert.assertTrue(textboxPage.isOutputDisplayed(),"Expected submitted data to be displayed");
	}
}
