package fc.support;

import fc.movie.Movie;

import java.util.Objects;

public abstract class Support {
    protected final Movie movie;

    public Support(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Support)) {
            return false;
        }
        Support support = (Support) o;
        return movie.equals(support.movie);
    }

    @Override
    public String toString() {
        return movie.getTitle();
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie);
    }
}
