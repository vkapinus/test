package demo.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomeBasePage extends AbstractPage {

    public HomeBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract PopularItemBasePage openItemFromPrimaryPane(String title);
    public abstract SearchResultBasePage showSearchResult(String query);
    public abstract HomeBasePage authorization(String email, String pass);
    public abstract String getUserEmail();
    public abstract HomeBasePage openMenuItem(String title);
    public abstract HomeBasePage openCategoryItem(String title);
    public abstract SearchResultBasePage openProductsFromNavigateMenu(String title);


}