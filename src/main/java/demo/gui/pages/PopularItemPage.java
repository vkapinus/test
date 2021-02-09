package demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PopularItemPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(PopularItemPage.class);

    @FindBy(xpath = "//button[contains(@class, 'g-button g-buybtn')]")
    private ExtendedWebElement inBasketButton;

    @FindBy(xpath = "//div[@class='b-info cr-info-attrs']")
    private ExtendedWebElement descriptionMenu;

    @FindBy(xpath = ".//div[@class = 'tabs__switcher']/span")
    private ExtendedWebElement rewiewsButton;

    @FindBy(xpath = "//div[@class='headerCart']")
    private ExtendedWebElement basketButton;


    public PopularItemPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened(PageOpeningStrategy byElement) {
        return inBasketButton.isPresent() && descriptionMenu.isPresent();
    }

    public BasketPage addToBasket(){
        inBasketButton.click();
        basketButton.click();
        return new BasketPage(driver);
    }
}