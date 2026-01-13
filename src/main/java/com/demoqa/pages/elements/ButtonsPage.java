package com.demoqa.pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.demoqa.pages.BasePage;

public class ButtonsPage extends BasePage{
	 @FindBy(id = "doubleClickBtn")
	 private WebElement doubleClickButton;

	 @FindBy(id = "rightClickBtn")
	 private WebElement rightClickButton;

	 @FindBy(xpath = "//button[text()='Click Me']")
	 private WebElement dynamicClickButton;

	 @FindBy(id = "doubleClickMessage")
	 private WebElement doubleClickMessage;

	 @FindBy(id = "rightClickMessage")
	 private WebElement rightClickMessage;

	 @FindBy(id = "dynamicClickMessage")
	 private WebElement dynamicClickMessage;

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }
    
    public void doubleClick() {
    	scrollIntoViewAndCenter(doubleClickButton);
    	new Actions(driver)
        .moveToElement(doubleClickButton)
        .doubleClick()
        .perform();
    }

    public void rightClick() {
    	scrollIntoViewAndCenter(rightClickButton);
    	new Actions(driver)
        .moveToElement(rightClickButton)
        .contextClick()
        .perform();
    }
    
    public void dynamicClick() {
        jsClick(dynamicClickButton);
    }
    
    public String getMessage(String type) {

        switch (type.toLowerCase()) {
            case "double":
                return getText(doubleClickMessage);
            case "right":
                return getText(rightClickMessage);
            case "dynamic":
                return getText(dynamicClickMessage);
            default:
                throw new IllegalArgumentException(
                        "Invalid click type: " + type
                );
        }
    }
}
