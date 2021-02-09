package demo.vek;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.HomePage;
import demo.gui.pages.BasketPage;
import demo.gui.pages.PopularItemPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddPopularItemToBasketTest extends AbstractTest {
    private static final String ITEM_EXPECTED =
            "Термокружка 21vek 1186/7 (черный/красный)";

    @Test
    @MethodOwner(owner = "kapinus")
    public void testAddItemToBasket() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "21vek home page was not opened!");
        PopularItemPage itemPage = homePage.openItemFromPrimaryPane(ITEM_EXPECTED);
        Assert.assertTrue(itemPage.isPageOpened(), "Popular Item Page was not opened!");
        itemPage.addItemToBasket();
        BasketPage basketPage = new BasketPage(getDriver());
        Assert.assertTrue(basketPage.isPageOpened(), "Basket Page was not opened!");
        Assert.assertEquals(basketPage.getItemName(), ITEM_EXPECTED,
                "The Item was not added to basket");
        basketPage.openBasketFromItemPage();
        Assert.assertTrue(basketPage.showSuccessOrderConfirmation(),
                "Adding item to basket was not success!");
    }
}
