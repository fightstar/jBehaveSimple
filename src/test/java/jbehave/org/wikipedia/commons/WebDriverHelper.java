package jbehave.org.wikipedia.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Alex.
 */
public class WebDriverHelper {

    private WebDriver driver;

    public WebDriverHelper() {
    }

    public void startDriver() {
        if (driver == null) {
            driver = new FirefoxDriver();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void destroyDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
