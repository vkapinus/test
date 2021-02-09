package demo.vek;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.HomePage;
import demo.gui.pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy.BY_ELEMENT;

public class NavigateMenuTest extends AbstractTest{
    private static final String sectionName = "Для кухни";
    private static final String categoryName = "Тостеры";

    @Test
    @MethodOwner(owner = "kapinus")
    public void testNavigateMenu() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "21vek home page was not opened!");
        homePage.openMenuItem(sectionName);
        SearchResultPage resultSearchPage = homePage.openCategoryProducts(categoryName);
        Assert.assertTrue(resultSearchPage.isPageOpened(), "Search Page was not opened!");
        Assert.assertEquals(categoryName, resultSearchPage.getHeader(),
                "Item does not belong to the selected category");
    }

}
