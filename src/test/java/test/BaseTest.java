package test;

import DriverManager.DriverManager;
import automation.Navigate;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseTest  {
    protected  WebDriver driver;
    protected LoginPage loginPage;
    protected SoftAssert softAssert;
    protected Navigate navigate;
    private static List<DriverManager> webdriverThreadPool = Collections.synchronizedList(new ArrayList<DriverManager>());
    private static ThreadLocal<DriverManager> driverThread;

    @BeforeSuite(alwaysRun = true)
    public static void initWebDriverObject(){
        driverThread = ThreadLocal.withInitial(() ->{
            DriverManager webDriverThread = new DriverManager();
            webdriverThreadPool.add(webDriverThread);
            return webDriverThread;
        });
    }
    public static WebDriver getDriver(String browserName){
        return driverThread.get().getDriver(browserName);
    }
    @BeforeClass(alwaysRun = true)
    @Parameters({ "browser" })
    public void beforeClass(String browserName) {
        driver = getDriver(browserName);
        navigate = new Navigate(driver);
        loginPage = new LoginPage(driver);

    }
    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        softAssert = new SoftAssert();
    }
    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        for(DriverManager driver : webdriverThreadPool){
            driver.quitDriver();
        }
    }
}
