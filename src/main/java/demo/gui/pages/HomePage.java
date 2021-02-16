package demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ElementLoadingStrategy;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import demo.gui.components.compare.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class HomePage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

    @FindBy(className = "logotype")
    private ExtendedWebElement logo;

    @FindBy(id = "j-search")
    private SearchFieldComponent searchFrame;

    @FindBy(xpath = "//ul[@class ='b-foreign_goods']/li")
    private List<PopularPrimeryComponent> primeryComponents;

    @FindBy(css = "div[role=button]>div>button")
    private ExtendedWebElement accountButton;

    @FindBy(xpath = "//button[@class='userToolsBtn']")
    private ExtendedWebElement loginButton;

    @FindBy(css = "div[class~=screenHolder-focusable]")
    private LoginFormComponent loginFormComponent;

    @FindBy(className = "navigationItem")
    private List<NavigateMenuComponent> navigateMenuHeader;

    @FindBy(xpath = "//dd[contains(@class,'subnavDescription')]/a")
    private List<ExtendedWebElement> navigateCategoryProducts;

    public HomePage(WebDriver driver) {
        super(driver);
        setLoadingStrategy(ElementLoadingStrategy.BY_PRESENCE);
        setUiLoadedMarker(logo);
    }

    public PopularItemPage openItemFromPrimaryPane(String title) {
        primeryComponents.stream().filter(e -> e.getNamePopularItem().equals(title)).findAny().get().openPopularItemPage();
        return new PopularItemPage(this.driver);
    }

    public HomePage openMenuItem(String title) {
        navigateMenuHeader.stream().filter(e -> e.getNameMenuHeader().equals(title)).findAny().get().showMenuOptions();
        return this;
    }

    public SearchResultPage openCategoryProducts(String title) {
        navigateCategoryProducts.stream().filter(e -> e.getText().equals(title)).findAny().get().click();
        return new SearchResultPage(this.driver);
    }

    public SearchResultPage showSearchResult(String query){
        searchFrame.fillSearch(query);
        return searchFrame.submitSearch();
    }

    public HomePage authorization(String email, String pass){
        accountButton.click();
        loginButton.click();
        return loginFormComponent.login(email, pass);

    }

    public String getUserEmail(){
        accountButton.click();
        return loginFormComponent.getUserEmail();
    }
}