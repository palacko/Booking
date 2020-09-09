package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SauceDemoLoginPage {
    WebDriver driver;

    public SauceDemoLoginPage(WebDriver driver){
        this.driver = driver;
    }

    private By userName = By.id("user-name");
    private By password = By.id("password");
    private By login = By.id("login-button");

    public void enterText(String text, By toElement){
        driver.findElement(toElement).sendKeys(text);
    }

    public void clickElement(By clickElement){
        driver.findElement(clickElement).click();
    }

    public void loginToSauceDemo(String username,String passwordText){
        enterText(username,userName);
        enterText(passwordText,password);
        clickElement(login);
    }
}