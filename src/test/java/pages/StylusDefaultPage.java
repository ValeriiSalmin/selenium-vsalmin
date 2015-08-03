package pages;

import core.BrowserTypes;
import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ui_tests.TestData;

import static org.testng.Assert.assertTrue;

/**
 * Created by selenium on 29.07.2015.
 */
public class StylusDefaultPage extends TestBase {

    private WebElement searchField;
    private WebElement searchButton;

    public StylusDefaultPage(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
    }

    public void open(String URL) throws InterruptedException {
        webDriver.get(URL);
        assertTrue(isCurrentPageOpened(URL));
        Thread.sleep(5000);
    }

    public boolean isCurrentPageOpened(String URL){
        return (webDriver.getCurrentUrl().equals(URL + "/"));
    }

    public void searchText(String searchText) {
        searchField = webDriver.findElement(By.name("q"));
        searchField.sendKeys(searchText);
        searchButton = webDriver.findElement(By.xpath("//*[@class='search']//input[@type='submit']"));
        searchButton.click();
    }

    public void openMenu(){
        if (TestData.BROWSER_NAME== BrowserTypes.CHROME){
            webDriver.findElement(By.xpath("//a[@href='http://stylus.com.ua/ru/apple_store/index.html']")).click();
        }
        if (TestData.BROWSER_NAME== BrowserTypes.FIRE_FOX){
            Actions action = new Actions(webDriver);
            action.moveToElement(webDriver.findElement(By.xpath("//a[@href='http://stylus.com.ua/ru/apple_store/index.html']"))).perform();
        }
    }

    public void goTo(String product){
        if (TestData.BROWSER_NAME==BrowserTypes.FIRE_FOX){
            wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//span[@class='title' and text()='" + product + "']/.."))));
            Actions action = new Actions(webDriver);
            action.moveToElement(webDriver.findElement(By.xpath("//span[@class='title' and text()='"+product+"']/.."))).click().perform();
        }
        if (TestData.BROWSER_NAME==BrowserTypes.CHROME){
            String test1 = product.substring(0, 6);
            webDriver.findElement(By.xpath("//span[@class='title' and contains(text(),'" + test1 + "')]/..")).click();
        }
    }

    public void setLowPrice(String lowPrice) {
        webDriver.findElement(By.id("min")).clear();
        webDriver.findElement(By.id("min")).sendKeys(lowPrice);
    }

    public void setUpperPrice(String upperPrice) {
        webDriver.findElement(By.id("max")).clear();
        webDriver.findElement(By.id("max")).sendKeys(upperPrice);
    }

    public void confirm() {
        webDriver.findElement(By.xpath("//input[@type='submit' and @value='OK']")).click();
    }
}
