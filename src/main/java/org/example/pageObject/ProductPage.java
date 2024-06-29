package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage extends BasePage {
    @FindBy(css = ".m-2.blink_me")
    WebElement cartPageMsg;
    @FindBy(css = ".mb-3")
    List<WebElement> products;
    @FindBy(css = ".toast-message.ng-star-inserted[aria-label='Product Added To Cart']")
    WebElement toastAddToCart;
    By addToCartBtn = By.cssSelector(".btn.w-10.rounded");

    @FindBy(css = ".btn.btn-custom[routerlink='/dashboard/cart']")
    WebElement cartBtn;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String cartPageMsg() {
        return cartPageMsg.getText();
    }

    public List<WebElement> getProductList() {
        return products;
    }

    public WebElement getProductByName(String productName) {
        WebElement prod = getProductList().stream().filter(p ->
                p.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        return prod;
    }

    public String addProductToCart(String productName) {
        WebElement prod = getProductByName(productName);
        prod.findElement(addToCartBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(toastAddToCart));
        return toastAddToCart.getText();
    }

    public CartPage goToCartPage() {
        click(cartBtn);
        return  new CartPage(driver);
    }




}
