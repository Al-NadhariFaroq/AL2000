package db.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "NON_SUBSCRIBER_RENTALS", schema = "ALNADHAF", catalog = "")
public class NonSubRentalPOJO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NON_SUBSCRIBER_RENTAL_ID")
    private int nonSubscriberRentalId;

    @JoinColumn(name="RENTAL_ID", referencedColumnName = "RENTAL_ID")
    @ManyToOne(optional = false)
    private RentalPOJO rental;
    @Basic
    @Column(name = "CREDIT_CARD_NUMBER")
    private int creditCardNumber;

    public NonSubRentalPOJO() {

    }

    public NonSubRentalPOJO(RentalPOJO rental, int creditCardNumber) {
        this.rental = rental;
        this.creditCardNumber = creditCardNumber;
    }

    public RentalPOJO getRental() {
        return rental;
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
        return nonSubscriberRentalId == that.nonSubscriberRentalId && rental.getMovie() == that.rental.getMovie() &&
               creditCardNumber == that.creditCardNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nonSubscriberRentalId, rental.getMovie(), creditCardNumber);
    }
}
