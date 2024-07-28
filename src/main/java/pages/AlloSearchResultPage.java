package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;

import org.openqa.selenium.NoSuchElementException;

/**
 * Page object for search result page
 */
public class AlloSearchResultPage extends BasePage {
    /**
     * Construct method
     *
     * @param driver
     */
    public AlloSearchResultPage(WebDriver driver) {
        super(driver);
    }

    private final By searchResultCard = By.cssSelector(".products-layout__item:not(.products-layout__item--next)");
    private final By emptySearchResults = By.className("v-catalog__empty");
    private final By minimumPriceField = By.xpath("//input[@class = \"f-range__form-input\" and position()=1]");
    private final By maximumPriceField = By.xpath("//input[@class = \"f-range__form-input\" and position()=2]");
    private final By priceTab = By.className("/header-title");
    private final By searchItemTruePrice = By.xpath("//div[@class =\"v-pb__cur discount\"]//span[@class = \"sum\"]");
    private final By priceFilterEnabledBlock = By.xpath("//div[@class =\"v-catalog__products\"]//div[@class=\"f-active\"]//a[@data-id =\"price\"]");

    /**
     * Check search result is not empty and equal or bigger than given qty
     *
     * @param qty
     * @return
     */
    public AlloSearchResultPage checkSearchResultQty(int qty) {
        boolean isElementAbsent = false;
        try {
            driver.findElement(emptySearchResults);
            isElementAbsent = false;
        } catch (NoSuchElementException e) {
            isElementAbsent = true;
        }

        Assert.assertTrue(isElementAbsent);
        int searchResultQty = driver.findElements(searchResultCard).size();
        Assert.assertTrue(searchResultQty >= 2);

        return this;
    }

    /**
     * Check if price form is opened if closed open it
     *
     * @return this
     */
    public AlloSearchResultPage checkPriceFormIsOpened() {
        boolean priceInputDisplayed = driver.findElement(minimumPriceField).isDisplayed();

        if (!priceInputDisplayed) {
            driver.findElement(priceTab).click();
            WebElement minimumInput = driver.findElement(minimumPriceField);
            waitElementIsVisible(minimumInput);
        }

        return this;
    }

    /**
     * Set price in search input
     *
     * @param queryPrice
     * @return this
     */
    public AlloSearchResultPage setQueryPrice(int queryPrice, String input) {
        String priceString = String.valueOf(queryPrice);
        By priceField = minimumPriceField;

        if (Objects.equals(input, "maximum")) {
            priceField = maximumPriceField;
        }
        WebElement inputElement = driver.findElement(priceField);
        waitElementIsVisible(inputElement);
        inputElement.clear();
        inputElement.sendKeys(priceString);

        return this;
    }

    /**
     * Check results of search by price action
     *
     * @return this
     */
    public AlloSearchResultPage checkResultsOfPriceSearch() {
        WebElement filerBlock = driver.findElement(priceFilterEnabledBlock);
        waitElementIsVisible(filerBlock);
        List<WebElement> priceElements = driver.findElements(searchItemTruePrice);

        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace(" ", "");
            int currentTruePrice = Integer.parseInt(priceText);
            Assert.assertTrue(currentTruePrice >= 30000 && currentTruePrice <= 40000);
        }

        return this;
    }
}
