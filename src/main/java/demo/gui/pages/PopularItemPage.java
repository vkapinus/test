package demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import demo.gui.components.compare.ReviewsComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PopularItemPage extends AbstractPage {


    @FindBy(xpath = ".//button[@class = 'g-button g-buybtn item__buybtn cr-buybtn__in j-ga_track']")
    private ExtendedWebElement basketButton;

    @FindBy(xpath = ".//div[@class = 'tabs__switcher']/span")
    private ExtendedWebElement rewiewsButton;

    @FindBy(xpath = "//span[@class = 'reviews-rate cr-reviews-rate-5']")
    private List<ReviewsComponent> reviewsFiveStars;

    public PopularItemPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return basketButton.isPresent();
    }

    public int getReviewsFiveStarsCount() {
        rewiewsButton.assertElementPresent(18);
        rewiewsButton.click();
        return reviewsFiveStars.size();
    }

}

