package lesson_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;
/**
 * Created by Валерий on 25.07.2015.
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
    public void stylusSearchTest(){

        searchField = driver.findElement(By.name("q"));
        searchField.sendKeys(searchValue);
        searchButton = driver.findElement(By.xpath("//*[@value='Найти']"));
        searchButton.click();
        searchLinkResult = driver.findElement(By.xpath(".//*[@id='search-list']//span[contains(text(),'Sony') and contains(text(),'Z2')]"));
        assertTrue(searchLinkResult.getText().toLowerCase().contains(searchValue.toLowerCase()));
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
