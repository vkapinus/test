package demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewsPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(NewsPage.class);

    @FindBy(xpath = ".//h1[@class='content__header']")
    private ExtendedWebElement header;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return header.isPresent();
    }

}
