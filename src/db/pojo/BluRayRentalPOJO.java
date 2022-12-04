package db.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "BLU_RAY_RENTALS", schema = "ALNADHAF", catalog = "")
public class BluRayRentalPOJO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "BLU_RAY_RENTAL_ID")
    private int bluRayRentalId;
    @Basic
    @Column(name = "RENTAL_ID")
    private int rentalId;
    @Basic
    @Column(name = "BLU_RAY_ID")
    private int bluRayId;
    @Basic
    @Column(name = "RETURN_DATE")
    private Date returnDate;

    public BluRayRentalPOJO() {

    }

    public BluRayRentalPOJO(int rentalId, int bluRayId, Date returnDate) {
        this.rentalId = rentalId;
        this.bluRayId = bluRayId;
        this.returnDate = returnDate;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public int getBluRayId() {
        return bluRayId;
    }

    public void setBluRayId(int bluRayId) {
        this.bluRayId = bluRayId;
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
        return bluRayRentalId == that.bluRayRentalId && rentalId == that.rentalId && bluRayId == that.bluRayId &&
               Objects.equals(returnDate, that.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bluRayRentalId, rentalId, bluRayId, returnDate);
    }
}
