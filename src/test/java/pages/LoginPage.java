package pages;

import data.URLs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {
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
    }
    public void checkLoginFormDisplayed(){
        Assert.assertTrue(automation.isElementDisplayed(loginFormXpath));
    }
    public void goToLoginPage(){
        automation.navigate(URLs.BASE_URL);
    }

}

