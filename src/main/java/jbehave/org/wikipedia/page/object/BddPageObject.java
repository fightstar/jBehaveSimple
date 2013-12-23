package jbehave.org.wikipedia.page.object;

import com.google.common.collect.ImmutableMap;
import jbehave.org.wikipedia.commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

/**
 * Created by Alex.
 */
public class BddPageObject extends AbstractPage {

    @FindBy(xpath = "//li[@id='ca-nstab-main']")
    private WebElement articleTab;

    @FindBy(xpath = "//h1[@id='firstHeading']")
    private WebElement firstHeading;

    @FindBy(xpath = "//span[@dir='auto']")
    private WebElement articleName;

    private static final String ARTICLE_TAB_TEXT = "Article";
    public static final Map<String, String> LANGUAGE_ID_MAP = ImmutableMap.<String, String>builder()
            .put("en", "English")
            .put("de", "Deutsch")
            .put("ru", "Русский")
            .build();

    public BddPageObject(WebDriver driver) {
        super(driver);
    }

    public boolean isItArticlePage() {
        return articleTab.getText().equals(ARTICLE_TAB_TEXT);

    }

    public String getArticleLanguage() {
        String languageId = firstHeading.getAttribute("lang");
        return LANGUAGE_ID_MAP.get(languageId);
    }

    public String getArticleName() {
        return articleName.getText();
    }
}
