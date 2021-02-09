package demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ProductPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductPage.class);

    @FindBy(xpath = ".//button[contains(@class, 'g-button g-buybtn')]")
    private ExtendedWebElement inBasketButton;

    @FindBy(xpath = "//div[@class='headerCart']")
    private ExtendedWebElement basketButton;

    @FindBy(xpath = "//span[text() = 'Отзывы']")
    private ExtendedWebElement reviewLabel;

    @FindBy(xpath = "//button[@class = 'g-button']")
    private ExtendedWebElement addReview;

    public ProductPage(WebDriver driver) {
        super(driver);
    }


    public boolean isPageOpened(PageOpeningStrategy byElement) {
        return inBasketButton.isPresent()&&reviewLabel.isPresent();
    }
}