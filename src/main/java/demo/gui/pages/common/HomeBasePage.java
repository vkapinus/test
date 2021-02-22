package demo.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import demo.gui.components.compare.PopularPrimeryComponent;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class HomeBasePage extends AbstractPage {

    public HomeBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract List<PopularPrimeryComponent> getComponents();
    public abstract String getNameByIndex (int index);
    public abstract PopularItemBasePage openPrimeryItem(String title);
    public abstract SearchResultBasePage showSearchResult(String query);
    public abstract HomeBasePage authorization(String email, String pass);
    public abstract String getUserEmail();
    public abstract HomeBasePage openMenuItem(String title);
    public abstract HomeBasePage openCategoryItem(String title);
    public abstract SearchResultBasePage openProductsFromNavigateMenu(String title);


}