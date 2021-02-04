package demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResultSearchPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResultSearchPage.class);

    @FindBy(xpath = ".//h1[@class='content__header cr-category_header']")
    private ExtendedWebElement resultHeader;

    public ResultSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return resultHeader.isPresent();
    }

}