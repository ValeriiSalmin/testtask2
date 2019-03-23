package ui_tests;

import core.BrowserTypes;
import utils.PropertyLoader;

public class TestData {

    public static final BrowserTypes BROWSER_NAME = BrowserTypes.valueOf(PropertyLoader.loadProperty("browser.name"));

    public static final String ROZETKA_URL = "https://rozetka.com.ua/";

    public static final String APPLE_IPHONE_7 = "Apple IPhone 7 32gb".toLowerCase();

    public static final String APPLE_IPHONE_7_PLUS = "Apple IPhone 7 Plus 32gb".toLowerCase();
}
