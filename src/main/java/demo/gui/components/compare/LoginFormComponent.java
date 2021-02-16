package demo.gui.components.compare;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import demo.gui.pages.common.HomeBasePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginFormComponent extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(css = "input[type=text]")
    private ExtendedWebElement emailInput;

    @FindBy(css = "input[name=email]")
    private ExtendedWebElement emailInputAndroid;

    @FindBy(css = "input[type=password]")
    private ExtendedWebElement passwordInput;

    @FindBy(css = "input[name=password]")
    private ExtendedWebElement passwordInputAndroid;

    @FindBy(xpath = "//div[text()='Войти']")
    private ExtendedWebElement loginButton;

    @FindBy(css = "button[type=submit]")
    private ExtendedWebElement loginButtonAndroid;

    @FindBy(className = "userToolsSubtitle")
    private ExtendedWebElement userEmail;

    @FindBy(xpath = "//p")
    private ExtendedWebElement userEmailAndroid;


    public LoginFormComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HomeBasePage login (String email, String pass){
        if (R.CONFIG.get("platform").equals("android")){
            emailInputAndroid.type(email);
            passwordInputAndroid.type(pass);
            loginButtonAndroid.click();
            return initPage(this.driver, HomeBasePage.class);
        } else {
            emailInput.type(email);
            passwordInput.type(pass);
            loginButton.click();
            return initPage(this.driver, HomeBasePage.class);
        }
    }

    public String getUserEmail() {
        if (R.CONFIG.get("platform").equals("android")) {
            return userEmailAndroid.getText();
        } else {
            return userEmail.getText();
        }
    }
}