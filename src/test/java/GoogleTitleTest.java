import com.google.pages.GoogleSearchPage;
import org.testng.annotations.Test;

public class GoogleTitleTest extends BaseTest {

    @Test
    public void verifyTitleContainsExpectedWord() {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        googleSearchPage.open()
                .searchFor("automation")
                .clickOnFirstDetectedLink()
                .verifyTitleIsCorrect("Automation");
    }
}
