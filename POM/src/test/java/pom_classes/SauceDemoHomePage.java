package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SauceDemoHomePage {
    WebDriver driver;

    public SauceDemoHomePage(WebDriver driver){
        this.driver = driver;
    }

    private By robotImg = By.cssSelector(".peek");

    public void checkIsLogoDisplayed(){
        Assert.assertTrue(driver.findElement(robotImg).isDisplayed());
    }
}