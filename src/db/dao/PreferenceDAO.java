package db.dao;

import db.pojo.PreferencePOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

public class PreferenceDAO extends DAO<PreferencePOJO> {

    protected PreferenceDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public PreferencePOJO read(int id) {
        PreferencePOJO preferencePOJO = entityManager.find(PreferencePOJO.class, id);
        if (preferencePOJO == null) {
            throw new EntityNotFoundException("Can't find restriction for ID " + id);
        }
        return preferencePOJO;
    }
}

