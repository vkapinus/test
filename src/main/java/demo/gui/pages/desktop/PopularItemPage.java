package demo.gui.pages.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ElementLoadingStrategy;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import demo.gui.pages.common.BasketBasePage;
import demo.gui.pages.common.PopularItemBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = PopularItemBasePage.class)
public class PopularItemPage extends PopularItemBasePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(PopularItemPage.class);

    @FindBy(className = "item-buy")
    private ExtendedWebElement inBasketButton;

    @FindBy(xpath = "//div[@class='content__header']/h1")
    private ExtendedWebElement itemName;

    @FindBy(css = "div[class~=b-info]")
    private ExtendedWebElement descriptionMenu;

    @FindBy(className = "headerCart")
    private ExtendedWebElement basketButton;

    public PopularItemPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(descriptionMenu);
    }

    public BasketBasePage addItemToBasket(){
        inBasketButton.click();
        basketButton.click();
        return initPage(this.driver, BasketBasePage.class);
    }

    public String getItemName(){
        return itemName.getText();
    }
}