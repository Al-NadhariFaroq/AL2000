package db.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "RESTRICTIONS", schema = "ALNADHAF", catalog = "")
public class Restriction {
    //    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "RESTRICTION_ID")
    private int restrictionId;
    @Basic
    @Column(name = "CARD_NUMBER")
    private long cardNumber;
    @Basic
    @Column(name = "THEME_ID")
    private Integer themeId;

    public int getRestrictionId() {
        return restrictionId;
    }

    public void setRestrictionId(int restrictionId) {
        this.restrictionId = restrictionId;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getThemeId() {
        return themeId;
    }

    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }

    public Restriction(int restrictionId, long cardNumber, Integer themeId) {
        this.restrictionId = restrictionId;
        this.cardNumber = cardNumber;
        this.themeId = themeId;
    }

    public Restriction() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restriction that = (Restriction) o;
        return restrictionId == that.restrictionId && cardNumber == that.cardNumber && Objects.equals(themeId, that.themeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restrictionId, cardNumber, themeId);
    }
}
