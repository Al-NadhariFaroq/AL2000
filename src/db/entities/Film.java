package db.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "FILMS", schema = "ALNADHAF", catalog = "")
public class Film {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "FILM_ID")
    private int filmId;
    @Basic
    @Column(name = "TITLE")
    private String title;
    @Basic
    @Column(name = "RELEASE_DATE")
    private Date releaseDate;
    @Basic
    @Column(name = "SYNOPSIS")
    private String synopsis;
    @Basic
    @Column(name = "RATING")
    private Byte rating;
    @Basic
    @Column(name = "AGE_LIMIT")
    private Byte ageLimit;

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Byte getRating() {
        return rating;
    }

    public void setRating(Byte rating) {
        this.rating = rating;
    }

    public Byte getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(Byte ageLimit) {
        this.ageLimit = ageLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Film that = (Film) o;
        return filmId == that.filmId && Objects.equals(title, that.title) && Objects.equals(releaseDate,
                                                                                            that.releaseDate
        ) && Objects.equals(synopsis, that.synopsis) && Objects.equals(rating, that.rating) && Objects.equals(ageLimit,
                                                                                                              that.ageLimit
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, title, releaseDate, synopsis, rating, ageLimit);
    }
}
