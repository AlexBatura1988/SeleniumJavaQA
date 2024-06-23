package org.example.testCases;

import org.example.baseTest.BaseTest;
import org.example.pageObject.ProductPage;
import org.example.pageObject.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class ProductPageTest extends BaseTest {

    String cartPageMsg = "User can only see maximum 9 products on a page";
    int products = 3;
    String product1 = "ZARA COAT 3";
    String product2 = "ADIDAS ORIGINAL";
    String product3 = "IPHONE 13 PRO";
    String toastAddToCartMsg = "Product Added To Cart";

    @BeforeClass
    public void login() {
        LoginPage lp = new LoginPage(driver);
        lp.setUserEmail(rb.getString("email"));
        lp.setUserPassword(rb.getString("password"));
        lp.clickLogin();
        lp.login();
    }

    @Test(priority = 1)
    public void verifyProductPage() {
        ProductPage productPage = new ProductPage(driver);
        Assert.assertEquals(productPage.cartPageMsg(), cartPageMsg);
    }

    @Test(priority = 2)
    public void sumAllProducts() {
        ProductPage productPage = new ProductPage(driver);
        Assert.assertEquals(productPage.getProductList().size(), products);
    }

    @Test(priority = 3)
    public void verifyCartProductName() {
        ProductPage productPage = new ProductPage(driver);
        WebElement prod = productPage.getProductByName(product1);
        Assert.assertEquals(prod.findElement(By.cssSelector("b")).getText(), product1);
    }

    @Test(priority = 4)
    public void addToCart() {
        ProductPage productPage = new ProductPage(driver);
        Assert.assertEquals(productPage.addProductToCart(product3), toastAddToCartMsg);

    }








}
