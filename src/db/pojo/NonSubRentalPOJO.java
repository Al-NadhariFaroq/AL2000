package db.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "non_subscriber_rentals")
@Table(name = "non_subscriber_rentals", schema = "rocd", catalog = "")
public class NonSubRentalPOJO implements POJO {
    @Id
    @Column(name = "non_subscriber_rental_id")
    private int nonSubscriberRentalId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rental_id", referencedColumnName = "rental_id")
    private RentalPOJO rental;

    @Basic(optional = false)
    @Column(name = "credit_card_number")
    private int creditCardNumber;

    public NonSubRentalPOJO() {

    }

    public NonSubRentalPOJO(int nonSubscriberRentalId, RentalPOJO rental, int creditCardNumber) {
        this.nonSubscriberRentalId = nonSubscriberRentalId;
        this.rental = rental;
        this.creditCardNumber = creditCardNumber;
    }

    public int getID() {
        return nonSubscriberRentalId;
    }

    public void setID(int nonSubscriberRentalId) {
        this.nonSubscriberRentalId = nonSubscriberRentalId;
    }

    public RentalPOJO getRental() {
        return rental;
    }

    public void setRental(RentalPOJO rental) {
        this.rental = rental;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NonSubRentalPOJO)) {
            return false;
        }
        NonSubRentalPOJO that = (NonSubRentalPOJO) o;
        return nonSubscriberRentalId == that.nonSubscriberRentalId && rental.getID() == that.rental.getID() &&
               creditCardNumber == that.creditCardNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nonSubscriberRentalId, rental.getMovie().getTitle(), creditCardNumber);
    }
}
