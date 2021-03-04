package demo.vek;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.common.HomeBasePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AuthorizationTest extends AbstractTest {


    String email = "parvikus@gmail.com";
    String pass = "Vikadima1307";

    @Parameters({"browserName"})
    @Test
    @MethodOwner(owner = "kapinus")
    public void testAuthorization(String browserName){
        HomeBasePage homePage = initPage(getDriver(browserName), HomeBasePage.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "21vek home page was not opened!");
        homePage.authorization(email, pass);
        Assert.assertEquals(homePage.getUserEmail(), email,
                "Authorization was not successful");
    }
}