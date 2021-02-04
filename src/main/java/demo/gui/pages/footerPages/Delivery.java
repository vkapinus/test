package demo.gui.pages.footerPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Delivery extends AbstractPage {

    @FindBy(xpath = ".//h1[@class='content__header']")
    private ExtendedWebElement deliveryHeader;

    public Delivery(WebDriver driver) {
        super(driver);
      }

    @Override
    public boolean isPageOpened() {
        return deliveryHeader.isPresent();
    }
}
