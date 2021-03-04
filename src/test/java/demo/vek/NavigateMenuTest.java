package demo.vek;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.common.HomeBasePage;
import demo.gui.pages.common.SearchResultBasePage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NavigateMenuTest extends AbstractTest{

    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "xls/navigate.xlsx", sheet = "Navigate", dsUid = "TUID",
            dsArgs = "sectionName, categoryName, productsName")
    @MethodOwner(owner = "kapinus")
    public void testNavigateMenu( String sectionName, String categoryName, String productsName) {
        HomeBasePage homePage = initPage(getDriver(), HomeBasePage.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "21vek home page was not opened!");
        homePage.openMenuItem(sectionName);
        homePage.openCategoryItem(categoryName);
        SearchResultBasePage resultSearchPage = homePage.openProductsFromNavigateMenu(productsName);
        Assert.assertTrue(resultSearchPage.isPageOpened(), "Search Page was not opened!");
        Assert.assertTrue(resultSearchPage.getHeader().contains(productsName),
                "Item does not belong to the selected category");
    }
}