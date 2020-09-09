package selenium_core;

import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManagerFactory {

    public static DriverManager getDriverManager(DriverType type){
        DriverManager driverManager;

        switch (type){
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FireFoxDriverManager();
                break;
            case IE:
                driverManager = new IEDriverManager();
                break;
            case EDGE:
                driverManager = new EDGEDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
        } return driverManager;
    }
}
