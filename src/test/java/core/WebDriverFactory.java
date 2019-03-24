package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.Arrays;

public class WebDriverFactory {

    static {
        try {
            System.setProperty("webdriver.gecko.driver", WebDriverFactory.class.getClassLoader().getResource("drivers/windows/geckodriver.exe").getPath());
            System.setProperty("webdriver.chrome.driver", WebDriverFactory.class.getClassLoader().getResource("drivers/windows/chromedriver.exe").getPath());
        } catch (Exception e) {
            System.out.println("Cannot launch FireFox or Chrome driver \n" + e.getMessage());
        }
    }

    public static WebDriver getWebDriver(BrowserTypes browserType) throws IOException {
        switch (browserType) {
            case FIREFOX:
                return new FirefoxDriver();
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("ignore-certificate-errors"));
                return new ChromeDriver(chromeOptions);
            default:
                throw new IllegalArgumentException("Browser is not supported" + browserType);
        }
    }
}
