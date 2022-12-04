package db.dao;

import db.pojo.SubRentalPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

public class SubRentalDAO extends DAO<SubRentalPOJO> {

    protected SubRentalDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public SubRentalPOJO read(int id) {
        SubRentalPOJO subRentalPOJO = entityManager.find(SubRentalPOJO.class, id);
        if (subRentalPOJO == null) {
            throw new EntityNotFoundException("Can't find subscriber rental for ID " + id);
        }
        return subRentalPOJO;
    }
}
