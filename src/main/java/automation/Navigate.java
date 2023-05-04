package automation;

import org.openqa.selenium.WebDriver;

import java.util.List;

public class Navigate {
    private WebDriver driver;
    public Navigate(WebDriver driver)
    {
        this.driver = driver;
    }
    public void navigateTo(String url){
        driver.get(url);
    }
    public void refreshPage(){
        driver.navigate().refresh();
    }
    public void navigateBack(){
        driver.navigate().back();
    }
}
