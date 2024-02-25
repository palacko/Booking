package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookingHomePage extends BasePage {

    WebDriver driver;

    public BookingHomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = ":re:")
    WebElement whereAreYouGoing;
    @FindBy(xpath = "//div[@class='a1139161bf']")
    WebElement checkiInCheckOut;
    @FindBy(css = ".e1eebb6a1e.ee7ec6b631")
    List<WebElement> months;
    @FindBy(css = "[aria-label='Next month']")
    WebElement nextMonth;
    @FindBy(css = "button[type = submit]")
    WebElement search;
    @FindBy(xpath = "//div[@class='d777d2b248']")
    WebElement guests;
    @FindBy(xpath = "//label[text()='Adults']/../..//button[2]")
    WebElement adultsAdd;
    @FindBy(xpath = "//label[text()='Adults']/../..//button[1]")
    WebElement adultsSub;
    @FindBy(xpath = "//label[text()='Children']/../..//button[2]")
    WebElement childrenAdd;
    @FindBy(xpath = "//label[text()='Children']/../..//button[1]")
    WebElement childrenSub;
    @FindBy(xpath = "//label[text()='Rooms']/../..//button[2]")
    WebElement roomsAdd;
    @FindBy(xpath = "//label[text()='Rooms']/../..//button[1]")
    WebElement roomsSub;
    @FindBy(css = "[name='age']")
    List<WebElement> childrenAge;


    public void setWhereAreYouGoing(String location) {
        typeText(whereAreYouGoing, location, "Typed: " + location);
        clickElement(driver.findElement(By.xpath(" //li//div[text()='" + location + "']")), "Clicked: " + location);
    }

    public void clickDate(String monthYear, String day) {
        while (true) {
            if (driver.findElements(By.xpath("//div[@class='d358556c65']/h3[contains(text(),'" + monthYear + "')]")).size() == 0) {
                clickElement(nextMonth, "Clicked: Next month");
            } else {
                clickElement(driver.findElement(By.xpath("//div[@class='d358556c65']/h3[contains(text(),'" + monthYear + "')]/..//span[text()='" + day + "']")), "Clicked: " + monthYear + " " + day);
                break;
            }
        }
    }

    public void checkiInCheckOut(String checkInMonthYear, String checkInDate, String checkOutMonthYear, String checkOutDate) {
        clickElement(checkiInCheckOut, "Clicked: Check in / Check out");
        clickDate(checkInMonthYear, checkInDate);
        clickDate(checkOutMonthYear, checkOutDate);
    }

    /**
     *
     * @param adultNum Add additional adults
     * @param childrenNum Add children num
     * @param childrenAge Add children age
     * @param roomsNum Add additional rooms
     */
    public void addGuests(int adultNum, int childrenNum, String[] childrenAge, int roomsNum) {
        clickElement(guests, "Clicked: Guests");
        addAdultsNum(adultNum);
        addChildrenNum(childrenNum, childrenAge);
        addRoomsNum(roomsNum);
    }

    public void addAdultsNum(int num) {
        for (int i = 1; i < num; i++) {
            clickElement(adultsAdd, "Clicked: Add adults");
        }
    }

    public void addRoomsNum(int num) {
        for (int i = 1; i < num; i++) {
            clickElement(roomsAdd, "Clicked: Add rooms");
        }
    }

    public void addChildrenNum(int num, String[] year) {
        for (int i = 1; i <= num; i++) {
            clickElement(childrenAdd, "Clicked: Add children");
            selectByText(childrenAge.get(i - 1), year[i - 1], "from child age select");
        }
    }

    public void search() {
        clickElement(search, "Clicked: Search");
    }
}