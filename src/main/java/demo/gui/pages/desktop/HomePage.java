package demo.gui.pages.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ElementLoadingStrategy;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import demo.gui.components.compare.*;
import demo.gui.pages.common.HomeBasePage;
import demo.gui.pages.common.PopularItemBasePage;
import demo.gui.pages.common.SearchResultBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomeBasePage.class)
public class HomePage extends HomeBasePage {

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

    @FindBy(xpath = "//dt[@class='subnavTerm']/a")
    private List<ExtendedWebElement> navigateCategoryItem;

    @FindBy(xpath = "//dl[@class='b-cloud-sub ']/dt/a")
    private List<ExtendedWebElement> navigateProductsFromMenu;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(logo);
    }

    public List<PopularPrimeryComponent> getComponents() {
        return primeryComponents;
    }
    public PopularItemBasePage openPrimeryItem(String title) {
        primeryComponents.stream().filter(e -> e.getNamePopularItem().equals(title)).findAny().get().openPopularItemPage();
        return initPage(this.driver, PopularItemBasePage.class);
    }
    public String getNameByIndex (int index){
        return primeryComponents.get(index).getNamePopularItem();
    }

    public HomeBasePage openMenuItem(String title) {
        navigateMenuHeader.stream().filter(e -> e.getNameMenuHeader().equals(title)).findAny().get().showMenuOptions();
        return this;
    }

    public HomeBasePage openCategoryItem(String title) {
        navigateCategoryItem.stream().filter(e -> e.getText().equals(title)).findAny().get().click();
        return this;
    }

    public SearchResultBasePage openProductsFromNavigateMenu(String title) {
        navigateProductsFromMenu.stream().filter(e -> e.getText().equals(title)).findAny().get().click();
        return initPage(this.driver, SearchResultBasePage.class);
    }

    public SearchResultBasePage showSearchResult(String query){
        searchFrame.fillSearch(query);
        return searchFrame.submitSearch();
    }

    public HomeBasePage authorization(String email, String pass) {
        accountButton.click();
        loginButton.click();
        return loginFormComponent.login(email, pass);
    }

    public String getUserEmail(){
        accountButton.click();
        return loginFormComponent.getUserEmail();
    }
}