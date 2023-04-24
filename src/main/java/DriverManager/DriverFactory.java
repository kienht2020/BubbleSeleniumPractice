package DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    public  WebDriver getBrowser(String browserName) {
        WebDriver driver = null;
        switch (browserName) {
            case "Firefox":
                driver = new FirefoxDriverManager().createDriver();
                break;
            case "IE":
                driver = new EdgeDriverManager().createDriver();
                break;
            case "Chrome":
                driver = new ChromeDriverManager().createDriver();
                break;
            case "Safari":
                driver = new SafariDriverManager().createDriver();
                break;
        }
        return driver;
    }
}
