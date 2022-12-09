package db.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity(name = "Rentals")
@Table(name = "RENTALS", schema = "ALNADHAF", catalog = "")
public class RentalPOJO {
    @Id
    @Column(name = "RENTAL_ID")
    private int rentalId;
    @Basic
    @Column(name = "MOVIE_ID")
    private int movieId;
    @Basic
    @Column(name = "RENTAL_DATE")
    private Date rentalDate;

    public RentalPOJO() {

    }

    public RentalPOJO(int rentalId, int movieId, Date rentalDate) {
        this.rentalId = rentalId;
        this.movieId = movieId;
        this.rentalDate = rentalDate;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RentalPOJO)) {
            return false;
        }
        RentalPOJO that = (RentalPOJO) o;
        return rentalId == that.rentalId && movieId == that.movieId && Objects.equals(rentalDate, that.rentalDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rentalId, movieId, rentalDate);
    }
}
