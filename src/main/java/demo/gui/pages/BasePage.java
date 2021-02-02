package demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import demo.gui.components.compare.*;
import org.openqa.selenium.NoSuchElementException;
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
    private SearchComponent searchFrame;

    @FindBy(xpath = "//ul[@class ='b-foreign_goods']/li")
    private List<PopularPrimeryComponent> primeryComponents;

    public BasePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://21vek.by");
    }

    @Override
    public boolean isPageOpened() {
        return logo.isPresent() && primeryComponents.size() > 0;
    }


    public PopularItemPage openItemFromPrimaryPane(String title) {

        for (PopularPrimeryComponent component : primeryComponents) {
            if (component.getName().equals(title)) {
                return component.navigateTo();
            }
        }
        throw new NoSuchElementException(String.format("The item with title '%s' not found!", title));
    }

    public PopularItemPage openRew(String title) {

        for (PopularPrimeryComponent component : primeryComponents) {
            if (component.getName().equals(title)) {
                return component.navigateTo();
            }
        }
        throw new NoSuchElementException(String.format("The item with title '%s' not found!", title));

    }

    public BasketPage openBasket(){
        BasketComponent basketComponent = new BasketComponent(this.driver);
        return basketComponent.navigateTo();
    }

    public NewsPage openNews(){
        NewsComponent newsComponent = new NewsComponent(this.driver);
        return newsComponent.navigateTo();
    }

    public AllReviewsPage openReviews(){
        AllReviewsComponent reviewsComponent = new AllReviewsComponent(this.driver);
        return reviewsComponent.navigateTo();
    }

    public BonusProgramPage openBonusPage(){
        BonusProgramComponent bonusProgramComponent = new BonusProgramComponent(this.driver);
        return bonusProgramComponent.navigateTo();
    }

    public ResultSearchPage getResultSearch(String query){
        searchFrame.activate();
        searchFrame.setSearchInput(query);
        return searchFrame.navigateToResult();
    }




}
