package demo.vek;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.BasePage;
import demo.gui.pages.ResultSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest{
    private static final String searchWord = "Утюг";

    @Test
    @MethodOwner(owner = "kapinus")
    public void testSearchProduct() {
        BasePage homePage = openHomePage(getDriver());
        Assert.assertTrue(homePage.isPageOpened(), "Home Page was not opened!");
        ResultSearchPage searchPage = homePage.getResultSearch(searchWord);
        Assert.assertTrue(searchPage.isPageOpened(), "Result Search Page was not opened!");
        searchPage.searchWordEqualsItems(searchWord);
    }
}