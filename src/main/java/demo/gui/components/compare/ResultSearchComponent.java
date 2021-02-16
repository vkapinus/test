package demo.gui.components.compare;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ResultSearchComponent extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(className = "result__name")
    private ExtendedWebElement resultItem;

    @FindBy(css="div>h3>a")
    private ExtendedWebElement resultItemAndroid;

    public ResultSearchComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getNameItem() {

        if (R.CONFIG.get("platform").equals("android")){
            return resultItemAndroid.getText();
        } else {
            return resultItem.getText();
        }
    }

}