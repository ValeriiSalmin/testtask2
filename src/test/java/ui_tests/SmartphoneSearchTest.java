package ui_tests;

import core.TestBase;
import org.testng.annotations.Test;
import pages.AppleIphonePage;
import pages.BasketPage;
import pages.HomePage;
import pages.SearchPage;
import utils.SQLHelper;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmartphoneSearchTest extends TestBase {

    @Test
    public void testSearchSmartphoneAndVerifyCharacteristics() throws Exception {

        HomePage homePage = new HomePage(webDriver,wait);
        homePage.open(TestData.ROZETKA_URL);
        assertTrue(homePage.isOpened(TestData.ROZETKA_URL),"Page isn't opened!!!");
        homePage.setUkrainianLocale();
        homePage.searchProduct(TestData.APPLE_IPHONE_7);

        SearchPage searchPage = new SearchPage(webDriver,wait);
        assertTrue(searchPage.verifyProduct().contains(TestData.APPLE_IPHONE_7),"Product isn't found!!!");
        searchPage.openProduct();

        AppleIphonePage appleIphonePage = new AppleIphonePage(webDriver,wait);
        appleIphonePage.goToCharisticsTab();
        assertEquals(appleIphonePage.getDisplay(),TestData.APPLE_IPHONE_7_DISPLAY);
        assertEquals(appleIphonePage.getMemory(),TestData.APPLE_IPHONE_7_MEMORY);
        assertEquals(appleIphonePage.getWidth(),TestData.APPLE_IPHONE_7_WIDTH);
        assertEquals(appleIphonePage.getHeight(),TestData.APPLE_IPHONE_7_HEIGHT);
        Double priceAppleIphone7 = appleIphonePage.getPrice();
        appleIphonePage.addToBasket();

        BasketPage basketPage = new BasketPage(webDriver,wait);
        basketPage.closeBasketPage();
        homePage.open(TestData.ROZETKA_URL);

        homePage.searchProduct(TestData.APPLE_IPHONE_7_PLUS);
        assertTrue(searchPage.verifyProduct().contains(TestData.APPLE_IPHONE_7_PLUS),"Product isn't found!!!");
        searchPage.openProduct();
        appleIphonePage.goToCharisticsTab();
        assertEquals(appleIphonePage.getDisplay(),TestData.APPLE_IPHONE_7_PLUS_DISPLAY);
        assertEquals(appleIphonePage.getMemory(),TestData.APPLE_IPHONE_7_PLUS_MEMORY);
        assertEquals(appleIphonePage.getWidth(),TestData.APPLE_IPHONE_7_PLUS_WIDTH);
        assertEquals(appleIphonePage.getHeight(),TestData.APPLE_IPHONE_7_PLUS_HEIGHT);
        Double priceAppleIphone7Plus = appleIphonePage.getPrice();

        appleIphonePage.addToBasket();
        assertTrue(basketPage.isItemsInBasket(TestData.APPLE_IPHONE_7, TestData.APPLE_IPHONE_7_PLUS),"Items aren't in basket!!!");

        SQLHelper.writePricesToDB(priceAppleIphone7,priceAppleIphone7Plus);
    }
}
