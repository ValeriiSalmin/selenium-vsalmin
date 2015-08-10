package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Валерий on 07.08.2015.
 */
public class RozetkaNoteBooksPage extends TestBase {

    String URL = "http://rozetka.com.ua/notebooks/c80004/";

    public RozetkaNoteBooksPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        open(URL);
        Assert.assertTrue(webDriver.getCurrentUrl().equals(URL));
    }

    public int getNumberNotesProducers(){
        int count=0;
        WebElement select = webDriver.findElement(By.xpath("(//ul[@class='m-cat-subl'])[2]"));
        List<WebElement> list = select.findElements(By.xpath("/li[@class='m-cat-subl-i']"));
        for (WebElement item:list){
            count++;
        }
        return count;
    }

    public void selectAppleProducer(){
        WebElement select = webDriver.findElement(By.xpath("(//li[@class='m-cat-l-i'])[2]"));
        List<WebElement> list = select.findElements(By.xpath("//a[@class='m-cat-subl-i-link']"));
        for (WebElement item:list){
            if (item.getText().equals("Apple")){
                webDriver.get(item.getAttribute("href"));
                break;
            }
        }
    }
}

