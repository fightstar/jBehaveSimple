package jbehave.org.wikipedia.steps;

import jbehave.org.wikipedia.commons.AbstractSteps;
import jbehave.org.wikipedia.commons.CommonContextKey;
import jbehave.org.wikipedia.commons.StoryContext;
import jbehave.org.wikipedia.page.object.WikipediaMainPageObject;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;

import static junit.framework.Assert.assertTrue;
import static org.openqa.selenium.support.PageFactory.initElements;

/**
 * Created by Alex on 22.12.13.
 */
public class WikipediaWhenSteps extends AbstractSteps {

    public WikipediaWhenSteps(WebDriver driver, StoryContext context) {
        super(driver,context);
    }

    @When("select $language language")
    @Alias("select $language language in search language field")
    public void whenSelectLanguage(@Named("language") String language) {
        context.set(CommonContextKey.LANGUAGE, language);
        sleectLanguageForSearch(language);
    }

    @When("user select <language> language")
    public void whenSelectAnyLanguage(@Named("language") String language) {
        context.set(CommonContextKey.LANGUAGE, language);
        sleectLanguageForSearch(language);
    }

    @When("user searches $text text in $language language")
    public void whenUserSearchData(@Named("text") String text, @Named("language") String language) {
        context.set(CommonContextKey.LANGUAGE, language);
        WikipediaMainPageObject mainPageObject = getWikipediaMainPageObject();
        sleectLanguageForSearch(language);
        mainPageObject.inputSearchData(text);
        mainPageObject.clickSearchButton();
    }

    @When("input $text text in search field")
    public void whenInputSearchText(@Named("text") String text) {
        WikipediaMainPageObject mainPageObject = getWikipediaMainPageObject();
        mainPageObject.inputSearchData(text);
    }

    @When("click search button '->'")
    public void whenClickSearchButton() {
        WikipediaMainPageObject mainPageObject = getWikipediaMainPageObject();
        mainPageObject.clickSearchButton();
    }

    private void sleectLanguageForSearch(String language) {
        WikipediaMainPageObject mainPageObject = getWikipediaMainPageObject();
        mainPageObject.selectSearchLanguage(language);
    }

    private WikipediaMainPageObject getWikipediaMainPageObject() {
        return initElements(driver, WikipediaMainPageObject.class);
    }
}
