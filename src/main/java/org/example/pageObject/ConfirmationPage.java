package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends BasePage {
    @FindBy(css = ".hero-primary")
    WebElement confirmationMsg;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public String getConfMsg() {
        return confirmationMsg.getText();
    }
}
