package demo.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ElementLoadingStrategy;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import demo.gui.pages.common.BasketBasePage;
import demo.gui.pages.common.PopularItemBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PopularItemBasePage.class)
public class PopularItemPage extends PopularItemBasePage {

    @FindBy(className = "pointer")
    ExtendedWebElement descriptionMenu;

    @FindBy(css = "meta[itemprop=name]")
    ExtendedWebElement itemName;

    @FindBy(className = "b-product__buy__button-wrap")
    private ExtendedWebElement inBasketButton;

    @FindBy(className = "mini-cart")
    private ExtendedWebElement basketButton;

    public PopularItemPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(descriptionMenu);
    }

    public BasketBasePage addItemToBasket() {
        inBasketButton.click();
        basketButton.click();
        return initPage(this.driver, BasketBasePage.class);
    }

    public String getItemName(){
        return itemName.getAttribute("content");
    }
}