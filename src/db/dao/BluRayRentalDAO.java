package db.dao;

import db.pojo.BluRayRentalPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

public class BluRayRentalDAO extends DAO<BluRayRentalPOJO> {

    protected BluRayRentalDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public BluRayRentalPOJO read(int id) {
        BluRayRentalPOJO bluRayRentalPOJO = entityManager.find(BluRayRentalPOJO.class, id);
        if (bluRayRentalPOJO == null) {
            throw new EntityNotFoundException("Can't find blu-ray rental for ID " + id);
        }
        return bluRayRentalPOJO;
    }
}
