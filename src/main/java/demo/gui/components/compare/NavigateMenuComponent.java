package demo.gui.components.compare;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import demo.gui.pages.BasePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavigateMenuComponent extends AbstractUIObject {

    @FindBy(xpath = ".//span[@class='pseudoLink pseudoLinkNav']")
    private ExtendedWebElement navigateMenuHeader;

    @FindBy(xpath = "//dd[@class='subnavDescription g-grouplinks__item']/a")
    private List<ExtendedWebElement> navigateCategoryProducts;

    public NavigateMenuComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getNameCategory(){
        return navigateMenuHeader.getText();
    }

    public BasePage navigateToMenu(){
        navigateMenuHeader.click();
        return new BasePage(this.driver);
    }

    public String getNameMenuHeader(){
        return navigateMenuHeader.getText();
    }
}