package org.example.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillText(WebElement el, String text){
        el.clear();
        waiting(1000);
        highlightElement(el, "yellow");
        el.sendKeys(text);
    }

    public void click(WebElement el) {
        highlightElement(el, "yellow");
        el.click();
        waiting(1000);
    }

    public String getText(WebElement el) {
        return el.getText();
    }


    private void highlightElement(WebElement element, String color) {
        //keep the old style to change it back
        String originalStyle = element.getAttribute("style");
        String newStyle = "border: 1px solid " + color + ";" + originalStyle;
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Change the style
        js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
                        + newStyle + ";background-color:yellow');},0);",
                element);

        // Change the style back after few milliseconds
        js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
                + originalStyle + "');},400);", element);

    }

    public void waiting(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
