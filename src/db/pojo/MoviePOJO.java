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
    @Basic
    @Column(name = "LINK_URL")
    private String linkURL;
    @Basic
    @Column(name = "POSTER_URL")
    private String posterURL;

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

    public String getLinkURL() {
        return linkURL;
    }

    public void setLinkURL(String linkURL) {
        this.linkURL = linkURL;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MoviePOJO)) {
            return false;
        }
        MoviePOJO moviePOJO = (MoviePOJO) o;
        return movieId == moviePOJO.movieId && Objects.equals(title, moviePOJO.title) &&
               Objects.equals(releaseDate, moviePOJO.releaseDate) && Objects.equals(synopsis, moviePOJO.synopsis) &&
               Objects.equals(rating, moviePOJO.rating) && Objects.equals(linkURL, moviePOJO.linkURL) &&
               Objects.equals(posterURL, moviePOJO.posterURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, title, releaseDate, synopsis, rating, linkURL, posterURL);
    }
}
