package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.time.Duration;

import static constants.Constant.TimeoutVariables.EXCLICIT_WAIT;
import static constants.Constant.TimeoutVariables.IMPLICIT_WAIT;

/**
 * Parent class for all pages
 */
public class BasePage
{
    protected WebDriver driver;

    /**
     * Construct method
     *
     * @param driver
     */
    public BasePage(WebDriver driver)
    {
        this.driver = driver;
    }

    /**
     * Open page by url
     *
     * @param url
     */
    public void openPage(String url)
    {
        driver.get(url);
    }

    /**
     * Wait page element loading
     *
     * @param element
     * @return element
     */
    public WebElement waitElementIsVisible(WebElement element)
    {
        new WebDriverWait(driver,IMPLICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
