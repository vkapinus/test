package demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasketPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasketPage.class);

    @FindBy(xpath = "//h2[@class='content__header']")
    private ExtendedWebElement contentHeader;

    @FindBy(id = "j-basket__ok")
    private ExtendedWebElement orderButton;

    @FindBy(xpath = "//td[@class='g-table-cell basket__item cr-basket__name']/a")
    private ExtendedWebElement itemName;

    @FindBy(id = "j-basket__confirm")
    private ExtendedWebElement confirmOrder;

    @FindBy(xpath = "//div[@class='b-order cr-order__delivery']")
    private ExtendedWebElement deliveryInfoForm;

    public BasketPage(WebDriver driver) {
        super(driver);

    }

    public boolean isPageOpened(PageOpeningStrategy byElement) {
        return orderButton.isPresent() && contentHeader.isPresent();
    }

    public BasketPage orderItem(){
        orderButton.click();
        return new BasketPage(this.driver);
    }

    public String getItemName() {
        return itemName.getText();
    }

    public boolean validateOrderConfirmationIsShown(){
        return deliveryInfoForm.isPresent() && confirmOrder.isPresent();
    }
}