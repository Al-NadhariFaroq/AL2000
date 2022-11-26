package db.dao;

import db.pojo.SubscriberPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

public class SubscriberDAO extends DAO<SubscriberPOJO> {

    protected SubscriberDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public SubscriberPOJO read(int id) {
        SubscriberPOJO subscriberPOJO = entityManager.find(SubscriberPOJO.class, id);
        if (subscriberPOJO == null) {
            throw new EntityNotFoundException("Can't find subscriber for ID " + id);
        }
        return subscriberPOJO;
    }
}
