package db.pojo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "Blu_Rays")
@Table(name = "BLU_RAYS", schema = "ALNADHAF", catalog = "")
public class BluRayPOJO {
    @Id
    @Column(name = "BLU_RAY_ID")
    private int bluRayId;
    @Basic
    @Column(name = "SERIAL_NUMBER")
    private int serialNumber;
    @JoinColumn(name="MOVIE_ID", referencedColumnName = "MOVIE_ID")
    @ManyToOne(optional = false)
    private MoviePOJO movie;
    @Basic
    @Column(name = "POSITION")
    private int position;

    @OneToMany(mappedBy="bluRay", cascade = CascadeType.ALL)
    private List<BluRayRentalPOJO> bluRayRentalPOJOList;

    public BluRayPOJO() {

    }

    public BluRayPOJO(int bluRayId,int serialNumber, MoviePOJO movie, int position) {
        this.bluRayId = bluRayId;
        this.serialNumber = serialNumber;
        this.movie = movie;
        this.position = position;
    }

    public int getBluRayId() {
        return bluRayId;
    }

    public void setBluRayId(int bluRayId) {
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
