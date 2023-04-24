package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestForFun extends TestBase {
    @Test
    public void Test1() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.xpath("//*[@id=\"app\"]/div/section/aside/div/ul/li[1]/span[2]/span")).getText());

    }

}
