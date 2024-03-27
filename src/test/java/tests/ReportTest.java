package tests;

import com.beust.jcommander.Parameter;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pom_classes.BasePage;

import java.io.IOException;

public class ReportTest extends BaseTest {
    String TEST_DATA = "src/test_data/Booking.xlsx";

    @BeforeMethod
    @Parameters({"SHEET"})
    public void setup(String SHEET) throws IOException {
        baseSetUp("CHROME", "", 10);
    }

    @AfterMethod
    public void tearDown() throws IOException {
        new BasePage(driver).reportScreenshot("TestScreenshot_" + System.currentTimeMillis(), "Test Screenshot");
        baseTearDown();
    }


    @Test(description = "Test case name")
    @Description("Some description of the test case")
    @Epic("EP001")
    @Feature("FE001")
    @Story("US001")
    @Link("Test")
    @TmsLink("TC001")
    @Issue("DE001")
    public void test1() {

                Assert.assertTrue(true);
    }


}
