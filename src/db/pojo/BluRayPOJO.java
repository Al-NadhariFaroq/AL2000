package db.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BLU_RAYS", schema = "ALNADHAF", catalog = "")
public class BluRayPOJO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "BLU_RAY_ID")
    private int bluRayId;
    @Basic
    @Column(name = "SERIAL_NUMBER")
    private int serialNumber;
    @Basic
    @Column(name = "MOVIE_ID")
    private int movieId;
    @Basic
    @Column(name = "POSITION")
    private int position;

    public BluRayPOJO() {

    }

    public BluRayPOJO(int serialNumber, int movieId, int position) {
        this.serialNumber = serialNumber;
        this.movieId = movieId;
        this.position = position;
    }

    public int getBluRayId() {
        return bluRayId;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
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
        return bluRayId == that.bluRayId && serialNumber == that.serialNumber && movieId == that.movieId &&
               position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bluRayId, serialNumber, movieId, position);
    }
}
