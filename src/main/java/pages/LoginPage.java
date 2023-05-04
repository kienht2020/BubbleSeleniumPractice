package pages;

import data.URLs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    By txtUsername = By.xpath("//input[contains(@id,'username')]");
    By txtPassword = By.xpath("//input[contains(@id,'password')]");
    By loginBtn = By.xpath("//span[contains(text(),Login)]//parent::button");
    By frmLogin = By.xpath("//form[contains(@id,'login')]");
    By customInputUsername = By.xpath("//input[contains(@id, 'username')]//parent::span");
    By customInputPassword = By.xpath("//input[contains(@id, 'password')]//parent::span");
    By inputPrefixUserName = By.xpath("//span[contains(@class, 'mail')]/parent::span");
    By inputPrefixPassword = By.xpath("//span[contains(@class, 'lock')]/parent::span");

    By usernameEmptyMsgErr = By.xpath("//div[contains(@class, 'explain')]//span[contains(text(),'Username')]");
    By passwordEmptyMsgErr = By.xpath("//div[contains(@class, 'explain')]//span[contains(text(),'Password')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //=========================== Action =====================//
    public void enterUsername(String username){
        automation.enter(txtUsername,username);
    }
    public  void enterPassword(String password){
        automation.enter(txtPassword,password);
    }
    public void clickLoginBtn(){
        automation.click(loginBtn);
    }
    public void fillData(String username, String password){
        enterUsername(username);
        enterPassword(password);
    }

    public void loginFunction(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginBtn();
    }
    public String getUsernameEmptyMsgErr(){
        return automation.getText(usernameEmptyMsgErr);
    }
    public String getPasswordEmptyMsgErr(){
        return automation.getText(passwordEmptyMsgErr);
    }
}

