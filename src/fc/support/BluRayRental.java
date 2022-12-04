package fc.support;

import java.util.Calendar;
import java.util.Objects;

public class BluRayRental {
    BluRay bluRay;
    Calendar rentalDate;
    Calendar returnDate;

    public BluRayRental(BluRay bluRay) {
        this.bluRay = bluRay;
        this.rentalDate = Calendar.getInstance();
        this.returnDate = null;
    }

    public BluRayRental(BluRay bluRay, Calendar rentalDate, Calendar returnDate) {
        this.bluRay = bluRay;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }

    public BluRay getBluRay() {
        return bluRay;
    }

    public Calendar getRentalDate() {
        return rentalDate;
    }

    public Calendar getReturnDate() {
        return returnDate;
    }

    public void returnBluRay() throws IllegalStateException {
        if (returnDate != null) {
            throw new IllegalStateException("cannot return a support already return");
        }
        this.returnDate = Calendar.getInstance();
    }

    @Override
    public String toString() {
        return "Rental: " + bluRay + " from " + rentalDate + " to " + (returnDate == null ? "rented" : returnDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BluRayRental)) {
            return false;
        }
        BluRayRental bluRayRental = (BluRayRental) o;
        return Objects.equals(bluRay, bluRayRental.bluRay) && Objects.equals(rentalDate, bluRayRental.rentalDate) &&
               Objects.equals(returnDate, bluRayRental.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bluRay, rentalDate, returnDate);
    }
}
