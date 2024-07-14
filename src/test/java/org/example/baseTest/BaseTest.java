package org.example.baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.ResourceBundle;

public class BaseTest {

    public static WebDriver driver;
    public ResourceBundle rb;

    @BeforeClass
    @Parameters("browser")
    public void setup(ITestContext testContext, String br) {
        rb = ResourceBundle.getBundle("config");
    }

    @BeforeMethod
    @Parameters("browser")
    public void setupDriver(ITestContext testContext, String br) {


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

//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

//    @AfterMethod
//    public void cleanUp() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

}
