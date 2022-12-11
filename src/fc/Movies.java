package fc;

import fc.movie.Movie;
import fc.movie.Rating;
import fc.movie.SearchType;
import fc.movie.SortType;
import fc.support.BluRay;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Vector;

public class Movies {
    private final Set<Movie> bluRaysSortedMovies;
    private final Set<Movie> ratingSortedMovies;
    private final Set<Movie> themesSortedMovies;
    private final List<Movie> searchSortedMovies;

    private boolean bluRaysOnly;
    private Rating rating;
    private Set<String> themes;
    private SearchType searchType;
    private String searchWords;
    private SortType sortType;

    Movies() {
        this(false, Rating.UR, new HashSet<>(), SearchType.TITLE, null, SortType.DATE_ASC);
    }

    Movies(boolean bluRaysOnly,
           Rating rating,
           Set<String> themes,
           SearchType searchType,
           String searchWords,
           SortType sortType
    ) {
        this.bluRaysSortedMovies = new HashSet<>();
        this.ratingSortedMovies = new HashSet<>();
        this.themesSortedMovies = new HashSet<>();
        this.searchSortedMovies = new Vector<>();

        this.bluRaysOnly = bluRaysOnly;
        this.rating = rating;
        this.themes = themes;
        this.searchType = searchType;
        this.searchWords = searchWords;
        this.sortType = sortType;

        updateFromDatabase();
    }

    public List<Movie> getSortedMovies() {
        return searchSortedMovies;
    }

    public boolean isBluRaysOnly() {
        return bluRaysOnly;
    }

    public void setBluRaysOnly(boolean bluRaysOnly) {
        this.bluRaysOnly = bluRaysOnly;
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

    public String getSearchWords() {
        return searchWords;
    }

    public void setSearchWords(String searchWords) {
        this.searchWords = searchWords;
    }

    public SortType getSortType() {
        return sortType;
    }

    public void setSortType(SortType sortType) {
        this.sortType = sortType;
    }

    public void updateFromDatabase() {
        sortBluRays();
    }

    public void sortBluRays() {
        bluRaysSortedMovies.clear();
        if (bluRaysOnly) {
            Set<BluRay> bluRays = DatabaseManagement.readAllBluRays().keySet();
            bluRays.forEach(bluRay -> bluRaysSortedMovies.add(bluRay.getMovie()));
        } else {
            bluRaysSortedMovies.addAll(DatabaseManagement.readAllMovies());
        }

        sortRating();
    }

    public void sortRating() {
        ratingSortedMovies.clear();
        bluRaysSortedMovies.forEach(movie -> {
            if (movie.getRating().ordinal() <= rating.ordinal()) {
                ratingSortedMovies.add(movie);
            }
        });

        sortThemes();
    }

    public void sortThemes() {
        themesSortedMovies.clear();
        ratingSortedMovies.forEach(movie -> {
            themes.forEach(theme -> {
                if (movie.getThemes().contains(theme)) {
                    themesSortedMovies.add(movie);
                }
            });
        });

        sortMovies();
    }

    public void sortMovies() {
        searchSortedMovies.clear();
        if (searchWords == null || searchWords.isEmpty()) {
            searchSortedMovies.addAll(themesSortedMovies);
        } else {
            themesSortedMovies.forEach(movie -> {
                if (searchType.isContainsInMovie(movie, searchWords)) {
                    searchSortedMovies.add(movie);
                }
            });
        }

        orderMovies();
    }

    public void orderMovies() {
        searchSortedMovies.sort(sortType.getComparator());
    }
}
