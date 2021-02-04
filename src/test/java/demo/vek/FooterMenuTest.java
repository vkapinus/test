package demo.vek;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import demo.gui.components.compare.FooterMenu;
import demo.gui.pages.BasePage;
import demo.gui.pages.footerPages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FooterMenuTest extends BaseTest{

    @Test
    @MethodOwner(owner = "kapinus")
    public void testOpenContactsPage() {
        BasePage homePage = openHomePage(getDriver());
        FooterMenu footerMenu = homePage.getFooterMenu();
        Contacts contacts = footerMenu.openContactsPage();
        Assert.assertTrue(contacts.isPageOpened(), "Contacts Page was not opened!");
    }

    @Test
    @MethodOwner(owner = "kapinus")
    public void testOpenDeliveryPage() {
        BasePage homePage = openHomePage(getDriver());
        FooterMenu footerMenu = homePage.getFooterMenu();
        Delivery delivery = footerMenu.openDeliveryPage();
        Assert.assertTrue(delivery.isPageOpened(), "Delivery Page was not opened!");
    }

    @Test
    @MethodOwner(owner = "kapinus")
    public void testOpenInsurancePage() {
        BasePage homePage = openHomePage(getDriver());
        FooterMenu footerMenu = homePage.getFooterMenu();
        Insurance insurance = footerMenu.openInsurancePage();
        Assert.assertTrue(insurance.isPageOpened(), "Insurance Page was not opened!");
    }

    @Test
    @MethodOwner(owner = "kapinus")
    public void testOpenOrderPage() {
        BasePage homePage = openHomePage(getDriver());
        FooterMenu footerMenu = homePage.getFooterMenu();
        Order order = footerMenu.openOrderPage();
        Assert.assertTrue(order.isPageOpened(), "Order Page was not opened!");
    }

    @Test
    @MethodOwner(owner = "kapinus")
    public void testOpenPublicOfferPage() {
        BasePage homePage = openHomePage(getDriver());
        FooterMenu footerMenu = homePage.getFooterMenu();
        PublicOffer publicOffer = footerMenu.openPublicOfferPage();
        Assert.assertTrue(publicOffer.isPageOpened(), "PublicOffer Page was not opened!");
    }

    @Test
    @MethodOwner(owner = "kapinus")
    public void testOpenReviewsPage() {
        BasePage homePage = openHomePage(getDriver());
        FooterMenu footerMenu = homePage.getFooterMenu();
        Reviews reviews = footerMenu.openReviewsPage();
        Assert.assertTrue(reviews.isPageOpened(), "Reviews Page was not opened!");
    }

    @Test
    @MethodOwner(owner = "kapinus")
    public void testOpenSelfDeliveryPage() {
        BasePage homePage = openHomePage(getDriver());
        FooterMenu footerMenu = homePage.getFooterMenu();
        SelfDelivery selfDelivery = footerMenu.openSelfDeliveryPage();
        Assert.assertTrue(selfDelivery.isPageOpened(), "SelfDelivery Page was not opened!");
    }

}