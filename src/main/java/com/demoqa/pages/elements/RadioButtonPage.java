package com.demoqa.pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.demoqa.pages.BasePage;

public class RadioButtonPage extends BasePage{
	
	@FindBy(xpath = "//label[@for='yesRadio']")
    private WebElement yesRadioButton;

    @FindBy(xpath = "//label[@for='impressiveRadio']")
    private WebElement impressiveRadio;
    
    @FindBy(className = "text-success")
    private WebElement resultText;

	public RadioButtonPage(WebDriver driver) {
		super(driver);
	}
	
	
	public void selectYesRadioButton() {
        click(yesRadioButton);
    }
	
	public void selectRadioOption(String option)
	{
		switch(option.toLowerCase()) {
		
		case "yes":jsClick(yesRadioButton);
		break;
		
		case "impressive":jsClick(impressiveRadio);
		break;
		
		default:throw new IllegalArgumentException("Invalid radio option: "+ option);
			
		}
	}

    public String getSelectedRadioText() {
        return getText(resultText);
    }

}
