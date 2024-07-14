package org.example.testCases;

import org.example.baseTest.BaseTest;
import org.example.pageObject.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class SubmitOrderTest extends BaseTest {

    String confirmationPagMsg = "THANKYOU FOR THE ORDER.";
    String productName = "ADIDAS ORIGINAL";
    String productName1 = "ZARA COAT 3";


    @Test(dataProvider = "getData")
    public void submitOrderTest(String email, String pass, String prName) throws InterruptedException {

        LoginPage lp = new LoginPage(driver);
        lp.setUserEmail(email);
        lp.setUserPassword(pass);
        lp.clickLogin();
        lp.login();

        ProductPage productPage = new ProductPage(driver);

        List<WebElement> products = productPage.getProductList();
        productPage.addProductToCart(prName);
        CartPage cartPage = productPage.goToCartPage();

        Boolean match = cartPage.verifyProductDisplay(prName);
        Assert.assertTrue(match);
        Thread.sleep(1000);
        CheckoutPage checkoutPage = cartPage.goToCheckoutPage();
        checkoutPage.selectCountry("Russian Federation");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        Assert.assertEquals(confirmationPage.getConfMsg(), confirmationPagMsg);

    }


    @DataProvider
    public Object[][] getData() {
        String email1 = rb.getString("email");
        String pass1 = rb.getString("password");
        String email2 = rb.getString("email_2");
        String pass2 = rb.getString("password_2");

        return new Object[][]{{email1, pass1, productName}, {email2, pass2, productName1}};
    }

}
