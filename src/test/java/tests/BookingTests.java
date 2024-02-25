package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom_classes.BookingHomePage;
import selenium_core.DriverManager;

public class BookingTests extends BaseTest {

    @BeforeMethod
    public void setup() {
        baseSetUp("CHROME", "", 5);
    }

    @Test
    public void booking() {
        BookingHomePage bookingHomePage = new BookingHomePage(driver);
        String[] ages = {"3 years old","9 years old"};

        bookingHomePage.setWhereAreYouGoing("Kopaonik");
        bookingHomePage.checkiInCheckOut("February", "25", "April", "13");
        bookingHomePage.addGuests(2,2, ages, 1);
        bookingHomePage.search();


    }

    @AfterMethod
    public void tearDown() {
        baseTearDown();
    }

}