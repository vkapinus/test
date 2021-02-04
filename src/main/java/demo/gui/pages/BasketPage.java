package demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasketPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasketPage.class);

    @FindBy(id = "content")
    private ExtendedWebElement order;

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return order.isPresent();
    }

}