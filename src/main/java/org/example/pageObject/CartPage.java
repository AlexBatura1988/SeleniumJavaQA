package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage{

    @FindBy(css = ".totalRow button")
    WebElement checkoutBtn;
    @FindBy(css = ".cartSection>h3")
    List<WebElement> productTitles;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyProductDisplay(String prodName) {
        Boolean match = productTitles.stream().anyMatch(pr ->
                pr.getText().equalsIgnoreCase(prodName));
        return match;
    }

    public CheckoutPage goToCheckoutPage() {
        click(checkoutBtn);
        return new CheckoutPage(driver);
    }
}
