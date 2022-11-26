package db.dao;

import db.pojo.RestrictionPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

public class RestrictionDAO extends DAO<RestrictionPOJO> {

    protected RestrictionDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public RestrictionPOJO read(int id) {
        RestrictionPOJO restrictionPOJO = entityManager.find(RestrictionPOJO.class, id);
        if (restrictionPOJO == null) {
            throw new EntityNotFoundException("Can't find restriction for ID " + id);
        }
        return restrictionPOJO;
    }
}

