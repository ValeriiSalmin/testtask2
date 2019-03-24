package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AppleIphonePage extends BasePage {

    @FindBy(css = "li[name='characteristics'] a[href]")
    WebElement characheristicsTab;

    @FindBy(css = "div.chars-value")
    List<WebElement> characheristics;

    @FindBy(xpath = "//*[contains(text(),'Ширина')]/../..//div[@class='chars-value']")
    WebElement iphoneWidth;

    @FindBy(xpath = "//*[contains(text(),'Висота')]/../..//div[@class='chars-value']")
    WebElement iphoneHeight;

    @FindBy(xpath = "//*[contains(text(),'Діагональ екрана')]/../../..//div[@class='chars-value']//a")
    WebElement iphoneDisplay;

    @FindBy(xpath = "//*[contains(text(),\"Оперативна пам'ять\")]/../../..//div[@class='chars-value']//a")
    WebElement iphoneMemory;

    @FindBy(css = "[name='sticky_price']")
    WebElement iphonePrice;

    @FindBy(css = ".toOrder")
    WebElement buyItem;

    @FindBy(css = "a.exponea-banner.exponea-popup-banner.exponea-animate")
    List<WebElement> adPopup;

    @FindBy(css = "span.exponea-close")
    WebElement closeAdPopup;

    public AppleIphonePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void goToCharisticsTab() {
        characheristicsTab.click();
    }

    public String getWidth() {
        return iphoneWidth.getText();
    }

    public String getHeight() {
        return iphoneHeight.getText();
    }

    public String getDisplay() throws InterruptedException {
        Thread.sleep(1000);
        return iphoneDisplay.getText();
    }

    public String getMemory() {
        return iphoneMemory.getText();
    }

    public Double getPrice() {
        String parsedPrice = iphonePrice.getText().replaceAll(" ", "");
        return Double.valueOf(parsedPrice);
    }

    public void addToBasket() {
        if (adPopup.size()!=0){
            wait.until(ExpectedConditions.visibilityOf(closeAdPopup));
            closeAdPopup.click();
        }
        buyItem.click();
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.cssSelector(".cart-total"))));
    }
}
