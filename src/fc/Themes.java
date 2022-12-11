package fc;

import fc.user.Subscriber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class Themes {
    public static final int INCLUDED = 0;
    public static final int EXCLUDED = 1;
    public static final int FORBIDDEN = 2;

    private final Map<String, Integer> themes;

    Themes() {
        themes = new LinkedHashMap<>();
        updateFromDatabase();
    }

    public List<String> getAllThemes() {
        return new ArrayList<>(themes.keySet());
    }

    public Set<String> getIncludedThemes() {
        return getSpecifiedThemes(themes, INCLUDED);
    }

    public Set<String> getExcludedThemes() {
        return getSpecifiedThemes(themes, EXCLUDED);
    }

    public Set<String> getForbiddenThemes() {
        return getSpecifiedThemes(themes, FORBIDDEN);
    }

    public static Set<String> getSpecifiedThemes(Map<String, Integer> themes, int a) {
        Set<String> includedThemes = new HashSet<>();
        themes.forEach((theme, availability) -> {
            if (availability == a) {
                includedThemes.add(theme);
            }
        });
        return includedThemes;
    }

    public int getAvailability(String theme) throws IllegalArgumentException {
        if (!themes.containsKey(theme)) {
            throw new IllegalArgumentException("Invalid theme value");
        }
        return themes.get(theme);
    }

    public void setAvailability(String theme, int availability) throws IllegalArgumentException {
        if (!themes.containsKey(theme)) {
            throw new IllegalArgumentException("Invalid theme value");
        }
        if (availability < INCLUDED || availability > FORBIDDEN) {
            throw new IllegalArgumentException("Invalid availability value");
        }
        themes.replace(theme, availability);
    }

    public void forEach(BiConsumer<? super String, ? super Integer> action) {
        themes.forEach(action);
    }

    public void updateFromDatabase() {
        themes.clear();
        List<String> newThemes = DatabaseManagement.readAllThemes();
        newThemes.forEach(theme -> themes.put(theme, INCLUDED));
    }

    public void updateAvailabilities(Subscriber subscriber) {
        themes.forEach((theme, available) -> {
            if (subscriber.getForbiddenThemes().contains(theme)) {
                available = FORBIDDEN;
            } else if (subscriber.getExcludedThemes().contains(theme)) {
                available = EXCLUDED;
            } else {
                available = INCLUDED;
            }
        });
    }

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
        themes.forEach((theme, availability) -> {
            String availabilityString = "error";
            if (availability == INCLUDED) {
                availabilityString = "included";
            } else if (availability == EXCLUDED) {
                availabilityString = "excluded";
            } else if (availability == FORBIDDEN) {
                availabilityString = "forbidden";
            }
            txt.append(theme).append(" (").append(availabilityString).append(")\n");
        });
        return txt.toString();
    }
}
