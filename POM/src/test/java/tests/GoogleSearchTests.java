package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom_classes.GoogleResultPage;
import pom_classes.GoogleSearchPage;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;
import selenium_core.DriverType;

import java.util.concurrent.TimeUnit;

public class GoogleSearchTests {

    String URL = "http://www.google.com";
    String searchFor = "QAitive";
    String searchResult = "www.qaserbia.rs";

    WebDriver driver;
    DriverManager driverManager;
    GoogleSearchPage gsp;
    GoogleResultPage grp;


    @BeforeMethod
    public void setup(){
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void verifyGoogleSearchResult(){
        gsp = new GoogleSearchPage(driver);
        gsp.SearchGoogle(searchFor);

        grp = new GoogleResultPage(driver);
        grp.checkResults(searchResult);
    }

    @AfterMethod
    public void tearDown(){
        driverManager.quitWebDriver();
    }

}