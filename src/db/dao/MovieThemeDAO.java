package db.dao;

import db.pojo.MovieThemePOJO;

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
}
