package jbehave.org.wikipedia.commons;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 22.12.13.
 */
public class StoryContext {

    public static final String STORY_CLASS_NAME = "STORY_CLASS_NAME";
    private Map<String, Object> context = new HashMap<>();

    public Object get(String key) {
        return context.get(key);
    }

    public void put(String key, Object value) {
        context.put(key, value);
    }

    public boolean containsKey(Object key) {
        return context.containsKey(key);
    }

    public void set(final Enum key, final Object value) {
        put(key.toString(), value);
    }

    public String get(final Enum key) {
        return get(key, String.class);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(final Enum key, final Class<T> clazz) {
        return (T) get(key.toString());
    }

    public boolean isKeySet(final Enum key) {
        return containsKey(key.toString());
    }
}
