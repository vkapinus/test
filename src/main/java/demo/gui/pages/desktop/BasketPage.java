package demo.gui.pages.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ElementLoadingStrategy;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import demo.gui.pages.common.BasketBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = BasketBasePage.class)
public class BasketPage extends BasketBasePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasketPage.class);

    @FindBy(className = "content__header")
    private ExtendedWebElement contentHeader;

    @FindBy(id = "j-basket__ok")
    private ExtendedWebElement orderButton;

    @FindBy(css = "td[class~=cr-basket__name]>a")
    private ExtendedWebElement itemName;

    @FindBy(id = "j-basket__confirm")
    private ExtendedWebElement confirmOrder;

    @FindBy(className = "b-order")
    private ExtendedWebElement deliveryInfoForm;

    public BasketPage(WebDriver driver) {
        super(driver);
        setLoadingStrategy(ElementLoadingStrategy.BY_PRESENCE);
        setUiLoadedMarker(contentHeader);
    }

    public BasketBasePage openBasketFromItemPage() {
        orderButton.click();
        return this;
    }

    public String getItemName() {
        return itemName.getText();
    }

    public boolean showSuccessOrderConfirmation(){
        return deliveryInfoForm.isPresent() && confirmOrder.isPresent();
    }
}