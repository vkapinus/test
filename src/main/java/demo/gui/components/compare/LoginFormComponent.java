package demo.gui.components.compare;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import demo.gui.pages.HomePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginFormComponent extends AbstractUIObject {

    @FindBy(css = "input[type=text]")
    private ExtendedWebElement emailInput;

    @FindBy(css = "input[type=password]")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//div[text()='Войти']")
    private ExtendedWebElement loginButton;

    @FindBy(className = "userToolsSubtitle")
    private ExtendedWebElement userEmail;

    public LoginFormComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HomePage login (String email, String pass){
        emailInput.type(email);
        passwordInput.type(pass);
        loginButton.click();
        return new HomePage(driver);
    }

    public String getUserEmail() {
        return userEmail.getText();
    }
}
