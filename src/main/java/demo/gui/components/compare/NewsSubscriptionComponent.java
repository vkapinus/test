package demo.gui.components.compare;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NewsSubscriptionComponent extends AbstractUIObject {

    @FindBy(xpath = "//input[@class='react-input__input react-subscription-form__input']")
    private ExtendedWebElement emailInput;

    public NewsSubscriptionComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void activate(){
        emailInput.click();
    }

    public NewsSubscriptionComponent setEmailInput(String query) {
        emailInput.type(query);
        return this;
    }
}