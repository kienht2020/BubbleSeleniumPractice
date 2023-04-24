package DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private WebDriver webDriver;
    //singleton Design pattern
    public WebDriver getDriver(){
        if(webDriver == null){
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        }
        return webDriver;
    }
    public WebDriver getDriver(String browserName){
        if(webDriver == null){
            webDriver = new DriverFactory().getBrowser(browserName);
        }
        return webDriver;
    }
    public void quitDriver(){
        if (webDriver != null){
            webDriver.quit();
            webDriver = null;
        }
    }
}
