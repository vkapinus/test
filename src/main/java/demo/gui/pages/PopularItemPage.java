package demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PopularItemPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(PopularItemPage.class);

    @FindBy(xpath = ".//button[@class = 'g-button g-buybtn item__buybtn cr-buybtn__in j-ga_track']")
    private ExtendedWebElement basketButton;

    @FindBy(xpath = ".//div[@class = 'tabs__switcher']/span")
    private ExtendedWebElement rewiewsButton;

    public PopularItemPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return basketButton.isPresent();
    }

}