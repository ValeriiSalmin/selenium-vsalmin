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
public class StylusDefaultPage extends TestBase {

    private WebElement searchField;
    private WebElement searchButton;

    public StylusDefaultPage(WebDriver driver){
        this.driver=driver;
    }

    public void open(String URL){
        driver.get(URL);
    }

    public void searchText(String searchText){
        searchField = driver.findElement(By.name("q"));
        searchField.sendKeys(searchText);
        searchButton = driver.findElement(By.xpath("//*[@class='search']//input[@type='submit']"));
        searchButton.click();
    }


}
