package fc.user;

import fc.support.BluRayRental;

import java.util.Set;

public interface Client extends User {

    int getCreditCardNumber();

    Set<BluRayRental> getBluRayRentals();

    void addBluRayRental(BluRayRental bluRayRental);

    void removeBluRayRental(BluRayRental bluRayRental);
}
