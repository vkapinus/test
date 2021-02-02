package demo.gui.components.compare;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import demo.gui.pages.AllReviewsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AllReviewsComponent extends AbstractUIObject {

    @FindBy(xpath = ".//a[@class = 'best_review__more_link']")
    private ExtendedWebElement allReviewsLabel;

    public AllReviewsComponent(WebDriver driver) {
        super(driver);
    }

    public AllReviewsPage navigateTo() {
        allReviewsLabel.assertElementPresent(30);
        allReviewsLabel.click();
        return new AllReviewsPage(this.driver);
    }

}
