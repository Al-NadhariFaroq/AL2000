package db.dao;

import db.pojo.PreferencePOJO;

public class PreferenceDAO extends DAO<PreferencePOJO> {
    private static PreferenceDAO instance;

    private PreferenceDAO() {
        super(PreferencePOJO.class);
    }

    public static PreferenceDAO getInstance() {
        if (instance == null) {
            instance = new PreferenceDAO();
        }
        return instance;
    }
}

