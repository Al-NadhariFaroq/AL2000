package db.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Subscriber_Rentals")
@Table(name = "SUBSCRIBER_RENTALS", schema = "ALNADHAF", catalog = "")
public class SubRentalPOJO {
    @Id
    @Column(name = "SUBSCRIBER_RENTAL_ID")
    private int subscriberRentalId;
    @ManyToOne
    @JoinColumn(name = "RENTAL_ID")
    private RentalPOJO rental;

    @ManyToOne
    @JoinColumn(name = "SUBSCRIBER_ID")
    private SubscriberPOJO subscriber;

    public SubRentalPOJO() {

    }

    public SubRentalPOJO(int subscriberRentalId, RentalPOJO rental, SubscriberPOJO subscriber) {
        this.subscriberRentalId = subscriberRentalId;
        this.rental = rental;
        this.subscriber = subscriber;
    }

    public int getSubscriberRentalId() {
        return subscriberRentalId;
    }

    public void setSubscriberRentalId(int subscriberRentalId) {
        this.subscriberRentalId = subscriberRentalId;
    }

    public RentalPOJO getRental() {
        return rental;
    }

    public void setRental(RentalPOJO rental) {
        this.rental = rental;
    }

    public SubscriberPOJO getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(SubscriberPOJO subscriber) {
        this.subscriber = subscriber;
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
        return subscriberRentalId == that.subscriberRentalId && rental.getRentalId() == that.rental.getRentalId() &&
               subscriber.getSubscriberId() == that.subscriber.getSubscriberId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriberRentalId, rental.getRentalId(), subscriber.getSubscriberId());
    }
}
