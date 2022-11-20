package db.entities;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Basic;

@Entity
@Table(name = "subscribers", schema = "", catalog = "") //schema to specify later
public class Subscriber{
    @Id
    @Column
    private long subscriber_id;
    @Basic
    @Column(nullable = false, unique = true)
    private String email;
    @Basic
    @Column(nullable = false)
    private long card_number;

    public Subscriber(long subscriber_id, String email, long card_number) {
        this.subscriber_id = subscriber_id;
        this.email = email;
        this.card_number = card_number;
    }

    public Subscriber(){

    }

    public long getId() {
        return subscriber_id;
    }

    public void setId(long subscriber_id) {
        this.subscriber_id = subscriber_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCardNumber() {
        return card_number;
    }

    public void setCardNumber(long card_number) {
        this.card_number = card_number;
    }
}

