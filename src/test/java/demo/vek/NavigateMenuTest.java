package demo.vek;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.common.HomeBasePage;
import demo.gui.pages.common.SearchResultBasePage;

import demo.utils.MobileContextUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigateMenuTest extends AbstractTest{
    private static final String sectionName = "Для кухни";
    private static final String categoryName = "Мелкая техника";
    private static final String productsName = "Тостеры";

    @Test
    @MethodOwner(owner = "kapinus")
    public void testNavigateMenu() {
        HomeBasePage homePage = initPage(getDriver(), HomeBasePage.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "21vek home page was not opened!");
        homePage.openMenuItem(sectionName);
        homePage.openCategoryItem(categoryName);
        SearchResultBasePage resultSearchPage = homePage.openProductsFromNavigateMenu(productsName);
        Assert.assertTrue(resultSearchPage.isPageOpened(), "Search Page was not opened!");
        Assert.assertTrue(resultSearchPage.getHeader().contains(productsName),
                "Item does not belong to the selected category");
    }
}