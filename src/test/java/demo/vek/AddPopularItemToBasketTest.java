package demo.vek;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.common.HomeBasePage;
import demo.gui.pages.common.BasketBasePage;
import demo.gui.pages.common.PopularItemBasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;


public class AddPopularItemToBasketTest extends AbstractTest {

    @Test
    @MethodOwner(owner = "kapinus")
    public void testAddItemToBasket() {
        HomeBasePage homePage = initPage(getDriver(), HomeBasePage.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "21vek home page was not opened!");
        int itemIndex = new Random().nextInt(homePage.getComponents().size() - 1);
        String expectedItemName = homePage.getNameByIndex(itemIndex);
        PopularItemBasePage itemPage = homePage.openPrimeryItem(expectedItemName);
        Assert.assertTrue(itemPage.isPageOpened(), "Popular Item Page was not opened!");
        BasketBasePage basketPage =  itemPage.addItemToBasket();
        Assert.assertTrue(basketPage.isPageOpened(), "Basket Page was not opened!");
        Assert.assertTrue(basketPage.getItemName().contains(expectedItemName),
                "The Item was not added to basket");
        basketPage.openBasketFromItemPage();
        Assert.assertTrue(basketPage.showSuccessOrderConfirmation(),
                "Adding item to basket was not successful!");
    }
}