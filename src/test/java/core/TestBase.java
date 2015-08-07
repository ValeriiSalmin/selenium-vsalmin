package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ui_tests.TestData;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by selenium on 29.07.2015.
 */
public class TestBase {

    protected WebDriver webDriver;
    protected WebDriverWait wait;

    @BeforeSuite
    public void setUp() throws IOException {

        webDriver = WebDriverFactory.getWebDriver(TestData.BROWSER_NAME);
        wait = new WebDriverWait(webDriver,50);

        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    public void open(String URL){
        webDriver.get(URL);
    }

    @AfterSuite
    public void tearDown(){
        webDriver.quit();
    }
}
