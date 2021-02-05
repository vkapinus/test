package demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import demo.gui.components.compare.ResultSearchComponent;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ResultSearchPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResultSearchPage.class);

    @FindBy(xpath = ".//h1[@class='content__header cr-category_header']")
    private ExtendedWebElement resultHeader;


    @FindBy(xpath = "className = 'result_name'")
    private List<ResultSearchComponent> searchComponents;

    public ResultSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return resultHeader.isPresent();
    }

    public ProductPage searchWordEqualsItems(String title) {

        for (ResultSearchComponent component : searchComponents) {
            if (component.getName().equals(title)) {
                return component.navigateTo();
            }
        }
        throw new NoSuchElementException(String.format("The item with title '%s' not found!", title));
    }

    public String getCategoryName() {
        return resultHeader.getText();
    }
}