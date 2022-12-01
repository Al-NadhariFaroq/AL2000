package db.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "MOVIES", schema = "ALNADHAF", catalog = "")
public class MoviePOJO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MOVIE_ID")
    private int movieId;
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
    private String rating;

    public MoviePOJO() {
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MoviePOJO movie = (MoviePOJO) o;
        return movie.movieId == movieId && movie.title.equals(title) && movie.releaseDate.equals(releaseDate) &&
               movie.synopsis.equals(synopsis) && movie.rating.equals(rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, title, releaseDate, synopsis, rating);
    }
}
