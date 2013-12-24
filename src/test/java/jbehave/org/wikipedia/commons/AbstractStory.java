package jbehave.org.wikipedia.commons;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.junit.After;
import org.openqa.selenium.WebDriver;

import static org.jbehave.core.reporters.Format.*;

/**
 * Created by Alex.
 */
public abstract class AbstractStory extends JUnitStory {

    private WebDriver driver;
    protected StoryContext storyContext;
    private WebDriverHelper webDriverHelper;

    public AbstractStory() {
        configuredEmbedder().embedderControls()
                .doGenerateViewAfterStories(true)
                .doIgnoreFailureInStories(false)
                .doIgnoreFailureInView(true)
                .useThreads(2)
                .useStoryTimeoutInSecs(60);
        storyContext = new StoryContext();
        webDriverHelper = new WebDriverHelper();
        webDriverHelper.startDriver();
        driver = webDriverHelper.getDriver();
    }

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .usePendingStepStrategy(new FailingUponPendingStep())
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withDefaultFormats()
                        .withFormats(CONSOLE, TXT, HTML, XML));
    }

    @After
    public void tearDown() {
        webDriverHelper.destroyDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
