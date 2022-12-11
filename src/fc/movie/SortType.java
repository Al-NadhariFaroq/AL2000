package fc.movie;

import java.util.Comparator;

public enum SortType {
    TITLE_AZ("Title (a-z)"),
    TITLE_ZA("Title (z-a)"),
    DATE_DES("Date (des)"),
    DATE_ASC("Date (asc)"),
    SCORE_DES("Score (des)"),
    SCORE_ASC("Score (asc)"),
    LENGTH_DES("Length (des)"),
    LENGTH_ASC("Length (asc)");

    private final String description;

    SortType(String description) {
        this.description = description;
    }

    public Comparator<Movie> getComparator() {
        SortType sortType = this;
        return (movie1, movie2) -> {
            switch (sortType) {
                case TITLE_AZ:
                    return movie1.getTitle().compareTo(movie2.getTitle());
                case TITLE_ZA:
                    return movie2.getTitle().compareTo(movie1.getTitle());
                case DATE_DES:
                    return movie2.getReleaseDate().compareTo(movie1.getReleaseDate());
                case DATE_ASC:
                    return movie1.getReleaseDate().compareTo(movie2.getReleaseDate());
                case SCORE_DES:
                    return movie2.getScore().compareTo(movie1.getScore());
                case SCORE_ASC:
                    return movie1.getScore().compareTo(movie2.getScore());
                case LENGTH_DES:
                    return movie2.getRunningTime().compareTo(movie1.getRunningTime());
                case LENGTH_ASC:
                    return movie1.getRunningTime().compareTo(movie2.getRunningTime());
                default:
                    return 0;
            }
        };
    }

    @Override
    public String toString() {
        return description;
    }
}
