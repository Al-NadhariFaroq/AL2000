package db.entities;
import javax.persistence.*;

@Entity
@Table(name = "cards", schema = "", catalog = "") //schema to specify later
public class Card{
    @Id
    @Column
    private long card_id;
    @Basic
    @Column(nullable = false)
    private long card_number;

    public Card(){

    }
    public long getId() {
        return card_id;
    }

    public void setId(long card_id) {
        this.card_id = card_id;
    }

    public long getCardNumber() {
        return card_number;
    }

    public void setCardNumber(long card_number) {
        this.card_number = card_number;
    }
}

