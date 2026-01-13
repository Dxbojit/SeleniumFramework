package com.demoqa.stepdefinitions;

import org.testng.Assert;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.elements.CheckBoxPage;
import com.demoqa.utils.ConfigReader;
import com.demoqa.utils.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CheckBoxSteps {
	HomePage homePage;
	CheckBoxPage checkBoxPage;
	
	@Given("user is on Check Box Page")
	public void user_is_on_Checkbox_page() {
		
		homePage = new HomePage(DriverFactory.getDriver());
		homePage.clickElementsCard();
		
		DriverFactory.getDriver().get(ConfigReader.get("checkboxUrl"));
		
		checkBoxPage = new CheckBoxPage(DriverFactory.getDriver());
	}
	
	
	@And("clicks on Desktop checkbox")
	public void clicks_on_desktop_checkbox() {
		checkBoxPage.selectHomeCheckbox();
	}
	
	@Then("data displayed should be {string}")
	public void data_displayed_should_be(String expectedText)
	{
		String actualText = checkBoxPage.getSelectionResult();
		Assert.assertTrue(actualText.contains(expectedText),"Expected text not found in result");
	}
}
