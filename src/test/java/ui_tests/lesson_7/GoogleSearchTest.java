package ui_tests.lesson_7;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;

import static org.testng.Assert.assertTrue;

/**
 * Created by selenium on 22.07.2015.
 */
public class GoogleSearchTest extends TestBase{

    private String googleWebSite="https://www.google.com";
    private String searchText = "Selenium";

    @Test
    public void seleniumSearchTest(){
        GoogleSearchPage onGoogleSearchPage = new GoogleSearchPage();
        onGoogleSearchPage.open(googleWebSite);
        onGoogleSearchPage.searchText(searchText);
        assertTrue(onGoogleSearchPage.findURLElement().getText()
                .toLowerCase().contains(searchText.toLowerCase()));
    }
}
