package demo.gui.components.compare;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import demo.gui.pages.common.SearchResultBasePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchFieldComponent extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(id = "j-search")
    private ExtendedWebElement searchInput;

    @FindBy(css = "input[type= submit]")
    private ExtendedWebElement openSearchInputMobile;

    @FindBy(name = "sa")
    private ExtendedWebElement searchButton;

    public SearchFieldComponent(WebDriver driver, SearchContext context){
        super(driver, context);
    }

    public SearchFieldComponent fillSearch(String query) {
        if (R.CONFIG.get("platform").equals("android") |
                R.CONFIG.get("platform").equals("ios")){
            openSearchInputMobile.click();
            searchInput.type(query);
        } else {
            searchInput.type(query);
        }
        return this;
    }

    public SearchResultBasePage submitSearch() {
        searchButton.click();
        return initPage(this.driver, SearchResultBasePage.class);
    }
}