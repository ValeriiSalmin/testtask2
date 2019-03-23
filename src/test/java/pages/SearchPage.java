package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log4Test;

/**
 * Created by Walker on 7/26/14.
 */
public class SearchPage extends BasePage {

    @FindBy(xpath = "//div[@class='g-i-tile-i-title clearfix']/a[@href]")
    WebElement searchProductLink;

    @FindBy(xpath = "(//*[@class='toOrder'])[1]")
    WebElement addToBasketFirstItem;

    public SearchPage(WebDriver driver, WebDriverWait wait){
        super(driver,wait);
        PageFactory.initElements(driver,this);
    }

    private WebElement searchLinkElem;

    public String verifyProductLink() {
        Log4Test.info("Verify product link");
        return searchProductLink.getText().toLowerCase();
    }

    public void openProductLink() {
        Log4Test.info("Open product characteristics");
        searchLinkElem = elementIsLocated(getLocator("searchProductLink"));
        searchLinkElem.click();
    }

    public void addToBasketFirstProduct(){
        addToBasketFirstItem.click();
    }
}
