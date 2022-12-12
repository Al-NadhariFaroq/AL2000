package db.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity(name = "blu_ray_rentals")
@Table(name = "blu_ray_rentals", schema = "rocd", catalog = "")
public class BluRayRentalPOJO implements POJO {
    @Id
    @Column(name = "blu_ray_rental_id")
    private int bluRayRentalId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rental_id")
    private RentalPOJO rental;

    @ManyToOne(optional = false)
    @JoinColumn(name = "blu_ray_id")
    private BluRayPOJO bluRay;

    @Basic
    @Column(name = "return_date")
    private Date returnDate;

    public BluRayRentalPOJO() {
        super();
    }

    public BluRayRentalPOJO(int bluRayRentalId, RentalPOJO rental, BluRayPOJO bluRay, Date returnDate) {
        super();
        this.bluRayRentalId = bluRayRentalId;
        this.rental = rental;
        this.bluRay = bluRay;
        this.returnDate = returnDate;
    }

    public int getID() {
        return bluRayRentalId;
    }

    public void setID(int bluRayRentalId) {
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
        return bluRayRentalId == that.bluRayRentalId && rental.getID() == that.rental.getID() &&
               bluRay.getID() == that.bluRay.getID() && Objects.equals(returnDate, that.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bluRayRentalId, rental.getID(), bluRay.getID(), returnDate);
    }
}
