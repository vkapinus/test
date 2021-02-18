package demo.gui.pages.iOs;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import demo.gui.pages.common.BasketBasePage;
import demo.gui.pages.common.PopularItemBasePage;
import demo.utils.MobileContextUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = PopularItemBasePage.class)
public class PopularItemPage extends PopularItemBasePage {


    @FindBy(xpath = "//div[@class='wrapper']/h1")
    ExtendedWebElement itemName;

    @ExtendedFindBy( iosPredicate= "label == 'В корзину'")
    private ExtendedWebElement inBasketButton;

    @ExtendedFindBy( iosPredicate= "label == 'В корзине'")
    private ExtendedWebElement basketButton;

    public PopularItemPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(itemName);
    }

    public BasketBasePage addItemToBasket() {
        MobileContextUtils contextHelper = new MobileContextUtils();
        contextHelper.switchMobileContext(MobileContextUtils.View.NATIVE);
        inBasketButton.click();
        basketButton.click();
        return initPage(this.driver, BasketBasePage.class);
    }

    public String getItemName(){
        return itemName.getText();
    }
}