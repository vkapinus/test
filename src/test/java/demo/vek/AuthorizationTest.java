package demo.vek;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.common.HomeBasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorizationTest extends AbstractTest {

    @Test
    @MethodOwner(owner = "kapinus")
    public void testAuthorization() {
        HomeBasePage homePage = initPage(getDriver(), HomeBasePage.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "21vek home page was not opened!");
        homePage.authorization(R.TESTDATA.get("email"), R.TESTDATA.get("pass"));
        Assert.assertEquals(homePage.getUserEmail(), R.TESTDATA.get("email"),
                "Authorization was not successful!");
    }
}