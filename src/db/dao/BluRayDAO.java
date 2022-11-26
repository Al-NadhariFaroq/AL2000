package db.dao;

import db.pojo.BluRayPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

public class BluRayDAO extends DAO<BluRayPOJO> {

    protected BluRayDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public BluRayPOJO read(int id) {
        BluRayPOJO bluRayPOJO = entityManager.find(BluRayPOJO.class, id);
        if (bluRayPOJO == null) {
            throw new EntityNotFoundException("Can't find blu-ray for ID " + id);
        }
        return bluRayPOJO;
    }
}
