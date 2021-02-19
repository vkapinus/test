package demo.vek;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.common.HomeBasePage;
import demo.gui.pages.common.BasketBasePage;
import demo.gui.pages.common.PopularItemBasePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddPopularItemToBasketTest extends AbstractTest {
    private static String ITEM_EXPECTED;

    @Test
    @MethodOwner(owner = "kapinus")
    public void testAddItemToBasket() {
        HomeBasePage homePage = initPage(getDriver(), HomeBasePage.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "21vek home page was not opened!");
        PopularItemBasePage itemPage = homePage.openItemFromPrimaryPane(ITEM_EXPECTED);
        Assert.assertTrue(itemPage.isPageOpened(), "Popular Item Page was not opened!");
        BasketBasePage basketPage =  itemPage.addItemToBasket();
        Assert.assertTrue(basketPage.isPageOpened(), "Basket Page was not opened!");
        Assert.assertTrue(basketPage.getItemName().contains(ITEM_EXPECTED),
                "The Item was not added to basket");
        basketPage.openBasketFromItemPage();
        Assert.assertTrue(basketPage.showSuccessOrderConfirmation(),
                "Adding item to basket was not successful!");
    }
}