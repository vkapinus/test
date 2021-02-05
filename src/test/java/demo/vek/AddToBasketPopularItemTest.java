package demo.vek;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.BasePage;
import demo.gui.pages.BasketPage;
import demo.gui.pages.PopularItemPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToBasketPopularItemTest extends BaseTest{

    private static final String ITEM_EXPECTED =
            "Термокружка 21vek 1186/7 (черный/красный)";

    @Test
    @MethodOwner(owner = "kapinus")
    public void testAddToBasketItem() {
        BasePage homePage = openHomePage(getDriver());
        Assert.assertTrue(homePage.isPageOpened(), "Home Page was not opened!");
        PopularItemPage itemPage = homePage.openItemFromPrimaryPane(ITEM_EXPECTED);
        Assert.assertTrue(itemPage.isPageOpened(), "Popular Item Page was not opened!");
        itemPage.addToBasket();
        BasketPage basketPage = new BasketPage(getDriver());
        Assert.assertTrue(basketPage.isPageOpened(), "Basket Page was not opened!");
        Assert.assertEquals(basketPage.getItemName(), ITEM_EXPECTED);
        basketPage.orderItem();
        Assert.assertTrue(basketPage.successAdding(), "Adding item to basket was not success!");
    }
}
