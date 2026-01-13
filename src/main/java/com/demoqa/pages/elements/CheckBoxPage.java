package com.demoqa.pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.demoqa.pages.BasePage;

public class CheckBoxPage extends BasePage{
	
	@FindBy(xpath = "//span[@class='rct-checkbox']")
    private WebElement homeCheckBox;

    @FindBy(id = "result")
    private WebElement resultText;

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    public void selectHomeCheckbox() {
        jsClick(homeCheckBox);
    }

    public String getSelectionResult() {
        return getText(resultText);
    }

}
