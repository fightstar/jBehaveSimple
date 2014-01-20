package jbehave.org.wikipedia.commons;

import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.jbehave.core.reporters.Format.*;

/**
 * Created by Alex.
 */
public abstract class AbstractStory extends JUnitStory {

    private Configuration configuration;
    private WebDriver driver;
    protected StoryContext storyContext;
    protected WebDriverHelper webDriverHelper;

    public abstract Object[] requiredSteps();

    @Before
    public void setUp() {
        storyContext = new StoryContext();
        webDriverHelper = new WebDriverHelper();
        webDriverHelper.startDriver();
        driver = webDriverHelper.getDriver();
    }

    public AbstractStory() {
        configuredEmbedder().embedderControls()
                .doGenerateViewAfterStories(true)
                .doIgnoreFailureInStories(false)
                .doIgnoreFailureInView(true)
                .useStoryTimeoutInSecs(60);
    }

    @Override
    public Configuration configuration() {
        if (configuration == null) {
            return new MostUsefulConfiguration()
                    .usePendingStepStrategy(new FailingUponPendingStep())
                    .useStoryLoader(new LoadFromClasspath(this.getClass()))
                    .useStoryReporterBuilder(
                            new StoryReporterBuilder()
                                    .withDefaultFormats()
                                    .withFormats(CONSOLE, TXT, HTML, XML));
        }
        return configuration;
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), (Object[]) requiredSteps());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
