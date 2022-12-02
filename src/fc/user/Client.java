package fc.user;

import fc.support.Rental;

public class Client implements User {
    private final int creditCardNumber;
    private Rental rental;

    public Client(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
        // search rental in DB
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public Rental getRental() {
        return rental;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Client)) {
            return false;
        }
        Client client = (Client) o;
        return creditCardNumber == client.creditCardNumber && rental.equals(client.rental);
    }

    @Override
    public String toString() {
        return String.valueOf(creditCardNumber);
    }
}
