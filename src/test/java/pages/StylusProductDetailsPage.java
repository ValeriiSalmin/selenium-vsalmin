package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Created by Валерий on 31.07.2015.
 */
public class StylusProductDetailsPage extends TestBase{


    public StylusProductDetailsPage(WebDriver driver){
        this.webDriver=webDriver;
    }

    public WebElement findHeaderElement(){
        return webDriver.findElement(By.xpath("//header[@class='title']//h1"));
    }
}
