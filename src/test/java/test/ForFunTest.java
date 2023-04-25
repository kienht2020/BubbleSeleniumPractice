package test;

import data.UserAccount;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ForFunTest extends BaseTest {
    @Test
    public void Test1() {
        loginPage.goToLoginPage();
        loginPage.loginFunction(UserAccount.USER_NAME, UserAccount.PASSWORD);
        System.out.println(loginPage.getLoginPageTitle());

    }

}
