package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "userPassword")
    WebElement userPassword;
    @FindBy(id = "login")
    WebElement login;
    @FindBy(css = "[class*='flyInOut']")
    WebElement errorMsg;
    @FindBy(css = ".invalid-feedback")
    WebElement passErrorMsg;
    @FindBy(css = ".toast-title.ng-star-inserted[aria-label='Login Successfully']")
    WebElement toastLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setUserEmail(String email){
        fillText(userEmail, email);
    }

    public void setUserPassword(String pass){
        fillText(userPassword, pass);
    }

    public void clickLogin(){
        click(login);
    }

    public String getErrorMsg()  {
        return errorMsg.getText();
    }

    public String emptyPassError() {
        return passErrorMsg.getText();
    }

    public String login() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(toastLogin));
        return toastLogin.getText();

    }

}
