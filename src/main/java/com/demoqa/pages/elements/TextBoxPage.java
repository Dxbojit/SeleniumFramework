package com.demoqa.pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.demoqa.pages.BasePage;

public class TextBoxPage extends BasePage{
    @FindBy(id = "userName")
    private WebElement fullNameInput;

    @FindBy(id = "userEmail")
    private WebElement emailInput;

    @FindBy(id = "currentAddress")
    private WebElement currentAddressInput;

    @FindBy(id = "permanentAddress")
    private WebElement permanentAddressInput;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(id = "output")
    private WebElement outputSection;

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public void fillTextBoxForm(String name, String email, String currentAddr, String permanentAddr) {
        type(fullNameInput, name);
        type(emailInput, email);
        type(currentAddressInput, currentAddr);
        type(permanentAddressInput, permanentAddr);
    }

    public void submitForm() {
        jsClick(submitButton);
    }

    public boolean isOutputDisplayed() {
        return outputSection.isDisplayed();
    }
}
