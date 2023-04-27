package pages;

import constants.Login;
import data.URLs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {
    By usernameXpath = By.xpath("//input[contains(@id,'username')]");
    By passwordXpath = By.xpath("//input[contains(@id,'password')]");
    By loginBtnXpath = By.xpath("//button[(@type='submit')]");
    By loginFormXpath = By.xpath("//form[contains(@id,'login')]");
    By customInputUsernameXpath = By.xpath("//input[contains(@id, 'username')]//parent::span");
    By customInputPasswordXpath = By.xpath("//input[contains(@id, 'password')]//parent::span");
    By inputPrefixUserNameXpath = By.xpath("//span[contains(@class, 'mail')]/parent::span");
    By inputPrefixPasswordXpath = By.xpath("//span[contains(@class, 'lock')]/parent::span");

    By emptyErrorMessageUsernameXpath = By.xpath("//div[contains(@class, 'explain')]//span[contains(text(),'Username')]");
    By emptyErrorMessagePasswordXpath = By.xpath("//div[contains(@class, 'explain')]//span[contains(text(),'Password')]");

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
    public String getLoginPageUrl(){
        return automation.getCurrentURL();
    }
    public String getLoginPageTitle(){
        return automation.getTitle();
    }
   public void checkIfWarningUsernameEmpty(){
        softAssert.assertTrue(automation
                        .getCssColor(customInputUsernameXpath,"border-color")
                        .matches(Login.ERROR_COLOR)
                        ,"Field's color border");

        softAssert.assertTrue(automation
                        .getCssColor(inputPrefixUserNameXpath,"color")
                        .matches(Login.ERROR_COLOR)
                ,"Prefix icon's color");
       softAssert.assertTrue(automation
                       .getCssColor(emptyErrorMessageUsernameXpath, "color")
                       .matches(Login.ERROR_COLOR)
               ,"Error message color");

   }
    public void checkIfWarningPasswordEmpty(){
        softAssert.assertTrue(automation
                        .getCssColor(customInputPasswordXpath,"border-color")
                        .matches(Login.ERROR_COLOR)
                ,"Field's color border");

        softAssert.assertTrue(automation
                        .getCssColor(inputPrefixPasswordXpath,"color")
                        .matches(Login.ERROR_COLOR)
                ,"Prefix icon's color");
        softAssert.assertTrue(automation
                        .getCssColor(emptyErrorMessagePasswordXpath, "color")
                        .matches(Login.ERROR_COLOR)
                ,"Error message color");

    }
   public void checkIfTheUsernameErrMsgDisplayCorrectly(){
        softAssert.assertTrue(automation.isElementDisplayed(emptyErrorMessageUsernameXpath)
                ,"Is the Error message display");
        softAssert.assertEquals(automation.getText(emptyErrorMessageUsernameXpath)
                ,Login.USERNAME_EMPTY_ERR_MSG
                ,"Is the Error message is correct");
   }
    public void checkIfThePasswordErrMsgDisplayCorrectly(){
        softAssert.assertTrue(automation.isElementDisplayed(emptyErrorMessagePasswordXpath)
                ,"Is the Error message display");
        softAssert.assertEquals(automation.getText(emptyErrorMessagePasswordXpath)
                ,Login.PASSWORD_EMPTY_ERR_MSG
                ,"Is the Error message is correct");
    }
}

