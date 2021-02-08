package demo.gui.components.compare;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import demo.gui.pages.BasketPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BasketComponent extends AbstractUIObject {

    @FindBy(xpath = ".//span[@class = 'headerCartLabel']")
    private ExtendedWebElement basketLabel;

    public BasketComponent(WebDriver driver) {
        super(driver);
    }

    public BasketPage openBasket() {
        basketLabel.click();
        return new BasketPage(this.driver);
    }
}