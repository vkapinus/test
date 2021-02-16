package demo.vek;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.common.HomeBasePage;
import demo.gui.pages.common.PopularItemBasePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PopularItemTest extends AbstractTest {
    private static final String ITEM_EXPECTED =
            "Наушники-гарнитура Xiaomi Mi True Wireless Earbuds Basic 2 / BHR4272GL/TWSEJ061LS (черный)";

    @Test
    @MethodOwner(owner = "kapinus")
    public void testOpenItemP() {
        HomeBasePage homePage = initPage(getDriver(), HomeBasePage.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "21vek home page was not opened!");
        PopularItemBasePage itemPage = homePage.openItemFromPrimaryPane(ITEM_EXPECTED);
        Assert.assertTrue(itemPage.isPageOpened(), "Popular Item Page was not opened!");
        Assert.assertEquals(itemPage.getItemName(), ITEM_EXPECTED,
                "The title of the searched item and the title of the current item are not equals");
    }
}