package jbehave.org.wikipedia.stories;

import jbehave.org.wikipedia.commons.AbstractStory;
import jbehave.org.wikipedia.steps.WikipediaGivenSteps;
import jbehave.org.wikipedia.steps.WikipediaThenSteps;
import jbehave.org.wikipedia.steps.WikipediaWhenSteps;

/**
 * Created by Alex.
 */
public class WikipediaLanguageStory extends AbstractStory {

    @Override
    public Object[] requiredSteps() {
        return new Object[] {
                new WikipediaGivenSteps(getDriver(), storyContext),
                new WikipediaWhenSteps(getDriver(), storyContext),
                new WikipediaThenSteps(getDriver(), storyContext)
        };
    }
}
