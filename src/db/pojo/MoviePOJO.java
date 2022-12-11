package db.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity(name = "Movies")
@Table(name = "MOVIES", schema = "ALNADHAF", catalog = "")
public class MoviePOJO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID")
    private int movieId;
    @Basic
    @Column(name = "TITLE")
    private String title;
    @Basic
    @Column(name = "RELEASE_DATE")
    private Date releaseDate;
    @Basic
    @Column(name = "RATING")
    private String rating;
    @Basic
    @Column(name = "RUNNING_TIME")
    private int runningTime;
    @Basic
    @Column(name = "SYNOPSIS")
    private String synopsis;
    @Basic
    @Column(name = "LINK_URL")
    private String linkURL;
    @Basic
    @Column(name = "POSTER_URL")
    private String posterURL;
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<RentalPOJO> rentalPOJOList;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<RolePOJO> rolePOJOList;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<BluRayPOJO> bluRayPOJOList;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<ScorePOJO> scorePOJOList;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<MovieThemePOJO> movieThemePOJOList;

    public MoviePOJO() {

    }

    public MoviePOJO(int movieId,
                     String title,
                     Date releaseDate,
                     String synopsis,
                     String rating,
                     String linkURL,
                     String posterURL
    ) {
        this.movieId = movieId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.runningTime = runningTime;
        this.synopsis = synopsis;
        this.linkURL = linkURL;
        this.posterURL = posterURL;
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
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

    public List<RentalPOJO> getRentalPOJOList() {
        return rentalPOJOList;
    }

    public List<BluRayPOJO> getBluRayPOJOList() {
        return bluRayPOJOList;
    }

    public List<RolePOJO> getRolePOJOList() {
        return rolePOJOList;
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
        return movieId == moviePOJO.movieId && runningTime == moviePOJO.runningTime &&
               Objects.equals(title, moviePOJO.title) && Objects.equals(releaseDate, moviePOJO.releaseDate) &&
               Objects.equals(rating, moviePOJO.rating) && Objects.equals(synopsis, moviePOJO.synopsis) &&
               Objects.equals(linkURL, moviePOJO.linkURL) && Objects.equals(posterURL, moviePOJO.posterURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, title, releaseDate, rating, runningTime, synopsis, linkURL, posterURL);
    }
}
