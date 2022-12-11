package db.dao;

import db.pojo.SubRentalPOJO;

public class SubRentalDAO extends DAO<SubRentalPOJO> {
    private static SubRentalDAO instance;

    private SubRentalDAO() {
        super(SubRentalPOJO.class);
    }

    public static SubRentalDAO getInstance() {
        if (instance == null) {
            instance = new SubRentalDAO();
        }
        return instance;
    }
}
