package db.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity(name = "movies")
@Table(name = "movies", schema = "rocd", catalog = "")
public class MoviePOJO implements POJO {
    @Id
    @Column(name = "movie_id")
    private int movieId;

    @Basic(optional = false)
    @Column(name = "title")
    private String title;

    @Basic(optional = false)
    @Column(name = "release_date")
    private Date releaseDate;

    @Basic(optional = false)
    @Column(name = "rating")
    private String rating;

    @Basic(optional = false)
    @Column(name = "running_time")
    private int runningTime;

    @Basic
    @Column(name = "synopsis")
    private String synopsis;

    @Basic(optional = false)
    @Column(name = "link_url")
    private String linkURL;

    @Basic
    @Column(name = "poster_url")
    private String posterURL;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @OrderBy("themeRank ASC")
    private List<MovieThemePOJO> movieThemes;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @OrderBy("directorRank ASC")
    private List<DirectorPOJO> directors;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @OrderBy("actorRank ASC")
    private List<ActorPOJO> actors;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<ScorePOJO> scores;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<RentalPOJO> rentals;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<BluRayPOJO> bluRays;

    public MoviePOJO() {
        super();
    }

    public MoviePOJO(int movieId,
                     String title,
                     Date releaseDate,
                     String rating,
                     int runningTime,
                     String synopsis,
                     String linkURL,
                     String posterURL
    ) {
        super();
        this.movieId = movieId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.runningTime = runningTime;
        this.synopsis = synopsis;
        this.linkURL = linkURL;
        this.posterURL = posterURL;
    }

    public int getID() {
        return movieId;
    }

    public void setID(int movieId) {
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

    public List<MovieThemePOJO> getMovieThemes() {
        return movieThemes;
    }

    public List<DirectorPOJO> getDirectors() {
        return directors;
    }

    public List<ActorPOJO> getActors() {
        return actors;
    }

    public List<BluRayPOJO> getBluRays() {
        return bluRays;
    }

    public List<RentalPOJO> getRentals() {
        return rentals;
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
