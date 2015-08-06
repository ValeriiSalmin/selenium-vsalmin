package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Валерий on 06.08.2015.
 */
public class VKDefaultPage extends TestBase {

    public VKDefaultPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public WebElement findElement(){
        return webDriver.findElement(By.xpath("//h1[@id='title']"));
    }
}
