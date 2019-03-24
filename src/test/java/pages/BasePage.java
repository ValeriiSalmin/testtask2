package pages;

import core.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log4Test;

import static org.testng.AssertJUnit.assertFalse;

public class BasePage extends TestBase {

    WebDriver webDriver;
    WebDriverWait wait;

    BasePage(WebDriver webDriver, WebDriverWait wait){
        this.webDriver = webDriver;
        this.wait = wait;
    }

    public void open(String URL) {
        webDriver.get(URL);
        Log4Test.info("Open WebUrl " + URL);
    }

    public boolean isOpened(String URL) {
        return webDriver.getCurrentUrl().equals(URL);
    }

    void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            wait.until(expectation);
        } catch (Throwable error) {
            assertFalse("Timeout waiting for Page Load Request to complete.", true);
        }
    }
}
