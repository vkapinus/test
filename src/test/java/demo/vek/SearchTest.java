package demo.vek;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.HomePage;
import demo.gui.pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class SearchTest extends AbstractTest {
    private static final String searchWord = "Утюг";

    @Test
    @MethodOwner(owner = "kapinus")
    public void testSearchProduct() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "21vek home page was not opened!");
        SearchResultPage searchPage = homePage.showSearchResult(searchWord);
        Assert.assertTrue(searchPage.isPageOpened(), "Result Search Page was not opened!");
        List<String> productTitles = searchPage.getProductTitles();
        productTitles.forEach(e->Assert.assertTrue(e.contains(searchWord),
                "Product was not found"));
    }
}