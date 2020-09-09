package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom_classes.ComtradeRegisterPage;
import pom_classes.ComtradeRegisteredPage;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;
import selenium_core.DriverType;

import java.util.concurrent.TimeUnit;

public class ComtradeRegisterTests {

    String URL = "https://www.ctshop.rs/customer/account/create";
    String message = "Hvala na registraciji. Molimo proverite email i aktivirajte Vaš nalog.";

    WebDriver driver;
    DriverManager driverManager;
    ComtradeRegisterPage registerPage;
    ComtradeRegisteredPage registeredPage;


    @BeforeMethod
    public void setup(){
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void verifyGoogleSearchResult(){
        registerPage = new ComtradeRegisterPage(driver);
        registerPage.registerUser("Aleksandar","Stojanovic","email121@email.com","pass123!");
        registeredPage = new ComtradeRegisteredPage(driver);
        registeredPage.checkAlertMessage(message);
    }

    @AfterMethod
    public void tearDown(){
        driverManager.quitWebDriver();
    }

}