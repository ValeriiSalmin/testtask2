package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log4Test;

public class HomePage extends BasePage {

    @FindBy(css = "[name=search]")
    WebElement searchField;

    @FindBy(css = ".button.button_color_green.search__button")
    WebElement searchButton;

    @FindBy(css = "span.header-topline__language-item_state_active")
    WebElement selectedLanguage;

    @FindBy(css = "li.header-topline__language-item a")
    WebElement ruLocale;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void setUkrainianLocale() {
        if (!selectedLanguage.getText().equals("UA")) {
            ruLocale.click();
        }
    }

    public void searchProduct(String productName) {
        Log4Test.info("Search product " + productName);
        waitForPageLoaded();
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchField.clear();
        searchField.sendKeys(productName);
        searchButton.click();
    }
}



