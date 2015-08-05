package ui_tests;

import core.BrowserTypes;
import utils.PropertyLoader;

/**
 * Created by selenium on 03.08.2015.
 */
public class TestData {
    //public static final BrowserTypes BROWSER_NAME = BrowserTypes.CHROME;
    public static final BrowserTypes BROWSER_NAME = BrowserTypes.valueOf(PropertyLoader.loadProperty("browser.name"));
}
