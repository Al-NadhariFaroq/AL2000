package db.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "SUBSCRIBER_CARDS", schema = "ALNADHAF", catalog = "")
public class SubscriberCards {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "SUBSCRIBER_CARD_ID")
    private int subscriberCardId;
    @Basic
    @Column(name = "SUBSCRIBER_CARD_NUMBER")
    private long subscriberCardNumber;
    @Basic
    @Column(name = "IS_SUBSCRIBER")
    private boolean isSubscriber;
    @Basic
    @Column(name = "CARDHOLDER_LAST_NAME")
    private String cardholderLastName;
    @Basic
    @Column(name = "CARDHOLDER_FIRST_NAME")
    private String cardholderFirstName;
    @Basic
    @Column(name = "BIRTH_DATE")
    private Date birthDate;
    @Basic
    @Column(name = "CARD_BALANCE")
    private Integer cardBalance;
    @JoinColumn(name="SUBSCRIBER_ID", referencedColumnName = "SUBSCRIBER_ID")
    @ManyToOne(optional = false)
//    @Column(name = "SUBSCRIBER_ID")
    private Subscriber subscriberId;

    public int getSubscriberCardId() {
        return subscriberCardId;
    }

    public void setSubscriberCardId(int subscriberCardId) {
        this.subscriberCardId = subscriberCardId;
    }

    public long getSubscriberCardNumber() {
        return subscriberCardNumber;
    }

    public void setSubscriberCardNumber(long subscriberCardNumber) {
        this.subscriberCardNumber = subscriberCardNumber;
    }

    public boolean isSubscriber() {
        return isSubscriber;
    }

    public void setSubscriber(boolean subscriber) {
        isSubscriber = subscriber;
    }

    public String getCardholderLastName() {
        return cardholderLastName;
    }

    public void setCardholderLastName(String cardholderLastName) {
        this.cardholderLastName = cardholderLastName;
    }

    public String getCardholderFirstName() {
        return cardholderFirstName;
    }

    public void setCardholderFirstName(String cardholderFirstName) {
        this.cardholderFirstName = cardholderFirstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(Integer cardBalance) {
        this.cardBalance = cardBalance;
    }

//    public int getSubscriberId() {
//        return subscriberId;
//    }
//
//    public void setSubscriberId(int subscriberId) {
//        this.subscriberId = subscriberId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SubscriberCards that = (SubscriberCards) o;
        return subscriberCardId == that.subscriberCardId && subscriberCardNumber == that.subscriberCardNumber && isSubscriber == that.isSubscriber && subscriberId == that.subscriberId && Objects.equals(
                cardholderLastName, that.cardholderLastName) && Objects.equals(cardholderFirstName,
                                                                               that.cardholderFirstName
        ) && Objects.equals(birthDate, that.birthDate) && Objects.equals(cardBalance, that.cardBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriberCardId, subscriberCardNumber, isSubscriber, cardholderLastName,
                            cardholderFirstName, birthDate, cardBalance, subscriberId
        );
    }
}
