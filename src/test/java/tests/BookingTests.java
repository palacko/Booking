package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pom_classes.BasePage;
import pom_classes.BookingHomePage;

import java.io.IOException;

public class BookingTests extends BaseTest {

    String TEST_DATA = "src/test_data/Booking.xlsx";

    @BeforeMethod
    @Parameters({"SHEET", "TC_ID"})
    public void setup(String SHEET, String TC_ID) throws IOException {
        baseSetUp("CHROME", "", 10);
        loadTestData(TEST_DATA, SHEET, TC_ID, "1");
        mergeTestData(TEST_DATA, "ChildData", "Children");
    }

    @AfterMethod
    public void tearDown() throws IOException {
        new BasePage(driver).reportScreenshot("TestScreenshot_" + System.currentTimeMillis(), "Test Screenshot");
        baseTearDown();
    }

    @Test
    public void booking() throws IOException {
//        mergeTestData("ChildData", "Children");

        BookingHomePage bookingHomePage = new BookingHomePage(driver);

        bookingHomePage.setWhereAreYouGoing(data.get("Location"));
        bookingHomePage.checkiInCheckOut(data);
        bookingHomePage.addGuests(data);
        bookingHomePage.search();
    }

}