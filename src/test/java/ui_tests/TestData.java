package ui_tests;

import core.BrowserTypes;
import utils.PropertyLoader;

public class TestData {

    public static final BrowserTypes BROWSER_NAME = BrowserTypes.valueOf(PropertyLoader.loadProperty("browser.name"));

    public static final String ROZETKA_URL = "https://rozetka.com.ua/";

    public static final String APPLE_IPHONE_7 = "Apple IPhone 7 32gb".toLowerCase();

    public static final String APPLE_IPHONE_7_WIDTH = "67.1 мм";

    public static final String APPLE_IPHONE_7_HEIGHT = "138.3 мм";

    public static final String APPLE_IPHONE_7_DISPLAY = "4.7";

    public static final String APPLE_IPHONE_7_MEMORY = "2 ГБ";

    public static final String APPLE_IPHONE_7_PLUS = "Apple IPhone 7 Plus 32gb".toLowerCase();

    public static final String APPLE_IPHONE_7_PLUS_WIDTH = "77.9 мм";

    public static final String APPLE_IPHONE_7_PLUS_HEIGHT = "158.2 мм";

    public static final String APPLE_IPHONE_7_PLUS_DISPLAY = "5.5";

    public static final String APPLE_IPHONE_7_PLUS_MEMORY = "3 ГБ";
}
