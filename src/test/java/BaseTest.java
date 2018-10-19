import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeSuite;

public class BaseTest {


    @BeforeSuite
    public void setUp() {
        SelenideConfig config = ConfigFactory.create(SelenideConfig.class, System.getProperties());
        Configuration.baseUrl = config.baseUrl();
        Configuration.browser = config.browserName();
        Configuration.browserSize = config.resolution();
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true).savePageSource(true));
    }
}
