package demo.gui.components.compare;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import demo.gui.pages.NewsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NewsComponent extends AbstractUIObject {

    @FindBy(xpath = ".//div[@class='sidebar__header']")
    private ExtendedWebElement newsLabel;

    public NewsComponent(WebDriver driver) {
        super(driver);
    }

    public NewsPage navigateTo() {
        newsLabel.assertElementPresent(30);
        newsLabel.click();
        return new NewsPage(this.driver);
    }

}
