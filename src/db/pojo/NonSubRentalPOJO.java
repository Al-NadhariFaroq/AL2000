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
    @Basic
    @Column(name = "RENTAL_ID")
    private int rentalId;
    @Basic
    @Column(name = "CREDIT_CARD_NUMBER")
    private int creditCardNumber;

    public NonSubRentalPOJO() {

    }

    public NonSubRentalPOJO(int rentalId, int creditCardNumber) {
        this.rentalId = rentalId;
        this.creditCardNumber = creditCardNumber;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
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
        return nonSubscriberRentalId == that.nonSubscriberRentalId && rentalId == that.rentalId &&
               creditCardNumber == that.creditCardNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nonSubscriberRentalId, rentalId, creditCardNumber);
    }
}
