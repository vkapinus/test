package demo.gui.components.compare;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import demo.gui.pages.BasePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NavigateMenuComponent extends AbstractUIObject {

    @FindBy(xpath = ".//dt[@class='navigationItem']/span")
    private ExtendedWebElement navigateMenuHeader;

    @FindBy(xpath = "//dd[@class='subnavDescription g-grouplinks__item']/a[text()='Одеяла']")
    private ExtendedWebElement navigateToProducts;

    public NavigateMenuComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public NavigateMenuComponent navigateMenuComponentForHome(){
        navigateMenuHeader.click();
        navigateToProducts.click();
        return this;
    }

    public String getName(){
        return navigateMenuHeader.getAttribute("data-ga_action");
    }

    public BasePage navigateTo(){
        navigateMenuHeader.click();
        return null;
    }



}
