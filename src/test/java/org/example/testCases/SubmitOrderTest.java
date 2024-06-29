package org.example.testCases;

import org.example.baseTest.BaseTest;
import org.example.pageObject.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class SubmitOrderTest extends BaseTest {

    String confirmationPagMsg = "THANKYOU FOR THE ORDER.";

    @BeforeClass
    public void login() {
        LoginPage lp = new LoginPage(driver);
        lp.setUserEmail(rb.getString("email"));
        lp.setUserPassword(rb.getString("password"));
        lp.clickLogin();
        lp.login();
    }
    @Test
    public void submitOrderTest() throws InterruptedException {
        String productName = "ADIDAS ORIGINAL";
        ProductPage productPage = new ProductPage(driver);

        List<WebElement> products = productPage.getProductList();
        productPage.addProductToCart(productName);
        CartPage cartPage = productPage.goToCartPage();

        Boolean match = cartPage.verifyProductDisplay(productName);
        Assert.assertTrue(match);
        Thread.sleep(1000);
        CheckoutPage checkoutPage = cartPage.goToCheckoutPage();
        checkoutPage.selectCountry("Russian Federation");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        Assert.assertEquals(confirmationPage.getConfMsg(), confirmationPagMsg);

    }


}
