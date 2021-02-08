package demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import demo.gui.components.compare.ResultSearchComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ResultSearchPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResultSearchPage.class);

    @FindBy(xpath = ".//h1[@class='content__header cr-category_header']")
    private ExtendedWebElement resultHeader;


    @FindBy(xpath = "//ul[@class='b-result__inner']/li")
    private List<ResultSearchComponent> searchComponents;

    public ResultSearchPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened(PageOpeningStrategy byElement) {
        return resultHeader.isPresent();
    }

    public String getHeader(){
       return resultHeader.getText();

    }

    public ResultSearchComponent getItemByIndex(int index){
        return searchComponents.get(index);
    }

    public String getCategoryName() {
        return resultHeader.getText();
    }
}