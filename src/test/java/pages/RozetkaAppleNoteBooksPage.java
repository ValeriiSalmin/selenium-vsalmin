package pages;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Валерий on 07.08.2015.
 */
public class RozetkaAppleNoteBooksPage extends TestBase{

    String URL = "http://rozetka.com.ua/notebooks/apple/c80004/v069/";

    public RozetkaAppleNoteBooksPage(WebDriver webDriver, WebDriverWait wait){
        this.webDriver = webDriver;
        this.wait = wait;
        open(URL);
        Assert.assertTrue(webDriver.getCurrentUrl().equals(URL));
    }

    public void setSorting(String typeOfSorting){
        webDriver.get(webDriver.findElement(By.xpath("//a[contains(@class,'sort-view-l-i-link') and contains(text(),'"+typeOfSorting+"')]")).getAttribute("href"));
    }

    public boolean findProduct(String product){
        Boolean productExist=false;
        WebElement select = webDriver.findElement(By.xpath("//div[@name='goods_list']//div[contains(@class,'g-i-tile-i-title clearfix')]"));
        List<WebElement> list = select.findElements(By.xpath("/a"));
        for (WebElement item:list){
            if (item.getText().contains(product)){
                productExist=true;
                break;
            }
        }
        return productExist;
    }

    public void addToCompare(String product){
        webDriver.findElement(By.xpath("//a[contains(text(),'"+product+"')]/../..//div[@name='comparison_new_catalog']//img")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'" + product + "')]/../..//div[@name='comparison_new_catalog']//input[@checked='checked']")));
    }

    public boolean checkProductInComparisonList(String product){
        Boolean isExisted=false;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'" + product + "')]/../..//div[@name='comparison_new_catalog']//input[@checked='checked']")));

        webDriver.get(webDriver.findElement(By.xpath("//*[@id='comparison']/a")).getAttribute("href"));
        if (webDriver.findElement(By.xpath("//a[contains(text(),'" + product + "')]")).getText().contains(product)){
            isExisted=true;
        }
        webDriver.navigate().back();
        return isExisted;
    }

    public boolean checkProductsInComparisonList(String product1, String product2){
        Boolean isExisted=false;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'" + product1 + "')]/../..//div[@name='comparison_new_catalog']//input[@checked='checked']")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'" + product2 + "')]/../..//div[@name='comparison_new_catalog']//input[@checked='checked']")));

        webDriver.get(webDriver.findElement(By.xpath("//*[@id='comparison']/a")).getAttribute("href"));
        if (webDriver.findElement(By.xpath("//a[contains(text(),'" + product1 + "')]")).getText().contains(product1)&&webDriver.findElement(By.xpath("//a[contains(text(),'" + product2 + "')]")).getText().contains(product2)){
            isExisted=true;
        }
        webDriver.navigate().back();
        return isExisted;
    }

    public void clickToCompare() throws InterruptedException {
        Thread.sleep(5000);
        webDriver.get(webDriver.findElement(By.xpath("(//a[contains(@href,'http://rozetka.com.ua/computers-notebooks/notebooks/comparison/ids=')])[1]")).getAttribute("href"));
    }
}
