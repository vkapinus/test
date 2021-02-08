package demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import demo.gui.components.compare.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BasePage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

    @FindBy(className = "logotype")
    private ExtendedWebElement logo;

    @FindBy(id = "j-search")
    private SearchFieldComponent searchFrame;

    @FindBy(xpath = "//ul[@class ='b-foreign_goods']/li")
    private List<PopularPrimeryComponent> primeryComponents;

    @FindBy(xpath = "//button[contains(@class, 'styles_reactButton__2olKd')]")
    private ExtendedWebElement buttonSubscription;

    @FindBy(xpath = "//button[@class='styles_userToolsToggler__imcSl']")
    private ExtendedWebElement accountButton;

    @FindBy(xpath = "//button[@class='userToolsBtn']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//div[@class='screenHolder-focusable react-popup']")
    private LoginFormComponent loginFormComponent;

    @FindBy(className = "navigationItem")
    private List<NavigateMenuComponent> navigateMenuHeader;

    @FindBy(xpath = "//dd[@class='subnavDescription g-grouplinks__item']/a")
    private List<ExtendedWebElement> navigateCategoryProducts;

    public BasePage(WebDriver driver) {
        super(driver);
        setPageURL("https://www.21vek.by/");
    }

    public PopularItemPage openItemFromPrimaryPane(String title) {
        primeryComponents.stream().filter(e -> e.getName().equals(title)).findAny().get().openPopularItemPage();
        return new PopularItemPage(driver);
    }

    public BasePage openMenuItem(String title) {
        navigateMenuHeader.stream().filter(e -> e.getNameCategory().equals(title)).findAny().get().navigateToMenu();
        return new BasePage(driver);
    }

    public ResultSearchPage openCategoryProducts(String title) {
        navigateCategoryProducts.stream().filter(e -> e.getText().equals(title)).findAny().get().click();
        return new ResultSearchPage(driver);
    }

    public ResultSearchPage getResultSearch(String query){
        searchFrame.activate();
        searchFrame.setSearchInput(query);
        return searchFrame.navigateToResult();
    }


    public BasePage authorization(String email, String pass){
        accountButton.click();
        loginButton.isPresent();
        loginButton.click();
        loginFormComponent.login(email, pass);
        return new BasePage(this.driver);
    }

    public String getUserEmail(){
        accountButton.click();
        return loginFormComponent.getUserEmail();
    }
}