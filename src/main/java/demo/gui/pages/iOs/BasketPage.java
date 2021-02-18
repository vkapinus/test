package demo.gui.pages.iOs;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import demo.gui.pages.common.BasketBasePage;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = BasketBasePage.class)
public class BasketPage extends BasketBasePage{

    @ExtendedFindBy( iosPredicate= "label == 'Оформить заказ'")
    private ExtendedWebElement orderButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[19]")
    private ExtendedWebElement itemName;

    @ExtendedFindBy( iosPredicate= "label == 'Войти >'")
    private ExtendedWebElement confirmOrder;

    @ExtendedFindBy( iosPredicate= "type == 'XCUIElementTypeSecureTextField'")
    private ExtendedWebElement deliveryInfoForm;

    public BasketPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(orderButton);
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