package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasketPage extends BasePage{

    @FindBy(css = ".cart-i-content a[name='goods-link']")
    List<WebElement> basketItems;

    public BasketPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
        PageFactory.initElements(driver,this);
    }

    public boolean checkAddedItems(String ... items){
        boolean checked = false;
        for (int i=0;i<items.length;i++){
            if (basketItems.get(i).getText().equals(items)){
                checked = true;
            }
            else {
                checked = false;
            }
        }
        return checked;
    }
}
