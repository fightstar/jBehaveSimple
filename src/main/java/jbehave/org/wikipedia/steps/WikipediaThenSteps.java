package jbehave.org.wikipedia.steps;

import jbehave.org.wikipedia.commons.AbstractSteps;
import jbehave.org.wikipedia.commons.CommonContextKey;
import jbehave.org.wikipedia.commons.StoryContext;
import jbehave.org.wikipedia.page.object.BddPageObject;
import jbehave.org.wikipedia.page.object.WikipediaMainPageObject;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.openqa.selenium.WebDriver;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.openqa.selenium.support.PageFactory.initElements;

/**
 * Created by Alex.
 */
public class WikipediaThenSteps extends AbstractSteps {

    public WikipediaThenSteps(WebDriver driver, StoryContext context) {
        super(driver,context);
    }

    @Then("$language language is selected")
    public void thenCheckThatSelectedLanguageIs (@Named("language") String language){
        assertThatLanguageSelected(language);
    }

    @Then("selected language is <language>")
    public void thenCheckThatLanguageSelected(@Named("language") String language){
        assertThatLanguageSelected(language);
    }

    @Then("user redirect on article result page")
    public void thenUserRedirectOnArticlePage() {
        BddPageObject bddPageObject = getBddPageObject();
        assertTrue("Not article page!", bddPageObject.isItArticlePage());
    }

    @Then("$text article display on the page")
    public void thenArticleDisplayOnThePage(@Named("text") String text) {
        BddPageObject bddPageObject = getBddPageObject();
        assertEquals("Wrong article name!", text, bddPageObject.getArticleName());
    }

    @Then("article language is $language")
    public void thenArticleLanguageIs(@Named("language") String language) {
        BddPageObject bddPageObject = getBddPageObject();
        assertEquals("Article language doesn't equals selected language for search!",
                language, bddPageObject.getArticleLanguage());
    }

    @Then("$text article is found")
    public void thenArticleIsFound(@Named("text") String text) {
        BddPageObject bddPageObject = getBddPageObject();
        String lastLanguage = context.get(CommonContextKey.LANGUAGE);

        assertEquals("Article language doesn't equals selected language for search!",
                lastLanguage, bddPageObject.getArticleLanguage());

        assertEquals("Wrong article name!", text, bddPageObject.getArticleName());
    }


    private void assertThatLanguageSelected(String language) {
        WikipediaMainPageObject mainPageObject = getWikipediaMainPageObject();
        assertTrue(language +" language doesn't select!", mainPageObject.isLanguageSelected(language));
    }

    private WikipediaMainPageObject getWikipediaMainPageObject() {
        return initElements(driver, WikipediaMainPageObject.class);
    }

    private BddPageObject getBddPageObject() {
        return initElements(driver, BddPageObject.class);
    }
}
