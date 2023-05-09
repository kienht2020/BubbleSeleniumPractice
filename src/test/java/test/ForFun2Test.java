package test;

import data.UserAccount;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ForFun2Test extends BaseTest {
    @Test
    public void Test2()  {

        loginPage.loginFunction(UserAccount.USER_NAME, UserAccount.PASSWORD);
    }

}
