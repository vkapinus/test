package demo.gui.components.compare;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NavigateMenuComponent extends AbstractUIObject {

    @FindBy(css = "span[class~=navigationLink]>span")
    private ExtendedWebElement sectionHeader;

    public NavigateMenuComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getNameMenuHeader(){
        return sectionHeader.getText();
    }

    public NavigateMenuComponent showMenuOptions(){
        sectionHeader.click();
        return this;
    }
}