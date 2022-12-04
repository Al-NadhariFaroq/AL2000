package fc.support;

import fc.movie.Movie;

import java.util.Objects;

public class BluRay {
    private final int serialNumber;
    private final Movie movie;

    public BluRay(int serialNumber, Movie movie) {
        this.serialNumber = serialNumber;
        this.movie = movie;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public Movie getMovie() {
        return movie;
    }

    @Override
    public String toString() {
        return serialNumber + " (" + movie.toString() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BluRay)) {
            return false;
        }
        BluRay bluRay = (BluRay) o;
        return serialNumber == bluRay.serialNumber && Objects.equals(movie, bluRay.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber, movie);
    }
}
