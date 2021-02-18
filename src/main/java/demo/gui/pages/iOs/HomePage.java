package demo.gui.pages.iOs;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import demo.gui.components.compare.LoginFormComponent;
import demo.gui.components.compare.NavigateMenuComponent;
import demo.gui.components.compare.PopularPrimeryComponent;
import demo.gui.components.compare.SearchFieldComponent;
import demo.gui.pages.common.HomeBasePage;
import demo.gui.pages.common.PopularItemBasePage;
import demo.gui.pages.common.SearchResultBasePage;
import demo.utils.MobileContextUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomeBasePage.class)
public class HomePage extends HomeBasePage {

    @FindBy(className = "logo")
    private ExtendedWebElement logo;

    @FindBy(className = "item")
    private List<PopularPrimeryComponent> primeryComponents;

    @FindBy(id = "j-search")
    private SearchFieldComponent searchFrame;

    @FindBy(className = "mini-profile")
    private ExtendedWebElement accountButton;

    @ExtendedFindBy(iosPredicate = "label == 'Войти'")
    private ExtendedWebElement loginButton;

    @FindBy(className = "root")
    private LoginFormComponent loginFormComponent;

    @FindBy(className = "g-btn")
    private ExtendedWebElement openMenu;

    @FindBy(xpath = "//ul[contains(@class, 'menu-top')]/li")
    private List<NavigateMenuComponent> navigateMenuHeader;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeLink")
    private List<ExtendedWebElement> navigateCategoryItem;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther/XCUIElementTypeLink")
    private List<ExtendedWebElement> navigateProductsFromMenu;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(logo);
    }

    public PopularItemBasePage openItemFromPrimaryPane(String title) {
        primeryComponents.stream().filter(e -> e.getNamePopularItem().equals(title)).findAny().get().openPopularItemPage();
        return initPage(this.driver, PopularItemBasePage.class);
    }

    public HomeBasePage openMenuItem(String title) {
        openMenu.click();
        navigateMenuHeader.stream().filter(e -> e.getNameMenuHeader().equals(title)).findAny().get().showMenuOptions();
        return this;
    }

    public HomeBasePage openCategoryItem(String title) {
        MobileContextUtils contextHelper = new MobileContextUtils();
        contextHelper.switchMobileContext(MobileContextUtils.View.NATIVE);
        navigateCategoryItem.stream().filter(e -> e.getText().equals(title)).findAny().get().click();
        return this;
    }

    public SearchResultBasePage openProductsFromNavigateMenu(String title) {
        navigateProductsFromMenu.stream().filter(e -> e.getText().equals(title)).findAny().get().click();
        return initPage(this.driver, SearchResultBasePage.class);
    }

    public SearchResultBasePage showSearchResult(String query) {
        searchFrame.fillSearch(query);
        return searchFrame.submitSearch();
    }

    public HomeBasePage authorization(String email, String pass) {
        accountButton.click();
        MobileContextUtils contextHelper = new MobileContextUtils();
        contextHelper.switchMobileContext(MobileContextUtils.View.NATIVE);
        loginButton.click();
        return loginFormComponent.login(email, pass);

    }

    public String getUserEmail() {
        MobileContextUtils contextHelper = new MobileContextUtils();
        contextHelper.switchMobileContext(MobileContextUtils.View.WEB);
        accountButton.click();
        return loginFormComponent.getUserEmail();
    }
}