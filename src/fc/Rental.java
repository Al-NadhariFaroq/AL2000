package fc;

import java.util.Calendar;
import java.util.Date;

public class Rental {
    Date rentalDate;
    Date returnDate;
    Support support;

    public Rental(Support s) {
        support = s;
        rentalDate = Calendar.getInstance().getTime();
    }

    public Support getSupport() {
        return support;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        Rental rental = (Rental) o;

        return rental.rentalDate.equals(rentalDate) && rental.returnDate.equals(returnDate) &&
               rental.support.equals(support);
    }

    @Override
    public String toString() {
        return "Rental: " + support + " at " + rentalDate;
    }
}
