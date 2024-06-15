package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

}
