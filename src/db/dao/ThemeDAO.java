package db.dao;

import db.pojo.ThemePOJO;

public class ThemeDAO extends DAO<ThemePOJO> {
    private static ThemeDAO instance;

    private ThemeDAO() {
        super(ThemePOJO.class);
    }

    public static ThemeDAO getInstance() {
        if (instance == null) {
            instance = new ThemeDAO();
        }
        return instance;
    }
}
