package demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PopularItemPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(PopularItemPage.class);

    @FindBy(xpath = ".//button[@class = 'g-button g-buybtn item__buybtn cr-buybtn__in j-ga_track']")
    private ExtendedWebElement inBasketButton;

    @FindBy(xpath = "//div[@class='b-info cr-info-attrs']")
    private ExtendedWebElement descriptionMenu;

    @FindBy(xpath = ".//div[@class = 'tabs__switcher']/span")
    private ExtendedWebElement rewiewsButton;

    @FindBy(xpath = "//div[@class='headerCart']")
    private ExtendedWebElement basketButton;

    @FindBy(xpath = "//span[text() = 'Отзывы']")
    private ExtendedWebElement reviewLabel;

    @FindBy(xpath = "//button[@class = 'g-button']")
    private ExtendedWebElement addReview;

    public PopularItemPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return inBasketButton.isPresent() && descriptionMenu.isPresent();
    }



    public PopularItemPage addToBasket(){
        inBasketButton.click();
        basketButton.click();
        return this;
    }

    public PopularItemPage addReview(){
        reviewLabel.click();
        addReview.click();
        return this;
    }
}