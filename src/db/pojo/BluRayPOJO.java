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
    @Column(name = "BLU_RAY_POSITION")
    private int bluRayPosition;

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

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getBluRayPosition() {
        return bluRayPosition;
    }

    public void setBluRayPosition(int bluRayPosition) {
        this.bluRayPosition = bluRayPosition;
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
               bluRayPosition == that.bluRayPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bluRayId, serialNumber, bluRayPosition, movieId);
    }
}
