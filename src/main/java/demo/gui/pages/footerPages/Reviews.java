package demo.gui.pages.footerPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class Reviews extends AbstractPage {

    @FindBy(xpath = ".//h1[@class='content__header']")
    private ExtendedWebElement reviewsHeader;

    public Reviews(WebDriver driver) {
        super(driver);
        setPageURL("/services/reviews.html");
    }

    @Override
    public boolean isPageOpened() {
        return reviewsHeader.isPresent();
    }


}
