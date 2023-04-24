package DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager  {
    protected WebDriver createDriver(){
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
