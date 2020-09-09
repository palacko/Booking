package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom_classes.SauceDemoHomePage;
import pom_classes.SauceDemoLoginPage;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;
import selenium_core.DriverType;

import java.util.concurrent.TimeUnit;

public class SauceDemoTests {

    String URL = "https://www.saucedemo.com/";

    WebDriver driver;
    DriverManager driverManager;
    SauceDemoHomePage home;
    SauceDemoLoginPage login;

    @BeforeMethod
    public void setup(){
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void verifyGoogleSearchResult(){
        login = new SauceDemoLoginPage(driver);
        home = new SauceDemoHomePage(driver);
        login.loginToSauceDemo("standard_user","secret_sauce");
        home.checkIsLogoDisplayed();
    }

    @AfterMethod
    public void tearDown(){
        driverManager.quitWebDriver();
    }

}