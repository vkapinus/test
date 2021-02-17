package demo.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ElementLoadingStrategy;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import demo.gui.pages.common.BasketBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BasketBasePage.class)
public class BasketPage extends BasketBasePage{

    @FindBy(css = "h1")
    private ExtendedWebElement contentHeader;

    @FindBy(id = "j-basket__ok")
    private ExtendedWebElement orderButton;

    @FindBy(css = "div>h3>a")
    private ExtendedWebElement itemName;

    @FindBy(css = "button[type=submit]")
    private ExtendedWebElement confirmOrder;

    @FindBy(className = "wrapper")
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