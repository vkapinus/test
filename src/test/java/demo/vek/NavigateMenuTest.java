package demo.vek;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.BasePage;
import demo.gui.pages.ResultSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy.BY_ELEMENT;

public class NavigateMenuTest extends AbstractTest{
    private static final String sectionName = "Для кухни";
    private static final String categoryName = "Тостеры";

    @Test
    @MethodOwner(owner = "kapinus")
    public void testNavigateMenu() {
        BasePage homePage = new BasePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "21vek home page was not opened!");
        homePage.openMenuItem(sectionName);
        ResultSearchPage resultSearchPage = homePage.openCategoryProducts(categoryName);
        Assert.assertTrue(resultSearchPage.isPageOpened(BY_ELEMENT), "Search Page was not opened!");
        Assert.assertEquals(categoryName, resultSearchPage.getHeader(),
                "Item does not belong to the selected category");
    }

}
