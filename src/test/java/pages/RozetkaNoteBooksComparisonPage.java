package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Валерий on 07.08.2015.
 */
public class RozetkaNoteBooksComparisonPage extends TestBase {

    public RozetkaNoteBooksComparisonPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public WebElement getTitle(){
        return webDriver.findElement(By.xpath("//h1[@class='comparison-title-text']"));
    }

    public boolean getProduct(String product){
        Boolean productExist=false;
        List<WebElement> list = webDriver.findElements(By.xpath("//div[@class='g-title']/a[contains(@href,'http://rozetka.com.ua')]"));
        for (WebElement item:list){
            if (item.getText().contains(product)){
                productExist=true;
                break;
            }
        }
        return productExist;
    }
}
