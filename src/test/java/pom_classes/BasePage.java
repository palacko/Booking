package pom_classes;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    int waitTime = 30;


    public void clickElement(WebElement element, String log) {
        try {
            WebDriverWait wdWait = new WebDriverWait(driver, waitTime);
            wdWait.until(ExpectedConditions.visibilityOf(element));
            wdWait.until(ExpectedConditions.elementToBeClickable(element));

            Actions actions = new Actions(driver);
            actions.moveToElement(element).click().build().perform();
            System.out.println("Clicked: " + log);
        } catch (StaleElementReferenceException e) {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).click().build().perform();
            System.out.println("Clicked: " + log);
        }
    }

    public void typeText(WebElement element, String text, String log) {
        try {
            WebDriverWait wdWait = new WebDriverWait(driver, waitTime);
            wdWait.until(ExpectedConditions.visibilityOf(element));

            element.clear();
            element.sendKeys(text);

            System.out.println("Typed text " + text + " into " + log);
        } catch (StaleElementReferenceException e) {
            element.clear();
            element.sendKeys();
            System.out.println("Typed text " + text + " into " + log);
        }
    }

    public String getText(WebElement element, String log) {
        try {
            WebDriverWait wdWait = new WebDriverWait(driver, waitTime);
            wdWait.until(ExpectedConditions.visibilityOf(element));

            System.out.println("Get text from " + log);
            return element.getText();

        } catch (StaleElementReferenceException e) {
            System.out.println("Get text from " + log);
            return element.getText();
        }
    }

    public boolean isElementPresent(List<WebElement> elements){
        return elements.size()>0;
    }

    public void selectByText(WebElement element, String text, String log) {
        try {
            WebDriverWait wdWait = new WebDriverWait(driver, waitTime);
            wdWait.until(ExpectedConditions.visibilityOf(element));
            wdWait.until(ExpectedConditions.elementToBeClickable(element));

            Select select = new Select(element);
            select.selectByVisibleText(text);
            System.out.println("Selected " +text+" "+log);
        } catch (StaleElementReferenceException e) {
            Select select = new Select(element);
            select.selectByVisibleText(text);
            System.out.println("Selected " +text+" "+log);
        }
    }

}

