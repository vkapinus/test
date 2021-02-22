package demo.gui.pages.iOs;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import demo.gui.components.compare.ResultSearchComponent;
import demo.gui.pages.common.SearchResultBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SearchResultBasePage.class)
public class SearchResultPage extends SearchResultBasePage {

    @FindBy(className = "filters")
    private ExtendedWebElement filter;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[4]")
    private ExtendedWebElement resultHeader;

    @FindBy(className = "item")
    private List<ResultSearchComponent> searchComponents;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(filter);
    }

    public String getHeader(){
        return resultHeader.getText();
    }

    public List<String> getProductTitles(){
        return searchComponents.stream().map(ResultSearchComponent::getNameItem).collect(Collectors.toList());
    }
}