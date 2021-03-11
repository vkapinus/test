package demo.vek;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.common.HomeBasePage;
import demo.gui.pages.common.SearchResultBasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class SearchTest extends AbstractTest {
    private static final String searchWord = "Утюг";

    @Test
    @MethodOwner(owner = "kapinus")
    public void testSearchProduct() {
        HomeBasePage homePage = initPage(getDriver(), HomeBasePage.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "21vek home page was not opened!");
        SearchResultBasePage searchPage = homePage.showSearchResult(searchWord);
        Assert.assertTrue(searchPage.isPageOpened(), "Result Search Page was not opened!");
        SoftAssert softAssert = new SoftAssert();
        List<String> productTitles = searchPage.getProductTitles();
        productTitles.forEach(e->softAssert.assertTrue(e.contains(searchWord),
                "The titles of the searched items and the title of the current item are not equals!"));
        softAssert.assertAll()
    }
}