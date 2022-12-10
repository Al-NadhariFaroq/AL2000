package db.pojo;

import fc.support.BluRay;
import fc.support.Rental;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity(name = "Blu_Ray_Rentals")
@Table(name = "BLU_RAY_RENTALS", schema = "ALNADHAF", catalog = "")
public class BluRayRentalPOJO {
    @Id
    @Column(name = "BLU_RAY_RENTAL_ID")
    private int bluRayRentalId;

    @ManyToOne
    @JoinColumn(name = "RENTAL_ID")
    private RentalPOJO rental;

    @ManyToOne
    @JoinColumn(name = "BLU_RAY_ID")
    private BluRayPOJO bluRay;
    @Basic
    @Column(name = "RETURN_DATE")
    private Date returnDate;

    public BluRayRentalPOJO() {

    }

    public BluRayRentalPOJO(int bluRayRentalId, RentalPOJO rental, BluRayPOJO bluRay, Date returnDate) {
        this.bluRayRentalId = bluRayRentalId;
        this.rental = rental;
        this.bluRay = bluRay;
        this.returnDate = returnDate;
    }

    public int getBluRayRentalId() {
        return bluRayRentalId;
    }

    public void setBluRayRentalId(int bluRayRentalId) {
        this.bluRayRentalId = bluRayRentalId;
    }

    public RentalPOJO getRental() {
        return rental;
    }

    public void setRental(RentalPOJO rental) {
        this.rental = rental;
    }

    public BluRayPOJO getBluRay() {
        return bluRay;
    }

    public void setBluRay(BluRayPOJO bluRay) {
        this.bluRay = bluRay;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BluRayRentalPOJO)) {
            return false;
        }
        BluRayRentalPOJO that = (BluRayRentalPOJO) o;
        return bluRayRentalId == that.bluRayRentalId && rental.getRentalId() == that.rental.getRentalId() && bluRay.getBluRayId() == that.bluRay.getBluRayId() &&
               Objects.equals(returnDate, that.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bluRayRentalId, rental.getRentalId(), bluRay.getBluRayId(), returnDate);
    }
}
