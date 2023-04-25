package pages;

import automation.Automation;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    protected Automation automation;
    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        automation = new Automation(driver);
    }

}
