package db.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PREFERENCE", schema = "ALNADHAF", catalog = "")
public class PreferencePOJO {
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
    @Basic
    @Column(name = "RESTRICTED")
    private boolean restricted;

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

    public boolean isRestricted() {
        return restricted;
    }

    public void setRestricted(boolean restricted) {
        this.restricted = restricted;
    }

    public PreferencePOJO(int restrictionId, long cardNumber, Integer themeId, boolean restricted) {
        this.restrictionId = restrictionId;
        this.cardNumber = cardNumber;
        this.themeId = themeId;
        this.restricted = restricted;
    }

    public PreferencePOJO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PreferencePOJO that = (PreferencePOJO) o;
        return restrictionId == that.restrictionId && cardNumber == that.cardNumber &&
               Objects.equals(themeId, that.themeId) && Objects.equals(restricted, that.restricted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restrictionId, cardNumber, themeId, restricted);
    }
}
