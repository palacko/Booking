package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ComtradeRegisterPage {

    WebDriver driver;

    public ComtradeRegisterPage(WebDriver driver){
        this.driver = driver;
    }

    private By firstName = By.id("firstname");
    private By lastName = By.id("lastname");
    private By emailAddress = By.id("email_address");
    private By isSubscribed = By.id("is_subscribed");
    private By password = By.id("password");
    private By confirmation = By.id("confirmation");
    private By rememberMe = By.name("rememberme");
    private By sendButton = By.cssSelector(".button.btn.btn-primary.btn-continue.pull-right.btn-lg");
    private By selectPravnoLice = By.id("pravnolice");


    public void enterText(String text, By toElement){
        driver.findElement(toElement).sendKeys(text);
    }

    public void clickElement(By clickElement){
        driver.findElement(clickElement).click();
    }

    public void selectElementByValue(By selectElement, String value){
        Select select = new Select(driver.findElement(selectElement));
        select.selectByValue(value);
    }

    public void registerUser(String firstNameText, String lastNameText, String emailAddressText, String passwordText){
        enterText(firstNameText, firstName);
        enterText(lastNameText, lastName);
        enterText(emailAddressText, emailAddress);
        enterText(passwordText, password);
        enterText(passwordText, confirmation);
        clickElement(isSubscribed);
        clickElement(rememberMe);
        selectElementByValue(selectPravnoLice,"0");
        clickElement(sendButton);
    }

    //TODO write a method that registers legal entity (registerLegalEntity and add 2 more elements - PIB, Company)
}