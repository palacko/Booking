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

    @FindBy(id = "searchbox-dates-container")
    WebElement checkiInCheckOut;

    @FindBy(css = ".e1eebb6a1e.ee7ec6b631")
    List<WebElement> months;

    @FindBy(css = "[aria-label='Next month']")
    WebElement nextMonth;

    @FindBy(css = "button[type = submit]")
    WebElement search;

    public void clickDate(String monthYear, String day) {
        while (true) {
            if (driver.findElements(By.xpath("//div[@class='d358556c65']/h3[contains(text(),'" +monthYear+ "')]")).size() == 0) {
                clickElement(nextMonth, "Clicked: Next month");
            } else {
                clickElement(driver.findElement(By.xpath("//div[@class='d358556c65']/h3[contains(text(),'" +monthYear+ "')]/..//span[text()='" +day+ "']")), "Clicked:" + monthYear + " " + day);
                break;
            }
        }
    }


}