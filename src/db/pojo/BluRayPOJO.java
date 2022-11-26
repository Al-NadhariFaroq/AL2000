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
    private long serialNumber;
    @Basic
    @Column(name = "BLU_RAY_POSITION")
    private Byte bluRayPosition;
    @Basic
    @Column(name = "MOVIE_ID")
    private int movieId;

    public int getBluRayId() {
        return bluRayId;
    }

    public void setBluRayId(int bluRayId) {
        this.bluRayId = bluRayId;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Byte getBluRayPosition() {
        return bluRayPosition;
    }

    public void setBluRayPosition(Byte bluRayPosition) {
        this.bluRayPosition = bluRayPosition;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BluRayPOJO that = (BluRayPOJO) o;
        return bluRayId == that.bluRayId && serialNumber == that.serialNumber && movieId == that.movieId && Objects.equals(
                bluRayPosition, that.bluRayPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bluRayId, serialNumber, bluRayPosition, movieId);
    }
}
