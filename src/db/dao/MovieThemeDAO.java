package db.dao;

import db.pojo.MovieThemePOJO;
import db.pojo.ThemePOJO;

import java.util.ArrayList;
import java.util.List;

public class MovieThemeDAO extends DAO<MovieThemePOJO> {
    private static MovieThemeDAO instance;

    private MovieThemeDAO() {
        super(MovieThemePOJO.class);
    }

    public static MovieThemeDAO getInstance() {
        if (instance == null) {
            instance = new MovieThemeDAO();
        }
        return instance;
    }

    public List<ThemePOJO> readFromMovieId(int movieId) {
        List<ThemePOJO> themesPOJO = new ArrayList<>();
        // TODO find all themes from a movie ID order by theme_rank
        return themesPOJO;
    }
}
