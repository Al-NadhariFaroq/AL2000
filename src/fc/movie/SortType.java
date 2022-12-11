package fc.movie;

import java.util.Comparator;

public enum SortType {
    TITLE_AZ("title (a-z)"),
    TITLE_ZA("title (z-a)"),
    DATE_ASC("date (asc)"),
    DATE_DES("date (des)"),
    SCORE_ASC("score (asc)"),
    SCORE_DES("score (des)"),
    LENGTH_ASC("length (asc)"),
    LENGTH_DES("length (des)");

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
                case DATE_ASC:
                    return movie1.getReleaseDate().compareTo(movie2.getReleaseDate());
                case DATE_DES:
                    return movie2.getReleaseDate().compareTo(movie1.getReleaseDate());
                case SCORE_ASC:
                    return movie1.getScore().compareTo(movie2.getScore());
                case SCORE_DES:
                    return movie2.getScore().compareTo(movie1.getScore());
                case LENGTH_ASC:
                    return movie1.getRunningTime().compareTo(movie2.getRunningTime());
                case LENGTH_DES:
                    return movie2.getRunningTime().compareTo(movie1.getRunningTime());
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
