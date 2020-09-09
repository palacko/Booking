package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ComtradeRegisteredPage {
    WebDriver driver;

    public ComtradeRegisteredPage(WebDriver driver){
        this.driver = driver;
    }

    private By alertMessage = By.cssSelector(".alert.alert-success");

    public void checkAlertMessage(String message){
        Assert.assertEquals(message,driver.findElement(alertMessage).getText());
    }

}