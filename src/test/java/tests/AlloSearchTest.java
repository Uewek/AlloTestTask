package tests;

import org.testng.annotations.Test;
import pages.AlloHomePage;
import pages.AlloSearchResultPage;

import static constants.Constant.AlloUrls.ALLO_HOME_PAGE_URL;
import static constants.Constant.SearchQueries.IPHONE_QUERY;

/**
 * This class may contain all test about search by main search input
 */
public class AlloSearchTest extends BaseTest {

    /**
     * Positive test. Open store make search query and check result is not empty
     *
     * @throws InterruptedException
     */
    @Test
    public void alloIphoneSearchWithoutPrice() throws InterruptedException {

        AlloHomePage homePage = new AlloHomePage(driver);
        homePage.openPage(ALLO_HOME_PAGE_URL);
        homePage.enterSearchQuery(IPHONE_QUERY);
        AlloSearchResultPage searchResultPage = new AlloSearchResultPage(driver);
        searchResultPage.checkSearchResultQty(2);
    }

}
