package demo.vek;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.common.HomeBasePage;
import demo.gui.pages.common.PopularItemBasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PopularItemTest extends AbstractTest {
    private static final String ITEM_EXPECTED =
            "Напольные весы электронные Xiaomi Mi Smart Scale 2 White / NUN4056GL (XMTZC04HM)";

    @Test
    @MethodOwner(owner = "kapinus")
    public void testOpenItem() {
        HomeBasePage homePage = initPage(getDriver(), HomeBasePage.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "21vek home page was not opened!");
        PopularItemBasePage itemPage = homePage.openItemFromPrimaryPane(ITEM_EXPECTED);
        Assert.assertTrue(itemPage.isPageOpened(), "Popular Item Page was not opened!");
        Assert.assertTrue(itemPage.getItemName().contains(ITEM_EXPECTED),
                "The title of the searched item and the title of the current item are not equals");
    }
}