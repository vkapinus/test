package demo.vek;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.BasePage;
import demo.gui.pages.NewsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenNewsPageTest extends BaseTest{

    @Test
    @MethodOwner(owner = "kapinus")
    public void testOpenNewsPage() {
        BasePage homePage = openHomePage(getDriver());
        NewsPage newsPage = homePage.openNews();
        Assert.assertTrue(newsPage.isPageOpened(), "Item Page was not opened!");
    }
}
