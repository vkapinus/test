package demo.vek;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigateMenuTest extends BaseTest{

    private static final String searchWord = "Спорт";

//    @Test
//    @MethodOwner(owner = "kapinus")
//    public void testNavigateMenuForHome() {
//        BasePage homePage = openHomePage(getDriver());
//        ResultSearchPage newPage  = homePage.navigateMenuForHome();
//        Assert.assertTrue(newPage.isPageOpened(), "Result Page was not opened!");
//    }

    @Test
    @MethodOwner(owner = "kapinus")
    public void testNavigateMenu() {
        BasePage homePage = openHomePage(getDriver());
        Assert.assertTrue(homePage.isPageOpened(), "Home Page was not opened!");
        homePage.openMenuItem(searchWord);

    }

}
