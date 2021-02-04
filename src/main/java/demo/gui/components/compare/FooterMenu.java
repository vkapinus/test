package demo.gui.components.compare;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import demo.gui.pages.footerPages.*;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FooterMenu extends AbstractUIObject {

    @FindBy(linkText = "Оплата")
    private ExtendedWebElement orderLink;

    @FindBy(linkText = "Доставка")
    private ExtendedWebElement deliveryLink;

    @FindBy(linkText = "Самовывоз")
    private ExtendedWebElement selfDeliveryLink;

    @FindBy(linkText = "Страхование")
    private ExtendedWebElement insuranceLink;

    @FindBy(linkText = "Договор публичной оферты")
    private ExtendedWebElement publicOfferLink;

    @FindBy(linkText = "Контакты")
    private ExtendedWebElement contactsLink;

    @FindBy(linkText = "Отзывы")
    private ExtendedWebElement reviewsLink;

    public FooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public Contacts openContactsPage() {
        contactsLink.click();
        return new Contacts(driver);
    }

    public Delivery openDeliveryPage() {
        deliveryLink.click();
        return new Delivery(driver);
    }

    public Insurance openInsurancePage() {
        insuranceLink.click();
        return new Insurance(driver);
    }

    public Order openOrderPage() {
        orderLink.click();
        return new Order(driver);
    }

    public PublicOffer openPublicOfferPage() {
        publicOfferLink.click();
        return new PublicOffer(driver);
    }

    public Reviews openReviewsPage() {
        reviewsLink.click();
        return new Reviews(driver);
    }

    public SelfDelivery openSelfDeliveryPage() {
        selfDeliveryLink.click();
        return new SelfDelivery(driver);
    }
}