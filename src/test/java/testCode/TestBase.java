package testCode;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.epam.web.matcher.verify.Verify;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import pageObjects.TestingEpamSite;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;

public class TestBase extends TestNGBase
{
    @BeforeSuite(alwaysRun = true)
    public static void setUp() throws Exception {
        WebSite.init(TestingEpamSite.class);
        Verify.getFails();
        logger.info("Run Tests");
    }

    @AfterMethod
    public void tearDown() {
        Verify.getFails();
    }
}
