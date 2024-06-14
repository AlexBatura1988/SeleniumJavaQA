package org.example.baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.ResourceBundle;

public class BaseTest {

    public static WebDriver driver;
    public ResourceBundle rb;

    @BeforeMethod
    @Parameters("browser")
    public void setup(ITestContext testContext, String br) {
        rb = ResourceBundle.getBundle("config");

        if (br.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
        } else if (br.equals("edge")) {
            driver = new EdgeDriver();
        } else {
            driver = new FirefoxDriver();
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        //By calling the "setAttribute" method, the attribute "WebDriver" is set in the "testContext" object.
        testContext.setAttribute("WebDriver", driver);
        driver.get(rb.getString("appURL"));

    }
}
