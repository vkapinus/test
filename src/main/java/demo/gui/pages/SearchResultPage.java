package demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ElementLoadingStrategy;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import demo.gui.components.compare.ResultSearchComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchResultPage.class);

    @FindBy(xpath = "//h1[contains(@class,'content__header')]")
    private ExtendedWebElement resultHeader;

    @FindBy(xpath = "//ul[@class='b-result__inner']/li")
    private List<ResultSearchComponent> searchComponents;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        setLoadingStrategy(ElementLoadingStrategy.BY_PRESENCE);
        setUiLoadedMarker(resultHeader);
    }

    public String getHeader(){
       return resultHeader.getText();

    }

    public List<String> getProductTitles(){
        return searchComponents.stream().map(e -> e.getNameItem()).collect(Collectors.toList());
    }

}