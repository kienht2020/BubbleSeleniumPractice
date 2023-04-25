package automation;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Automation {
    private  WebDriver driver;
    private WebElement element = null;
    private List<WebElement> listElements = null;
    Actions actions;


    public Automation(WebDriver driver)
    {
        this.driver = driver;
    }
    public void sleep(int milliseconds){
        try{
            Thread.sleep(milliseconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public WebElement findElement(By locator, long timeout){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

         element = wait.until(
                new Function<WebDriver, WebElement>() {
                    public WebElement apply(WebDriver driver) {
                        return driver.findElement(locator);
                    }
                }
        );
        return element;
    };
    public  List<WebElement> findElements( By locator,long timeout){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

         listElements = wait.until(
                new Function<WebDriver,List<WebElement>>() {
                    public List<WebElement> apply(WebDriver driver) {
                        return driver.findElements(locator);
                    }
                }
        );
        return listElements;
    };
    public WebElement findElement(By locator){
        int timeout = Settings.getObjecWait();
        return findElement(locator, timeout);
    }
    public    List<WebElement> findElements(By locator){
        int timeout = Settings.getObjecWait();
        return findElements(locator, timeout);
    }
    public void waitForControlClose(By locator) {
        int timeout = Settings.getObjecWait();

        try {
            WebDriverWait wait = new WebDriverWait(driver, (Duration.ofSeconds(timeout)));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public WebElement getElementFromListElements(By locator, int index){
        List<WebElement> elementList = findElements(locator);
        return elementList.get(index);
    }
    public void waitForControlClose(By locator, long timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, (Duration.ofSeconds(timeout)));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public boolean isPageDisplayed(String pageTitle) {

        boolean isExist = false;
        long timeout = Settings.getObjecWait()*1000;
        try {
            driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
            String title = driver.getTitle();
            long getTickCount = System.currentTimeMillis();
            while (!title.equals(pageTitle)) {
                Thread.sleep(50);
                title = driver.getTitle();
                if ((System.currentTimeMillis()-getTickCount) > timeout) {
                    break;
                }
            }

            if (title.equals(pageTitle)) isExist = true;
        } catch (Exception e) {
            isExist = false;
        }
        return isExist;

    }
    public void type(CharSequence... keys)
    {
        element.sendKeys(keys);

    }
    public void enter(By locator, String value) {
        element = findElement(locator);
        element.click();
        sleep(500);
        clearFieldByJS(element);
        element.sendKeys(value);
    }
    public void enter(WebElement element, String value) {
        element.click();
        sleep(500);
        clearFieldByJS(element);
        element.sendKeys(value);
    }
    public void clear(By locator){
        element = findElement(locator);
        element.clear();
        sleep(500);
    }
    public boolean isElementExists(By locator)
    {
        return findElement(locator)!= null ;
    }

    public boolean isElementDisplayed(By locator)
    {
        boolean isDisplayed = false;
        boolean isExists = isElementExists(locator);

        if(isExists)
        {
            try {
                isDisplayed = driver.findElement(locator).isDisplayed();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return isDisplayed;
    }
    public void bringIntoView(By locator)
    {
        element = findElement(locator);

    }
    public void clickByJS(By locator)
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", findElement(locator));
        sleep(1000);
    }
    public void clearFieldByJS(By locator){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].value = '';", findElement(locator));
    }
    public void clearFieldByJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].value = '';", element);
    }
    public void click(By locator) {
        element = findElement(locator);
        try
        {
            element.click();
        }
        catch(NoSuchElementException ex)
        {
            clickByJS(locator);
        }
        sleep(1000);
    }


    public boolean checkIfElementsInListDisplay(By locator){
        try{
            List<WebElement> listElement = findElements(locator);
            return listElement.size()>0;
        }catch (Exception e){
            return false;
        }
    }
    public boolean isChecked(By locator)
    {
        element = findElement(locator);
        return element.isSelected();
    }
    public String getText(By locator)
    {
        return findElement(locator).getText();
    }
    public String getText(WebElement element){return element.getText(); }
    public String getAttribute(By locator, String att)
    {
        element = findElement(locator);
        return element.getAttribute(att);
    }
    public String getCssColor(By locator, String att){
        element = findElement(locator);
        return element.getCssValue(att);
    }
    public  WebDriver getDriver()
    {
        return driver;
    }
    public void navigate(String url)
    {
        driver.manage().window().maximize();
        driver.get(url);
    }
    public void close()
    {
        if(driver != null)
        {
            driver.quit();
        }
    }

    public String getCurrentURL(){

        return driver.getCurrentUrl();
    }

    public String getTitle()
    {
        return driver.getTitle();
    }
    public  boolean isTextContains(String strActual, String strExpected){
        if(strExpected.contains(strActual))
            return true;
        return false;
    }
    public  List<String> getListText(By locator){
        List<String> listText = new ArrayList<>();
        List <WebElement> listEles = findElements(locator);
        if(listEles.isEmpty()){
            return null;
        }
        for(WebElement e : listEles){
            listText.add(e.getText());
        }
        return listText;
    }
    public  Boolean isTextExisting( By locator, String text){
        try{
            List<String> listText = getListText(locator);
            return listText.contains(text);
        } catch(Exception e){
            return false;
        }

    }
    public void uploadPhoto(By locator, String url){
        try {
            findElement(locator).sendKeys(url);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void moveToElementAndClick(By locator){
        actions = new Actions(driver);
        WebElement element = findElement(locator);
        actions.moveToElement(element).perform();
        actions.click(element).perform();
    }
    public void moveToElementAndClick(WebElement element){
        actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click(element).perform();
    }
    public void moveToElement(By locator){
        actions = new Actions(driver);
        WebElement element = findElement(locator);
        actions.moveToElement(element).perform();
    }
    public void moveToElement(WebElement element){
        actions = new Actions(driver);
        actions.moveToElement(element).perform();
        sleep(500);
    }
    public void refreshPage(){
        driver.navigate().refresh();
    }
    public void backPage(){
        driver.navigate().back();
    }
    public void chooseValueInDropdown(int index){
        actions = new Actions(driver);
        for (int i = 0; i < index; i++ ){
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        actions.sendKeys(Keys.ENTER).perform();
    }
}
