package demo.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class PopularItemBasePage extends AbstractPage {

    public PopularItemBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract BasketBasePage addItemToBasket();
    public abstract String getItemName();

}