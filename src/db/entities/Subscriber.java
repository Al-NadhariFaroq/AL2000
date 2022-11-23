package db.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SUBSCRIBERS", schema = "ALNADHAF", catalog = "")
public class Subscriber {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "SUBSCRIBER_ID")
    private int subscriberId;
    @Basic
    @Column(name = "EMAIL")
    private String email;
    @Basic
    @Column(name = "CARD_NUMBER")
    private long cardNumber;

    public int getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(int subscriberId) {
        this.subscriberId = subscriberId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Subscriber that = (Subscriber) o;
        return subscriberId == that.subscriberId && cardNumber == that.cardNumber && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriberId, email, cardNumber);
    }
}
