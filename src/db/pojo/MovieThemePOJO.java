package db.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "MOVIES_THEMES", schema = "ALNADHAF", catalog = "")
public class MovieThemePOJO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MOVIE_THEME_ID")
    private int movieThemeId;
    @Basic
    @Column(name = "MOVIE_ID")
    private int movieId;
    @Basic
    @Column(name = "Theme_ID")
    private int themeId;
    @Basic
    @Column(name = "THEME_RANK")
    private int themeRank;

    public MovieThemePOJO() {

    }

    public MovieThemePOJO(int movieId, int themeId, int themeRank) {
        this.movieId = movieId;
        this.themeId = themeId;
        this.themeRank = themeRank;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    public int getThemeRank() {
        return themeRank;
    }

    public void setThemeRank(int themeRank) {
        this.themeRank = themeRank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MovieThemePOJO)) {
            return false;
        }
        MovieThemePOJO that = (MovieThemePOJO) o;
        return movieThemeId == that.movieThemeId && movieId == that.movieId && themeId == that.themeId &&
               themeRank == that.themeRank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieThemeId, movieId, themeId, themeRank);
    }
}