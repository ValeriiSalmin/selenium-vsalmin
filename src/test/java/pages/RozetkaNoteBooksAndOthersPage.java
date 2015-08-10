package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Валерий on 06.08.2015.
 */
public class RozetkaNoteBooksAndOthersPage extends TestBase {

    String URL="http://rozetka.com.ua/computers-notebooks/c80253/";

    public RozetkaNoteBooksAndOthersPage(WebDriver webDriver){
        this.webDriver = webDriver;
        open(URL);
        Assert.assertTrue(webDriver.getCurrentUrl().equals(URL));
    }

    public void goToAllNoteBooks(){
        webDriver.findElement(By.xpath("//a[@href='http://rozetka.com.ua/notebooks/c80004/']")).click();
    }

    public int getNumberUnderNoteBooks(){
        WebElement select = webDriver.findElement(By.xpath("(//ul[@class='pab-items'])[1]"));
        List<WebElement> list = select.findElements(By.xpath("/li[@class='pab-items-i']"));
       // return webDriver.findElements(By.xpath("(//ul[@class='pab-items'])[1]/li[@class='pab-items-i']")).size();
        return list.size();
    }


}
