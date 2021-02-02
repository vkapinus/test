package demo.gui.components.compare;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ReviewsComponent extends AbstractUIObject {

    @FindBy(xpath = ".//li[@class = 'reviews__item']")
    private ExtendedWebElement rewiewsComponent;

    public ReviewsComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}