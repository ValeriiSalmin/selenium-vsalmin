package pages;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Created by Валерий on 05.08.2015.
 */
public class RozetkaPrivateCabinetPage extends TestBase {

    String winHandleBefore=null;

    public RozetkaPrivateCabinetPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void enterAsVK(){
        winHandleBefore = webDriver.getWindowHandle();
        webDriver.findElement(By.xpath("//div[@type='vkontakte']//a")).click();
        for(String winHandle : webDriver.getWindowHandles()){
            webDriver.switchTo().window(winHandle);
        }
    }

    public void fillCredentialsAndLogin(String email,String password){
       // webDriver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
       // WebElement element = webDriver.findElement(By.linkText("Click ME"));
        js.executeScript("document.getElementByName('email')[0].value="+email+"");
        webDriver.findElement(By.xpath("//input[@name='pass']")).sendKeys(password);
        webDriver.findElement(By.xpath("//*[@id='install_allow']")).click();
    }

    public WebElement findElement(){
        return webDriver.findElement(By.xpath("//a[@class='head_name']"));
    }

    public void clickOnName(){
        winHandleBefore = webDriver.getWindowHandle();
        webDriver.findElement(By.xpath("//a[@class='head_name']")).click();
        for(String winHandle : webDriver.getWindowHandles()){
            webDriver.switchTo().window(winHandle);
        }
    }
}
