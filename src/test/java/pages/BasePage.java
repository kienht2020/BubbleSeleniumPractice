package pages;

import automation.Automation;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class BasePage {
    protected WebDriver driver;
    protected Automation automation;
    protected SoftAssert softAssert;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        automation = new Automation(driver);
        softAssert = new SoftAssert();
    }
    public void getAllAssert(){
        softAssert.assertAll();
    }
    public void refreshPage(){
        automation.refreshPage();
    }

}
