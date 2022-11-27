package db.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "RENTALS", schema = "ALNADHAF", catalog = "")
public class RentalPOJO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "RENTAL_ID")
    private int rentalId;
    @Basic
    @Column(name = "CARD_NUMBER")
    private long cardNumber;
    @Basic
    @Column(name = "RENTAL_DATE")
    private Date rentalDate;
    @Basic
    @Column(name = "RETURN_DATE")
    private Date returnDate;
    @Basic
    @Column(name = "BILLING_ADDRESS")
    private String billingAddress;
    @Basic
    @Column(name = "IS_BLU_RAY")
    private Integer isBluRay;
    @Basic
    @Column(name = "FILM_ID")
    private int filmId;
    @Basic
    @Column(name = "CARD_ID")
    private int cardId;

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Integer getIsBluRay() {
        return isBluRay;
    }

    public void setIsBluRay(Integer isBluRay) {
        this.isBluRay = isBluRay;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RentalPOJO that = (RentalPOJO) o;
        return rentalId == that.rentalId && cardNumber == that.cardNumber && filmId == that.filmId &&
               cardId == that.cardId && Objects.equals(rentalDate, that.rentalDate) &&
               Objects.equals(returnDate, that.returnDate) && Objects.equals(billingAddress, that.billingAddress) &&
               Objects.equals(isBluRay, that.isBluRay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rentalId, cardNumber, rentalDate, returnDate, billingAddress, isBluRay, filmId, cardId);
    }
}
