package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {
    WebDriver driver;

    public GoogleSearchPage(WebDriver driver){
        this.driver = driver;
    }

    private By googleSearchBox = By.name("q");
    private By googleSearchButton = By.name("btnK");

    public void setSearchFor(String searchFor){
        driver.findElement(googleSearchBox).sendKeys(searchFor);
    }

    public void performSearch(){
        driver.findElement(googleSearchButton).click();
    }

    public void SearchGoogle(String searchFor){
        this.setSearchFor(searchFor);
        this.performSearch();
    }

}