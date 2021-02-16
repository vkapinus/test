package demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ElementLoadingStrategy;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasketPage extends AbstractPage {

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

    public BasketPage openBasketFromItemPage() {
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