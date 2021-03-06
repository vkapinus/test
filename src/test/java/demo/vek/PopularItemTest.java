package demo.vek;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.common.HomeBasePage;
import demo.gui.pages.common.PopularItemBasePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.Random;

public class PopularItemTest extends AbstractTest {

    @Test
    @Parameters({"browserName"})
    @MethodOwner(owner = "kapinus")
    public void testOpenItem(String browserName) {
        HomeBasePage homePage = initPage(getDriver(browserName), HomeBasePage.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "21vek home page was not opened!");
        int itemIndex = new Random().nextInt(homePage.getComponents().size() - 1);
        String expectedItemName = homePage.getNameByIndex(itemIndex);
        PopularItemBasePage itemPage = homePage.openPrimeryItem(expectedItemName);
        Assert.assertTrue(itemPage.isPageOpened(), "Popular Item Page was not opened!");
        Assert.assertTrue(itemPage.getItemName().contains(expectedItemName),
                "The title of the searched item and the title of the current item are not equals");
    }
}