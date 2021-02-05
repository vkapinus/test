package demo.vek.AuxiliaryTests;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.BasePage;
import demo.vek.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubscribeToNewsTest extends BaseTest {

    private static final String email = "random@gmail.com";
    @Test
    @MethodOwner(owner = "kapinus")
    public void testSubscribeToNews() {
        BasePage homePage = openHomePage(getDriver());
        BasePage newPage  = homePage.subscribeToNews(email);
        Assert.assertTrue(newPage.isPageOpened(), "Home Page was not opened!");
    }
}