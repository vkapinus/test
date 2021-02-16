package demo.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class SearchResultBasePage extends AbstractPage {

    public SearchResultBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract List<String> getProductTitles();
    public abstract String getHeader();
}