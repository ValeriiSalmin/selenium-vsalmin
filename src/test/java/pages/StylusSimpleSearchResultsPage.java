package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by selenium on 29.07.2015.
 */
public class StylusSimpleSearchResultsPage extends TestBase {

    private WebElement searchLink;


    public StylusSimpleSearchResultsPage(WebDriver webDriver, WebDriverWait wait){

        this.webDriver = webDriver;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='search-list']//span[text()]")));
    }

    public WebElement findURLElement(){
        searchLink = webDriver.findElement(By.xpath("//div[@id='search-list']//a//span[contains(text(),'Sony') and contains(text(),'Z2')]"));
        return searchLink;
    }
}
