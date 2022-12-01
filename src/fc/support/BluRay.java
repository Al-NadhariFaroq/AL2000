package fc.support;

import fc.movie.Movie;

import java.util.Objects;

public class BluRay extends Support {
    private final int serialNumber;

    public BluRay(int serialNumber, Movie movie) {
        super(movie);
        this.serialNumber = serialNumber;
    }

    public int getSerialNumber() {
        return serialNumber;
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
        return serialNumber == bluRay.serialNumber && movie.equals(bluRay.movie);
    }

    @Override
    public String toString() {
        return serialNumber + " (" + movie.toString() + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSerialNumber(), movie);
    }
}
