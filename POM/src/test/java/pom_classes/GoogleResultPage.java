package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GoogleResultPage {

    WebDriver driver;
    String result;

    public GoogleResultPage(WebDriver driver){
        this.driver = driver;
    }

    private By searchResultContainer = By.cssSelector("#search");

    public String getSearchResults(){
        result = driver.findElement(searchResultContainer).getText();
        return result;
    }

    public void checkResults(String searchItem){
        getSearchResults();
        Assert.assertTrue(result.contains(searchItem));
    }

}