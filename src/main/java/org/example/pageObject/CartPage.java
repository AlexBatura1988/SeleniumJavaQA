package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    @FindBy(css = ".m-2.blink_me")
    WebElement cartPageMsg;

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public String   cartPageMsg() {
       return cartPageMsg.getText();
    }
}
