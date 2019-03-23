package ui_tests;

import core.TestBase;
import org.testng.annotations.Test;
import pages.AppleIphonePage;
import pages.BasketPage;
import pages.HomePage;
import pages.SearchPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmartphoneSearchTest extends TestBase {


    //AppleIphonePage samsungGalaxyS5Page = new AppleIphonePage();

    BasketPage basketPage = new BasketPage(webDriver,wait);

    @Test
    public void testSearchSmartphoneAndVerifyCharacteristics() {

        HomePage homePage = new HomePage(webDriver,wait);
        homePage.open(TestData.ROZETKA_URL);
        assertTrue(homePage.isOpened(TestData.ROZETKA_URL));
        homePage.searchProduct(TestData.APPLE_IPHONE_7);

        SearchPage searchPage = new SearchPage(webDriver,wait);
        assertTrue(searchPage.verifyProductLink().contains(TestData.APPLE_IPHONE_7));
        searchPage.addToBasketFirstProduct();

        //searchPage.openProductLink();
        searchPage.returnToPreviousPage();
        homePage.searchProduct(TestData.APPLE_IPHONE_7_PLUS);
        assertTrue(searchPage.verifyProductLink().contains(TestData.APPLE_IPHONE_7_PLUS));
      //  searchPage.openProductLink();
        searchPage.addToBasketFirstProduct();
        basketPage.checkAddedItems(TestData.APPLE_IPHONE_7, TestData.APPLE_IPHONE_7_PLUS);
    }
}
