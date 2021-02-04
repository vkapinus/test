package demo.gui.components.compare;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import demo.gui.pages.BonusProgramPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BonusProgramComponent extends AbstractUIObject {

    @FindBy(xpath = ".//div[@class='b-sidebar b-tizer']/a[@class]")
    private ExtendedWebElement bonusLabel;

    public BonusProgramComponent(WebDriver driver) {
        super(driver);
    }

    public BonusProgramPage navigateTo() {
        bonusLabel.assertElementPresent(30);
        bonusLabel.click();
        return new BonusProgramPage(this.driver);
    }
}