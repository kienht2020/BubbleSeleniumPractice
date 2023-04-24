package pages;

import automation.Automation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
    protected WebDriver driver;
    protected Automation automation;
    public PageBase(WebDriver driver)
    {
        this.driver = driver;
        automation = new Automation(driver);
    }

}
