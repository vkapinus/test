package demo.gui.components.compare;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import demo.gui.pages.BasePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginFormComponent extends AbstractUIObject {

    @FindBy(xpath = "//input[@class='sc-htpNat hIeGZi']")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//input[@class='sc-htpNat dgqTuC']")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//div[@class='selen-pokdbn5820x']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//span[@class='userToolsSubtitle']")
    private ExtendedWebElement personEmail;

    public LoginFormComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public BasePage login (String email, String pass){
        emailInput.type(email);
        passwordInput.type(pass);
        loginButton.click();
        return new BasePage(driver);
    }

    public String getUserEmail() {
        return personEmail.getText();
    }
}
