package demo.gui.components.compare;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import demo.gui.pages.PopularItemPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PopularPrimeryComponent extends AbstractUIObject {


    @FindBy(xpath = ".//span[@class = 'foreign_goods__name']/a")
    private ExtendedWebElement titleLabel;

    public PopularPrimeryComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getName() {
        titleLabel.assertElementPresent(30);
        return titleLabel.getAttribute("title");
    }

    public PopularItemPage navigateTo() {
        titleLabel.assertElementPresent(30);
        titleLabel.click();
        return new PopularItemPage(this.driver);
    }

}