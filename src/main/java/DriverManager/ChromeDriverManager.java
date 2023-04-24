package DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager {
    protected WebDriver createDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(getChromeOptions());
    }
    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new  ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-features=EnableEphemeralFlashPermission");
        options.addArguments("--disable-infobars");
//        options.addArguments("--headless");

        return options;
    }
}
