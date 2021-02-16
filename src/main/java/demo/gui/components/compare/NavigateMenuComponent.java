package demo.gui.components.compare;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NavigateMenuComponent extends AbstractUIObject {

    @FindBy(css = "span[class~=navigationLink]>span")
    private ExtendedWebElement sectionHeader;

    @FindBy(xpath = "//ul[@class='menu menu-top']/li/a[@class='top-level']")
    private ExtendedWebElement navigateMenuHeaderAndroid;

    public NavigateMenuComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getNameMenuHeader(){
        if (R.CONFIG.get("platform").equals("android")) {
            return navigateMenuHeaderAndroid.getText();
        } else {
            return sectionHeader.getText();
        }
    }

    public NavigateMenuComponent showMenuOptions(){
        if (R.CONFIG.get("platform").equals("android")) {
            navigateMenuHeaderAndroid.click();
        } else {
            sectionHeader.click();
        }
        return this;
    }
}