package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

/**
 * Created by selenium on 29.07.2015.
 */
public class StylusDefaultPage extends TestBase {

    private WebElement searchField;
    private WebElement searchButton;

    public StylusDefaultPage(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.webDriverWait = webDriverWait;
    }

    public void open(String URL) {
        driver.get(URL);
        assertTrue(isCurrentPageOpened(URL));
    }

    public boolean isCurrentPageOpened(String URL){
        return (driver.getCurrentUrl().equals(URL+"/"));
    }

    public void searchText(String searchText) {
        searchField = driver.findElement(By.name("q"));
        searchField.sendKeys(searchText);
        searchButton = driver.findElement(By.xpath("//*[@class='search']//input[@type='submit']"));
        searchButton.click();
    }

    public void openMenu() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//a[@href='http://stylus.com.ua/ru/apple_store/index.html']"))).perform();
    }

    public void goTo(String product){
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='title' and text()='"+product+"']/.."))));
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//span[@class='title' and text()='"+product+"']/.."))).click().perform();
    }

    public void setLowPrice(String lowPrice) {
        driver.findElement(By.id("min")).clear();
        driver.findElement(By.id("min")).sendKeys(lowPrice);
    }

    public void setUpperPrice(String upperPrice) {
        driver.findElement(By.id("max")).clear();
        driver.findElement(By.id("max")).sendKeys(upperPrice);
    }

    public void confirm() {
        driver.findElement(By.xpath("//input[@type='submit' and @value='OK']")).click();
    }
}
