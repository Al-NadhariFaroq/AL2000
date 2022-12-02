package fc.support;

import java.util.Calendar;
import java.util.Objects;

public class Rental {
    Support support;
    Calendar rentalDate;
    Calendar returnDate;

    public Rental(Support s) {
        support = s;
        rentalDate = Calendar.getInstance();
    }

    public Support getSupport() {
        return support;
    }

    public Calendar getRentalDate() {
        return rentalDate;
    }

    public Calendar getReturnDate() {
        return returnDate;
    }

    public void returnSupport() {
        this.returnDate = Calendar.getInstance();
    }

    @Override
    public String toString() {
        return "Rental: " + support + " at " + rentalDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rental)) {
            return false;
        }
        Rental rental = (Rental) o;
        return Objects.equals(support, rental.support) && Objects.equals(rentalDate, rental.rentalDate) &&
               Objects.equals(returnDate, rental.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(support, rentalDate, returnDate);
    }
}
