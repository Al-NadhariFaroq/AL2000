package db.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Movies_Themes")
@Table(name = "MOVIES_THEMES", schema = "ALNADHAF", catalog = "")
public class MovieThemePOJO {
    @Id
    @Column(name = "MOVIE_THEME_ID")
    private int movieThemeId;
    @ManyToOne
    @JoinColumn(name = "MOVIE_ID")
    private MoviePOJO movie;
    @ManyToOne
    @JoinColumn(name = "Theme_ID")
    private ThemePOJO theme;
    @Basic
    @Column(name = "THEME_RANK")
    private int themeRank;

    public MovieThemePOJO() {

    }

    public MovieThemePOJO(int movieThemeId,MoviePOJO movie, ThemePOJO theme, int themeRank) {
        this.movieThemeId = movieThemeId;
        this.movie = movie;
        this.theme = theme;
        this.themeRank = themeRank;
    }

    public int getMovieThemeId() {
        return movieThemeId;
    }

    public void setMovieThemeId(int movieThemeId) {
        this.movieThemeId = movieThemeId;
    }

    public MoviePOJO getMovie() {
        return movie;
    }

    public void setMovie(MoviePOJO movie) {
        this.movie = movie;
    }

    public ThemePOJO getTheme() {
        return theme;
    }

    public void setTheme(ThemePOJO theme) {
        this.theme = theme;
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
        return movieThemeId == that.movieThemeId && movie.getMovieId() == that.movie.getMovieId() && theme.getThemeId() == that.theme.getThemeId() &&
               themeRank == that.themeRank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieThemeId, movie.getMovieId(), theme.getThemeId(), themeRank);
    }
}
