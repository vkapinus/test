package demo.gui.components.compare;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

import demo.gui.pages.ResultSearchPage;
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

    public void activate(){
        searchInput.click();
    }

    public SearchFieldComponent setSearchInput(String query) {
        searchInput.type(query);
        return this;
    }

    public ResultSearchPage navigateToResult(){
        searchButton.sendKeys(Keys.ENTER);
        return new ResultSearchPage(driver);
    }
}