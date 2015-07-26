package lesson_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;
/**
 * Created by ������� on 25.07.2015.
 */
public class StylusSearchTest {

    WebDriver driver;
    WebElement searchField;
    String searchValue="Sony Z2";
    WebElement searchButton;
    WebElement searchLinkResult;

    @BeforeTest
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.stylus.com.ua");
    }

    @Test
    public void stylusSearchTest() throws InterruptedException {

        searchField = driver.findElement(By.name("q"));
        searchField.sendKeys(searchValue);
        searchButton = driver.findElement(By.xpath("//*[@class='search']//input[@type='submit']"));
        searchButton.click();
        searchLinkResult = driver.findElement(By.xpath(".//*[@id='search-list']//span[contains(text(),'Sony') and contains(text(),'Z2')]"));
        searchCondition();
        assertTrue(searchLinkResult.getText().toLowerCase().contains("Sony".toLowerCase()) &&
                searchLinkResult.getText().toLowerCase().contains("Z2".toLowerCase()));

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    public void searchCondition(){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='search-list']//span[text()]")));
    }
}
