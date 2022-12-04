package fc;

import fc.movie.Movie;
import fc.movie.Rating;
import fc.movie.SearchType;
import fc.movie.SortType;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Vector;

public class Movies {
    private final Set<Movie> allMovies;
    private final List<Movie> sortedMovies;

    private Rating rating;
    private boolean bluRaysOnly;
    private Set<String> themes;
    private SearchType searchType;
    private SortType sortType;

    Movies() {
        this(Rating.UR, false, new HashSet<>(), SearchType.TITLE, SortType.DATE_ASC);
    }

    Movies(Rating rating, boolean bluRaysOnly, Set<String> themes, SearchType searchType, SortType sortType) {
        this.allMovies = new HashSet<>();
        this.sortedMovies = new Vector<>();

        this.rating = rating;
        this.bluRaysOnly = bluRaysOnly;
        this.themes = themes;
        this.searchType = searchType;
        this.sortType = sortType;

        updateFromDatabase();
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

    public boolean isBluRaysOnly() {
        return bluRaysOnly;
    }

    public void setBluRaysOnly(boolean bluRaysOnly) {
        this.bluRaysOnly = bluRaysOnly;
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

    public void updateFromDatabase() {
        allMovies.clear();
        allMovies.addAll(DatabaseManagement.readAllMovies());

        sortedMovies.clear();
        sortedMovies.addAll(allMovies);

        sortRating();
        sortBluRays();
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

    public void sortBluRays() {
        // keep only movie which has a Blu-ray
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
