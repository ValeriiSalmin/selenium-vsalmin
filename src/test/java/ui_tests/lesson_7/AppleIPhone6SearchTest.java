package ui_tests.lesson_7;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.testng.annotations.Test;
import pages.StylusDefaultPage;
import pages.StylusProductDetailsPage;

import static org.testng.Assert.*;

/**
 * Created by Валерий on 31.07.2015.
 */
public class AppleIPhone6SearchTest extends TestBase {

    String URL = "http://stylus.com.ua";
    String lowPrice = "20000";
    String upperPrice = "30000";
    String product = "iPhone 6";
    String nameOfSearchProduct = "Apple iPhone 6 128GB Space Gray";

    @Test
    public void appleIPhone6SearchTest(){
        StylusDefaultPage stylusDefaultPage = new StylusDefaultPage(driver,webDriverWait);
        stylusDefaultPage.open(URL);
        stylusDefaultPage.openMenu();
        stylusDefaultPage.goTo(product);
        stylusDefaultPage.setLowPrice(lowPrice);
        stylusDefaultPage.setUpperPrice(upperPrice);
        stylusDefaultPage.confirm();
        StylusProductDetailsPage stylusProductDetailsPage = new StylusProductDetailsPage(driver);
        assertTrue(stylusProductDetailsPage.findHeaderElement().getText().contains(nameOfSearchProduct));
    }
}
