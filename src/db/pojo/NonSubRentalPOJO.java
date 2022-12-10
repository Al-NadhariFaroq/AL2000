package db.pojo;

import db.dao.RentalDAO;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Non_Subscriber_rentals")
@Table(name = "NON_SUBSCRIBER_RENTALS", schema = "ALNADHAF", catalog = "")
public class NonSubRentalPOJO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public int getNonSubscriberRentalId() {
        return nonSubscriberRentalId;
    }

    public void setNonSubscriberRentalId(int nonSubscriberRentalId) {
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
        return nonSubscriberRentalId == that.nonSubscriberRentalId && rental.getRentalId() == that.rental.getRentalId() &&
               creditCardNumber == that.creditCardNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nonSubscriberRentalId, rental.getMovie().getTitle(), creditCardNumber);
    }
}
