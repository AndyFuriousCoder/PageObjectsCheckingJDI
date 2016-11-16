package pageObjects;


import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.openqa.selenium.support.FindBy;

import static com.epam.web.matcher.testng.Assert.assertTrue;

public class LoginForm extends Form
{
    @FindBy(id = "Login")
    private ITextField login;

    @FindBy(id = "Password")
    private ITextField password;

    @FindBy(css = "li.dropdown.uui-profile-menu > a.dropdown-toggle")
    public IButton loginFormOpenButton;

    @FindBy(xpath = "//button[@type='submit']")
    private IButton loginButton;

    @FindBy(css = ".logout")
    private IButton logoutButton;

    @FindBy(css = "span.login-txt")
    private ITextField loginFaild;

    public void submit(String loginText, String passwordText)
    {
        login.newInput(loginText);
        password.newInput(passwordText);
        loginButton.click();
    }

    public void checkingAuthorize(boolean status, String loginText, String passwordText)
    {
        submit(loginText, passwordText);

        if(status)
        {
            assertTrue(logoutButton.isDisplayed());
            logoutButton.click();
        }
        else
        {
            assertTrue(loginFaild.isDisplayed());
        }
    }
}
