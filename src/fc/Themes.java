package fc;

import fc.user.Subscriber;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class Themes {
    public static final int INCLUDED = 0;
    public static final int EXCLUDED = 1;
    public static final int FORBIDDEN = 2;

    private final Map<String, Integer> themes;

    public Themes() {
        themes = new LinkedHashMap<>();
        updateThemes();
    }

    public List<String> getThemes() {
        return new ArrayList<>(themes.keySet());
    }

    public Collection<String> getIncludedThemes() {
        Collection<String> includedThemes = new HashSet<>();
        themes.forEach((theme, availability) -> {
            if (availability == INCLUDED) {
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

    public void updateThemes() {
        themes.clear();
        // read themes in DB
        // insert them in importance order with DISPLAY

        themes.put("action", INCLUDED);
        themes.put("adventure", INCLUDED);
        themes.put("science fiction", INCLUDED);
        themes.put("anime", INCLUDED);
        themes.put("animation", INCLUDED);
        themes.put("comedy", INCLUDED);
        themes.put("drama", INCLUDED);
        themes.put("crime", INCLUDED);
        themes.put("horror", INCLUDED);
        themes.put("fantasy", INCLUDED);
        themes.put("thriller", INCLUDED);
        themes.put("fantastique", INCLUDED);
        themes.put("western", INCLUDED);
        themes.put("romance", INCLUDED);
        themes.put("musical", INCLUDED);
        themes.put("historical", INCLUDED);
        themes.put("documentary", INCLUDED);
        themes.put("anthology", INCLUDED);
    }

    public void updateAvailabilities(Subscriber subscriber) {
        themes.forEach((theme, available) -> {
            if (subscriber.getSubscribeCard().getForbiddenThemes().contains(theme)) {
                available = FORBIDDEN;
            } else if (subscriber.getSubscribeCard().getHiddenThemes().contains(theme)) {
                available = EXCLUDED;
            } else {
                available = INCLUDED;
            }
        });
    }

    @Override
    public String toString() {
        List<String> tmp = new ArrayList<>();
        themes.forEach((theme, availability) -> {
            String availabilityString;
            switch (availability) {
                case INCLUDED:
                    availabilityString = "included";
                    break;
                case EXCLUDED:
                    availabilityString = "excluded";
                    break;
                case FORBIDDEN:
                    availabilityString = "forbidden";
                    break;
                default:
                    availabilityString = "error";
                    break;
            }
            tmp.add(theme + " (" + availabilityString + ")");
        });
        return String.join(", ", tmp);
    }
}
