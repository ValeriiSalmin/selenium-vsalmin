package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

/**
 * Created by selenium on 29.07.2015.
 */
public class TestBase {

    protected static WebDriver driver;
    protected static WebDriverWait webDriverWait;

    @BeforeSuite
    public void setUp(){
        driver = new FirefoxDriver();
        webDriverWait = new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

    public  void open(String URL){
        driver.get(URL);
    }
}
