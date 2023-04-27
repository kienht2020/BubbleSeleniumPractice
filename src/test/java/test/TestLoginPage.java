package test;

import constants.Login;
import data.UserAccount;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestLoginPage extends BaseTest {
    @Test(priority = 0)
    public void loginWithoutUsernameAndPassword() {
        loginPage.goToLoginPage();
        loginPage.clickLoginBtn();
        // check if there are any warnings from username field
        loginPage.checkIfTheUsernameErrMsgDisplayCorrectly();
        loginPage.checkIfWarningUsernameEmpty();
        //check if there are any warnings from password field
        loginPage.checkIfThePasswordErrMsgDisplayCorrectly();
        loginPage.checkIfWarningPasswordEmpty();
        loginPage.getAllAssert();
    }
    @Test(priority = 1)
    public void loginWithoutPassword(){
        //refresh page
        loginPage.refreshPage();
        //enter username
        loginPage.enterUsername(UserAccount.USER_NAME);
        // click login button
        loginPage.clickLoginBtn();
        //check if there are any warnings from password field
        loginPage.checkIfThePasswordErrMsgDisplayCorrectly();
        loginPage.checkIfWarningPasswordEmpty();
        loginPage.getAllAssert();

    }
    @Test(priority = 2)
    public void loginWithoutUser(){
        //refresh page
        loginPage.refreshPage();
        //enter username
        loginPage.enterPassword(UserAccount.PASSWORD);
        // click login button
        loginPage.clickLoginBtn();
        //check if there are any warnings from password field
        loginPage.checkIfTheUsernameErrMsgDisplayCorrectly();
        loginPage.checkIfWarningUsernameEmpty();
        loginPage.getAllAssert();
    }
}
