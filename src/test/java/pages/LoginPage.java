package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class LoginPage extends PageBase {
    By usernameXpath = By.xpath("//input[contains(@id,'username')]");
    By passwordXpath = By.xpath("//input[contains(@id,'password')]");
    By loginBtnXpath = By.xpath("//button[(@type='submit')]");
    By loginFormXpath = By.xpath("//form[contains(@id,'login')]");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //=========================== Action =====================//
    public void enterUsername(String username){
        automation.enter(usernameXpath,username);
    }
    public  void enterPassword(String password){
        automation.enter(passwordXpath,password);
    }
    public void clickLoginBtn(){
        automation.click(loginBtnXpath);
    }

    public void loginFunction(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginBtn();
        automation.sleep(1000);
    }
    public void checkLoginFormDisplayed(){
        Assert.assertTrue(automation.isElementDisplayed(loginFormXpath));
    }


}

