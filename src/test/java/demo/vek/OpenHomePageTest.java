package demo.vek;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenHomePageTest extends BaseTest{
    @Test
    @MethodOwner(owner = "kapinus")
    public void testOpenPage() {
        BasePage homePage = openHomePage(getDriver());
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }
}