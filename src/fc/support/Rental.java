package fc.support;

import fc.movie.Movie;

import java.util.Calendar;
import java.util.Objects;

public class Rental {
    Movie movie;
    Calendar rentalDate;

    public Rental(Movie movie) {
        this.movie = movie;
        this.rentalDate = Calendar.getInstance();
    }

    public Rental(Movie movie, Calendar rentalDate) {
        this.movie = movie;
        this.rentalDate = rentalDate;
    }

    public Movie getMovie() {
        return movie;
    }

    public Calendar getRentalDate() {
        return rentalDate;
    }

    @Override
    public String toString() {
        return "Rental: " + movie + " at " + rentalDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rental)) {
            return false;
        }
        Rental bluRayRental = (Rental) o;
        return Objects.equals(movie, bluRayRental.movie) && Objects.equals(rentalDate, bluRayRental.rentalDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie, rentalDate);
    }
}
