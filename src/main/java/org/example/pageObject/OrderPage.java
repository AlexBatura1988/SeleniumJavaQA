package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OrderPage extends BasePage {

    @FindBy(css = "tr td:nth-child(3)")
    private List<WebElement> productNames;

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public boolean VerifyOrderDisplay(String prodName) {
        boolean match = productNames.stream().anyMatch(pr ->
                pr.getText().equalsIgnoreCase(prodName));
        return match;
    }
}
