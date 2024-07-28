package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Page object for Allo home page
 */
public class AlloHomePage extends BasePage{
    /**
     * Construct method
     *
     * @param driver
     */
    public AlloHomePage(WebDriver driver) {
        super(driver);
    }


    private final By searchInput = By.xpath("//*[@id=\"search-form__input\"]");
    private final By searchSubmitBtn = By.xpath("//*[@class=\"search-form__submit-button\"]");

    /**
     * Getter for search input
     *
     * @return By
     */
    public By getSearchInput() {
        return this.searchInput;
    }

    /**
     * Getter for search submit button
     *
     * @return By
     */
    public By getSearchSubmitBtn() {
        return this.searchSubmitBtn;
    }

    /**
     * Enter query in search input and click on submit button
     *
     * @param query
     * @return this
     */
    public AlloHomePage enterSearchQuery(String query) {
        WebElement searchInputElement = driver.findElement(searchInput);
        WebElement searchSubmitElement = driver.findElement(searchSubmitBtn);
        waitElementIsVisible(searchInputElement);
        waitElementIsVisible(searchSubmitElement);
        driver.findElement(searchInput).sendKeys(query);
        driver.findElement(searchSubmitBtn).click();

        return this;
    }
}
