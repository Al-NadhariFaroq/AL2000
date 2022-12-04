package fc.user;

import fc.DatabaseManagement;
import fc.support.BluRayRental;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class NonSubscriber implements Client {
    private final int creditCardNumber;
    private BluRayRental bluRayRental;

    public NonSubscriber(int creditCardNumber, BluRayRental bluRayRental) {
        this.creditCardNumber = creditCardNumber;
        this.bluRayRental = bluRayRental;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public Set<BluRayRental> getBluRayRentals() {
        Set<BluRayRental> bluRayRentals = new HashSet<>();
        bluRayRentals.add(bluRayRental);
        return bluRayRentals;
    }

    public void addBluRayRental(BluRayRental bluRayRental) throws IllegalStateException, NullPointerException {
        if (this.bluRayRental != null) {
            throw new IllegalStateException("only one blu-ray rental authorized");
        }
        if (bluRayRental == null) {
            throw new NullPointerException("variable bluRayRental might not have been initialized");
        }
        this.bluRayRental = bluRayRental;
        DatabaseManagement.createNonSubscriberBluRayRental(bluRayRental, this);
    }

    public void removeBluRayRental(BluRayRental bluRayRental) throws IllegalArgumentException {
        if (!this.bluRayRental.equals(bluRayRental)) {
            throw new IllegalArgumentException("invalid blu-ray rental value");
        }
        this.bluRayRental = null;
        // db
    }

    @Override
    public String toString() {
        return String.valueOf(creditCardNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NonSubscriber)) {
            return false;
        }
        NonSubscriber that = (NonSubscriber) o;
        return creditCardNumber == that.creditCardNumber && Objects.equals(bluRayRental, that.bluRayRental);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditCardNumber, bluRayRental);
    }
}
