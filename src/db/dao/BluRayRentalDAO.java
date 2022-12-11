package db.dao;

import db.pojo.BluRayRentalPOJO;

public class BluRayRentalDAO extends DAO<BluRayRentalPOJO> {
    private static BluRayRentalDAO instance;

    private BluRayRentalDAO() {
        super(BluRayRentalPOJO.class);
    }

    public static BluRayRentalDAO getInstance() {
        if (instance == null) {
            instance = new BluRayRentalDAO();
        }
        return instance;
    }
}
