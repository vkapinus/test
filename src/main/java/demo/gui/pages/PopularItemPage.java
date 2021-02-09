package demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ElementLoadingStrategy;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PopularItemPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(PopularItemPage.class);

    @FindBy(className = "item-buy")
    private ExtendedWebElement inBasketButton;

    @FindBy(css = "div[class~=b-info]")
    private ExtendedWebElement descriptionMenu;

    @FindBy(className = "headerCart")
    private ExtendedWebElement basketButton;

    public PopularItemPage(WebDriver driver) {
        super(driver);
        setLoadingStrategy(ElementLoadingStrategy.BY_PRESENCE);
        setUiLoadedMarker(descriptionMenu);
    }


    public BasketPage addItemToBasket(){
        inBasketButton.click();
        basketButton.click();
        return new BasketPage(driver);
    }
}