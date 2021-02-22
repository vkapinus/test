package demo.gui.components.compare;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import demo.gui.pages.common.PopularItemBasePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PopularPrimeryComponent extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = ".//span[@class = 'foreign_goods__name']/a")
    private ExtendedWebElement titleLabel;

    @FindBy(css = "div>h3>a")
    private ExtendedWebElement titleLabelMobile;

    public PopularPrimeryComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getNamePopularItem() {
        if (R.CONFIG.get("platform").equals("android") |
                R.CONFIG.get("platform").equals("ios")) {
            return titleLabelMobile.getText();
        } else {
            return titleLabel.getAttribute("title");
        }
    }

    public PopularItemBasePage openPopularItemPage() {
        if (R.CONFIG.get("platform").equals("android") |
                R.CONFIG.get("platform").equals("ios")) {
            titleLabelMobile.click();
        } else {
            titleLabel.click();
        }
        return initPage(this.driver, PopularItemBasePage.class);
    }
}