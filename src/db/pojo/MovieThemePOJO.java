package db.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "movies_themes")
@Table(name = "movies_themes", schema = "alnadhaf", catalog = "")
public class MovieThemePOJO implements POJO {
    @Id
    @Column(name = "movie_theme_id")
    private int movieThemeId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_id")
    private MoviePOJO movie;

    @ManyToOne(optional = false)
    @JoinColumn(name = "theme_id")
    private ThemePOJO theme;

    @Basic
    @Column(name = "theme_rank")
    private int themeRank;

    public MovieThemePOJO() {
        super();
    }

    public MovieThemePOJO(int movieThemeId, MoviePOJO movie, ThemePOJO theme, int themeRank) {
        super();
        this.movieThemeId = movieThemeId;
        this.movie = movie;
        this.theme = theme;
        this.themeRank = themeRank;
    }

    public int getID() {
        return movieThemeId;
    }

    public void setID(int movieThemeId) {
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
        return movieThemeId == that.movieThemeId && movie.getID() == that.movie.getID() &&
               theme.getID() == that.theme.getID() && themeRank == that.themeRank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieThemeId, movie.getID(), theme.getID(), themeRank);
    }
}
