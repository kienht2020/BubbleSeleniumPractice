package test;

import DriverManager.DriverManager;
import automation.Automation;
import data.URLs;
import data.UserAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pages.LoginPage;

public class TestBase extends DriverBase {
    protected  WebDriver driver;
    protected LoginPage loginPage;
    protected Automation automation;
    @BeforeClass(alwaysRun = true)
    @Parameters({ "browser" })
    public void beforeClass(String browserName) {
        driver = getDriver(browserName);
        loginPage = new LoginPage(driver);
        automation = new Automation(driver);
        automation.navigate(URLs.BASE_URL);
        // check if the form is display
        loginPage.checkLoginFormDisplayed();
        // login
        loginPage.loginFunction(UserAccount.USER_NAME, UserAccount.PASSWORD);

    }
}
