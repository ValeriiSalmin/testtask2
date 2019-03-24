package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class BasketPage extends BasePage{

    @FindBy(css = ".cart-i-content a[name='goods-link']")
    List<WebElement> basketItems;

    @FindBy(css = "a[class='popup-close']")
    WebElement closeButton;

    public BasketPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
        PageFactory.initElements(driver,this);
    }

    public boolean isItemsInBasket(String ... items){
        //boolean checked = false;
        if (items.length != basketItems.size()){
            return false;
        }
        Boolean[] checkedArray = new Boolean[items.length];
        for (int i=0;i<items.length;i++){
            for (int j=0;j<basketItems.size();j++){
                //String text1 = basketItems.get(i).getText().toLowerCase();
                //String items1 = items[i];
                if (basketItems.get(j).getText().toLowerCase().contains(items[i])){
                    checkedArray[i] = true;
                }
            }
        }
        return Arrays.stream(checkedArray).allMatch(val -> val);
    }

    public void closeBasketPage(){
        wait.until(ExpectedConditions.visibilityOf(closeButton));
        closeButton.click();
    }
}
