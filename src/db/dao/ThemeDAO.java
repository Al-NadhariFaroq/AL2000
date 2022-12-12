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

    public ThemePOJO readFromName(String name) {
        String query = "SELECT T FROM themes T WHERE T.name = :name";
        return entityManager.createQuery(query, ThemePOJO.class).setParameter("name", name).getSingleResult();
    }
}
