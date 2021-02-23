package demo.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ElementLoadingStrategy;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import demo.gui.components.compare.ResultSearchComponent;
import demo.gui.pages.common.SearchResultBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchResultBasePage.class)
public class SearchResultPage extends SearchResultBasePage {

    @FindBy(xpath = ".//div[@class='wrapper']/h1")
    private ExtendedWebElement resultHeader;

    @FindBy(className = "item")
    private List<ResultSearchComponent> searchComponents;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(resultHeader);
    }

    public String getHeader(){
        return resultHeader.getText();

    }

    public List<String> getProductTitles(){
        return searchComponents.stream().map(e -> e.getNameItem()).collect(Collectors.toList());
    }
}