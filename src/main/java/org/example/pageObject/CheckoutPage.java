package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(css = "[placeholder='Select Country']")
    WebElement country;
    @FindBy(css = ".action__submit")
    WebElement submitBtn;
    @FindBy(css = ".list-group-item>span")
    WebElement spanCountry;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void selectCountry(String countryName) {
        fillText(country, countryName);
        click(spanCountry);
    }

    public ConfirmationPage submitOrder() {
        click(submitBtn);
        return new ConfirmationPage(driver);
    }
}
