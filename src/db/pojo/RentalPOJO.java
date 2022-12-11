package db.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity(name = "rentals")
@Table(name = "rentals", schema = "alnadhaf", catalog = "")
public class RentalPOJO implements POJO {
    @Id
    @Column(name = "rental_id")
    private int rentalId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    private MoviePOJO movie;

    @Basic(optional = false)
    @Column(name = "rental_date")
    private Date rentalDate;

    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
    private List<BluRayRentalPOJO> bluRayRentals;

    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
    private List<NonSubRentalPOJO> nonSubRentals;

    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
    private List<SubRentalPOJO> subRentals;

    public RentalPOJO() {
        super();
    }

    public RentalPOJO(int rentalId, MoviePOJO movie, Date rentalDate) {
        super();
        this.rentalId = rentalId;
        this.movie = movie;
        this.rentalDate = rentalDate;
    }

    public int getID() {
        return rentalId;
    }

    public void setID(int rentalId) {
        this.rentalId = rentalId;
    }

    public MoviePOJO getMovie() {
        return movie;
    }

    public void setMovie(MoviePOJO movie) {
        this.movie = movie;
    }

    public List<NonSubRentalPOJO> getNonSubRentals() {
        return nonSubRentals;
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
        return rentalId == that.rentalId && movie.getID() == that.movie.getID() &&
               Objects.equals(rentalDate, that.rentalDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rentalId, movie.getTitle(), rentalDate);
    }
}
