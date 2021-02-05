package demo.vek;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorizationTest extends BaseTest{

    private static final String email = "parvikus@gmail.com";
    private static final String pass = "Vikadima1307";

    @Test
    @MethodOwner(owner = "kapinus")
    public void testAuthorization() {
        BasePage homePage = openHomePage(getDriver());
        BasePage newPage  = homePage.authorization(email, pass);
        Assert.assertTrue(newPage.isPageOpened(), "Home Page was not opened!");
        Assert.assertEquals(homePage.getEmail(), email);
    }
}
