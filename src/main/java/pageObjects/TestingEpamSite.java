package pageObjects;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;

@JSite(domain = "https://jdi-framework.github.io/tests")
public class TestingEpamSite extends WebSite
{

    @JPage(url = "/index.htm", title = "Index Page")
    public static HomePage homePage;

    @JPage(url = "/page8.htm", title = "Different elements")
    public static DifferentElementsPage differentElementsPage;

}
