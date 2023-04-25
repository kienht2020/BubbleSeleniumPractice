package test;

import data.UserAccount;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ForFun2Test extends BaseTest {
    @Test
    public void Test3()  {
        loginPage.goToLoginPage();
        loginPage.loginFunction(UserAccount.USER_NAME, UserAccount.PASSWORD);
        System.out.println(driver.findElement(By.xpath("//*[@id=\"app\"]/div/section/aside/div/ul/li[5]/span[2]/span")).getText());

    }

}
