package demo.gui.components.compare;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ResultSearchComponent extends AbstractUIObject {

    @FindBy(xpath = ".//span[@class='result__name']")
    private ExtendedWebElement resultItem;

    public ResultSearchComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getName() {
        return resultItem.getText();
    }

}
