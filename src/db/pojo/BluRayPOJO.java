package db.pojo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "blu_rays")
@Table(name = "blu_rays", schema = "rocd", catalog = "")
public class BluRayPOJO implements POJO {
    @Id
    @Column(name = "blu_ray_id")
    private int bluRayId;

    @Basic(optional = false)
    @Column(name = "serial_number")
    private int serialNumber;

    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    private MoviePOJO movie;

    @Basic
    @Column(name = "position")
    private int position;

    @OneToMany(mappedBy = "bluRay", cascade = CascadeType.ALL)
    private List<BluRayRentalPOJO> bluRayRentalPOJOList;

    public BluRayPOJO() {
        super();
    }

    public BluRayPOJO(int bluRayId, int serialNumber, MoviePOJO movie, int position) {
        super();
        this.bluRayId = bluRayId;
        this.serialNumber = serialNumber;
        this.movie = movie;
        this.position = position;
    }

    public int getID() {
        return bluRayId;
    }

    public void setID(int bluRayId) {
        this.bluRayId = bluRayId;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public MoviePOJO getMovie() {
        return movie;
    }

    public void setMovie(MoviePOJO movie) {
        this.movie = movie;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int bluRayPosition) {
        this.position = bluRayPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BluRayPOJO)) {
            return false;
        }
        BluRayPOJO that = (BluRayPOJO) o;
        return bluRayId == that.bluRayId && serialNumber == that.serialNumber && movie == that.movie &&
               position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bluRayId, serialNumber, movie.getTitle(), position);
    }
}
