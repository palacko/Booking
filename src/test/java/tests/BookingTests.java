package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium_core.DriverManager;

public class BookingTests extends BaseTest {

    WebDriver driver;
    DriverManager driverManager;


    @BeforeMethod
    public void setup() {
        baseSetUp("CHROME", "", 10);
    }

    @Test
    public void booking() {

    }

    @AfterMethod
    public void tearDown() {
        baseTearDown();
    }

}