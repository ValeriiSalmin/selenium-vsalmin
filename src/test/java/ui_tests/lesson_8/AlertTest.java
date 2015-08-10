package ui_tests.lesson_8;

import core.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by selenium on 10.08.2015.
 */
public class AlertTest extends TestBase {

    @Test
    public void alertTest() {
        webDriver.get("http://www.quackit.com/javascript/codes/javascript_prompt.cfm");
        webDriver.switchTo().frame(webDriver.findElement(By.xpath("(//iframe[@class='result'])[1]")));
        webDriver.findElement(By.xpath("//input[@type='button' and contains(@value,'Click me')]")).click();
        Alert alert = webDriver.switchTo().alert();
        String AlertText = alert.getText();
        System.out.println(AlertText);
        alert.accept();
    }

    @Test
    public void frameTest() {
        String URL="http://www.quackit.com/html/templates/frames/frames_example_1.html";

        webDriver.get(URL);
        List<WebElement> frames = webDriver.findElements(By.tagName("frame"));
        webDriver.switchTo().frame(0);
       // Assert.assertTrue("White Page");
        webDriver.switchTo().frame(1);
        //Assert.assertTrue(webDriver.getCurrentUrl().equals(URL));
        webDriver.switchTo().defaultContent();
        Assert.assertTrue(webDriver.getCurrentUrl().equals(URL));
            //webDriver.switchTo().frame(item);

    }

    @Test
    public void switchWindow() {
//        String URL="http://www.quackit.com/html/codes/html_popup_window_code.cfm";
//        webDriver.get(URL);
//        String beforeWindow = webDriver.getWindowHandle();
//        webDriver.findElement(By.xpath("//a[contains(@href,'JavaScript:newPopup')]")).click();
//        for (String handle:webDriver.getWindowHandles()){
//            webDriver.switchTo().window(handle);
//            System.out.println(handle);
//        }
        Date date = new Date();
        date.getTime();
        System.out.print(date.toString());
        System.out.print(date.getTime());
//        webDriver.switchTo().window(beforeWindow);
//        Assert.assertTrue(webDriver.getCurrentUrl().equals(URL));
    }
}