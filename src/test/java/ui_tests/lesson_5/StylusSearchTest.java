package ui_tests.lesson_5;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.StylusDefaultPage;
import pages.StylusSearchResultsPage;

import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;
/**
 * Created by ������� on 25.07.2015.
 */
public class StylusSearchTest extends TestBase{

    WebElement searchField;
    String searchValue="Sony Z2";
    WebElement searchButton;
    WebElement searchLinkResult;

    @Test
    public void stylusSearchTest() throws InterruptedException {

        StylusDefaultPage stylusDefaultPage = new StylusDefaultPage(driver);
        stylusDefaultPage.open("http://www.stylus.com.ua");
        stylusDefaultPage.searchText(searchValue);
        StylusSearchResultsPage stylusSearchResultsPage = new StylusSearchResultsPage(driver);
        assertTrue(stylusSearchResultsPage.findURLElement().getText().toLowerCase().contains("Sony".toLowerCase()) &&
                searchLinkResult.getText().toLowerCase().contains("Z2".toLowerCase()));

    }
}
