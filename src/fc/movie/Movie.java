package fc.movie;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Movie {
    private final String title;
    private final Calendar date;
    private final List<String> themes;
    private final List<String> directors;
    private final Map<String, String> actors; // LinkedHashMap recommended
    private final String synopsis;
    private final Rating rating;
    private final Float score;
    private final String linkURL;
    private final String posterURL;

    public Movie(String title,
                 Calendar date,
                 List<String> themes,
                 List<String> directors,
                 Map<String, String> actors,
                 String synopsis,
                 Rating rating,
                 Float score,
                 String linkURL,
                 String posterURL
    ) {
        this.title = title;
        this.date = date;
        this.themes = themes;
        this.directors = directors;
        this.actors = actors;
        this.synopsis = synopsis;
        this.rating = rating;
        this.score = score;
        this.linkURL = linkURL;
        this.posterURL = posterURL;
    }

    public String getTitle() {
        return title;
    }

    public Calendar getDate() {
        return date;
    }

    public List<String> getThemes() {
        return themes;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public Map<String, String> getActorsWithRoles() {
        return actors;
    }

    public List<String> getActors() {
        return new ArrayList<>(actors.keySet());
    }

    public List<String> getRoles() {
        return new ArrayList<>(actors.values());
    }

    public String getSynopsis() {
        return synopsis;
    }

    public Rating getRating() {
        return rating;
    }

    public Float getScore() {
        return score;
    }

    public String getLinkURL() {
        return linkURL;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public boolean isContainedInTitle(String text) {
        return isContainedInString(title, text);
    }

    public boolean isContainedInDirectors(String text) {
        return isContainedInString(String.join(" ", directors), text);
    }

    public boolean isContainedInActors(String text) {
        return isContainedInString(String.join(" ", actors.keySet()), text);
    }

    public boolean isContainedInRoles(String text) {
        return isContainedInString(String.join(" ", actors.values()), text);
    }

    public boolean isContainedInSynopsis(String text) {
        return isContainedInString(synopsis, text);
    }

    private boolean isContainedInString(String string, String text) {
        String[] words = text.replaceAll("\\p{P}", " ").toLowerCase().split("\\s+");
        string = string.toLowerCase();
        for (String word : words) {
            if (!string.contains(word)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return title + " (" + date.get(Calendar.YEAR) + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Movie)) {
            return false;
        }
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title) && Objects.equals(date, movie.date) &&
               Objects.equals(themes, movie.themes) && Objects.equals(directors, movie.directors) &&
               Objects.equals(actors, movie.actors) && Objects.equals(synopsis, movie.synopsis) &&
               rating == movie.rating && Objects.equals(score, movie.score) && Objects.equals(linkURL, movie.linkURL) &&
               Objects.equals(posterURL, movie.posterURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, date, themes, directors, actors, synopsis, rating, score, linkURL, posterURL);
    }
}
