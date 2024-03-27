package selenium_core;

public class DriverManagerFactory{

    public static DriverManager getDriverManager(String type){
        DriverManager driverManager;

        switch(type){
            case "FIREFOX":{
                driverManager = new FirefoxDriverManager();
            }
            break;
            default:{
                driverManager = new ChromeDriverManager();
            }
        }
        return driverManager;
    }
}
