package demo.gui.components.compare;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import demo.gui.pages.SearchResultPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchFieldComponent extends AbstractUIObject {

    @FindBy(id = "j-search")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//button[@name='sa']")
    private ExtendedWebElement searchButton;

    public SearchFieldComponent(WebDriver driver, SearchContext context){
        super(driver, context);
    }

    public SearchFieldComponent fillSearch(String query) {
        searchInput.type(query);
        return this;
    }

    public SearchResultPage submitSearch(){
        searchButton.sendKeys(Keys.ENTER);
        return new SearchResultPage(driver);
    }
}