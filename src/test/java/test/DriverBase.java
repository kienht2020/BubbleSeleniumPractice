package test;

import DriverManager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverBase {
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

    public static WebDriver getDriver(){
        return driverThread.get().getDriver();
    }
    public static WebDriver getDriver(String browserName){
        return driverThread.get().getDriver(browserName);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        for(DriverManager driver : webdriverThreadPool){
            driver.quitDriver();
        }
    }

}
