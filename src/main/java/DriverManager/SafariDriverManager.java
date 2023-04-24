package DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariDriverManager extends DriverManager {
    protected WebDriver createDriver(){
        return new SafariDriver();
    }
}
