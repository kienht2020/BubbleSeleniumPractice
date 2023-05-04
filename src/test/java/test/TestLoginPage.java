package test;

import data.Login;
import data.URLs;
import data.UserAccount;
import org.testng.annotations.Test;

public class TestLoginPage extends BaseTest {
    @Test(priority = 0, description = "Verify that the user is not able to login with empty username and password")
    public void TC_LOG_001() {
        navigate.navigateTo(URLs.BASE_URL);
        loginPage.fillData("","");
        loginPage.clickLoginBtn();
        softAssert.assertEquals(loginPage.getUsernameEmptyMsgErr(), Login.USERNAME_EMPTY_ERR_MSG,"The empty username error message is wrong.");
        softAssert.assertEquals(loginPage.getPasswordEmptyMsgErr(), Login.PASSWORD_EMPTY_ERR_MSG,"The empty password error message is wrong.");
        softAssert.assertAll();
    }
    @Test(priority = 1, description = "Verify that the user is not able to login with empty password")
    public void TC_LOG_002(){
        //refresh page
        navigate.refreshPage();
        //enter username
        loginPage.fillData(UserAccount.USER_NAME,"");
        // click login button
        loginPage.clickLoginBtn();
        softAssert.assertEquals(loginPage.getPasswordEmptyMsgErr(), Login.PASSWORD_EMPTY_ERR_MSG,"The empty password error message is wrong.");
        softAssert.assertAll();
    }
    @Test(priority = 2,description = "Verify the user is not able to login with empty username")
    public void TC_LOG_003(){
        //refresh page
        navigate.refreshPage();
        //enter username
        loginPage.fillData("",UserAccount.PASSWORD);
        // click login button
        loginPage.clickLoginBtn();
        softAssert.assertEquals(loginPage.getUsernameEmptyMsgErr(), Login.USERNAME_EMPTY_ERR_MSG,"The empty username error message is wrong.");
        softAssert.assertAll();
    }
}
