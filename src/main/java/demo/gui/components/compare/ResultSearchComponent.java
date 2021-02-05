package demo.gui.components.compare;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import demo.gui.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ResultSearchComponent extends AbstractUIObject {

    @FindBy(xpath = ".//span[@class='result__name']")
    private ExtendedWebElement resultItem;

    public ResultSearchComponent(WebDriver driver) {
        super(driver);
    }

    public String getName() {
        return resultItem.getText();
    }

    public ProductPage navigateTo() {
        resultItem.assertElementPresent(30);
        resultItem.click();
        return new ProductPage(this.driver);
    }
}
