package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log4Test;


public class AppleIphonePage extends BasePage {

    AppleIphonePage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
        PageFactory.initElements(driver,this);
    }

    protected WebElement productContent;

    public WebElement verifyProductContent() {

        Log4Test.info("Verify product content");

        return productContent = elementIsLocated(getLocator("productDescription"));

    }
}
