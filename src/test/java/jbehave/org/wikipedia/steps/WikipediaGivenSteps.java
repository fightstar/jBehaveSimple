package jbehave.org.wikipedia.steps;

import jbehave.org.wikipedia.commons.AbstractSteps;
import jbehave.org.wikipedia.commons.StoryContext;
import jbehave.org.wikipedia.page.object.WikipediaMainPageObject;
import org.jbehave.core.annotations.Given;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.PageFactory.initElements;

/**
 * Created by Alex.
 */
public class WikipediaGivenSteps extends AbstractSteps {

    public static final String WIKIPEDIA_TITLE = "Wikipedia";
    public static final String WIKIPEDIA_MAIN_PAGE = "http://www.wikipedia.org/";

    public WikipediaGivenSteps(WebDriver driver, StoryContext context) {
        super(driver, context);
    }

    @Given("open Wikipedia main page")
    public void givenOpenWikiMainPage() {
        driver.navigate().to(WIKIPEDIA_MAIN_PAGE);
        assertEquals("Wikipedia title not correct!", WIKIPEDIA_TITLE, driver.getTitle());
    }
}
