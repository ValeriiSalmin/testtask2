package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log4Test;

/**
 * Created by Walker on 7/26/14.
 */
public class SearchPage extends BasePage {

    @FindBy(xpath = "//div[@class='g-i-tile-i-title clearfix']/a[@href]")
    WebElement productLink;

    @FindBy(xpath = "(//*[@class='toOrder'])[1]")
    WebElement addToBasketFirstItem;

    public SearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public String verifyProduct() {
        Log4Test.info("Verify product");
        return productLink.getText().toLowerCase();
    }

    public void openProduct() {
        Log4Test.info("Open product characteristics");
        wait.until(ExpectedConditions.visibilityOf(productLink));
        productLink.click();
    }

    public void addToBasketFirstProduct() {
        Log4Test.info("Add product to basket");
        addToBasketFirstItem.click();
    }
}
