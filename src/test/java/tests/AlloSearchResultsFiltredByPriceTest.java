package tests;

import org.testng.annotations.Test;
import pages.AlloHomePage;
import pages.AlloSearchResultPage;

import static constants.Constant.AlloUrls.ALLO_HOME_PAGE_URL;
import static constants.Constant.SearchQueries.IPHONE_QUERY;

/**
 * Class may contain all tests about filtration search results by price
 */
public class AlloSearchResultsFiltredByPriceTest extends BaseTest {

    /**
     * Positive test. Repeat all steps from alloIphoneSearchWithPrice,
     * filter results by price and check filtration results
     *
     * @throws InterruptedException
     */
    @Test
    public void alloIphoneSearchWithPrice() throws InterruptedException {
        AlloHomePage homePage = new AlloHomePage(driver);
        homePage.openPage(ALLO_HOME_PAGE_URL);
        homePage.enterSearchQuery(IPHONE_QUERY);
        AlloSearchResultPage searchResultPage = new AlloSearchResultPage(driver);
        searchResultPage.checkSearchResultQty(2);
        searchResultPage.checkPriceFormIsOpened();
        searchResultPage.setQueryPrice(30000, "minimum");
        searchResultPage.setQueryPrice(40000, "maximum");
        searchResultPage.checkResultsOfPriceSearch();

    }
}
