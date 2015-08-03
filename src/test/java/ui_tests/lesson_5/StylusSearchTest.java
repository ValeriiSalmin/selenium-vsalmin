package ui_tests.lesson_5;

import core.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.StylusDefaultPage;
import pages.StylusSimpleSearchResultsPage;

import static org.testng.Assert.*;
/**
 * Created by ������� on 25.07.2015.
 */
public class StylusSearchTest extends TestBase{

    String URL = "http://stylus.com.ua";
    String searchValue="Sony Z2";
    WebElement searchLinkResult;

    @Test
    public void stylusSearchTest() throws InterruptedException {

        StylusDefaultPage stylusDefaultPage = new StylusDefaultPage(driver,webDriverWait);
        stylusDefaultPage.open(URL);
        stylusDefaultPage.searchText(searchValue);
        StylusSimpleSearchResultsPage stylusSimpleSearchResultsPage = new StylusSimpleSearchResultsPage(driver, webDriverWait);
        assertTrue(stylusSimpleSearchResultsPage.findURLElement().getText().toLowerCase().contains("Sony".toLowerCase()) &&
                searchLinkResult.getText().toLowerCase().contains("Z2".toLowerCase()));
    }
}
