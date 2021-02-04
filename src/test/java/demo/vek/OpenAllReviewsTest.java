package demo.vek;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.AllReviewsPage;
import demo.gui.pages.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenAllReviewsTest extends BaseTest {

    @Test
    @MethodOwner(owner = "kapinus")
    public void testOpenNewsPage() {
        BasePage homePage = openHomePage(getDriver());
        AllReviewsPage reviewsPage = homePage.openReviews();
        Assert.assertTrue(reviewsPage.isPageOpened(), "News Page was not opened!");
    }
}