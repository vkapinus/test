package demo.vek;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.BasePage;
import demo.gui.pages.BonusProgramPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BonusProgramPageTest extends BaseTest {
    @Test
    @MethodOwner(owner = "kapinus")
    public void testOpenNewsPage() {
        BasePage homePage = openHomePage(getDriver());
        BonusProgramPage bonusProgramPage = homePage.openBonusPage();
        Assert.assertTrue(bonusProgramPage.isPageOpened(), "Item Page was not opened!");
    }
}
