package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by selenium on 03.08.2015.
 */
public class WebDriverFactory {

    static {
        try {
            System.setProperty("webdriver.chrome.driver",WebDriverFactory.class.getClassLoader().getResource("drivers/chromedriver.exe").getPath());
        }
        catch (Exception e){
            System.out.println("Cannot launch Firefox or Chrome driver \n" + e.getMessage());
        }
    }

    public static WebDriver getWebDriver(BrowserTypes browserTypes) throws IOException{
        switch (browserTypes){
            case FIRE_FOX:
                ProfilesIni profile = new ProfilesIni();
                FirefoxProfile ffprofile = profile.getProfile("SELENIUM");
                return new FirefoxDriver(ffprofile);

            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("ignore-certificate-errors"));
                return new ChromeDriver(chromeOptions);

            case IE:
                return new InternetExplorerDriver();

            default:
                throw new IllegalArgumentException("Browser is not supported"+browserTypes.name());
        }
    }


}
