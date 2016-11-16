package testCode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

import static pageObjects.TestingEpamSite.differentElementsPage;
import static pageObjects.TestingEpamSite.homePage;


public class SiteTest extends TestBase
{

    @BeforeMethod
    public void before(Method method) throws IOException {
        homePage.isOpened();
        homePage.checkOpened();
    }

    @Test(dataProviderClass = LoginData.class, dataProvider = "LoginTest")
    public void checkingLoginForm(boolean status, String loginText, String passwordText) {
        homePage.loginForm.loginFormOpenButton.click();
        homePage.loginForm.checkingAuthorize(status, loginText, passwordText);
        homePage.loginForm.loginFormOpenButton.click();
    }

    @Test
    public void checkingDifferentElements()
    {
        homePage.loginForm.loginFormOpenButton.click();
        homePage.loginForm.submit("epam", "1234");
        differentElementsPage.open();
        differentElementsPage.checkingAllCheckboxes();
    }


}
