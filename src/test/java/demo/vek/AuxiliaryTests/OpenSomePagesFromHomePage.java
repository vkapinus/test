package demo.vek.AuxiliaryTests;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.pages.AllReviewsPage;
import demo.gui.pages.BasePage;
import demo.gui.pages.BasketPage;
import demo.vek.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenSomePagesFromHomePage extends BaseTest {

    @Test
    @MethodOwner(owner = "kapinus")
    public void testOpenNewsPage() {
        BasePage homePage = openHomePage(getDriver());
        AllReviewsPage reviewsPage = homePage.openReviews();
        Assert.assertTrue(reviewsPage.isPageOpened(), "News Page was not opened!");
    }

    @Test
    @MethodOwner(owner = "kapinus")
    public void testOpenBasketPage() {
        BasePage homePage = openHomePage(getDriver());
        BasketPage basketPage = homePage.openBasket();
        Assert.assertTrue(basketPage.isPageOpened(), "Basket Page was not opened!");
    }

    @Test
    @MethodOwner(owner = "kapinus")
    public void testOpenHomePage() {
        BasePage homePage = openHomePage(getDriver());
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    @MethodOwner(owner = "kapinus")
    public void testOpenAllReviewsPage() {
        BasePage homePage = openHomePage(getDriver());
        AllReviewsPage reviewsPage = homePage.openReviews();
        Assert.assertTrue(reviewsPage.isPageOpened(), "Reviews Page was not opened!");
    }

}
