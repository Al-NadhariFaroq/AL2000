package db.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Subscriber_Rentals")
@Table(name = "SUBSCRIBER_RENTALS", schema = "ALNADHAF", catalog = "")
public class SubRentalPOJO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUBSCRIBER_RENTAL_ID")
    private int subscriberRentalId;
    @Basic
    @Column(name = "RENTAL_ID")
    private int rentalId;
    @Basic
    @Column(name = "SUBSCRIBER_ID")
    private int subscriberID;

    public SubRentalPOJO() {

    }

    public SubRentalPOJO(int rentalId, int subscriberID) {
        this.rentalId = rentalId;
        this.subscriberID = subscriberID;
    }

    public int getSubscriberRentalId() {
        return subscriberRentalId;
    }

    public void setSubscriberRentalId(int subscriberRentalId) {
        this.subscriberRentalId = subscriberRentalId;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public int getSubscriberID() {
        return subscriberID;
    }

    public void setSubscriberID(int subscriberID) {
        this.subscriberID = subscriberID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SubRentalPOJO)) {
            return false;
        }
        SubRentalPOJO that = (SubRentalPOJO) o;
        return subscriberRentalId == that.subscriberRentalId && rentalId == that.rentalId &&
               subscriberID == that.subscriberID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriberRentalId, rentalId, subscriberID);
    }
}
