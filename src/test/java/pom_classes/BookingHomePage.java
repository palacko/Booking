package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class BookingHomePage extends BasePage {

    WebDriver driver;

    public BookingHomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = ":re:")
    WebElement whereAreYouGoing;
    @FindBy(xpath = "//div[@class='f73e6603bf']")
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
    @FindBy(xpath = "//*[@aria-label='Dismiss sign-in info.']")
    WebElement clickClose;

    public void setWhereAreYouGoing(String location) {
        clickClose();
        typeText(whereAreYouGoing, location, "" + location);
        clickElement(driver.findElement(By.xpath(" //li//div[text()='" + location + "']")), "" + location);
    }

    public void clickDate(String monthYear, String day) {
        while (true) {
            if (driver.findElements(By.xpath("//div[@class='d358556c65']/h3[contains(text(),'" + monthYear + "')]")).size() == 0) {
                clickElement(nextMonth, "Next month");
            } else {
                clickElement(driver.findElement(By.xpath("//div[@class='d358556c65']/h3[contains(text(),'" + monthYear + "')]/..//span[text()='" + day + "']")), "" + monthYear + " " + day);
                break;
            }
        }
    }

    public void checkiInCheckOut(Map<String, String> data) {
        clickDate(data.get("CheckInMonthYear"), data.get("CheckInDay"));
        clickDate(data.get("CheckOutMonthYear"), data.get("CheckOutDay"));
    }

    public void addGuests(Map<String, String> data) {
        clickElement(guests, "Guests");
        addAdultsNum(data.get("AdultsNum"));
        addChildrenNum(data);
        addRoomsNum(data.get("RoomsNum"));
    }

    public void addAdultsNum(String num) {
        if(num.equalsIgnoreCase("1")){
            clickElement(adultsSub, "Decrease adults number");
        }

        for (int i = 2; i < Integer.parseInt(num); i++) {
            clickElement(adultsAdd, "Add adults");
        }
    }

    public void addRoomsNum(String num) {
        clickElement(guests,"");
        for (int i = 1; i < Integer.parseInt(num); i++) {
            clickElement(roomsAdd, "Add rooms");
        }
    }

    public void addChildrenNum(Map<String, String> data) {
        if(hasValue(data.get("Children"))) {
            for (int i = 1; i <= data.get("Children").split(",").length; i++) {
                clickElement(childrenAdd, "Add children");
                selectByText(childrenAge.get(i - 1), data.get("Child_Age_" + i), "from child age select");
                clickElement(guests, "");
            }
        }
    }

    public void search() {
        clickElement(search, "Search");
    }

    public void clickClose(){
        clickElement(clickClose,"Closed Pop-Up");
    }
}