package tests;

import excel_core.GetExcelData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pom_classes.BookingHomePage;
import selenium_core.DriverManager;

import java.io.IOException;
import java.util.Map;

public class BookingTests extends BaseTest {

    @BeforeMethod
    public void setup() {
        baseSetUp("CHROME", "", 10);
    }

    @Test
    @Parameters({"row"})
    public void booking(String row) throws IOException {
        Map<String, String> data = new GetExcelData().getRowData("src/test_data/Booking.xlsx","BookingSheet",Integer.parseInt(row));
        String [] ages = data.get("ChildAges").split(",");

        BookingHomePage bookingHomePage = new BookingHomePage(driver);

        bookingHomePage.setWhereAreYouGoing(data.get("Location"));
        bookingHomePage.checkiInCheckOut(data.get("CheckInMonthYear"), data.get("CheckInDay"), data.get("CheckOutMonthYear"), data.get("CheckOutDay"));
        bookingHomePage.addGuests(Integer.parseInt(data.get("AdultsNum")),Integer.parseInt(data.get("ChildrenNum")), ages, Integer.parseInt(data.get("RoomsNum")));
        bookingHomePage.search();
    }

    @AfterMethod
    public void tearDown() {
        baseTearDown();
    }

}