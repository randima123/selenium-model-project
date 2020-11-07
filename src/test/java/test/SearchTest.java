package test;

import fragment.LoginFragment;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchResultPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest {

    private SearchResultPage searchResultPage;

    @BeforeMethod
    public void searchBeforeMethod() {
        new LoginFragment(driver).login("randima@mailinator.com","abc123");
        searchResultPage = new SearchResultPage(driver);
        new HomePage(driver).searchItem("T-shirt");
    }

    @Test
    public void testSearchResultCount() {
        int actualSearchResultCount = searchResultPage.getSearchResultCount();
        assertTrue(actualSearchResultCount > 0);
        assertEquals(actualSearchResultCount,1);
    }

    @Test
    public void testSearchResult() {
        assertTrue(searchResultPage.getFirstSearchResultName().contains("Faded Short Sleeve T-shirts"));
        assertEquals(searchResultPage.getFirstSearchResultPrice(), "$16.51");
    }
}
