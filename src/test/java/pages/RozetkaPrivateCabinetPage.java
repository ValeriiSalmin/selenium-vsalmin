package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Created by Валерий on 05.08.2015.
 */
public class RozetkaPrivateCabinetPage extends TestBase {

    public RozetkaPrivateCabinetPage(WebDriver webDriver){
        this.webDriver = webDriver;
        //Assert.assertTrue(webDriver.getCurrentUrl().equals(URL));
    }

    public void enterAsVK(){
        webDriver.findElement(By.xpath("//div[@type='vkontakte']//a")).click();
    }

//    public void fillCredentials(){
//        webDriver.findElement().sendKeys();
//        webDriver.findElement().sendKeys();
//        webDriver.findElement().click();
//    }

    public WebElement findElement(){
        return webDriver.findElement(By.xpath("//a[@class='head_name']"));
    }

    public void clickName(){
        webDriver.findElement(By.xpath("//a[@class='head_name']")).click();
    }
}
