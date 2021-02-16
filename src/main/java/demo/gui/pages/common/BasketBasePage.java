package demo.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class BasketBasePage extends AbstractPage {

    public BasketBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract BasketBasePage openBasketFromItemPage();
    public abstract String getItemName();
    public abstract boolean showSuccessOrderConfirmation();

}