package demo.vek;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.BasePage;
import demo.gui.pages.ResultSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy.BY_ELEMENT;


public class SearchTest extends AbstractTest {
    private static final String searchWord = "Утюг";
    private static final int index = 0;

    @Test
    @MethodOwner(owner = "kapinus")
    public void testSearchProduct() {
        BasePage homePage = new BasePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "21vek home page was not opened!");
        ResultSearchPage searchPage = homePage.getResultSearch(searchWord);
        Assert.assertTrue(searchPage.isPageOpened(BY_ELEMENT), "Result Search Page was not opened!");
        String itemName = searchPage.getItemByIndex(index).getName();
        Assert.assertTrue(itemName.contains(searchWord), "Product item's name was not contain searchWord");
    }
}