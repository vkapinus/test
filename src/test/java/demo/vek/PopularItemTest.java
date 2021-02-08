package demo.vek;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.BasePage;
import demo.gui.pages.PopularItemPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy.BY_ELEMENT;


public class PopularItemTest extends AbstractTest {
    private static final String ITEM_EXPECTED =
            "Фитнес-трекер Xiaomi Mi Smart Band 5 / BHR4219RU";

    @Test
    @MethodOwner(owner = "kapinus")
    public void testOpenItem() {
        BasePage homePage = new BasePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "21vek home page was not opened!");
        PopularItemPage itemPage = homePage.openItemFromPrimaryPane(ITEM_EXPECTED);
        Assert.assertTrue(itemPage.isPageOpened(BY_ELEMENT), "Popular Item Page was not opened!");
    }
}