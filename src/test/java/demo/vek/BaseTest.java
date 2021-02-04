package demo.vek;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import demo.gui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BaseTest extends AbstractTest {

    protected BasePage openHomePage(WebDriver driver) {
        BasePage homePage = new BasePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "21vek home page was not opened!");
        return homePage;
    }
}