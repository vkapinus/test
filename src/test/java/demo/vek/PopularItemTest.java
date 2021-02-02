package demo.vek;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.BasePage;
import demo.gui.pages.PopularItemPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PopularItemTest extends BaseTest{
    private static final String ITEM_EXPECTED =
            "Наушники-гарнитура Xiaomi Mi True Wireless Earbuds Basic 2 / BHR4272GL/TWSEJ061LS (черный)";

    @Test(description = "The proper item opened correct")
    @MethodOwner(owner = "kapinus")
    public void testOpenItem() {
        BasePage homePage = openHomePage(getDriver());
        PopularItemPage itemPage = homePage.openItemFromPrimaryPane(ITEM_EXPECTED);
        Assert.assertTrue(itemPage.isPageOpened(), "Item Page was not opened!");
    }
}
