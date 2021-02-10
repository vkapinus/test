package demo.vek;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.HomePage;
import demo.gui.pages.PopularItemPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PopularItemTest extends AbstractTest {
    private static final String ITEM_EXPECTED =
            "Фитнес-трекер Xiaomi Mi Smart Band 5 / BHR4219RU";

    @Test
    @MethodOwner(owner = "kapinus")
    public void testOpenItem() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "21vek home page was not opened!");
        PopularItemPage itemPage = homePage.openItemFromPrimaryPane(ITEM_EXPECTED);
        Assert.assertTrue(itemPage.isPageOpened(), "Popular Item Page was not opened!");
    }
}