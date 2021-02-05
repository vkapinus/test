package demo.vek.AuxiliaryTests;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.BasePage;
import demo.gui.pages.BonusProgramPage;
import demo.vek.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BonusProgramPageTest extends BaseTest {

    @Test
    @MethodOwner(owner = "kapinus")
    public void testOpenNewsPage() {
        BasePage homePage = openHomePage(getDriver());
        BonusProgramPage bonusProgramPage = homePage.openBonusPage();
        Assert.assertTrue(bonusProgramPage.isPageOpened(), "Bonus Program Page was not opened!");
    }
}