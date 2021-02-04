package demo.vek;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.BasePage;
import demo.gui.pages.BasketPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenBasketPageTest extends BaseTest{

    @Test
    @MethodOwner(owner = "kapinus")
    public void testOpenBasketPage() {
        BasePage homePage = openHomePage(getDriver());
        BasketPage basketPage = homePage.openBasket();
        Assert.assertTrue(basketPage.isPageOpened(), "Basket Page was not opened!");
    }
}