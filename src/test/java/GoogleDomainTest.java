import com.google.pages.GoogleSearchPage;
import org.testng.annotations.Test;

public class GoogleDomainTest extends BaseTest {

    @Test
    public void verifyExpectedDomainIsPresent() {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        googleSearchPage.open()
                .searchForSomething("automation")
                .verifyExpectedDomain("https://testautomationday.com", 5);
    }
}
