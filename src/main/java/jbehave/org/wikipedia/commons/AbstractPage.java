package jbehave.org.wikipedia.commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

/**
 * Created by Alex.
 */
public abstract class AbstractPage extends WebDriverHelper {

    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator).isDisplayed();
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }
}
