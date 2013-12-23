package jbehave.org.wikipedia.page.object;

import com.google.common.collect.ImmutableMap;
import jbehave.org.wikipedia.commons.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

/**
 * Created by Alex.
 */
public class WikipediaMainPageObject extends AbstractPage {

    @FindBy(xpath = "//body")
    private WebElement body;

    @FindBy(xpath = "//div[@class='central-featured-logo']")
    private WebElement centralLogo;

    @FindBy(id = "searchInput")
    private WebElement searchInput;

    @FindBy(id = "searchLanguage")
    private WebElement searchLanguage;

    @FindBy(xpath = "//input[@class='formBtn'][@name='go']")
    private WebElement searchButton;

    public static final Map<String, String> LANGUAGE_VALUES_MAP = ImmutableMap.<String, String>builder()
            .put("English", "en")
            .put("Deutsch", "de")
            .put("Italiano", "it")
            .build();


    public WikipediaMainPageObject(WebDriver driver) {
        super(driver);
    }

    public void inputSearchData(String searchData) {
        searchInput.clear();
        searchInput.sendKeys(searchData);
    }

    public void selectSearchLanguage(String language) {
        Select select = new Select(searchLanguage);
        select.selectByValue(LANGUAGE_VALUES_MAP.get(language));
    }

    public boolean isLanguageSelected(String language) {
        Select select = new Select(searchLanguage);
        return language.equals(select.getFirstSelectedOption().getText());
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean isCentralLogoPresent() {
        return isElementPresent(By.xpath("//div[@class='central-featured-logo']"));
    }
}
