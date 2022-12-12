package db.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "subscriber_rentals")
@Table(name = "subscriber_rentals", schema = "rocd", catalog = "")
public class SubRentalPOJO implements POJO {
    @Id
    @Column(name = "subscriber_rental_id")
    private int subscriberRentalId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rental_id")
    private RentalPOJO rental;

    @ManyToOne(optional = false)
    @JoinColumn(name = "subscriber_id")
    private SubscriberPOJO subscriber;

    public SubRentalPOJO() {
        super();
    }

    public SubRentalPOJO(int subscriberRentalId, RentalPOJO rental, SubscriberPOJO subscriber) {
        super();
        this.subscriberRentalId = subscriberRentalId;
        this.rental = rental;
        this.subscriber = subscriber;
    }

    public int getID() {
        return subscriberRentalId;
    }

    public void setID(int subscriberRentalId) {
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
        return subscriberRentalId == that.subscriberRentalId && rental.getID() == that.rental.getID() &&
               subscriber.getID() == that.subscriber.getID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriberRentalId, rental.getID(), subscriber.getID());
    }
}
