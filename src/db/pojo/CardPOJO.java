package db.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CARDS", schema = "ALNADHAF", catalog = "")
public class CardPOJO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CARD_ID")
    private long cardId;
    @Basic
    @Column(name = "CARD_NUMBER")
    private long cardNumber;

    public long getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
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
        CardPOJO that = (CardPOJO) o;
        return cardId == that.cardId && cardNumber == that.cardNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, cardNumber);
    }
}
