package fc.movie;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Vector;

public class MovieDatabase {
    private final Set<Movie> allMovies;
    private final List<Movie> sortedMovies;

    private Rating rating;
    private Set<String> themes;
    private SearchType searchType;
    private SortType sortType;

    public MovieDatabase() {
        this(Rating.UR, null, SearchType.TITLE, SortType.DATE_ASC);
    }

    public MovieDatabase(Rating rating, Set<String> themes, SearchType searchType, SortType sortType) {
        this.allMovies = new HashSet<>();
        this.sortedMovies = new Vector<>();
        this.rating = rating;
        this.themes = themes;
        this.searchType = searchType;
        this.sortType = sortType;
        updateDatabase();
    }

    public List<Movie> getSortedMovies() {
        return sortedMovies;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Set<String> getThemes() {
        return themes;
    }

    public void setThemes(Set<String> themes) {
        this.themes = themes;
    }

    public SearchType getSearchType() {
        return searchType;
    }

    public void setSearchType(SearchType searchType) {
        this.searchType = searchType;
    }

    public SortType getSortType() {
        return sortType;
    }

    public void setSortType(SortType sortType) {
        this.sortType = sortType;
    }

    public void updateDatabase() {
        allMovies.clear();
        // read in DB all movies
        // insert in allMovies
        // insert in sortedMovies
        sortRating();
        sortThemes();
        orderMovies();
    }

    public void sortRating() {
        sortedMovies.clear();
        allMovies.forEach(movie -> {
            if (movie.getRating().compareTo(rating) <= 0) {
                sortedMovies.add(movie);
            }
        });
    }

    public void sortThemes() {
        Set<Movie> tmpMovies1;
        Set<Movie> tmpMovies2 = new HashSet<>(sortedMovies);
        for (String theme : themes) {
            tmpMovies1 = new HashSet<>(tmpMovies2);
            tmpMovies2.clear();
            tmpMovies1.forEach(movie -> {
                if (movie.getThemes().contains(theme)) {
                    sortedMovies.add(movie);
                } else {
                    tmpMovies2.add(movie);
                }
            });
        }
    }

    public void sortMovies(String text) {
        sortedMovies.clear();
        allMovies.forEach(movie -> {
            if (searchType.isContainsInMovie(movie, text)) {
                sortedMovies.add(movie);
            }
        });
        orderMovies();
    }

    public void orderMovies() {
        sortedMovies.sort(sortType.getComparator());
    }
}
