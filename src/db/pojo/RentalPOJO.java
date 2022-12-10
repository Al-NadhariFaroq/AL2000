package db.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity(name = "Rentals")
@Table(name = "RENTALS", schema = "ALNADHAF", catalog = "")
public class RentalPOJO {
    @Id
    @Column(name = "RENTAL_ID")
    private int rentalId;
    @JoinColumn(name="MOVIE_ID", referencedColumnName = "MOVIE_ID")
    @ManyToOne(optional = false)
    private MoviePOJO movie;
    @Basic
    @Column(name = "RENTAL_DATE")
    private Date rentalDate;

    @OneToMany(mappedBy="rental", cascade = CascadeType.ALL)
    private List<NonSubRentalPOJO> nonSubRentalPOJOList;

    @OneToMany(mappedBy="rental", cascade = CascadeType.ALL)
    private List<BluRayRentalPOJO> bluRayRentalPOJOList;

    @OneToMany(mappedBy="rental", cascade = CascadeType.ALL)
    private List<SubRentalPOJO> subRentalPOJOList;

    public RentalPOJO() {

    }


    public RentalPOJO(int rentalId,MoviePOJO movie, Date rentalDate) {
        this.rentalId = rentalId;
        this.movie = movie;
        this.rentalDate = rentalDate;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public MoviePOJO getMovie() {
        return movie;
    }
    public void setMovie(MoviePOJO movie) {
        this.movie = movie;
    }
    public List<NonSubRentalPOJO> getNonSubRentalPOJOList(){
        return nonSubRentalPOJOList;
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
        return rentalId == that.rentalId && movie.getMovieId() == that.movie.getMovieId() && Objects.equals(rentalDate, that.rentalDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rentalId, movie.getTitle(), rentalDate);
    }
}
