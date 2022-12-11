package db.dao;

import db.pojo.NonSubRentalPOJO;
import db.pojo.RentalPOJO;

public class NonSubRentalDAO extends DAO<NonSubRentalPOJO> {
    protected static NonSubRentalDAO instance;

    private NonSubRentalDAO() {
        super(NonSubRentalPOJO.class);
    }

    public static NonSubRentalDAO getInstance() {
        if (instance == null) {
            instance = new NonSubRentalDAO();
        }
        return instance;
    }

    @Override
    public void delete(NonSubRentalPOJO nonSubRentalPOJO) {
        RentalPOJO rentalPOJO = DAOFactory.getRentalDAO().read(nonSubRentalPOJO.getRental().getRentalId());
        if (!rentalPOJO.getNonSubRentalPOJOList().isEmpty()) {
            rentalPOJO.getNonSubRentalPOJOList().remove(nonSubRentalPOJO);
            entityManager.merge(rentalPOJO);
        }
        executeInsideTransaction(entityManager -> entityManager.remove(nonSubRentalPOJO));
    }
}
